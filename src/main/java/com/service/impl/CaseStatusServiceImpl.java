package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.CaseStatus;
import com.model.bean.CaseStatusBean;
import com.service.CaseStatusService;
import com.service.mapper.CaseStatusBeanMapper;
import com.utils.CommonValidate;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by tl on 2018/5/19 0019.
 */
@Service
public class CaseStatusServiceImpl implements CaseStatusService {
    @Autowired
    private CaseStatusBeanMapper caseStatusBeanMapper;
    @Override
    @Transactional
    public void updateCaseStatus(String caseId, String key, String value) throws WebMessageException {

        if (CommonValidate.isEmpty(caseId) || CommonValidate.isEmpty(key)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }

        CaseStatusBean caseStatusBean = caseStatusBeanMapper.findBeanByCaseId(caseId);
        CaseStatus caseStatus = new CaseStatus();
        try {
            if (CommonValidate.isEmpty(caseStatusBean)) {
                //添加
                caseStatus.setId(ServiceUtils.generatePrimaryKey());
                caseStatus.setCaseid(caseId);
                BeanUtils.setProperty(caseStatus, key, value);
                caseStatusBeanMapper.insert(caseStatus);

            } else {
                //修改
                BeanUtils.setProperty(caseStatusBean, key, value);
                BeanUtils.copyProperties(caseStatus, caseStatusBean);
                caseStatusBeanMapper.updateByPrimaryKeySelective(caseStatus);
            }
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.COPYPROPERTIES);
        }
    }
}
