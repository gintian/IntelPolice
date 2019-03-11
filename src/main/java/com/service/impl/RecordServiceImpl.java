package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Record;
import com.model.RecordCase;
import com.model.bean.RecordBean;
import com.model.bean.RecordCaseBean;
import com.model.mapper.RecordCaseMapper;
import com.page.PageBean;
import com.service.RecordService;
import com.service.mapper.RecordBeanMapper;
import com.utils.RandomUtils;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：RecordServiceImpl 类描述：笔录操作业务逻辑接口实现
 */
@Service("recordService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class RecordServiceImpl  implements RecordService {
	@Autowired
	private RecordBeanMapper recordBeanMapper;
	@Autowired
    private RecordCaseMapper recordCaseMapper;

	@Override
	public void addBean(RecordBean recordBean, RecordCaseBean recordCaseBean) throws WebMessageException {
		if (recordBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		RandomUtils.RandomCode("R","");
		// 添加主键值,, 临时使用uuid,截取20 位
		recordBean.setId(ServiceUtils.generatePrimaryKey());
        recordCaseBean.setId(ServiceUtils.generatePrimaryKey());
        //存储笔录主键在关联类
        recordCaseBean.setRecordId(recordBean.getId());
		// 校验Bean
		validateBean(recordBean);
		Record record = new Record();
        RecordCase recordCase = new RecordCase();
		// 复制Bean 到model

		try {
            ServiceUtils.copyProperties(record, recordBean);
            ServiceUtils.copyProperties(recordCase, recordCaseBean);
			recordBeanMapper.insertSelective(recordBean);
            recordCaseMapper.insertSelective(recordCaseBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
	}

	@Override
	public void updateBean(String id,RecordBean recordBean) throws WebMessageException {
		if (recordBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(recordBean);
		Record record = new Record();
		try {
			ServiceUtils.copyProperties(record, recordBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		recordBeanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		recordBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RecordBean findRecordById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		Record record = recordBeanMapper.selectByPrimaryKey(id);
		if (record != null) {
			RecordBean recordBean = new RecordBean();
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
	public void pageQuery(PageBean<Record> pageBean, RecordBean bean) {
		int total = recordBeanMapper.selectTotal(bean);
		List<RecordBean> recordBeanList = new ArrayList<RecordBean>();
		if (total > 0) {
			recordBeanList = recordBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(recordBeanList);
	}

	@Override
	public List<RecordBean> selectDataAllEqCaseId(String caseid) {
		return recordBeanMapper.selectDataAllEqCaseId(caseid);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(RecordBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}