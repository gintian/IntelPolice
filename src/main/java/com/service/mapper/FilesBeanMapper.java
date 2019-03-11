package com.service.mapper;

import com.model.Criminal;
import com.model.Files;
import com.model.bean.CriminalBean;
import com.model.bean.FilesBean;
import com.model.mapper.FilesMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilesBeanMapper extends FilesMapper {
	// 查询分页数据
	List<FilesBean> selectData(@Param("entity") FilesBean bean, @Param("pageBean") PageBean<Files> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") FilesBean bean);

	/**
	 * 各个模块查询案件信息的公共方法
	 * @param pageBean
	 * @param bean
	 * @param moduleFunction     模块功能,如"未录入笔录的案件"
	 */
	List<FilesBean> findBeanPageForModule(@Param("pageBean") PageBean<Files> pageBean, @Param("entity") FilesBean bean, @Param("moduleFunction") String moduleFunction);

	/**
	 * 各个模块查询案件信息总条数的公共方法
	 * @param moduleFunction     模块功能,如"未录入笔录的案件"
	 */
	int findBeanPageForModuleTotal(@Param("entity") FilesBean bean,@Param("moduleFunction") String moduleFunction);
}
