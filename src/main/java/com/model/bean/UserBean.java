package com.model.bean;

import java.util.ArrayList;
import java.util.List;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.User;
import com.utils.CommonValidate;

public class UserBean extends User {
	private String roleId;
	private List<String> roleIds = new ArrayList<String>();
	private String roleName;							//角色名称
	private String oldpassword;
	private String deptName;						//部门名称
	private String already;						//是否已经登录标识

	//请勿删除
	private String eqUserDeptId;                 //操作用户部门id , 作用例如： Sql  查询  = 'eqUserDeptId'
	private String likeUserDeptId;              //操作用户部门id, 作用例如 sql 查询 like  'likeUserDeptId%'


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getEqUserDeptId() {
		//添加部门筛选, 系统超级管理员不筛选，
		// 当前用户为管理员，查询当前部门及其子部门所有数据
		//为经办员，或者系统内置人员只查询当期部门数据
		if (!isSuperAdmin()){
			//操作用户非空校验
			if (CommonValidate.isEmpty(getDeptId())){
				System.out.println("=============当前操作用户数据错误！,管理员请立即处理 用户id 为:"+ getId()+" ================");
				System.out.println(this);
				setDeptId("-10");
			}
			String userDeptId = getDeptId();
			if (getUserType().equals(CommonConstant.USER_TYPE_SYSTEM)){
				//系统内置人员
				return userDeptId;
			}else if (getUserType().equals(CommonConstant.USER_TYPE_JINGBANYUUAN)){
				//经办员
				return userDeptId;
			}
		}
		return "";
	}

	public void setEqUserDeptId(String eqUserDeptId) {

		this.eqUserDeptId = eqUserDeptId;
	}

	public String getLikeUserDeptId() {
		//添加部门筛选, 系统超级管理员不筛选，
		// 当前用户为管理员，查询当前部门及其子部门所有数据
		//为经办员，或者系统内置人员只查询当期部门数据
		if (!isSuperAdmin()) {
			//操作用户非空校验
			if (CommonValidate.isEmpty(getDeptId())) {
				System.out.println("=============当前操作用户数据错误！,管理员请立即处理 用户id 为:" + getId() + " ================");
				System.out.println(this);
				setDeptId("-10");
			}
			String userDeptId = getDeptId();
			if (getUserType().equals(CommonConstant.USER_TYPE_ADMIN)) {
				//管理员
				return userDeptId;
			}
		}
		return "";
	}

	public void setLikeUserDeptId(String likeUserDeptId) {
		this.likeUserDeptId = likeUserDeptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAlready() {
		return already;
	}

	public void setAlready(String already) {
		this.already = already;
	}
}

