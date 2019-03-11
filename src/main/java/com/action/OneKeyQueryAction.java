package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.User;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.*;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类名称：OneKeyQueryAction 类描述：一键查询的实现
 */
@SuppressWarnings("serial")
// @ParentPackage("json-default")
@Action(value = Url.ONEKEYQUERY)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class OneKeyQueryAction extends BaseAction<OneKeyQueryBean> implements ModelDriven<OneKeyQueryBean> {
    @Autowired
    private JJService jjService;//接警类
    @Autowired
    private CJService cjService;//出警类
    @Autowired
    private CriminalService criminalService;//案件类
    @Autowired
    private RecordService recordService;//笔录类
    @Autowired
    private InvolvedService involvedService;//财务类
    @Autowired
    private ArchiveService archiveService;//卷宗类


    private OneKeyQueryBean bean = new OneKeyQueryBean();

    @Override
    public OneKeyQueryBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();


    @Action(value = Url.ONEKEYQUERY_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "oneKeyQuery/show.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        String code = request.getParameter("code");//编号
        String type = request.getParameter("type");//0案件，1接警，2处警
        request.setAttribute("code",code);
        request.setAttribute("type",type);
        if(code !=null && code.trim().length() > 0){
            String message = "暂无数据";
            request.setAttribute("message",message);
        }
        try {
            CriminalBean criminalBean = null;
            CJBean cjBean = null;
            JJBean jjBean = null;
            if(code !=null && code.trim().length() > 0){
                if("0".equals(type)){
                    criminalBean = criminalService.findCriminalById(code);
                    if(criminalBean != null){
                        jjBean = jjService.findJJBycaseId(criminalBean.getCaseid());
                        if(jjBean != null){
                            cjBean = cjService.findCJByJjdbh(jjBean.getJjdbh());
                        }
                    }
                }
                if("1".equals(type)){
                    jjBean = jjService.findJJByJjdbh(code);
                    if(jjBean != null){
                        cjBean = cjService.findCJByJjdbh(jjBean.getJjdbh());
                        criminalBean = criminalService.findCriminalByJJId(jjBean.getJjdbh());
                    }
                }
                if("2".equals(type)){
                    cjBean = cjService.findCJAndJJById(code);
                    jjBean = cjBean.getJJBean();
                    if(jjBean != null){
                        criminalBean = criminalService.findCriminalByJJId(jjBean.getJjdbh());
                    }
                }
                if(criminalBean != null){
                    List<RecordBean> recordBeanList =  recordService.selectDataAllEqCaseId(criminalBean.getCaseid());
                    List<InvolvedBean> involvedBeanList = involvedService.findByCaseId(criminalBean.getCaseid());
                    List<ArchiveBean> archiveBeanList = archiveService.selectDataAllEqCaseId(criminalBean.getCaseid());
                    request.setAttribute("recordBeanList",recordBeanList);
                    request.setAttribute("involvedBeanList",involvedBeanList);
                    request.setAttribute("archiveBeanList",archiveBeanList);
                }
                request.setAttribute("criminalBean",criminalBean);
                request.setAttribute("jjBean",jjBean);
                request.setAttribute("cjBean",cjBean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SUCCESS";
    }
}