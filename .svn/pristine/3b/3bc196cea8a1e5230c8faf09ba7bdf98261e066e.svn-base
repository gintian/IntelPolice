package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Notice;
import com.model.Notice;
import com.model.bean.NoticeBean;
import com.page.PageBean;
import com.service.NoticeService;
import com.service.mapper.NoticeBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：NoticeServiceImpl 类描述：公告操作业务逻辑接口实现
 */
@Service("noticeService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class NoticeServiceImpl   implements NoticeService {
	@Autowired
	private NoticeBeanMapper noticeBeanMapper;

	@Override
	public void addBean(NoticeBean noticeBean) throws WebMessageException {
		if (noticeBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 添加主键值,, 临时使用uuid,截取20 位
		noticeBean.setId(ServiceUtils.generatePrimaryKey());
		// 校验Bean
		validateBean(noticeBean);
		Notice notice = new Notice();
		// 复制Bean 到model
		try {
			ServiceUtils.copyProperties(notice, noticeBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		noticeBeanMapper.insertSelective(noticeBean);
	}

	@Override
	public void updateBean(String id,NoticeBean noticeBean) throws WebMessageException {
		if (noticeBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 校验bean
		validateBean(noticeBean);
		Notice notice = new Notice();
		try {
			ServiceUtils.copyProperties(notice, noticeBean);
		} catch (Exception e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		noticeBeanMapper.updateByPrimaryKeySelective(notice);
	}

	@Override
	public void deleteBean(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		noticeBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public NoticeBean findNoticeById(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		// 查询对象
		Notice notice = noticeBeanMapper.selectByPrimaryKey(id);
		if (notice != null) {
			NoticeBean noticeBean = new NoticeBean();
			try {
				ServiceUtils.copyProperties(noticeBean, notice);
			} catch (Exception e) {
				throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
			}
			return noticeBean;
		}
		return null;
	}

	@Override
	public NoticeBean findNoticeIndex()
			throws WebMessageException
	{
		NoticeBean noticeBean = this.noticeBeanMapper.selectBeanIndex();
		if (noticeBean != null) {
			return noticeBean;
		}
		return null;
	}

	@Override
	public void setLookAble(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		Notice notice = noticeBeanMapper.selectByPrimaryKey(id);
		String status = notice.getStatus();
		if (status.equals("0")){
			notice.setStatus("1");
			noticeBeanMapper.updateByPrimaryKeySelective(notice);
		}else{
			notice.setStatus("0");
			noticeBeanMapper.updateByPrimaryKeySelective(notice);
		}
	}

	@Override
	public void setTop(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		Notice notice = noticeBeanMapper.selectByPrimaryKey(id);
		String status = notice.getStatus();
		if (status.equals("2")){
			notice.setStatus("1");
			noticeBeanMapper.updateByPrimaryKeySelective(notice);
		}else{
			notice.setStatus("2");
			noticeBeanMapper.updateByPrimaryKeySelective(notice);
		}
	}

	@Override
	public void pageQuery(PageBean<Notice> pageBean, NoticeBean bean) {
		int total = noticeBeanMapper.selectTotal(bean);
		List<NoticeBean> noticeBeanList = new ArrayList<NoticeBean>();
		if (total > 0) {
			noticeBeanList = noticeBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(noticeBeanList);
	}

	@Override
	public void pageQueryList(PageBean<Notice> pageBean, NoticeBean bean) {
		bean.setxStatus("1");
		int total = noticeBeanMapper.selectTotal(bean);
		List<NoticeBean> noticeBeanList = new ArrayList<NoticeBean>();
		if (total > 0) {
			noticeBeanList = noticeBeanMapper.selectData(bean, pageBean);
		}
		pageBean.setTotal(total);
		pageBean.setRows(noticeBeanList);
	}

	/**
	 * 校验 bean 对象
	 *
	 * @param bean
	 * @throws Exception
	 *             校验异常
	 */
	private void validateBean(NoticeBean bean) throws WebMessageException {
		if (StringUtils.isEmpty(bean.getId())) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
	}
}
