package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.ArchiveStoresBoxLog;
import com.model.bean.ArchiveStoresBoxLogBean;
import com.page.PageBean;
import com.service.ArchiveStoresBoxLogService;
import com.service.mapper.ArchiveStoresBoxLogBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：ArchiveStoresBoxServiceImpl 类描述：留言操作业务逻辑接口实现
 */
@Service("archiveStoresBoxLogService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class ArchiveStoresBoxLogServiceImpl implements ArchiveStoresBoxLogService {
	@Autowired
	private ArchiveStoresBoxLogBeanMapper archiveStoresBoxLogBeanMapper;

	@Override
	public void addBean(ArchiveStoresBoxLogBean archiveStoresBoxLogBean) throws WebMessageException {
		if (archiveStoresBoxLogBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		if(archiveStoresBoxLogBean.getId() == null){
			// 添加主键值,, 临时使用uuid,截取20 位
			archiveStoresBoxLogBean.setId(ServiceUtils.generatePrimaryKey());
		}
		// 校验Bean
		validateBean(archiveStoresBoxLogBean);
		ArchiveStoresBoxLog archiveStoresBoxLog = new ArchiveStoresBoxLog();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(archiveStoresBoxLog, archiveStoresBoxLogBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveStoresBoxLogBeanMapper.insertSelective(archiveStoresBoxLogBean);
	}

	@Override
	public void updateBean(String id,ArchiveStoresBoxLogBean archiveStoresBoxLogBean) throws WebMessageException {
		if (archiveStoresBoxLogBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(archiveStoresBoxLogBean);
		ArchiveStoresBoxLog archiveStoresBoxLog = new ArchiveStoresBoxLog();
		try {
			ServiceUtils.copyProperties(archiveStoresBoxLog, archiveStoresBoxLogBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveStoresBoxLogBeanMapper.updateByPrimaryKeySelective(archiveStoresBoxLog);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		archiveStoresBoxLogBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ArchiveStoresBoxLogBean findArchiveStoresBoxLogById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		ArchiveStoresBoxLog archiveStoresBoxLog = archiveStoresBoxLogBeanMapper.selectByPrimaryKey(id);
		if (archiveStoresBoxLog != null) {
			ArchiveStoresBoxLogBean archiveStoresBoxBean = new ArchiveStoresBoxLogBean();
			try {
				ServiceUtils.copyProperties(archiveStoresBoxBean, archiveStoresBoxLog);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return archiveStoresBoxBean;
		}
		return null;
	}



	@Override
	public void pageQuery(PageBean<ArchiveStoresBoxLogBean> pageBean, ArchiveStoresBoxLogBean bean) {
		int total = archiveStoresBoxLogBeanMapper.selectTotal(bean);
		List<ArchiveStoresBoxLogBean> archiveStoresBoxLogBeanList = new ArrayList<ArchiveStoresBoxLogBean>();
		if (total > 0) {
			archiveStoresBoxLogBeanList = archiveStoresBoxLogBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(archiveStoresBoxLogBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(ArchiveStoresBoxLogBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
