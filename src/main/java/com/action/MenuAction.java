package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.bean.MenuBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.MenuService;
import com.utils.ExecuteResult;

/**
 * 绫诲悕绉帮細LoginAction
 * 绫绘弿杩帮細鐢ㄦ埛鎺у埗鍣ㄧ殑瀹炵幇
 */
@Action(value = Url.MENU)
public class MenuAction extends ActionSupport implements ModelDriven<MenuBean> {
    private MenuBean bean = new MenuBean();

    @Override
    public MenuBean getModel() {
        return bean;
    }

    @Autowired
    private MenuService menuService;
    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = context.getSession();

    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 显示菜单视图
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.MENU_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = "/WEB-INF/views/menu/show.jsp")})
    public String menuListTree() throws Exception {
        List<MenuBean> menuBeanList = menuService.findMenuBeanList();
        request.setAttribute("menuBeanList", menuBeanList);
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.MENU_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/menu/add_update_show.jsp")})
    public String showAdd() {
        try {
            request.setAttribute("entity", bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.MENU_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            menuService.addMenuBean(bean);
            menuService.doCacheMenu();
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
    @Action(value = Url.MENU_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/menu/add_update_show.jsp")})
    public String showUpdate() {
        try {
            MenuBean menuBean = menuService.findMenuByMenuId(bean.getId());
            request.setAttribute("entity", menuBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.MENU_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            menuService.updateMenuBean(bean.getId(), bean);
            menuService.doCacheMenu();
            //返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);

        } catch (Exception e) {
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
    @Action(value = Url.MENU_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            menuService.deleteMenuBean(bean.getId());
            menuService.doCacheMenu();
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }


    /**
     * 显示菜单字符串
     *
     * @throws Exception
     */
    @Action(value = Url.MENU_ALL_LIST)
    public void getMenuAll() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        String menulist = "";
        try {
            menulist = menuService.showMenuAll(request);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write(menulist);
    }
}
