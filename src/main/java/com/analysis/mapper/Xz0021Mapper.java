package com.analysis.mapper;

import com.analysis.model.Xz0021;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Xz0021Mapper {
    int insert(Xz0021 record);

    int insertSelective(Xz0021 record);

    List<Xz0021> selectAll();

    List<Xz0021> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}