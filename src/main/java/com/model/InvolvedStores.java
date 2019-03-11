package com.model;

import java.util.Date;

/**
 * 仓库表ea_involved_stores
 *
 * @author OnJuly
 */
public class InvolvedStores {

    private String id;                                    //仓库ID
    private String name;                                    //仓库名称
    private String location;                                //仓库地址
    private String deptId;                                //仓库所属机构号
    private String userId;                                //仓库保管员
    private String remark;                                //备注
    private String createUserId;                        //创建人员
    private Date createTime;                                //创建时间
    private Date editTime;                                //修改时间
    private Integer sortCode;                            //排序号

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    @Override
    public String toString() {
        return "InvolvedStores{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", deptId='" + deptId + '\'' +
                ", userId='" + userId + '\'' +
                ", remark='" + remark + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createTime=" + createTime +
                ", editTime=" + editTime +
                ", sortCode=" + sortCode +
                '}';
    }
}
