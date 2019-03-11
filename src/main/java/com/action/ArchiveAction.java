package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.Archive;
import com.model.User;
import com.model.bean.ArchiveBean;
import com.model.bean.ArchiveCaseBean;
import com.model.bean.CriminalBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ArchiveCaseService;
import com.service.ArchiveService;
import com.service.CriminalService;
import com.service.InvolvedCaseService;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import com.utils.ServiceUtils;
import org.apache.commons.lang.StringUtils;
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
@Action(value = Url.ARCHIVE)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class ArchiveAction extends BaseAction<Archive> implements ModelDriven<Archive> {
    @Autowired
    private ArchiveService archiveService;
    private ArchiveBean bean = new ArchiveBean();
    private ArchiveCaseBean caseBean = new ArchiveCaseBean();

    @Override
    public ArchiveBean getModel() {
        return bean;
    }

    @Autowired
    private ArchiveCaseService archiveCaseService;
    @Autowired
    private CriminalService criminalService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.ARCHIVE_CASE_ADDNEW_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "/archive/add_archive_by_case_show.jsp")})
    public String showAddByCase() {
        //获取当前登录的用户
        User user = this.getUser(request);
        //获取案件编号
        String caseid = request.getParameter("caseid");
        //获取案件信息
        CriminalBean criminalBean = new CriminalBean();
        try {
            criminalBean = criminalService.findCriminalById(caseid);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        //查询数据
        archiveService.pageQueryEqCaseId(getPageBean(), bean, user.getId(), caseid);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充案件对象
        request.setAttribute("caseObj", criminalBean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * tl
     *  未录入同步卷宗的案件   无需处理操作
     * @throws Exception
     */
    @Action(value = Url.ARCHIVE_NOT_INPUT_SUBMIT)
    public void noRequireDispose() throws Exception {
        System.err.println(bean.getCaseid());
        JSONObject jsonObject = null;
        try {
            archiveService.noRequireDispose(bean.getCaseid());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, false);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 查询卷宗
     * @return
     * @throws Exception
     */
    @Action(value = Url.ARCHIVE_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        archiveService.pageQuery(getPageBean(), bean);
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
    @Action(value = Url.ARCHIVE_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/infos_add_update_show.jsp")})
    public String showAdd() {
        request.setAttribute("caseid", bean.getCaseid());
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.ARCHIVE_ADD_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        // 获取当前登录的用户
        User user = this.getUser(request);
        bean.setUserName(user.getName());
        bean.setUserId(user.getId());
        bean.setCode(RandomUtils.RandomCode("JZ",user.getDeptId()));//生成编号
        String [] imgPathes = request.getParameterValues("imgPathes");
        String imgPath = StringUtils.join(imgPathes, ",");
        bean.setImgPath(imgPath);
        try {
            bean.setId(ServiceUtils.generatePrimaryKey());
            archiveService.addBean(bean);
            caseBean.setArchiveId(bean.getId());
            caseBean.setCaseId(bean.getCaseid());
            archiveCaseService.addBean(caseBean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.ARCHIVE_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/infos_add_update_show.jsp")})
    public String showEdit() {
        try {
            ArchiveBean resultBean = archiveService.findArchiveById(bean.getId());
            request.setAttribute("entity", resultBean);
            request.setAttribute("caseid", bean.getCaseid());
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
    @Action(value = Url.ARCHIVE_UPDATE_SUBMIT)
    public void update() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        // 获取当前登录的用户
        User user = this.getUser(request);
        bean.setUserName(user.getName());
        bean.setUserId(user.getId());
        String [] imgPathes = request.getParameterValues("imgPathes");
        String imgPath = StringUtils.join(imgPathes, ",");
        bean.setImgPath(imgPath);
        try {
            archiveService.updateBean(bean.getId(), bean);
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
    @Action(value = Url.ARCHIVE_DELETE_SUBMIT)
    public void delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            archiveService.deleteBean(bean.getId());
            archiveCaseService.deleteArchiveBean(bean.getId());
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
    @Action(value = Url.ARCHIVE_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            ArchiveBean bean2 = archiveService.findArchiveById(bean.getId());
            String[] imgPaths= bean2.getImgPath().split(",");
            request.setAttribute("imgPaths",imgPaths);
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultArchive = e.getMessage();
            request.setAttribute("message", resultArchive);
        }
        return "SUCCESS";
    }
    //同步卷宗
    @Action(value = Url.ARCHIVE_INFOS_CASE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "/archive/case_show.jsp")})
    public String showCaseAddShow() {
        //获取案件编号
        String caseId = request.getParameter("caseId");
        //获取案件信息
        CriminalBean criminalBean = new CriminalBean();
        try {
            criminalBean = criminalService.findCriminalById(caseId);
            //查询对应号所以数据
            List<ArchiveBean> list = archiveService.selectDataAllEqCaseId(criminalBean.getCaseid());
            request.setAttribute("criminalBean",criminalBean);
            request.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
 /*   *//**
     * 卷宗添加页面
     *
     * @return
     *//*
    @Action(value = Url.ARCHIVE_INFOS_CASE_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/infos_add_update_show.jsp")})
    public String showAddInfos() {
        String caseId = request.getParameter("caseid");
        request.setAttribute("caseid", caseId);
        return "SUCCESS";
    }
    *//**
     * 编辑页面
     *
     * @return
     *//*
    @Action(value = Url.ARCHIVE_INFOS_CASE_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/infos_add_update_show.jsp")})
    public String showUpdateInfos() {
        String caseId = request.getParameter("caseid");
        request.setAttribute("caseid", caseId);
        request.setAttribute("entity", bean);
        return "SUCCESS";
    }*/
    //是否当当存入
    @Action(value = Url.ARCHIVE_STORES_BOX_TODAY_BOX, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "archive/storesBox/isDeposit/show.jsp")})
    public String CruDay() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        archiveService.pageCruDayQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加文件展示详情
     *
     * @return
     */
    @Action(value = Url.ARCHIVE_ADD_DETAIL_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/infos_add_update_show.jsp")})
    public String showAddDetail1() {
        String caseid = request.getParameter("caseid");
        bean = (ArchiveBean) request.getSession().getAttribute("archiveEntity");
        request.getSession().removeAttribute("archiveEntity");
        request.setAttribute("caseid",caseid);
        request.setAttribute("entity",bean);
        return "SUCCESS";
    }

    /**
     * 图片展示
     *
     * @return
     */
    @Action(value = Url.ARCHIVE_IMG_SHOW1, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive/imgShow.jsp")})
    public String showAddArchiveUpload() {
        String imgPath = request.getParameter("imgPath");
        request.setAttribute("imgPath",imgPath);
        return "SUCCESS";
    }
    /**
     * 添加卷宗页面
     *
     * @return
     */
    @Action(value = Url.ARCHIVE_ADD_UPLOAD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "archive_uploader.jsp")})
    public String showImg() {
        String caseid = request.getParameter("caseid");
        request.setAttribute("caseid",caseid);
        request.getSession().setAttribute("archiveEntity", bean);
        return "SUCCESS";
    }
}
