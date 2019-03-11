package com.service.mapper;

import java.util.List;

import com.model.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import com.model.bean.RoleBean;
import com.model.mapper.RoleMapper;
import com.page.PageBean;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface RoleBeanMapper extends RoleMapper {
    /**
     * 分页条件查询
     * @param bean                [必填]            查询条件
     * @param userBean           [必填]            操作用户
     * @return
     */
     List<RoleBean> selectBeanPage(@Param("entity") RoleBean bean, @Param("pageBean") PageBean<RoleBean> beanPageBean, @Param("user") UserBean userBean);

    /**
     * 查询根据添加查询总条数
     * @param bean                    [必填]            查询条件
     * @param userBean               [必填]            操作用户
     * @return
     */
    int countTotal(@Param("entity") RoleBean bean, @Param("user") UserBean userBean);

    /**
     * 查询所有
     * @return
     */
    List<RoleBean> findAll();

    /**
     * 根据部门查询，当前部门的角色
     * @param deptId                [必填]         部门id
     * @return
     */
    List<RoleBean> findBeanListByDeptId(@Param("deptId") String deptId);

    /**
     * 根据机构父类的id和RoleKey查找到权限
     * @param parentDept
     * @param roleKey
     * @return
     */
    RoleBean findRoleByParentDeptAndRolekey(@Param("parentDept")String parentDept, @Param("roleKey")String roleKey);
}
