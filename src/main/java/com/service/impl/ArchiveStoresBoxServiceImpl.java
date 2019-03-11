package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.ArchiveStoresBox;
import com.model.bean.ArchiveStoresBoxBean;
import com.page.PageBean;
import com.service.ArchiveStoresBoxService;
import com.service.mapper.ArchiveStoresBoxBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：ArchiveStoresBoxServiceImpl 类描述：留言操作业务逻辑接口实现
 */
@Service("archiveStoresBoxService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class ArchiveStoresBoxServiceImpl implements ArchiveStoresBoxService {
	@Autowired
	private ArchiveStoresBoxBeanMapper archiveStoresBoxBeanMapper;

	@Override
	public void addBean(ArchiveStoresBoxBean archiveStoresBoxBean) throws WebMessageException {
		if (archiveStoresBoxBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		archiveStoresBoxBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(archiveStoresBoxBean);
		ArchiveStoresBox archiveStoresBox = new ArchiveStoresBox();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(archiveStoresBox, archiveStoresBoxBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}

		archiveStoresBoxBeanMapper.insertSelective(archiveStoresBoxBean);
	}

	@Override
	public void updateBean(String id,ArchiveStoresBoxBean archiveStoresBoxBean) throws WebMessageException {
		if (archiveStoresBoxBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(archiveStoresBoxBean);
		ArchiveStoresBox archiveStoresBox = new ArchiveStoresBox();
		try {
			ServiceUtils.copyProperties(archiveStoresBox, archiveStoresBoxBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveStoresBoxBeanMapper.updateByPrimaryKeySelective(archiveStoresBox);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		archiveStoresBoxBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ArchiveStoresBoxBean findArchiveStoresBoxById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		ArchiveStoresBox archiveStoresBox = archiveStoresBoxBeanMapper.selectByPrimaryKey(id);
		if (archiveStoresBox != null) {
			ArchiveStoresBoxBean archiveStoresBoxBean = new ArchiveStoresBoxBean();
			try {
				ServiceUtils.copyProperties(archiveStoresBoxBean, archiveStoresBox);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return archiveStoresBoxBean;
		}
		return null;
	}

	@Override
	public List<ArchiveStoresBoxBean> findArchiveStoresBoxByBoxUser(String boxUser) throws WebMessageException {
		if (StringUtils.isEmpty(boxUser)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		return archiveStoresBoxBeanMapper.selectByBoxUser(boxUser);
	}


	@Override
	public void pageQuery(PageBean<ArchiveStoresBox> pageBean, ArchiveStoresBoxBean bean) {
		int total = archiveStoresBoxBeanMapper.selectTotal(bean);
		List<ArchiveStoresBoxBean> archiveStoresBoxBeanList = new ArrayList<ArchiveStoresBoxBean>();
		if (total > 0) {
			archiveStoresBoxBeanList = archiveStoresBoxBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(archiveStoresBoxBeanList);
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(ArchiveStoresBoxBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
