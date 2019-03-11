package com.service;

import com.exception.WebMessageException;
import com.model.CMD;
import com.model.bean.CMDBean;
import com.page.PageBean;

/**
 * 类名称：CMDService 类描述：110指令逻辑接口
 */
public interface CMDService{
	//添加
    void addBean(CMDBean cmdBean) throws WebMessageException;
    //修改
    void updateBean(String id,CMDBean cmdBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	CMDBean findCMDById(String id) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<CMD> pageBean, CMDBean bean);
}
