package com.service;
import java.util.List;

import com.exception.WebMessageException;
import com.model.bean.PermissionBean;
import com.page.PageBean;

public interface PermissionService {
	/**
	 *  添加
	 * @param bean    [必填]   Bean对象
	 */
	void addBean(PermissionBean bean) throws WebMessageException;

	/**
	 *   修改
	 * @param bean     [必填]   Bean对象
	 * @param id       [必填]   主键
	 */
	void updateBean(String id, PermissionBean bean) throws WebMessageException;

	/**
	 *  删除
	 * @param id      [必填]    主键
	 */
	void deleteBean(String id) throws WebMessageException;

	/**
	 * 	根据Id查询对象
	 * @param id					[必填]      主键
	 * @return
	 * @throws Exception
	 */
	 PermissionBean findPermissionById(String id) throws WebMessageException;

	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param userId			[必填]		操作用户
	 */
	void pageQuery(PageBean<PermissionBean> pageBean, PermissionBean bean, String userId) throws WebMessageException;

	/**
	 * 查询所有的权限
	 * @return
	 */
	List<PermissionBean> findAllPermissionBean() throws WebMessageException;
}
