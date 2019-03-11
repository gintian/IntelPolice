package com.service;

import com.exception.WebMessageException;
import com.model.InvestigationExpAlarm;
import com.model.bean.InvestigationExpAlarmBean;
import com.page.PageBean;

public interface InvestigationExpAlarmService {
    //增加
    void addBean(InvestigationExpAlarmBean bean) throws WebMessageException;

    //修改
    void updateBean(String exceptionId, InvestigationExpAlarmBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String exceptionId) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    InvestigationExpAlarmBean findInvestigationExpAlarmById(String exceptionId) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<InvestigationExpAlarmBean> pageBean, InvestigationExpAlarmBean bean);
}