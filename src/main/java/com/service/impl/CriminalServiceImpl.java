package com.service.impl;

import com.constant.CommonConstant;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Criminal;
import com.model.bean.CaseStatusBean;
import com.model.bean.CriminalBean;
import com.page.PageBean;
import com.service.CaseStatusService;
import com.service.CriminalService;
import com.service.mapper.CriminalBeanMapper;
import com.utils.CommonValidate;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：CriminalServiceImpl 类描述：案事件操作业务逻辑接口实现
 */
@Service("criminalService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class CriminalServiceImpl implements CriminalService {
    @Autowired
    private CriminalBeanMapper criminalBeanMapper;
    @Autowired
    private CaseStatusService caseStatusService;

    @Override
    public void addBean(CriminalBean criminalBean) throws WebMessageException {
        if (criminalBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        criminalBean.setCaseid(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(criminalBean);
        Criminal cj = new Criminal();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(cj, criminalBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        criminalBeanMapper.insertSelective(criminalBean);
    }

    @Override
    public void updateBean(String caseId, CriminalBean criminalBean) throws WebMessageException {
        if (criminalBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(criminalBean);
        Criminal cj = new Criminal();
        try {
            ServiceUtils.copyProperties(cj, criminalBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        criminalBeanMapper.updateByPrimaryKeySelective(cj);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        criminalBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CriminalBean findCriminalById(String caseId) throws WebMessageException {
        if (StringUtils.isEmpty(caseId)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        Criminal cj = criminalBeanMapper.selectByPrimaryKey(caseId);
        if (cj != null) {
            CriminalBean criminalBean = new CriminalBean();
            try {
                ServiceUtils.copyProperties(criminalBean, cj);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return criminalBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<Criminal> pageBean, CriminalBean bean) {
        int total = criminalBeanMapper.selectTotal(bean);
        List<CriminalBean> criminalBeanList = new ArrayList<CriminalBean>();
        if (total > 0) {
            criminalBeanList = criminalBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(criminalBeanList);
    }

    /**
     * 校验  bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(CriminalBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getCaseid())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }

    /**
     * 各个模块查询案件信息的公共方法
     *
     * @param pageBean
     * @param bean
     * @param moduleFunction 模块功能,如"未录入笔录的案件"
     * @throws WebMessageException
     */
    public void findBeanPageForModule(PageBean<Criminal> pageBean, CriminalBean bean, String moduleFunction) throws WebMessageException {
        try {
            int total = criminalBeanMapper.findBeanPageForModuleTotal(bean, moduleFunction);
            List<CriminalBean> criminalBeanList = new ArrayList<CriminalBean>();
            if (total > 0) {
                criminalBeanList = criminalBeanMapper.findBeanPageForModule(pageBean, bean, moduleFunction);
            }
            pageBean.setTotal(total);
            pageBean.setRows(criminalBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findBeanPageForCaseStatus(PageBean<Criminal> pageBean, CriminalBean bean, CaseStatusBean caseStatusBean) throws WebMessageException {
        int total = criminalBeanMapper.findBeanPageForForCaseStatusTotal(bean, caseStatusBean);
        List<CriminalBean> criminalBeanList = new ArrayList<CriminalBean>();
        if (total > 0) {
            criminalBeanList = criminalBeanMapper.findBeanPageForCaseStatus(pageBean, bean, caseStatusBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(criminalBeanList);
    }

    @Override
    public List<CriminalBean> findDataAllByBoxId(String boxId) {
        List<CriminalBean> list = null;
        try {
            list = criminalBeanMapper.selectDataAllEqBoxId(boxId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    ;

    @Override
    public List<CriminalBean> findDataAllByInvolvedBoxId(String boxId) {
        List<CriminalBean> list = null;
        try {
            list = criminalBeanMapper.selectDataAllEqInvolvedBoxId(boxId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CriminalBean findDataByOrganizerId(String OrganizerId) {
        return criminalBeanMapper.selectByOrganizerId(OrganizerId);
    }

    @Override
    public void sync(String caseId) throws WebMessageException {
        if (CommonValidate.isEmpty(caseId)) {
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        caseStatusService.updateCaseStatus(caseId, "involvedsyncstatus", CommonConstant.CASE_REQUIRE_SYNCHRONIZE);
    }

    @Override
    public void noRequireSync(String caseId) throws WebMessageException {
        if (CommonValidate.isEmpty(caseId)) {
            throw new WebMessageException(WebExceptionConstant.SYSTEM_ERROR);
        }
        caseStatusService.updateCaseStatus(caseId, "involvedsyncstatus", CommonConstant.CASE_NO_REQUIRE_SYNCHRONIZE);
    }

    @Override
    public void pageSmsLogQuery(PageBean<Criminal> pageBean, CriminalBean bean, String stuts) {
        int total = criminalBeanMapper.selectSmsNotFsTotal(bean, stuts);
        List<CriminalBean> criminalBeanList = new ArrayList<CriminalBean>();
        if (total > 0) {
            criminalBeanList = criminalBeanMapper.selectSmsNotFsData(bean, pageBean, stuts);
        }
        pageBean.setTotal(total);
        pageBean.setRows(criminalBeanList);
    }

    @Override
    public void pageNotjcjQuery(PageBean<Criminal> pageBean, CriminalBean bean) {
        int total = criminalBeanMapper.selectNotjcjTotal(bean);
        List<CriminalBean> criminalBeanList = new ArrayList<CriminalBean>();
        if (total > 0) {
            criminalBeanList = criminalBeanMapper.selectNotjcjData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(criminalBeanList);
    }

    @Override
    public void pageZjslQuery(PageBean<Criminal> pageBean, CriminalBean bean) {
        try {
            int total = criminalBeanMapper.selectZjslTotal(bean);
            List<CriminalBean> criminalBeanList = new ArrayList<CriminalBean>();
            if (total > 0) {
                criminalBeanList = criminalBeanMapper.selectZjslData(bean, pageBean);
            }
            pageBean.setTotal(total);
            pageBean.setRows(criminalBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public CriminalBean findCriminalByJJId(String caseid) throws WebMessageException {
        if (StringUtils.isEmpty(caseid)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        Criminal cj = criminalBeanMapper.selectCriminalBeanByjjdbh(caseid);
        if (cj != null) {
            CriminalBean criminalBean = new CriminalBean();
            try {
                ServiceUtils.copyProperties(criminalBean, cj);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return criminalBean;
        }
        return null;
    }

    @Override
    public void pageQueryNotView(PageBean<Criminal> pageBean, Criminal bean) {

        int total = criminalBeanMapper.selectNotViewTotal();
        List<Criminal> list = criminalBeanMapper.selectNotView(pageBean, bean);
        pageBean.setTotal(total);
        pageBean.setRows(list);

    }

    @Override
    public void pageQueryCorrelateView(PageBean<Criminal> pageBean, Criminal bean) {

        int total = criminalBeanMapper.selectCorrelateViewTotal();
        List<Criminal> list = criminalBeanMapper.selectCorrelateView(pageBean, bean);

        pageBean.setTotal(total);
        pageBean.setRows(list);

    }

}