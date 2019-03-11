package com.service;

import com.exception.WebMessageException;
import com.model.ArchiveStoresBoxLog;
import com.model.bean.ArchiveStoresBoxLogBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：ArchiveStoresBoxService 类描述：处警单逻辑接口
 */
public interface ArchiveStoresBoxLogService {
	//添加
    void addBean(ArchiveStoresBoxLogBean ArchiveStoresBoxLogBean) throws WebMessageException;
    //修改
    void updateBean(String id, ArchiveStoresBoxLogBean ArchiveStoresBoxLogBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	ArchiveStoresBoxLogBean findArchiveStoresBoxLogById(String id) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<ArchiveStoresBoxLogBean> pageBean, ArchiveStoresBoxLogBean bean);

}
