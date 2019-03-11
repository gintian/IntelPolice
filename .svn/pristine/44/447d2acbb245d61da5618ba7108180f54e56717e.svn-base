package com.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.constant.CommonConstant;
import com.model.bean.UserBean;
import com.utils.CommonValidate;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Dept;
import com.model.User;
import com.model.bean.DeptBean;
import com.page.PageBean;
import com.service.DeptService;
import com.service.mapper.DeptBeanMapper;
import com.utils.LogClass;
import com.utils.ServiceUtils;
import com.utils.SysDeptVo;

/**
 * 类名称：DeptServiceImpl 类描述：接警单操作业务逻辑接口实现
 */
@Service("deptService") // 声明是业务层的组件
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptBeanMapper deptBeanMapper;

	private static Logger log = Logger.getLogger(LogClass.class);

	@Override
	public DeptBean findDeptBeanByName(String name) {
		return deptBeanMapper.selectDeptEqName(name);
	}

	@Override
	public DeptBean findDeptBeanByDeptId(String id) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		if (id.equals("-1")){
			id = "520421000000";
		}
		Dept dept = deptBeanMapper.selectByPrimaryKey(id);
		DeptBean deptBean = new DeptBean();
		try {
			ServiceUtils.copyProperties(deptBean, dept);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		if (deptBean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_SEARCH_NONE);
		}
		return deptBean;
	}

	@Override
	public List<DeptBean> findDeptByParentId(String parentId) throws WebMessageException {
		if (parentId == null){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		if (parentId.equals("-1")){
			parentId = "0";
		}
		List<DeptBean> deptBeanList = new ArrayList<DeptBean>();
		deptBeanList = deptBeanMapper.selectDeptEqParentId(parentId);
		return deptBeanList;
	}

	@Override
	public List<DeptBean> findDeptBeanListByCurrentUser(User user) throws WebMessageException {
		if (user == null){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		List<DeptBean> deptBeanList = new ArrayList<>();
		if (StringUtils.isEmpty(user.getDeptId())){
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}
		String deptId = user.getDeptId();
		//判断当前用户是否是超级管理员
		if (user.isSuperAdmin()){
			deptBeanList = SysDeptVo.findAll();
		}else {
			if (CommonValidate.isEmpty(user.getUserType())){
				throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
			}
			if (user.getUserType().equals(CommonConstant.USER_TYPE_ADMIN)){
				//添加当前用户子部门
				deptBeanList = SysDeptVo.findByParentId(deptId);
				//添加当前用户所属部门
				deptBeanList.add(SysDeptVo.findById(deptId));

			}else if(user.getUserType().equals(CommonConstant.USER_TYPE_SYSTEM)){
				//当前用户所属部门
				deptBeanList.add(SysDeptVo.findById(deptId));
			}else if(user.getUserType().equals(CommonConstant.USER_TYPE_JINGBANYUUAN)){
				//当前用户所属部门
				deptBeanList.add(SysDeptVo.findById(deptId));
			}else {
				throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
			}
		}

		return deptBeanList;
	}

	@Override
	@Transactional
	public void addBean(DeptBean bean, UserBean currentUser) throws WebMessageException {
		if (bean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		// 当父节点为叶子节点，自动设置父节点为树枝节点
		String parentId = bean.getParentId();

		Dept parent = deptBeanMapper.selectByPrimaryKey(parentId);

		if (parent.getLeaf().equals("1")) {
			parent.setLeaf("0");
			log.debug("自动设置父节点为树枝节点");
			deptBeanMapper.updateByPrimaryKeySelective(parent);
		}
		List<DeptBean> childrens = deptBeanMapper.selectDeptEqParentId(parentId);
		bean.setId(parentId + (childrens.size() + 1));
		if (bean.getSortNo() == null) {
			bean.setSortNo("0");
			log.debug("自动设置SortNo...");
		}
		if (bean.getIsCaseUnit() == null) {
			bean.setIsCaseUnit("0");
			log.debug("自动设置IsCaseUnit...");
		}
		if (bean.getStatus() == null) {
			bean.setStatus("0");
			log.debug("自动设置enable...");
		}
		if (bean.getLeaf() == null) {
			bean.setLeaf("1");
			log.debug("自动设置leaf...");
		}
		validateBean(bean);
		Dept dept = new Dept();
		try {
			BeanUtils.copyProperties(dept, bean);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
		deptBeanMapper.insertSelective(dept);
	}

	/*
	 * 校验 bean 对象
	 */
	private void validateBean(DeptBean bean) throws WebMessageException {
		if (bean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		if (StringUtils.isEmpty(bean.getName())) {
			throw new WebMessageException(WebExceptionConstant.NAME_IS_NONE);
		}
	}

	@Override
	@Transactional
	public void updateBean(String id, DeptBean bean, UserBean currentUser) throws WebMessageException {
		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		if (bean == null) {
			throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
		}
		//校验，是否有权访问此部门
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, bean.getId())){
			System.out.println(WebExceptionConstant.SYSTEM_ILLEGAL_ACCESS);
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		// 校验bean
		validateBean(bean);
		Dept dept = new Dept();
		ServiceUtils.copyProperties(dept, bean);
		deptBeanMapper.updateByPrimaryKeySelective(dept);
	}

	@Override
	@Transactional
	public void deleteBean(String id, UserBean currentUser) throws WebMessageException {

		//校验，是否有权访问此部门
		if (!ServiceUtils.hasPermissionAccessDept(currentUser, id)){
			System.out.println(WebExceptionConstant.SYSTEM_ILLEGAL_ACCESS);
			throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
		}

		if (StringUtils.isEmpty(id)) {
			throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
		}
		deptBeanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void pageQuery(PageBean<DeptBean> pageBean, DeptBean bean, UserBean currentUser) throws WebMessageException {
		List<DeptBean> deptBeanList = new ArrayList<DeptBean>();

		int total = deptBeanMapper.countTotal(bean, currentUser);

		if (total>0) {
			deptBeanList = deptBeanMapper.selectBeanPage(bean, pageBean, currentUser);
		}
		pageBean.setTotal(total);
		pageBean.setRows(deptBeanList);
	}

	

	@Override
	public List<DeptBean> findBeanAll() throws WebMessageException {
		List<DeptBean> deptBeanList = deptBeanMapper.selectAll();
		return deptBeanList;
	}

	@Override
	public void cacheDeptAll() throws WebMessageException{
		List<DeptBean> depts = deptBeanMapper.selectAll();
		SysDeptVo.setSysDeptBeanList(depts);
		System.out.println("部门缓存成功！");
	}
}
