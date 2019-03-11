package com.action;

import com.alibaba.fastjson.JSONObject;
import com.model.User;
import com.model.bean.DeptBean;
import com.model.bean.JJBean;
import com.model.bean.MessageBean;
import com.opensymphony.xwork2.ActionContext;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.model.Message;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：MessageAction 类描述：消息的实现
 */
@SuppressWarnings("serial")
// @ParentPackage("json-default")
@Action(value = Url.MESSAGE)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class MessageAction extends BaseAction<Message> implements ModelDriven<Message> {
    @Autowired
    private MessageService service;
    private MessageBean bean = new MessageBean();

    @Override
    public MessageBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 回收站
     *
     * @throws Exception
     */
    @Action(value = Url.MESSAGE_RECOVER_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/message/recovery_show.jsp")})
    public String recovery() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        bean.setStatus("0");
        bean.setReceiveUserId(user.getId());
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
     * 回收，还原
     *
     * @throws Exception
     */
    @Action(value = Url.MESSAGE_RECOVER_SUBMIT)
    public void recover() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.recoverBean(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 刷新未读消息数量
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.MESSAGE_REFRESH_SUBMIT)
    public void refresh() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            service.pageQueryNoRead(getPageBean(), bean, user.getId());
//            request.getSession().removeAttribute("messageNum");
            int messageNum = pageBean.getTotal();
            request.getSession().setAttribute("messageNum", messageNum);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
            jsonObject.put("messageNum", messageNum + "");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 消息发送管理
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.MESSAGE_SEND_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/message/send_show.jsp")})
    public String sendMessage() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        bean.setCreateUserId(user.getId());
        bean.setStatus("1");
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
     * 首页未读信息展示
     * @return
     * @throws Exception
     */
    @Action(value = Url.MESSAGE_INDEX_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/message/index_show.jsp")})
    public String indexNoRead() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        bean.setReceiveUserId(user.getId());
        bean.setStatus("1");
        bean.setIsVisit("0");
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    @Action(value = Url.MESSAGE_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/message/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        bean.setReceiveUserId(user.getId());
        bean.setStatus("1");
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
    @Action(value = Url.MESSAGE_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "others/message/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.MESSAGE_ADD_SUBMIT)
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
    @Action(value = Url.MESSAGE_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "others/message/add_update_show.jsp")})
    public String showEdit() {
        try {
            MessageBean resultBean = service.findMessageById(bean.getId());
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
    @Action(value = Url.MESSAGE_UPDATE_SUBMIT)
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
    @Action(value = Url.MESSAGE_DELETE_SUBMIT)
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
    @Action(value = Url.MESSAGE_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/message/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            //设置此条信息为已查看
            service.setLooked(bean.getId());
            MessageBean bean2 = service.findMessageById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

}
