package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationJucDept;
import com.model.bean.InvestigationJucDeptBean;
import com.page.PageBean;
import com.service.InvestigationJucDeptService;
import com.service.mapper.InvestigationJucDeptBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class InvestigationJucDeptServiceImpl implements InvestigationJucDeptService {
    @Autowired
    InvestigationJucDeptBeanMapper investigationJucDeptBeanMapper;

    //增加
    public void addBean(InvestigationJucDeptBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setId(ServiceUtils.generatePrimaryKey());

        InvestigationJucDept investigationJucDept = new InvestigationJucDept();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationJucDept, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationJucDeptBeanMapper.insert(investigationJucDept);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationJucDeptBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String id, InvestigationJucDeptBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationJucDept investigationJucDept = new InvestigationJucDept();
        try {
            BeanUtils.copyProperties(investigationJucDept, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationJucDeptBeanMapper.updateByPrimaryKeySelective(investigationJucDept);
    }

    // 删除
    @Override
    public void deleteBean(String id) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationJucDeptBeanMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationJucDeptBean findInvestigationJucDeptById(String id) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationJucDept investigationJucDept = investigationJucDeptBeanMapper.selectByPrimaryKey(id);
        if (investigationJucDept != null){
            InvestigationJucDeptBean investigationJucDeptBean = new InvestigationJucDeptBean();
            try {
                BeanUtils.copyProperties(investigationJucDeptBean, investigationJucDept);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationJucDeptBean;
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
    public void pageQuery(PageBean<InvestigationJucDeptBean> pageBean, InvestigationJucDeptBean bean){
        int total = investigationJucDeptBeanMapper.countTotal(bean);
        List<InvestigationJucDeptBean> InvestigationExpInformBeanList = investigationJucDeptBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(InvestigationExpInformBeanList);
    }
}