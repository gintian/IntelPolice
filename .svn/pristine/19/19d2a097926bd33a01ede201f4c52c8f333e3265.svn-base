package com.service.mapper;

import com.model.RecordQuestion;
import com.model.bean.RecordQuestionBean;
import com.model.mapper.RecordQuestionMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordQuestionBeanMapper extends RecordQuestionMapper {
	//查询分页数据
	List<RecordQuestionBean> selectData(@Param("entity") RecordQuestionBean bean, @Param("pageBean") PageBean<RecordQuestionBean> pageBean,@Param("typeId") String typeId);
	//查询分页数据量
	int selectTotal(@Param("entity") RecordQuestionBean bean,@Param("typeId") String typeId);

	List<RecordQuestionBean> selectDataByType(String type);

	List<RecordQuestionBean> selectDataAll(@Param("entity") RecordQuestionBean bean,@Param("typeId") String typeId);

}
