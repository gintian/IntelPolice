package com.service;
import com.exception.WebMessageException;
import com.model.bean.MediaBean;
import com.page.PageBean;

public interface MediaService {
	/**
	 *  添加
	 * @param bean    [必填]   Bean对象
	 */
	void addBean(MediaBean bean) throws WebMessageException;

	/**
	 *   修改
	 * @param bean     [必填]   Bean对象
	 * @param id       [必填]   主键
	 */
	void updateBean(String id, MediaBean bean) throws WebMessageException;

	/**
	 *  删除
	 * @param id      [必填]    主键
	 */
	void deleteBean(String id) throws WebMessageException;

	/**
	 * 	根据Id查询对象
	 * @param id					[必填]      主键
	 * @return
	 * @throws Exception
	 */
	 MediaBean findMediaById(String id) throws WebMessageException;

	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param userId			[必填]		操作用户
	 */
	void pageQuery(PageBean<MediaBean> pageBean, MediaBean bean, String userId);
}
