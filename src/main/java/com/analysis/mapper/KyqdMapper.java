package com.analysis.mapper;

import com.analysis.model.Kyqd;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface KyqdMapper {
    int insert(Kyqd record);

    int insertSelective(Kyqd record);

    List<Kyqd> selectAll();

    List<Kyqd> selectByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
}