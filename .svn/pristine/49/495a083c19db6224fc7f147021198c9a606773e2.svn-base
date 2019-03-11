package com.action;

import com.alibaba.fastjson.JSONObject;
import com.model.Criminal;
import com.model.Involved;
import com.model.InvolvedStoresBox;
import com.model.User;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.*;
import com.utils.ExecuteResult;
import com.utils.StoreUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 类名称：InvolvedStoresBoxAction 类描述：储物柜箱子表的实现
 */
@SuppressWarnings("serial")
@Action(value = Url.INVOLVED_STORES_BOX)
public class InvolvedStoresBoxAction extends BaseAction<InvolvedStoresBox> implements ModelDriven<InvolvedStoresBox> {
    @Autowired
    private InvolvedStoresBoxService service;
    private InvolvedStoresBoxBean bean = new InvolvedStoresBoxBean();
    @Autowired
    private InvolvedService involvedService;
    @Autowired
    private InvolvedStoresLockersService involvedStoresLockersService;
    @Autowired
    private InvolvedCaseService involvedCaseService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private UserService userService;

    @Override
    public InvolvedStoresBoxBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

//    @Action(value = Url.INVOLVED_STORES_BOX_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/box/show.jsp")})
//    public String index() throws Exception {
//        // 获取当前登录的用户
//        User user = this.getUser(request);
//        // 查询数据
//        service.pageQuery(getPageBean(), bean);
//        // 获取分页数据
//        List entityList = pageBean.getRows();
//        // 填充查询对象
//        request.setAttribute("searchObj", bean);
//        request.setAttribute("storeId", bean.getStoreId());
//        request.setAttribute("lockerId", bean.getLockerId());
//        // 填充分页对象
//        this.handlePageData(entityList, pageBean, request);
//        return "SUCCESS";
//    }

    @Action(value = Url.INVOLVED_STORES_BOX_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/box/imgShow.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        InvolvedStoresLockersBean involvedStoresLockersBean = involvedStoresLockersService.findInvolvedStoresLockersById(bean.getLockerId());
        request.setAttribute("involvedLocker", involvedStoresLockersBean);
        int col = 2;//横
        int row = 6;//竖
        String[] boxGroup = new String[(int) Math.ceil(Double.parseDouble(involvedStoresLockersBean.getLockerGate()) / (col * row))];//1组col * row个箱子
        String[] boxNum = new String[col * row];//1组col * row个箱子
        request.setAttribute("boxgroup", boxGroup);
        request.setAttribute("boxnum", boxNum);

        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List<InvolvedStoresBoxBean> entityList = pageBean.getRows();
        // 填充查询对象
        InvolvedStoresBoxBean[] involvedStoresBoxBeanArray = new InvolvedStoresBoxBean[Integer.parseInt(involvedStoresLockersBean.getLockerGate())];
        for (InvolvedStoresBoxBean a : entityList) {
            involvedStoresBoxBeanArray[Integer.parseInt(a.getBoxNo()) - 1] = a;
        }
        request.setAttribute("searchObj", bean);
        if (bean.getStoreId() != null) {
            request.setAttribute("lockerId", bean.getStoreId());
        }
        Map<String, String> isBoxUser = new HashMap<>();
        Map<String, Object> map = new HashMap();
        for (int i = 0; i < entityList.size(); i++) {
            if (user.getId().equals(entityList.get(i).getUserId())) {
                isBoxUser.put(entityList.get(i).getBoxNo(), "1");
            }
        }
        request.setAttribute("entityList", involvedStoresBoxBeanArray);
        request.setAttribute("isBoxUser", isBoxUser);

        String state = "-1";//-1不是，0保管员
        if (user.getId().equals(involvedStoresLockersBean.getUserId())) {
            state = "0";
        }
        state = user.getId().equals("1") ? "0" : state;
        request.setAttribute("state", state);
        return "SUCCESS";
    }

