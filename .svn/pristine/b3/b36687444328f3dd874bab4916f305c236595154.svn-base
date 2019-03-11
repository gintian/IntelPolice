package com.service.mapper;

import com.model.bean.CodeBean;
import com.model.mapper.CodeMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tl on 2018/5/19 0019.
 */
public interface CodeBeanMapper extends CodeMapper {
    //查询分页数据
    List<CodeBean> selectData(@Param("entity") CodeBean bean, @Param("pageBean") PageBean<CodeBean> pageBean);
    //查询分页数据量
    int selectTotal(@Param("entity") CodeBean bean);
    List<CodeBean> findBeanListByField(@Param("field") String field);

    List<CodeBean> findAll();
}
