package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.model.CMD;
import com.model.User;
import com.model.bean.CMDBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CMDService;

/**
 * 类名称：CMDAction 类描述：110指令的实现
 */
// @ParentPackage("json-default")
@Action(value = Url.CMD) // 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class CMDAction extends BaseAction<CMD> implements ModelDriven<CMD> {
    @Autowired
    private CMDService service;

    private CMDBean bean = new CMDBean();

    @Override
    public CMDBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.CMD_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "case/cmd/show.jsp")})
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
    @Action(value = Url.CMD_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "case/cmd/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            CMDBean bean2 = service.findCMDById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

}
