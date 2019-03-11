package com.activiti.task;

import com.service.InvolvedTaskService;
import com.service.UserService;
import com.utils.ActivitiUtils;
import com.utils.SpringContextHolder;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerByCaseUserImpl implements TaskListener {

    private InvolvedTaskService involvedTaskService = SpringContextHolder.getBean(InvolvedTaskService.class);

    private UserService userService = SpringContextHolder.getBean(UserService.class);

    /**
     * 指定业务申请人
     * @param delegateTask
     */
    @Override
    public void  notify(DelegateTask delegateTask)
    {
        //获取流程实例ID
        String processInstanceId = delegateTask.getProcessInstanceId();
        //根据流程变量的caseUser查找到任务的办理人的身份证号
        String identityCard = ActivitiUtils.getVariableByTaskId(delegateTask.getId(),"caseUser").toString();

        delegateTask.setAssignee(identityCard);
    }
}
