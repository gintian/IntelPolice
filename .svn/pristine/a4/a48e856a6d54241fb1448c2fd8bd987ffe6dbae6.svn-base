package com.service;
import com.model.bean.MediaCaseBean;

public interface MediaCaseService {
	/**
	 *  获取所有的bean，并返回json字符串
	 * @return
	 */
	String getAllListBean() throws Exception;

	/**
	 *  添加
	 * @param bean    [必填]   Bean对象
	 */
	void addBean(MediaCaseBean bean) throws Exception;

	/**
	 *   修改
	 * @param bean     [必填]   Bean对象
	 * @param id       [必填]   主键
	 */
	void updateBean(String id, MediaCaseBean bean) throws Exception;

	/**
	 *  删除
	 * @param id      [必填]    主键
	 */
	void deleteBean(String id) throws Exception;

	/**
	 * 	根据Id查询对象
	 * @param id					[必填]      主键
	 * @return
	 * @throws Exception
	 */
	 MediaCaseBean findMenuById(String id) throws Exception;

	/**
	 *   根据条件查询bean对象list
	 * @param bean				[必填]     查询条件
	 * @return                      json 对象
	 * @throws Exception
	 */
	 String queryCriteriaBeanList(MediaCaseBean bean) throws Exception;
}
