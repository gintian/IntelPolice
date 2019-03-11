package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.CMD;
import com.model.bean.CMDBean;
import com.page.PageBean;
import com.service.CMDService;
import com.service.mapper.CMDBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：CMDServiceImpl 类描述：110指令操作业务逻辑接口实现
 */
@Service("cmdService") // 声明是业务层的组件
public class CMDServiceImpl implements CMDService {
	@Autowired
	private CMDBeanMapper cmdBeanMapper;

	@Override
	public void addBean(CMDBean cmdBean) throws WebMessageException {
		if (cmdBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验Bean
		validateBean(cmdBean);
		// 添加主键值,, 临时使用uuid,截取20 位
		cmdBean.setId(ServiceUtils.generatePrimaryKey());
		CMD cmd = new CMD();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(cmd, cmdBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		cmdBeanMapper.insertSelective(cmdBean);
	}

	@Override
	public void updateBean(String id,CMDBean cmdBean) throws WebMessageException {
		if (cmdBean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验bean
		validateBean(cmdBean);
		CMD cmd = new CMD();
		try {
			ServiceUtils.copyProperties(cmd, cmdBean);
		}catch (Exception e){
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		cmdBeanMapper.updateByPrimaryKeySelective(cmd);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		cmdBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public CMDBean findCMDById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		//查询对象
		CMDBean cmdBean= cmdBeanMapper.selectBeanEqId(id);
		if (cmdBean != null){
			return cmdBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<CMD> pageBean, CMDBean bean) {
		int total = cmdBeanMapper.selectTotal(bean);
		List<CMDBean> cmdBeanList = new ArrayList<CMDBean>();
		if (total>0) {
			cmdBeanList = cmdBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(cmdBeanList);
	}
	
	/**
	 *  校验  bean 对象
	 * @param cmdBean
	 * @throws Exception    校验异常
	 */
	private void validateBean(CMDBean cmdBean) throws WebMessageException{
		if (StringUtils.isEmpty(cmdBean.getId())){
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}

}
