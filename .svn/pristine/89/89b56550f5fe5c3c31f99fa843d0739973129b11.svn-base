package com.utils;

import com.exception.WebMessageException;
import com.model.bean.InvolvedStoresLockersBean;
import com.service.InvolvedStoresLockersService;

public class SysInvolvedStoresLockersVo {
    public static InvolvedStoresLockersService involvedStoresLockersService;

    /**
     * tl
     *  根据id 查询柜子
     *  @param id       [必填]    柜子id
     * @return
     */
    public static InvolvedStoresLockersBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        InvolvedStoresLockersBean resulstBean = null;
        try {
            resulstBean = involvedStoresLockersService.findInvolvedStoresLockersById(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据柜子id 查询柜子名称
     * @param id                [必填]        柜子id
     * @return      柜子名称
     */
    public static String getNameById(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        InvolvedStoresLockersBean resulstBean = findById(id);
        System.err.println(resulstBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(resulstBean)){
            if (!CommonValidate.isEmpty(resulstBean.getLockerName())){
                resultName = resulstBean.getLockerName();
            }
        }
        return resultName;
    }
}
