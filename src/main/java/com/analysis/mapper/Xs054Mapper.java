package com.analysis.mapper;

import com.analysis.model.Xs054;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface Xs054Mapper {
    int insert(Xs054 record);

    int insertSelective(Xs054 record);

    List<Xs054> selectAll();

    List<Xs054> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}