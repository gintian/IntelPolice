package com.model;

import java.util.Date;

public class ArchiveStoresBoxLog {
    private String id;

   private String caseId;//案件ID

   private  String  achiveId;//卷宗ID

    private String boxId;//箱子ID

    private Date logTime;//存取时间

    private String stuts;//0存1取2移交

    private String operationUser;//操作者ID

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getAchiveId() {
        return achiveId;
    }

    public void setAchiveId(String achiveId) {
        this.achiveId = achiveId;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getStuts() {
        return stuts;
    }

    public void setStuts(String stuts) {
        this.stuts = stuts;
    }
}