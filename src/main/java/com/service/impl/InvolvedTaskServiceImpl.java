package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.InvolvedTask;
import com.model.bean.InvolvedTaskBean;
import com.page.PageBean;
import com.service.InvolvedTaskService;
import com.service.mapper.InvolvedTaskBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：InvolvedInfosServiceImpl 类描述：涉案财物信息表操作业务逻辑接口实现
 */
@Service // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class InvolvedTaskServiceImpl implements InvolvedTaskService {
	@Autowired
	private InvolvedTaskBeanMapper involvedTaskBeanMapper;

	@Override
	public void addBean(InvolvedTaskBean involvedTaskBean) throws WebMessageException {
		if (involvedTaskBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		involvedTaskBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(involvedTaskBean);
		InvolvedTask involvedTask = new InvolvedTask();
		// 复制Bean 到model
		try {
			BeanUtils.copyProperties(involvedTask, involvedTaskBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedTaskBeanMapper.insertSelective(involvedTaskBean);
	}

	@Override
	public void updateBean(InvolvedTaskBean involvedTaskBean) throws WebMessageException {
		if (involvedTaskBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(involvedTaskBean);
		InvolvedTask involved = new InvolvedTask();
		try {
			BeanUtils.copyProperties(involved, involvedTaskBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		involvedTaskBeanMapper.updateByPrimaryKeySelective(involved);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		involvedTaskBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InvolvedTaskBean findInvolvedTaskById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		InvolvedTask involvedTask = involvedTaskBeanMapper.selectByPrimaryKey(id);
		if (involvedTask != null) {
			InvolvedTaskBean involvedTaskBean = new InvolvedTaskBean();
			try {
				BeanUtils.copyProperties(involvedTaskBean, involvedTask);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return involvedTaskBean;
		}
		return null;
	}

	@Override
	public InvolvedTaskBean findInvolvedTaskByProcessInstanceId(String processDefinitionId) {
//		if (StringUtils.isEmpty(processDefinitionId)) {
//			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
//		}
		// 查询对象
		InvolvedTask involvedTask = involvedTaskBeanMapper.selectByProcessDefinitionId(processDefinitionId);
		if (involvedTask != null) {
			InvolvedTaskBean involvedTaskBean = new InvolvedTaskBean();
			try {
				BeanUtils.copyProperties(involvedTaskBean, involvedTask);
			} catch (Exception e) {
//				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return involvedTaskBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<InvolvedTask> pageBean, InvolvedTaskBean bean) {
		int total = involvedTaskBeanMapper.selectTotal(bean);
		List<InvolvedTaskBean> involvedTaskBeanList = new ArrayList<InvolvedTaskBean>();
		if (total > 0) {
			involvedTaskBeanList = involvedTaskBeanMapper.selectBeanPage(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(involvedTaskBeanList);
	}

	/* 根据身份证号查找我的工作流任务*/
	@Override
	public List<InvolvedTaskBean> findInvolvedTaskByIdentityCard(String identityCard) throws WebMessageException {
		if (StringUtils.isEmpty(identityCard)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		List<InvolvedTask> involvedTask = involvedTaskBeanMapper.findInvolvedTaskByIdentityCard(identityCard);
		if (involvedTask != null) {
			List<InvolvedTaskBean> involvedTaskBean = new ArrayList();
			try {
				BeanUtils.copyProperties(involvedTaskBean, involvedTask);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return involvedTaskBean;
		}
		return null;
	}

	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(InvolvedTaskBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
