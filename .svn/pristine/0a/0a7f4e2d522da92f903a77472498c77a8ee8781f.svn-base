package com.service.mapper;


import com.model.bean.InvestigationJucDeptBean;
import com.model.mapper.InvestigationJucDeptMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationJucDeptBeanMapper extends InvestigationJucDeptMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationJucDeptBean> selectBeanPage(@Param("entity") InvestigationJucDeptBean bean, @Param("pageBean")PageBean<InvestigationJucDeptBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationJucDeptBean bean);
}