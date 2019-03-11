package com.model;

import java.util.Date;

public class InvestigationExpInform {
    private String informId;

    private String exceptionId;

    private Date informTime;

    private String fromUerId;

    private String fromUserName;

    private String informInfo;

    private String toUserId;

    private String toUserName;

    private String isCancel;

    private Date cancelTime;

    private String type;

    private String state;

    public String getInformId() {
        return informId;
    }

    public void setInformId(String informId) {
        this.informId = informId;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public Date getInformTime() {
        return informTime;
    }

    public void setInformTime(Date informTime) {
        this.informTime = informTime;
    }

    public String getFromUerId() {
        return fromUerId;
    }

    public void setFromUerId(String fromUerId) {
        this.fromUerId = fromUerId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getInformInfo() {
        return informInfo;
    }

    public void setInformInfo(String informInfo) {
        this.informInfo = informInfo;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}