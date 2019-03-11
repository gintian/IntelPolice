package com.service;

import com.exception.WebMessageException;
import com.model.Involved;
import com.model.bean.InvolvedBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：InvolvedService 类描述：涉案财物信息表接口
 */
public interface InvolvedService {
	 // 增加
	String addBean(InvolvedBean bean) throws WebMessageException;
	 // 修改
	void updateBean(String id, InvolvedBean bean) throws WebMessageException;
	 //  删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedBean findInvolvedById(String id) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQuery(PageBean<Involved> pageBean, InvolvedBean bean);

	/**
	 * 分页查询根据案件ID关联
	 * @param caseId		[必填]		案件ID号
	 */
	List<InvolvedBean> findByCaseId(String caseId);

	/**
	 * 修改财务保管状态
	 * @param approveState
	 */
    void updateApproveState(String involvedId, String approveState) throws WebMessageException;

	/**
	 * 修改财务处置状态
	 * @param disposeState
	 */
	void updateDisposeState(String involvedId, String disposeState) throws WebMessageException;

}
