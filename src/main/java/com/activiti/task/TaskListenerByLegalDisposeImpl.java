package com.activiti.task;

import com.exception.WebMessageException;
import com.model.bean.DeptBean;
import com.model.bean.InvolvedTaskBean;
import com.model.bean.RoleBean;
import com.model.bean.UserBean;
import com.service.InvolvedTaskService;
import com.service.RoleService;
import com.service.UserService;
import com.utils.ActivitiUtils;
import com.utils.SpringContextHolder;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.ArrayList;
import java.util.List;

public class TaskListenerByLegalDisposeImpl implements TaskListener {
    private InvolvedTaskService involvedTaskService = SpringContextHolder.getBean(InvolvedTaskService.class);

    private UserService userService = SpringContextHolder.getBean(UserService.class);

    private RoleService roleService = SpringContextHolder.getBean(RoleService.class);

    /**
     * 指定法制处置审批任务办理人
     * @param delegateTask
     */
    @Override
    public void  notify(DelegateTask delegateTask)
    {
        //权限的key值
        String roleKey="legalDispose";
        //获取流程实例ID
        String processInstanceId = delegateTask.getProcessInstanceId();
        //根据流程实例ID在任务的SERVICE查找到任务的办理人
        InvolvedTaskBean involvedTaskBean = new InvolvedTaskBean();
        //任务办理人
        UserBean userBean = new UserBean();
        DeptBean deptBean = new DeptBean();
        RoleBean roleBean = new RoleBean();
        //法制审批人列表
        List<UserBean> listUserBean = new ArrayList<UserBean>();
        try {
            //根据流程变量的caseUser查找到任务的办理人的身份证号
            String identityCard = ActivitiUtils.getVariableByTaskId(delegateTask.getId(),"caseUser").toString();
            //根据任务信息身份证号查找任务办理人
            userBean = userService.findUserByIdentityCard(identityCard);
            //根据任务办理人机构的信息查找到权限ROLE的id
            roleBean = roleService.findRoleByDeptAndRolekey(userBean.getDeptId(),roleKey);
            //根据任务办理人机构查找到当前机构的法制审批人列表
            listUserBean = userService.findUsersByRole(roleBean.getId());
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        if(listUserBean.size()>0)
        {
            String assignee="";
            for(UserBean usbean :listUserBean)
            {
                String userIdentityCard = usbean.getIdentityCard();
                if(userIdentityCard!=null||userIdentityCard!="") {
                    if (assignee.length() == 0 || assignee == null || assignee == "") {
                        assignee = userIdentityCard;
                    } else {
                        assignee += "," + usbean.getIdentityCard();
                    }
                }
            }

            delegateTask.setAssignee(assignee);
        }
    }
}
