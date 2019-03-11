package com.action;


import com.activiti.service.InvolvedActivitiService;
import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.Involved;
import com.model.User;
import com.model.bean.InvolvedBean;
import com.model.bean.InvolvedCaseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InvolvedCaseService;
import com.service.InvolvedService;
import com.utils.ActivitiUtils;
import com.utils.ExecuteResult;
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
@Action(value = Url.INVOLVED_INFOS)
public class InvolvedTaskAction extends BaseAction<Involved> implements ModelDriven<InvolvedBean> {
    private HttpServletRequest request = ServletActionContext.getRequest();
    ActionContext context = ActionContext.getContext();

    private InvolvedBean bean = new InvolvedBean();

    @Override
    public InvolvedBean getModel() {
        return bean;
    }

    @Autowired
    private InvolvedActivitiService involvedActivitiService;

    @Autowired
    private InvolvedService involvedService;

    @Autowired
    private InvolvedCaseService involvedCaseService;

    /********************************************************************* 流程展示 *********************************************************************/

/**-------------------------------保管-------------------------------*/
    /*-------------------------------保管（办案人员）-------------------------------*/

    /**
     * 未提交保管的财物
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_KEEP_NO_SUBMIT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepapply/keep_no_submit_show.jsp")})
    public String noSubmitKeep() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setApproveState("0");        //未进行保管流程
        bean.setDisposeState("0");        //未进行处置流程
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 待完成任务(办案人员保管)
     */
    @Action(value = Url.INVOLVED_KEEP_NO_FINISH_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepapply/keep_no_finish_show.jsp")})
    public String currentKeep() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
            involved.setTaskId(task.getId());
            involved.setTaskName(task.getName());
            involved.setStartTime(task.getCreateTime());
            involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
            List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
            if (comments.size() > 0) {
                Comment comment = comments.get(0);
                String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                String remark = comment.getFullMessage();
                if (remark != null) {
                    involved.setRemark("（" + assigneeName + "）：" + remark);
                } else {
                    involved.setRemark("（" + assigneeName + "）无批注");
                }
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(办案人员保管)
     */
    @Action(value = Url.INVOLVED_KEEP_FINISHED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepapply/keep_finished_show.jsp")})
    public String historyKeep() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }


    /*-------------------------------保管（法制）-------------------------------*/

    /**
     * 待完成任务(法制保管)
     */
    @Action(value = Url.INVOLVED_KEEP_FZ_NO_ADOPT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepadopt/keep_no_adopt_show.jsp")})
    public String keepFzNoAdopt() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().equals("法制保管审批")) {
                InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
                involved.setTaskId(task.getId());
                involved.setTaskName(task.getName());
                involved.setStartTime(task.getCreateTime());
                involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
                List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
                if (comments.size() > 0) {
                    Comment comment = comments.get(0);
                    String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                    String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                    String remark = comment.getFullMessage();
                    if (remark != null) {
                        involved.setRemark("（" + assigneeName + "）：" + remark);
                    } else {
                        involved.setRemark("（" + assigneeName + "）无批注");
                    }
                }
                involveds.add(involved);
            }
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "法制");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(法制保管)
     */
    @Action(value = Url.INVOLVED_KEEP_FZ_ADOPTED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepadopt/keep_adopted_show.jsp")})
    public String keepFzAdopted() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setIdentityCard(ActivitiUtils.getVariableByProcessId(process.getId(), "caseUser").toString());
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "法制");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /*-------------------------------保管（领导）-------------------------------*/

    /**
     * 待完成任务(领导保管)
     */
    @Action(value = Url.INVOLVED_KEEP_LD_NO_ADOPT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepadopt/keep_no_adopt_show.jsp")})
    public String keepLdNoAdopt() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().equals("领导保管审批")) {
                InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
                involved.setTaskId(task.getId());
                involved.setTaskName(task.getName());
                involved.setStartTime(task.getCreateTime());
                involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
                List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
                if (comments.size() > 0) {
                    Comment comment = comments.get(0);
                    String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                    String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                    String remark = comment.getFullMessage();
                    if (remark != null) {
                        involved.setRemark("（" + assigneeName + "）：" + remark);
                    } else {
                        involved.setRemark("（" + assigneeName + "）无批注");
                    }
                }
                involveds.add(involved);
            }
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "领导");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(领导保管)
     */
    @Action(value = Url.INVOLVED_KEEP_LD_ADOPTED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepadopt/keep_adopted_show.jsp")})
    public String keepLdAdopted() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setIdentityCard(ActivitiUtils.getVariableByProcessId(process.getId(), "caseUser").toString());
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "领导");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 待完成任务(财务保管人员入库)
     */
    @Action(value = Url.INVOLVED_KEEP_NO_KEEP_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepadopt/keep_no_keep_show.jsp")})
    public String keepBgNoAdopt() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().equals("财务保管人员入库")) {
                InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
                involved.setTaskId(task.getId());
                involved.setTaskName(task.getName());
                involved.setStartTime(task.getCreateTime());
                involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
                List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
                if (comments.size() > 0) {
                    Comment comment = comments.get(0);
                    String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                    String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                    String remark = comment.getFullMessage();
                    if (remark != null) {
                        involved.setRemark("（" + assigneeName + "）：" + remark);
                    } else {
                        involved.setRemark("（" + assigneeName + "）无批注");
                    }
                }
                involveds.add(involved);
            }
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(财务保管人员入库)
     */
    @Action(value = Url.INVOLVED_KEEP_KEEPED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keepadopt/keep_keeped_show.jsp")})
    public String keepBgAdopted() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedApprove", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setIdentityCard(ActivitiUtils.getVariableByProcessId(process.getId(), "caseUser").toString());
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

/**-------------------------------处置-------------------------------*/
    /*-------------------------------处置（办案人员）-------------------------------*/

    /**
     * 未提交处置的财物
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_DISPOSE_NO_SUBMIT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeapply/dispose_no_submit_show.jsp")})
    public String noSumitDispose() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setApproveState("0");        //未进行保管流程
        bean.setDisposeState("0");        //未进行处置流程
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }


    /**
     * 待完成任务(办案人员处置)
     */
    @Action(value = Url.INVOLVED_DISPOSE_NO_FINISH_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeapply/dispose_no_finish_show.jsp")})
    public String currentDispose() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedDispose", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
            involved.setTaskId(task.getId());
            involved.setTaskName(task.getName());
            involved.setStartTime(task.getCreateTime());
            involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
            List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
            if (comments.size() > 0) {
                Comment comment = comments.get(0);
                String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                String remark = comment.getFullMessage();
                if (remark != null) {
                    involved.setRemark("（" + assigneeName + "）：" + remark);
                } else {
                    involved.setRemark("（" + assigneeName + "）无批注");
                }
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(办案人员处置)
     */
    @Action(value = Url.INVOLVED_DISPOSE_FINISHED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeapply/dispose_finished_show.jsp")})
    public String historyDispose() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedDispose", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }


    /*-------------------------------处置（法制）-------------------------------*/

    /**
     * 待完成任务(法制处置)
     */
    @Action(value = Url.INVOLVED_DISPOSE_FZ_NO_ADOPT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeadopt/dispose_no_adopt_show.jsp")})
    public String disposeFzNoAdopt() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedDispose", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().equals("法制处置审批")) {
                InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
                involved.setTaskId(task.getId());
                involved.setTaskName(task.getName());
                involved.setStartTime(task.getCreateTime());
                involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
                List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
                if (comments.size() > 0) {
                    Comment comment = comments.get(0);
                    String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                    String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                    String remark = comment.getFullMessage();
                    if (remark != null) {
                        involved.setRemark("（" + assigneeName + "）：" + remark);
                    } else {
                        involved.setRemark("（" + assigneeName + "）无批注");
                    }
                }
                involveds.add(involved);
            }
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "法制");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(法制处置)
     */
    @Action(value = Url.INVOLVED_DISPOSE_FZ_ADOPTED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeadopt/dispose_adopted_show.jsp")})
    public String disposeFzAdopted() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedDispose", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setIdentityCard(ActivitiUtils.getVariableByProcessId(process.getId(), "caseUser").toString());
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "法制");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /*-------------------------------处置（领导）-------------------------------*/

    /**
     * 待完成任务(领导处置)
     */
    @Action(value = Url.INVOLVED_DISPOSE_LD_NO_ADOPT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeadopt/dispose_no_adopt_show.jsp")})
    public String disposeLdNoAdopt() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号
        int total = ActivitiUtils.findTaskCountByIdentityCard(user.getIdentityCard());
        List<Task> tasks = ActivitiUtils.findTaskListByIdentityCard(user.getIdentityCard(), "InvolvedDispose", getPageBean().getPageNum(), getPageBean().getPageCount());
        List<Involved> involveds = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().equals("领导处置审批")) {
                InvolvedBean involved = involvedActivitiService.findInvolvedByTask(task.getId());
                involved.setTaskId(task.getId());
                involved.setTaskName(task.getName());
                involved.setStartTime(task.getCreateTime());
                involved.setIdentityCard(ActivitiUtils.getVariableByTaskId(task.getId(), "caseUser").toString());
                List<Comment> comments = ActivitiUtils.findProcessInstanceCommentByTaskId(task.getId());
                if (comments.size() > 0) {
                    Comment comment = comments.get(0);
                    String assignee = ActivitiUtils.findAssigneeByTaskId(comment.getTaskId());
                    String assigneeName = SysUserVo.getNameByIdentityCard(assignee);
                    String remark = comment.getFullMessage();
                    if (remark != null) {
                        involved.setRemark("（" + assigneeName + "）：" + remark);
                    } else {
                        involved.setRemark("（" + assigneeName + "）无批注");
                    }
                }
                involveds.add(involved);
            }
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "领导");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已完成任务(领导处置)
     */
    @Action(value = Url.INVOLVED_DISPOSE_LD_ADOPTED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/disposeadopt/dispose_adopted_show.jsp")})
    public String disposeLdAdopted() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据根据用户身份证号和任务状态
        List<HistoricProcessInstance> processes = ActivitiUtils.findHistoricProcessListByIdentityCard(user.getIdentityCard(), "InvolvedDispose", getPageBean().getPageNum(), getPageBean().getPageCount());
        int total = processes.size();
        List<Involved> involveds = new ArrayList<>();
        for (HistoricProcessInstance process : processes) {
            InvolvedBean involved = involvedService.findInvolvedById(process.getBusinessKey().split("\\.")[1]);
            involved.setProcessId(process.getId());
            ProcessDefinition definition = ActivitiUtils.findProcessDefinition(process.getBusinessKey());
            if (definition != null) {
                involved.setProcessName(definition.getName());
            }
            involved.setIdentityCard(ActivitiUtils.getVariableByProcessId(process.getId(), "caseUser").toString());
            involved.setStartTime(process.getStartTime());
            String nextTaskName = ActivitiUtils.getNextTask(process.getId());
            if (nextTaskName.equals("流程已结束")) {
                involved.setEndTime(process.getEndTime());
            } else {
                involved.setTaskName(nextTaskName);
            }
            involveds.add(involved);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involveds);
        //填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("iden", "领导");
        //填充分页对象
        this.handlePageData(involveds, pageBean, request);
        return "SUCCESS";
    }

    /********************************************************************* 保管流程操作 *********************************************************************/
    /**
     * 启动保管流程开始页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_START_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/keep_start.jsp")})
    public String InvolvedKeepTaskShow() throws Exception {
        String involvedId = request.getParameter("involvedId");
        InvolvedBean bean = involvedService.findInvolvedById(involvedId);
        //填充查询对象
        request.setAttribute("entity", bean);
        return "SUCCESS";
    }

    /**
     * 启动保管流程并添加数据
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_START)
    public void addInvolvedKeepTask() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            Involved involved = involvedService.findInvolvedById(bean.getId());
            if (involved.getDisposeState().equals("0") || involved.getApproveState().equals("0")) {
                //启动工作流,返回流程实例对象
                ProcessInstance processInstance = involvedActivitiService.startApproveProcess(bean.getId(), user.getIdentityCard());
                //修改财务保管状态,1为正在申请保管过程，2为保管完成
                involvedService.updateApproveState(bean.getId(), "1");
                jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
            } else {
                jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, "当前财务已在流程中或已经完成流程，不可申请保管！");
            }
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 提交申请保管页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_SUBMIT_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/keep_submit.jsp")})
    public String keep_apply_submit_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        return "SUCCESS";
    }

    /**
     * 提交申请保管
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_SUBMIT)
    public void keep_apply_submit() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            String outcome = request.getParameter("outcome");
            if (outcome.equals("取消申请")) {
                InvolvedBean resultBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
                involvedService.updateApproveState(resultBean.getId(), "0");
            }
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 审批申请保管页面（法制）
     *
     * @return
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_FZ_ADOPT_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/keep_adopt.jsp")})
    public String keep_fz_adopt_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        request.setAttribute("iden", "法制");
        return "SUCCESS";
    }

    /**
     * 审批申请保管（法制）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_FZ_ADOPT)
    public void keep_fz_adopt() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            InvolvedBean involvedBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
            involvedBean.setLawerProcessId(bean.getTaskId());
            String outcome = request.getParameter("outcome");
            if (outcome.equals("驳回")) {
                //增加保管驳回次数
                involvedBean.setBgbhcs(involvedBean.getBgbhcs() + 1);
            }
            involvedService.updateBean(involvedBean.getId(), involvedBean);
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 审批申请保管页面（领导）
     *
     * @return
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_LD_ADOPT_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/keep_adopt.jsp")})
    public String keep_ld_adopt_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        request.setAttribute("iden", "领导");
        return "SUCCESS";
    }

    /**
     * 审批申请保管（领导）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_LD_ADOPT)
    public void keep_ld_adopt() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            InvolvedBean involvedBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
            involvedBean.setLeaderProcessId(bean.getTaskId());
            String outcome = request.getParameter("outcome");
            if (outcome.equals("驳回")) {
                //增加保管驳回次数
                involvedBean.setBgbhcs(involvedBean.getBgbhcs() + 1);
            }
            involvedService.updateBean(involvedBean.getId(), involvedBean);
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 保管员入库财物页面（保管员）
     *
     * @return
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_KEEP_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/keep_keep.jsp")})
    public String keep_keep_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        request.setAttribute("iden", "入库");
        return "SUCCESS";
    }

    /**
     * 保管员入库财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_KEEP_TASK_KEEP)
    public void keep_keep() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            InvolvedBean involvedBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
            String boxId = request.getParameter("boxId");
            InvolvedCaseBean involvedCaseBean = involvedCaseService.findInvolvedCaseByInvolvedId(involvedBean.getId());
            involvedCaseBean.setBoxId(boxId);
            involvedCaseService.updateBean(involvedCaseBean.getId(),involvedCaseBean);
            involvedBean.setStoreState("1");
            involvedBean.setIsBgsp("1");
            involvedBean.setApproveState("2");
            involvedBean.setBgkssj(new Date());
            involvedBean.setBgdqsj(bean.getBgdqsj());
            involvedService.updateBean(involvedBean.getId(), involvedBean);
            String outcome = request.getParameter("outcome");
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /********************************************************************* 处置流程操作 *********************************************************************/

    /**
     * 启动处置流程开始页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_START_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/dispose_start.jsp")})
    public String InvolvedDisposeTaskShow() throws Exception {
        String involvedId = request.getParameter("involvedId");
        InvolvedBean bean = involvedService.findInvolvedById(involvedId);
        //填充查询对象
        request.setAttribute("entity", bean);
        return "SUCCESS";
    }

    /**
     * 启动处置流程并添加数据
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_START)
    public void addInvolvedDisposeTask() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            Involved involved = involvedService.findInvolvedById(bean.getId());
            if (involved.getDisposeState().equals("0") || involved.getApproveState().equals("0")) {
                //启动工作流,返回流程实例对象
                ProcessInstance processInstance = involvedActivitiService.startDisposeProcess(bean.getId(), user.getIdentityCard());
                //修改财务处置状态,1为正在申请处置过程，2为处置完成
                involvedService.updateDisposeState(bean.getId(), "1");
                jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
            } else {
                jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, "当前财务已在流程中或已经完成流程，不可申请处置！");
            }
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }


    /**
     * 提交申请处置页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_SUBMIT_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/dispose_submit.jsp")})
    public String dispose_apply_submit_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        return "SUCCESS";
    }

    /**
     * 提交申请处置
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_SUBMIT)
    public void dispose_apply_submit() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            String outcome = request.getParameter("outcome");
            if (outcome.equals("取消申请")) {
                InvolvedBean resultBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
                involvedService.updateDisposeState(resultBean.getId(), "0");
            }else if(outcome.equals("确认处置")){
                InvolvedBean resultBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
                resultBean.setDisposeState("2");
                resultBean.setStoreState("5");
                involvedService.updateBean(resultBean.getId(),resultBean);
            }
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 审批申请处置页面（法制）
     *
     * @return
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_FZ_ADOPT_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/dispose_adopt.jsp")})
    public String dispose_fz_adopt_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        request.setAttribute("iden", "法制");
        return "SUCCESS";
    }

    /**
     * 审批申请处置（法制）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_FZ_ADOPT)
    public void dispose_fz_adopt() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            InvolvedBean involvedBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
            involvedBean.setLawerProcessId(bean.getTaskId());
            String outcome = request.getParameter("outcome");
            if (outcome.equals("驳回")) {
                //增加处置驳回次数
                involvedBean.setClbhcs(involvedBean.getClbhcs() + 1);
            }
            involvedService.updateBean(involvedBean.getId(), involvedBean);
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 审批申请处置页面（领导）
     *
     * @return
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_LD_ADOPT_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/task/dispose_adopt.jsp")})
    public String dispose_ld_adopt_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        request.setAttribute("iden", "领导");
        return "SUCCESS";
    }

    /**
     * 审批申请处置（领导）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_DISPOSE_TASK_LD_ADOPT)
    public void dispose_ld_adopt() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            InvolvedBean involvedBean = involvedActivitiService.findInvolvedByTask(bean.getTaskId());
            involvedBean.setLeaderProcessId(bean.getTaskId());
            String outcome = request.getParameter("outcome");
            if (outcome.equals("驳回")) {
                //增加处置驳回次数
                involvedBean.setClbhcs(involvedBean.getClbhcs() + 1);
            }
            involvedService.updateBean(involvedBean.getId(), involvedBean);
            involvedActivitiService.saveSubmitByTaskId(bean.getTaskId(), outcome, bean.getRemark());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

}
