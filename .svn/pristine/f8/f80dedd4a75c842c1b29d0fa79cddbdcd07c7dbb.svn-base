package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.RolePermission;
import com.model.bean.RolePermissionBean;
import com.model.mapper.RolePermissionMapper;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface RolePermissionBeanMapper extends RolePermissionMapper {
    /**
     * 批量插入
     * @param rolePermissions           [必填]    角色权限
     */
    void insertBatchData(@Param("list") List<RolePermissionBean> rolePermissions);

    /**
     * 根据角色id 查询权限
     * @param roleId                       [必填]   角色id
     * @return
     */
    List<RolePermissionBean> getModelByRoleID(@Param("roleId") String roleId);

    /**
     * 根据角色id c查询所有的url
     * @param roleId                    [必填]        角色id
     * @return
     */
    List<String> getModelListByRoleIds(@Param("list") List<String> roleId);

    /**
     * 根据角色id  删除所有的权限
     * @param roleId                [必填]        角色id
     */
    void deleteModelByRoleId(@Param("roleId") String roleId);
}
