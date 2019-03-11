package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.JJ;
import com.model.bean.JJBean;
import com.page.PageBean;
import com.service.JJService;
import com.service.mapper.JJBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：JJServiceImpl 类描述：接警单操作业务逻辑接口实现
 */
@Service("jjService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class JJServiceImpl implements JJService {
    @Autowired
    private JJBeanMapper jjBeanMapper;

    @Override
    public void addBean(JJBean jjBean) throws WebMessageException {
        if (jjBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        jjBean.setJjdbh(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(jjBean);
        JJ jj = new JJ();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(jj, jjBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        jjBeanMapper.insertSelective(jjBean);
    }

    @Override
    public void updateBean(String jjdbh, JJBean jjBean) throws WebMessageException {
        if (jjBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(jjBean);
        JJ jj = new JJ();
        try {
            ServiceUtils.copyProperties(jj, jjBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        jjBeanMapper.updateByPrimaryKeySelective(jj);
    }

    @Override
    public void deleteBean(String jjdbh) throws WebMessageException {
        if (StringUtils.isEmpty(jjdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        jjBeanMapper.deleteByPrimaryKey(jjdbh);
    }

    @Override
    public JJBean findJJByJjdbh(String jjdbh) throws WebMessageException {
        if (StringUtils.isEmpty(jjdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        JJBean jjBean = jjBeanMapper.selectJJEqJjdbh(jjdbh);
        if (jjBean != null) {
            return jjBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<JJ> pageBean, JJBean bean) {
        int total = jjBeanMapper.selectTotal(bean);
        List<JJBean> jjBeanList = new ArrayList<JJBean>();
        if (total > 0) {
            jjBeanList = jjBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(jjBeanList);
    }

    @Override
    public void pageQueryUnrelated(PageBean<JJ> pageBean, JJBean bean) {
        int total = jjBeanMapper.selectTotalUnrelated(bean);
        List<JJBean> jjBeanList = new ArrayList<JJBean>();
        if (total > 0) {
            jjBeanList = jjBeanMapper.selectDataUnrelated(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(jjBeanList);
    }

    @Override
    public void pageQueryNotRecordings(PageBean<JJ> pageBean, JJBean bean) {
        int total = jjBeanMapper.selectTotalUnrelated(bean);
        List<JJBean> jjBeanList = new ArrayList<JJBean>();
        if (total > 0) {
            jjBeanList = jjBeanMapper.selectDataNotRecordings(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(jjBeanList);
    }

    @Override
    public JJBean findJJBycaseId(String caseId) throws WebMessageException {
        if (StringUtils.isEmpty(caseId)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        JJBean jjBean = jjBeanMapper.selectByCaseId(caseId);
        if (jjBean != null) {
            return jjBean;
        }
        return null;
    }


    /**
     * 校验  bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(JJBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getJjdbh())) {
            throw new WebMessageException(WebExceptionConstant.JJ_JJDBH_IS_NONE);
        }
    }

    @Override
    public void pageQueryNotView(PageBean<JJ> pageBean, JJBean bean) {

        int total = jjBeanMapper.selectNotViewTotal();

        List<JJBean> list = jjBeanMapper.selectNotView(pageBean, bean);

        pageBean.setTotal(total);
        pageBean.setRows(list);


    }

    @Override
    public void pageQueryCorrelateView(PageBean<JJ> pageBean, JJBean bean) {

        int total = jjBeanMapper.selectCorrelateViewTotal();
        List<JJBean> list = jjBeanMapper.selectCorrelateView(pageBean, bean);
        pageBean.setTotal(total);
        pageBean.setRows(list);

    }


}