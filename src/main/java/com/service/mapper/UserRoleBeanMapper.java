package com.service.mapper;

import java.util.List;

import com.model.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import com.exception.WebMessageException;
import com.model.bean.UserRoleBean;
import com.model.mapper.UserRoleMapper;

public interface UserRoleBeanMapper extends UserRoleMapper {
	/**
	 * 通过用户ID得到用户角色
	 * @return
	 * @throws WebMessageException
	 */
	List<UserRoleBean> selectRolesByUserId(@Param("userId") String userId) throws WebMessageException;

	/**
	 * 根据用户id 删除   当前用户的所有的角色
	 * @param userId					[必填]   用户id
	 */
	void deleteRolesByUserId(@Param("userId") String userId);

	/**
	 * 权限ID查找用户列表
	 * @param roleId
	 * @return
	 */
	List<UserRoleBean> findUsersByRoleId(@Param("roleId")String roleId);
}
