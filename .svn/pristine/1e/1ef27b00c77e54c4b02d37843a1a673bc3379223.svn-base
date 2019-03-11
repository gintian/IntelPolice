package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationExpType;
import com.model.bean.InvestigationExpTypeBean;
import com.page.PageBean;
import com.service.InvestigationExpTypeService;
import com.service.mapper.InvestigationExpTypeBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationExpTypeServiceImpl implements InvestigationExpTypeService {
    @Autowired
    InvestigationExpTypeBeanMapper investigationExpTypeBeanMapper;
    //增加
    @Override
    public void addBean(InvestigationExpTypeBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setId(ServiceUtils.generatePrimaryKey());

        InvestigationExpType investigationExpType = new InvestigationExpType();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationExpType, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationExpTypeBeanMapper.insert(investigationExpType);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationExpTypeBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String id, InvestigationExpTypeBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationExpType investigationExpType = new InvestigationExpType();
        try {
            BeanUtils.copyProperties(investigationExpType, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationExpTypeBeanMapper.updateByPrimaryKeySelective(investigationExpType);
    }

    // 删除
    @Override
    public void deleteBean(String id) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationExpTypeBeanMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationExpTypeBean findInvestigationExpTypeById(String id) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationExpType investigationExpType = investigationExpTypeBeanMapper.selectByPrimaryKey(id);
        if (investigationExpType != null){
            InvestigationExpTypeBean investigationExpTypeBean = new InvestigationExpTypeBean();
            try {
                BeanUtils.copyProperties(investigationExpTypeBean, investigationExpType);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationExpTypeBean;
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
    public void pageQuery(PageBean<InvestigationExpTypeBean> pageBean, InvestigationExpTypeBean bean){
        int total = investigationExpTypeBeanMapper.countTotal(bean);
        List<InvestigationExpTypeBean> investigationExpTypeBeanList = investigationExpTypeBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(investigationExpTypeBeanList);
    }
}