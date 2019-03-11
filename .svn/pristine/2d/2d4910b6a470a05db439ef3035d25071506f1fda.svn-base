package com.action;


import com.activiti.service.InvolvedActivitiService;
import com.alibaba.fastjson.JSONObject;
import com.analysis.model.InvolvedTemp;
import com.constant.Url;
import com.model.Involved;
import com.model.User;
import com.model.bean.InvolvedBean;
import com.model.bean.InvolvedCaseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InvolvedCaseService;
import com.service.InvolvedService;
import com.service.InvolvedTempService;
import com.utils.ActivitiUtils;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import com.utils.SysUserVo;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类名称：InvolvedInfosAction 类描述：涉案财物信息表的实现
 */
@Action(value = Url.INVOLVED_TEMP)
public class InvolvedTempAction extends BaseAction<InvolvedTemp> implements ModelDriven<InvolvedTemp> {
    private HttpServletRequest request = ServletActionContext.getRequest();
    ActionContext context = ActionContext.getContext();

    private InvolvedTemp bean = new InvolvedTemp();

    @Override
    public InvolvedTemp getModel() {
        return bean;
    }
    @Autowired
    private  InvolvedService involvedService;

    @Autowired
    private InvolvedTempService involvedTempService;

    @Autowired
    private  InvolvedCaseService involvedCaseService;

    /**
     * 展示页面-根据案件
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TEMP_CASE_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/temp/show.jsp")})
    public String noSubmitKeep() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);

        //查询数据
        involvedTempService.pageQueryByCaseId(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("caseid", bean.getCaseid());
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }
    /**
     * 同步-根据案件
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TEMP_CASE_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            String[] ids = request.getParameterValues("ids");
            String caseid = request.getParameter("caseid");
            for (int i = 0; i < ids.length; i++){
                InvolvedTemp involvedTemp = involvedTempService.findInvolvedTempById(ids[i]);
                InvolvedBean involved = new InvolvedBean();
//                involved.setId();//涉案id
                involved.setCwbm(RandomUtils.RandomCode("CW", user.getDeptId()));//财物编号
                involved.setCwmc(involvedTemp.getObjectname());//财物名称
                involved.setDjsj(involvedTemp.getCreatetime());//登记时间
//                involved.setDjryId();//登记人员ID1
//                involved.setDjryzh();//登记人员账号
//                involved.setLrry();//登记人员
//                involved.setDjrydw();//登记人员单位ID
//                involved.setDjrydw();//登记人员单位机构
//                involved.setCwflCode();//财物分类code
//                involved.setKyyy();//扣押原因
                involved.setCwwz(involvedTemp.getPersonname());//财物物主
                involved.setWzxx(involvedTemp.getPersoninfo());//物主信息
                involved.setCwsl(involvedTemp.getAmounts());//物品数量
//                involved.setCwjz();//财物价值
                involved.setCwtz(involvedTemp.getCharacteristic());//财物特征
                involved.setBz(involvedTemp.getAnnex());//财物备注
//                involved.setIsBgsp();//是否经过保管审批0：不通过，1：本单位保管，2、警务保障室保管
//                involved.setClbhcs();//处理驳回次数
//                involved.setBgbhcs();//保管驳回次数
//                involved.setBgdqsj();//保管到期时间
//                involved.setIsSa();//财物是否涉案
//                involved.setIsDelete();//是否删除0，正常，1，已删除
//                involved.setIsEdit();//是否申请修改0：默认，1、申请、2、可修改、3、驳回
//                involved.setIsEditInFile();//是否申请入库图片0：默认，1、申请、2、可修改、3、驳回
//                involved.setIsEditOutFile();//是否申请修改出库附件0：默认，1、申请、2、可修改、3、驳回
//                involved.setIsEditFinishFile();//是否申请修改完成处理附件0：默认，1、申请、2、可修改、3、驳回
//                involved.setLeaderProcessId();//所领导审批ID只记录最新的一次审批
//                involved.setLawerProcessId();//法制审批ID只记录最新的一次审批
//                involved.setOfficeProcessId();//局领导审批ID只记录最新的一次审批
//                involved.setObjId();//案事件系统财物序号
//                involved.setProcessMode();//处置方式
//                involved.setApproveState();//保管状态0为默认，1为正在保管工作流过程，2为保管完成
//                involved.setDisposeState();//处置状态0为默认，1为正在处理工作流过程，2为处理完成
//                involved.setStoreState();//库存状态0为默认，1为已经入库，2为移交，3为出库，4提取，5为已处理
                String involvedId = involvedService.addBean(involved);
                InvolvedCaseBean involvedCaseBean = new InvolvedCaseBean();
                involvedCaseBean.setCaseId(caseid);
                involvedCaseBean.setInvolvedId(involvedId);
                involvedCaseService.addBean(involvedCaseBean);
            }
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
