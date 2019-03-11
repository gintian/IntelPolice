package com.service.mapper;

import com.model.bean.CaseStatusBean;
import com.model.mapper.CaseStatusMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/5/19 0019.
 */
public interface CaseStatusBeanMapper extends CaseStatusMapper {
    /**
     * 根据  caseId  查询 bean
     * @param caseId                [必填]    案件id
     * @return
     */
    CaseStatusBean findBeanByCaseId(@Param("caseId") String caseId);
}
