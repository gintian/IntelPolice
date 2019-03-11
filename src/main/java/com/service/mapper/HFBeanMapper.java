package com.service.mapper;

import com.exception.WebMessageException;
import com.model.HF;
import com.model.bean.HFBean;
import com.model.mapper.HFMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HFBeanMapper extends HFMapper {
    //查询分页数据
    List<HFBean> selectData(@Param("entity") HFBean bean, @Param("pageBean") PageBean<HF> pageBean);

    //查询分页数据量
    int selectTotal(@Param("entity") HFBean bean);

    //通过hfdbh查询
    HFBean selectHFEqHfhsdbh(@Param("hfdbh") String hfdbh) throws WebMessageException;

}
