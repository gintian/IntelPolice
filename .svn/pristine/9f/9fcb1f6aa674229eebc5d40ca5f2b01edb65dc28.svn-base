package com.service;

import com.exception.WebMessageException;
import com.model.ArchiveStoresBox;
import com.model.bean.ArchiveStoresBoxBean;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类名称：ArchiveStoresBoxService 类描述：处警单逻辑接口
 */
public interface ArchiveStoresBoxService {
	//添加
    void addBean(ArchiveStoresBoxBean ArchiveStoresBoxBean) throws WebMessageException;
    //修改
    void updateBean(String id, ArchiveStoresBoxBean ArchiveStoresBoxBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	ArchiveStoresBoxBean findArchiveStoresBoxById(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	List<ArchiveStoresBoxBean> findArchiveStoresBoxByBoxUser(String boxUser) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<ArchiveStoresBox> pageBean, ArchiveStoresBoxBean bean);

}
