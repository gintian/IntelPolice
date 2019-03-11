package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Feedback;
import com.model.bean.FeedbackBean;
import com.model.mapper.FeedbackMapper;
import com.page.PageBean;

public interface FeedbackBeanMapper extends FeedbackMapper {
	// 查询分页数据
	List<FeedbackBean> selectData(@Param("entity") FeedbackBean bean, @Param("pageBean") PageBean<Feedback> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") FeedbackBean bean);

}
