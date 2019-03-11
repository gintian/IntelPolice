package com.service.impl;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Message;
import com.model.bean.MessageBean;
import com.page.PageBean;
import com.service.MessageService;
import com.service.mapper.MessageBeanMapper;
import com.utils.DateUtils;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 类名称：MessageServiceImpl 类描述：消息操作业务逻辑接口实现
 */
@Service("messageService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageBeanMapper messageBeanMapper;

    @Override
    public void addBean(MessageBean messageBean) throws WebMessageException {
        if (messageBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        messageBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(messageBean);
        Message message = new Message();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(message, messageBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        messageBeanMapper.insertSelective(messageBean);
    }

    @Override
    public void updateBean(String id, MessageBean messageBean) throws WebMessageException {
        if (messageBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(messageBean);
        Message message = new Message();
        try {
            ServiceUtils.copyProperties(message, messageBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        messageBeanMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public void setLooked(String id) throws WebMessageException {
        Message message = messageBeanMapper.selectByPrimaryKey(id);
        message.setIsVisit("1");
        message.setVisitTime(new Date());
        messageBeanMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public void recoverBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        Message message = messageBeanMapper.selectByPrimaryKey(id);
        String status = message.getStatus();
        if (status.equals("0")) {
            message.setStatus("1");
            messageBeanMapper.updateByPrimaryKeySelective(message);
        } else if (status.equals("1") || status.equals("2")) {
            message.setStatus("0");
            messageBeanMapper.updateByPrimaryKeySelective(message);
        } else {
            throw new WebMessageException(WebExceptionConstant.MESSAGE_RECOVER_ERROR);
        }
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        messageBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MessageBean findMessageById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        Message message = messageBeanMapper.selectByPrimaryKey(id);
        if (message != null) {
            MessageBean messageBean = new MessageBean();
            try {
                ServiceUtils.copyProperties(messageBean, message);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return messageBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<Message> pageBean, MessageBean bean) {
        int total = messageBeanMapper.selectTotal(bean);
        List<MessageBean> messageBeanList = new ArrayList<MessageBean>();
        if (total > 0) {
            messageBeanList = messageBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(messageBeanList);
    }

    @Override
    public PageBean<Message> pageQueryNoRead(PageBean<Message> pageBean, MessageBean bean, String userId) {
        bean.setReceiveUserId(userId);
        bean.setIsVisit("0");
        bean.setStatus("1");
        int total = messageBeanMapper.selectTotal(bean);
        List<MessageBean> messageBeanList = new ArrayList<MessageBean>();
        if (total > 0) {
            messageBeanList = messageBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(messageBeanList);
        return pageBean;
    }

    /**
     * 校验 bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(MessageBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}
