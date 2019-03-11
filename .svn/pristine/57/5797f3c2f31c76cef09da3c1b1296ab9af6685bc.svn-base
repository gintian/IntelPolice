package com.analysis.mapper;

import com.analysis.model.Cfqd;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfqdMapper {
    int insert(Cfqd record);

    int insertSelective(Cfqd record);

    List<Cfqd> selectAll();

    List<Cfqd> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}