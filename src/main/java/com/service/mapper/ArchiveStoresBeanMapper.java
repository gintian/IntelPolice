package com.service.mapper;

import com.exception.WebMessageException;
import com.model.ArchiveStores;
import com.model.bean.ArchiveStoresBean;
import com.model.mapper.ArchiveStoresMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveStoresBeanMapper extends ArchiveStoresMapper {
	//查询分页数据
	List<ArchiveStoresBean> selectData(@Param("entity") ArchiveStoresBean bean, @Param("pageBean") PageBean<ArchiveStores> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") ArchiveStoresBean bean);

}
