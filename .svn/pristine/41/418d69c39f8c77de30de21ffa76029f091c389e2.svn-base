package com.service.impl;

import com.analysis.mapper.InvolvedTempMapper;
import com.analysis.model.InvolvedTemp;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.User;
import com.page.PageBean;
import com.service.*;
import com.utils.*;
import org.activiti.engine.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("involvedTempService")
public class InvolvedTempServiceImpl implements InvolvedTempService {

    @Autowired
    private InvolvedTempMapper involvedTempMapper;

    @Override
    public void pageQueryByCaseId(PageBean<InvolvedTemp> pageBean, InvolvedTemp bean) {
        int total = involvedTempMapper.selectTotalByCaseId(bean);
        List<InvolvedTemp> involvedTaskBeanList = new ArrayList<InvolvedTemp>();
        if (total > 0) {
            involvedTaskBeanList = involvedTempMapper.selectDataByCaseId(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involvedTaskBeanList);
    }

    @Override
    public InvolvedTemp findInvolvedTempById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        InvolvedTemp involvedTemp = involvedTempMapper.selectByPrimaryKey(id);
        if (involvedTemp != null) {
            InvolvedTemp involvedTaskBean = new InvolvedTemp();
            try {
                BeanUtils.copyProperties(involvedTaskBean, involvedTemp);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return involvedTaskBean;
        }
        return null;
    }
}