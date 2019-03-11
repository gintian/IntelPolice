package com.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.User;
import com.model.bean.MediaFilesBean;
import com.opensymphony.xwork2.ModelDriven;
import com.service.MediaFilesService;

/**
 * 绫诲悕绉帮細LoginAction
 * 绫绘弿杩帮細鐢ㄦ埛鎺у埗鍣ㄧ殑瀹炵幇
 */

@Action
public class MediaFilesAction extends BaseAction implements ModelDriven<MediaFilesBean> {

    private MediaFilesBean bean = new MediaFilesBean();

    @Override
    public MediaFilesBean getModel() {
        return bean;
    }

    @Autowired
    private MediaFilesService mediaFilesService;


    /**
     * 展示-分页
     *
     * @return
     */
    @Action(value = Url.MEDIAFILES_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/mediaFiles/show.jsp")})
    public String showPage() {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        mediaFilesService.pageQuery(getPageBean(), bean, user.getId());
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.MEDIAFILES_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            mediaFilesService.addBean(bean);
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
    @Action(value = Url.MEDIAFILES_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            mediaFilesService.updateBean(bean.getId(), bean);
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
    @Action(value = Url.MEDIAFILES_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            mediaFilesService.deleteBean(bean.getId());
            jsonObject.put("success", "success");

        } catch (Exception e) {
            String resultMessage = e.getMessage();
            jsonObject.put("message", resultMessage);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
