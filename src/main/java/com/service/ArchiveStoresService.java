package com.service;

import com.exception.WebMessageException;
import com.model.ArchiveStores;
import com.model.bean.ArchiveStoresBean;
import com.page.PageBean;

/**
 * 类名称：ArchiveStoresService 类描述：处警单逻辑接口
 */
public interface ArchiveStoresService {
	//添加
    String addBean(ArchiveStoresBean ArchiveStoresBean) throws WebMessageException;
    //修改
    void updateBean(String id, ArchiveStoresBean ArchiveStoresBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	ArchiveStoresBean findArchiveStoresById(String id) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<ArchiveStores> pageBean, ArchiveStoresBean bean);

}
