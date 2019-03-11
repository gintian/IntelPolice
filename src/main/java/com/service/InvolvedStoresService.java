package com.service;

import com.exception.WebMessageException;
import com.model.InvolvedStores;
import com.model.bean.InvolvedStoresBean;
import com.page.PageBean;
/**
 * 类名称：InvolvedStoresService 类描述：仓库表接口
 */
public interface InvolvedStoresService {
	 //增加
	void addBean(InvolvedStoresBean bean) throws WebMessageException;
	//修改
	void updateBean(String id, InvolvedStoresBean bean) throws WebMessageException;
	// 删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedStoresBean findInvolvedStoresById(String id) throws WebMessageException;
	/**
	 * 分页
	 * 
	 * @param pageBean
	 * @param bean
	 */
	void pageQuery(PageBean<InvolvedStores> pageBean, InvolvedStoresBean bean);
}
