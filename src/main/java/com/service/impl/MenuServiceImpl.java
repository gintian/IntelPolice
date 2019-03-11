package com.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.utils.CommonValidate;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Menu;
import com.model.User;
import com.model.UserRole;
import com.model.bean.MenuBean;
import com.model.bean.UserRoleBean;
import com.service.MenuService;
import com.service.UserService;
import com.service.mapper.MenuBeanMapper;
import com.service.mapper.RoleMenuBeanMapper;
import com.service.mapper.UserRoleBeanMapper;
import com.utils.SessionKey;
import com.utils.StringUtil;
import com.utils.SysMenuVo;

@Service("menuService") // 澹版槑鏄笟鍔″眰鐨勭粍浠�
public class MenuServiceImpl  implements MenuService {

	@Autowired
	private MenuBeanMapper menuBeanMapper;
	@Autowired
	private RoleMenuBeanMapper roleMenuBeanMapper;
	@Autowired
	private UserRoleBeanMapper userRoleBeanMapper;
	@Autowired
	private UserService userService;

	public List<MenuBean> findMenuByParentId(String parentId) throws WebMessageException {
		if (StringUtils.isEmpty(parentId)) {
			throw new WebMessageException(WebExceptionConstant.MENU_PARENTID_IS_NONE);
		}
		return menuBeanMapper.findMenuByParentId(parentId);
	}

	@Override
	@Transactional
	public void addMenuBean(MenuBean menuBean) throws Exception {
		if (!StringUtils.isEmpty(menuBean.getParentId())) {

			List<MenuBean> menuList = findOneLevelMenuByParentId(menuBean.getParentId());
			int id = menuList.size() + 1;
			if (id < 10){
				menuBean.setId(menuBean.getParentId() + "0" + id);
			}else{
				menuBean.setId(menuBean.getParentId() + id);
			}
		} else {

			menuBean.setId("0");
		}

		validateBean(menuBean);

		Menu menu = new Menu();
		BeanUtils.copyProperties(menu, menuBean);
		menuBeanMapper.insert(menu);
	}

