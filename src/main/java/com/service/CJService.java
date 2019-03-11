package com.service;

import com.exception.WebMessageException;
import com.model.CJ;
import com.model.bean.CJBean;
import com.page.PageBean;

/**
 * 类名称：CJService 类描述：处警单逻辑接口
 */
public interface CJService {
    //添加
    void addBean(CJBean cjBean) throws WebMessageException;

    //修改
    void updateBean(String cjdbh, CJBean cjBean) throws WebMessageException;

    //删除
    void deleteBean(String cjdbh) throws WebMessageException;

    /**
     * 通过cjdbh查询Bean
     */
    CJBean findCJByCjdbh(String cjdbh) throws WebMessageException;

    /**
     * 条件查询：分页条件
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageQuery(PageBean<CJ> pageBean, CJBean bean);

    void pageQueryByTimeout(PageBean<CJ> pageBean, CJBean bean);

    CJBean findCJAndJJById(String cjdbh) throws WebMessageException;

    /**
     * 条件查询：多条反馈
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageQueryFeedbacks(PageBean<CJ> pageBean, CJBean bean);

    /**
     * 条件查询：超时未立案
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageQueryCsWla(PageBean<CJ> pageBean, CJBean bean);

    /**
     * 条件查询：超时未立案
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageQueryCsLa(PageBean<CJ> pageBean, CJBean bean);

    /**
     * 通过jjdbh查询Bean
     */
    CJBean findCJByJjdbh(String jjdbh) throws WebMessageException;

    void pageQueryNotView(PageBean<CJ> pageBean, CJ bean);

    void pageQueryCorrelateView(PageBean<CJ> pageBean, CJ bean);
}
