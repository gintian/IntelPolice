package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationSupAlarm;
import com.model.bean.InvestigationSupAlarmBean;
import com.page.PageBean;

public interface InvestigationSupAlarmService {
    //增加
    void addBean(InvestigationSupAlarmBean bean) throws WebMessageException;

    //修改
    void updateBean(String suspicId, InvestigationSupAlarmBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String suspicId) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationSupAlarmBean findInvestigationSupAlarmById(String suspicId) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationSupAlarmBean> pageBean, InvestigationSupAlarmBean bean);
}