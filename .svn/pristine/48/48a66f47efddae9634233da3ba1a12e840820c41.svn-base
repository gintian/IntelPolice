package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;

import com.constant.Url;
import com.exception.WebMessageException;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import com.service.DataSyncTaskService;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 角色action
 */

@Action(value = Url.ROLE)
public class DataSynctaskAction extends BaseAction<DataSyncTaskBean> implements ModelDriven<DataSyncTaskBean> {
    private DataSyncTaskBean bean = new DataSyncTaskBean();

    @Override
    public DataSyncTaskBean getModel() {
        return bean;
    }

    @Autowired
    private DataSyncTaskService dataSyncTaskService;
    /**
     * 备份历史 数据  展示-分页
     *
     * @return
     */
    @Action(value = Url.DATA_SYNCTASK_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dataSyncTask/show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showPage() {
        try {
            //查询数据
            dataSyncTaskService.pageQuery(getPageBean(), bean, getCurrentUserBean(request));
            //获取分页数据
            List entityList = pageBean.getRows();
            //填充查询对象
            request.setAttribute("searchObj", bean);
            //填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 备份历史 数据  展示-分页
     *
     * @return
     */
    @Action(value = Url.DATA_SYNCTASK_NEXT_TASK_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dataSyncTask/showNextTask.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showPageForNextTask() {
        try {
            //查询数据
            dataSyncTaskService.pageQueryForNextExecte(getPageBean(), bean);
            //获取分页数据
            List entityList = pageBean.getRows();
            //填充查询对象
            request.setAttribute("searchObj", bean);
            //填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }
    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.DATA_SYNCTASK_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dataSyncTask/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showAdd() {
        try {
           
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }
    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.DATA_SYNCTASK_ADD_SUBMIT)
    public void addMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            dataSyncTaskService.addBean(bean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.DATA_SYNCTASK_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dataSyncTask/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showUpdate() {
        try {
            DataSyncTaskBean dataSyncTaskBean = dataSyncTaskService.findBeanById(bean.getId());
            request.setAttribute("entity", dataSyncTaskBean);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.DATA_SYNCTASK_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dataSyncTask/detail.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showDetails() {
        try {
            DataSyncTaskBean dataSyncTaskBean = dataSyncTaskService.findBeanById(bean.getId());
            request.setAttribute("entity", dataSyncTaskBean);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }
    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.DATA_SYNCTASK_UPDATE_SUBMIT)
    public void updateSubmit() throws Exception {
        JSONObject jsonObject = null;
        try {
            dataSyncTaskService.updateBean(bean.getId(),bean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.DATA_SYNCTASK_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            dataSyncTaskService.deleteBean(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
