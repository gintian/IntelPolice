package com.service;

import com.exception.WebMessageException;
import com.model.Message;
import com.model.bean.MessageBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：FeedbackService 类描述：消息逻辑接口
 */
public interface MessageService {
    //增加
    void addBean(MessageBean bean) throws WebMessageException;

    //修改
    void updateBean(String id, MessageBean bean) throws WebMessageException;

    // 删除
    void deleteBean(String id) throws WebMessageException;

    /**
     * @param id 消息ID
     *  设置为已查看
     */
    void setLooked(String id) throws  WebMessageException;

    /**
     * @param id 消息ID
     * 回收，还原
     */

    void recoverBean(String id) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    MessageBean findMessageById(String id) throws WebMessageException;

    /**
     * 分页查询
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    void pageQuery(PageBean<Message> pageBean, MessageBean bean);

    /**
     * 未读消息
     *
     * @param pageBean [必填]		分页对象
     * @param bean     [必填]      查询条件
     */
    PageBean<Message> pageQueryNoRead(PageBean<Message> pageBean, MessageBean bean, String userId);

}
