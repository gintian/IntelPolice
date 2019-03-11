package com.service;
import com.exception.WebMessageException;
import com.model.User;
import com.model.bean.UserBean;
import com.page.PageBean;

import java.util.List;

/**
 * tl
 * 类名称：UserService 类描述：用户业务逻辑接口
 */
public interface UserService {

	/**
	 * 添加
	 * @param userBean					[必填]		内容
	 * @param currentUser					[必填]		操作用户
	 * @throws WebMessageException			异常，可以向用户界面抛出
	 */
	void addBean(UserBean userBean, UserBean currentUser) throws WebMessageException;

	/**
	 * 修改
	 * @param id							[必填]		bean主键
	 * @param bean							[必填]		修改内容
	 * @param currentUser					[必填]		操作用户
	 * @throws WebMessageException			异常，可以向用户界面抛出
	 */
	void updateBean(String id,UserBean bean, UserBean currentUser) throws WebMessageException;

	/**
	 * 删除
	 * @param id							[必填]	     删除主键
	 * @param currentUser					[必填]		操作用户
	 * @throws WebMessageException			异常，可以向用户界面抛出
	 */
	void deleteBean(String id, UserBean currentUser) throws WebMessageException;

	/**
	 * 根据主键查询 bean
	 * @param id						[必填]			主键
	 * @return							用户bean 对象
	 * @throws WebMessageException    异常，可以向用户界面抛出
	 */
	UserBean findUserById(String id) throws WebMessageException;

	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param currentUser			[必填]		操作用户
	 * @throws WebMessageException    异常，可以向用户界面抛出
	 */
	void pageQuery(PageBean<UserBean> pageBean, UserBean bean, UserBean currentUser) throws WebMessageException;

	/**
	 * 登录
	 * 
	 * @param account						[必填]			账号号
	 * @param password					[密码]			密码
	 * @return
	 * @throws WebMessageException    异常，可以向用户界面抛出
	 */
	boolean login(String account, String password) throws WebMessageException;

	/**
	 * 修改密碼
	 * 
	 * @param account					[必填]		账号
	 * @param oldpassword				[必填]		旧密码
	 * @param password				[必填]		新密码
	 * @throws WebMessageException    异常，可以向用户界面抛出
	 */
	void changePassword(String account, String oldpassword, String password) throws WebMessageException;

	/**
	 * 根据账户得到用户
	 * 
	 * @param account
	 * @return
	 * @throws WebMessageException
	 */
	UserBean findUserByAccount(String account) throws WebMessageException;

	/**
	 * 重置密码
	 * @param userId						[必填]		用户id
	 * @param currentUser					[必填]		操作用户
	 *  @throws WebMessageException    异常，可以向用户界面抛出
	 */
	void resetPassword(String userId, UserBean currentUser) throws WebMessageException;

	/**
	 * 根据用户id 查询当前用户的角色ids
	 * @param userId							[必填]		用户id
	 * @param currentUser					    [必填]		操作用户
	 * @throws WebMessageException
	 */
	String findRoleIdsByUserId(String userId, UserBean currentUser) throws WebMessageException;

	/**
	 * 锁定激活当前用户
	 * @param userId						[必填]		锁定用户id
	 * @param locked						[必填]		锁定激活标识
	 */
	void updateUserLocked(String userId, String locked) throws WebMessageException;

	/**
	 * 判断当前用户是否有权限登录
	 * @param userBean					[必填]		登录用户
	 * @return
	 * @throws WebMessageException
	 */
	void validateUserLoginPermission(UserBean userBean) throws WebMessageException;

	/**
	 * 根据用户身份证号查找用户
	 * @param identityCard
	 * @return
	 */
    UserBean findUserByIdentityCard(String identityCard) throws WebMessageException;

	/**
	 * 根据任务办理人机构查找到当前机构的法制审批人列表
	 * @param roleId
	 * @return
	 */
	List<UserBean> findUsersByRole(String roleId)  throws WebMessageException ;
}
