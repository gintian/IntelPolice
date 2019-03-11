package com.model;

import java.util.Date;

public class InvestigationKeywords {
    private String keywordsId;

    private String keywords;

    private String type;

    private String remark;

    private String userId;

    private Date addTime;

    private String isDelete;

    public String getKeywordsId() {
        return keywordsId;
    }

    public void setKeywordsId(String keywordsId) {
        this.keywordsId = keywordsId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}