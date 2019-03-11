package com.service.mapper;

import com.model.bean.InvestigationExpInformBean;
import com.model.mapper.InvestigationExpInformMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationExpInformBeanMapper extends InvestigationExpInformMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationExpInformBean> selectBeanPage(@Param("entity") InvestigationExpInformBean bean, @Param("pageBean")PageBean<InvestigationExpInformBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationExpInformBean bean);
}