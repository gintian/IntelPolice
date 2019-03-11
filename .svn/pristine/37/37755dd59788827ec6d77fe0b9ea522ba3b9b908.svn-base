package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationRelated;
import com.model.bean.InvestigationRelatedBean;
import com.page.PageBean;

public interface InvestigationRelatedService {
    //增加
    void addBean(InvestigationRelatedBean bean) throws WebMessageException;

    //修改
    void updateBean(String withBreakId, InvestigationRelatedBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String withBreakId) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationRelatedBean findInvestigationRelatedById(String withBreakId) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationRelatedBean> pageBean, InvestigationRelatedBean bean);
}