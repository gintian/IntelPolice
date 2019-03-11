package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvolvedStoresLockers;
import com.model.bean.InvolvedStoresLockersBean;
import com.page.PageBean;
import com.service.InvolvedStoresLockersService;
import com.service.mapper.InvolvedStoresLockersBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedStoresLockersServiceImpl 类描述：仓库储物柜操作业务逻辑接口实现
 */
@Service("involvedStoresLockersService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedStoresLockersServiceImpl implements InvolvedStoresLockersService {
	@Autowired
	private InvolvedStoresLockersBeanMapper involvedStoresLockersBeanMapper;

	@Override
	public void addBean(InvolvedStoresLockersBean involvedStoresLockersBean) throws WebMessageException {
		if (involvedStoresLockersBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		involvedStoresLockersBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(involvedStoresLockersBean);
		InvolvedStoresLockers involvedStoresLockers = new InvolvedStoresLockers();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(involvedStoresLockers, involvedStoresLockersBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedStoresLockersBeanMapper.insertSelective(involvedStoresLockersBean);
	}

	@Override
	public void updateBean(String id,InvolvedStoresLockersBean involvedStoresLockersBean) throws WebMessageException {
		if (involvedStoresLockersBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(involvedStoresLockersBean);
		InvolvedStoresLockers involvedStoresLockers = new InvolvedStoresLockers();
		try {
			ServiceUtils.copyProperties(involvedStoresLockers, involvedStoresLockersBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedStoresLockersBeanMapper.updateByPrimaryKeySelective(involvedStoresLockers);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		involvedStoresLockersBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InvolvedStoresLockersBean findInvolvedStoresLockersById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		InvolvedStoresLockers involvedStoresLockers = involvedStoresLockersBeanMapper.selectByPrimaryKey(id);
		if (involvedStoresLockers != null) {
			InvolvedStoresLockersBean involvedStoresLockersBean = new InvolvedStoresLockersBean();
			try {
				ServiceUtils.copyProperties(involvedStoresLockersBean, involvedStoresLockers);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return involvedStoresLockersBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<InvolvedStoresLockers> pageBean, InvolvedStoresLockersBean bean) {
		int total = involvedStoresLockersBeanMapper.selectTotal(bean);
		List<InvolvedStoresLockersBean> involvedStoresLockersBeanList = new ArrayList<InvolvedStoresLockersBean>();
		if (total > 0) {
			involvedStoresLockersBeanList = involvedStoresLockersBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(involvedStoresLockersBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(InvolvedStoresLockersBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
