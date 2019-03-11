package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.exception.WebMessageException;
import com.model.bean.MenuBean;

public interface MenuService {

	/**
	 * tl
	 * 通过parentId得到menu   所有子类
	 * @param parentId
	 * @return
	 * @throws WebMessageException
	 */
	List<MenuBean> findMenuByParentId(String parentId) throws WebMessageException;

	/**
	 * tl
	 * 根据  parentId 得到一级子类
	 * @param parentId				[必填]		父类id
	 * @return
	 * @throws WebMessageException
	 */
	List<MenuBean> findOneLevelMenuByParentId(String parentId) throws WebMessageException;

	/**
	 *  添加菜单
	 * @param menuBean    [必填]   Bean对象
	 */
	void addMenuBean(MenuBean menuBean) throws Exception;

	/**
	 *   修改菜单
	 * @param menuBean     [必填]   Bean对象
	 * @param id       [必填]   菜单主键
	 */
	void updateMenuBean(String id, MenuBean menuBean) throws Exception;

	/**
	 *  删除菜单
	 * @param id      [必填]    菜单主键
	 */
	void deleteMenuBean(String id) throws Exception;

	/**
	 * 	根据Id查询对象
	 * @param id					[必填]      主键id
	 * @return
	 * @throws Exception
	 */
	 MenuBean findMenuByMenuId(String id) throws Exception;


	/**
	 *  查询所有的菜单，返回指定的字符串格式
	 * @return
	 */
	 String showMenuAll(HttpServletRequest request);

	/**
	 * 查询所有的菜单，不进行级联操作
	 * @return
	 */
	List<MenuBean> findMenuBeanList() throws WebMessageException;

	/**
	 * 缓存菜单数据
	 */
	void doCacheMenu();
}
