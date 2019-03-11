package com.service;

import com.exception.WebMessageException;
import com.model.RecordPerson;
import com.model.bean.RecordPersonBean;
import com.page.PageBean;

/**
 * 类名称：RecordService 类描述：笔录逻辑接口
 */
public interface RecordPersonService {
	 //增加
		void addBean(RecordPersonBean bean) throws WebMessageException;
		 //修改
		void updateBean(String id, RecordPersonBean bean) throws WebMessageException;
		 // 删除
		void deleteBean(String id) throws WebMessageException;
		/**
		 * 通过Id查询Bean
		 */
		RecordPersonBean findRecordById(String id) throws WebMessageException;
		/**
		 * 分页查询
		 * @param pageBean		[必填]		分页对象
		 * @param bean				[必填]      查询条件
		 */
		void pageQuery(PageBean<RecordPersonBean> pageBean, RecordPersonBean bean);
}