    @Action(value = Url.INVOLVED_STORES_BOX_PAGE_DATA)
    public void index1() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List<InvolvedStoresBoxBean> entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        if (bean.getLockerId() != null) {
            request.setAttribute("storesId", bean.getLockerId());
        }
        Map<String, String> isBoxUser = new HashMap();
        Map<String, Object> map = new HashMap();
        for (int i = 0; i < entityList.size(); i++) {
            if (user.getId().equals(entityList.get(i).getUserId())) {
                isBoxUser.put(entityList.get(i).getBoxNo(), "1");
            }
        }
        map.put("entityList", entityList);
        map.put("isBoxUser", isBoxUser);
        response.getWriter().write(jsonObject.toJSONString(map));
    }

    /**
     * 仓库箱子树
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_BOX_TREE_SHOW, results = {@Result(name = "INVOLVED_STORES_BOX_TREE", location = Url.VIEWS + "involved/box/show.jsp")})
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
        return "INVOLVED_STORES_BOX_TREE";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_STORES_BOX_ADD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "involved/box/add_update_show.jsp")})
    public String showAdd() {
        String storeId = request.getParameter("storeId");
        String lockerId = request.getParameter("lockerId");
        request.setAttribute("storeId", storeId);
        request.setAttribute("lockerId", lockerId);
        return "SUCCESS";
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_STORES_BOX_ADD_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        UserBean userBean = userService.findUserById(bean.getUserId());
        //获取当前毫秒数
        Calendar Cld = Calendar.getInstance();
        int MI = Cld.get(Calendar.MILLISECOND);
        bean.setBoxCode(userBean.getDeptId() + bean.getBoxNo() + MI);
        try {
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
    @Action(value = Url.INVOLVED_STORES_BOX_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "involved/box/add_update_show.jsp")})
    public String showEdit() {
        try {
            InvolvedStoresBoxBean resultBean = service.findInvolvedStoresBoxById(bean.getId());
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
    @Action(value = Url.INVOLVED_STORES_BOX_UPDATE_SUBMIT)
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
    @Action(value = Url.INVOLVED_STORES_BOX_DELETE_SUBMIT)
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
    @Action(value = Url.INVOLVED_STORES_BOX_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/box/detail.jsp")})
    public String getDetails() throws Exception {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            try {
                List<CriminalBean> criminalBeanList = criminalService.findDataAllByInvolvedBoxId(bean.getId());
                List<InvolvedCaseBean> involvedCaseBeanList =  involvedCaseService.findInvolvedCaseByBoxId(bean.getId());
                for (CriminalBean criminalBean : criminalBeanList) {
                    criminalBean.setInvolvedBeanList(new ArrayList<InvolvedBean>());
                    for (InvolvedCaseBean involvedCaseBean : involvedCaseBeanList) {
                        if(criminalBean.getCaseid().equals(involvedCaseBean.getCaseId())){
                            InvolvedBean involvedBean = involvedService.findInvolvedById(involvedCaseBean.getInvolvedId());
                            List<InvolvedBean> list = criminalBean.getInvolvedBeanList();
                                    list.add(involvedBean);
                        }
                    }
                }
                request.setAttribute("list", criminalBeanList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //List<InvovledStoresBoxBean>  list= service.selectDateById(bean);
            // 填充查询对象

            return "SUCCESS";
        }

    /**
     * 开箱
     */
    @Action(value = Url.INVOLVED_STORES_BOX_OPEN_BOX)
    public void remoteOpenBox() throws Exception{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        InvolvedStoresLockersBean involvedStoresLockersBean = involvedStoresLockersService.findInvolvedStoresLockersById(bean.getLockerId());
        //
        String path = involvedStoresLockersBean.getIntegration().equals("2") ? involvedStoresLockersBean.getPostPath() : involvedStoresLockersBean.getHost();
        try {
            StoreUtil.openBox(Integer.parseInt(bean.getBoxNo()),path);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 清箱
     *
     * @param cab：柜子编号
     * @param box：箱子编号
     */
    public String remoteClrBox(String cab, String box) {
        return StoreUtil.postToWebserviceByHttp("remoteClrBox", cab, box, "", "");
    }

    /**
     * 锁箱
     *
     * @param cab：柜子编号
     * @param box：箱子编号
     */
    public String remoteLockBox(String cab, String box) {
        return StoreUtil.postToWebserviceByHttp("remoteLockBox", cab, box, "", "");
    }

    /**
     * 解锁
     *
     * @param cab：柜子编号
     * @param box：箱子编号
     */
    public String remoteUnfreezeBox(String cab, String box) {
        return StoreUtil.postToWebserviceByHttp("remoteUnfreezeBox", cab, box, "", "");
    }

    /**
     * 设备重启
     *
     * @param cab：柜子编号
     * @param box：箱子编号
     */
    public String restartCabnient(String cab, String box) {
        return StoreUtil.postToWebserviceByHttp("restartCabnient", box, cab, "", "");
    }
}
