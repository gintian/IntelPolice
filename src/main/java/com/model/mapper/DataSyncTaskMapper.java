package com.model.mapper;

import com.model.DataSyncTask;

public interface DataSyncTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(DataSyncTask record);

    int insertSelective(DataSyncTask record);

    DataSyncTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DataSyncTask record);

    int updateByPrimaryKey(DataSyncTask record);
}