package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.ArchiveCase;
import com.model.bean.ArchiveCaseBean;
import com.page.PageBean;
import com.service.ArchiveCaseService;
import com.service.mapper.ArchiveCaseBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：ArchiveCaseServiceImpl 类描述：留言操作业务逻辑接口实现
 */
@Service("archiveCaseService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class ArchiveCaseServiceImpl implements ArchiveCaseService {
	@Autowired
	private ArchiveCaseBeanMapper archiveCaseBeanMapper;

	@Override
	public void addBean(ArchiveCaseBean archiveCaseBean) throws WebMessageException {
		if (archiveCaseBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		archiveCaseBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(archiveCaseBean);
		ArchiveCase archiveCase = new ArchiveCase();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(archiveCase, archiveCaseBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		archiveCaseBeanMapper.insertSelective(archiveCaseBean);
	}

	@Override
	public void updateBean(String id,ArchiveCaseBean archiveCaseBean) throws WebMessageException {
		if (archiveCaseBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(archiveCaseBean);
		ArchiveCase archiveCase = new ArchiveCase();
		try {
			ServiceUtils.copyProperties(archiveCase, archiveCaseBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
        try {
            archiveCaseBeanMapper.updateByPrimaryKeySelective(archiveCase);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		archiveCaseBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteArchiveBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		archiveCaseBeanMapper.deleteByArchiveKey(id);
	}

	@Override
	public ArchiveCaseBean findArchiveCaseById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		ArchiveCase archiveCase = archiveCaseBeanMapper.selectByPrimaryKey(id);
		if (archiveCase != null) {
			ArchiveCaseBean archiveCaseBean = new ArchiveCaseBean();
			try {
				ServiceUtils.copyProperties(archiveCaseBean, archiveCase);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return archiveCaseBean;
		}
		return null;
	}

	@Override
	public void pageQuery(PageBean<ArchiveCase> pageBean, ArchiveCaseBean bean) {
		int total = 0;
		try{
			total = archiveCaseBeanMapper.selectTotal(bean);
		}catch (Exception e){
			e.printStackTrace();
		}

		List<ArchiveCaseBean> archiveCaseBeanList = new ArrayList<ArchiveCaseBean>();
		if (total > 0) {
			archiveCaseBeanList = archiveCaseBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(archiveCaseBeanList);
	}

	@Override
	public ArchiveCaseBean findArchiveCaseByArchiveId(String boxUserId){
		try{
			return archiveCaseBeanMapper.selectByArchiveId(boxUserId);
		}catch (Exception e){e.printStackTrace();}

		return null;
	}

	@Override
	public void updateByArchiveIdByCaseId(ArchiveCaseBean bean) {
		try{
			archiveCaseBeanMapper.updateByArchiveIdByCaseId(bean);
		}catch (Exception e){e.printStackTrace();}

	}

	@Override
	public List<ArchiveCaseBean> selectDataByBoxId(String boxId) {
		List<ArchiveCaseBean> list = null;
		try{
			list =	archiveCaseBeanMapper.selectDataByBoxId(boxId);
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 校验 bean 对象
	 * 
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(ArchiveCaseBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
