package com.model.mapper;

import com.model.InvolvedTask;

import java.util.List;

public interface InvolvedTaskMapper {

    int insert(InvolvedTask involvedTask);

    int deleteByPrimaryKey(String id);

    int insertSelective(InvolvedTask involvedTask);

    InvolvedTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InvolvedTask involvedTask);

    int updateByPrimaryKey(InvolvedTask involvedTask);
}