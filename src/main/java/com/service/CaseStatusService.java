package com.service;

import com.exception.WebMessageException;


/**
 * tl
 * 案事件，状态修改Service
 */
public interface CaseStatusService {
	/**
	 * 更新  事件状态     比如： caseStatusService.updateCaseStatus("111", "recordsyncstatus", "1");
	 * @param caseId				[必填]		案件id
	 * @param key					[必填]		字段名
	 * @param value				[必填]		值
	 * @throws WebMessageException
	 */
	 void updateCaseStatus(String caseId, String key, String value) throws WebMessageException;
}
