package com.model.mapper;

import com.model.InvestigationSupAlarm;

public interface InvestigationSupAlarmMapper {
    int deleteByPrimaryKey(String suspicId);

    int insert(InvestigationSupAlarm record);

    int insertSelective(InvestigationSupAlarm record);

    InvestigationSupAlarm selectByPrimaryKey(String suspicId);

    int updateByPrimaryKeySelective(InvestigationSupAlarm record);

    int updateByPrimaryKey(InvestigationSupAlarm record);
}