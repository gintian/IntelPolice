package com.model.bean;

import com.model.RecordType;

import java.util.List;

public class RecordTypeBean extends RecordType {
    private List<RecordTypeBean> sonList;//子类

    public List<RecordTypeBean> getSonList() {
        return sonList;
    }

    public void setSonList(List<RecordTypeBean> sonList) {
        this.sonList = sonList;
    }
}