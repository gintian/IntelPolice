package com.model;

import java.util.Date;

/**
 * 涉案财物信息表ea_involved_infos
 */
public class Involved {
    private String id;                         //涉案财物编号
    private String cwbm;                               //财物编码
    private String cwmc;                               //财物名称
    private Date djsj;                                 //登记时间
    private String djryId;                             //登记人员ID
    private String djryzh;                             //登记人员账号
    private String lrry;                               //登记人员
    private String djrydwId;                           //登记人员单位ID
    private String djrydw;                             //登记人员单位机构
    private String cwflCode;                           //财物分类code
    private String kyyy;                               //扣押原因
    private String cwwz;                               //财物物主
    private String wzxx;                               //物主信息
    private String cwsl;                               //物品数量
    private String cwjz;                               //财物价值
    private String cwtz;                               //财物特征
    private String bz;                                 //财物备注
    private String isBgsp;                             //是否经过保管审批0：不通过，1：本单位保管，2、警务保障室保管
    private Integer clbhcs;                             //处理驳回次数
    private Integer bgbhcs;                             //保管驳回次数
    private Date bgkssj;                             //保管开始时间
    private Date bgdqsj;                             //保管到期时间
    private String isSa;                               //财物是否涉案
    private String isDelete;                           //是否删除0，正常，1，已删除
    private String isEdit;                             //是否申请修改0：默认，1、申请、2、可修改、3、驳回
    private String isEditInFile;                       //是否申请入库图片0：默认，1、申请、2、可修改、3、驳回
    private String isEditOutFile;                      //是否申请修改出库附件0：默认，1、申请、2、可修改、3、驳回
    private String isEditFinishFile;                   //是否申请修改完成处理附件0：默认，1、申请、2、可修改、3、驳回
    private String leaderProcessId;                    //所领导审批ID只记录最新的一次审批
    private String lawerProcessId;                     //法制审批ID只记录最新的一次审批
    private String officeProcessId;                    //局领导审批ID只记录最新的一次审批
    private String objId;                              //案事件系统财物序号
    private String processMode;                        //处置方式
    private String approveState;                       //保管状态0为默认，1为正在申请这时候可以修改财务内容，2正在审批保管过程不能修改内容，2为保管完成
    private String disposeState;                        //处置状态0为默认，1为正在处理工作流过程，2为处理完成
    private String storeState;                            //库存状态0为默认，1为已经入库，2为移交，3为出库，4提取，5为已处理

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCwbm() {
        return cwbm;
    }

    public void setCwbm(String cwbm) {
        this.cwbm = cwbm;
    }

    public String getCwmc() {
        return cwmc;
    }

    public void setCwmc(String cwmc) {
        this.cwmc = cwmc;
    }

    public Date getDjsj() {
        return djsj;
    }

    public void setDjsj(Date djsj) {
        this.djsj = djsj;
    }

    public String getDjryId() {
        return djryId;
    }

    public void setDjryId(String djryId) {
        this.djryId = djryId;
    }

    public String getDjryzh() {
        return djryzh;
    }

    public void setDjryzh(String djryzh) {
        this.djryzh = djryzh;
    }

    public String getLrry() {
        return lrry;
    }

    public void setLrry(String lrry) {
        this.lrry = lrry;
    }

    public String getDjrydwId() {
        return djrydwId;
    }

    public void setDjrydwId(String djrydwId) {
        this.djrydwId = djrydwId;
    }

    public String getDjrydw() {
        return djrydw;
    }

    public void setDjrydw(String djrydw) {
        this.djrydw = djrydw;
    }

    public String getCwflCode() {
        return cwflCode;
    }

    public void setCwflCode(String cwflCode) {
        this.cwflCode = cwflCode;
    }

    public String getKyyy() {
        return kyyy;
    }

    public void setKyyy(String kyyy) {
        this.kyyy = kyyy;
    }

    public String getCwwz() {
        return cwwz;
    }

    public void setCwwz(String cwwz) {
        this.cwwz = cwwz;
    }

    public String getWzxx() {
        return wzxx;
    }

    public void setWzxx(String wzxx) {
        this.wzxx = wzxx;
    }

    public String getCwsl() {
        return cwsl;
    }

    public void setCwsl(String cwsl) {
        this.cwsl = cwsl;
    }

    public String getCwjz() {
        return cwjz;
    }

    public void setCwjz(String cwjz) {
        this.cwjz = cwjz;
    }

    public String getCwtz() {
        return cwtz;
    }

