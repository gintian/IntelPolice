package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.utils.CommonValidate;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.User;
import com.model.bean.DeptBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DeptService;
import com.utils.ExecuteResult;
import com.utils.SysDeptVo;

/**
 * 类名称：DeptAction 类描述：部门的实现
 */
// @ParentPackage("json-default")
@Action(value = Url.DEPT)
public class DeptAction extends BaseAction<DeptBean> implements ModelDriven<DeptBean> {
    private DeptBean bean = new DeptBean();

    @Override
    public DeptBean getModel() {
        return bean;
    }

    @Autowired
    private DeptService service;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();

	/**
	 * 获取部门通过parentid
	 *
	 * @throws Exception
	 */
	@Action(value = Url.DEPT_SHOW_BY_PARENTID)
	public void get_dept_by_parentid() throws Exception {
		String parentId = request.getParameter("parentId");
		String json="";
		try {
			//根据当前用户查询，部门树
			List<DeptBean> entityList = service.findDeptByParentId(parentId);
			//新的json对象
			JSONArray newJsonArray = new JSONArray ();
			// 转换JSON对象
			JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(entityList));
			//循环JSON对象，树节点添加isParent=true属性，实现节点实实加载，没有这个属性就没有展开的加号。
			for (int i=0;i<jsonArray.size();i++) {
				JSONObject job = jsonArray.getJSONObject(i);
				String leaf=job.getString("leaf");
				if(leaf!=null && leaf.equals("0"))
				{
					job.put("isParent","true");
				}
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
	 * 获取部门通过id
	 *
	 * @throws Exception
	 */
	@Action(value = Url.DEPT_SHOW_BY_ID)
	public void get_dept_by_id() throws Exception {
		String deptId = request.getParameter("deptId");
		String json="";
		try {
			//根据当前用户查询，部门树
			DeptBean entity = service.findDeptBeanByDeptId(deptId);
			List<DeptBean> list = new ArrayList<>();
			list.add(entity);
			//新的json对象
			JSONArray newJsonArray = new JSONArray ();
			// 转换JSON对象
			JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(list));
			//循环JSON对象，树节点添加isParent=true属性，实现节点实实加载，没有这个属性就没有展开的加号。
			for (int i=0;i<jsonArray.size();i++) {
				JSONObject job = jsonArray.getJSONObject(i);
				String leaf=job.getString("leaf");
				if(leaf!=null && leaf.equals("0"))
				{
					job.put("isParent","true");
				}
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
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.DEPT_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/dept/show.jsp")})
    public String index() throws Exception {

        // 查询数据
        service.pageQuery(getPageBean(), bean, getCurrentUserBean(request));
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.DEPT_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/dept/add_update_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.DEPT_ADD_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.addBean(bean, getCurrentUserBean(request));
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
    @Action(value = Url.DEPT_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/dept/add_update_show.jsp")})
    public String showEdit() {
        try {
            DeptBean resultBean = service.findDeptBeanByDeptId(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

	/**
	 * 详情展示
	 * @throws Exception
	 */
	@Action(value = Url.DEPT_DETAIL_SHOW,
			results = {@Result(name = "SUCCESS", location = Url.VIEWS+"authority/dept/detail.jsp") })
	public String detailShow() throws Exception{
		try {
			DeptBean bean2 = service.findDeptBeanByDeptId(bean.getId());
			request.setAttribute("entity", bean2);
		} catch (Exception e) {
			String resultMessage = e.getMessage();
			request.setAttribute("message", resultMessage);
		}
		return "SUCCESS";
	}

    /**
     * 编辑
     *
     * @throws Exception
     */
    @Action(value = Url.DEPT_UPDATE_SUBMIT)
    public void update() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.updateBean(bean.getId(), bean, getCurrentUserBean(request));
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
    @Action(value = Url.DEPT_DELETE_SUBMIT)
    public void delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.deleteBean(bean.getId(), getCurrentUserBean(request));
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
    @Action(value = Url.DEPT_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "authority/dept/detail.jsp")})
    public String getMenuById() throws Exception {
        try {
            DeptBean bean2 = service.findDeptBeanByDeptId(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
    /**
     * 部门树 展示 页面
     * @throws Exception
     */
    @Action(value = Url.DEPT_TREE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/authority/dept/dept_tree2.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String updateMenuShow() throws Exception{

        return "SUCCESS";
    }
}
