package com.model;

import java.util.Date;

/**
 * 仓库储物柜ea_involved_stores_lockers
 * 
 * @author OnJuly
 *
 */
public class InvolvedStoresLockers {
	private String id; // 储物柜id
	private String deptId; // 部门id
	private String storeId; // 仓库id
	private String type; // 类型
	private String lockerName; // 储物柜名称
	private String lockerRow; // 排数
	private String lockerGate; // 门数
	private String postPath; // webservice请求地址
	private String host; // 柜子服务端主机有端口需要加端口号
	private String userId; // 保管用户id
	private String createUserId; // 生成用户id
	private Date createTime; // 生成时间
	private Date editTime; // 生成时间
	private String isDelete; // 是否删除1：删除，0：不删除
	private String integration; // 集成类型1为sochet集成，直接取host进行连接，2为webservice集成

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLockerName() {
		return lockerName;
	}

	public void setLockerName(String lockerName) {
		this.lockerName = lockerName;
	}

	public String getLockerRow() {
		return lockerRow;
	}

	public void setLockerRow(String lockerRow) {
		this.lockerRow = lockerRow;
	}

	public String getLockerGate() {
		return lockerGate;
	}

	public void setLockerGate(String lockerGate) {
		this.lockerGate = lockerGate;
	}

	public String getPostPath() {
		return postPath;
	}

	public void setPostPath(String postPath) {
		this.postPath = postPath;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getIntegration() {
		return integration;
	}

	public void setIntegration(String integration) {
		this.integration = integration;
	}

	@Override
	public String toString() {
		return "InvolvedStoresLockers{" +
				"id='" + id + '\'' +
				", deptId='" + deptId + '\'' +
				", storeId='" + storeId + '\'' +
				", type='" + type + '\'' +
				", lockerName='" + lockerName + '\'' +
				", lockerRow='" + lockerRow + '\'' +
				", lockerGate='" + lockerGate + '\'' +
				", postPath='" + postPath + '\'' +
				", host='" + host + '\'' +
				", userId='" + userId + '\'' +
				", createUserId='" + createUserId + '\'' +
				", createTime=" + createTime +
				", editTime=" + editTime +
				", isDelete='" + isDelete + '\'' +
				", integration='" + integration + '\'' +
				'}';
	}
}
