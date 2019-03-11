package com.service.impl;


import com.exception.WebMessageException;
import com.model.bean.BpipUserBean;
import com.service.mapper.BpipUserBeanMapper;
import com.service.BpipUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bpipUserService") // 声明是业务层的组件
public class BpipUserServiceImpl implements BpipUserService {
    @Autowired
    private BpipUserBeanMapper bpipUserBeanMapper;

    @Override
    public BpipUserBean findBpipUserById(String id) throws WebMessageException {
        BpipUserBean bpipUserBean = null;
        try{
            bpipUserBean = bpipUserBeanMapper.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bpipUserBean;
    }
}
