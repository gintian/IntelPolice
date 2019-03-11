package com.service;

import com.exception.WebMessageException;
import com.model.InvolvedTypes;
import com.model.bean.InvolvedTypesBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：InvolvedTypesService 类描述：涉案财物类别表接口
 */
public interface InvolvedTypesService {
	 // 增加
	String addBean(InvolvedTypesBean bean) throws WebMessageException;
	 // 修改
	void updateBean(String id, InvolvedTypesBean bean) throws WebMessageException;
	 //  删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedTypesBean findInvolvedTypesById(String id) throws WebMessageException;
	/**
	 * 通过Code查询Bean
	 */
	InvolvedTypesBean findInvolvedTypesByCode(String code) throws WebMessageException;
	/**
	 *通过parentId查询Bean
	 */
	List<InvolvedTypesBean> findInvolvedTypesByParentId(String parentId) throws WebMessageException;
	/**
	 * 查询所有Bean
	 */
	List<InvolvedTypesBean> findAll() throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQuery(PageBean<InvolvedTypes> pageBean, InvolvedTypesBean bean);
}
