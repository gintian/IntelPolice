package com.model;

public class Dept {
    private String id;

    private String name;

    private String parentId;

    private String customId;

    private String status;

    private String sortNo;

    private String leaf;

    private String remark;

    private String isCaseUnit;

    private String longName;

    private String shortName;

    private String address;

    private String phone;

    private String zjId;

    private String zhId;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getIsCaseUnit() {
        return isCaseUnit;
    }

    public void setIsCaseUnit(String isCaseUnit) {
        this.isCaseUnit = isCaseUnit;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZjId() {
        return zjId;
    }

    public void setZjId(String zjId) {
        this.zjId = zjId;
    }

    public String getZhId() {
        return zhId;
    }

    public void setZhId(String zhId) {
        this.zhId = zhId;
    }
}