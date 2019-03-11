package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.ArchiveStoresBox;
import com.model.ArchiveStoresLockers;
import com.model.User;
import com.model.bean.ArchiveStoresBean;
import com.model.bean.ArchiveStoresLockersBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ArchiveStoresLockersService;
import com.service.ArchiveStoresService;
import com.utils.ExecuteResult;
import com.utils.StoreUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：ArchiveAction 类描述：消息的实现
 */
@SuppressWarnings("serial")
// @ParentPackage("json-default")
@Action(value = Url.ARCHIVE_STORES_LOCKERS)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class ArchiveStoresLockersAction extends BaseAction<ArchiveStoresLockers> implements ModelDriven<ArchiveStoresLockers> {
    @Autowired
    private ArchiveStoresLockersService service;
    @Autowired
    private ArchiveStoresService archiveStoresService;


    private ArchiveStoresLockersBean bean = new ArchiveStoresLockersBean();

    @Override
    public ArchiveStoresLockersBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();


    @Action(value = Url.ARCHIVE_STORES_LOCKERS_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesLockers/show.jsp")})
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
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_TREE_SHOW, results = {@Result(name = "ARCHIVE_STORES_LOCKERS_TREE", location = Url.VIEWS + "archive/storesLockers/show.jsp")})
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
        return "INVOLVED_STORES_LOCKERS_TREE";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesLockers/add_update_show.jsp")})
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
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_ADD_SUBMIT)
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
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesLockers/add_update_show.jsp")})
    public String showEdit() {
        try {
            ArchiveStoresLockersBean resultBean = service.findInvolvedStoresLockersById(bean.getLockersId());
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
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_UPDATE_SUBMIT)
    public void update() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.updateBean(bean.getLockersId(), bean);
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
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_DELETE_SUBMIT)
    public void delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.deleteBean(bean.getLockersId());
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
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesLockers/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            ArchiveStoresLockersBean bean2 = service.findInvolvedStoresLockersById(bean.getLockersId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultInvolved = e.getMessage();
            request.setAttribute("message", resultInvolved);
        }
        return "SUCCESS";
    }
/*
    @Action(value = Url.ARCHIVE_STORES_LOCKERS_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesBox/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        ArchiveStoresBean archiveStoresBean = archiveStoresService.findArchiveStoresById(bean.getArchiveStoresId());
        request.setAttribute("archiveStores",archiveStoresBean);
        return "SUCCESS";
    }

    @Action(value = Url.ARCHIVE_STORES_LOCKERS_PAGE_DATA)
    public void index1() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        if (bean.getArchiveStoresId()!=null){
            request.setAttribute("storesId",bean.getArchiveStoresId());
        }
        response.getWriter().write(jsonObject.toJSONString(entityList));
    }
    *//**
     * 添加页面
     *
     * @return
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesBox/add_update_show.jsp")})
    public String showAdd() {
        String storesId = request.getParameter("storesId");
        request.setAttribute("storesId",storesId);
        return "SUCCESS";
    }

    *//**
     * 新增
     *
     * @throws Exception
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_ADD_SUBMIT)
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

    *//**
     * 修改页面
     *
     * @return
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesBox/add_update_show.jsp")})
    public String showEdit() {
        try {
            ArchiveStoresBoxBean resultBean = service.findArchiveStoresBoxById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    *//**
     * 编辑
     *
     * @throws Exception
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_UPDATE_SUBMIT)
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

    *//**
     * 删除
     *
     * @throws Exception
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_DELETE_SUBMIT)
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

    *//**
     * 详情展示
     *
     * @throws Exception
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesBox/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            ArchiveStoresBoxBean bean2 = service.findArchiveStoresBoxById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultArchive = e.getMessage();
            request.setAttribute("message", resultArchive);
        }
        return "SUCCESS";
    }
    */
    /**
     * 开锁
     *
     * @throws Exception
     *//*
    @Action(value = Url.ARCHIVE_STORES_BOX_OPEN_BOX)
    public void openBox() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            StoreUtil.openBox(Integer.parseInt(bean.getCode()),"10.164.22.219");
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }*/
}
