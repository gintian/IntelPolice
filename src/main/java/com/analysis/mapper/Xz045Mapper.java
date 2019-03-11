package com.analysis.mapper;

import com.analysis.model.Xz045;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Xz045Mapper {
    int insert(Xz045 record);

    int insertSelective(Xz045 record);

    List<Xz045> selectAll();

    List<Xz045> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}