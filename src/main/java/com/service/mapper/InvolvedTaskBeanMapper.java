package com.service.mapper;

import com.model.InvolvedTask;
import com.model.bean.InvolvedTaskBean;
import com.model.mapper.InvolvedTaskMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvolvedTaskBeanMapper extends InvolvedTaskMapper {
	// 查询分页数据
	List<InvolvedTaskBean> selectBeanPage(@Param("entity") InvolvedTaskBean bean, @Param("pageBean") PageBean<InvolvedTask> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedTaskBean bean);

	/* 根据身份证号查找我的工作流任务*/
	List<InvolvedTask> findInvolvedTaskByIdentityCard(String identityCard);

	/** 根据流程定义ID超找到当前财物的任务*/
    InvolvedTask selectByProcessDefinitionId(String processDefinitionId);
}
