package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.bean.*;
import com.utils.CommonValidate;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Role;
import com.model.RolePermission;
import com.model.User;
import com.page.PageBean;
import com.service.RoleService;
import com.service.mapper.RoleBeanMapper;
import com.service.mapper.RoleMenuBeanMapper;
import com.service.mapper.RolePermissionBeanMapper;
import com.service.mapper.UserRoleBeanMapper;
import com.utils.ServiceUtils;

@Service()
public class RoleServiceImpl  implements RoleService {
	@Autowired
	private RoleBeanMapper roleBeanMapper;
	@Autowired
	private RolePermissionBeanMapper rolePermissionBeanMapper;
	@Autowired
	private UserRoleBeanMapper userRoleBeanMapper;
	@Autowired
	private RoleMenuBeanMapper roleMenuBeanMapper;
	@Override
	@Transactional
	public void addBean(RoleBean bean) throws WebMessageException {
		// TODO Auto-generated method stub
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验Bean
		validateBean(bean);
		//添加主键
		bean.setId(ServiceUtils.generatePrimaryKey());
		Role model = new Role();
		
		//复制Bean 到model
		try {
			BeanUtils.copyProperties(model, bean);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
	
		roleBeanMapper.insert(model);
	}
	
	/**
	 *  校验  bean 对象
	 * @param bean  			[必填]		bean对象
	 * @throws Exception    校验异常
	 */
	private void validateBean(RoleBean bean) throws WebMessageException{
		if (StringUtils.isEmpty(bean.getName())){
			throw new WebMessageException(WebExceptionConstant.ROLE_NAME_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getChangeInd())){
			throw new WebMessageException(WebExceptionConstant.ROLE_IS_CHANGEIND);
		}
		if (StringUtils.isEmpty(bean.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.ROLE_DEPT_ID_ISNONE);
		}
		if (StringUtils.isEmpty(bean.getLocked())){
			throw new WebMessageException(WebExceptionConstant.ROLE_IS_LOCK);
		}
		if (StringUtils.isEmpty(bean.getType())){
			throw new WebMessageException(WebExceptionConstant.ROLE_TYPE_IS_NONE);
		}
	}

	@Override
	@Transactional
	public void updateBean(String id, RoleBean bean, UserBean currentUser) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.ROLE_ID_IS_NONE);
		}
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}

		//校验，是否有权访问此部门
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, bean.getDeptId())){
			System.out.println(WebExceptionConstant.SYSTEM_ILLEGAL_ACCESS);
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		//校验bean
		validateBean(bean);
		//去掉remrak 空格
		bean.setRemark(bean.getRemark().trim());
		//查看原数据，是否可以以修改
		/*validateCanEdit(id);*/
		Role Role = new Role();
		try {
			BeanUtils.copyProperties(Role, bean);
		}catch (Exception e){
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		
		roleBeanMapper.updateByPrimaryKeySelective(Role);
	}

	/**
	 * 判断原数据是否可以修改
	 * @param id							[必填]     id
	 * @throws WebMessageException
	 */
	@Transactional
	private void validateCanEdit(String id) throws WebMessageException{

		Role model = roleBeanMapper.selectByPrimaryKey(id);

		//校验 角色是否可以修改
		if (CommonConstant.CHANGEIND_ISLOCK.equals(model.getChangeInd())){
			throw new WebMessageException(WebExceptionConstant.ROLE_IS_NOT_CHANGE);
		}
	}
	@Override
	@Transactional
	public void deleteBean(String id, UserBean currentUser) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.ROLE_ID_IS_NONE);
		}
		Role role = roleBeanMapper.selectByPrimaryKey(id);

		//校验，是否有权访问此部门
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, role.getDeptId())){
			System.out.println(WebExceptionConstant.SYSTEM_ILLEGAL_ACCESS);
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		//删除当前角色的菜单
		roleMenuBeanMapper.deleteModelByRoleId(id);

		//删除当前角色的权限
		rolePermissionBeanMapper.deleteModelByRoleId(id);

		roleBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RoleBean findRoleById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.ROLE_ID_IS_NONE);
		}
		//查询对象
		Role Role = roleBeanMapper.selectByPrimaryKey(id);
		if (Role != null){
			RoleBean RoleBean = new RoleBean();
			try {
				BeanUtils.copyProperties(RoleBean, Role);
			}catch (Exception e){
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return RoleBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<RoleBean> pageBean, RoleBean bean, UserBean currentUser) throws WebMessageException {
		int total = roleBeanMapper.countTotal(bean, currentUser);
		List<RoleBean> mediaBeanList = roleBeanMapper.selectBeanPage(bean, pageBean, currentUser);
		pageBean.setTotal(total);
		pageBean.setRows(mediaBeanList);
	}

	@Override
	@Transactional
	public void updatePermissionByRoleId(List<String> permissionIds, String roleId, User user) throws WebMessageException {
		if (StringUtils.isEmpty(roleId)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		Role role = roleBeanMapper.selectByPrimaryKey(roleId);

		UserBean userBean = new UserBean();
		ServiceUtils.copyProperties(userBean, user);
		//校验，是否有权访问此部门
		if (!ServiceUtils.hasPermissionAccessDept(userBean, role.getDeptId())){
			System.out.println(WebExceptionConstant.SYSTEM_ILLEGAL_ACCESS);
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		//每次先删除所有与roleid相关的数据
		rolePermissionBeanMapper.deleteModelByRoleId(roleId);
		//添加相关数据
		List<RolePermissionBean> rolePermissionList = new ArrayList<RolePermissionBean>();
		if (!permissionIds.isEmpty()){
			for (String s : permissionIds){
				RolePermissionBean rolePermission = new RolePermissionBean();
				rolePermission.setId(ServiceUtils.generatePrimaryKey());
				rolePermission.setRoleId(roleId);
				rolePermission.setPermissionId(s);
				rolePermissionList.add(rolePermission);
			}
		}
		if (rolePermissionList.size() > 0) {
			rolePermissionBeanMapper.insertBatchData(rolePermissionList);
		}
	}

	@Override
	public List<String> findPermissionByRoleId(String roleId) throws WebMessageException {
		if (StringUtils.isEmpty(roleId)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		List<RolePermissionBean> list = rolePermissionBeanMapper.getModelByRoleID(roleId);
		if (list.isEmpty()){
			return null;
		}

		List<String> result = new ArrayList<>();

		for (RolePermission rolePermission : list){
			result.add(rolePermission.getPermissionId());
		}
		return result;
	}
	@Override
	public Set<String> findPermissionURlsByUserId(String userId) throws WebMessageException {
		if (StringUtils.isEmpty(userId)) {
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		//根据userid 查询当前用户所拥有的角色
		List<UserRoleBean> userRoleList = userRoleBeanMapper.selectRolesByUserId(userId);
		List<String> roleIds = new ArrayList<String>();
		for (UserRoleBean userRole : userRoleList){
			roleIds.add(userRole.getRoleId());
		}

		Set<String> set = null;
		if (roleIds.isEmpty()){
			return set;
		}
		//根据角色查询，所有的url
		List<String> rolePermissionList = rolePermissionBeanMapper.getModelListByRoleIds(roleIds);
		//过滤url 链接，保持唯一
		set = new HashSet<>(rolePermissionList);

		return set;
	}

	@Override
	public List<RoleBean> findBeanListByDeptId(String deptId, boolean flag) throws WebMessageException {

		if (StringUtils.isEmpty(deptId)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		List<RoleBean> roleBeenlist = roleBeanMapper.findBeanListByDeptId(deptId);
		return roleBeenlist;
	}

	@Override
	@Transactional
	public void addRoleMenuList(String roleId, String funIds) throws WebMessageException {
		if (StringUtils.isEmpty(roleId)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		List<String> menuIds = new ArrayList<>();
		if (!StringUtils.isEmpty(funIds)){
			menuIds.addAll(Arrays.asList(funIds.split(",")));
		}
		if (CommonValidate.isEmpty(menuIds)){
			//不做任何修改
			return;
		}
		List<RoleMenuBean> roleMenuList = new ArrayList<>();
		for (String s :menuIds){
			RoleMenuBean roleMenu = new RoleMenuBean();
			roleMenu.setId(ServiceUtils.generatePrimaryKey());
			roleMenu.setMenuId(s);
			roleMenu.setRoleId(roleId);
			roleMenuList.add(roleMenu);
		}
		//删除当前roleid的所有
		roleMenuBeanMapper.deleteModelByRoleId(roleId);

		roleMenuBeanMapper.insertBatchData(roleMenuList);
	}

	@Override
	public List<String> findMenuIdsByRoleIds(String roleId) throws WebMessageException{
		if (StringUtils.isEmpty(roleId)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		List<RoleMenuBean> roleMenuList = roleMenuBeanMapper.getModelByRoleID(roleId);
		List<String> menuIds = new ArrayList<String>();
		for (RoleMenuBean roleMenu : roleMenuList){
			menuIds.add(roleMenu.getMenuId());
		}
		return menuIds;
	}

	@Override
	public RoleBean findRoleByDeptAndRolekey(String deptId, String roleKey){
		//判断机构是否大于8位，大于8位取前8为来获得一个区县同级别的机构
		String parentDept = "" ;
		if(deptId.length()>=8)
		{
			parentDept = deptId.substring(0,7);
		}
		RoleBean roleBean = new RoleBean();
		//根据机构父类的id和RoleKey查找到权限
		roleBean = roleBeanMapper.findRoleByParentDeptAndRolekey(parentDept,roleKey);
		return roleBean;
	}
}
