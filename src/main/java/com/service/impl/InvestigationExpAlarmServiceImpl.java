package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvestigationExpAlarm;
import com.model.bean.InvestigationExpAlarmBean;
import com.page.PageBean;
import com.service.InvestigationExpAlarmService;
import com.service.mapper.InvestigationExpAlarmBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationExpAlarmServiceImpl implements InvestigationExpAlarmService {
    @Autowired
    InvestigationExpAlarmBeanMapper investigationExpAlarmBeanMapper;

    //增加
    @Override
    public void addBean(InvestigationExpAlarmBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验Bean
        validateBean(bean);

        //添加主键值,, 临时使用uuid,截取20 位
        //TODO 添加主键值,, 临时使用uuid,截取20 位
        bean.setExceptionId(ServiceUtils.generatePrimaryKey());

        InvestigationExpAlarm investigationExpAlarm = new InvestigationExpAlarm();

        //复制Bean 到model
        try {
            BeanUtils.copyProperties(investigationExpAlarm, bean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        investigationExpAlarmBeanMapper.insert(investigationExpAlarm);
    }

    /**
     *  校验  bean 对象
     * @param bean
     * @throws Exception    校验异常
     */
    private void validateBean(InvestigationExpAlarmBean bean) throws WebMessageException{
        if (StringUtils.isEmpty(bean.getExceptionId())){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    //修改
    @Override
    public void updateBean(String exceptionId, InvestigationExpAlarmBean bean) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(exceptionId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        if (bean == null){
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(bean);

        InvestigationExpAlarm investigationExpAlarm = new InvestigationExpAlarm();
        try {
            BeanUtils.copyProperties(investigationExpAlarm, bean);
        }catch (Exception e){
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }

        investigationExpAlarmBeanMapper.updateByPrimaryKeySelective(investigationExpAlarm);
    }

    // 删除
    @Override
    public void deleteBean(String exceptionId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(exceptionId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        investigationExpAlarmBeanMapper.deleteByPrimaryKey(exceptionId);
    }

    /**
     * 通过Id查询Bean
     */
    @Override
    public InvestigationExpAlarmBean findInvestigationExpAlarmById(String exceptionId) throws WebMessageException{
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(exceptionId)){
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        InvestigationExpAlarm investigationExpAlarm = investigationExpAlarmBeanMapper.selectByPrimaryKey(exceptionId);
        if (investigationExpAlarm != null){
            InvestigationExpAlarmBean investigationExpAlarmBean = new InvestigationExpAlarmBean();
            try {
                BeanUtils.copyProperties(investigationExpAlarmBean, investigationExpAlarm);
            }catch (Exception e){
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return investigationExpAlarmBean;
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
    public void pageQuery(PageBean<InvestigationExpAlarmBean> pageBean, InvestigationExpAlarmBean bean){
        int total = investigationExpAlarmBeanMapper.countTotal(bean);
        List<InvestigationExpAlarmBean> InvestigationExpAlarmBeanList = investigationExpAlarmBeanMapper.selectBeanPage(bean, pageBean);

        pageBean.setTotal(total);
        pageBean.setRows(InvestigationExpAlarmBeanList);
    }
}