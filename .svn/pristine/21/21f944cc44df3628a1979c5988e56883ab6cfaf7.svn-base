package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.DataSyncTask;
import com.model.bean.DataSyncTaskBean;
import com.model.bean.UserBean;
import com.page.PageBean;
import com.service.DataSyncTaskService;
import com.service.mapper.DataSyncTaskBeanMapper;
import com.utils.CommonValidate;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by tl on 2018/5/22 0022.
 */
@Service
public class DataSyncTaskServiceImpl implements DataSyncTaskService {
    @Autowired
    private DataSyncTaskBeanMapper dataSyncTaskBeanMapper;
    @Override
    public void addBean(DataSyncTaskBean bean) throws WebMessageException {
        //校验值
        if (CommonValidate.isEmpty(bean.getSyncvalue())){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        //判断
        List<DataSyncTaskBean> list = dataSyncTaskBeanMapper.findListByType(bean.getSyncvalue());
        if (list.size() == 1){
            //不能添加只能修改
            throw new WebMessageException("已经有待处理的数据,请修改当前的");

        }else if(list.size() > 1){
            //处理数据有问题
            throw new WebMessageException("待处理数据,有多条等待备份数据,请联系管理员");
        }

        bean.setId(ServiceUtils.generatePrimaryKey());
        DataSyncTask model = new DataSyncTask();
        try {
            BeanUtils.copyProperties(model, bean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.COPYPROPERTIES);
        }
        dataSyncTaskBeanMapper.insert(model);
    }

    @Override
    public void pageQuery(PageBean<DataSyncTaskBean> pageBean, DataSyncTaskBean bean, UserBean user) throws WebMessageException {
        int total = dataSyncTaskBeanMapper.countTotal(bean);
        List<DataSyncTaskBean> list = dataSyncTaskBeanMapper.selectBeanPage(bean, pageBean);
        pageBean.setTotal(total);
        pageBean.setRows(list);
    }

    @Override
    public void pageQueryForNextExecte(PageBean<DataSyncTaskBean> pageBean, DataSyncTaskBean bean) throws WebMessageException {
        int total = dataSyncTaskBeanMapper.countTotalForNextTask(bean);
        List<DataSyncTaskBean> list = dataSyncTaskBeanMapper.selectBeanPageForNextTask(bean, pageBean);
        pageBean.setTotal(total);
        pageBean.setRows(list);
    }

    @Override
    public void updateBean(String id, DataSyncTaskBean dictoryBean) throws WebMessageException {
        if (CommonValidate.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        //校验


        DataSyncTask model = new DataSyncTask();
        try {
            BeanUtils.copyProperties(model, dictoryBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.COPYPROPERTIES);
        }
        dataSyncTaskBeanMapper.updateByPrimaryKeySelective(model);

    }

    @Override
    public DataSyncTaskBean findBeanById(String id) throws WebMessageException {
        if (CommonValidate.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        DataSyncTask model = dataSyncTaskBeanMapper.selectByPrimaryKey(id);
        DataSyncTaskBean bean = new DataSyncTaskBean();
        try {
            BeanUtils.copyProperties(bean, model);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.COPYPROPERTIES);
        }
        return bean;
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (CommonValidate.isEmpty(id)){
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        dataSyncTaskBeanMapper.deleteByPrimaryKey(id);
    }
}
