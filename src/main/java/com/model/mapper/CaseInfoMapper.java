package com.model.mapper;

import com.model.CaseInfo;

public interface CaseInfoMapper {
	int deleteByPrimaryKey(String id);

	int insert(CaseInfo record);

	int insertSelective(CaseInfo record);

	CaseInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(CaseInfo record);

	int updateByPrimaryKey(CaseInfo record);
}