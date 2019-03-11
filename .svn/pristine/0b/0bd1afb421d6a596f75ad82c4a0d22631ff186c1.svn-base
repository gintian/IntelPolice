package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.LY;
import com.model.bean.LYBean;
import com.page.PageBean;
import com.service.LYService;
import com.service.mapper.LYBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：LYServiceImpl 类描述：反馈单操作业务逻辑接口实现
 */
@Service("lyService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class LYServiceImpl implements LYService {
    @Autowired
    private LYBeanMapper lyBeanMapper;

    @Override
    public void addBean(LYBean lyBean) throws WebMessageException {
        if (lyBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        lyBean.setLybh(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(lyBean);
        LY ly = new LY();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(ly, lyBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        lyBeanMapper.insertSelective(lyBean);
    }

    @Override
    public void updateBean(String lybh, LYBean lyBean) throws WebMessageException {
        if (lyBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(lyBean);
        LY ly = new LY();
        try {
            ServiceUtils.copyProperties(ly, lyBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        lyBeanMapper.updateByPrimaryKeySelective(ly);
    }

    @Override
    public void deleteBean(String lybh) throws WebMessageException {
        if (StringUtils.isEmpty(lybh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        lyBeanMapper.deleteByPrimaryKey(lybh);
    }

    @Override
    public LYBean findLYByLybh(String lybh) throws WebMessageException {
        if (StringUtils.isEmpty(lybh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        LYBean lyBean = lyBeanMapper.selectLYEqLybh(lybh);
        if (lyBean != null) {
            return lyBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<LY> pageBean, LYBean bean) {
        int total = lyBeanMapper.selectTotal(bean);
        List<LYBean> lyBeanList = new ArrayList<LYBean>();
        if (total > 0) {
            lyBeanList = lyBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(lyBeanList);
    }

    /**
     * 校验  bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(LYBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getLybh())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}