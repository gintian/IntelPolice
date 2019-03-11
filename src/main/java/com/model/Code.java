package com.model;

import java.math.BigDecimal;

public class Code {
    private String id;

    private String field;

    private String fieldname;

    private String code;

    private String codedesc;

    private String enabled;

    private String editmode;

    private BigDecimal sortno;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodedesc() {
        return codedesc;
    }

    public void setCodedesc(String codedesc) {
        this.codedesc = codedesc;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEditmode() {
        return editmode;
    }

    public void setEditmode(String editmode) {
        this.editmode = editmode;
    }

    public BigDecimal getSortno() {
        return sortno;
    }

    public void setSortno(BigDecimal sortno) {
        this.sortno = sortno;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}