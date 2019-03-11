package com.action;

import com.alibaba.fastjson.JSONObject;
import com.exception.WebMessageException;
import com.model.BpipUser;
import com.model.RecordCase;
import com.model.User;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.page.PageBean;
import com.constant.CommonConstant;
import com.service.*;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.constant.Url;
import com.model.Record;
import com.opensymphony.xwork2.ModelDriven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 类名称：RecordAction 类描述：笔录的实现
 */
// @ParentPackage("json-default")
@Action(value = Url.RECORD)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class RecordAction extends BaseAction<Record> implements ModelDriven<Record> {
    private RecordBean bean = new RecordBean();

    public RecordBean getModel() {
        return bean;
    }

    @Autowired
    private RecordService recordService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private BpipUserService bpipUserService;
    @Autowired
    private RecordTypeService recordTypeService;
    @Autowired
    private RecordPersonService recordPersonService;
    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.RECORD_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "record/show.jsp")})
    public String index() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        recordService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.RECORD_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/record/add_trial_show.jsp")})
    public String showAdd() {
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            recordService.addBean(bean,null);
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
    @Action(value = Url.RECORD_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/record/add_update_show.jsp")})
    public String showEdit() {
        try {
            RecordBean resultBean = recordService.findRecordById(bean.getId());
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
    @Action(value = Url.RECORD_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            recordService.updateBean(bean.getId(), bean);
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
    @Action(value = Url.RECORD_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            recordService.deleteBean(bean.getId());
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
    @Action(value = Url.RECORD_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/record/detail.jsp")})
    public String getMenuById() throws Exception {
        try {
            RecordBean bean2 = recordService.findRecordById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
    /**
     * 选择人员
     *
     * @return
     */
    @Action(value = Url.RECORD_PERSON_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/messageManage/person.jsp")})
    public String showPerson() {
        try {

            List<RecordTypeBean> recordTypeBeanList = recordTypeService.findAllByLevel();
            List<RecordTypeBean> recordTypeOneList = new ArrayList<RecordTypeBean>();
            for(int i = 0; i < recordTypeBeanList.size(); i++){
                if(recordTypeBeanList.get(i).getParentid() != null){
                    if(recordTypeBeanList.get(i).getParentid().equals("01")){
                        recordTypeOneList.add(recordTypeBeanList.get(i));
                    }
                }
            }
            if(recordTypeOneList.size() > 0){
                for(RecordTypeBean RecordTypeOne:recordTypeOneList){
                    RecordTypeOne.setSonList(new ArrayList<RecordTypeBean>());
                    for(RecordTypeBean RecordType:recordTypeBeanList){
                        if(RecordTypeOne.getId().equals(RecordType.getParentid())){
                            RecordTypeOne.getSonList().add(RecordType);
                        }
                    }
                }
                for(RecordTypeBean RecordTypeOne:recordTypeOneList){
                    if(RecordTypeOne.getSonList().size() > 0){
                        for(RecordTypeBean RecordTypeTwo:RecordTypeOne.getSonList()){
                            RecordTypeTwo.setSonList(new ArrayList<RecordTypeBean>());
                            for(RecordTypeBean RecordType:recordTypeBeanList){
                                if(RecordTypeTwo.getId().equals(RecordType.getParentid())){
                                    RecordTypeTwo.getSonList().add(RecordType);
                                }
                            }
                        }
                    }

                }
            }
            request.setAttribute("recordTypeBeanList", recordTypeOneList);


            //获取当前登录的用户
            User user = this.getUser(request);
            request.setAttribute("status", request.getParameter("status"));
            String caseId = request.getParameter("caseid");
            BpipUser bpipUser = bpipUserService.findBpipUserById(caseId);
            request.setAttribute("entity", user);
            request.setAttribute("caseIdPerson", caseId);
            request.setAttribute("bpipUser", bpipUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
    //查看笔录
    @Action(value = Url.RECORD_INFOS_CASE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "/record/case_show.jsp")})
    public String showCaseAddShow() {
        //获取案件编号
        String caseId = request.getParameter("caseId");
        //获取案件信息
        CriminalBean criminalBean = new CriminalBean();
        try {
            criminalBean = criminalService.findCriminalById(caseId);
            //查询对应号所以数据
            List<RecordBean> list = recordService.selectDataAllEqCaseId(criminalBean.getCaseid());
            request.setAttribute("criminalBean",criminalBean);
            request.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 添加笔录
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_ADD_CASE_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        request.getSession().removeAttribute("record-person");
        try {
            String caseId = request.getParameter("caseId");
            RecordCaseBean recordCaseBean = new RecordCaseBean();
            recordCaseBean.setCaseId(caseId);
            //获取当前登录的用户
            User user = this.getUser(request);
            String type = request.getParameter("typeIdasd");
            //生成笔录问题编码
            String code = RandomUtils.RandomCode("R",user.getDeptId());
            bean.setCode(code);
            recordService.addBean(bean,recordCaseBean);
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
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
    @Action(value = Url.RECORD_MESSSAGEMANAGE_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = "/WEB-INF/views/record/messageManage/in_writing_detail.jsp"),
                       @Result(name = "SUCCESS1", location = "/WEB-INF/views/record/messageManage/identification_detail.jsp")})
    public String getMenu() throws Exception {
        try {
            RecordBean bean2 = recordService.findRecordById(bean.getId());

            //案件信息
            String caseId = request.getParameter("caseId");
            request.setAttribute("caseS",criminalService.findCriminalById(caseId));
            request.setAttribute("entity", bean2);
            String modelId = request.getParameter("modelId");
            if("001".equals(modelId)){
                request.setAttribute("person",recordPersonService.findRecordById(bean2.getBxwr()));
                return "SUCCESS";
            }else{
                request.setAttribute("person",recordPersonService.findRecordById(bean2.getBrr()));
                List<RecordPersonBean> personList = new ArrayList<>();
                if(bean2.getBbrr1() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr1()));
                if(bean2.getBbrr2() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr2()));
                if(bean2.getBbrr3() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr3()));
                if(bean2.getBbrr4() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr4()));
                if(bean2.getBbrr5() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr5()));
                if(bean2.getBbrr6() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr6()));
                if(bean2.getBbrr7() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr7()));
                if(bean2.getBbrr8() != null) personList.add(recordPersonService.findRecordById(bean2.getBbrr8()));
                request.setAttribute("personList",personList);
                return "SUCCESS1";
            }
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
}
