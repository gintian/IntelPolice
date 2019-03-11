package com.service.mapper;

import com.model.RecordType;
import com.model.bean.RecordTypeBean;
import com.model.mapper.RecordTypeMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordTypeBeanMapper extends RecordTypeMapper {
	/*// 查询分页数据
	List<RecordTypeBean> selectBeanPage(@Param("entity") RecordTypeBean bean, @Param("pageBean") PageBean<RecordTypeBean> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") RecordTypeBean bean);

	//通过parentId查询
	List<RecordTypeBean> selectByParentId(@Param("parentId") String parentId);

	*//**
	 * 查询全部
	 *
	 * @return
	 *//*
	List<RecordTypeBean> selectAll();*/
	/**
	 * 查询所有
	 * @return
	 */
	List<RecordTypeBean> findAllJilian();
	/**
	 * 查询所有
	 * @return
	 */
	List<RecordTypeBean> findAll();

	/**
	 * 通过 父类id  查询   所有多级子类
	 * @param parentId                          [必填]    父类id
	 * @return
	 */
	List<RecordTypeBean> findMenuByParentId(@Param("parentId") String parentId);

	/**
	 * 通过 父类id  查询   所有一级子类
	 * @param parentId                          [必填]    父类id
	 * @return
	 */
	List<RecordTypeBean> findOneLevelMenuByParentId(@Param("parentId") String parentId);

	List<RecordTypeBean> findAllByLevel();
}
