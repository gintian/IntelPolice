package com.model;

import java.util.Date;

/**
 * 类名称：留言
 */
public class Feedback {
    // 留言id id
    private String id;
    // 留言标题 title
    private String title;
    // 留言内容 content
    private String content;
    // 操作人id createuserid
    private String createUserId;
    // 操作人姓名 createusername
    private String createUserName;
    // 联系电话 telephone
    private String telephone;
    // 地址 address
    private String address;
    // 状态 status
    private String status;
    // 浏览次数 looktimes
    private String lookTimes;
    // 操作次数 processtimes
    private String processTimes;
    // 操作时间 createTime
    private Date createTime;
    // 业务类型 businesstype
    private String businessType;

    public Feedback() {
        super();
    }

    public Feedback(String id, String title, String content, String createUserName, String telephone, String address, String status, String lookTimes, String processTimes, Date createTime, String businessType, String createUserId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createUserName = createUserName;
        this.telephone = telephone;
        this.address = address;
        this.status = status;
        this.lookTimes = lookTimes;
        this.processTimes = processTimes;
        this.createTime = createTime;
        this.businessType = businessType;
        this.createUserId = createUserId;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLookTimes() {
        return lookTimes;
    }

    public void setLookTimes(String lookTimes) {
        this.lookTimes = lookTimes;
    }

    public String getProcessTimes() {
        return processTimes;
    }

    public void setProcessTimes(String processTimes) {
        this.processTimes = processTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Override
    public String toString() {
        return "Feedback [id=" + id + ", title=" + title + ", content=" + content + ", createUserName=" + createUserName
                + ", telephone=" + telephone + ", address=" + address + ", status=" + status + ", lookTimes="
                + lookTimes + ", processTimes=" + processTimes + ", createTime=" + createTime + ", businessType="
                + businessType + ", createUserId=" + createUserId + "]";
    }

}