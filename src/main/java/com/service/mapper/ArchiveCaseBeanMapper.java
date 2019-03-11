package com.service.mapper;

import com.exception.WebMessageException;
import com.model.ArchiveCase;
import com.model.bean.ArchiveCaseBean;
import com.model.mapper.ArchiveCaseMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveCaseBeanMapper extends ArchiveCaseMapper {
	//查询分页数据
	List<ArchiveCaseBean> selectData(@Param("entity") ArchiveCaseBean bean, @Param("pageBean") PageBean<ArchiveCase> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") ArchiveCaseBean bean);
	//箱子Id查询bean
	ArchiveCaseBean selectByArchiveId(String archiveId);
	//根据boxID查询数据
	List<ArchiveCaseBean> selectDataByBoxId(String boxId);
}
