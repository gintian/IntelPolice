package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.bean.MediaBean;
import com.model.mapper.MediaMapper;
import com.page.PageBean;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface MediaBeanMapper extends MediaMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
     List<MediaBean> selectBeanPage(@Param("entity") MediaBean bean, @Param("pageBean")PageBean<MediaBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") MediaBean bean);

    /**
     *  根据name 查询
     * @param name            [必填]            name
     * @return
     */
     MediaBean selectBeanEqName(@Param("name") String name);


}
