package com.service.impl;

import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Permission;
import com.model.bean.PermissionBean;
import com.page.PageBean;
import com.service.PermissionService;
import com.service.mapper.PermissionBeanMapper;
import com.utils.ServiceUtils;

@Service()
public class PermissionServiceImpl  implements PermissionService {
	@Autowired
	private PermissionBeanMapper permissionBeanMapper;

	@Override
	@Transactional
	public void addBean(PermissionBean bean) throws WebMessageException {
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//设置状态为1启用状态
		bean.setStatus("1");
		bean.setId(ServiceUtils.generatePrimaryKey());
		//校验Bean
		validateBean(bean);

		Permission Permission = new Permission();
		
		//复制Bean 到model
		try {
			BeanUtils.copyProperties(Permission, bean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
	
		permissionBeanMapper.insert(Permission);
	}
	
	/**
	 *  校验  bean 对象
	 * @param bean  			[必填]		bean对象
	 * @throws Exception    校验异常
	 */
	private void validateBean(PermissionBean bean) throws WebMessageException{
		if (StringUtils.isEmpty(bean.getName())){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_NAME_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getChangeInd())){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_IS_CHANGEIND);
		}
		if (StringUtils.isEmpty(bean.getStatus())){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_STATUS_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getUrl())){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_URL_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getId())){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_ID_IS_NONE);
		}
	}

	@Override
	@Transactional
	public void updateBean(String id, PermissionBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_ID_IS_NONE);
		}
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验bean
		validateBean(bean);
		Permission Permission = new Permission();
		try {
			BeanUtils.copyProperties(Permission, bean);
		}catch (Exception e){
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		
		permissionBeanMapper.updateByPrimaryKeySelective(Permission);
	}

	@Override
	@Transactional
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_ID_IS_NONE);
		}
		permissionBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PermissionBean findPermissionById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_ID_IS_NONE);
		}
		//查询对象
		Permission Permission = permissionBeanMapper.selectByPrimaryKey(id);
		if (Permission != null){
			PermissionBean PermissionBean = new PermissionBean();
			try {
				BeanUtils.copyProperties(PermissionBean, Permission);
			}catch (Exception e){
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return PermissionBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<PermissionBean> pageBean, PermissionBean bean, String userId) throws WebMessageException {
		int total = permissionBeanMapper.countTotal(bean);
		List<PermissionBean> list = permissionBeanMapper.selectBeanPage(bean, pageBean);
		pageBean.setTotal(total);
		pageBean.setRows(list);
	}

	@Override
	public List<PermissionBean> findAllPermissionBean() throws WebMessageException {
		List<PermissionBean> permissionBeanList = permissionBeanMapper.findAll();
		return permissionBeanList;
	}
}
