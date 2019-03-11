package com.action;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.utils.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Url;
import com.model.bean.FileBean;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public class UploadAction extends BaseAction<FileBean> implements ModelDriven<FileBean> {
    private FileBean bean = new FileBean();

    @Override
    public FileBean getModel() {
        return bean;
    }

    //根路径，到时可以换成ftp 路径
    private String basePath = CommonConstant.FILE_UPLOAD_PATH;
    //分割字符串
    private String regex = CommonConstant.FILE_UPLOAD_REGEX;


    private static List<JSONObject> fileList = new ArrayList<JSONObject>();
    int i= 0;
    /**
     * 文件上传
     *
     * @throws Exception
     */
    @Action(value = Url.FILE_UPLOAD)
    public void fileUpload() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;

        try {
            for (int i = 0; i < bean.getFile().size(); i++) {
                //文件名称
                String name = bean.getFileFileName().get(i);
                String fileName = ServiceUtils.generatePrimaryKey() + name.substring(name.lastIndexOf("."));
                //文件路径
                String filePath = DateUtils.dateToString(new Date(), "/yyyy/MM/dd/HH");
                //目标文件
                File diestFile = new File(basePath + filePath, fileName);
//                System.out.println(filePath + fileName);
//                System.out.println(diestFile.getPath());
                FileUploadUtils.upload(bean.getFile().get(i), diestFile);
                jsonObject = new JSONObject();
                jsonObject.put("statusCode", 200);
                double fileSize = bean.getFile().get(i).length();
                String size = "";
                if (fileSize < 1000) {
                    size = fileSize + "B";
                };
                if (fileSize >= 1000) {
                    fileSize = fileSize / 1000;
                    size = fileSize + "KB";
                };
                if (fileSize >= 1000) {
                    fileSize = fileSize / 1000;
                    size = fileSize + "MB";
                };
                jsonObject.put("name", bean.getFileFileName().get(i));
                jsonObject.put("size", size);
                jsonObject.put("path", filePath + "/" + fileName);
                jsonObject.put("message", "上传成功");


            }
            List<JSONObject> fileList1 = (List) request.getSession().getAttribute("fileList");
            if(fileList1 == null){
                fileList1 = new ArrayList<>();
            }
                fileList1.add(jsonObject);
                request.getSession().setAttribute("fileList", fileList1);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().write(jsonObject.toJSONString());
        request.getSession().setAttribute("file", jsonObject);
        //request.getSession().setAttribute("files", fileList);
    }

    /**
     * 文件下载
     *
     * @throws Exception
     */
    @Action(value = Url.FILE_DOWNLOAD)
    public void fileDownload() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        //文件路径
        String a =  request.getParameter("path");
        String b="";
        for (int i = 0;i<a.length();i++){
            if(a.charAt(i) != '"'){
                b +=a.charAt(i);
            }
        }
        String filePath = CommonConstant.FILE_UPLOAD_PATH + b;

        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;
        boolean isOnLine = true;
        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }


////        文件名称
//        String fileName = request.getParameter("name") + "";
//
//        response.reset();
//        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//        response.setHeader("Connection", "close");
//        response.setHeader("Content-Type", "application/pdf");
//
//        OutputStream ops = null;
//        FileInputStream fis = null;
//        byte[] buffer = new byte[8192];
//        int bytesRead = 0;
//
//        try {
//            ops = response.getOutputStream();
//            fis = new FileInputStream(filePath);
//            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
//                ops.write(buffer, 0, bytesRead);
//            }
//            ops.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//                if (ops != null) {
//                    ops.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }}

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.ACTIVITI_ADD_SUBMIT)
    public void addActiviti() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            for (int i = 0; i < bean.getFile().size(); i++) {
                //目标文件
                FileInputStream fls = new FileInputStream(bean.getFile().get(i));
                ActivitiUtils.saveDeploye(fls, bean.getFileFileName().get(i));

                jsonObject = new JSONObject();
                jsonObject.put("statusCode", 200);
                jsonObject.put("message", "上传成功");
                break;
            }

        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
}
