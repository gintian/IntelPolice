package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.InvolvedStores;
import com.model.bean.InvolvedStoresBean;
import com.model.mapper.InvolvedStoresMapper;
import com.page.PageBean;

public interface InvolvedStoresBeanMapper extends InvolvedStoresMapper {
	// 查询分页数据
	List<InvolvedStoresBean> selectData(@Param("entity") InvolvedStoresBean bean,
			@Param("pageBean") PageBean<InvolvedStores> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedStoresBean bean);

}
