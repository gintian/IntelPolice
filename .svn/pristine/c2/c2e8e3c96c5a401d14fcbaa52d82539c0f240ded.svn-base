package com.analysis.mapper;

import com.analysis.model.InvolvedTemp;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvolvedTempMapper {
    int insert(InvolvedTemp record);

    int insertSelective(InvolvedTemp record);

    List<InvolvedTemp> selectByObjid(@Param("objid") String objid);
    int selectCountByObjid(@Param("objid") String objid);
    void deleteByObjid(@Param("objid") String objid);
    void deleteByObjids(@Param("objids") List<String> objids);

    List<InvolvedTemp> selectByCaseId(@Param("caseId") String caseId);

    InvolvedTemp selectByPrimaryKey(String id);
    //查询分页数据
    List<InvolvedTemp> selectDataByCaseId(@Param("entity") InvolvedTemp bean, @Param("pageBean") PageBean<InvolvedTemp> pageBean);
    //查询分页数据量
    int selectTotalByCaseId(@Param("entity") InvolvedTemp bean);
}