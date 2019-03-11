package com.analysis.mapper;

import com.analysis.model.Xz0024;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Xz0024Mapper {
    int insert(Xz0024 record);

    int insertSelective(Xz0024 record);

    List<Xz0024> selectAll();

    List<Xz0024> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}