package com.model;

public class ViewOrg {

    int id;
    char orgCode;
    long orgName;
    int parentId;

    public ViewOrg() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(char orgCode) {
        this.orgCode = orgCode;
    }

    public long getOrgName() {
        return orgName;
    }

    public void setOrgName(long orgName) {
        this.orgName = orgName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "ViewOrg{" +
                "id=" + id +
                ", orgCode=" + orgCode +
                ", orgName=" + orgName +
                ", parentId=" + parentId +
                '}';
    }
}
