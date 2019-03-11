package com.utils;  
  
import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;  
  
public class ReadWriteExcelUtil {  
    public static String readExcel(String fileName) {  
        StringBuffer sb = new StringBuffer();  
        Workbook wb = null;  
        try {  
            wb = Workbook.getWorkbook(new File(fileName));  
        } catch (BiffException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        if (wb == null)  
            return null;  
  
        Sheet[] sheet = wb.getSheets();  
  
        if (sheet != null && sheet.length > 0) {  
            for (int i = 0; i < sheet.length; i++) {  
                int rowNum = sheet[i].getRows();  
                for (int j = 0; j < rowNum; j++) {  
                    Cell[] cells = sheet[i].getRow(j);  
                    if (cells != null && cells.length > 0) {  
                        for (int k = 0; k < cells.length; k++) {  
                            String cellValue = cells[k].getContents();  
							sb.append(cellValue + "\t");
                        }  
                    }  
                    sb.append("\r\n");  
                }  
                sb.append("\r\n");  
            }  
        }  
        wb.close();  
        return sb.toString();  
    }  
  
    
    public static void writeExcel(String fileName,List list) {  
        WritableWorkbook wwb = null;  
        try {  
            wwb = Workbook.createWorkbook(new File(fileName));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        if (wwb != null) {  
            WritableSheet ws = wwb.createSheet("sheet1", 0);  
  
            for (int i = 0; i < list.size(); i++) {  
            String[] str= (String[])list.get(i);
                for (int j = 0; j < str.length; j++) {  
                    Label labelC = new Label(j, i,str[j]);  
                    try {  
                        ws.addCell(labelC);  
                    } catch (RowsExceededException e) {  
                        e.printStackTrace();  
                    } catch (WriteException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }

            try {
                wwb.write();
                wwb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }  
  
}  