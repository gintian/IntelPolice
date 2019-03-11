package com.test;

import com.model.UserRole;
import com.model.bean.MenuBean;
import com.model.bean.UserRoleBean;
import com.model.mapper.UserRoleMapper;
import com.service.DictoryService;
import com.service.InvolvedTaskService;
import com.service.mapper.*;
import com.utils.ActivitiUtils;
import com.utils.SpringContextHolder;
import com.utils.StringUtil;
import com.utils.SysMenuVo;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class TestUser {
	private UserService userService;
	private UserRoleBeanMapper userRoleBeanMapper;
	private UserRoleMapper userRoleMapper;
	private UserBeanMapper userBeanMapper;
	private DeptBeanMapper deptBeanMapper;
	private DictoryService dictoryService;
	private MenuBeanMapper menuBeanMapper;
	private RoleMenuBeanMapper roleMenuBeanMapper;
	private InvolvedTaskService involvedTaskService;

	/**
	* 这个 before 方法在所有的测试方法之前执行，并且只执行一次
	* 所有做 Junit 单元测试时一些初始化工作可以在这个方法里面进行
	* 比如在 before 方法里面初始化 ApplicationContext 和 userService
	*/
	@Before
	public void before(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new
				String[]{"applicationContext.xml"});
//		userService = (UserService) ac.getBean("userService");
//		userRoleBeanMapper = ac.getBean(UserRoleBeanMapper.class);
//		userBeanMapper = ac.getBean(UserBeanMapper.class);
//		deptBeanMapper = ac.getBean(DeptBeanMapper.class);
//		dictoryService = ac.getBean(DictoryService.class);
//		menuBeanMapper = ac.getBean(MenuBeanMapper.class);
//		roleMenuBeanMapper = ac.getBean(RoleMenuBeanMapper.class);
//		involvedTaskService = ac.getBean(InvolvedTaskService.class);
//		baseActivitiService = ac.getBean(BaseActivitiService.class);
	}
	@Test
	public void test022(){
		ActivitiUtils.deleteProcessDefinitionByDeploymentId(null);
	}

	private List<MenuBean> menuList = new ArrayList<>();
	private List<String> listMenuIds = new ArrayList<>();

	@Test
	public void test01(){
		SysMenuVo.setSysMenuBeanList(menuBeanMapper.findAll());
		String resultJson= "";
		try {
			try {
				if (!false){//超级管理员，返回所有的菜单
					//查询当前用户的所有角色
					List<UserRoleBean> userRoles = userRoleBeanMapper.selectRolesByUserId("52000010000004");
					List<String> roleids = new ArrayList<>();
					for (UserRole userRole: userRoles){
						roleids.add(userRole.getRoleId());
					}
					if (!roleids.isEmpty()){
						listMenuIds = roleMenuBeanMapper.getModelListByRoleIds(roleids);
					}
					for (String menuId : listMenuIds){
						MenuBean menuBean = SysMenuVo.findById(menuId);
						if (null != menuBean) {
							menuList.add(menuBean);
						}
					}
				}else {
					menuList = SysMenuVo.findAll();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONArray jsonArray = formatJsonToMenu();
			resultJson = jsonArray.toString();
			System.out.println(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将数据库的json 字符串转为菜单需要的字符串
	 *
	 */
	private org.json.JSONArray formatJsonToMenu(){
		//查询顶级菜单
		List<org.json.JSONObject> rootJson = new ArrayList<>();
		for (MenuBean menu : findByEqParentId("01")){
			org.json.JSONObject jsonobj = StringUtil.formatJsonObject(new org.json.JSONObject(menu));
			List<org.json.JSONObject> list2 = new ArrayList<>();
			for (MenuBean menu2 : findByEqParentId(menu.getId())){
				org.json.JSONObject jsonobj2 = StringUtil.formatJsonObject(new org.json.JSONObject(menu2));
				List<org.json.JSONObject> list3 = new ArrayList<>();
				for (MenuBean menu3 : findByEqParentId(menu2.getId())){
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
	private List<MenuBean> findByEqParentId(String parentId){
		List<MenuBean> resultList = new ArrayList<>();
		if (StringUtils.isEmpty(parentId)){
			return resultList;
		}
		for (MenuBean deptBean : menuList){
			if (parentId.equals(deptBean.getParentId())){
				resultList.add(deptBean);
			}
		}
		return resultList;
	}

}
