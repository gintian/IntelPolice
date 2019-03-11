package com.service;

import com.exception.WebMessageException;
import com.model.bean.DataSyncTaskBean;
import com.model.bean.UserBean;
import com.page.PageBean;

public interface DataSyncTaskService {
	/**
	 *  添加
	 * @param bean    [必填]   Bean对象
	 */
	void addBean(DataSyncTaskBean bean) throws WebMessageException;

	//修改
	void updateBean(String id,DataSyncTaskBean dictoryBean) throws WebMessageException;

	/**
	 *  删除
	 * @param id      [必填]    主键
	 */
	void deleteBean(String id) throws WebMessageException;

	DataSyncTaskBean findBeanById(String id) throws WebMessageException;
	/**
	 * 分页查询  处理历史列表
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param user			   [必填]		操作用户
	 */
	void pageQuery(PageBean<DataSyncTaskBean> pageBean, DataSyncTaskBean bean, UserBean user) throws WebMessageException;

	/**
	 * 分页查询   待备份数据
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQueryForNextExecte(PageBean<DataSyncTaskBean> pageBean, DataSyncTaskBean bean) throws WebMessageException;
}
