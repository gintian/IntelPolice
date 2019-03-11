package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.utils.ActivitiUtils;
import com.utils.ExecuteResult;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Action(value = Url.ACTIVITI)
public class ActivitiAction {
    private HttpServletRequest request = ServletActionContext.getRequest();    //获取httpServletRequest对象
    private HttpServletResponse response = ServletActionContext.getResponse();    //获取httpServletRequest对象

    /**
     * 展示-分页
     *
     * @return
     */
    @Action(value = Url.ACTIVITI_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "/activiti/show.jsp")})
    public String showPage() {
        //查询数据
        List<ProcessDefinition> entityList = ActivitiUtils.findProcessDefinitionList();
        request.setAttribute("list", entityList);    //返回数据
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.ACTIVITI_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "/activiti/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.ACTIVITI_DELETE_SUBMIT)
    public void deleteInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            String deploymentId = request.getParameter("deploymentId");
            ActivitiUtils.deleteProcessDefinitionByDeploymentId(deploymentId);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 查看流程图
     *
     * @throws Exception
     */
    @Action(value = Url.ACTIVITI_DETAIL_SHOW)
    public void showView() throws Exception {
        String deploymentId = request.getParameter("deploymentId");
        String diagramResourceName = request.getParameter("diagramResourceName");
        String s = ActivitiUtils.showView(deploymentId, diagramResourceName, response);
        response.getWriter().write(s);
    }
}
