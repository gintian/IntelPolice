package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.model.bean.FKBean;
import com.service.FKService;
import com.service.JJService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.model.CJ;
import com.model.User;
import com.model.bean.CJBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CJService;

/**
 * 类名称：CJAction 类描述：处警单的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.CJ) // 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Namespace("/")
// 使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class CJAction extends BaseAction<CJ> implements ModelDriven<CJ> {
    private CJBean bean = new CJBean();

    @Override
    public CJBean getModel() {
        return bean;
    }

    @Autowired
    private CJService service;
    @Autowired
    private JJService jjService;
    @Autowired
    private FKService fkService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.CJ_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/show.jsp")})
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
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            CJBean bean2 = service.findCJByCjdbh(bean.getCjdbh());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

    /**
     * 超时未反馈
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_TIMEOUT_UNTREATED_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/timeoutUntreted.jsp")})
    public String geTimeoutUntreted() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryByTimeout(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 超时未反馈详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_TIMEOUT_UNTREATED_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/timeoutUntretedDetail.jsp")})
    public String getDetails1() throws Exception {
        try {
            CJBean bean2 = service.findCJAndJJById(bean.getCjdbh());
            request.setAttribute("entity", bean2);
            request.setAttribute("jJbean",jjService.findJJByJjdbh(bean2.getJJBean().getJjdbh()));
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
    /**
     * 多反馈
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_FEEDBACKS_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/feedbacks/show.jsp")})
    public String getFeedbacks() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryFeedbacks(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 多反馈详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_FEEDBACKS_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/feedbacks/detail.jsp")})
    public String getFeedbacksDetails() throws Exception {
        try {
            CJBean bean2 = service.findCJAndJJById(bean.getCjdbh());
            request.setAttribute("entity", bean2);
            request.setAttribute("jJbean",jjService.findJJByJjdbh(bean2.getJJBean().getJjdbh()));
            List<FKBean>  fkdbList=  fkService.findFKByCj(bean.getCjdbh());
            request.setAttribute("fkdbList",fkdbList );
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
    /**
     * 超时未立案
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_TIMEOUT_CSWLA_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/timeout_wla/show.jsp")})
    public String geTimeoutWla() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryCsWla(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 超时未反馈详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_TIMEOUT_CSWLA_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/timeout_wla/detail.jsp")})
    public String getWlaDetails() throws Exception {
        try {
            CJBean bean2 = service.findCJAndJJById(bean.getCjdbh());
            request.setAttribute("entity", bean2);
            request.setAttribute("jJbean",jjService.findJJByJjdbh(bean2.getJJBean().getJjdbh()));
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
    /**
     * 超时立案
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_TIMEOUT_CSLA_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/timeout_la/show.jsp")})
    public String geTimeoutLa() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryCsLa(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 超时立案详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.CJ_TIMEOUT_CSLA_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/timeout_la/detail.jsp")})
    public String getLaDetails() throws Exception {
        try {
            CJBean bean2 = service.findCJAndJJById(bean.getCjdbh());
            request.setAttribute("entity", bean2);
            request.setAttribute("jJbean",jjService.findJJByJjdbh(bean2.getJJBean().getJjdbh()));
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }


    //未关联视频的处警
    @Action(value = Url.CJ_NOTCORRELATE_VIEW_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/notCorrelateView.jsp")})
    public String selectCJNotView() {

        service.pageQueryNotView(getPageBean(), bean);
        List list = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(list, pageBean, request);
        return "SUCCESS";
    }


    //已未关联视频的处警
    @Action(value = Url.CJ_CORRELATE_VIEW_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/cj/correlateView.jsp")})
    public String selectCJView() {

        service.pageQueryCorrelateView(getPageBean(), bean);
        List list = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(list, pageBean, request);
        return "SUCCESS";
    }



}
