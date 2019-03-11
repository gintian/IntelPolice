package com.model.mapper;

import com.model.RecordType;

public interface RecordTypeMapper {
    int deleteByPrimaryKey(String typeid);

    int insert(RecordType record);

    int insertSelective(RecordType record);

    RecordType selectByPrimaryKey(String typeid);

    int updateByPrimaryKeySelective(RecordType record);

    int updateByPrimaryKey(RecordType record);

}