package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.RecordQuestion;
import com.model.User;
import com.model.bean.CodeBean;
import com.model.bean.MenuBean;
import com.model.bean.RecordQuestionBean;
import com.model.bean.RecordTypeBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CodeService;
import com.service.MenuService;
import com.service.RecordTypeService;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 类名称：RecordQuestionAction 类描述：笔录问题
 */
@SuppressWarnings("serial")
// @ParentPackage("json-default")
@Action(value = Url.RECORD_QUESTION_TYPE)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class RecordQuestionTypeAction extends BaseAction<RecordTypeBean> implements ModelDriven<RecordTypeBean> {
    private RecordTypeBean bean = new RecordTypeBean();

    @Override
    public RecordTypeBean getModel() {
        return bean;
    }

    @Autowired
    private RecordTypeService recordTypeService;
    ActionContext context = ActionContext.getContext();
    Map<String, Object> session = context.getSession();

    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 显示菜单视图
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.RECORD_QUESTION_TYPE_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "record/questionType/show.jsp")})
    public String menuListTree() throws Exception {
        List<RecordTypeBean> recordTypeBeanList = recordTypeService.findMenuBeanList();
        request.setAttribute("recordTypeBeanList", recordTypeBeanList);
        return "SUCCESS";
    }
    /**
     *
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_QUESTION_TYPE_PAGE_SHOWLIST)
    public void showList() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        List<RecordTypeBean> recordTypeBeanList = recordTypeService.findAllByLevel();
        response.getWriter().write(jsonObject.toJSONString(recordTypeBeanList));
    }
    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.RECORD_QUESTION_TYPE_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/questionType/add_update_show.jsp")})
    public String showAdd() {
        try {
            request.setAttribute("entity", bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_QUESTION_TYPE_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            String json1= request.getParameter("json");//接收输入数据
            JSONArray jsonArray = JSON.parseArray(json1);
            JSONObject jsonO = jsonArray.getJSONObject(0);
            RecordTypeBean r = JSONObject.toJavaObject(jsonO,RecordTypeBean.class);
            String order =  r.getOrder();
            r.setSortNo(order);
            String leaf = r.isAddFlag() == true ? "0" : "1";
            r.setOrder(leaf);
            if(r.getId() == null){
                recordTypeService.addMenuBean(r);
                RecordTypeBean r1 = new RecordTypeBean();
                if(r.getParentid() != null){
                    r1.setOrder("1");
                    r1.setId(r.getParentid());
                    recordTypeService.updateMenuBean(r1.getId(), r1);
                }
            }else{
                recordTypeService.updateMenuBean(r.getId(), r);
            }

            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.RECORD_QUESTION_TYPE_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location =Url.VIEWS + "record/questionType/add_update_show.jsp")})
    public String showUpdate() {
        try {
            String typeId = request.getParameter("id");
            RecordTypeBean recordTypeBean = recordTypeService.findMenuByMenuId(typeId);
            request.setAttribute("entity", recordTypeBean);
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
    @Action(value = Url.RECORD_QUESTION_TYPE_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            recordTypeService.updateMenuBean(bean.getId(), bean);
           // recordTypeService.doCacheMenu();
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
    @Action(value = Url.RECORD_QUESTION_TYPE_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            String json1= request.getParameter("json");//接收输入数据
            JSONArray jsonArray = JSON.parseArray(json1);
            JSONObject jsonO = jsonArray.getJSONObject(0);
            RecordTypeBean r = JSONObject.toJavaObject(jsonO,RecordTypeBean.class);
            recordTypeService.deleteMenuBean(r.getId());
            //recordTypeService.doCacheMenu();
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }


    /**
     * 显示菜单字符串
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_QUESTION_TYPE_DETAIL_SHOW)
    public void getMenuAll() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        String menulist = "";
        try {
            menulist = recordTypeService.showMenuAll(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write(menulist);
    }
}
