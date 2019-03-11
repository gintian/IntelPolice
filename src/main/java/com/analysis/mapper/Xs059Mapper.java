package com.analysis.mapper;

import com.analysis.model.Xs059;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Xs059Mapper {
    int insert(Xs059 record);

    int insertSelective(Xs059 record);

    List<Xs059> selectAll();

    List<Xs059> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}