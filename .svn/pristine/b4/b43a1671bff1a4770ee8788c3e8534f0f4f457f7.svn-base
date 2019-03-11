package com.service;

import com.exception.WebMessageException;
import com.model.JJ;
import com.model.bean.JJBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：JJService 类描述：接警单逻辑接口
 */
public interface JJService  {
	//添加
    void addBean(JJBean jjBean) throws WebMessageException;
    //修改
    void updateBean(String jjdbh,JJBean jjBean) throws WebMessageException;
	//删除
	void deleteBean(String jjdbh) throws WebMessageException;
	/**
	 * 通过jjdbh查询Bean
	 */
	JJBean findJJByJjdbh(String jjdbh) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<JJ> pageBean, JJBean bean);
	/**
	 * 条件查询：分页条件（未关联）
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQueryUnrelated(PageBean<JJ> pageBean, JJBean bean);
	/**
	 * 条件查询：分页条件（未录音）
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQueryNotRecordings(PageBean<JJ> pageBean, JJBean bean);

	/**
	 * 通过caseId查询Bean
	 */
	JJBean findJJBycaseId(String caseId) throws WebMessageException;

	//未关联的接警
	void pageQueryNotView(PageBean<JJ> pageBean, JJBean bean);

	//已关联的接警
	void pageQueryCorrelateView(PageBean<JJ> pageBean, JJBean bean);

}