	/*
	 * 鏍￠獙 bean 瀵硅薄
	 */
	private void validateBean(MenuBean menuBean) throws WebMessageException {
		if (menuBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		if (StringUtils.isEmpty(menuBean.getName())) {
			throw new WebMessageException(WebExceptionConstant.NAME_IS_NONE);
		}
		if (StringUtils.isEmpty(menuBean.getParentId())) {
			throw new WebMessageException(WebExceptionConstant.MENU_PARENTID_IS_NONE);
		}
		if (StringUtils.isEmpty(menuBean.getLeaf())) {
			throw new WebMessageException(WebExceptionConstant.MENU_LEAF_IS_NONE);
		}
	}

	@Override
	@Transactional
	public void updateMenuBean(String id, MenuBean menuBean) throws Exception {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.MENU_MENUID_IS_NONE);
		}
		if (StringUtils.isEmpty(menuBean.getSortNo())) {
			menuBean.setSortNo("0");
		}
		validateBean(menuBean);
		Menu menu = new Menu();
		BeanUtils.copyProperties(menu, menuBean);
		menuBeanMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	@Transactional
	public void deleteMenuBean(String id) throws Exception {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.MENU_MENUID_IS_NONE);
		}
		menuBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MenuBean findMenuByMenuId(String id) throws Exception {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.MENU_MENUID_IS_NONE);
		}
		MenuBean menuBean = new MenuBean();
		Menu menu = menuBeanMapper.selectByPrimaryKey(id);
		if (menu == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_SEARCH_NONE);
		}
		BeanUtils.copyProperties(menuBean, menu);
		return menuBean;
	}

	@Override
	public String showMenuAll(HttpServletRequest request) {
		List<MenuBean> menuList_user = new ArrayList<>();
		List<String> listMenuIds = new ArrayList<>();
		User user = (User) request.getSession().getAttribute(SessionKey.USER);
		// 从Session中取值，如果菜单数据为空，就查询数据库
		String resultJson = (String) request.getSession().getAttribute(SessionKey.USER_LIST_MENU);
		if (StringUtils.isEmpty(resultJson)) {
			System.out.println("缓存中没有当前用户的菜单");
			try {
				if (!user.isSuperAdmin()){//超级管理员，返回所有的菜单
					//查询当前用户的所有角色
					List<UserRoleBean> userRoles = userRoleBeanMapper.selectRolesByUserId(user.getId());
					List<String> roleids = new ArrayList<>();
					for (UserRole userRole: userRoles){
						roleids.add(userRole.getRoleId());
					}
					if (!roleids.isEmpty()){
						listMenuIds = roleMenuBeanMapper.getModelListByRoleIds(roleids);
					}
					for (String menuId : new HashSet<>(listMenuIds)){
						MenuBean menuBean = SysMenuVo.findById(menuId);
						if (null != menuBean) {
							menuList_user.add(menuBean);
						}
					}
				}else {
					menuList_user = SysMenuVo.findAll();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONArray jsonArray = formatJsonToMenu(menuList_user);
			resultJson = jsonArray.toString();
			System.out.println(resultJson);
			// 将菜单数据缓存到session中
			request.getSession().setAttribute(SessionKey.USER_LIST_MENU, resultJson);
		}
		return resultJson;
	}
	/**
	 * 将数据库的json 字符串转为菜单需要的字符串
	 *
	 */
	private org.json.JSONArray formatJsonToMenu(List<MenuBean> list){
		//查询顶级菜单
		List<org.json.JSONObject> rootJson = new ArrayList<>();
		for (MenuBean menu : findByEqParentId("01", list)){
			org.json.JSONObject jsonobj = StringUtil.formatJsonObject(new org.json.JSONObject(menu));
			List<org.json.JSONObject> list2 = new ArrayList<>();
			for (MenuBean menu2 : findByEqParentId(menu.getId(), list)){
				org.json.JSONObject jsonobj2 = StringUtil.formatJsonObject(new org.json.JSONObject(menu2));
				List<org.json.JSONObject> list3 = new ArrayList<>();
				for (MenuBean menu3 : findByEqParentId(menu2.getId(), list)){
					org.json.JSONObject jsonobj3 = StringUtil.formatJsonObject(new org.json.JSONObject(menu3));
					list3.add(jsonobj3);
				}
				jsonobj2.put("children", list3);
				list2.add(jsonobj2);
			}
			jsonobj.put("children", list2);
			rootJson.add(jsonobj);
		}
		return new JSONArray(rootJson);
	}
	/**
	 * 根据父类查询子一代类
	 * @param parentId                  [必填]
	 * @return
	 */
	private List<MenuBean> findByEqParentId(String parentId, List<MenuBean> menuList_user){
		List<MenuBean> resultList = new ArrayList<>();
		if (StringUtils.isEmpty(parentId)){
			return resultList;
		}
		for (MenuBean deptBean : menuList_user){
			if (parentId.equals(deptBean.getParentId())){
				resultList.add(deptBean);
			}
		}
		return resultList;
	}
	@Override
	public List<MenuBean> findMenuBeanList() throws WebMessageException{
		List<MenuBean> menuBeanList = menuBeanMapper.findAll();
		return menuBeanList;
	}

	@Override
	public void doCacheMenu() {
		SysMenuVo.clearCache();
		//缓存菜单
		SysMenuVo.setSysMenuBeanList(menuBeanMapper.findAll());
		System.out.println("菜单缓存成功！");
	}

	@Override
	public List<MenuBean> findOneLevelMenuByParentId(String parentId) throws WebMessageException {
		if (CommonValidate.isEmpty(parentId)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		return menuBeanMapper.findOneLevelMenuByParentId(parentId);
	}
}
