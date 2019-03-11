package com.service;

import com.exception.WebMessageException;
import com.model.Record;
import com.model.RecordCase;
import com.model.bean.RecordBean;
import com.model.bean.RecordCaseBean;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类名称：RecordService 类描述：笔录逻辑接口
 */
public interface RecordService {
	 //增加
		void addBean(RecordBean bean, RecordCaseBean recordCaseBean) throws WebMessageException;
		 //修改
		void updateBean(String id, RecordBean bean) throws WebMessageException;
		 // 删除
		void deleteBean(String id) throws WebMessageException;
		/**
		 * 通过Id查询Bean
		 */
		RecordBean findRecordById(String id) throws WebMessageException;
		/**
		 * 分页查询
		 * @param pageBean		[必填]		分页对象
		 * @param bean				[必填]      查询条件
		 */
		void pageQuery(PageBean<Record> pageBean, RecordBean bean);

		List<RecordBean> selectDataAllEqCaseId(String caseid);
}
