package com.analysis.mapper;

import com.analysis.model.Djbcqd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DjbcqdMapper {
    int insert(Djbcqd record);

    int insertSelective(Djbcqd record);

    List<Djbcqd> selectAll();

    List<Djbcqd> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}