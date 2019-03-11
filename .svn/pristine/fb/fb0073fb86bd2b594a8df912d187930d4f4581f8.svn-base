package com.service.mapper;

import java.util.List;

import com.model.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import com.model.bean.DeptBean;
import com.model.mapper.DeptMapper;
import com.page.PageBean;

public interface DeptBeanMapper extends DeptMapper {
    /**
     * tl
     * 分页条件查询
     *
     * @param bean [必填]  查询条件
     * @return
     */
	List<DeptBean> selectBeanPage(@Param("entity") DeptBean bean, @Param("pageBean") PageBean<DeptBean> beanPageBean, @Param("user") UserBean userBean);

	/**
	 * tl
	 * 查询根据添加查询总条数
	 * @param bean             [必填]            查询条件
	 * @return
	 */
	int countTotal(@Param("entity") DeptBean bean, @Param("user") UserBean userBean);
	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	DeptBean selectDeptEqId(@Param("id") String id);
	/**
	 * tl
	 * 查询根据添加查询总条数
	 * @param bean             [必填]            查询条件
	 * @return
	 */
	int countTotal(@Param("entity") DeptBean bean);

    /**
     * 根据ParentId查询
     *
     * @param parentId
     * @return
     */
    List<DeptBean> selectDeptEqParentId(@Param("parentId") String parentId);

    /**
     * 根据NAME查询
     *
     * @param name
     * @return
     */
	DeptBean selectDeptEqName(@Param("name") String name);

    /**
     * 根据NAME查询
     *
     * @param name
     * @return
     */
	List<DeptBean> selectDeptLikeName(@Param("name") String name);

    /**
     * 查询全部
     *
     * @return
     */
    List<DeptBean> selectAll();

}
