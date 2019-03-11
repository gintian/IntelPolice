package com.service;

import com.exception.WebMessageException;
import com.model.Archive;
import com.model.bean.ArchiveBean;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类名称：ArchiveService 类描述：处警单逻辑接口
 */
public interface ArchiveService {
	//添加
    void addBean(ArchiveBean ArchiveBean) throws WebMessageException;
    //修改
    void updateBean(String id, ArchiveBean ArchiveBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	ArchiveBean findArchiveById(String id) throws WebMessageException;
	/**
	 * 通过案事件分页查询
	 * @param pageBean
	 * @param bean
	 * @param userId
	 * @param caseid
	 */
	void pageQueryEqCaseId(PageBean<Archive> pageBean, ArchiveBean bean, String userId, String caseid);
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<Archive> pageBean, ArchiveBean bean);

	/**
	 * 无需同步处理
	 * @param caseid
	 * @throws WebMessageException
	 */
	void noRequireDispose(String caseid) throws WebMessageException;

	List<ArchiveBean> selectDataAllEqCaseId(String caseid);

	void pageCruDayQuery(PageBean<Archive> pageBean, ArchiveBean bean);
}
