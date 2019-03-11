package com.model;

import java.util.Date;
/**
 * 涉案财物类别ea_involved_types
 */
public class InvolvedTypes {
    private String id;

    private String name;

    private String code;

    private String sortcode;

    private String parentid;

    private String remark;

    private Date createtime;

    private String userid;

    private String isinvolved;

    private String state;

    private Long maxmoney;

    private String issuperexamine;

    private String isprocessdirect;

    private String keepunit;

    private String isprocessbykeepunit;

    private String isappointkeepunit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode == null ? null : sortcode.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getIsinvolved() {
        return isinvolved;
    }

    public void setIsinvolved(String isinvolved) {
        this.isinvolved = isinvolved == null ? null : isinvolved.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(Long maxmoney) {
        this.maxmoney = maxmoney;
    }

    public String getIssuperexamine() {
        return issuperexamine;
    }

    public void setIssuperexamine(String issuperexamine) {
        this.issuperexamine = issuperexamine == null ? null : issuperexamine.trim();
    }

    public String getIsprocessdirect() {
        return isprocessdirect;
    }

    public void setIsprocessdirect(String isprocessdirect) {
        this.isprocessdirect = isprocessdirect == null ? null : isprocessdirect.trim();
    }

    public String getKeepunit() {
        return keepunit;
    }

    public void setKeepunit(String keepunit) {
        this.keepunit = keepunit == null ? null : keepunit.trim();
    }

    public String getIsprocessbykeepunit() {
        return isprocessbykeepunit;
    }

    public void setIsprocessbykeepunit(String isprocessbykeepunit) {
        this.isprocessbykeepunit = isprocessbykeepunit == null ? null : isprocessbykeepunit.trim();
    }

    public String getIsappointkeepunit() {
        return isappointkeepunit;
    }

    public void setIsappointkeepunit(String isappointkeepunit) {
        this.isappointkeepunit = isappointkeepunit == null ? null : isappointkeepunit.trim();
    }
}