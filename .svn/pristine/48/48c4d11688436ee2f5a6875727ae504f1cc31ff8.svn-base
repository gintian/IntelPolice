package com.service;
import java.util.List;
import java.util.Set;

import com.exception.WebMessageException;
import com.model.User;
import com.model.bean.RoleBean;
import com.model.bean.UserBean;
import com.page.PageBean;

public interface RoleService {
	/**
	 *  添加
	 * @param bean    [必填]   Bean对象
	 */
	void addBean(RoleBean bean) throws WebMessageException;

	/**
	 *   修改
	 * @param bean     [必填]   Bean对象
	 * @param id       [必填]   主键
	 */
	void updateBean(String id, RoleBean bean, UserBean currentUser) throws WebMessageException;

	/**
	 *  删除
	 * @param id      [必填]    主键
	 */
	void deleteBean(String id, UserBean currentUser) throws WebMessageException;

	/**
	 * 	根据Id查询对象
	 * @param id					[必填]      主键
	 * @return
	 * @throws Exception
	 */
	 RoleBean findRoleById(String id) throws WebMessageException;

	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param user			   [必填]		操作用户
	 */
	void pageQuery(PageBean<RoleBean> pageBean, RoleBean bean, UserBean user) throws WebMessageException;

	/**
	 * 修改角色对应的权限
	 * @param permissionIds				[必填]
	 * @param roleId
	 * @throws WebMessageException
	 */
	void updatePermissionByRoleId(List<String> permissionIds, String roleId, User user) throws WebMessageException;

	/**
	 * 根据 roleid查询  权限id
	 * @param roleId						[必填]
	 * @return
	 */
	List<String> findPermissionByRoleId(String roleId) throws WebMessageException;

	/**
	 * 根据用户id  查询此用户的所有url
	 * @param userId						[必填]		用户id
	 * @return
	 * @throws WebMessageException
	 */
	Set<String> findPermissionURlsByUserId(String userId) throws WebMessageException;

	/**
	 * 通过部门查询 ，当前部门的角色，过当前用户是管理员就返回所有
	 * @param deptId							[必填]    部门Id
	 *@param deptId							[必填]    是否根据当前用户显示数据
	 * @return
	 * @throws WebMessageException
	 */
	List<RoleBean> findBeanListByDeptId(String deptId, boolean flag) throws WebMessageException;

	/**
	 *  添加角色 - 菜单关联数据
	 * @param roleId							[必填]		角色Id
	 * @param funIds							[必填]		菜单id 列表
	 * @throws WebMessageException
	 */
	void addRoleMenuList(String roleId, String funIds) throws WebMessageException;

	/**
	 * 根据角色id 查询菜单id
	 * @param roleId						[必填]			角色id
	 * @return
	 */
	List<String> findMenuIdsByRoleIds(String roleId) throws WebMessageException;

	/**
	 * 根据机构ID和权限的roleKey查找权限
	 * @param deptId
	 * @param roleKey
	 * @return
	 */
    RoleBean findRoleByDeptAndRolekey(String deptId, String roleKey);
}
