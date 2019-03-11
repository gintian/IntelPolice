package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationKeywords;
import com.model.bean.InvestigationKeywordsBean;
import com.page.PageBean;

public interface InvestigationKeywordsService {
    //增加
    void addBean(InvestigationKeywordsBean bean) throws WebMessageException;

    //修改
    void updateBean(String keywordsId, InvestigationKeywordsBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String keywordsId) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationKeywordsBean findInvestigationKeywordsById(String keywordsId) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationKeywordsBean> pageBean, InvestigationKeywordsBean bean);
}