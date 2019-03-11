package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.bean.RoleMenuBean;
import com.model.mapper.RoleMenuMapper;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface RoleMenuBeanMapper extends RoleMenuMapper {
    /**
     * 批量插入
     * @param roleMenuBeanList           [必填]    角色菜单
     */
    void insertBatchData(@Param("list") List<RoleMenuBean> roleMenuBeanList);

    /**
     * 根据角色id 查询菜单
     * @param roleId                       [必填]   角色id
     * @return
     */
    List<RoleMenuBean> getModelByRoleID(@Param("roleId") String roleId);

    /**
     * 根据角色id c查询所有的url
     * @param roleId                    [必填]        角色id
     * @return
     */
    List<String> getModelListByRoleIds(@Param("list") List<String> roleId);

    /**
     * 根据角色id  删除所有的菜单
     * @param roleId                [必填]        角色id
     */
    void deleteModelByRoleId(@Param("roleId") String roleId);
}
