package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.ArchiveStores;
import com.model.bean.ArchiveStoresBean;
import com.page.PageBean;
import com.service.ArchiveStoresService;
import com.service.mapper.ArchiveStoresBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：ArchiveStoresInfosServiceImpl 类描述：涉案财物信息表操作业务逻辑接口实现
 */
@Service("archiveStoresInfosService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class ArchiveStoresServiceImpl implements ArchiveStoresService {
	@Autowired
	private ArchiveStoresBeanMapper archiveStoresBeanMapper;

	@Override
	public String addBean(ArchiveStoresBean archiveStoresBean) throws WebMessageException {
		if (archiveStoresBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		archiveStoresBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(archiveStoresBean);
		ArchiveStores archiveStores = new ArchiveStores();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(archiveStores, archiveStoresBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveStoresBeanMapper.insertSelective(archiveStoresBean);
		return archiveStoresBean.getId();
	}

	@Override
	public void updateBean(String id,ArchiveStoresBean archiveStoresBean) throws WebMessageException {
		if (archiveStoresBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(archiveStoresBean);
		ArchiveStores archiveStores = new ArchiveStores();
		try {
			ServiceUtils.copyProperties(archiveStores, archiveStoresBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveStoresBeanMapper.updateByPrimaryKeySelective(archiveStores);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		archiveStoresBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ArchiveStoresBean findArchiveStoresById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		ArchiveStores archiveStores = archiveStoresBeanMapper.selectByPrimaryKey(id);
		if (archiveStores != null) {
			ArchiveStoresBean archiveStoresBean = new ArchiveStoresBean();
			try {
				ServiceUtils.copyProperties(archiveStoresBean, archiveStores);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return archiveStoresBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<ArchiveStores> pageBean, ArchiveStoresBean bean) {
		int total = archiveStoresBeanMapper.selectTotal(bean);
		List<ArchiveStoresBean> archiveStoresBeanList = new ArrayList<ArchiveStoresBean>();
		if (total > 0) {
			archiveStoresBeanList = archiveStoresBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(archiveStoresBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param
	 * @throws Exception
	 *             校验异常
	 */

	private void validateBean(ArchiveStoresBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
