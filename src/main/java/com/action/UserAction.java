package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Dept;
import com.model.Message;
import com.model.bean.*;
import com.page.PageBean;
import com.service.*;
import com.utils.*;
import org.apache.shiro.web.session.HttpServletSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.constant.Indicator;
import com.constant.Url;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 类名称：LoginAction 类描述：用户控制器的实现
 */
@Action(value = Url.USER)
public class UserAction extends BaseAction<UserBean> implements ModelDriven<UserBean> {
    private UserBean bean = new UserBean();

    @Override
    public UserBean getModel() {
        return bean;
    }
    @Autowired
    private UserService userService;
    @Autowired
    private DictoryService dictoryService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private AccessManager accessManager;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();


    /**
     * 登陆
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_LOGIN, results = {@Result(name = "SUCCESS", type = "redirect", location = "../index.jsp"),
            @Result(name = "FAILER", type = "redirect", location = "../failer.jsp")})
    public String login() throws Exception {

        return "SUCCESS";

    }

    /**
     * 登录校验
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_LOGIN_VALIDATE)
    public void dologin() throws Exception {
        JSONObject jsonObject = null;
        try {
            boolean flag = userService.login(bean.getAccount(), bean.getPassword());
            if (flag) {
                if (!CommonValidate.isEmpty(bean.getAlready()) && bean.getAlready().equals("1")) {
                    jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, "欢迎进入");
                } else {
                    UserBean user = userService.findUserByAccount(bean.getAccount());
                    //校验是否有权限登录
//                    userService.validateUserLoginPermission(user);
                    //登录成功后存入用户的权限url 到session 缓存中
                    Set<String> urls = roleService.findPermissionURlsByUserId(user.getId());
                    //登陆后缓存部门
                    DeptBean dept = deptService.findDeptBeanByDeptId(user.getDeptId());
                    //登陆后缓存公告
                    NoticeBean noticeBean = this.noticeService.findNoticeIndex();
                    //登陆后缓存消息
                    int messageNum = messageService.pageQueryNoRead(new PageBean<Message>(), new MessageBean(), user.getId()).getTotal();

                    //单点登录,登录掉线
                    SessionListenerUtils.isAlreadyEnter(request.getSession(), user.getAccount());

                    //设置session有效时间
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(CommonConstant.SESSION_TIMEOUT);

                    Map<String,Object> sessionMap = context.getSession();
                    sessionMap.put(SessionKey.USER_PERMISSION_URL, urls);
                    sessionMap.put(SessionKey.USER, user);
                    sessionMap.put(SessionKey.DEPT, dept);
                    sessionMap.put("noticeBean", noticeBean);
                    sessionMap.put("messageNum", messageNum);
                    jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, "登录成功");
                }
            } else {
                Integer loginErrorCount = (Integer) context.getSession().get(SessionKey.USER_LOGIN_ERROR_COUNT);
                AccessUtils.doLogErrorForAcount(loginErrorCount, context);
                jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, WebExceptionConstant.USER_LOGIN_IS_ERROR);
            }
        } catch (WebMessageException e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, WebExceptionConstant.USER_LOGIN_IS_ERROR);
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 注销
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_LOGOUT, results = {
            @Result(name = "SUCCESS", type = "redirect", location = "/login.jsp")})
    public String logout() throws Exception {
        context.getSession().clear();
        SessionListenerUtils.logout(request.getSession());
        return "SUCCESS";
    }

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/user/show.jsp")})
    public String index() throws Exception {
        // 查询数据
        userService.pageQuery(getPageBean(), bean, this.getCurrentUserBean(request));
        // 获取分页数据
        List entityList = pageBean.getRows();
        List<DictoryBean> userTypeBeanList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(Indicator.USER_TYPE.getCode()));

        request.setAttribute("userTypeBeanList", userTypeBeanList);
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 员工树
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_TREE_SHOW, results = {
            @Result(name = "USER_TREE", location = Url.VIEWS + "authority/user/user_tree.jsp")})
    public String index2() throws Exception {
        // 查询数据
        userService.pageQuery(getPageBean(), bean, this.getCurrentUserBean(request));
        // 获取分页数据
        List entityList = pageBean.getRows();
        List<DictoryBean> userTypeBeanList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(Indicator.USER_TYPE.getCode()));

        request.setAttribute("userTypeBeanList", userTypeBeanList);
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);

        String status = request.getParameter("status");
        return "USER_TREE";
    }
    /**
     * 员工树2
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_TREE_SHOW1, results = {
            @Result(name = "USER_TREE", location = Url.VIEWS + "authority/user/user_tree1.jsp")})
    public String index21() throws Exception {
        // 查询数据
        userService.pageQuery(getPageBean(), bean, this.getCurrentUserBean(request));
        // 获取分页数据
        List entityList = pageBean.getRows();
        List<DictoryBean> userTypeBeanList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(Indicator.USER_TYPE.getCode()));

        request.setAttribute("userTypeBeanList", userTypeBeanList);
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);

        String status = request.getParameter("status");
        return "USER_TREE";
    }

    /**
     * 查询员工
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_DATA)
    public void userData() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
//        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject = null;
        // 查询数据\r\n
        userService.pageQuery(getPageBean(), bean, this.getCurrentUserBean(request));
        // 获取分页数据
        List entityList = pageBean.getRows();
        response.getWriter().write(jsonObject.toJSONString(entityList));
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.USER_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/user/add_update_show.jsp"),
            @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showAdd() {
        try {
            User user = getUser(request);
            List<DictoryBean> userTypeBeanList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(Indicator.USER_TYPE.getCode()));
            request.setAttribute("userTypeBeanList", userTypeBeanList);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.USER_ADD_SUBMIT)
    public void add() throws Exception {
        JSONObject jsonObject = null;
        try {
            userService.addBean(bean, this.getCurrentUserBean(request));
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
    @Action(value = Url.USER_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/user/add_update_show.jsp"),
            @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String showEdit() {
        try {
            UserBean resultBean = userService.findUserById(bean.getId());
            User user = getUser(request);
            List<DictoryBean> userTypeBeanList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(Indicator.USER_TYPE.getCode()));
            String roleIds = userService.findRoleIdsByUserId(bean.getId(), this.getCurrentUserBean(request));
            request.setAttribute("roleIds", roleIds);
            request.setAttribute("userTypeBeanList", userTypeBeanList);
            request.setAttribute("entity", resultBean);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(CommonConstant.SYSTEM_MESSAGE, e.getMessage());
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 编辑
     *
     * @throws Exception
     */
    @Action(value = Url.USER_UPDATE_SUBMIT)
    public void update() throws Exception {
        JSONObject jsonObject = null;
        try {
            userService.updateBean(bean.getId(), bean, this.getCurrentUserBean(request));
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
    @Action(value = Url.USER_DELETE_SUBMIT)
    public void delete() throws Exception {
        JSONObject jsonObject = null;
        try {
            userService.deleteBean(bean.getId(), this.getCurrentUserBean(request));
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
    @Action(value = Url.USER_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "authority/user/detail.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String getDetails() throws Exception {
        try {
            UserBean bean2 = userService.findUserById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            e.printStackTrace();
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 部门树 展示 页面
     *
     * @throws Exception
     */
    @Action(value = Url.USER_DEPT_TREE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/authority/user/dept_tree2.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String updateMenuShow() throws Exception {

        return "SUCCESS";
    }

    /**
     * 根据部门异步加载，角色数据
     */
    @Action(value = Url.USER_MENU_BY_DEPTID)
    public void findMenuByDeptId() throws Exception {
        JSONObject jsonObject = new JSONObject();
        try {
            List<JSONObject> listjson = new ArrayList<JSONObject>();
            List<RoleBean> roleBeanList = roleService.findBeanListByDeptId(bean.getDeptId(), false);
            for (RoleBean roleBean : roleBeanList) {
                JSONObject json = new JSONObject();
                json.put("id", roleBean.getId());
                json.put("name", roleBean.getName());
                listjson.add(json);
            }
            System.out.println(listjson);
            jsonObject.put("list", listjson);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 重置密码
     *
     * @throws Exception
     */
    @Action(value = Url.USER_RESET_PASSWORD_SUBMIT)
    public void resetPassword() throws Exception {
        JSONObject jsonObject = null;
        try {
            userService.resetPassword(bean.getId(), this.getCurrentUserBean(request));
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 用户操作失败提示页面
     *
     * @throws Exception
     */
    @Action(value = Url.USER_TO_ERROR_SHOW,
            results = {@Result(name = "SUCCESS", location = "/sys_error.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String toErrorShow() throws Exception {
        return "SUCCESS";
    }

    /**
     * 修改密码展示 页面
     *
     * @throws Exception
     */
    @Action(value = Url.USER_PASSWORD_CHANGE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/authority/user/changepassword.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String toUpdatePasswordShow() throws Exception {

        return "SUCCESS";
    }

    /**
     * 修改密码
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.USER_PASSWORD_CHANGE_SUBMIT)
    public void changePassword() throws Exception {
        JSONObject jsonObject = null;
        try {
            userService.changePassword(getUser(request).getAccount(), bean.getOldpassword(), bean.getPassword());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 登录超时展示 页面
     *
     * @throws Exception
     */
    @Action(value = Url.USER_LOGIN_TIMEOUT_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/authority/user/login_timeout.jsp"),
                    @Result(name = "ERROR", location = "/sys_error.jsp")})
    public String LoginOutShow() throws Exception {

        return "SUCCESS";
    }

    /**
     * 用户激活锁定
     *
     * @throws Exception
     */
    @Action(value = Url.USER_LOCKED_SUBMIT)
    public void locked() throws Exception {
        JSONObject jsonObject = null;
        try {
            userService.updateUserLocked(bean.getId(), bean.getLocked());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (WebMessageException e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
