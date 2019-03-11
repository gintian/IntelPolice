package com.analysis.model;

import java.util.Date;

public class BpipUnit {
    private String unitid;

    private String unitname;

    private String longname;

    private String shortname;

    private String unittype;

    private String address;

    private String phone;

    private String fax;

    private String postalcode;

    private String state;

    private String inputpsn;

    private Date inputtime;

    private String modifiedpsn;

    private Date modifiedtime;

    private Date districttime;

    private Date provincetime;

    private String tag;

    private String modifiedtag;

    private String deletag;

    private String longitude;

    private String latitude;

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

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname == null ? null : longname.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getUnittype() {
        return unittype;
    }

    public void setUnittype(String unittype) {
        this.unittype = unittype == null ? null : unittype.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getInputpsn() {
        return inputpsn;
    }

    public void setInputpsn(String inputpsn) {
        this.inputpsn = inputpsn == null ? null : inputpsn.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getModifiedpsn() {
        return modifiedpsn;
    }

    public void setModifiedpsn(String modifiedpsn) {
        this.modifiedpsn = modifiedpsn == null ? null : modifiedpsn.trim();
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Date getDistricttime() {
        return districttime;
    }

    public void setDistricttime(Date districttime) {
        this.districttime = districttime;
    }

    public Date getProvincetime() {
        return provincetime;
    }

    public void setProvincetime(Date provincetime) {
        this.provincetime = provincetime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getModifiedtag() {
        return modifiedtag;
    }

    public void setModifiedtag(String modifiedtag) {
        this.modifiedtag = modifiedtag == null ? null : modifiedtag.trim();
    }

    public String getDeletag() {
        return deletag;
    }

    public void setDeletag(String deletag) {
        this.deletag = deletag == null ? null : deletag.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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