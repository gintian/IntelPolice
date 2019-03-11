package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Involved;
import com.model.bean.InvolvedBean;
import com.model.mapper.InvolvedMapper;
import com.page.PageBean;

public interface InvolvedBeanMapper extends InvolvedMapper {
	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedBean bean);

	// 查询分页数据
	List<InvolvedBean> selectBeanPage(@Param("entity") InvolvedBean bean, @Param("pageBean") PageBean<Involved> pageBean);

	// 根据案件查询财物
	List<InvolvedBean> selectByCaseId(@Param("caseid") String caseid);

}
