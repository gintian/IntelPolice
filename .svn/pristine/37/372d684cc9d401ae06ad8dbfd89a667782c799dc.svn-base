package com.service;

import com.exception.WebMessageException;
import com.model.HF;
import com.model.bean.HFBean;
import com.page.PageBean;

/**
 * 类名称：HFService 类描述：回访单逻辑接口
 */
public interface HFService {
	//添加
    void addBean(HFBean hfBean) throws WebMessageException;
    //修改
    void updateBean(String hfhsdbh, HFBean hfBean) throws WebMessageException;
	//删除
	void deleteBean(String hfhsdbh) throws WebMessageException;
	/**
	 * 通过hfhsdbh查询Bean
	 */
	HFBean findHFByHfhsdbh(String hfhsdbh) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<HF> pageBean, HFBean bean);

}
