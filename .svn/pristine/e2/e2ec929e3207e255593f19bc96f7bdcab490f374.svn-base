package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.WebMessageException;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Url;
import com.model.User;
import com.model.bean.DictoryBean;
import com.model.bean.PermissionBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DictoryService;
import com.service.PermissionService;
import com.utils.ExecuteResult;
import com.utils.SysDictoryVo;

/**
 * 角色action
 */

@Action(value = Url.PERMISSION)
public class PermissionAction extends BaseAction<PermissionBean> implements ModelDriven<PermissionBean> {
    private PermissionBean bean = new PermissionBean();

    @Override
    public PermissionBean getModel() {
        return bean;
    }

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private DictoryService dictoryService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示-分页
     *
     * @return
     */
    @Action(value = Url.PERMISSION_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/permission/show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showPage() {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        try {
            permissionService.pageQuery(getPageBean(), bean, user.getId());
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);

        List<DictoryBean> list = SysDictoryVo.getDictoryBeanList(Integer.valueOf(CommonConstant.DICTORY_TYPE_PERMISSION));
        request.setAttribute("dictorylist", list);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.PERMISSION_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/permission/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showAdd() {
        try {
            List<DictoryBean> list = SysDictoryVo.getDictoryBeanList(Integer.valueOf(CommonConstant.DICTORY_TYPE_PERMISSION));
            request.setAttribute("dictorylist", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.PERMISSION_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            permissionService.addBean(bean);
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
    @Action(value = Url.PERMISSION_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/permission/add_update_show.jsp")})
    public String showEdit() {
        try {
            List<DictoryBean> list = SysDictoryVo.getDictoryBeanList(Integer.valueOf(CommonConstant.DICTORY_TYPE_PERMISSION));
            PermissionBean resultBean = permissionService.findPermissionById(bean.getId());
            request.setAttribute("entity", resultBean);
            request.setAttribute("dictorylist", list);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.PERMISSION_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            permissionService.updateBean(bean.getId(), bean);
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
    @Action(value = Url.PERMISSION_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            permissionService.deleteBean(bean.getId());
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
    @Action(value = Url.PERMISSION_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/permission/detail.jsp")})
    public String getMenuById() throws Exception {
        try {
            PermissionBean bean2 = permissionService.findPermissionById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

}
