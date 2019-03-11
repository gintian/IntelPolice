package com.service;

import com.analysis.model.InvolvedTemp;
import com.exception.WebMessageException;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：InvolvedService 类描述：涉案财物信息表接口
 */
public interface InvolvedTempService {

	/**
	 * 分页查询根据案件ID
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQueryByCaseId(PageBean<InvolvedTemp> pageBean, InvolvedTemp bean);

	/**
	 * 通过Id查询Bean
	 */
	InvolvedTemp findInvolvedTempById(String id) throws WebMessageException;

}
