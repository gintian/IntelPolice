package com.action;

import com.constant.Url;
import com.model.bean.InvestigationExpAlarmBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CJService;
import com.service.CriminalService;
import com.service.InvestigationExpAlarmService;
import com.service.JJService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Action(value = Url.INVESTIGATIONEXPALARM)
public class InvestigationExpAlarmAction extends BaseAction<InvestigationExpAlarmBean> implements ModelDriven<InvestigationExpAlarmBean> {
    private InvestigationExpAlarmBean bean = new InvestigationExpAlarmBean();

    @Override
    public InvestigationExpAlarmBean getModel() {
        return bean;
    }

    @Autowired
    private InvestigationExpAlarmService investigationExpAlarmService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private JJService jjService;
    @Autowired
    private CJService cjService;

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示-分页受立案-异常警情-正常警情
     * ALARMTYPE 警情类型，0：无需处理警情，1：预警警情，2：需要处理警情，3：正常警情
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/show.jsp")})
    public String showPage() {
        //设置正常警情
        bean.setAlarmType("3");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-无需处理
     * ALARMTYPE 警情类型，0：无需处理警情，1：预警警情，2：需要处理警情，3：正常警情
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_NO_DISPOSE_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/no_dispose_show.jsp")})
    public String showPageNoDispose() {
        //设置无需处理警情
        bean.setAlarmType("0");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-未处理
     * PROCESSSTATUS 异常警情处置状态，分为四类：1：未处理异常、2：已告知异常:3：待复核异常，4：已处理异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_NO_ACCEPT_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/no_accept_show.jsp")})
    public String showPageNoAccept() {
        //设置未处理警情
        bean.setProcessStatus("1");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-已告知
     * PROCESSSTATUS 异常警情处置状态，分为四类：1：未处理异常、2：已告知异常:3：待复核异常，4：已处理异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_INFORM_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/inform_show.jsp")})
    public String showPageInform() {
        //设置未处理警情
        bean.setProcessStatus("2");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-待复核
     * PROCESSSTATUS 异常警情处置状态，分为四类：1：未处理异常、2：已告知异常:3：待复核异常，4：已处理异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_NO_REVIEW_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/no_review_show.jsp")})
    public String showPageNoReview() {
        //设置待复核警情
        bean.setProcessStatus("3");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-已处理
     * PROCESSSTATUS 异常警情处置状态，分为四类：1：未处理异常、2：已告知异常:3：待复核异常，4：已处理异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_ACCEPT_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/accept_show.jsp")})
    public String showPageAccept() {
        //设置已处理警情
        bean.setProcessStatus("4");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-超时未受立行政案件
     * CASECLASS 类型，0：刑事，1：行政
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_TIMEOUT_XZ_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/timeout_xz_show.jsp")})
    public String showPageTimeOutXZ() {
        //设置超时未受立行政案件
        bean.setCaseClass("2");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-异常警情-超时未受立行事案件
     * CASECLASS 类型，0：刑事，1：行政
     * @return
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_TIMEOUT_XS_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/timeout_xs_show.jsp")})
    public String showPageTimeOutXS() {
        //设置超时未受立行事案件
        bean.setCaseClass("1");
        //查询数据
        investigationExpAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.INVESTIGATIONEXPALARM_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmManage/detail.jsp")})
    public String getInvestigationExpAlarmById() throws Exception {
        try {
            InvestigationExpAlarmBean bean2 = investigationExpAlarmService.findInvestigationExpAlarmById(bean.getExceptionId());
            if(bean2.getCaseId() != null && bean2.getCaseId().length() > 0){
                bean2.setCriminal(criminalService.findCriminalById(bean2.getCaseId()));
            }

            if(bean2.getJjdbh() != null && bean2.getJjdbh().length() > 0){
                bean2.setJj(jjService.findJJByJjdbh(bean2.getJjdbh()));
            }
            if(bean2.getCjdbh() != null && bean2.getCjdbh().length() > 0){
                bean2.setCj(cjService.findCJByCjdbh(bean2.getCjdbh()));
            }

            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

}
