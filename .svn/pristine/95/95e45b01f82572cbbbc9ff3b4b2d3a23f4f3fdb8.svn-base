package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Indicator;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.*;
import com.utils.ExecuteResult;
import com.utils.SysDictoryVo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统参数设置action
 */

@Action()
public class SystemSettingAction extends BaseAction<SystemSettingBean> implements ModelDriven<SystemSettingBean> {
    private SystemSettingBean bean = new SystemSettingBean();

    @Override
    public SystemSettingBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();
    @Autowired
    private SystemSettingService settingService;
    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.SYSTEM_SETTINGS_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "SystemSeting/show.jsp") })
    public String index() throws Exception {

        return "SUCCESS";
    }
    /**
     * 修改当前使用网点
     *
     * @throws Exception
     */
    @Action(value = Url.SYSTEM_SETTINGS_CURRENT_DEPT_SUBMIT)
    public void updateMenuSubmit() throws Exception {
        JSONObject jsonObject = null;
        try {
            settingService.setCurrentDeptUse(bean.getDeptId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
