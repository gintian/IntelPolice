package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvolvedTypes;
import com.model.bean.InvolvedTypesBean;
import com.page.PageBean;
import com.service.InvolvedTypesService;
import com.service.mapper.InvolvedTypesBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedTypesServiceImpl 类描述：涉案财物信息表操作业务逻辑接口实现
 */
@Service("involvedTypesService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedTypesServiceImpl implements InvolvedTypesService {
    @Autowired
    private InvolvedTypesBeanMapper involvedTypesBeanMapper;

    @Override
    public String addBean(InvolvedTypesBean involvedTypesBean) throws WebMessageException {
        if (involvedTypesBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        if (involvedTypesBean.getParentid() == involvedTypesBean.getId()) {
            throw new WebMessageException(WebExceptionConstant.PARENT_IS_SELF);
        }
        /*
         * 财物分类ID逻辑
         */
        InvolvedTypesBean bean1 = new InvolvedTypesBean();
        int size1 = involvedTypesBeanMapper.selectTotal(bean1);
        if (size1 > 0) {
            String idX = size1 < 10 ? "1000000" + size1 : size1 < 100 ? "100000" + size1 : size1 < 1000 ? "10000" + size1 : "1000" + size1;
            //检查ID是否已使用
            while (involvedTypesBeanMapper.selectByPrimaryKey(idX) != null) {
                size1++;
                idX = size1 < 10 ? "1000000" + size1 : size1 < 100 ? "100000" + size1 : size1 < 1000 ? "10000" + size1 : "1000" + size1;
            }
            involvedTypesBean.setId(idX);
        }
        /*
         * 财物分类Code逻辑
         */
        if (involvedTypesBean.getParentid() == null) {
            if (involvedTypesBean.getSortcode() == null || involvedTypesBean.getSortcode().equals("")) {
                int size2 = 1;
                String sortCodeX = size2 < 10 ? "00" + size2 : size2 < 100 ? "0" + size2 : size2 + "";
                InvolvedTypesBean bean2 = new InvolvedTypesBean();
                bean2.setCode("0" + sortCodeX);
                //检查排序号是否已使用
                while (involvedTypesBeanMapper.selectTotal(bean2) > 0) {
                    size2++;
                    sortCodeX = size2 < 10 ? "00" + size2 : size2 < 100 ? "0" + size2 : size2 + "";
                    bean2.setCode("0" + sortCodeX);
                }
                involvedTypesBean.setSortcode(sortCodeX);
            }
            // 编号 = 父类编号 + 排序号
            involvedTypesBean.setCode("0" + involvedTypesBean.getSortcode());
        } else {
            InvolvedTypes parent = involvedTypesBeanMapper.selectByPrimaryKey(involvedTypesBean.getParentid());
            if (involvedTypesBean.getSortcode() == null || involvedTypesBean.getSortcode().equals("")) {
                //没有设定排序号时采用自增得到排序号
                int size2 = 1;
                String sortCodeX = size2 < 10 ? "00" + size2 : size2 < 100 ? "0" + size2 : size2 + "";
                InvolvedTypesBean bean2 = new InvolvedTypesBean();
                bean2.setCode(parent.getCode() + sortCodeX);
                //检查排序号是否已使用
                while (involvedTypesBeanMapper.selectTotal(bean2) > 0) {
                    size2++;
                    sortCodeX = size2 < 10 ? "00" + size2 : size2 < 100 ? "0" + size2 : size2 + "";
                    bean2.setCode(parent.getCode() + sortCodeX);
                }
                involvedTypesBean.setSortcode(sortCodeX);
            }
            // 编号 = 父类编号 + 排序号
            involvedTypesBean.setCode(parent.getCode() + involvedTypesBean.getSortcode());
        }
        // 添加主键值,, 临时使用uuid,截取20 位
//		involvedTypesBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(involvedTypesBean);

        InvolvedTypes involvedTypes = new InvolvedTypes();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(involvedTypes, involvedTypesBean);
        } catch (
                Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedTypesBeanMapper.insertSelective(involvedTypesBean);
        return involvedTypesBean.getId();
    }

    @Override
    public void updateBean(String id, InvolvedTypesBean involvedTypesBean) throws WebMessageException {
        if (involvedTypesBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(involvedTypesBean);
        InvolvedTypes involvedTypes = new InvolvedTypes();
        try {
            ServiceUtils.copyProperties(involvedTypes, involvedTypesBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        involvedTypesBeanMapper.updateByPrimaryKeySelective(involvedTypes);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        involvedTypesBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public InvolvedTypesBean findInvolvedTypesById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        InvolvedTypes involved = involvedTypesBeanMapper.selectByPrimaryKey(id);
        if (involved != null) {
            InvolvedTypesBean involvedTypesBean = new InvolvedTypesBean();
            try {
                ServiceUtils.copyProperties(involvedTypesBean, involved);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return involvedTypesBean;
        }
        return null;
    }

    @Override
    public InvolvedTypesBean findInvolvedTypesByCode(String code) throws WebMessageException {
        if (StringUtils.isEmpty(code)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        InvolvedTypesBean involvedTypesBean = involvedTypesBeanMapper.selectByCode(code);
        if (involvedTypesBean != null) {
            return involvedTypesBean;
        }
        return null;
    }

    @Override
    public List<InvolvedTypesBean> findInvolvedTypesByParentId(String parentId) throws WebMessageException {
        if (StringUtils.isEmpty(parentId)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        List<InvolvedTypesBean> list = involvedTypesBeanMapper.selectByParentId(parentId);
        return list;
    }

    @Override
    public List<InvolvedTypesBean> findAll() throws WebMessageException {
        List<InvolvedTypesBean> involvedTypesBeanList = new ArrayList<InvolvedTypesBean>();
        // 查询对象
        involvedTypesBeanList = involvedTypesBeanMapper.selectAll();
        return involvedTypesBeanList;
    }

    @Override
    public void pageQuery(PageBean<InvolvedTypes> pageBean, InvolvedTypesBean bean) {
        int total = involvedTypesBeanMapper.selectTotal(bean);
        List<InvolvedTypesBean> involvedTypesBeanList = new ArrayList<InvolvedTypesBean>();
        if (total > 0) {
            involvedTypesBeanList = involvedTypesBeanMapper.selectBeanPage(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(involvedTypesBeanList);
    }

    /**
     * 校验 bean 对象
     *
     * @param
     * @throws Exception 校验异常
     */

    private void validateBean(InvolvedTypesBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}
