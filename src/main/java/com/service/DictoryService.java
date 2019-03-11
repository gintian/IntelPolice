package com.service;
import java.util.List;

import com.exception.WebMessageException;
import com.model.Dictory;
import com.model.bean.DictoryBean;
import com.page.PageBean;

public interface DictoryService {
	//添加
    void addBean(DictoryBean dictoryBean) throws WebMessageException;
    //修改
    void updateBean(String id,DictoryBean dictoryBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	DictoryBean findDictoryById(String id) throws WebMessageException;
	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param userId			[必填]		操作用户
	 */
	void pageQuery(PageBean<DictoryBean> pageBean, DictoryBean bean, String userId);

	/**
	 * 通过 typep 类型查询 字典
	 * @param type					[必填]    字典类型
 	 * @return
	 */
	List<DictoryBean> findDictoryByType(String type) throws WebMessageException;

	/***
	 *  缓存字典数据
	 */
	void doCacheForDictroy();
}
