package com.activiti.service.impl;

import com.activiti.bean.WorkflowBean;
import com.activiti.service.InvolvedActivitiService;
import com.exception.WebMessageException;
import com.model.InvolvedTask;
import com.model.bean.InvolvedBean;
import com.model.bean.InvolvedTaskBean;
import com.service.InvolvedService;
import com.service.InvolvedTaskService;
import com.service.mapper.InvolvedTaskBeanMapper;
import com.utils.ActivitiUtils;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("involvedActivitiService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedActivitiServiceImpl implements InvolvedActivitiService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private FormService formService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private InvolvedService involvedService;
    @Autowired
    private InvolvedTaskService involvedTaskService;

    /**
     * 启动保管工作流
     *
     * @param involvedId
     */
    @Override
    public ProcessInstance startApproveProcess(String involvedId, String identityCard) {
        //1：使用财务ID
        String id = involvedId;
        //2：流程定义的key
        String key = "InvolvedApprove";
        /**
         * caseUser是流程变量的名称，
         * 办理人是流程变量的值
         */
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("caseUser", identityCard);//身份证号来表示惟一用户
        /**
         * 4：	(1)使用流程变量设置字符串（格式：LeaveBill.id的形式），通过设置，让启动的流程（流程实例）关联业务
         (2)使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
         */
        //格式：LeaveBill.id的形式（使用流程变量）
        String objId = key + "." + id;
        variables.put("objId", objId);
        //6：使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
        return runtimeService.startProcessInstanceByKey(key, objId, variables);
    }

    /**
     * 启动处置工作流
     *
     * @param involvedId
     */
    @Override
    public ProcessInstance startDisposeProcess(String involvedId, String identityCard) {
        //1：使用财务ID
        String id = involvedId;
        //2：流程定义的key
        String key = "InvolvedDispose";
        /**
         * caseUser是流程变量的名称，
         * 办理人是流程变量的值
         */
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("caseUser", identityCard);//身份证号来表示惟一用户
        /**
         * 4：	(1)使用流程变量设置字符串（格式：LeaveBill.id的形式），通过设置，让启动的流程（流程实例）关联业务
         (2)使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
         */
        //格式：LeaveBill.id的形式（使用流程变量）
        String objId = key + "." + id;
        variables.put("objId", objId);
        //6：使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
        return runtimeService.startProcessInstanceByKey(key, objId, variables);
    }

    /**
     * 使用任务，查找财物ID，从而获取财物信息
     *
     * @param taskId
     * @return
     */
    @Override
    public InvolvedBean findInvolvedByTask(String taskId) {
        //1：使用任务ID，查询任务对象Task
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //2：使用任务对象Task获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        //4：使用流程实例对象获取BUSINESS_KEY
        String buniness_key = pi.getBusinessKey();
        //5：获取BUSINESS_KEY对应的主键ID，使用主键ID，查询请假单对象（InvolvedApprove.1）
        String id = "";
        if (StringUtils.isNotBlank(buniness_key)) {
            //截取字符串，取buniness_key小数点的第2个值
            id = buniness_key.split("\\.")[1];
        }
        //查询请假单对象
        InvolvedBean involvedBean = new InvolvedBean();
        try {
            involvedBean = involvedService.findInvolvedById(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return involvedBean;
    }

    /**
     * 使用历史任务，查找财物ID，从而获取财物信息
     *
     * @param taskId
     * @return
     */
    @Override
    public InvolvedBean findInvolvedByHistoryTask(String taskId) {
        //1：使用任务ID，查询任务对象Task
        HistoricTaskInstance task = historyService.createHistoricTaskInstanceQuery()
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //2：使用任务对象Task获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        HistoricProcessInstance pi = historyService.createHistoricProcessInstanceQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        //4：使用流程实例对象获取BUSINESS_KEY
        String buniness_key = pi.getBusinessKey();
        //5：获取BUSINESS_KEY对应的主键ID，使用主键ID，查询请假单对象（InvolvedApprove.1）
        String id = "";
        if (StringUtils.isNotBlank(buniness_key)) {
            //截取字符串，取buniness_key小数点的第2个值
            id = buniness_key.split("\\.")[1];
        }
        //查询请假单对象
        InvolvedBean involvedBean = new InvolvedBean();
        try {
            involvedBean = involvedService.findInvolvedById(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return involvedBean;
    }

    /**
     * 指定连线的名称完成任务
     *
     * @param outcome          下一个任务连线的名称，如果只有一个连线，那就直接传null
     * @param remark           任务批注
     */
    @Override
    public void saveSubmitByTaskId(String taskId, String outcome, String remark) {
         // 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
        //使用任务ID，查询任务对象，获取流程流程实例ID
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //根据流程实例添加批注

        taskService.addComment(taskId, processInstanceId, remark);

        /**
         * 2：如果连线的名称是“默认提交”，那么就不需要设置，如果不是，就需要设置流程变量
         * 在完成任务之前，设置流程变量，按照连线的名称，去完成任务
         流程变量的名称：outcome
         流程变量的值：连线的名称
         */
        Map<String, Object> variables = new HashMap<String, Object>();
        //3：使用任务ID，完成当前人的个人任务，同时流程变量
        variables.put("outcome",outcome);
        taskService.complete(taskId, variables);
        //4:判断任务是否完成，完成了就添加任务完成时间
//        if(ActivitiUtils.isProcessEnd(processInstanceId))
//        {
//            Date date = new Date();
//            involvedTaskBean.setTaskEndDate(date);
//        }
        //更新任务
    }
}
