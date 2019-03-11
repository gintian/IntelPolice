package com.service.mapper;

import com.model.CMD;
import com.model.bean.CMDBean;
import com.model.mapper.CMDMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CMDBeanMapper extends CMDMapper {
    // 查询分页数据
    List<CMDBean> selectData(@Param("entity") CMDBean bean, @Param("pageBean") PageBean<CMD> pageBean);

    // 查询分页数据量
    int selectTotal(@Param("entity") CMDBean bean);

    //通过事件编号查询
    CMDBean selectBeanEqSjbh(@Param("sjbh") String sjbh);

    //通过ID查询
    CMDBean selectBeanEqId(@Param("id") String id);

}
