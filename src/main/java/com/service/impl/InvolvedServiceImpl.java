package com.service.impl;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Involved;
import com.model.bean.InvolvedBean;
import com.page.PageBean;
import com.service.CaseStatusService;
import com.service.InvolvedService;
import com.service.mapper.InvolvedBeanMapper;
import com.utils.CommonValidate;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.WebAsyncManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedInfosServiceImpl 类描述：涉案财物信息表操作业务逻辑接口实现
 */
@Service("involvedInfosService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedServiceImpl implements InvolvedService {
    @Autowired
    private InvolvedBeanMapper involvedBeanMapper;

    @Override
    public String addBean(InvolvedBean involvedBean) throws WebMessageException {
        if (involvedBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        involvedBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(involvedBean);
        Involved involved = new Involved();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(involved, involvedBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedBeanMapper.insertSelective(involvedBean);
        return involvedBean.getId();
    }

    @Override
    public void updateBean(String id, InvolvedBean involvedBean) throws WebMessageException {
        if (involvedBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(involvedBean);
        Involved involved = new Involved();
        try {
            ServiceUtils.copyProperties(involved, involvedBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedBeanMapper.updateByPrimaryKeySelective(involved);
    }

    @Override
    public void updateApproveState(String involvedId, String approveState) throws WebMessageException {
        if (approveState == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        Involved involved = new Involved();
        InvolvedBean involvedBean = findInvolvedById(involvedId);
        involvedBean.setApproveState(approveState);
        try {
            ServiceUtils.copyProperties(involved, involvedBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedBeanMapper.updateByPrimaryKeySelective(involved);
    }

    @Override
    public void updateDisposeState(String involvedId, String disposeState) throws WebMessageException {
        if (disposeState == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        Involved involved = new Involved();
        InvolvedBean involvedBean = findInvolvedById(involvedId);
        involvedBean.setDisposeState(disposeState);
        try {
            ServiceUtils.copyProperties(involved, involvedBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedBeanMapper.updateByPrimaryKeySelective(involved);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        involvedBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public InvolvedBean findInvolvedById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        Involved involved = involvedBeanMapper.selectByPrimaryKey(id);
        if (involved != null) {
            InvolvedBean involvedBean = new InvolvedBean();
            try {
                ServiceUtils.copyProperties(involvedBean, involved);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return involvedBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<Involved> pageBean, InvolvedBean bean) {
        int total = involvedBeanMapper.selectTotal(bean);
        List<InvolvedBean> involvedBeanList = new ArrayList<InvolvedBean>();
        if (total > 0) {
            involvedBeanList = involvedBeanMapper.selectBeanPage(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involvedBeanList);
    }

    @Override
    public List<InvolvedBean> findByCaseId(String caseid) {
        List<InvolvedBean> involvedBeanList = involvedBeanMapper.selectByCaseId(caseid);
        if (involvedBeanList.size() > 0) {
            return involvedBeanList;
        }
        return null;
    }

    /**
     * 校验 bean 对象
     *
     * @param
     * @throws Exception 校验异常
     */

    private void validateBean(InvolvedBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

}
