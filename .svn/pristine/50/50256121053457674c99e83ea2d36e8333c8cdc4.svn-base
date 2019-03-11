package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvolvedStoresBox;
import com.model.bean.InvolvedStoresBoxBean;
import com.page.PageBean;
import com.service.InvolvedStoresBoxService;
import com.service.mapper.InvolvedStoresBoxBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedStoresBoxServiceImpl 类描述：储物柜箱子表操作业务逻辑接口实现
 */
@Service("involvedStoresBoxService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedStoresBoxServiceImpl implements InvolvedStoresBoxService {
	@Autowired
	private InvolvedStoresBoxBeanMapper involvedStoresBoxBeanMapper;

	@Override
	public void addBean(InvolvedStoresBoxBean involvedStoresBoxBean) throws WebMessageException {
		if (involvedStoresBoxBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		involvedStoresBoxBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(involvedStoresBoxBean);
		InvolvedStoresBox involvedStoresBox = new InvolvedStoresBox();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(involvedStoresBox, involvedStoresBoxBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedStoresBoxBeanMapper.insertSelective(involvedStoresBoxBean);
	}

	@Override
	public void updateBean(String id,InvolvedStoresBoxBean involvedStoresBoxBean) throws WebMessageException {
		if (involvedStoresBoxBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(involvedStoresBoxBean);
		InvolvedStoresBox involvedStoresBox = new InvolvedStoresBox();
		try {
			ServiceUtils.copyProperties(involvedStoresBox, involvedStoresBoxBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedStoresBoxBeanMapper.updateByPrimaryKeySelective(involvedStoresBox);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		involvedStoresBoxBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InvolvedStoresBoxBean findInvolvedStoresBoxById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		InvolvedStoresBox involvedStoresBox = involvedStoresBoxBeanMapper.selectByPrimaryKey(id);
		if (involvedStoresBox != null) {
			InvolvedStoresBoxBean involvedStoresBoxBean = new InvolvedStoresBoxBean();
			try {
				ServiceUtils.copyProperties(involvedStoresBoxBean, involvedStoresBox);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return involvedStoresBoxBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<InvolvedStoresBox> pageBean, InvolvedStoresBoxBean bean) {
		int total = involvedStoresBoxBeanMapper.selectTotal(bean);
		List<InvolvedStoresBoxBean> involvedStoresBoxBeanList = new ArrayList<InvolvedStoresBoxBean>();
		if (total > 0) {
			involvedStoresBoxBeanList = involvedStoresBoxBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(involvedStoresBoxBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(InvolvedStoresBoxBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
