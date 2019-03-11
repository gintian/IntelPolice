package com.service.mapper;

import com.model.DataSyncTask;
import com.model.bean.DataSyncTaskBean;
import com.model.bean.UserBean;
import com.model.mapper.DataSyncTaskMapper;
import com.model.mapper.RoleMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by tl on 2018/4/18 0018.
 */
public interface DataSyncTaskBeanMapper extends DataSyncTaskMapper {
    /**
     * 分页条件查询
     * @param bean                [必填]            查询条件
     * @return
     */
     List<DataSyncTaskBean> selectBeanPage(@Param("entity") DataSyncTaskBean bean, @Param("pageBean") PageBean<DataSyncTaskBean> beanPageBean);

    /**
     * 查询根据添加查询总条数
     * @param bean                    [必填]            查询条件
     * @return
     */
    int countTotal(@Param("entity") DataSyncTaskBean bean);

    /**
     * 根据 、同步类型值，，查询待同步数据
     * @param syncvalue                 [必填]      类型值
     * @return
     */
    List<DataSyncTaskBean> findListByType(@Param("syncvalue") String syncvalue);

    /**
     * 分页条件查询
     * @param bean                [必填]            查询条件
     * @return
     */
    List<DataSyncTaskBean> selectBeanPageForNextTask(@Param("entity") DataSyncTaskBean bean, @Param("pageBean") PageBean<DataSyncTaskBean> beanPageBean);

    /**
     * 查询根据添加查询总条数
     * @param bean                    [必填]            查询条件
     * @return
     */
    int countTotalForNextTask(@Param("entity") DataSyncTaskBean bean);
}
