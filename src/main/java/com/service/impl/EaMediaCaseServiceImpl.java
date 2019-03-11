package com.service.impl;

import com.model.bean.EaMediaCaseBean;
import com.service.EaMediaCaseService;
import com.service.mapper.EaMediaCaseBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eaMediaCaseService")
public class EaMediaCaseServiceImpl implements EaMediaCaseService {

    @Autowired
    EaMediaCaseBeanMapper eaMediaCaseBeanMapper;

    @Override
    public EaMediaCaseBean selectByDocid(String id) {

        return eaMediaCaseBeanMapper.selectByDocid(id);
    }
}
