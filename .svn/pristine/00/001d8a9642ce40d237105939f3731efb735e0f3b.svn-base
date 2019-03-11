package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.model.bean.ViewDocBean;
import com.page.PageBean;
import com.service.ViewDocService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.model.JJ;
import com.model.User;
import com.model.bean.JJBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.JJService;

/**
 * 类名称：JJAction 类描述：接警单的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.JJ)
public class JJAction extends BaseAction<JJ> implements ModelDriven<JJBean> {
    @Autowired
    private JJService service;
    @Autowired
    private ViewDocService viewDocService;

    private JJBean bean = new JJBean();

    @Override
    public JJBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.JJ_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "/platform/jj/show.jsp")})
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
    @Action(value = Url.JJ_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/jj/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            JJBean bean2 = service.findJJByJjdbh(bean.getJjdbh());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

    /**
     * 未关联接警
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.JJ_UNRELATED_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "/platform/unrelated/show.jsp")})
    public String indexUnrelated() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryUnrelated(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 未录音
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.JJ_NOTRECORDINGS_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "/platform/notRecordings/show.jsp")})
    public String indexNotRecordings() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQueryNotRecordings(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 未关联接警详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.JJ_UNRELATED_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/jj/unrelated/detail.jsp")})
    public String getDetailsUnrelated() throws Exception {
        try {
            JJBean bean2 = service.findJJByJjdbh(bean.getJjdbh());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }


    //查询未关联视频的接警
    @Action(value = Url.JJ_NOTCORRELATE_VIEW_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/jj/notCorrelateView.jsp")})
    public String selectJJNotView() {

        service.pageQueryNotView(getPageBean(), bean);
        List list = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(list, pageBean, request);

        return "SUCCESS";
    }

    //已关联视频的接警
    @Action(value = Url.JJ_CORRELATE_VIEW_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/jj/correlateView.jsp")})
    public String selectJJView() {

        service.pageQueryCorrelateView(getPageBean(), bean);
        List list = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(list, pageBean, request);
        return "SUCCESS";
    }


}
