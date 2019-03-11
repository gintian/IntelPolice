package com.service;

import com.exception.WebMessageException;
import com.model.Feedback;
import com.model.Notice;
import com.model.bean.FeedbackBean;
import com.model.bean.NoticeBean;
import com.page.PageBean;

/**
 * 类名称：FeedbackService 类描述：留言逻辑接口
 */
public interface FeedbackService{
	//添加
    void addBean(FeedbackBean feedbackBean) throws WebMessageException;
    //修改
    void updateBean(String id,FeedbackBean feedbackBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	FeedbackBean findFeedbackById(String id) throws WebMessageException;

	/**
	 *设置显示/隐藏
	 * @param id
	 * @throws WebMessageException
	 */
	void setLookAble(String id) throws WebMessageException;

	/**
	 *设置置顶/取消置顶
	 * @param id
	 * @throws WebMessageException
	 */
	void setTop(String id) throws WebMessageException;

	/**
	 * 条件查询：分页条件
	 *
	 * @param pageBean [必填]		分页对象
	 * @param bean     [必填]      查询条件
	 */
	void pageQuery(PageBean<Feedback> pageBean, FeedbackBean bean);
}
