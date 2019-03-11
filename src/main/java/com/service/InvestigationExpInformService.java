package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationExpInform;
import com.model.bean.InvestigationExpInformBean;
import com.page.PageBean;

public interface InvestigationExpInformService {
    //增加
    void addBean(InvestigationExpInformBean bean) throws WebMessageException;

    //修改
    void updateBean(String informId, InvestigationExpInformBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String informId) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationExpInformBean findInvestigationExpInformById(String informId) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationExpInformBean> pageBean, InvestigationExpInformBean bean);
}