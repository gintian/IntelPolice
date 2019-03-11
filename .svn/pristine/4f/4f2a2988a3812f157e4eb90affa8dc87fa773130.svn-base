package com.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.model.bean.MenuBean;
import com.page.PageBean;

public class StringUtil {
	/** 
     * 本方法封装了往前台设置的header,contentType等信息 
     * @param message       需要传给前台的数据 
     * @param type          指定传给前台的数据格式，如"html","json"等 
     * @param response      HttpServletResponse对象 
     * @throws IOException 
     */  
    public static void writeToWeb(String message, String type, HttpServletResponse response) throws IOException{  
        response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setContentType("text/" + type +"; charset=utf-8");  
        response.getWriter().write(message);  
        response.getWriter().close();  
          
    }  
      
    /** 
     * List,Total转JSON字符串并传回页面
     * @param list 
     * @param total 
     * @throws Exception 
     */  
    public static void toBeJson(List list, int total) throws Exception{  
        HttpServletResponse response = ServletActionContext.getResponse();  
        HttpServletRequest request = ServletActionContext.getRequest();  
        JSONObject jobj = new JSONObject();  
        jobj.put("total", total);  
        jobj.put("rows", list);  
        response.setCharacterEncoding("utf-8");  
        String json = JSON.toJSONStringWithDateFormat(jobj,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
//        json=json.substring(4, json.length()-1);
        response.getWriter().write(json);  
    }  
    /**
     * PageBean转JSON字符串并传回页面
     * @param pageBean
     * @throws Exception
     */
	public static void pageToJson(PageBean pageBean) throws Exception{ 
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(pageBean);
			String json = JSON.toJSONStringWithDateFormat(jsonObject,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
			ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().print(json);
	}

    /**
     * 将数据库的json 字符串转为菜单需要的字符串
     * @param str
     */
	public static org.json.JSONArray formatJsonToMenu(){
        //查询顶级菜单
        List<MenuBean> rootList = SysMenuVo.findByEqParentId("01");
        List<org.json.JSONObject> rootJson = new ArrayList<>();
        for (MenuBean menu : rootList){
            org.json.JSONObject jsonobj = StringUtil.formatJsonObject(new org.json.JSONObject(menu));
            List<org.json.JSONObject> list2 = new ArrayList<>();
            for (MenuBean menu2 : SysMenuVo.findByEqParentId(menu.getId())){
                org.json.JSONObject jsonobj2 = StringUtil.formatJsonObject(new org.json.JSONObject(menu2));
                List<org.json.JSONObject> list3 = new ArrayList<>();
                for (MenuBean menu3 : SysMenuVo.findByEqParentId(menu2.getId())){
                    org.json.JSONObject jsonobj3 = StringUtil.formatJsonObject(new org.json.JSONObject(menu3));
                    list3.add(jsonobj3);
                }
                jsonobj2.put("children", list3);
                list2.add(jsonobj2);
            }
            jsonobj.put("children", list2);
            rootJson.add(jsonobj);
        }
        return new JSONArray(rootJson);
    }
    public static org.json.JSONObject formatJsonObject(org.json.JSONObject objJsonObject){
        org.json.JSONObject resultJsonObject = new org.json.JSONObject();
        resultJsonObject.put("name", objJsonObject.get("name"));
        try {
            resultJsonObject.put("url", objJsonObject.get("request"));
            resultJsonObject.put("id", "menu" + objJsonObject.get("id"));
            resultJsonObject.put("target","navtab");
        }catch (Exception e){
            System.out.println("不做处理");
        }
        return  resultJsonObject;
    }
}  