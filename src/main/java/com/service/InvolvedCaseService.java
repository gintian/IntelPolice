package com.service;

import com.exception.WebMessageException;
import com.model.InvolvedCase;
import com.model.bean.InvolvedCaseBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：InvolvedService 类描述：涉案财物与案件关联
 */
public interface InvolvedCaseService {
	 // 增加
	void addBean(InvolvedCaseBean bean) throws WebMessageException;
	 // 修改
	void updateBean(String id, InvolvedCaseBean bean) throws WebMessageException;
	 //  删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedCaseBean findInvolvedCaseById(String id) throws WebMessageException;
	/**
	 * 通过财物Id查询Bean
	 */
	InvolvedCaseBean findInvolvedCaseByInvolvedId(String involvedId) throws WebMessageException;
	/**
	 * 通过财物箱子Id查询Bean
	 */
	List<InvolvedCaseBean> findInvolvedCaseByBoxId(String boxId) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param userId			[必填]		操作用户
	 */
	void pageQuery(PageBean<InvolvedCase> pageBean, InvolvedCaseBean bean, String userId);
}
