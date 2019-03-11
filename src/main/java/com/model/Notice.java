package com.model;

import java.util.Date;

public class Notice {
    // 公告id id
    private String id;
    // 公告标题 title
    private String title;
    // 公告内容 content
    private String content;
    // 显示状态 status
    private String status;
    // 创建者ID userId
    private String userId;
    // 创建者 userName
    private String userName;
    // 创建者单位名 unitname
    private String unitName;
    // 创建者单位代码 unitCode
    private String unitCode;
    // 创建时间 createTime
    private Date createTime;
    //业务类型
    private String businessType;
    private String gxfw;

    public String getGxfw() {
        return gxfw;
    }

    public void setGxfw(String gxfw) {
        this.gxfw = gxfw;
    }

    public Notice() {
        super();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Notice(String id, String title, String content, String status, String userName, String unitName, String unitCode, Date createTime, String userId, String businessType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.userName = userName;
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.createTime = createTime;
        this.userId = userId;
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", userName='" + userName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", createTime=" + createTime +
                ", userId='" + userId + '\'' +
                ", businessType='" + businessType + '\'' +
                '}';
    }
}
