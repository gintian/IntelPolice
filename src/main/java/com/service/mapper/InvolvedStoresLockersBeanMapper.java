package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.InvolvedStoresLockers;
import com.model.bean.InvolvedStoresLockersBean;
import com.model.mapper.InvolvedStoresLockersMapper;
import com.page.PageBean;

public interface InvolvedStoresLockersBeanMapper extends InvolvedStoresLockersMapper {
	// 查询分页数据
	List<InvolvedStoresLockersBean> selectData(@Param("entity") InvolvedStoresLockersBean bean,
			@Param("pageBean") PageBean<InvolvedStoresLockers> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedStoresLockersBean bean);

}
