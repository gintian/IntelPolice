package com.analysis.mapper;

import com.analysis.model.Kyjds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KyjdsMapper {
    int insert(Kyjds record);

    int insertSelective(Kyjds record);

    List<Kyjds> selectAll();

    List<Kyjds> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}