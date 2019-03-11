package com.service;

import com.exception.WebMessageException;
import com.model.bean.BpipUserBean;

import java.util.List;

/**
 * 类名称：ArchiveCaseService 类描述：处警单逻辑接口
 */
public interface BpipUserService {
	/**
	 * 通过Id查询Bean
	 */
	BpipUserBean findBpipUserById(String id) throws WebMessageException;
}
