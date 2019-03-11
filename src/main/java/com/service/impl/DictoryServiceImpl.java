package com.service.impl;

import java.util.List;

import com.exception.WebMessageException;
import com.utils.CommonValidate;
import com.utils.ServiceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constant.Indicator;
import com.constant.WebExceptionConstant;
import com.model.Dictory;
import com.model.bean.DictoryBean;
import com.page.PageBean;
import com.service.DictoryService;
import com.service.mapper.DictoryBeanMapper;
import com.utils.SysDictoryVo;

@Service()
public class DictoryServiceImpl implements DictoryService{
	@Autowired
	private DictoryBeanMapper dictoryBeanMapper;
	@Override
	public DictoryBean findDictoryById(String id) throws WebMessageException {
		Dictory model = dictoryBeanMapper.selectByPrimaryKey(id);
		DictoryBean dictoryBean = new DictoryBean();
		try {
			BeanUtils.copyProperties(dictoryBean, model);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		return dictoryBean;
	}

	@Override
	public void doCacheForDictroy() {
		SysDictoryVo.clearCache();
		try {
			//用户类型
			List<DictoryBean> user_dicts =  findDictoryByType(Indicator.USER_TYPE.getCode());
			SysDictoryVo.addDictoryBeanList(Integer.valueOf(Indicator.USER_TYPE.getCode()), user_dicts);

			//权限类型
			List<DictoryBean> permission_dicts =  findDictoryByType(Indicator.PERMISSION_TYPE.getCode());
			SysDictoryVo.addDictoryBeanList(Integer.valueOf(Indicator.PERMISSION_TYPE.getCode()), permission_dicts);

			System.out.println("字典缓存成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("字典缓存失败");
		}
	}
	/**
	 *  校验  bean 对象
	 * @param bean  			[必填]		bean对象
	 * @throws Exception    校验异常
	 */
	private void validateBean(DictoryBean bean) throws WebMessageException{
		if (StringUtils.isEmpty(bean.getLabel())){
			throw new WebMessageException(WebExceptionConstant.DICTORY_LABEL_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getChangeInd())){
			throw new WebMessageException(WebExceptionConstant.DICTORY_IS_CHANGEIND);
		}
		if (StringUtils.isEmpty(bean.getType())){
			throw new WebMessageException(WebExceptionConstant.DICTORY_TYPE_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getId())){
			throw new WebMessageException(WebExceptionConstant.DICTORY_ID_IS_NONE);
		}
		if (CommonValidate.isEmpty(bean.getParentId())){
			throw new WebMessageException(WebExceptionConstant.DICTORY_PARENTID_IS_NONE);
		}
	}
	@Override
	public void addBean(DictoryBean bean) throws WebMessageException {
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		if (!CommonValidate.isEmpty(bean.getParentId())){
			//根据parentId 查询条数
			Integer count = dictoryBeanMapper.selectCountByParentId(bean.getParentId());
			//生成id
			bean.setId(bean.getParentId() + "-" + (count+1));
		}else {
			if (CommonValidate.isEmpty(bean.getId())) {
				bean.setId(ServiceUtils.generatePrimaryKey());
			}
		}
		//校验Bean
		validateBean(bean);

		Dictory dictory = new Dictory();

		//复制Bean 到model
		try {
			BeanUtils.copyProperties(dictory, bean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}

		dictoryBeanMapper.insert(dictory);
	}

	@Override
	public void updateBean(String id,DictoryBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.PERMISSION_ID_IS_NONE);
		}
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验bean
		validateBean(bean);
		Dictory model = new Dictory();
		try {
			BeanUtils.copyProperties(model, bean);
		}catch (Exception e){
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}

		dictoryBeanMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.DICTORY_ID_IS_NONE);
		}
		dictoryBeanMapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<DictoryBean> findDictoryByType(String type) {
		List<DictoryBean> list = dictoryBeanMapper.findBeanByType(type);
		if (list.isEmpty()){
			return null;
		}
		return list;
	}

	@Override
	public void pageQuery(PageBean<DictoryBean> pageBean, DictoryBean bean, String userId) {
		int total = dictoryBeanMapper.countTotal(bean);
		List<DictoryBean> list = dictoryBeanMapper.selectBeanPage(bean, pageBean);
		pageBean.setTotal(total);
		pageBean.setRows(list);
	}
}
