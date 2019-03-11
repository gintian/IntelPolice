package com.service;

import com.exception.WebMessageException;
import com.model.bean.MenuBean;
import com.model.bean.RecordTypeBean;
import com.page.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类名称：RecordTypeService 类描述：笔录接口
 */
public interface RecordTypeService {
	/* // 增加
	String addBean(RecordTypeBean bean) throws WebMessageException;
	 // 修改
	void updateBean(String typeId, RecordTypeBean bean) throws WebMessageException;
	 //  删除
	void deleteBean(String typeId) throws WebMessageException;
	*//**
	 * 通过Id查询Bean
	 *//*
	RecordTypeBean findRecordTypeById(String typeId) throws WebMessageException;

	*//**
	 *通过parentId查询Bean
	 *//*
	List<RecordTypeBean> findRecordTypeByParentId(String parentId) throws WebMessageException;
	*//**
	 * 查询所有Bean
	 *//*
	List<RecordTypeBean> findAll() throws WebMessageException;
	*//**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 *//*
	void pageQuery(PageBean<RecordTypeBean> pageBean, RecordTypeBean bean);*/

	/**
	 * tl
	 * 通过parentId得到RecordTypeBean   所有子类
	 * @param parentId
	 * @return
	 * @throws WebMessageException
	 */
	List<RecordTypeBean> findMenuByParentId(String parentId) throws WebMessageException;

	/**
	 * tl
	 * 根据  parentId 得到一级子类
	 * @param parentId				[必填]		父类id
	 * @return
	 * @throws WebMessageException
	 */
	List<RecordTypeBean> findOneLevelMenuByParentId(String parentId) throws WebMessageException;

	/**
	 *  添加类型
	 * @param recordTypeBean    [必填]   Bean对象
	 */
	void addMenuBean(RecordTypeBean recordTypeBean) throws Exception;

	/**
	 *   修改类型
	 * @param recordTypeBean     [必填]   Bean对象
	 * @param id       [必填]   菜单主键
	 */
	void updateMenuBean(String id, RecordTypeBean recordTypeBean) throws Exception;

	/**
	 *  删除类型
	 * @param id      [必填]    菜单主键
	 */
	void deleteMenuBean(String id) throws Exception;

	/**
	 * 	根据Id查询对象
	 * @param id					[必填]      主键id
	 * @return
	 * @throws Exception
	 */
	RecordTypeBean findMenuByMenuId(String id) throws Exception;


	/**
	 *  查询所有的菜单，返回指定的字符串格式
	 * @return
	 */
	String showMenuAll(HttpServletRequest request);

	/**
	 * 查询所有的菜单，不进行级联操作
	 * @return
	 */
	List<RecordTypeBean> findMenuBeanList() throws WebMessageException;

	/**
	 * 缓存菜单数据
	 */
	void doCacheMenu();

	List<RecordTypeBean> findAllByLevel();
}
