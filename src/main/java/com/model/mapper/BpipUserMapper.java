package com.model.mapper;

import com.model.BpipUser;
import com.model.bean.BpipUserBean;

public interface BpipUserMapper {
    BpipUserBean findById(String id);
}