package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.ArchiveStores;
import com.model.User;
import com.model.bean.ArchiveStoresBean;
import com.model.bean.CodeBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ArchiveStoresService;
import com.service.CodeService;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：ArchiveAction 类描述：消息的实现
 */
@SuppressWarnings("serial")
// @ParentPackage("json-default")
@Action(value = Url.CODE)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class CodeAction extends BaseAction<CodeBean> implements ModelDriven<CodeBean> {
    @Autowired
    private CodeService service;
    private CodeBean bean = new CodeBean();

    @Override
    public CodeBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.CODE_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "code/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        try{
            User user = this.getUser(request);
            // 查询数据
            service.pageQuery(getPageBean(), bean);
            // 获取分页数据
            List entityList = pageBean.getRows();
            // 填充查询对象
            request.setAttribute("searchObj", bean);
            // 填充分页对象
            this.handlePageData(entityList, pageBean, request);
        }catch (Exception e){e.printStackTrace();}

        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.CODE_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "code/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.CODE_ADD_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            bean.setId(RandomUtils.RandomCode("ZD",user.getDeptId()));
            service.addBean(bean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.CODE_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "code/add_update_show.jsp")})
    public String showEdit() {
        try {
            CodeBean resultBean = service.findCodeById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 编辑
     *
     * @throws Exception
     */
    @Action(value = Url.CODE_UPDATE_SUBMIT)
    public void update() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.updateBean(bean.getId(), bean);
            // 返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            // 返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.CODE_DELETE_SUBMIT)
    public void delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.deleteBean(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.CODE_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "code/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            CodeBean bean2 = service.findCodeById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultArchive = e.getMessage();
            request.setAttribute("message", resultArchive);
        }
        return "SUCCESS";
    }
}
