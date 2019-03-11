package com.service.mapper;

import com.model.bean.InvestigationExpAlarmBean;
import com.model.mapper.InvestigationExpAlarmMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationExpAlarmBeanMapper extends InvestigationExpAlarmMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationExpAlarmBean> selectBeanPage(@Param("entity") InvestigationExpAlarmBean bean, @Param("pageBean")PageBean<InvestigationExpAlarmBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationExpAlarmBean bean);
}