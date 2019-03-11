package com.action;

import com.alibaba.fastjson.JSONObject;
import com.model.InvolvedStoresBox;
import com.model.InvolvedStoresBox;
import com.model.InvolvedStoresLockers;
import com.model.User;
import com.model.bean.InvolvedStoresBoxBean;
import com.model.bean.InvolvedStoresLockersBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InvolvedStoresBoxService;
import com.service.InvolvedStoresLockersService;
import com.utils.ExecuteResult;
import com.utils.StoreUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.opensymphony.xwork2.ActionSupport;
import com.service.InvolvedStoresBoxService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 类名称：InvolvedStoresLockersAction 类描述：储物柜的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.INVOLVED_STORES_LOCKERS)
public class InvolvedStoresLockersAction extends BaseAction<InvolvedStoresLockers> implements ModelDriven<InvolvedStoresLockers> {
    @Autowired
    private InvolvedStoresLockersService service;
    private InvolvedStoresLockersBean bean = new InvolvedStoresLockersBean();

    @Override
    public InvolvedStoresLockersBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.INVOLVED_STORES_LOCKERS_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/locker/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("storeId", bean.getStoreId());
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 仓库柜子树
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_LOCKERS_TREE_SHOW, results = {@Result(name = "INVOLVED_STORES_LOCKERS_TREE", location = Url.VIEWS + "involved/locker/show.jsp")})
    public String index2() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        bean.setIsDelete("0");
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("status", "1");
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "INVOLVED_STORES_LOCKERS_TREE";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_STORES_LOCKERS_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "involved/locker/add_update_show.jsp")})
    public String showAdd() {
        String storeId = request.getParameter("storeId");
        request.setAttribute("storeId",storeId);
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_LOCKERS_ADD_SUBMIT)
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
    @Action(value = Url.INVOLVED_STORES_LOCKERS_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "involved/locker/add_update_show.jsp")})
    public String showEdit() {
        try {
            InvolvedStoresLockersBean resultBean = service.findInvolvedStoresLockersById(bean.getId());
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
    @Action(value = Url.INVOLVED_STORES_LOCKERS_UPDATE_SUBMIT)
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
    @Action(value = Url.INVOLVED_STORES_LOCKERS_DELETE_SUBMIT)
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
    @Action(value = Url.INVOLVED_STORES_LOCKERS_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/locker/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            InvolvedStoresLockersBean bean2 = service.findInvolvedStoresLockersById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultInvolved = e.getMessage();
            request.setAttribute("message", resultInvolved);
        }
        return "SUCCESS";
    }
}
