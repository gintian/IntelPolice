package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationKeywords;
import com.model.bean.InvestigationKeywordsBean;
import com.page.PageBean;
import com.service.InvestigationKeywordsService;
import com.service.mapper.InvestigationKeywordsBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationKeywordsServiceImpl implements InvestigationKeywordsService {
    @Autowired
    InvestigationKeywordsBeanMapper investigationKeywordsBeanMapper;

    //增加
    public void addBean(InvestigationKeywordsBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setKeywordsId(ServiceUtils.generatePrimaryKey());

        InvestigationKeywords investigationKeywords = new InvestigationKeywords();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationKeywords, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationKeywordsBeanMapper.insert(investigationKeywords);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationKeywordsBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getKeywordsId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String keywordsId, InvestigationKeywordsBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(keywordsId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationKeywords investigationKeywords = new InvestigationKeywords();
        try {
            BeanUtils.copyProperties(investigationKeywords, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationKeywordsBeanMapper.updateByPrimaryKeySelective(investigationKeywords);
    }

    // 删除
    @Override
    public void deleteBean(String keywordsId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(keywordsId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationKeywordsBeanMapper.deleteByPrimaryKey(keywordsId);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationKeywordsBean findInvestigationKeywordsById(String keywordsId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(keywordsId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationKeywords investigationKeywords = investigationKeywordsBeanMapper.selectByPrimaryKey(keywordsId);
        if (investigationKeywords != null){
            InvestigationKeywordsBean investigationKeywordsBean = new InvestigationKeywordsBean();
            try {
                BeanUtils.copyProperties(investigationKeywordsBean, investigationKeywords);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationKeywordsBean;
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
    public void pageQuery(PageBean<InvestigationKeywordsBean> pageBean, InvestigationKeywordsBean bean){
        int total = investigationKeywordsBeanMapper.countTotal(bean);
        List<InvestigationKeywordsBean> investigationKeywordsBeanList = investigationKeywordsBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(investigationKeywordsBeanList);
    }
}