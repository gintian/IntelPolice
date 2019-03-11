package com.analysis.mapper;

import com.analysis.model.Zjbqjds;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ZjbqjdsMapper {
    int insert(Zjbqjds record);

    int insertSelective(Zjbqjds record);

    List<Zjbqjds> selectAll();

    List<Zjbqjds> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}