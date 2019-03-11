package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Url;
import com.model.Record;
import com.model.bean.RecordPersonBean;
import com.service.FilesService;
import com.utils.DateUtils;
import com.utils.ExecuteResult;
import com.utils.ReportUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
@SuppressWarnings("serial")
@Action(value = Url.REPORT)
@ParentPackage("jasperreports-default")
public class ReportAction {
    private HttpServletRequest request = ServletActionContext.getRequest();    //获取httpServletRequest对象
    private HttpServletResponse response = ServletActionContext.getResponse();    //获取httpServletRequest对象
@Autowired
   private FilesService filesService;
    /**
     * 展示-分页
     *
     * @return
     */
    @Action(value = Url.REPORT_DATA,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/print/show.jsp") })
    public String reportData() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        List list = new ArrayList();
        map.put("reportTitle", "xxx报表");
        map.put("printTime", "2018-07-25 14:56:30");
        Map<String, Object> maps = new HashMap<String, Object>();
        for (int i = 1; i <= 10; i++) {
            maps = new HashMap<String, Object>();
            maps.put("index", i);
            maps.put("cwmc", "财物名称" + i);
            maps.put("cwsl", i);
            maps.put("cwtz", "CWTZ" + i);
            maps.put("ivalue", "IVALUE" + i);
            maps.put("bz", "备注" + i);
            maps.put("clspyj", "clspyj" + i);
            maps.put("clspryxm", "clspryxm" + i);
            maps.put("cwbm", "财物编码" + i);
            list.add(maps);
        }
        //这里调用
//        ReportUtils.compileReportToFile("/report/test.jrxml");
        String filePath = ReportUtils.runReportToHtmlFile("/report/test.jrxml",list,map,"testReport");
        return "SUCCESS";
    }

    /**
     * 笔录打印
     *
     * @return
     */
    @Action(value = Url.REPORT_RECORD_DATA)
    public void reportRecordData() throws Exception{
        String user = request.getParameter("user");
        RecordPersonBean recordPersonBean = (RecordPersonBean) request.getSession().getAttribute("record-person");
        String user1= request.getParameter("user1");
        String content= request.getParameter("content").replace("<br>","\r\n");
        String record_start_time= request.getParameter("record_start_time");
        String record_end_time= request.getParameter("record_end_time");
        String sex = "";
        if (recordPersonBean.getIdcard().length() == 15) {
            String num = recordPersonBean.getIdcard().substring(14, 15);
            sex = Integer.parseInt(num) % 2 == 0 ? "女" : "男";
        }
        if(recordPersonBean.getIdcard().length() == 18){
            String num = recordPersonBean.getIdcard().substring(16, 17);
            sex = Integer.parseInt(num) % 2 == 0 ? "女" : "男";
        }
        Map<String, Object> map = new HashMap<String, Object>();
        List list = new ArrayList();
        map.put("reportTitle", "笔录");
        map.put("printTime", DateUtils.getCurrentDateTime());
        Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("record_start_time", record_start_time);
            maps.put("record_end_time", record_end_time);
            maps.put("personName", recordPersonBean.getName());
            maps.put("personSex1", sex);
            maps.put("personAge", IdNOToAge(recordPersonBean.getIdcard()));
            maps.put("personBirth", getBirthByIdCard(recordPersonBean.getIdcard()));
            maps.put("personIdcard", recordPersonBean.getIdcard());
            maps.put("personAddress", recordPersonBean.getBxwrAddr());
            maps.put("personPhone", recordPersonBean.getBxwrPhone());
            maps.put("personIsrddb", recordPersonBean.getIsrddb().equals("0") ? "是" : "否");
            maps.put("content", content.trim());
            list.add(maps);

        //这里调用
//        ReportUtils.compileReportToFile("/report/test.jrxml");
        String filePath = ReportUtils.runReportToHtmlFile("/2018/08/16/11/","d40dce75-083a-496a-8948-dfee60b92644.jrxml",list,map,"record");
        String b="";
        for (int i = 0;i<filePath.length();i++){
            if(filePath.charAt(i) != '"'){
                b +=filePath.charAt(i);
            }
        }
        JSONObject jsonObject = null;
        response.getWriter().write(jsonObject.toJSONString(b));
    }

    //根据身份证号输出年龄
    public static int IdNOToAge(String IdNO){
        int leh = IdNO.length();
        String dates="";
        if (leh == 18) {
            int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year=df.format(new Date());
            int u=Integer.parseInt(year)-Integer.parseInt(dates);
            return u;
        }else{
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }

    }
    public static String getBirthByIdCard(String idCard) {
        String year = idCard.substring(6, 10);// 截取年
        String month = idCard.substring(10, 12);// 截取月份
        String day = idCard.substring(12, 14);// 截取天
        return year + "年 " + month + "月 " + day + "日";
    }
}
