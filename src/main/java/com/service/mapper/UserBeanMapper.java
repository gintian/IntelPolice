package com.service.mapper;

import java.util.List;

import com.model.User;
import org.apache.ibatis.annotations.Param;

import com.exception.WebMessageException;
import com.model.bean.UserBean;
import com.model.mapper.UserMapper;
import com.page.PageBean;
import org.springframework.security.core.parameters.P;

public interface UserBeanMapper extends UserMapper {
	/**
	 * 登录
	 * @param account
	 * @param password
	 * @return
	 * @throws WebMessageException
	 */
	UserBean selectUserEqAccountAndPassword(@Param("account")String account, @Param("password")String password) throws WebMessageException;
	/**
	 * 通过account得到user
	 * @param account
	 * @return
	 * @throws WebMessageException
	 */
	UserBean selectUserEqAccount(@Param("account")String account) throws WebMessageException;
	/**
	 * 通过name得到user
	 * @param name
	 * @return
	 * @throws WebMessageException
	 */
	UserBean selectUserEqName(@Param("name")String name) throws WebMessageException;
	/**
	 * 查询总条数
	 * @param query
	 * @return
	 * @throws WebMessageException
	 */
	int selectTotal(@Param("entity")UserBean userBean, @Param("user") UserBean currentUserBean);
	/**
	 * 查询目标数据
	 * @param query
	 * @return
	 * @throws WebMessageException
	 */
	List<UserBean> selectBeanPage(@Param("entity")UserBean userBean, @Param("pageBean")PageBean<UserBean> pageBean, @Param("user") UserBean currentUserBean);

	/**
	 * 重置密码
	 * @param id				[必填]  用户id
	 */
	void resetPasswordByUserId(@Param("id") String id, @Param("password") String password);

	/**
	 * 根据用户身份证号查找用户
	 * @param identityCard
	 * @return
	 */
	User selectByIdentityCard(@Param("identityCard")String identityCard);
}
