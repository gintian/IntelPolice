package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.InvolvedStoresBox;
import com.model.bean.InvolvedStoresBoxBean;
import com.model.mapper.InvolvedStoresBoxMapper;
import com.page.PageBean;

public interface InvolvedStoresBoxBeanMapper extends InvolvedStoresBoxMapper {
	// 查询分页数据
	List<InvolvedStoresBoxBean> selectData(@Param("entity") InvolvedStoresBoxBean bean,
			@Param("pageBean") PageBean<InvolvedStoresBox> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedStoresBoxBean bean);

}
