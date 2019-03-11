package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.bean.MediaCaseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.MediaCaseService;

/**
 * 执法音视频关联案件表EA_MEDIA_CASE
 */

@Action
public class MediaCaseAction extends ActionSupport implements ModelDriven<MediaCaseBean> {

    private MediaCaseBean bean = new MediaCaseBean();

    @Override
    public MediaCaseBean getModel() {
        return bean;
    }

    @Autowired
    private MediaCaseService mediaCaseCaseService;
    ActionContext context = ActionContext.getContext();

    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 显示列表视图
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_SHOW_VIEW_LIST, results = {
            @Result(name = "SUCCESS", location = "/WEB-INF/views/mediaCase/mediaCase.jsp")})
    public String mediaCaseListTree() throws Exception {
        return "SUCCESS";
    }

    /**
     * 返回  listjson数据
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_DATA)
    public void mediaCaseTreeData() throws Exception {
        String results = mediaCaseCaseService.getAllListBean();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(results);
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            mediaCaseCaseService.addBean(bean);
            jsonObject.put("success", "success");

        } catch (Exception e) {
            String resultMessage = e.getMessage();
            jsonObject.put("message", resultMessage);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            mediaCaseCaseService.updateBean(bean.getCaseId(), bean);
            jsonObject.put("success", "success");

        } catch (Exception e) {
            String resultMessage = e.getMessage();
            jsonObject.put("message", resultMessage);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            mediaCaseCaseService.deleteBean(bean.getCaseId());
            jsonObject.put("success", "success");

        } catch (Exception e) {
            String resultMessage = e.getMessage();
            jsonObject.put("message", resultMessage);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 查询  对象
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_PAGE_SHOW)
    public void mediaCaseSerachList() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            String result = mediaCaseCaseService.queryCriteriaBeanList(bean);
            jsonObject.put("bean", result);
            jsonObject.put("success", "success");
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            jsonObject.put("message", resultMessage);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }


    /**
     * 查询当前菜单详情
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIACASE_BY_ID)
    public void getMenuById() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();

        try {
            MediaCaseBean bean2 = mediaCaseCaseService.findMenuById(bean.getCaseId());
            jsonObject.put("bean", bean2);
            jsonObject.put("success", "success");
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            jsonObject.put("message", resultMessage);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
