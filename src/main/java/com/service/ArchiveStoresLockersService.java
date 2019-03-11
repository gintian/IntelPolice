package com.service;

import com.exception.WebMessageException;
import com.model.ArchiveStoresLockers;
import com.model.bean.ArchiveStoresLockersBean;
import com.page.PageBean;

/**
 * 类名称：ArchiveStoresBoxService 类描述：处警单逻辑接口
 */
public interface ArchiveStoresLockersService {
	// 增加
	void addBean(ArchiveStoresLockersBean bean) throws WebMessageException;
	// 修改
	void updateBean(String id,ArchiveStoresLockersBean bean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	ArchiveStoresLockersBean findInvolvedStoresLockersById(String id) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQuery(PageBean<ArchiveStoresLockers> pageBean, ArchiveStoresLockersBean bean);

}
