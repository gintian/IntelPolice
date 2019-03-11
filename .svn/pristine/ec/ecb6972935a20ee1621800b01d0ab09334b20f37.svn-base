package com.analysis.mapper;

import com.analysis.model.Jsjqd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JsjqdMapper {
    int insert(Jsjqd record);

    int insertSelective(Jsjqd record);

    List<Jsjqd> selectAll();

    List<Jsjqd> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

}