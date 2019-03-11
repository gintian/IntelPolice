package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvolvedStores;
import com.model.bean.InvolvedStoresBean;
import com.page.PageBean;
import com.service.InvolvedStoresService;
import com.service.mapper.InvolvedStoresBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedStoresServiceImpl 类描述：仓库表操作业务逻辑接口实现
 */
@Service("involvedStoresService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedStoresServiceImpl implements InvolvedStoresService {
	@Autowired
	private InvolvedStoresBeanMapper involvedStoresBeanMapper;

	@Override
	public void addBean(InvolvedStoresBean involvedStoresBean) throws WebMessageException {
		if (involvedStoresBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		involvedStoresBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(involvedStoresBean);
		InvolvedStores involvedStores = new InvolvedStores();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(involvedStores, involvedStoresBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedStoresBeanMapper.insertSelective(involvedStoresBean);
	}

	@Override
	public void updateBean(String id,InvolvedStoresBean involvedStoresBean) throws WebMessageException {
		if (involvedStoresBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(involvedStoresBean);
		InvolvedStores involvedStores = new InvolvedStores();
		try {
			ServiceUtils.copyProperties(involvedStores, involvedStoresBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedStoresBeanMapper.updateByPrimaryKeySelective(involvedStores);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		involvedStoresBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InvolvedStoresBean findInvolvedStoresById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		InvolvedStores involvedStores = involvedStoresBeanMapper.selectByPrimaryKey(id);
		if (involvedStores != null) {
			InvolvedStoresBean involvedStoresBean = new InvolvedStoresBean();
			try {
				ServiceUtils.copyProperties(involvedStoresBean, involvedStores);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return involvedStoresBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<InvolvedStores> pageBean, InvolvedStoresBean bean) {
		int total = involvedStoresBeanMapper.selectTotal(bean);
		List<InvolvedStoresBean> involvedStoresBeanList = new ArrayList<InvolvedStoresBean>();
		if (total > 0) {
			involvedStoresBeanList = involvedStoresBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(involvedStoresBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(InvolvedStoresBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
