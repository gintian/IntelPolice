package com.service;

import com.exception.WebMessageException;
import com.model.ArchiveCase;
import com.model.bean.ArchiveCaseBean;
import com.page.PageBean;
import java.util.List;

/**
 * 类名称：ArchiveCaseService 类描述：处警单逻辑接口
 */
public interface ArchiveCaseService {
	//添加
    void addBean(ArchiveCaseBean ArchiveCaseBean) throws WebMessageException;
    //修改
    void updateBean(String id, ArchiveCaseBean ArchiveCaseBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	void deleteArchiveBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	ArchiveCaseBean findArchiveCaseById(String id) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<ArchiveCase> pageBean, ArchiveCaseBean bean);
	//箱子Id查询bean
	ArchiveCaseBean findArchiveCaseByArchiveId(String boxUserId);

	void updateByArchiveIdByCaseId(ArchiveCaseBean bean);

	List<ArchiveCaseBean> selectDataByBoxId(String BoxId);
}
