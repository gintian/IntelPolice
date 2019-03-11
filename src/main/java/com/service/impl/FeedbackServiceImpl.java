package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Feedback;
import com.model.Feedback;
import com.model.bean.FeedbackBean;
import com.model.bean.FeedbackBean;
import com.page.PageBean;
import com.service.FeedbackService;
import com.service.mapper.FeedbackBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：FeedbackServiceImpl 类描述：留言操作业务逻辑接口实现
 */
@Service("feedbackService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackBeanMapper feedbackBeanMapper;

	@Override
	public void addBean(FeedbackBean feedbackBean) throws WebMessageException {
		if (feedbackBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		feedbackBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(feedbackBean);
		Feedback feedback = new Feedback();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(feedback, feedbackBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		feedbackBeanMapper.insertSelective(feedbackBean);
	}

	@Override
	public void updateBean(String id,FeedbackBean feedbackBean) throws WebMessageException {
		if (feedbackBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(feedbackBean);
		Feedback feedback = new Feedback();
		try {
			ServiceUtils.copyProperties(feedback, feedbackBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		feedbackBeanMapper.updateByPrimaryKeySelective(feedback);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		feedbackBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public FeedbackBean findFeedbackById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		Feedback feedback = feedbackBeanMapper.selectByPrimaryKey(id);
		if (feedback != null) {
			FeedbackBean feedbackBean = new FeedbackBean();
			try {
				ServiceUtils.copyProperties(feedbackBean, feedback);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return feedbackBean;
		}
		return null;
	}

	@Override
	public void setLookAble(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		Feedback feedback = feedbackBeanMapper.selectByPrimaryKey(id);
		String status = feedback.getStatus();
		if (status.equals("0")){
			feedback.setStatus("1");
			feedbackBeanMapper.updateByPrimaryKeySelective(feedback);
		}else{
			feedback.setStatus("0");
			feedbackBeanMapper.updateByPrimaryKeySelective(feedback);
		}
	}

	@Override
	public void setTop(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		Feedback feedback = feedbackBeanMapper.selectByPrimaryKey(id);
		String status = feedback.getStatus();
		if (status.equals("2")){
			feedback.setStatus("1");
			feedbackBeanMapper.updateByPrimaryKeySelective(feedback);
		}else{
			feedback.setStatus("2");
			feedbackBeanMapper.updateByPrimaryKeySelective(feedback);
		}
	}

	@Override
	public void pageQuery(PageBean<Feedback> pageBean, FeedbackBean bean) {
		int total = feedbackBeanMapper.selectTotal(bean);
		List<FeedbackBean> feedbackBeanList = new ArrayList<FeedbackBean>();
		if (total > 0) {
			feedbackBeanList = feedbackBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(feedbackBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(FeedbackBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
