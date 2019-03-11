package com.service.mapper;

import java.util.List;

import com.exception.WebMessageException;
import com.model.bean.CaseStatusBean;
import org.apache.ibatis.annotations.Param;

import com.model.Criminal;
import com.model.bean.CriminalBean;
import com.model.mapper.CriminalMapper;
import com.page.PageBean;

public interface CriminalBeanMapper extends CriminalMapper {
    // 查询分页数据
    List<CriminalBean> selectData(@Param("entity") CriminalBean bean, @Param("pageBean") PageBean<Criminal> pageBean);

    // 查询分页数据量
    int selectTotal(@Param("entity") CriminalBean bean);

    /**
     * 各个模块查询案件信息的公共方法
     *
     * @param pageBean
     * @param bean
     * @param moduleFunction 模块功能,如"未录入笔录的案件"
     * @throws WebMessageException
     */
    List<CriminalBean> findBeanPageForModule(@Param("pageBean") PageBean<Criminal> pageBean, @Param("entity") CriminalBean bean, @Param("moduleFunction") String moduleFunction);

    /**
     * 各个模块查询案件信息总条数的公共方法
     *
     * @param moduleFunction 模块功能,如"未录入笔录的案件"
     * @throws WebMessageException
     */
    int findBeanPageForModuleTotal(@Param("entity") CriminalBean bean, @Param("moduleFunction") String moduleFunction);


    /**
     * 根据caseStatus  状态条件  分页查询案件
     *
     * @param pageBean       [必填]			分页
     * @param bean           [必填]			案件
     * @param caseStatusBean [必填]			案件条件状态
     * @throws WebMessageException
     */
    List<CriminalBean> findBeanPageForCaseStatus(@Param("pageBean") PageBean<Criminal> pageBean, @Param("entity") CriminalBean bean, @Param("caseStatusBean") CaseStatusBean caseStatusBean);

    /**
     * 各个模块查询案件信息总条数的公共方法
     *
     * @param criminalBean   [必填]			案件筛选条件
     * @param caseStatusBean [必填]			caseStatus 关联信息
     * @throws WebMessageException
     */
    int findBeanPageForForCaseStatusTotal(@Param("entity") CriminalBean criminalBean, @Param("caseStatusBean") CaseStatusBean caseStatusBean);

    //通过案件ID查询
    CriminalBean selectCriminalEqCaseId(@Param("entity") CriminalBean bean);

    //通过案件名字查询
    List<CriminalBean> selectCriminalLikeCaseName(@Param("entity") CriminalBean bean);

    List<CriminalBean> selectDataAllEqBoxId(@Param("boxId") String boxId);

    List<CriminalBean> selectDataAllEqInvolvedBoxId(@Param("boxId") String boxId);

    CriminalBean selectByOrganizerId(String OrganizerId);

    // 查询分页数据
    List<CriminalBean> selectSmsNotFsData(@Param("entity") CriminalBean bean, @Param("pageBean") PageBean<Criminal> pageBean, @Param("stuts") String stuts);

    // 查询分页数据量
    int selectSmsNotFsTotal(@Param("entity") CriminalBean bean, @Param("stuts") String stuts);

    // 查询分页数据(无接处警异常)
    List<CriminalBean> selectNotjcjData(@Param("entity") CriminalBean bean, @Param("pageBean") PageBean<Criminal> pageBean);

    // 查询分页数据量(无接处警异常)
    int selectNotjcjTotal(@Param("entity") CriminalBean bean);

    // 查询分页数据(直接受理)
    List<CriminalBean> selectZjslData(@Param("entity") CriminalBean bean, @Param("pageBean") PageBean<Criminal> pageBean);

    // 查询分页数据量(直接受理)
    int selectZjslTotal(@Param("entity") CriminalBean bean);

    //通过jjdbh查询
    CriminalBean selectCriminalBeanByjjdbh(@Param("jjdbh") String jjdbh) throws WebMessageException;

    int selectNotViewTotal();

    List<Criminal> selectNotView(@Param("pageBean") PageBean<Criminal> pageBean, @Param("entity") Criminal bean);

    int selectCorrelateViewTotal();

    List<Criminal> selectCorrelateView(@Param("pageBean") PageBean<Criminal> pageBean, @Param("entity") Criminal bean);

}
