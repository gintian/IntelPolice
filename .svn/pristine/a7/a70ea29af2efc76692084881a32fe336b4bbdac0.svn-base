package com.service.mapper;

import com.model.bean.InvestigationRelatedBean;
import com.model.mapper.InvestigationRelatedMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationRelatedBeanMapper extends InvestigationRelatedMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationRelatedBean> selectBeanPage(@Param("entity") InvestigationRelatedBean bean, @Param("pageBean")PageBean<InvestigationRelatedBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationRelatedBean bean);
}