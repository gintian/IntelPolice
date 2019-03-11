package com.service;

import com.exception.WebMessageException;
import com.model.CaseInfo;
import com.model.bean.CaseInfoBean;
import com.page.PageBean;

/**
 * 类名称：CaseInfoService 类描述：处警单逻辑接口
 */
public interface CaseInfoService{
	//添加
    void addBean(CaseInfoBean caseInfoBean) throws WebMessageException;
    //修改
    void updateBean(String caseId,CaseInfoBean caseInfoBean) throws WebMessageException;
	//删除
	void deleteBean(String caseId) throws WebMessageException;
	/**
	 * 通过caseInfodbh查询Bean
	 */
	CaseInfoBean findCaseInfoById(String caseId) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<CaseInfo> pageBean, CaseInfoBean bean);

}
