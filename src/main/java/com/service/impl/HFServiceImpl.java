package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.HF;
import com.model.bean.HFBean;
import com.page.PageBean;
import com.service.HFService;
import com.service.mapper.HFBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：HFServiceImpl 类描述：反馈单操作业务逻辑接口实现
 */
@Service("hfService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class HFServiceImpl implements HFService {
    @Autowired
    private HFBeanMapper hfBeanMapper;

    @Override
    public void addBean(HFBean hfBean) throws WebMessageException {
        if (hfBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        hfBean.setHfhsdbh(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(hfBean);
        HF hf = new HF();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(hf, hfBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        hfBeanMapper.insertSelective(hfBean);
    }

    @Override
    public void updateBean(String hfhsdbh, HFBean hfBean) throws WebMessageException {
        if (hfBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(hfBean);
        HF hf = new HF();
        try {
            ServiceUtils.copyProperties(hf, hfBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        hfBeanMapper.updateByPrimaryKeySelective(hf);
    }

    @Override
    public void deleteBean(String hfhsdbh) throws WebMessageException {
        if (StringUtils.isEmpty(hfhsdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        hfBeanMapper.deleteByPrimaryKey(hfhsdbh);
    }

    @Override
    public HFBean findHFByHfhsdbh(String hfhsdbh) throws WebMessageException {
        if (StringUtils.isEmpty(hfhsdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        HFBean hfBean = hfBeanMapper.selectHFEqHfhsdbh(hfhsdbh);
        if (hfBean != null) {
            return hfBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<HF> pageBean, HFBean bean) {
        int total = hfBeanMapper.selectTotal(bean);
        List<HFBean> hfBeanList = new ArrayList<HFBean>();
        if (total > 0) {
            hfBeanList = hfBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(hfBeanList);
    }

    /**
     * 校验  bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(HFBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getHfhsdbh())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}