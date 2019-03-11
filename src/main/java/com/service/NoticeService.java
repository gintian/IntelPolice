package com.service;

import com.exception.WebMessageException;
import com.model.Notice;
import com.model.bean.NoticeBean;
import com.page.PageBean;

/**
 * 类名称：NoticeService 类描述：公告逻辑接口
 */
public interface NoticeService {
    //增加
    void addBean(NoticeBean bean) throws WebMessageException;

    //修改
    void updateBean(String id, NoticeBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String id) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    NoticeBean findNoticeById(String id) throws WebMessageException;

    /**
     * 查询首条置顶公告
     */
    public abstract NoticeBean findNoticeIndex()
            throws WebMessageException;

    /**
     *设置显示/隐藏
     * @param id
     * @throws WebMessageException
     */
    void setLookAble(String id) throws WebMessageException;

    /**
     *设置置顶/取消置顶
     * @param id
     * @throws WebMessageException
     */
    void setTop(String id) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<Notice> pageBean, NoticeBean bean);

    /**
     * 列表展示
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQueryList(PageBean<Notice> pageBean, NoticeBean bean);

}
