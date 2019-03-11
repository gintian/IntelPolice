package com.service.mapper;

import com.model.RecordPerson;
import com.model.bean.RecordPersonBean;
import com.model.mapper.RecordPersonMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordPersonBeanMapper extends RecordPersonMapper {
	// 查询分页数据
	List<RecordPersonBean> selectData(@Param("entity") RecordPersonBean bean, @Param("pageBean") PageBean<RecordPersonBean> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") RecordPersonBean bean);

}
