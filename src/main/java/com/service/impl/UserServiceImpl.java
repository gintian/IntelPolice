package com.service.impl;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Role;
import com.model.User;
import com.model.UserRole;
import com.model.bean.UserBean;
import com.model.bean.UserRoleBean;
import com.page.PageBean;
import com.service.UserService;
import com.service.mapper.RoleBeanMapper;
import com.service.mapper.UserBeanMapper;
import com.service.mapper.UserRoleBeanMapper;
import com.utils.BeanUtils;
import com.utils.CommonValidate;
import com.utils.DESEncrypt;
import com.utils.ServiceUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类名称：UserServiceImpl 类描述：用户信息操作业务逻辑接口实现
 */
@Service("userService") // 声明是业务层的组件
public class UserServiceImpl implements UserService {
	@Autowired
	private UserBeanMapper userBeanMapper;
	@Autowired
	private UserRoleBeanMapper userRoleBeanMapper;
	@Autowired
	private RoleBeanMapper roleBeanMapper;
	@Override
	@Transactional
	public void addBean(UserBean userBean, UserBean currentUser) throws WebMessageException {
		if (userBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		if (CommonValidate.isEmpty(userBean.getPassword())) {
			throw new WebMessageException(WebExceptionConstant.USER_PASSWORD_IS_NONE);
		}
		// 校验bean, 字典内容
		validateBean(userBean);

		//校验当前用户是否有权限，添加当前部门的用户
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, userBean.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION);
		}
		/*
		 * 验证重复,  校验账号是否重复
		 */
		User userForAccount = userBeanMapper.selectUserEqAccount(userBean.getAccount());
		if (userForAccount != null) {
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_EXIST);
		}

		// 添加主键值,, 临时使用uuid,截取20 位
		userBean.setId(ServiceUtils.generatePrimaryKey());
		// 添加用户角色
		if (userBean.getRoleIds().size() <= 0) {
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_EXIST);
		}
		List<UserRole> list = new ArrayList<>();
		for (String roleId : userBean.getRoleIds()) {
			UserRole userRole = new UserRole();
			userRole.setId(ServiceUtils.generatePrimaryKey());
			userRole.setUserId(userBean.getId());
			userRole.setRoleId(roleId);
			list.add(userRole);
		}
		for (UserRole userRole : list) {
			userRoleBeanMapper.insertSelective(userRole);
		}
		//创建时间
		userBean.setCreateDate(new Date());

		//密码加密存储
		userBean.setPassword(DESEncrypt.encrypt(userBean.getPassword().trim(), userBean.getAccount() + CommonConstant.USER_PASSWORD_SALT));

		// 复制Bean 到model
		User user = new User();
		try {
			ServiceUtils.copyProperties(user, userBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		userBeanMapper.insertSelective(user);
	}

	@Override
	@Transactional
	public void updateBean(String id, UserBean bean, UserBean currentUser) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		if (bean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}

		// 校验bean
		validateBean(bean);

		//校验当前用户是否有权限，添加当前部门的用户
		if (!ServiceUtils.hasPermissionAccessDept(bean.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION);
		}

		// 添加用户角色
		if (bean.getRoleIds().size() <= 0) {
			throw new WebMessageException(WebExceptionConstant.USER_ROLE_IS_NONE);
		}

		// 删除用户的所有角色
		userRoleBeanMapper.deleteRolesByUserId(id);

		List<UserRole> list = new ArrayList<>();
		for (String roleId : bean.getRoleIds()) {
			UserRole userRole = new UserRole();
			userRole.setId(ServiceUtils.generatePrimaryKey());
			userRole.setUserId(bean.getId());
			userRole.setRoleId(roleId);
			list.add(userRole);
		}
		for (UserRole userRole : list) {
			userRoleBeanMapper.insertSelective(userRole);
		}
		//修改时间
		bean.setUpdateDate(new Date());
		bean.setPassword(null);
		/*if (!CommonValidate.isEmpty(bean.getPassword())){
			//密码加密存储
			bean.setPassword(DESEncrypt.encrypt(bean.getPassword().trim(), bean.getAccount() + CommonConstant.USER_PASSWORD_SALT));

		}else {

		}*/
		User user = new User();
		ServiceUtils.copyProperties(user, bean);
		userBeanMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	@Transactional
	public void deleteBean(String id, UserBean currentUser) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}

		User usermodel = userBeanMapper.selectByPrimaryKey(id);

		if (CommonValidate.isEmpty(usermodel)){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}

		//校验当前用户是否有权限，添加当前部门的用户
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, usermodel.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION);
		}

		//逻辑删除
		usermodel.setStatus(CommonConstant.STATUS_DELETE);
		// 删除当前用户的角色
		userBeanMapper.updateByPrimaryKeySelective(usermodel);
	}

	@Override
	public UserBean findUserById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}

		User user = userBeanMapper.selectByPrimaryKey(id);
		if (user == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_SEARCH_NONE);
		}
		UserBean userBean = new UserBean();
		ServiceUtils.copyProperties(userBean, user);
		// 根据查询用户id角色，并填充bean
		List<UserRoleBean> userRoles = userRoleBeanMapper.selectRolesByUserId(userBean.getId());
		for (UserRole userRole : userRoles) {
			userBean.getRoleIds().add(userRole.getRoleId());
		}
		return userBean;
	}

	@Override
	public UserBean findUserByIdentityCard(String identityCard) throws WebMessageException {
		if (StringUtils.isEmpty(identityCard)) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}

		User user = userBeanMapper.selectByIdentityCard(identityCard);
		if (user == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_SEARCH_NONE);
		}
		UserBean userBean = new UserBean();
		ServiceUtils.copyProperties(userBean, user);
		// 根据查询用户id角色，并填充bean
		List<UserRoleBean> userRoles = userRoleBeanMapper.selectRolesByUserId(userBean.getId());
		for (UserRole userRole : userRoles) {
			userBean.getRoleIds().add(userRole.getRoleId());
		}
		return userBean;
	}

	@Override
	public void pageQuery(PageBean<UserBean> pageBean, UserBean userBean, UserBean currentUser) throws WebMessageException {
		int total = userBeanMapper.selectTotal(userBean, currentUser);
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		if (total > 0) {
			userBeanList = userBeanMapper.selectBeanPage(userBean, pageBean, currentUser);
		}
		pageBean.setTotal(total);
		pageBean.setRows(userBeanList);
	}

	@Override
	public boolean login(String account, String password) throws WebMessageException {
		if (StringUtils.isEmpty(account)) {
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_NONE);
		}
		if (StringUtils.isEmpty(password)) {
			throw new WebMessageException(WebExceptionConstant.USER_PASSWORD_IS_NONE);
		}
		String oldPassword = password;
		password = DESEncrypt.encrypt(oldPassword.trim(), account + CommonConstant.USER_PASSWORD_SALT);
		UserBean userBean = userBeanMapper.selectUserEqAccountAndPassword(account, password);
		//是否查询到用户
		if (CommonValidate.isEmpty(userBean) || CommonValidate.isEmpty(userBean.getAccount())){
			return false;
		}

		//判断用户是否已经被锁定
		if (userBean.getLocked().equals("1")){
			throw new WebMessageException(WebExceptionConstant.USER_IS_LOCKED);
		}

		//判断密码是否相同
		if (userBean.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public void changePassword(String account, String oldpassword, String newPassword) throws WebMessageException {
		if (StringUtils.isEmpty(account)) {
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_NONE);
		}
		if (StringUtils.isEmpty(oldpassword)) {
			throw new WebMessageException(WebExceptionConstant.USER_PASSWORD_IS_NONE);
		}
		if (StringUtils.isEmpty(newPassword)) {
			throw new WebMessageException(WebExceptionConstant.USER_NEWPASSWORD_IS_NONE);
		}

		oldpassword = DESEncrypt.encrypt(oldpassword, account + CommonConstant.USER_PASSWORD_SALT);

		UserBean userBean = userBeanMapper.selectUserEqAccountAndPassword(account, oldpassword);
		if (userBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_SEARCH_NONE);
		}

		//修改时间
		userBean.setUpdateDate(new Date());
		//密码加密存储
		userBean.setPassword(DESEncrypt.encrypt(newPassword.trim(), account + CommonConstant.USER_PASSWORD_SALT));

		User user = new User();
		ServiceUtils.copyProperties(user, userBean);
		userBeanMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserBean findUserByAccount(String account) throws WebMessageException {
		if (StringUtils.isEmpty(account)) {
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_NONE);
		}
		UserBean user = userBeanMapper.selectUserEqAccount(account);
		if (user == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_SEARCH_NONE);
		}
		List<UserRoleBean> list = userRoleBeanMapper.selectRolesByUserId(user.getId());
		StringBuilder roleName = new StringBuilder("");
		for (UserRoleBean userRoleBean : list){
			Role roleBean = roleBeanMapper.selectByPrimaryKey(userRoleBean.getRoleId());
			if (!CommonValidate.isEmpty(roleBean)){
				roleName.append(roleBean.getName());
				roleName.append(",");
			}
		}
		if (!CommonValidate.isEmpty(roleName.toString())){
			user.setRoleName(roleName.toString().substring(0, roleName.length() - 1));
		}else if (user.isSuperAdmin()){
			user.setRoleName("超级管理员");
		}

		return user;
	}

	/*
	 * 校验 bean 对象
	 */
	private void validateBean(UserBean bean) throws WebMessageException {
		/*
		 * 验证非空
		 */
		if (CommonValidate.isEmpty(bean.getName()) || bean.getName().length() > 40) {
			throw new WebMessageException(WebExceptionConstant.NAME_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getAccount()) || bean.getAccount().length() > 30) {
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getSex()) || bean.getSex().length() > 2) {
			throw new WebMessageException(WebExceptionConstant.USER_SEX_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getDeptId())) {
			throw new WebMessageException(WebExceptionConstant.USER_DEPTID_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getLocked())) {
			throw new WebMessageException(WebExceptionConstant.USER_LOCKED_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getUserType()) || bean.getUserType().length() > 2) {
			throw new WebMessageException(WebExceptionConstant.USER_USERTYPE_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getStatus())) {
			throw new WebMessageException(WebExceptionConstant.STATUS_IS_NONE);
		}
		if (bean.getRoleIds().size() <= 0) {
			throw new WebMessageException(WebExceptionConstant.USER_ROLE_IS_NONE);
		}

		// 校验用户账户是否重复
		// 校验身份证号码是否重复
		// 校验警号是否重复
	}

	@Override
	public void resetPassword(String userId, UserBean currentUser) throws WebMessageException {
		if (CommonValidate.isEmpty(userId)) {
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		User model = userBeanMapper.selectByPrimaryKey(userId);
		if (CommonValidate.isEmpty(model)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		//校验当前用户是否有权限，添加当前部门的用户
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, model.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION);
		}

		String password = DESEncrypt.encrypt(CommonConstant.USER_RESET_PASSWORD, model.getAccount() + CommonConstant.USER_PASSWORD_SALT);
		userBeanMapper.resetPasswordByUserId(userId, password);
	}

	@Override
	public String findRoleIdsByUserId(String userId, UserBean currentUser) throws WebMessageException {
		StringBuilder roleIds = new StringBuilder("");
		if (CommonValidate.isEmpty(userId)){
			return roleIds.toString();
		}
		User model = userBeanMapper.selectByPrimaryKey(userId);
		//校验当前用户是否有权限，添加当前部门的用户
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, model.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION);
		}

		for (UserRoleBean userRoleBean : userRoleBeanMapper.selectRolesByUserId(userId)){
			roleIds.append(userRoleBean.getRoleId());
			roleIds.append(",");
		}
		return roleIds.toString();
	}

	@Override
	public void updateUserLocked(String userId, String locked) throws WebMessageException {
		if (CommonValidate.isEmpty(userId) || CommonValidate.isEmpty(locked)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		User model = userBeanMapper.selectByPrimaryKey(userId);

		if (CommonValidate.isEmpty(model)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		//校验当前用户是否有权限，添加当前部门的用户
		if (!ServiceUtils.hasPermissionAccessDept(model.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION);
		}
		//更新锁定状态
		model.setLocked(locked);
		userBeanMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public void validateUserLoginPermission(UserBean userBean) throws WebMessageException {
		//登录权限点集合
		List<String> sps = new ArrayList<>();
		try {
			sps =  IOUtils.readLines(getClass().getResourceAsStream(CommonConstant.SYSTEM_PERSSION_FILENAME));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//为空，抛异常
		if (CommonValidate.isEmpty(userBean) || CommonValidate.isEmpty(userBean.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		//超级管理员放行
		if (userBean.isSuperAdmin()){
			return;
		}
		//权限点判断
		for (String sp : sps){
			for (String id : sp.split(",")){
				if (userBean.getDeptId().equals(id)){
					return;
				}
			}

		}
		//一个登录点 的权限都没匹配，抛异常无权登录
		throw new WebMessageException(WebExceptionConstant.USER_NONE_PERMISSION_LOGIN);
	}

	@Override
	public List<UserBean> findUsersByRole(String roleId)  throws WebMessageException {
		List<UserBean> listUserBean = new ArrayList<UserBean>();
		List<UserRoleBean> listUserRoleBean = new ArrayList<UserRoleBean>();
		listUserRoleBean = userRoleBeanMapper.findUsersByRoleId(roleId);
		if(listUserRoleBean.size()>0)
		{
			//根据权限关联列表循环查找到每一个用户
			for(UserRoleBean userRoleBean : listUserRoleBean) {
				String userId = userRoleBean.getUserId();
				UserBean userBean = new UserBean();
				User user = userBeanMapper.selectByPrimaryKey(userId);
				try {
					ServiceUtils.copyProperties(userBean, user);
				}catch (Exception e)
				{
					throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
				}
				listUserBean.add(userBean);
			}
		}
		return listUserBean;
	}
}
