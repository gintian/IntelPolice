package com.service;

import com.exception.WebMessageException;
import com.model.InvolvedStoresBox;
import com.model.bean.InvolvedStoresBoxBean;
import com.page.PageBean;

/**
 * 类名称：InvolvedStoresBoxStoresBoxService 类描述：储物柜箱子表接口
 */
public interface InvolvedStoresBoxService {
	// 增加
	void addBean(InvolvedStoresBoxBean bean) throws WebMessageException;
	// 修改
	void updateBean(String id,InvolvedStoresBoxBean bean) throws WebMessageException;
	// 删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedStoresBoxBean findInvolvedStoresBoxById(String id) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQuery(PageBean<InvolvedStoresBox> pageBean, InvolvedStoresBoxBean bean);
}
