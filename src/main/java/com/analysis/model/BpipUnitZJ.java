package com.analysis.model;

import java.util.Date;

public class BpipUnitZJ {
    private String unitid;

    private String unitname;

    private String zjid;

    private String zhid;

    private String zjname;

    private String lyds;

    private Date hckRksj;

    private Date hckGxsj;

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid == null ? null : unitid.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getZjid() {
        return zjid;
    }

    public void setZjid(String zjid) {
        this.zjid = zjid == null ? null : zjid.trim();
    }

    public String getZhid() {
        return zhid;
    }

    public void setZhid(String zhid) {
        this.zhid = zhid == null ? null : zhid.trim();
    }

    public String getZjname() {
        return zjname;
    }

    public void setZjname(String zjname) {
        this.zjname = zjname == null ? null : zjname.trim();
    }

    public String getLyds() {
        return lyds;
    }

    public void setLyds(String lyds) {
        this.lyds = lyds == null ? null : lyds.trim();
    }

    public Date getHckRksj() {
        return hckRksj;
    }

    public void setHckRksj(Date hckRksj) {
        this.hckRksj = hckRksj;
    }

    public Date getHckGxsj() {
        return hckGxsj;
    }

    public void setHckGxsj(Date hckGxsj) {
        this.hckGxsj = hckGxsj;
    }
}