package com.service;

import java.util.List;

import com.exception.WebMessageException;
import com.model.User;
import com.model.bean.DeptBean;
import com.model.bean.UserBean;
import com.page.PageBean;

/**
 * 类名称：DeptService 类描述：接警单逻辑接口
 */
public interface DeptService  {
	 // 添加
	void addBean(DeptBean bean, UserBean currentUser) throws WebMessageException;
	 //修改
	void updateBean(String id, DeptBean bean, UserBean currentUser) throws WebMessageException;
	 // 删除
	void deleteBean(String id, UserBean currentUser) throws WebMessageException;

	/**
	 * 通过Id查询Bean
	 * @param id						[必填]		主键
	 */
	DeptBean findDeptBeanByDeptId(String id) throws WebMessageException;

	/**
	 * 通过ParentId查找所有列表
	 * @param parentId 所属上级
	 *                 注意不包含父类 parentid
	 * @return
	 */
	List<DeptBean> findDeptByParentId(String parentId)  throws WebMessageException;
	/**
	 * 分页
	 * 
	 * @param pageBean					[必填]				分页对象
	 * @param bean							[必填]				查询对象
	 * @param currentUser					[必填]				操作用户
	 */
	void pageQuery(PageBean<DeptBean> pageBean, DeptBean bean, UserBean currentUser) throws WebMessageException;

	/**
	 * 根据name得到部门
	 * @param name
	 * @return
	 */
	DeptBean findDeptBeanByName(String name);	
	/**
	 * 全部查询
	 * @return
	 */
	List<DeptBean> findBeanAll() throws WebMessageException;

	/**
	 * 通过当前用户，查询部门，
	 * 当前用户为  管理员，返回当前部门及其子部门
	 * 	经办员  返回当前部门
	 * 	系统内置人员， 返回当前部门
	 * @param user 							[必填]			当前用户
	 * @return
	 */
	List<DeptBean> findDeptBeanListByCurrentUser(User user) throws WebMessageException;

	/**
	 * \缓存所有dept数据
	 */
	void cacheDeptAll() throws WebMessageException;
}
