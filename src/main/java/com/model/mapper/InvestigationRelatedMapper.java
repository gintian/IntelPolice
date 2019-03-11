package com.model.mapper;

import com.model.InvestigationRelated;

public interface InvestigationRelatedMapper {
    int deleteByPrimaryKey(String withBreakId);

    int insert(InvestigationRelated record);

    int insertSelective(InvestigationRelated record);

    InvestigationRelated selectByPrimaryKey(String withBreakId);

    int updateByPrimaryKeySelective(InvestigationRelated record);

    int updateByPrimaryKey(InvestigationRelated record);
}