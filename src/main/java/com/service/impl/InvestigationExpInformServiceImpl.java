package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationExpInform;
import com.model.bean.InvestigationExpInformBean;
import com.page.PageBean;
import com.service.InvestigationExpInformService;
import com.service.mapper.InvestigationExpInformBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationExpInformServiceImpl implements InvestigationExpInformService {
    @Autowired
    InvestigationExpInformBeanMapper investigationExpInformBeanMapper;

    //增加
    @Override
    public void addBean(InvestigationExpInformBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setInformId(ServiceUtils.generatePrimaryKey());

        InvestigationExpInform investigationExpInform = new InvestigationExpInform();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationExpInform, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationExpInformBeanMapper.insert(investigationExpInform);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationExpInformBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getInformId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String informId, InvestigationExpInformBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(informId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationExpInform investigationExpInform = new InvestigationExpInform();
        try {
            BeanUtils.copyProperties(investigationExpInform, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationExpInformBeanMapper.updateByPrimaryKeySelective(investigationExpInform);
    }

    // 删除
    @Override
    public void deleteBean(String informId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(informId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationExpInformBeanMapper.deleteByPrimaryKey(informId);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationExpInformBean findInvestigationExpInformById(String informId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(informId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationExpInform investigationExpInform = investigationExpInformBeanMapper.selectByPrimaryKey(informId);
        if (investigationExpInform != null){
            InvestigationExpInformBean investigationExpInformBean = new InvestigationExpInformBean();
            try {
                BeanUtils.copyProperties(investigationExpInformBean, investigationExpInform);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationExpInformBean;
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
    public void pageQuery(PageBean<InvestigationExpInformBean> pageBean, InvestigationExpInformBean bean){
        int total = investigationExpInformBeanMapper.countTotal(bean);
        List<InvestigationExpInformBean> InvestigationExpInformBeanList = investigationExpInformBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(InvestigationExpInformBeanList);
    }
}