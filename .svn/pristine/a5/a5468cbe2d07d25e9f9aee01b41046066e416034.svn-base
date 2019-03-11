package com.service.mapper;

import com.exception.WebMessageException;
import com.model.JJ;
import com.model.bean.JJBean;
import com.model.mapper.JJMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JJBeanMapper extends JJMapper {
    //查询分页数据
    List<JJBean> selectData(@Param("entity") JJBean bean, @Param("pageBean") PageBean<JJ> pageBean);

    //查询分页数据量
    int selectTotal(@Param("entity") JJBean bean);

    //通过xzqhdm查询
    List<JJBean> selectJJEqXzqhdm(@Param("xzqhdm") String xzqhdm) throws WebMessageException;

    //通过jjdbh查询
    JJBean selectJJEqJjdbh(@Param("jjdbh") String jjdbh) throws WebMessageException;

    //查询分页数据（未关联）
    List<JJBean> selectDataUnrelated(@Param("entity") JJBean bean, @Param("pageBean") PageBean<JJ> pageBean);

    //查询分页数据量（未关联）
    int selectTotalUnrelated(@Param("entity") JJBean bean);

    //查询分页数据（未录音）
    List<JJBean> selectDataNotRecordings(@Param("entity") JJBean bean, @Param("pageBean") PageBean<JJ> pageBean);

    //查询分页数据量（未录音）
    int selectTotalNotRecordings(@Param("entity") JJBean bean);

    //查询数据量（根据caseID）
    JJBean selectByCaseId(String caseId);

    //查询没关联音视频总数
    int selectNotViewTotal();
    //查询没关联音视频
    List<JJBean> selectNotView(@Param("pageBean") PageBean<JJ> pageBean, @Param("entity") JJBean bean);
    //查询关联音视频总数
    int selectCorrelateViewTotal();
    //查询关联音视频
    List<JJBean> selectCorrelateView(@Param("pageBean") PageBean<JJ> pageBean, @Param("entity") JJBean bean);
}
