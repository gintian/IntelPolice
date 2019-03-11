package com.analysis.mapper;

import com.analysis.model.Xs050;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Xs050Mapper {
    int insert(Xs050 record);

    int insertSelective(Xs050 record);

    List<Xs050> selectAll();

    List<Xs050> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}