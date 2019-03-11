package com.model.bean;

import com.model.CJ;
import com.model.JJ;

public class CJBean extends CJ {
    private JJBean jJBean;

    private String atime;//时间比

    private String caseType;//案件类型

    private Double atimeDouble;//时间比转换

    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public Double getAtimeDouble() {
        return atimeDouble;
    }

    public void setAtimeDouble(Double atimeDouble) {
        this.atimeDouble = atimeDouble;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        if(atime != null){
            this.atimeDouble =Double.parseDouble(atime);
        }
        this.atime = atime;
    }

    public JJBean getJJBean() {
        return jJBean;
    }

    public void setJJBean(JJBean jJBean) {
        this.jJBean = jJBean;
    }
}
