package com.action;


import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.ViewDoc;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Action(value = Url.VIEWDOC)
public class ViewDocAction extends BaseAction<ViewDocBean> implements ModelDriven<ViewDocBean> {

    @Autowired
    private ViewDocService viewDocService;
    @Autowired
    private EaMediaCaseService eaMediaCaseService;
    @Autowired
    private JJService jjService;
    @Autowired
    private CJService cjService;
    @Autowired
    private CriminalService criminalService;


    private ViewDocBean viewDocBean = new ViewDocBean();
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    //查询所有录音
    @Action(value = "/showAllView")
    public void showAllView() {

        List<ViewDocBean> list = viewDocService.showAllView();
        System.out.println("**********");
        System.out.println(list);
        System.out.println("**********");
        request.setAttribute("list", list);


    }

    //分页查询和模糊查询
    @Action(value = Url.VIEWDOC_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/media/show.jsp")})
    public String pagePage() {

        int docId = viewDocBean.getDocId();
        System.out.println("*******" + docId + "*******");
        viewDocService.pageQuery(this.getPageBean(), viewDocBean);

        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", viewDocBean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);

        return "SUCCESS";
    }

    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.VIEWDOC_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/media/detail.jsp")})
    public String getMenuById() throws Exception {
        try {

            ViewDocBean returnBean = viewDocService.findViewByDocid(viewDocBean.getDocId() + "");

            int docId = returnBean.getDocId();

            EaMediaCaseBean eaMediaCaseBean = eaMediaCaseService.selectByDocid(docId + "");

            request.setAttribute("entity", returnBean);

            String jjdbh = eaMediaCaseBean.getJjdbh();
            JJBean jjBean = null;
            if (jjdbh != null) {
                jjBean = jjService.findJJByJjdbh(jjdbh);
            }
            request.setAttribute("jjBean", jjBean);

            String cjdbh = eaMediaCaseBean.getCjdbh();
            CJBean cjBean = null;
            if (cjdbh != null) {
                cjBean = cjService.findCJByCjdbh(cjdbh);
            }

            request.setAttribute("cjBean", cjBean);


            String caseId = eaMediaCaseBean.getCaseId();
            CriminalBean criminalBean = null;
            if (caseId != null) {
                criminalBean = criminalService.findCriminalById(caseId);
            }
            request.setAttribute("criminalBean", criminalBean);

        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }


    //进入关联录音页面
    @Action(value = Url.VIEWDOC_CORRELATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/media/view_correlate_submit.jsp")})
    public String toCorrelateView() {


        String jjdbh = request.getParameter("jjdbh");
        String cjdbh = request.getParameter("cjdbh");
        String caseid = request.getParameter("caseid");

        request.setAttribute("jjdbh", jjdbh);
        request.setAttribute("cjdbh", cjdbh);
        request.setAttribute("caseid", caseid);

        viewDocService.selectNoCorrelateView(getPageBean(), viewDocBean);

        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", viewDocBean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);

        return "SUCCESS";
    }


    @Action(value = Url.VIEWDOC_CORRELATE_SUBMIT)
    public void viewCorrelate() {

        String jjdbh = request.getParameter("jjdbh");
        String cjdbh = request.getParameter("cjdbh");
        String caseid = request.getParameter("caseid");

        int docId = viewDocBean.getDocId();

        viewDocService.viewCorrelate(viewDocBean, jjdbh, cjdbh, caseid);

    }


    @Action(value = Url.VIEWDOC_ONE_VIEWS_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/media/show.jsp")})
    public String oneCorrelateViewShow() {
        String jjdbh = request.getParameter("jjdbh");
        String cjdbh = request.getParameter("cjdbh");
        String caseid = request.getParameter("caseid");

        viewDocService.selectDocIdByOther(getPageBean(), viewDocBean, jjdbh, cjdbh, caseid);
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", viewDocBean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }


    @Action(value = Url.VIEWDOC_FILE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/media/playVideo.jsp")})
    public String playVideo() {

        return "SUCCESS";
    }

    @Override
    public ViewDocBean getModel() {
        return viewDocBean;
    }
}
