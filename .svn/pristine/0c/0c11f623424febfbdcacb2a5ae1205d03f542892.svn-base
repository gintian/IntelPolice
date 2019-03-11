package com.action;

import com.constant.Url;
import com.model.HF;
import com.model.User;
import com.model.bean.HFBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.HFService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类名称：HFAction 类描述：回访单的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.HF) // 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Namespace("/")
// 使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class HFAction extends BaseAction<HF> implements ModelDriven<HF> {
    private HFBean bean = new HFBean();

    @Override
    public HFBean getModel() {
        return bean;
    }

    @Autowired
    private HFService service;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.HF_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/hf/show.jsp")})
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
    @Action(value = Url.HF_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/hf/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            HFBean bean2 = service.findHFByHfhsdbh(bean.getHfhsdbh());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
}