    public void setCwtz(String cwtz) {
        this.cwtz = cwtz;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getIsBgsp() {
        return isBgsp;
    }

    public void setIsBgsp(String isBgsp) {
        this.isBgsp = isBgsp;
    }

    public Integer getClbhcs() {
        return clbhcs;
    }

    public void setClbhcs(Integer clbhcs) {
        this.clbhcs = clbhcs;
    }

    public Integer getBgbhcs() {
        return bgbhcs;
    }

    public void setBgbhcs(Integer bgbhcs) {
        this.bgbhcs = bgbhcs;
    }

    public Date getBgdqsj() {
        return bgdqsj;
    }

    public void setBgdqsj(Date bgdqsj) {
        this.bgdqsj = bgdqsj;
    }

    public Date getBgkssj() {
        return bgkssj;
    }

    public void setBgkssj(Date bgkssj) {
        this.bgkssj = bgkssj;
    }

    public String getIsSa() {
        return isSa;
    }

    public void setIsSa(String isSa) {
        this.isSa = isSa;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getIsEditInFile() {
        return isEditInFile;
    }

    public void setIsEditInFile(String isEditInFile) {
        this.isEditInFile = isEditInFile;
    }

    public String getIsEditOutFile() {
        return isEditOutFile;
    }

    public void setIsEditOutFile(String isEditOutFile) {
        this.isEditOutFile = isEditOutFile;
    }

    public String getIsEditFinishFile() {
        return isEditFinishFile;
    }

    public void setIsEditFinishFile(String isEditFinishFile) {
        this.isEditFinishFile = isEditFinishFile;
    }

    public String getLeaderProcessId() {
        return leaderProcessId;
    }

    public void setLeaderProcessId(String leaderProcessId) {
        this.leaderProcessId = leaderProcessId;
    }

    public String getLawerProcessId() {
        return lawerProcessId;
    }

    public void setLawerProcessId(String lawerProcessId) {
        this.lawerProcessId = lawerProcessId;
    }

    public String getOfficeProcessId() {
        return officeProcessId;
    }

    public void setOfficeProcessId(String officeProcessId) {
        this.officeProcessId = officeProcessId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getProcessMode() {
        return processMode;
    }

    public void setProcessMode(String processMode) {
        this.processMode = processMode;
    }

    public String getApproveState() {
        return approveState;
    }

    public void setApproveState(String approveState) {
        this.approveState = approveState;
    }

    public String getDisposeState() {
        return disposeState;
    }

    public void setDisposeState(String disposeState) {
        this.disposeState = disposeState;
    }

    public String getStoreState() {
        return storeState;
    }

    public void setStoreState(String storeState) {
        this.storeState = storeState;
    }

    public Involved() {
        super();
    }

    public Involved(String id, String cwbm, String cwmc, Date djsj, String djryId, String djryzh, String lrry, String djrydwId, String djrydw, String cwflCode, String kyyy, String cwwz, String wzxx, String cwsl, String cwjz, String cwtz, String bz, String isBgsp, Integer clbhcs, Integer bgbhcs, Date bgkssj, Date bgdqsj, String isSa, String isDelete, String isEdit, String isEditInFile, String isEditOutFile, String isEditFinishFile, String leaderProcessId, String lawerProcessId, String officeProcessId, String objId, String processMode, String approveState, String disposeState, String storeState) {
        this.id = id;
        this.cwbm = cwbm;
        this.cwmc = cwmc;
        this.djsj = djsj;
        this.djryId = djryId;
        this.djryzh = djryzh;
        this.lrry = lrry;
        this.djrydwId = djrydwId;
        this.djrydw = djrydw;
        this.cwflCode = cwflCode;
        this.kyyy = kyyy;
        this.cwwz = cwwz;
        this.wzxx = wzxx;
        this.cwsl = cwsl;
        this.cwjz = cwjz;
        this.cwtz = cwtz;
        this.bz = bz;
        this.isBgsp = isBgsp;
        this.clbhcs = clbhcs;
        this.bgbhcs = bgbhcs;
        this.bgkssj = bgkssj;
        this.bgdqsj = bgdqsj;
        this.isSa = isSa;
        this.isDelete = isDelete;
        this.isEdit = isEdit;
        this.isEditInFile = isEditInFile;
        this.isEditOutFile = isEditOutFile;
        this.isEditFinishFile = isEditFinishFile;
        this.leaderProcessId = leaderProcessId;
        this.lawerProcessId = lawerProcessId;
        this.officeProcessId = officeProcessId;
        this.objId = objId;
        this.processMode = processMode;
        this.approveState = approveState;
        this.disposeState = disposeState;
        this.storeState = storeState;
    }

    @Override
    public String toString() {
        return "Involved{" +
                "id='" + id + '\'' +
                ", cwbm='" + cwbm + '\'' +
                ", cwmc='" + cwmc + '\'' +
                ", djsj=" + djsj +
                ", djryId='" + djryId + '\'' +
                ", djryzh='" + djryzh + '\'' +
                ", lrry='" + lrry + '\'' +
                ", djrydwId='" + djrydwId + '\'' +
                ", djrydw='" + djrydw + '\'' +
                ", cwflCode='" + cwflCode + '\'' +
                ", kyyy='" + kyyy + '\'' +
                ", cwwz='" + cwwz + '\'' +
                ", wzxx='" + wzxx + '\'' +
                ", cwsl='" + cwsl + '\'' +
                ", cwjz='" + cwjz + '\'' +
                ", cwtz='" + cwtz + '\'' +
                ", bz='" + bz + '\'' +
                ", isBgsp='" + isBgsp + '\'' +
                ", clbhcs=" + clbhcs +
                ", bgbhcs=" + bgbhcs +
                ", bgkssj=" + bgkssj +
                ", bgdqsj=" + bgdqsj +
                ", isSa='" + isSa + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", isEdit='" + isEdit + '\'' +
                ", isEditInFile='" + isEditInFile + '\'' +
                ", isEditOutFile='" + isEditOutFile + '\'' +
                ", isEditFinishFile='" + isEditFinishFile + '\'' +
                ", leaderProcessId='" + leaderProcessId + '\'' +
                ", lawerProcessId='" + lawerProcessId + '\'' +
                ", officeProcessId='" + officeProcessId + '\'' +
                ", objId='" + objId + '\'' +
                ", processMode='" + processMode + '\'' +
                ", approveState='" + approveState + '\'' +
                ", disposeState='" + disposeState + '\'' +
                ", storeState='" + storeState + '\'' +
                '}';
    }
}
