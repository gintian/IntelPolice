package com.service;

import com.exception.WebMessageException;
import com.model.InvolvedTask;
import com.model.bean.InvolvedTaskBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：InvolvedService 类描述：涉案财物信息表接口
 */
public interface InvolvedTaskService {
	 // 增加
	void addBean(InvolvedTaskBean bean) throws WebMessageException;
	 // 修改
	void updateBean(InvolvedTaskBean bean) throws WebMessageException;
	 //  删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	InvolvedTaskBean findInvolvedTaskById(String id) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 */
	void pageQuery(PageBean<InvolvedTask> pageBean, InvolvedTaskBean bean);

	/* 根据身份证号查找我的工作流任务*/
	List<InvolvedTaskBean> findInvolvedTaskByIdentityCard(String identityCard)  throws WebMessageException;

	/**
	 * 通过流程实例ID查找任务
	 * @param processDefinitionId
	 * @return
	 */
    InvolvedTaskBean findInvolvedTaskByProcessInstanceId(String processDefinitionId) ;
}
