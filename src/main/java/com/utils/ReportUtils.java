package com.utils;

import com.constant.CommonConstant;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ReportUtils {
    protected static final String  PDF_PATH = "/download/";

    /**
     * 生产 .jasper 文件 并生成PDF文件
     * @param sourceFileName
     * 			.jrxml文件的位置
     * @param destFileName
     * 			生成 .jasper 文件的名称
     * @param list
     * 			需要循环打印的集合
     * @param map
     * 			打印一次的参数（标题，表头、表尾的数据）
     * @param title
     * 			PDF文件的名称
     * @param code
     * 			打印的单号 （title + code = PDF文件名）
     * @return	返回PDF文件所在的路径
     * @throws Exception
     */
    public static String runReportToPdfFile(String sourceFileName, String  destFileName, List list,
                                            Map<String, Object> map, String title, String code) throws Exception{

        ServletContext context = ServletActionContext.getServletContext();
        //获取.jrxml 在磁盘的根路径
        String reportSource = context.getRealPath(sourceFileName);
        //获取.jrxml 在磁盘的上级目录
        File parent = new File(reportSource).getParentFile();
        //获取.jasper 在磁盘的路径
        String destFilePath = new File(parent, destFileName).getAbsolutePath();
        // 将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
        JasperCompileManager.compileReportToFile(reportSource, destFilePath);
        //转换list集合
        JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        //生成PDF文件和web PDF文件并返回PDF文件路径
        String pdfPaht = JasperRunManager.runReportToPdfFile(destFilePath, map, jrDataSource);
        //旧的PDF文件
        File oldpath = new File(pdfPaht);
        //获取磁盘下 项目的 PDF_PATH 路径
        String dpfPath = context.getRealPath(PDF_PATH)+ File.separator;
        //获取项目的  PDF_PATH 路径
        String realPath = context.getRealPath("/")+ PDF_PATH;
        File dir = new File(realPath);
        if (!dir.exists()) {// 没有目录就创建目录
            dir.mkdirs();
        }
        //PDF文件名称
        String name = title + "_" + code +".pdf";
        //新PDF文件名称及路径
        File savePDFFile = new File(dpfPath, name);
        //把旧PDF文件copy到新文件路径
        FileUtils.copyFile(oldpath, savePDFFile);
        //删除旧PDF文件
        oldpath.delete();

        return realPath + name;
    }

    /**
     * 生产 .jasper 文件 并生成PDF文件
     * @param sourceFileName
     * 			.jrxml文件的位置
     * @param list
     * 			需要循环打印的集合
     * @param map
     * 			打印一次的参数（标题，表头、表尾的数据）
     * @param title
     * 			PDF文件的名称
     * @return 返回PDF文件所在的路径
     * @throws Exception
     */
    public static String runReportToPdfFile(String sourceFileName,List list,
                                            Map<String, Object> map,String title) throws Exception{

        ServletContext context = ServletActionContext.getServletContext();
        //获取.jrxml 在磁盘的根路径
        String reportSource = context.getRealPath(sourceFileName);
        //获取.jrxml 在磁盘的上级目录
        File parent = new File(reportSource).getParentFile();
        //获取.jasper 在磁盘的路径
        String[] destFileNames = sourceFileName.split("/");
        String destFileName = destFileNames[destFileNames.length-1];
        destFileName = destFileName.substring(0,destFileName.length()-6) ;
        String destFilePath = new File(parent, destFileName + ".jasper").getAbsolutePath();
        // 将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
        JasperCompileManager.compileReportToFile(reportSource, destFilePath);


        //转换list集合
        JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        //生成PDF文件和web PDF文件并返回PDF文件路径
        String pdfPaht = JasperRunManager.runReportToPdfFile(destFilePath, map, jrDataSource);
        //旧的PDF文件
        File oldpath = new File(pdfPaht);
        //获取磁盘下 项目的 DPF_PATH 路径
        String dpfPath = context.getRealPath(PDF_PATH)+ File.separator;
        //获取项目的  DPF_PATH 路径
        String realPath = context.getRealPath("/")+ PDF_PATH;
        File dir = new File(realPath);
        if (!dir.exists()) {// 没有目录就创建目录
            dir.mkdirs();
        }
        //PDF文件名称
        if(title.equals("null") || title == null || title == ""){
            title = destFileName;
        }
        String name = title + ".pdf";
        //新PDF文件名称及路径
        File savePDFFile = new File(dpfPath, name);
        //把旧PDF文件copy到新文件路径
        FileUtils.copyFile(oldpath, savePDFFile);
        //删除旧PDF文件
        oldpath.delete();

        return realPath + name;

    }

    /**
     * 生产 .jasper 文件 并生成PDF文件
     * @param sourceFileName
     * 			.jrxml文件的位置
     * @param list
     * 			需要循环打印的集合
     * @param map
     * 			打印一次的参数（标题，表头、表尾的数据）
     * @param title
     * 			PDF文件的名称
     * @return 返回PDF文件所在的路径
     * @throws Exception
     */
    public static String runReportToHtmlFile(String sourceFileName,List list,
                                            Map<String, Object> map,String title) throws Exception{

        ServletContext context = ServletActionContext.getServletContext();
        //获取.jrxml 在磁盘的根路径
        String reportSource = context.getRealPath(sourceFileName);
        //获取.jrxml 在磁盘的上级目录
        File parent = new File(reportSource).getParentFile();
        //获取.jasper 在磁盘的路径
        String[] destFileNames = sourceFileName.split("/");
        String destFileName = destFileNames[destFileNames.length-1];
        destFileName = destFileName.substring(0,destFileName.length()-6) ;
        String destFilePath = new File(parent, destFileName + ".jasper").getAbsolutePath();
        // 将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
        JasperCompileManager.compileReportToFile(reportSource, destFilePath);


        //转换list集合
        JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        //生成PDF文件和web HTML文件并返回HTML文件路径
        String htmlPath = JasperRunManager.runReportToHtmlFile(destFilePath, map, jrDataSource);
        //旧的PDF文件
        File oldpath = new File(htmlPath);
        //获取磁盘下 项目的 PDF_PATH 路径
        String dpfPath = context.getRealPath(PDF_PATH)+ File.separator;
        //获取项目的  DPF_PATH 路径
        String realPath = context.getRealPath("/")+ PDF_PATH;
        File dir = new File(realPath);
        if (!dir.exists()) {// 没有目录就创建目录
            dir.mkdirs();
        }
        //PDF文件名称
        if(title.equals("null") || title == null || title == ""){
            title = destFileName;
        }
        String name = title + ".html";
        //新PDF文件名称及路径
        File savePDFFile = new File(dpfPath, name);
        //把旧PDF文件copy到新文件路径
        FileUtils.copyFile(oldpath, savePDFFile);
        //删除旧PDF文件
        oldpath.delete();

        return realPath + name;
    }
    /**
     * 生成 .jasper 文件
     * @param sourceFileName
     * 			.jrxml文件的位置
     * @throws Exception
     */
    public static void compileReportToFile(String sourceFileName) throws Exception{
        String reportSource = ServletActionContext.getServletContext().getRealPath(sourceFileName);
        File parent = new File(reportSource).getParentFile();
        String[] destFileNames = sourceFileName.split("/");
        String destFileName = destFileNames[destFileNames.length-1];
        destFileName = destFileName.substring(0,destFileName.length()-6) + ".jasper";
        // 将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
        JasperCompileManager.compileReportToFile(reportSource, new File(parent, destFileName).getAbsolutePath());
    }

    /**
     * 生产 .jasper 文件 并生成PDF文件
     * @param sourceFileName
     * 			.jrxml文件的位置
     * @param list
     * 			需要循环打印的集合
     * @param map
     * 			打印一次的参数（标题，表头、表尾的数据）
     * @param title
     * 			PDF文件的名称
     * @return 返回PDF文件所在的路径
     * @throws Exception
     */
    public static String runReportToHtmlFile(String sourceFileName, String sourceFilePath,List list,
                                             Map<String, Object> map,String title) throws Exception{

        ServletContext context = ServletActionContext.getServletContext();
        //获取.jrxml 在磁盘的根路径
        String reportSource =CommonConstant.FILE_UPLOAD_PATH +sourceFileName + sourceFilePath;
        //获取.jrxml 在磁盘的上级目录
        File parent = new File(reportSource).getParentFile();
        //获取.jasper 在磁盘的路径
        String[] destFileNames = reportSource.split("/");
        String destFileName = destFileNames[destFileNames.length-1];
        destFileName = destFileName.substring(0,destFileName.length()-6) ;
        String destFilePath = new File(parent, destFileName + ".jasper").getAbsolutePath();
        // 将.jrxml模板文件编译成为.jasper文件,当然,其文件名可以指定,如果没指定,则与.jrxml文件名一样.只是后缀不同而已
        try{JasperCompileManager.compileReportToFile(reportSource, destFilePath);}catch (Exception e){
            e.printStackTrace();
        }
//转换list集合
        JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(list);
//生成PDF文件和web HTML文件并返回HTML文件路径
        String htmlPath = null;
        try{
            htmlPath = JasperRunManager.runReportToPdfFile(destFilePath, map, jrDataSource);
        }catch (Exception e){
            e.printStackTrace();
        }

//旧的PDF文件
        File oldpath = new File(htmlPath);
        File oldParentpath=oldpath.getParentFile();
//获取磁盘下 项目的 PDF_PATH 路径
        String dpfPath = context.getRealPath(PDF_PATH)+ File.separator;
//获取项目的  DPF_PATH 路径
        String realPath = context.getRealPath("/")+ PDF_PATH;
        File dir = new File(realPath);
        if (!dir.exists()) {// 没有目录就创建目录
            dir.mkdirs();
        }
//PDF文件名称
        if(title.equals("null") || title == null || title == ""){
            title = destFileName;
        }
        String name = ServiceUtils.generatePrimaryKey() + ".pdf";
        //新PDF文件名称及路径
        File savePDFFile = new File(oldParentpath, name);
        //把旧PDF文件copy到新文件路径
        FileUtils.copyFile(oldpath, savePDFFile);
        //删除旧PDF文件
         //oldpath.delete();
        return sourceFileName + name;

    }


}
