package com.action;

import com.alibaba.fastjson.JSONObject;
import com.model.InvolvedStores;
import com.model.User;
import com.model.bean.InvolvedStoresBean;
import com.model.bean.InvolvedStoresBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.service.InvolvedStoresService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：InvolvedStoresAction 类描述：仓库表的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.INVOLVED_STORES)
public class InvolvedStoresAction extends BaseAction<InvolvedStores> implements ModelDriven<InvolvedStores> {
    @Autowired
    private InvolvedStoresService service;
    private InvolvedStoresBean bean = new InvolvedStoresBean();

    @Override
    public InvolvedStoresBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.INVOLVED_STORES_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/store/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 仓库树
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_TREE_SHOW, results = {@Result(name = "INVOLVED_STORES_TREE", location = Url.VIEWS + "involved/store/show.jsp")})
    public String index2() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("status", "1");
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "INVOLVED_STORES_TREE";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_STORES_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "involved/store/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_ADD_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.addBean(bean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_STORES_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "involved/store/add_update_show.jsp")})
    public String showEdit() {
        try {
            InvolvedStoresBean resultBean = service.findInvolvedStoresById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 编辑
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_UPDATE_SUBMIT)
    public void update() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.updateBean(bean.getId(), bean);
            // 返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            // 返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_DELETE_SUBMIT)
    public void delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.deleteBean(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/store/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            InvolvedStoresBean bean2 = service.findInvolvedStoresById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultInvolved = e.getMessage();
            request.setAttribute("message", resultInvolved);
        }
        return "SUCCESS";
    }
}
