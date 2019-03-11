package com.model.mapper;

import com.model.JJ;

public interface JJMapper {
	int deleteByPrimaryKey(String id);

	int insert(JJ record);

	int insertSelective(JJ record);

	JJ selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(JJ record);

	int updateByPrimaryKey(JJ record);
}