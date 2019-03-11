package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.MediaFiles;
import com.model.bean.MediaFilesBean;
import com.page.PageBean;
import com.service.MediaFilesService;
import com.service.mapper.MediaFileBeanMapper;
import com.utils.ServiceUtils;

@Service
public class MediaFilesServiceImpl implements MediaFilesService{

	@Autowired
	private MediaFileBeanMapper mediaFileBeanMapper;
	
	@Override
	public String getAllListBean(){
		List<MediaFilesBean> list = mediaFileBeanMapper.findAll();
		if (list == null || list.size() == 0){
			return "";
		}
		JSONArray jsonarray = new JSONArray(new ArrayList(list));
		return jsonarray.toJSONString();
	}

	@Override
	@Transactional
	public void addBean(MediaFilesBean bean) throws Exception {
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		bean.setId(UUID.randomUUID().toString().substring(0, 20));
		//校验Bean
		validateBean(bean);
		MediaFiles model = new MediaFiles();
		//复制Bean 到model
		BeanUtils.copyProperties(model, bean);
		mediaFileBeanMapper.insert(model);
	}
	
	/**
	 *  校验  bean 对象
	 * @param bean  
	 * @throws Exception    校验异常
	 */
	private void validateBean(MediaFilesBean bean) throws Exception{
		if (StringUtils.isEmpty(bean.getFilePath())){
			throw new WebMessageException(WebExceptionConstant.MEDIAFILES_FILEPATH_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getFileSize())){
			throw new WebMessageException(WebExceptionConstant.MEDIAFILES_FILESIZE_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getFileType())){
			throw new WebMessageException(WebExceptionConstant.MEDIAFILES_FILETYP_IS_NONE);
		}
		if (StringUtils.isEmpty(bean.getMediaId())){
			throw new WebMessageException(WebExceptionConstant.MEDIAFILES_MEDIAID_IS_NONE);
		}
	}

	@Override
	@Transactional
	public void updateBean(String id, MediaFilesBean bean) throws Exception {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.MEDIAFILES_ID_IS_NONE);
		}
		if (bean == null){
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验bean
		validateBean(bean);
		MediaFiles model = new MediaFiles();
		BeanUtils.copyProperties(model, bean);
		mediaFileBeanMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	@Transactional
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.MEDIA_ID_IS_NONE);
		}
		mediaFileBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MediaFilesBean findMenuById(String id) throws Exception {
		if (StringUtils.isEmpty(id)){
			throw new WebMessageException(WebExceptionConstant.MEDIA_ID_IS_NONE);
		}
		//查询对象
		MediaFiles media = mediaFileBeanMapper.selectByPrimaryKey(id);
		if (media != null){
			MediaFilesBean MediaFilesBean = new MediaFilesBean();
			BeanUtils.copyProperties(MediaFilesBean, media);
			return MediaFilesBean;
		}
		return null;
	}

	@Override
	@Transactional
	public void addBeanByMediaId(String mediaId, String filePath) throws WebMessageException {
		if (StringUtils.isEmpty(mediaId) || StringUtils.isEmpty(filePath)){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		MediaFiles mediaFiles = new MediaFiles();
		String[] contents =  filePath.split(CommonConstant.FILE_UPLOAD_REGEX);
		mediaFiles.setFilePath(contents[0]);
		mediaFiles.setFileSize(contents[1]);
		mediaFiles.setFileType(contents[0].substring(contents[0].lastIndexOf("."), contents[0].length()));

		mediaFiles.setId(ServiceUtils.generatePrimaryKey());
		mediaFiles.setMediaId(mediaId);
		mediaFileBeanMapper.insert(mediaFiles);
	}

	@Override
	public void pageQuery(PageBean<MediaFilesBean> pageBean, MediaFilesBean bean, String userId) {
		int total = mediaFileBeanMapper.countTotal(bean);
		List<MediaFilesBean> list = mediaFileBeanMapper.selectBeanPage(bean, pageBean);
		pageBean.setTotal(total);
		pageBean.setRows(list);
	}
}
