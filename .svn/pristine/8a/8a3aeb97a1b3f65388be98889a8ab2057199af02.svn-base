package com.service.mapper;

import com.model.InvolvedTypes;
import com.model.bean.InvolvedTypesBean;
import com.model.mapper.InvolvedTypesMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvolvedTypesBeanMapper extends InvolvedTypesMapper {
	// 查询分页数据
	List<InvolvedTypesBean> selectBeanPage(@Param("entity") InvolvedTypesBean bean, @Param("pageBean") PageBean<InvolvedTypes> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") InvolvedTypesBean bean);

	//通过Code查询
	InvolvedTypesBean selectByCode(@Param("code") String parentId);

	//通过parentId查询
	List<InvolvedTypesBean> selectByParentId(@Param("parentId") String parentId);

	/**
	 * 查询全部
	 *
	 * @return
	 */
	List<InvolvedTypesBean> selectAll();

}
