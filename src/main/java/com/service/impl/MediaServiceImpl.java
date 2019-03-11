package com.service.impl;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Media;
import com.model.bean.MediaBean;
import com.page.PageBean;
import com.service.MediaService;
import com.service.mapper.MediaBeanMapper;
import com.utils.ServiceUtils;

@Service
public class MediaServiceImpl implements MediaService{
	@Autowired
	private MediaBeanMapper mediaBeanMapper;

	@Override
	public void addBean(MediaBean bean) throws WebMessageException {
		// TODO Auto-generated method stub
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验Bean
		validateBean(bean);
		//校验名称是否相同
		MediaBean mediaForQueryByNmae =  mediaBeanMapper.selectBeanEqName(bean.getName());
		if (mediaForQueryByNmae != null){
			throw new WebMessageException(WebExceptionConstant.USER_ACCOUNT_IS_EXIST);
		}

		//添加主键值,, 临时使用uuid,截取20 位
		//TODO 添加主键值,, 临时使用uuid,截取20 位
		bean.setId(ServiceUtils.generatePrimaryKey());
		
		Media media = new Media();
		
		//复制Bean 到model
		try {
			BeanUtils.copyProperties(media, bean);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(WebExceptionConstant.PARAMES_COPY_ERROR);
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		mediaBeanMapper.insert(media);
	}
	
	/**
	 *  校验  bean 对象
	 * @param bean  
	 * @throws Exception    校验异常
	 */
	private void validateBean(MediaBean bean) throws WebMessageException{
		if (StringUtils.isEmpty(bean.getName())){
			throw new WebMessageException(WebExceptionConstant.MEDIA_NAME_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getTjrbh())){
			throw new WebMessageException(WebExceptionConstant.MEDIA_TJRBH_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getJldd())){
			throw new WebMessageException(WebExceptionConstant.MEDIA_JLDD_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getJlddzb())){
			throw new WebMessageException(WebExceptionConstant.MEDIA_JLDDZB_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getTjrbh())){
			throw new WebMessageException(WebExceptionConstant.MEDIA_TJRBH_IS_NONE);
		}
		
		if (StringUtils.isEmpty(bean.getTjrxm())){
			throw new WebMessageException(WebExceptionConstant.MEDIA_TJRXM_IS_NONE);
		}
		if (bean.getDqsj() == null){
			throw new WebMessageException(WebExceptionConstant.MEDIA_DQSJ_IS_NONE);
		}
		if (bean.getJlsj() == null){
			throw new WebMessageException(WebExceptionConstant.MEDIA_JLSJ_IS_NONE);
		}
	}

	@Override
	@Transactional
	public void updateBean(String id, MediaBean bean) throws WebMessageException {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.MEDIA_ID_IS_NONE);
		}
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验bean
		validateBean(bean);
		//校验名称是否相同
	/*	Media mediaForQueryByNmae =  mediaBeanMapper.getModelByMediaName(bean.getMediaName());
		if (mediaForQueryByNmae != null){
			//查询到的对象不是当前对象，抛出异常
			if (! mediaForQueryByNmae.getMediaId().equals(id)){
				throw new WebMessageException(WebExceptionConstant.MEDIA_NAME_IS_EQUAL);
			}
		}*/

		Media media = new Media();
		try {
			BeanUtils.copyProperties(media, bean);
		}catch (Exception e){
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		
		mediaBeanMapper.updateByPrimaryKeySelective(media);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.MEDIA_ID_IS_NONE);
		}
		mediaBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MediaBean findMediaById(String id) throws WebMessageException {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.MEDIA_ID_IS_NONE);
		}
		//查询对象
		Media media = mediaBeanMapper.selectByPrimaryKey(id);
		if (media != null){
			MediaBean mediaBean = new MediaBean();
			try {
				BeanUtils.copyProperties(mediaBean, media);
			}catch (Exception e){
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return mediaBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<MediaBean> pageBean, MediaBean bean, String userId) {
		int total = mediaBeanMapper.countTotal(bean);
		List<MediaBean> mediaBeanList = mediaBeanMapper.selectBeanPage(bean, pageBean);

		pageBean.setTotal(total);
		pageBean.setRows(mediaBeanList);
	}
}
