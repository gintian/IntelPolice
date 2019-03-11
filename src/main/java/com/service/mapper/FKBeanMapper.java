package com.service.mapper;

import com.exception.WebMessageException;
import com.model.FK;
import com.model.bean.FKBean;
import com.model.mapper.FKMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FKBeanMapper extends FKMapper {
	//查询分页数据
	List<FKBean> selectData(@Param("entity") FKBean bean, @Param("pageBean") PageBean<FK> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") FKBean bean);
	//通过xzqhdm查询
	List<FKBean> selectFKEqXzqhdm(@Param("xzqhdm") String xzqhdm) throws WebMessageException;
	//通过fkdbh查询
	FKBean selectFKEqFkdbh(@Param("fkdbh") String fkdbh) throws WebMessageException;
	//通过Cj查询
	List<FKBean> selectFKEqCj(String cj) throws WebMessageException;
}
