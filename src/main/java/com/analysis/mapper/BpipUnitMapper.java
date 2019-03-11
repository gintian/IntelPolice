package com.analysis.mapper;


import com.analysis.model.BpipUnit;

public interface BpipUnitMapper {
    int insert(BpipUnit record);

    int insertSelective(BpipUnit record);
}