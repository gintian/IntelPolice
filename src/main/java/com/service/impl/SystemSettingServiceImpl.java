package com.service.impl;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.bean.DeptBean;
import com.service.DeptService;
import com.service.SystemSettingService;
import com.utils.CommonValidate;
import org.apache.commons.io.IOUtils;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Created by tl on 2018/5/14 0014.
 */
@Service()
public class SystemSettingServiceImpl implements SystemSettingService {
    @Autowired
    private DeptService deptService;
    @Override
    public void setCurrentDeptUse(String deptId) throws WebMessageException {
        //为空校验
        if (CommonValidate.isEmpty(deptId)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }

        //向当前Sys.xml中存值
        StringBuilder stringBuilder = new StringBuilder();
        List<DeptBean> deptBeanList = deptService.findDeptByParentId(deptId);
        for (DeptBean deptBean : deptBeanList){
            stringBuilder.append(deptBean.getId());
            stringBuilder.append(",");
        }
        stringBuilder.append(deptId);
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            URL url = getClass().getResource(CommonConstant.SYSTEM_PERSSION_FILENAME);
            File file = new File(url.toURI());
            if (!file.exists()){
                throw  new WebMessageException("文件不存在");
            }
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
