package com.action;

import com.constant.Url;
import com.model.LY;
import com.model.User;
import com.model.bean.LYBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.LYService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类名称：LYAction 类描述：录音单的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.LY) // 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Namespace("/")
// 使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class LYAction extends BaseAction<LY> implements ModelDriven<LY> {
    private LYBean bean = new LYBean();

    @Override
    public LYBean getModel() {
        return bean;
    }

    @Autowired
    private LYService service;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.LY_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/ly/show.jsp")})
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
    @Action(value = Url.LY_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "platform/ly/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            LYBean bean2 = service.findLYByLybh(bean.getLybh());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
}
