package com.action;

import com.constant.Url;
import com.model.bean.InvestigationSupAlarmBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CJService;
import com.service.CriminalService;
import com.service.InvestigationSupAlarmService;
import com.service.JJService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Action(value = Url.INVESTIGATIONSUPALARM)
public class InvestigationSupAlarmAction extends BaseAction<InvestigationSupAlarmBean> implements ModelDriven<InvestigationSupAlarmBean> {
    private InvestigationSupAlarmBean bean = new InvestigationSupAlarmBean();

    @Override
    public InvestigationSupAlarmBean getModel() {
        return bean;
    }

    @Autowired
    private InvestigationSupAlarmService investigationSupAlarmService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private JJService jjService;
    @Autowired
    private CJService cjService;

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示-分页
     * 受立案-异常警情-未确认
     * PROCESSSTATUS 可疑信息处理状态，1：未确认，2：已确认异常，3：已确认无异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONSUPALARM_NO_ACCEPT_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForSuspic/no_accpet_show.jsp")})
    public String showNoAcceptPage() {
        //设置未确定参数
        bean.setProcessStatus("1");
        //查询数据
        investigationSupAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页
     * 受立案-异常警情-已确认异常
     * PROCESSSTATUS 可疑信息处理状态，1：未确认，2：已确认异常，3：已确认无异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONSUPALARM_ACCEPT_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForSuspic/accept_show.jsp")})
    public String showAcceptPage() {
        //设置未确定参数
        bean.setProcessStatus("2");
        //查询数据
        investigationSupAlarmService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        //request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 展示-分页
     * 受立案-异常警情-已确认异常
     * PROCESSSTATUS 可疑信息处理状态，1：未确认，2：已确认异常，3：已确认无异常
     * @return
     */
    @Action(value = Url.INVESTIGATIONSUPALARM_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForSuspic/show.jsp")})
    public String showPage() {
        //设置未确定参数
        bean.setProcessStatus("3");
        //查询数据
        investigationSupAlarmService.pageQuery(getPageBean(), bean);
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
    @Action(value = Url.INVESTIGATIONSUPALARM_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/investigation/alarmAnalyseForSuspic/detail.jsp")})
    public String getInvestigationExpAlarmById() throws Exception {
        try {
            InvestigationSupAlarmBean bean2 = investigationSupAlarmService.findInvestigationSupAlarmById(bean.getSuspicId());
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
