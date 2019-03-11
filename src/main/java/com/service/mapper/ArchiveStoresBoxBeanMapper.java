package com.service.mapper;

import com.exception.WebMessageException;
import com.model.ArchiveStoresBox;
import com.model.bean.ArchiveStoresBoxBean;
import com.model.mapper.ArchiveStoresBoxMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveStoresBoxBeanMapper extends ArchiveStoresBoxMapper {
	//查询分页数据
	List<ArchiveStoresBoxBean> selectData(@Param("entity") ArchiveStoresBoxBean bean, @Param("pageBean") PageBean<ArchiveStoresBox> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") ArchiveStoresBoxBean bean);
	List<ArchiveStoresBoxBean> selectDateById(@Param("entity") ArchiveStoresBoxBean bean);
	//根据使用者Id
	List<ArchiveStoresBoxBean> selectByBoxUser(@Param("boxUser")String boxUser);
	//查询分页数据当天是否存入
	List<ArchiveStoresBoxBean> selectCruDayData(@Param("entity") ArchiveStoresBoxBean bean, @Param("pageBean") PageBean<ArchiveStoresBox> pageBean);

}
