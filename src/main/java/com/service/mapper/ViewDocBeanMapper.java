package com.service.mapper;


import com.model.bean.ViewDocBean;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewDocBeanMapper {

    //查询所有音视频
    public List<ViewDocBean> showAllView();
    //查询音视频总数
    public int countTotal(@Param("entity") ViewDocBean bean);
    //分页查询
    public List<ViewDocBean> selectBeanPage(@Param("pageBean") PageBean<ViewDocBean> pageBean, @Param("entity") ViewDocBean bean);

    //没有被关联的音视频
    public List<ViewDocBean> selectNoCorrelateView(@Param("pageBean") PageBean<ViewDocBean> pageBean, @Param("entity") ViewDocBean bean);

    //查询已被关联总数
    public int selectCorrelateViewTotal();

 /*   public int selectViewTotal();*/

    //音视频关联提交
    public void viewCorrelate(@Param("id") String id, @Param("viewDocBean") ViewDocBean viewDocBean, @Param("jjdbh") String jjdbh, @Param("cjdbh") String cjdbh, @Param("caseid") String caseid);

    //通过docid查音视频
    public ViewDocBean findViewByDocid(String docId);

    //通过其他找音视频
    public List<ViewDocBean> selectViewByOther(@Param("pageBean")PageBean<ViewDocBean> pageBean,@Param("entity") ViewDocBean bean,@Param("jjdbh")String jjdbh,@Param("cjdbh") String cjdbh, @Param("caseid")String caseid);


    public int selectViewTotalByOther(@Param("pageBean")PageBean<ViewDocBean> pageBean,@Param("entity") ViewDocBean bean,@Param("jjdbh")String jjdbh,@Param("cjdbh") String cjdbh, @Param("caseid")String caseid);



}
