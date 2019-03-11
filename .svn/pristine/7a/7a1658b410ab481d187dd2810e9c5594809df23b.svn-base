package com.service.mapper;


import com.model.bean.InvestigationKeywordsBean;
import com.model.mapper.InvestigationKeywordsMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationKeywordsBeanMapper extends InvestigationKeywordsMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationKeywordsBean> selectBeanPage(@Param("entity") InvestigationKeywordsBean bean, @Param("pageBean")PageBean<InvestigationKeywordsBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationKeywordsBean bean);
}