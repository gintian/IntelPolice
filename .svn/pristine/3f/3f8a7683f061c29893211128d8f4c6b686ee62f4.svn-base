package com.service;

import com.exception.WebMessageException;
import com.model.Criminal;
import com.model.bean.CaseStatusBean;
import com.model.bean.CriminalBean;
import com.page.PageBean;

import java.util.List;

/**
 * 类名称：CriminalService 类描述：案事件逻辑接口
 */
public interface CriminalService {
    //添加
    void addBean(CriminalBean criminalBean) throws WebMessageException;

    //修改
    void updateBean(String caseId, CriminalBean criminalBean) throws WebMessageException;

    //删除
    void deleteBean(String caseId) throws WebMessageException;

    /**
     * 通过Id查询Bean
     */
    CriminalBean findCriminalById(String caseid) throws WebMessageException;

    /**
     * 条件查询：分页条件
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageQuery(PageBean<Criminal> pageBean, CriminalBean bean);

    /**
     * @param pageBean
     * @param bean
     * @param moduleFunction 模块功能,如"未录入笔录的案件"
     * @throws WebMessageException
     */
    void findBeanPageForModule(PageBean<Criminal> pageBean, CriminalBean bean, String moduleFunction) throws WebMessageException;


    void findBeanPageForCaseStatus(PageBean<Criminal> pageBean, CriminalBean bean, CaseStatusBean caseStatusBean) throws WebMessageException;

    List<CriminalBean> findDataAllByBoxId(String boxId);

    List<CriminalBean> findDataAllByInvolvedBoxId(String boxId);

    CriminalBean findDataByOrganizerId(String OrganizerId);


    /**
     * 需要同步财物
     *
     * @param caseId [必填]			案件信息
     * @throws WebMessageException
     */
    void sync(String caseId) throws WebMessageException;

    /**
     * 无需同步财物
     *
     * @param caseId [必填]			案件信息
     * @throws WebMessageException
     */
    void noRequireSync(String caseId) throws WebMessageException;

    /**
     * 条件查询：分页条件
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageSmsLogQuery(PageBean<Criminal> pageBean, CriminalBean bean, String stuts);

    /**
     * 条件查询：分页条件（无接处警异常)
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageNotjcjQuery(PageBean<Criminal> pageBean, CriminalBean bean);

    /**
     * 条件查询：分页条件(直接受理)
     *
     * @param pageBean
     * @param bean
     * @return
     */
    void pageZjslQuery(PageBean<Criminal> pageBean, CriminalBean bean);

    /**
     * 通过Id查询Bean
     */
    CriminalBean findCriminalByJJId(String caseid) throws WebMessageException;

    //查未关联录音
    void pageQueryNotView(PageBean<Criminal> pageBean, Criminal bean);

    void pageQueryCorrelateView(PageBean<Criminal> pageBean, Criminal bean);

}
