package com.model;

import java.util.Date;

/**
 * 涉案财物工作流任务表ea_involved_task
 */
public class InvolvedTask {
    private String id;                                   //任务编号
    private String involvedId;                            //涉案财物编号
    private String procInstId;                                //任务实例ID
    private String taskContent;                        //任务内容
    private String remark;                             //备注
    private Date taskDate;                             //任务开始时间
    private Date taskEndDate;                          //任务结束时间
    private String taskState;                          //任务状态0为开始，1为结束
    private String identityCard;                       //任务发起人身份证号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getInvolvedId() {
        return involvedId;
    }

    public void setInvolvedId(String involvedId) {
        this.involvedId = involvedId;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }
}
