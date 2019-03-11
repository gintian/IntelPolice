package com.action;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.InvolvedTypes;
import com.model.User;
import com.model.bean.DeptBean;
import com.model.bean.InvolvedTypesBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.InvolvedTypesService;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：InvolvedInfosAction 类描述：涉案财物信息表的实现
 */
@Action(value = Url.INVOLVED_TYPES)
public class InvolvedTypesAction extends BaseAction<InvolvedTypes> implements ModelDriven<InvolvedTypesBean> {
    private InvolvedTypesBean bean = new InvolvedTypesBean();

    @Override
    public InvolvedTypesBean getModel() {
        return bean;
    }

    @Autowired
    private InvolvedTypesService service;

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/types/show.jsp")})
    public String index() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        service.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();

        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 通过父类Id获取财务分类
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_SHOW_BY_PARENTID)
    public void get_involved_by_parentid() throws Exception {
        String parentId = request.getParameter("parentid");
        String json="";
        try {
            //根据当前用户查询，部门树
            List<InvolvedTypesBean> entityList = service.findInvolvedTypesByParentId(parentId);
            //新的json对象
            JSONArray newJsonArray = new JSONArray ();
            // 转换JSON对象
            JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(entityList));
            //循环JSON对象，树节点添加isParent=true属性，实现节点实实加载，没有这个属性就没有展开的加号。
            for (int i=0;i<jsonArray.size();i++) {
                JSONObject job = jsonArray.getJSONObject(i);
                newJsonArray.add(job);
            }
            json = newJsonArray.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            json = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage()).toJSONString();
        }
        response.getWriter().write(json);
    }

    /**
     * 财物分类树
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_TREE_SHOW, results = {@Result(name = "INVOLVED_TYPES_TREE", location = Url.VIEWS + "involved/types/show.jsp")})
    public String index2() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        request.setAttribute("status", "1");
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "INVOLVED_TYPES_TREE";
    }

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_FIND_ALL, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "common/_page_left_involved.jsp")})
    public void findAll() throws Exception {
        String json="";
        try {
            //根据当前用户查询，部门树
            List<InvolvedTypesBean> entityList = service.findAll();
            json = JSON.toJSONString(entityList);
        } catch (Exception e) {
            e.printStackTrace();
            json = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage()).toJSONString();
        }
        response.getWriter().write(json);
    }


    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_TYPES_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/types/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_ADD_SUBMIT)
    public void addInvolvedTypes() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;

        try {
            String beanId = service.addBean(bean);//添加
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
    @Action(value = Url.INVOLVED_TYPES_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/types/add_update_show.jsp")})
    public String showEdit() {
        try {
            InvolvedTypesBean resultBean = service.findInvolvedTypesById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_UPDATE_SUBMIT)
    public void updateInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.updateBean(bean.getId(), bean);
            //返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);

        } catch (Exception e) {
            //返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_TYPES_DELETE_SUBMIT)
    public void deleteInvolved() throws Exception {
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
    @Action(value = Url.INVOLVED_TYPES_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/types/detail.jsp")})
    public String getInvolvedTypesById() throws Exception {
        try {
            InvolvedTypesBean bean2 = service.findInvolvedTypesById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

}
