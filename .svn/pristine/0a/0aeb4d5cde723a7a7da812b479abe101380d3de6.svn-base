package com.service;

import com.exception.WebMessageException;
import com.model.LY;
import com.model.bean.LYBean;
import com.page.PageBean;

/**
 * 类名称：LYService 类描述：录音单逻辑接口
 */
public interface LYService {
	//添加
    void addBean(LYBean lyBean) throws WebMessageException;
    //修改
    void updateBean(String lybh, LYBean lyBean) throws WebMessageException;
	//删除
	void deleteBean(String lybh) throws WebMessageException;
	/**
	 * 通过lybh查询Bean
	 */
	LYBean findLYByLybh(String lybh) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<LY> pageBean, LYBean bean);

}
