package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationRelated;
import com.model.bean.InvestigationRelatedBean;
import com.page.PageBean;
import com.service.InvestigationRelatedService;
import com.service.mapper.InvestigationRelatedBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationRelatedServiceImpl implements InvestigationRelatedService {
    @Autowired
    InvestigationRelatedBeanMapper investigationRelatedBeanMapper;

    //增加
    public void addBean(InvestigationRelatedBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setWithBreakId(ServiceUtils.generatePrimaryKey());

        InvestigationRelated investigationRelated = new InvestigationRelated();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationRelated, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationRelatedBeanMapper.insert(investigationRelated);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationRelatedBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getWithBreakId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String withBreakId, InvestigationRelatedBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(withBreakId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationRelated investigationRelated = new InvestigationRelated();
        try {
            BeanUtils.copyProperties(investigationRelated, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationRelatedBeanMapper.updateByPrimaryKeySelective(investigationRelated);
    }

    // 删除
    @Override
    public void deleteBean(String withBreakId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(withBreakId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationRelatedBeanMapper.deleteByPrimaryKey(withBreakId);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationRelatedBean findInvestigationRelatedById(String withBreakId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(withBreakId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationRelated investigationRelated = investigationRelatedBeanMapper.selectByPrimaryKey(withBreakId);
        if (investigationRelated != null){
            InvestigationRelatedBean investigationRelatedBean = new InvestigationRelatedBean();
            try {
                BeanUtils.copyProperties(investigationRelatedBean, investigationRelated);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationRelatedBean;
        }
        return null;
    }

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    @Override
    public void pageQuery(PageBean<InvestigationRelatedBean> pageBean, InvestigationRelatedBean bean){
        int total = investigationRelatedBeanMapper.countTotal(bean);
        List<InvestigationRelatedBean> investigationRelatedBeanList = investigationRelatedBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(investigationRelatedBeanList);
    }
}