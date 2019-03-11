package com.utils;

import com.exception.WebMessageException;
import com.model.BpipUser;
import com.model.bean.BpipUserBean;
import com.service.BpipUserService;

public class SysBpipUserVo {
    public static BpipUserService bpipUserService;

    /**
     * tl
     *  根据id 查询用户
     *  @param id       [必填]    用户id
     * @return
     */
    public static BpipUserBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        BpipUserBean resulstBean = null;
        try {
            resulstBean = bpipUserService.findBpipUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据用户id 查询用户名称
     * @param id                [必填]        用户id
     * @return      用户名称
     */
    public static String getNameById(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        BpipUserBean bpipUserBean = findById(id);
        System.err.println(bpipUserBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(bpipUserBean)){
            if (!CommonValidate.isEmpty(bpipUserBean.getName())){
                resultName = bpipUserBean.getName();
            }
        }
        return resultName;
    }
}
