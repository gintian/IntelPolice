package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationJucDept;
import com.model.bean.InvestigationJucDeptBean;
import com.page.PageBean;

public interface InvestigationJucDeptService {
    //增加
    void addBean(InvestigationJucDeptBean bean) throws WebMessageException;

    //修改
    void updateBean(String id, InvestigationJucDeptBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String id) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationJucDeptBean findInvestigationJucDeptById(String id) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationJucDeptBean> pageBean, InvestigationJucDeptBean bean);
}