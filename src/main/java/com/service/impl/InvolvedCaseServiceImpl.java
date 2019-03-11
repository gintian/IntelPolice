package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvolvedCase;
import com.model.bean.InvolvedCaseBean;
import com.page.PageBean;
import com.service.InvolvedCaseService;
import com.service.mapper.InvolvedCaseBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedInfosServiceImpl 类描述：涉案财物信息表操作业务逻辑接口实现
 */
@Service("involvedCaseInfosService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedCaseServiceImpl implements InvolvedCaseService {
    @Autowired
    private InvolvedCaseBeanMapper involvedCaseBeanMapper;

    @Override
    public void addBean(InvolvedCaseBean involvedCaseBean) throws WebMessageException {
        if (involvedCaseBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        involvedCaseBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(involvedCaseBean);
        InvolvedCase involvedCase = new InvolvedCase();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(involvedCase, involvedCaseBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedCaseBeanMapper.insertSelective(involvedCaseBean);
    }

    @Override
    public void updateBean(String id, InvolvedCaseBean involvedCaseBean) throws WebMessageException {
        if (involvedCaseBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(involvedCaseBean);
        InvolvedCase involvedCase = new InvolvedCase();
        try {
            ServiceUtils.copyProperties(involvedCase, involvedCaseBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedCaseBeanMapper.updateByPrimaryKeySelective(involvedCase);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        involvedCaseBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public InvolvedCaseBean findInvolvedCaseById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        InvolvedCase involvedCase = involvedCaseBeanMapper.selectByPrimaryKey(id);
        if (involvedCase != null) {
            InvolvedCaseBean involvedCaseBean = new InvolvedCaseBean();
            try {
                ServiceUtils.copyProperties(involvedCaseBean, involvedCase);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return involvedCaseBean;
        }
        return null;
    }

    @Override
    public InvolvedCaseBean findInvolvedCaseByInvolvedId(String involvedId) throws WebMessageException {
        if (StringUtils.isEmpty(involvedId)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        InvolvedCaseBean involvedCaseBean = involvedCaseBeanMapper.selectByInvolvedId(involvedId);
        if (involvedCaseBean != null) {
            return involvedCaseBean;
        }
        return null;
    }

    @Override
    public List<InvolvedCaseBean> findInvolvedCaseByBoxId(String boxId) throws WebMessageException {
        if (StringUtils.isEmpty(boxId)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        List<InvolvedCaseBean> involvedCaseBeans = involvedCaseBeanMapper.selectByBoxId(boxId);
        if (involvedCaseBeans.size() > 0) {
            return involvedCaseBeans;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<InvolvedCase> pageBean, InvolvedCaseBean bean, String userId) {
        int total = involvedCaseBeanMapper.selectTotal(bean);
        List<InvolvedCaseBean> involvedCaseBeanList = new ArrayList<InvolvedCaseBean>();
        if (total > 0) {
            involvedCaseBeanList = involvedCaseBeanMapper.selectBeanPage(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involvedCaseBeanList);
    }

    /**
     * 校验 bean 对象
     *
     * @param involvedBean
     * @throws Exception 校验异常
     */
    private void validateBean(InvolvedCaseBean involvedBean) throws WebMessageException {

    }
}
