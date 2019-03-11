package com.service;

import com.exception.WebMessageException;
import com.model.InvolvedStoresLockers;
import com.model.bean.InvolvedStoresLockersBean;
import com.page.PageBean;
/**
 * 类名称：InvolvedStoresLockersService 类描述：仓库储物柜接口
 */
public interface InvolvedStoresLockersService  {
	 // 增加
	void addBean(InvolvedStoresLockersBean bean) throws WebMessageException;
	 // 修改
	void updateBean(String id,InvolvedStoresLockersBean bean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedStoresLockersBean findInvolvedStoresLockersById(String id) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQuery(PageBean<InvolvedStoresLockers> pageBean, InvolvedStoresLockersBean bean);
}
