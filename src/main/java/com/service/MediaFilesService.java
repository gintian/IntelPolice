package com.service;
import com.exception.WebMessageException;
import com.model.bean.MediaFilesBean;
import com.page.PageBean;

public interface MediaFilesService {
	/**
	 *  获取所有的bean，并返回json字符串
	 * @return
	 */
	String getAllListBean();

	/**
	 *  添加
	 * @param bean    [必填]   Bean对象
	 */
	void addBean(MediaFilesBean bean) throws Exception;

	/**
	 *   修改
	 * @param bean     [必填]   Bean对象
	 * @param id       [必填]   主键
	 */
	void updateBean(String id, MediaFilesBean bean) throws Exception;

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
	 MediaFilesBean findMenuById(String id) throws Exception;

	/**
	 *  根据视频id   和文件路径添加bean
	 * @param mediaId					[必填]			视频id
	 * @param filePath				[必填]			文件路径
	 */
	void addBeanByMediaId(String mediaId, String filePath) throws WebMessageException;

	/**
	 * 分页查询
	 * @param pageBean		[必填]		分页对象
	 * @param bean				[必填]      查询条件
	 * @param userId			[必填]		操作用户
	 */
	void pageQuery(PageBean<MediaFilesBean> pageBean, MediaFilesBean bean, String userId);
}
