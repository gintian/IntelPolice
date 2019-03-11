package com.action;

import com.constant.Url;
import com.model.bean.InvestigationRelatedBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CJService;
import com.service.CriminalService;
import com.service.InvestigationRelatedService;
import com.service.JJService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Action(value = Url.INVESTIGATIONRELATED)
public class InvestigationRelatedAction extends BaseAction<InvestigationRelatedBean> implements ModelDriven<InvestigationRelatedBean> {
    private InvestigationRelatedBean bean = new InvestigationRelatedBean();

    @Override
    public InvestigationRelatedBean getModel() {
        return bean;
    }

    @Autowired
    private InvestigationRelatedService investigationRelatedService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private JJService jjService;
    @Autowired
    private CJService cjService;

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示-分页受立案-积案带破
     * PROCESSSTATUS 可疑信息处理状态，1：未确认，2：已确认异常，3：已确认无异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONRELATED_NO_ACCEPT_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForWithBreak/no_accpet_show.jsp")})
    public String showPageNoAccept() {
        //设置为无异常
        bean.setProcessStatus("1");
        //查询数据
        investigationRelatedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-积案带破
     * PROCESSSTATUS 可疑信息处理状态，1：未确认，2：已确认异常，3：已确认无异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONRELATED_ACCEPT_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForWithBreak/accpet_show.jsp")})
    public String showPageAccept() {
        //设置为无异常
        bean.setProcessStatus("2");
        //查询数据
        investigationRelatedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页受立案-积案带破
     * PROCESSSTATUS 可疑信息处理状态，1：未确认，2：已确认异常，3：已确认无异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONRELATED_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForWithBreak/show.jsp")})
    public String showPage() {
        //设置为无异常
        bean.setProcessStatus("3");
        //查询数据
        investigationRelatedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.INVESTIGATIONRELATED_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForWithBreak/detail.jsp")})
    public String getInvestigationExpAlarmById() throws Exception {
        try {
            InvestigationRelatedBean bean2 = investigationRelatedService.findInvestigationRelatedById(bean.getWithBreakId());
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
