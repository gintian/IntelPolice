package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.bean.MenuBean;
import com.model.mapper.MenuMapper;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface MenuBeanMapper extends MenuMapper {
    /**
     * 查询所有
     * @return
     */
    List<MenuBean> findAllJilian();
    /**
     * 查询所有
     * @return
     */
    List<MenuBean> findAll();

    /**
     * 通过 父类id  查询   所有多级子类
     * @param parentId                          [必填]    父类id
     * @return
     */
    List<MenuBean> findMenuByParentId(@Param("parentId") String parentId);

    /**
     * 通过 父类id  查询   所有一级子类
     * @param parentId                          [必填]    父类id
     * @return
     */
    List<MenuBean> findOneLevelMenuByParentId(@Param("parentId") String parentId);
}
