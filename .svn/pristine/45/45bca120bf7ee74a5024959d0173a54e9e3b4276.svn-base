package com.service.mapper;

import java.util.List;

import com.model.bean.DeptBean;
import org.apache.ibatis.annotations.Param;

import com.model.Message;
import com.model.bean.MessageBean;
import com.model.mapper.MessageMapper;
import com.page.PageBean;

public interface MessageBeanMapper extends  MessageMapper {
	// 查询分页数据
	List<MessageBean> selectData(@Param("entity") MessageBean bean, @Param("pageBean") PageBean<Message> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") MessageBean bean);
}
