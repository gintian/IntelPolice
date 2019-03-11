package com.action;

import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.model.bean.NoticeBean;
import com.opensymphony.xwork2.ActionContext;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.model.Notice;
import com.opensymphony.xwork2.ModelDriven;
import com.service.NoticeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：NoticeAction 类描述：公告的实现
 */
// @ParentPackage("json-default")
@Action(value = Url.NOTICE)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class NoticeAction extends BaseAction<Notice> implements ModelDriven<Notice> {
    @Autowired
    private NoticeService service;
    private NoticeBean bean = new NoticeBean();

    @Override
    public NoticeBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.NOTICE_LIST_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/notice/list.jsp")})
    public String list() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryList(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    @Action(value = Url.NOTICE_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/notice/show.jsp")})
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
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.NOTICE_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "others/notice/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.NOTICE_ADD_SUBMIT)
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
    @Action(value = Url.NOTICE_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "others/notice/add_update_show.jsp")})
    public String showEdit() {
        try {
            NoticeBean resultBean = service.findNoticeById(bean.getId());
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
    @Action(value = Url.NOTICE_UPDATE_SUBMIT)
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
    @Action(value = Url.NOTICE_DELETE_SUBMIT)
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
     * 设置显示/隐藏
     *
     * @throws Exception
     */
    @Action(value = Url.NOTICE_SETLOCKABLE_SUBMIT)
    public void setLookAble() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.setLookAble(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 设置置顶/取消置顶
     *
     * @throws Exception
     */
    @Action(value = Url.NOTICE_SETTOP_SUBMIT)
    public void setTop() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.setTop(bean.getId());
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
    @Action(value = Url.NOTICE_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/notice/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            NoticeBean bean2 = service.findNoticeById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
}