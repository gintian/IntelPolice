package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Notice;
import com.model.bean.NoticeBean;
import com.model.mapper.NoticeMapper;
import com.page.PageBean;

public interface NoticeBeanMapper extends NoticeMapper {
	// 查询分页数据
	List<NoticeBean> selectData(@Param("entity") NoticeBean bean, @Param("pageBean") PageBean<Notice> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") NoticeBean bean);

	//查询首条置顶公告
	public abstract NoticeBean selectBeanIndex();
}
