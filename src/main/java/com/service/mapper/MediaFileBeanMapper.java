package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.bean.MediaFilesBean;
import com.model.mapper.MediaFilesMapper;
import com.page.PageBean;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface MediaFileBeanMapper extends MediaFilesMapper{
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
    List<MediaFilesBean> selectBeanPage(@Param("entity") MediaFilesBean bean, @Param("pageBean")PageBean<MediaFilesBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") MediaFilesBean bean);
    /**
     * 查询所有的数据
     * @return
     */
    List<MediaFilesBean>  findAll();
}
