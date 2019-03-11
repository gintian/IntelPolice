package com.action;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.bean.UserBean;
import com.utils.ServiceUtils;
import org.apache.struts2.ServletActionContext;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.page.PageBean;
import com.utils.SessionKey;

public class BaseAction<T> extends ActionSupport {

    protected ActionContext context = ActionContext.getContext();                //获取容器对象
    protected PageBean<T> pageBean;                                            //获取分页相关的字段
    protected HttpServletRequest request = ServletActionContext.getRequest();    //获取httpServletRequest对象
    protected HttpServletResponse response = ServletActionContext.getResponse();
    //分页相关的参数，请谨慎修改
    protected int pageSize;
    protected int pageCurrent;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public PageBean<T> getPageBean() {
        pageBean = new PageBean<T>();
        if (pageSize != 0 && pageCurrent != 0) {
            pageBean.setPage(pageCurrent);
            pageBean.setPageSize(pageSize);
        } else {
            pageBean.setPage(1);
            pageBean.setPageSize(PageBean.PAGESIZE);
        }
        return pageBean;
    }

    /**
     * Request
     *
     * @param request
     * @return
     */
//	private String status;
//	public String getStatus() {
//		return status;
//	}

    /**
     * 从Session中获取用户信息
     *
     * @param request
     * @return
     */
    public User getUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(SessionKey.USER);
    }

    /**
     * 从Session中获取用户信息
     *
     * @param request [必填]			request对象
     * @return userBean
     */
    public UserBean getCurrentUserBean(HttpServletRequest request) {
        UserBean userBean = new UserBean();
        User user = getUser(request);
        try {
            ServiceUtils.copyProperties(userBean, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBean;
    }

    /**
     * 处理分页数据
     *
     * @param list    数据对象
     * @param request HttpServletRequest对象
     */
    public void handlePageData(List list, PageBean<T> pageBean, HttpServletRequest request) {

        if (list == null || list.size() == 0) {
            request.setAttribute("total", 0);
            request.setAttribute("pageSize", pageBean.getPageSize());
            request.setAttribute("pageCurrent", pageBean.getPage());
        } else {
            request.setAttribute("list", pageBean.getRows());
            request.setAttribute("total", pageBean.getTotal());                            //总页数
            request.setAttribute("pageSize", pageBean.getPageSize());                    //当页条数
            request.setAttribute("pageCurrent", pageBean.getPage());                //当前页码
        }

        //封装查询条件的id
        request.setAttribute("searchFormId", UUID.randomUUID());

    }
}
