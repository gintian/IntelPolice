package com.service.mapper;

import com.model.ArchiveStoresLockers;
import com.model.bean.ArchiveStoresLockersBean;
import com.model.mapper.ArchiveStoresLockersMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveStoresLockersBeanMapper extends ArchiveStoresLockersMapper {
	//查询分页数据
	List<ArchiveStoresLockersBean> selectData(@Param("entity") ArchiveStoresLockersBean bean, @Param("pageBean") PageBean<ArchiveStoresLockers> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") ArchiveStoresLockersBean bean);

}
