package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Url;
import com.model.User;
import com.model.bean.DictoryBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DictoryService;
import com.utils.ExecuteResult;
import com.utils.SysDictoryVo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 角色action
 */

@Action(value = Url.DICTORY)
public class DictoryAction extends BaseAction<DictoryBean> implements ModelDriven<DictoryBean> {
    private DictoryBean bean = new DictoryBean();

    @Override
    public DictoryBean getModel() {
        return bean;
    }

    @Autowired
    private DictoryService dictoryService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();

    /**
     * 展示-分页
     *
     * @return
     */
    @Action(value = Url.DICTORY_PAGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dictory/show.jsp")})
    public String showPage() {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        dictoryService.pageQuery(getPageBean(), bean, user.getId());
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);

	/*	List<DictoryBean> list = SysDictoryVo.getDictoryBeanList(Integer.valueOf(CommonConstant.DICTORY_TYPE_DICTORY));
		request.setAttribute("dictorylist", list);*/
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.DICTORY_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dictory/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showAdd() {

        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.DICTORY_ADD_SUBMIT)
    public void addMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            dictoryService.addBean(bean);
            dictoryService.doCacheForDictroy();
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.DICTORY_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dictory/add_update_show.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showEdit() {
        try {
            DictoryBean resultBean = dictoryService.findDictoryById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.DICTORY_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            dictoryService.updateBean(bean.getId(), bean);
            dictoryService.doCacheForDictroy();
            //返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            //返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.DICTORY_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        JSONObject jsonObject = null;
        try {
            dictoryService.deleteBean(bean.getId());
            dictoryService.doCacheForDictroy();
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }


    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.DICTORY_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/dictory/detail.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String getMenuById() throws Exception {
        try {
            DictoryBean bean2 = dictoryService.findDictoryById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
            return "ERROR";
        }
        return "SUCCESS";
    }

}
