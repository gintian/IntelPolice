package com.service.mapper;

import com.model.InvolvedCase;
import com.model.bean.InvolvedCaseBean;
import com.model.mapper.InvolvedCaseMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvolvedCaseBeanMapper extends InvolvedCaseMapper {
	// 查询分页数据
	List<InvolvedCaseBean> selectBeanPage(@Param("entity") InvolvedCaseBean bean, @Param("pageBean") PageBean<InvolvedCase> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedCaseBean bean);

	InvolvedCaseBean selectByInvolvedId(String involvedId);

	List<InvolvedCaseBean> selectByBoxId(String boxId);

}
