package com.analysis.mapper;

import com.analysis.model.BpipUnitZJBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BpipUnitZJBeanMapper extends BpipUnitZJMapper {
	//查询所有数据
    List<BpipUnitZJBean> selectByPartOfUnitId(@Param("unitIdBefore") String unitIdBefore,
                                              @Param("unitIdAfter") String unitIdAfter,
                                              @Param("startDate") String startDate,
                                              @Param("endDate") String endDate);
}
