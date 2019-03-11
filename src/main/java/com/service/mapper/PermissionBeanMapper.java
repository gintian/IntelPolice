package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.bean.PermissionBean;
import com.model.mapper.PermissionMapper;
import com.page.PageBean;

/**
 * Created by Administrator on 2018/4/19 0019.
 */
public interface PermissionBeanMapper extends PermissionMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<PermissionBean> selectBeanPage(@Param("entity") PermissionBean bean, @Param("pageBean") PageBean<PermissionBean> beanPageBean);

    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") PermissionBean bean);
    /**
     * 查询所有
     * @return
     */
    List<PermissionBean> findAll();
}
