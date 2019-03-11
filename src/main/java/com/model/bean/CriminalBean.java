package com.model.bean;

import com.model.Criminal;
import com.model.SmsLog;

import java.util.List;

public class CriminalBean extends Criminal {
    private String codedesc;

    private String processPersonName;//办案人员

    private List<ArchiveBean> archiveBeanList;//卷宗信息

    private List<InvolvedBean> involvedBeanList;//财物信息

    private SmsLogBean smsLogBean;

    public SmsLogBean getSmsLogBean() {
        return smsLogBean;
    }

    public void setSmsLogBean(SmsLogBean smsLogBean) {
        this.smsLogBean = smsLogBean;
    }

    public List<InvolvedBean> getInvolvedBeanList() {
        return involvedBeanList;
    }

    public void setInvolvedBeanList(List<InvolvedBean> involvedBeanList) {
        this.involvedBeanList = involvedBeanList;
    }

    public List<ArchiveBean> getArchiveBeanList() {
        return archiveBeanList;
    }

    public void setArchiveBeanList(List<ArchiveBean> archiveBeanList) {
        this.archiveBeanList = archiveBeanList;
    }

    public String getCodedesc() {
        return codedesc;
    }

    public void setCodedesc(String codedesc) {
        this.codedesc = codedesc;
    }

    public String getProcessPersonName() {
        return processPersonName;
    }

    public void setProcessPersonName(String processPersonName) {
        this.processPersonName = processPersonName;
    }
}
