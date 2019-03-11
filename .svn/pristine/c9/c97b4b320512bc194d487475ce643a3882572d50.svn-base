package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.FK;
import com.model.bean.FKBean;
import com.page.PageBean;
import com.service.FKService;
import com.service.mapper.FKBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：FKServiceImpl 类描述：反馈单操作业务逻辑接口实现
 */
@Service("fkService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class FKServiceImpl implements FKService {
    @Autowired
    private FKBeanMapper fkBeanMapper;

    @Override
    public void addBean(FKBean fkBean) throws WebMessageException {
        if (fkBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        fkBean.setFkdbh(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(fkBean);
        FK fk = new FK();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(fk, fkBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        fkBeanMapper.insertSelective(fkBean);
    }

    @Override
    public void updateBean(String fkdbh, FKBean fkBean) throws WebMessageException {
        if (fkBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(fkBean);
        FK fk = new FK();
        try {
            ServiceUtils.copyProperties(fk, fkBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        fkBeanMapper.updateByPrimaryKeySelective(fk);
    }

    @Override
    public void deleteBean(String fkdbh) throws WebMessageException {
        if (StringUtils.isEmpty(fkdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        fkBeanMapper.deleteByPrimaryKey(fkdbh);
    }

    @Override
    public FKBean findFKByFkdbh(String fkdbh) throws WebMessageException {
        if (StringUtils.isEmpty(fkdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        FKBean fkBean = fkBeanMapper.selectFKEqFkdbh(fkdbh);
        if (fkBean != null) {
            return fkBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<FK> pageBean, FKBean bean) {
        int total = fkBeanMapper.selectTotal(bean);
        List<FKBean> fkBeanList = new ArrayList<FKBean>();
        if (total > 0) {
            fkBeanList = fkBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(fkBeanList);
    }

    @Override
    public List<FKBean> findFKByCj(String cj)throws WebMessageException {
        if (StringUtils.isEmpty(cj)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        List<FKBean>  fkBeanList = fkBeanMapper.selectFKEqCj(cj);
        if (fkBeanList != null) {
            return fkBeanList;
        }
        return null;
    }

    /**
     * 校验  bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(FKBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getFkdbh())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}