package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exception.WebMessageException;
import com.model.CJ;
import com.model.bean.CJBean;
import com.model.mapper.CJMapper;
import com.page.PageBean;

public interface CJBeanMapper extends CJMapper {
    //查询分页数据
    List<CJBean> selectData(@Param("entity") CJBean bean, @Param("pageBean") PageBean<CJ> pageBean);

    //查询分页数据量
    int selectTotal(@Param("entity") CJBean bean);

    //通过xzqhdm查询
    List<CJBean> selectCJEqXzqhdm(@Param("xzqhdm") String xzqhdm) throws WebMessageException;

    //通过cjdbh查询
    CJBean selectCJEqCjdbh(@Param("cjdbh") String cjdbh) throws WebMessageException;

    //查询超时24分页数据
    List<CJBean> selectTimeoutData(@Param("entity") CJBean bean, @Param("pageBean") PageBean<CJ> pageBean);

    //查询超时24分页数据量
    int selectTimeoutTotal(@Param("entity") CJBean bean);

    //查询超时未立案分页数据
    List<CJBean> selectTimeoutWlaData(@Param("entity") CJBean bean, @Param("pageBean") PageBean<CJ> pageBean);

    //查询超时未立案分页数据量
    int selectTimeoutWlaTotal(@Param("entity") CJBean bean);

    //查询超时立案分页数据
    List<CJBean> selectTimeoutLaData(@Param("entity") CJBean bean, @Param("pageBean") PageBean<CJ> pageBean);

    //查询超时立案分页数据量
    int selectTimeoutLaTotal(@Param("entity") CJBean bean);

    //通过id查询
    CJBean selectCJAndJJById(String cjdbh) throws WebMessageException;

    //查询多条反馈数据
    List<CJBean> selectFeedbacksData(@Param("entity") CJBean bean, @Param("pageBean") PageBean<CJ> pageBean);

    //查询多条反馈数据
    int selectFeedbacksTotal(@Param("entity") CJBean bean);

    //通过jjdbh查询
    CJBean selectCJEqjjdbh(@Param("jjdbh") String jjdbh) throws WebMessageException;

    int selectNotViewTotal();

    List<CJ> selectNotView(@Param("pageBean") PageBean<CJ> pageBean, @Param("entity") CJ bean);

    int selectCorrelateViewTotal();

    List<CJ> selectCorrelateView(@Param("pageBean") PageBean<CJ> pageBean, @Param("entity") CJ bean);
}
