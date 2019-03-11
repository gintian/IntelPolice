package com.service.mapper;

import com.model.ArchiveStoresBoxLog;
import com.model.bean.ArchiveStoresBoxLogBean;
import com.model.mapper.ArchiveStoresBoxLogMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveStoresBoxLogBeanMapper extends ArchiveStoresBoxLogMapper {
	//查询分页数据
	List<ArchiveStoresBoxLogBean> selectData(@Param("entity") ArchiveStoresBoxLogBean bean, @Param("pageBean") PageBean<ArchiveStoresBoxLogBean> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") ArchiveStoresBoxLogBean bean);

}
