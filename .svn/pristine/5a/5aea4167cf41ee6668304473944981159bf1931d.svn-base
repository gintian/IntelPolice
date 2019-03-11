package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationSupAlarm;
import com.model.bean.InvestigationSupAlarmBean;
import com.page.PageBean;
import com.service.InvestigationSupAlarmService;
import com.service.mapper.InvestigationSupAlarmBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationSupAlarmServiceImpl implements InvestigationSupAlarmService {
    @Autowired
    InvestigationSupAlarmBeanMapper investigationSupAlarmBeanMapper;

    //增加
    public void addBean(InvestigationSupAlarmBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setSuspicId(ServiceUtils.generatePrimaryKey());

        InvestigationSupAlarm investigationSupAlarm = new InvestigationSupAlarm();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationSupAlarm, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationSupAlarmBeanMapper.insert(investigationSupAlarm);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationSupAlarmBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getSuspicId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String suspicId, InvestigationSupAlarmBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(suspicId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationSupAlarm investigationSupAlarm = new InvestigationSupAlarm();
        try {
            BeanUtils.copyProperties(investigationSupAlarm, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationSupAlarmBeanMapper.updateByPrimaryKeySelective(investigationSupAlarm);
    }

    // 删除
    @Override
    public void deleteBean(String suspicId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(suspicId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationSupAlarmBeanMapper.deleteByPrimaryKey(suspicId);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationSupAlarmBean findInvestigationSupAlarmById(String suspicId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(suspicId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationSupAlarm investigationSupAlarm = investigationSupAlarmBeanMapper.selectByPrimaryKey(suspicId);
        if (investigationSupAlarm != null){
            InvestigationSupAlarmBean investigationSupAlarmBean = new InvestigationSupAlarmBean();
            try {
                BeanUtils.copyProperties(investigationSupAlarmBean, investigationSupAlarm);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationSupAlarmBean;
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
    public void pageQuery(PageBean<InvestigationSupAlarmBean> pageBean, InvestigationSupAlarmBean bean){
        int total = investigationSupAlarmBeanMapper.countTotal(bean);
        List<InvestigationSupAlarmBean> investigationSupAlarmBeanList = investigationSupAlarmBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(investigationSupAlarmBeanList);
    }
}