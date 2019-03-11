package com.service.mapper;

import com.model.bean.InvestigationExpTypeBean;
import com.model.mapper.InvestigationExpTypeMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvestigationExpTypeBeanMapper extends InvestigationExpTypeMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<InvestigationExpTypeBean> selectBeanPage(@Param("entity") InvestigationExpTypeBean bean, @Param("pageBean")PageBean<InvestigationExpTypeBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") InvestigationExpTypeBean bean);
}