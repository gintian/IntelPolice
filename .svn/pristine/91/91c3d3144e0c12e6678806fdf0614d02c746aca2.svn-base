package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.RecordPerson;
import com.model.bean.RecordPersonBean;
import com.page.PageBean;
import com.service.RecordPersonService;
import com.service.mapper.RecordPersonBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：RecordServiceImpl 类描述：笔录操作业务逻辑接口实现
 */
@Service("recordPersonService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class RecordPersonServiceImpl implements RecordPersonService {
	@Autowired
	private RecordPersonBeanMapper recordPersonBeanMapper;

	@Override
	public void addBean(RecordPersonBean recordPersonBean) throws WebMessageException {
		if (recordPersonBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		recordPersonBean.setPersonId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(recordPersonBean);
		RecordPerson record = new RecordPerson();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(record, recordPersonBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		recordPersonBeanMapper.insertSelective(recordPersonBean);
	}

	@Override
	public void updateBean(String id,RecordPersonBean recordBean) throws WebMessageException {
		if (recordBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(recordBean);
		RecordPerson record = new RecordPerson();
		try {
			ServiceUtils.copyProperties(record, recordBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		recordPersonBeanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		recordPersonBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RecordPersonBean findRecordById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		RecordPerson record = recordPersonBeanMapper.selectByPrimaryKey(id);
		if (record != null) {
			RecordPersonBean recordBean = new RecordPersonBean();
			try {
				ServiceUtils.copyProperties(recordBean, record);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return recordBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<RecordPersonBean> pageBean, RecordPersonBean bean) {
		int total = recordPersonBeanMapper.selectTotal(bean);
		List<RecordPersonBean> recordBeanList = new ArrayList<RecordPersonBean>();
		if (total > 0) {
			recordBeanList = recordPersonBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(recordBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(RecordPersonBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getPersonId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}