package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationExpType;
import com.model.bean.InvestigationExpTypeBean;
import com.page.PageBean;

public interface InvestigationExpTypeService {
    //增加
    void addBean(InvestigationExpTypeBean bean) throws WebMessageException;

    //修改
    void updateBean(String id, InvestigationExpTypeBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String id) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationExpTypeBean findInvestigationExpTypeById(String id) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationExpTypeBean> pageBean, InvestigationExpTypeBean bean);
}