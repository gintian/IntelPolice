package com.model.mapper;

import com.model.InvestigationExpAlarm;

public interface InvestigationExpAlarmMapper {
    int deleteByPrimaryKey(String exceptionId);

    int insert(InvestigationExpAlarm record);

    int insertSelective(InvestigationExpAlarm record);

    InvestigationExpAlarm selectByPrimaryKey(String exceptionId);

    int updateByPrimaryKeySelective(InvestigationExpAlarm record);

    int updateByPrimaryKey(InvestigationExpAlarm record);
}