package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.ArchiveStoresLockers;
import com.model.bean.ArchiveStoresLockersBean;
import com.page.PageBean;
import com.service.ArchiveStoresLockersService;
import com.service.mapper.ArchiveStoresLockersBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedStoresLockersServiceImpl 类描述：仓库储物柜操作业务逻辑接口实现
 */
@Service("ArchiveStoresLockersService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class ArchiveStoresLockersServiceImpl implements ArchiveStoresLockersService {
	@Autowired
	private ArchiveStoresLockersBeanMapper archiveStoresLockersBeanMapper;

	@Override
	public void addBean(ArchiveStoresLockersBean archiveStoresLockersBean) throws WebMessageException {
		if (archiveStoresLockersBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		archiveStoresLockersBean.setLockersId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(archiveStoresLockersBean);
		ArchiveStoresLockersBean archiveStoresLockers = new ArchiveStoresLockersBean();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(archiveStoresLockers, archiveStoresLockersBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		try{
			archiveStoresLockersBeanMapper.insertSelective(archiveStoresLockersBean);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void updateBean(String id,ArchiveStoresLockersBean archiveStoresLockersBean) throws WebMessageException {
		if (archiveStoresLockersBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(archiveStoresLockersBean);
		ArchiveStoresLockers archiveStoresLockers = new ArchiveStoresLockers();
		try {
			ServiceUtils.copyProperties(archiveStoresLockers, archiveStoresLockersBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveStoresLockersBeanMapper.updateByPrimaryKeySelective(archiveStoresLockers);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		archiveStoresLockersBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ArchiveStoresLockersBean findInvolvedStoresLockersById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象

		ArchiveStoresLockers archiveStoresLockers = null;
		try{
			archiveStoresLockers = archiveStoresLockersBeanMapper.selectByPrimaryKey(id);
		}catch(Exception e){e.printStackTrace();}
		if (archiveStoresLockers != null) {
			ArchiveStoresLockersBean archiveStoresLockersBean = new ArchiveStoresLockersBean();
			try {
				ServiceUtils.copyProperties(archiveStoresLockersBean, archiveStoresLockers);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return archiveStoresLockersBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<ArchiveStoresLockers> pageBean, ArchiveStoresLockersBean bean) {
		int total = archiveStoresLockersBeanMapper.selectTotal(bean);
		List<ArchiveStoresLockersBean> involvedStoresLockersBeanList = new ArrayList<ArchiveStoresLockersBean>();
		if (total > 0) {
			involvedStoresLockersBeanList = archiveStoresLockersBeanMapper.selectData(bean, pageBean);
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
	private void validateBean(ArchiveStoresLockersBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getLockersId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
