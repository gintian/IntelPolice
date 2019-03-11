package com.activiti.service;

import com.activiti.bean.WorkflowBean;
import com.model.InvolvedTask;
import com.model.bean.InvolvedBean;
import com.model.bean.InvolvedTaskBean;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import java.util.List;

public interface InvolvedActivitiService {
    //启动保管流程实例
    ProcessInstance startApproveProcess(String involvedId, String identityCard);

    //启动处置流程实例
    ProcessInstance startDisposeProcess(String involvedId, String identityCard);

    //使用任务，查找财物ID，从而获取财物信息*/
    InvolvedBean findInvolvedByTask(String taskId);

    //使用历史任务，查找财物ID，从而获取财物信息*/
    InvolvedBean findInvolvedByHistoryTask(String taskId);

    //使用任务ID指定连线的名称完成任务
    void saveSubmitByTaskId(String taskId, String outcome, String remark);
}
