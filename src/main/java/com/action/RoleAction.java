package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constant.CommonConstant;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.constant.Indicator;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.User;
import com.model.bean.DeptBean;
import com.model.bean.DictoryBean;
import com.model.bean.MenuBean;
import com.model.bean.PermissionBean;
import com.model.bean.RoleBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DeptService;
import com.service.MenuService;
import com.service.PermissionService;
import com.service.RoleService;
import com.utils.ExecuteResult;
import com.utils.SysDictoryVo;

/**
 * 角色action
 */

@Action(value = Url.ROLE)
public class RoleAction extends BaseAction<RoleBean> implements ModelDriven<RoleBean> {
    private RoleBean bean = new RoleBean();

    @Override
    public RoleBean getModel() {
        return bean;
    }

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private DeptService deptService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();

    /**
     * 展示-分页
     *
     * @return
     */
    @Action(value = Url.ROLE_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showPage() {
        try {
            //查询数据
            roleService.pageQuery(getPageBean(), bean, getCurrentUserBean(request));
            //获取分页数据
            List entityList = pageBean.getRows();
            //填充查询对象
            request.setAttribute("searchObj", bean);
            //填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.ROLE_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showAdd() {
        try {
            List<DeptBean> deptBeanList = deptService.findDeptBeanListByCurrentUser(getUser(request));
            request.setAttribute("deptBeanList", deptBeanList);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_ADD_SUBMIT)
    public void addMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            roleService.addBean(bean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.ROLE_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showEdit() {
        try {
            List<DeptBean> deptBeanList = deptService.findDeptBeanListByCurrentUser(getUser(request));
            request.setAttribute("deptBeanList", deptBeanList);
            RoleBean resultBean = roleService.findRoleById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            roleService.updateBean(bean.getId(), bean, getCurrentUserBean(request));
            //返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);

        } catch (WebMessageException e) {
            //返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            roleService.deleteBean(bean.getId(), getCurrentUserBean(request));
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }


    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/detail.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String getMenuById() throws Exception {
        try {
            RoleBean bean2 = roleService.findRoleById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            e.printStackTrace();
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 展示权限页面
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_UPDATE_PERMISSION_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/update_permission_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String updatePermissionShow() throws Exception {
        try {
            //所有的权限列表
            List<PermissionBean> beanList = permissionService.findAllPermissionBean();
            //当前角色的权限ids
            List<String> permissionIds = roleService.findPermissionByRoleId(bean.getId());
            //所有权限类型列表
            List<DictoryBean> dictoryBeanList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(Indicator.PERMISSION_TYPE.getCode()));
            request.setAttribute("dictoryBeanList", dictoryBeanList);
            request.setAttribute("permissionIds", permissionIds);
            request.setAttribute("beanList", beanList);
            request.setAttribute("roleId", bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 提交修改角色_权限
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_UPDATE_PERMISSION_SUBMIT)
    public void updatePermissionSubmit() throws Exception {
        JSONObject jsonObject = null;
        try {
            roleService.updatePermissionByRoleId(bean.getPermissoinIds(), bean.getId(), getUser(request));
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 展示角色菜单页面
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_UPDATE_MENU_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/update_menu_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String updateMenuShow() throws Exception {
        try {
            //查询所有的菜单
            List<MenuBean> menuBeanList = menuService.findMenuBeanList();
            //查询当前角色拥有的菜单
            List<String> menuIds = roleService.findMenuIdsByRoleIds(bean.getId());

            request.setAttribute("menuIds", menuIds);
            request.setAttribute("menuBeanList", menuBeanList);
            request.setAttribute("roleId", bean.getId());
        } catch (WebMessageException e) {
            e.printStackTrace();
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
            return "ERROR";
        }
        return "SUCCESS";
    }

	/**
	 * 部门树 展示 页面
	 * @throws Exception
	 */
	@Action(value = Url.ROLE_DEPT_TREE_SHOW,
			results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/role/dept_tree2.jsp"),
					@Result(name = "ERROR", location = "/sys_error.jsp")})
	public String deptTreeShow() throws Exception{
		//根据当前用户查询，部门树
		return "SUCCESS";
	}
    /**
     * 提交修改角色_菜单
     *
     * @throws Exception
     */
    @Action(value = Url.ROLE_UPDATE_MENU_SUBMIT)
    public void updateMenuSubmit() throws Exception {
        JSONObject jsonObject = null;
        try {
            roleService.addRoleMenuList(bean.getId(), bean.getFunIds());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
