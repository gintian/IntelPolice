package com.action;

import com.constant.Url;
import com.model.FK;
import com.model.User;
import com.model.bean.FKBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.FKService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类名称：FKAction 类描述：反馈单的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.FK) // 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Namespace("/")
// 使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class FKAction extends BaseAction<FK> implements ModelDriven<FK> {
    private FKBean bean = new FKBean();

    @Override
    public FKBean getModel() {
        return bean;
    }

    @Autowired
    private FKService service;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FK_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/fk/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }


    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.FK_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/fk/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            FKBean bean2 = service.findFKByFkdbh(bean.getFkdbh());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
}
