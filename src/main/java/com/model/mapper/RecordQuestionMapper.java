package com.model.mapper;

import com.model.RecordQuestion;

public interface RecordQuestionMapper {

    int deleteByPrimaryKey(String id);

    int insert(RecordQuestion record);

    int insertSelective(RecordQuestion record);

    RecordQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RecordQuestion record);

    int updateByPrimaryKey(RecordQuestion record);
}