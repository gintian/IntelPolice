/*package com.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
  
@SuppressWarnings( { "deprecation" })  
public class ExcelUtil<T> {  
  
//    public static void main(String[] args) throws Exception {  
//        String sheetName = "用车统计表单";  
//        String titleName = "用车申请数据统计表";  
//        String fileName = "用车申请统计表单";  
//        int columnNumber = 3;  
//        int[] columnWidth = { 10, 20, 30 };  
//        String[][] dataList = { { "001", "2015-01-01", "IT" },  
//                { "002", "2015-01-02", "市场部" }, { "003", "2015-01-03", "测试" } };  
//        String[] columnName = { "单号", "申请时间", "申请部门" };  
//        new ExcelUtil().ExportNoResponse(sheetName, titleName, fileName,  
//                columnNumber, columnWidth, columnName, dataList);  
//    }  
	
	public void export(String className,List<T> dataList,HttpServletResponse response) throws Exception {
		String sheetName= className+"统计表单"; 
		String titleName = className+"数据统计表";  
		String fileName = className+"统计表单";  
		new ExcelUtil<T>().ExportWithResponse(sheetName, titleName, fileName,dataList, response);
	}
  
    public void ExportWithResponse(String sheetName, String titleName,  
            String fileName, List<T> dataList,  
            HttpServletResponse response) throws Exception {  
//    	public void ExportWithResponse(String sheetName, String titleName,  
//    			String fileName, int columnNumber, int[] columnWidth,  
//    			String[] columnName, List<T> dataList,  
//    			HttpServletResponse response) throws Exception {  
            // 第一步，创建一个webbook，对应一个Excel文件  
            XSSFWorkbook wb = new XSSFWorkbook();  
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            XSSFSheet sheet = wb.createSheet(sheetName);  
             sheet.setDefaultColumnWidth(15); //统一设置列宽  
            
            // 创建第0行 也就是标题  
            HSSFRow row1 = sheet.createRow((int) 0);  
            row1.setHeightInPoints(50);// 设备标题的高度  
            // 第三步创建标题的单元格样式style2以及字体样式headerFont1  
            HSSFCellStyle style2 = wb.createCellStyle();  
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
            style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);  
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
            HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式  
            headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
            headerFont1.setFontName("黑体"); // 设置字体类型  
            headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小  
            style2.setFont(headerFont1); // 为标题样式设置字体样式  
  
            HSSFCell cell1 = row1.createCell(0);// 创建标题第一列  
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,  
                    columnNumber - 1)); // 合并列标题  
            cell1.setCellValue(titleName); // 设置值标题  
            cell1.setCellStyle(style2); // 设置标题样式  
  
            // 创建第1行 也就是表头  
            HSSFRow row = sheet.createRow((int) 1);  
            row.setHeightInPoints(37);// 设置表头高度  
  
            // 第四步，创建表头单元格样式 以及表头的字体样式  
            HSSFCellStyle style = wb.createCellStyle();  
            style.setWrapText(true);// 设置自动换行  
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  
  
            style.setBottomBorderColor(HSSFColor.BLACK.index);  
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
  
            HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式  
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
            headerFont.setFontName("黑体"); // 设置字体类型  
            headerFont.setFontHeightInPoints((short) 10); // 设置字体大小  
            style.setFont(headerFont); // 为标题样式设置字体样式  
  
            // 第四.一步，创建表头的列  
            for (int i = 0; i < columnNumber; i++)   
            {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellValue(columnName[i]);  
                cell.setCellStyle(style);  
            }  
  
            // 第五步，创建单元格，并设置值  
            for (int i = 0; i < dataList.size(); i++)   
            {  
                row = sheet.createRow((int) i + 2);  
                // 为数据内容设置特点新单元格样式1 自动换行 上下居中  
                HSSFCellStyle zidonghuanhang = wb.createCellStyle();  
                zidonghuanhang.setWrapText(true);// 设置自动换行  
                zidonghuanhang.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  
  
                // 设置边框  
                zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);  
                zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);  
  
                // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中  
                HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();  
                zidonghuanhang2.setWrapText(true);// 设置自动换行  
                zidonghuanhang2  
                        .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式  
                zidonghuanhang2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
  
                // 设置边框  
                zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);  
                zidonghuanhang2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
                HSSFCell datacell = null;  
                for (int j = 0; j < columnNumber; j++)   
                {  
                    datacell = row.createCell(j);  
                    datacell.setCellValue(value);  
                    datacell.setCellStyle(zidonghuanhang2);  
                }  
            }  
             
             int currentRowNum = 1;//从第几行开始写
     		int currentColNum = 1;//从第几列开始写
     		for (int i = 0; i < dataList.size(); i++) {
     			XSSFRow row = sheet.createRow(currentRowNum);//一个list就是一行，创建一个行
     			for (Object object : dataList) {//遍历每一个list的Object[]数组
     				if (object==null) {
     					XSSFCell cell = row.createCell(currentColNum++, XSSFCell.CELL_TYPE_BLANK);//如果该单元格为空，则创建一个空格子，不然数据会移位
     					cell.setCellValue("");//将这个空格设置为空字符串
     				}else if(object instanceof Double || object instanceof Float){//判断这个格子放的数据的类型，其他的同理
     					XSSFCell cell = row.createCell(currentColNum++, XSSFCell.CELL_TYPE_NUMERIC);//如果是Double或者Float类型的，则用这个方式
     					cell.setCellValue(Double.parseDouble(object.toString()));
     				}else if(object instanceof Long || object instanceof Integer){
     					XSSFCell cell = row.createCell(currentColNum++, XSSFCell.CELL_TYPE_NUMERIC);
     					cell.setCellValue(Double.parseDouble(object.toString()));
     				}else if(object instanceof Date){
     					XSSFCell cell = row.createCell(currentColNum++, XSSFCell.CELL_TYPE_STRING);
     					cell.setCellValue(new SimpleDateFormat("dd-MM-yyyy").format((Date)object));
     				}else if(object instanceof Boolean){
     					XSSFCell cell = row.createCell(currentColNum++, XSSFCell.CELL_TYPE_BOOLEAN);
     					cell.setCellValue((Boolean)object);
     				}else{
     					XSSFCell cell = row.createCell(currentColNum++, XSSFCell.CELL_TYPE_STRING);
     					cell.setCellValue(String.valueOf(object));
     				}
     			}
     			currentRowNum++;//写完第一个list，跳到下一行
     			currentColNum = 1;
     		}
  
            // 第六步，将文件存到浏览器设置的下载位置  
            String filename = fileName + ".xls";  
            response.setContentType("application/ms-excel;charset=UTF-8");  
            response.setHeader("Content-Disposition", "attachment;filename="  
                    .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));  
            OutputStream out = response.getOutputStream();  
            try {  
                wb.write(out);// 将数据写出去  
                String str = "导出" + fileName + "成功！";  
                System.out.println(str);  
            } catch (Exception e) {  
                e.printStackTrace();  
                String str1 = "导出" + fileName + "失败！";  
                System.out.println(str1);  
            } finally {  
                out.close();  
            }  
    }
  
    public void ExportNoResponse(String sheetName, String titleName,  
            String fileName, int columnNumber, int[] columnWidth,  
            String[] columnName, String[][] dataList) throws Exception {  
        if (columnNumber == columnWidth.length&& columnWidth.length == columnName.length) {  
            // 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook();  
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.createSheet(sheetName);  
            // sheet.setDefaultColumnWidth(15); //统一设置列宽  
            for (int i = 0; i < columnNumber; i++)   
            {  
                for (int j = 0; j <= i; j++)   
                {  
                    if (i == j)   
                    {  
                        sheet.setColumnWidth(i, columnWidth[j] * 256); // 单独设置每列的宽  
                    }  
                }  
            }  
            // 创建第0行 也就是标题  
            HSSFRow row1 = sheet.createRow((int) 0);  
            row1.setHeightInPoints(50);// 设备标题的高度  
            // 第三步创建标题的单元格样式style2以及字体样式headerFont1  
            HSSFCellStyle style2 = wb.createCellStyle();  
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
            style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);  
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
            HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式  
            headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
            headerFont1.setFontName("黑体"); // 设置字体类型  
            headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小  
            style2.setFont(headerFont1); // 为标题样式设置字体样式  
  
            HSSFCell cell1 = row1.createCell(0);// 创建标题第一列  
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,  
                    columnNumber - 1)); // 合并第0到第17列  
            cell1.setCellValue(titleName); // 设置值标题  
            cell1.setCellStyle(style2); // 设置标题样式  
  
            // 创建第1行 也就是表头  
            HSSFRow row = sheet.createRow((int) 1);  
            row.setHeightInPoints(37);// 设置表头高度  
  
            // 第四步，创建表头单元格样式 以及表头的字体样式  
            HSSFCellStyle style = wb.createCellStyle();  
            style.setWrapText(true);// 设置自动换行  
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  
  
            style.setBottomBorderColor(HSSFColor.BLACK.index);  
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
  
            HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式  
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
            headerFont.setFontName("黑体"); // 设置字体类型  
            headerFont.setFontHeightInPoints((short) 10); // 设置字体大小  
            style.setFont(headerFont); // 为标题样式设置字体样式  
  
            // 第四.一步，创建表头的列  
            for (int i = 0; i < columnNumber; i++)   
            {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellValue(columnName[i]);  
                cell.setCellStyle(style);  
            }  
  
            // 第五步，创建单元格，并设置值  
            for (int i = 0; i < dataList.length; i++)   
            {  
                row = sheet.createRow((int) i + 2);  
                // 为数据内容设置特点新单元格样式1 自动换行 上下居中  
                HSSFCellStyle zidonghuanhang = wb.createCellStyle();  
                zidonghuanhang.setWrapText(true);// 设置自动换行  
                zidonghuanhang  
                        .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  
  
                // 设置边框  
                zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);  
                zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);  
  
                // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中  
                HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();  
                zidonghuanhang2.setWrapText(true);// 设置自动换行  
                zidonghuanhang2  
                        .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式  
                zidonghuanhang2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  
  
                // 设置边框  
                zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);  
                zidonghuanhang2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                zidonghuanhang2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
                HSSFCell datacell = null;  
                for (int j = 0; j < columnNumber; j++)   
                {  
                    datacell = row.createCell(j);  
                    datacell.setCellValue(dataList[i][j]);  
                    datacell.setCellStyle(zidonghuanhang2);  
                }  
            }  
  
            // 第六步，将文件存到指定位置  
            try {  
                FileOutputStream fout = new FileOutputStream("D:students.xls");  
                wb.write(fout);  
                String str = "导出" + fileName + "成功！";  
                System.out.println(str);  
                fout.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
                String str1 = "导出" + fileName + "失败！";  
                System.out.println(str1);  
            }  
        } else {  
            System.out.println("列数目长度名称三个数组长度要一致");  
        }  
  
    }  
  
}  */