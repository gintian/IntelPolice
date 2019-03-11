package com.service.mapper;

import com.model.InvestigationSupAlarm;
import com.model.bean.InvestigationSupAlarmBean;
import com.model.mapper.InvestigationSupAlarmMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationSupAlarmBeanMapper extends InvestigationSupAlarmMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationSupAlarmBean> selectBeanPage(@Param("entity") InvestigationSupAlarmBean bean, @Param("pageBean")PageBean<InvestigationSupAlarmBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationSupAlarmBean bean);
}