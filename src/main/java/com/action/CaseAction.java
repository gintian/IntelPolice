package com.action;

import com.constant.CommonConstant;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.Criminal;
import com.model.User;
import com.model.bean.CaseStatusBean;
import com.model.bean.CodeBean;
import com.model.bean.CriminalBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CodeService;
import com.service.CriminalService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名称：CriminalAction 类描述：受立案的实现
 */
// @ParentPackage("json-default")
@Action(value = Url.CASE)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class CaseAction extends BaseAction<Criminal> implements ModelDriven<Criminal> {
    private CriminalBean bean = new CriminalBean();

    @Override
    public CriminalBean getModel() {
        return bean;
    }

    @Autowired
    private CriminalService criminalService;

    @Autowired
    private CodeService codeService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 已确认异常展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.ABNORMAL_CONFIRM_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "case/caseSupervise/suspiciousJCJ/abnormalConfirm/show.jsp")})
    public String index() throws Exception {
//        // 获取当前登录的用户
//        User user = this.getUser(request);
//        // 查询数据
//        criminalService.pageQuery(getPageBean(), bean);
//        // 获取分页数据
//        List entityList = pageBean.getRows();
//        // 填充查询对象
//        request.setAttribute("searchObj", bean);
//        // 填充分页对象
//        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已确认异常详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.ABNORMAL_CONFIRM_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "case/caseSupervise/suspiciousJCJ/abnormalConfirm/detail.jsp")})
    public String getDetails() throws Exception {
//        try {
//            CriminalBean bean2 = criminalService.findCriminalById(bean.getCaseid());
//            request.setAttribute("entity", bean2);
//        } catch (Exception e) {
//            String resultMessage = e.getMessage();
//            request.setAttribute("message", resultMessage);
//        }
        return "SUCCESS";
    }

}
