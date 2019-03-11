package com.analysis.mapper;

import com.analysis.model.BpipUnitBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BpipUnitBeanMapper extends BpipUnitMapper {
	//查询所有数据
    List<BpipUnitBean> selectByPartOfUnitId(@Param("unitIdBefore") String unitIdBefore,
                                            @Param("unitIdAfter") String unitIdAfter,
                                            @Param("startDate") String startDate,
                                            @Param("endDate") String endDate);
}
