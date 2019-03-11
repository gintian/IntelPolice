package com.service.mapper;

import com.exception.WebMessageException;
import com.model.LY;
import com.model.bean.LYBean;
import com.model.mapper.LYMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LYBeanMapper extends LYMapper {
    //查询分页数据
    List<LYBean> selectData(@Param("entity") LYBean bean, @Param("pageBean") PageBean<LY> pageBean);

    //查询分页数据量
    int selectTotal(@Param("entity") LYBean bean);

    //通过lydbh查询
    LYBean selectLYEqLybh(@Param("lydbh") String lydbh) throws WebMessageException;

}
