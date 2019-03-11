package com.model.mapper;

import com.model.Criminal;

public interface CriminalMapper {
	int deleteByPrimaryKey(String id);

	int insert(Criminal record);

	int insertSelective(Criminal record);

	Criminal selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Criminal record);

	int updateByPrimaryKey(Criminal record);
}