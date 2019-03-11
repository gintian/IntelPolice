package com.model;

public class EaMediaCase {

    String id;
    String mediaId;
    String caseId;
    String jjdbh;
    String cjdbh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getJjdbh() {
        return jjdbh;
    }

    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    public String getCjdbh() {
        return cjdbh;
    }

    public void setCjdbh(String cjdbh) {
        this.cjdbh = cjdbh;
    }

    @Override
    public String toString() {
        return "EaMediaCase{" +
                "id='" + id + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", caseId='" + caseId + '\'' +
                ", jjdbh='" + jjdbh + '\'' +
                ", cjdbh='" + cjdbh + '\'' +
                '}';
    }
}
