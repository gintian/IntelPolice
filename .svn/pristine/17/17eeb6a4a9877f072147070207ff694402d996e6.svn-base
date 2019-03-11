package com.utils;

import com.exception.WebMessageException;
import com.model.bean.ArchiveStoresLockersBean;
import com.service.ArchiveStoresLockersService;

public class SysArchiveStoresLockersVo {
    public static ArchiveStoresLockersService archiveStoresLockersService;

    /**
     * tl
     *  根据id 查询柜子
     *  @param id       [必填]    柜子id
     * @return
     */
    public static ArchiveStoresLockersBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        ArchiveStoresLockersBean resulstBean = null;
        try {
            resulstBean = archiveStoresLockersService.findInvolvedStoresLockersById(id);
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
        ArchiveStoresLockersBean resulstBean = null;
        try{
            resulstBean = findById(id);
        }catch (Exception e){e.printStackTrace();}
        System.err.println(resulstBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(resulstBean)){
            if (!CommonValidate.isEmpty(resulstBean.getLockersName())){
                resultName = resulstBean.getLockersName();
            }
        }
        return resultName;
    }
}
