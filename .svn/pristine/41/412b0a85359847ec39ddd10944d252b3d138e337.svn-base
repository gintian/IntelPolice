package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.bean.DictoryBean;
import com.model.mapper.DictoryMapper;
import com.page.PageBean;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
public interface DictoryBeanMapper extends DictoryMapper {
    /**
     * 分页条件查询
     * @param bean              [必填]  查询条件
     * @return
     */
     List<DictoryBean> selectBeanPage(@Param("entity") DictoryBean bean, @Param("pageBean") PageBean<DictoryBean> beanPageBean);
    /**
     * 查询根据添加查询总条数
     * @param bean             [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") DictoryBean bean);

    /**
     * 根据 类型查询bean
     * @param type                  [必填]        类型
     * @return
     */
    List<DictoryBean> findBeanByType(@Param("type") String type);

    /**
     * 根据父类id  查询条数
     * @param parentId              [必填]     父类id
     * @return      当前parentId 的条数
     */
    int selectCountByParentId(@Param("parentId") String parentId);
}
