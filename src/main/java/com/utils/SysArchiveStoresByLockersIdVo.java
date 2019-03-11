package com.utils;

import com.exception.WebMessageException;
import com.model.bean.ArchiveStoresBean;
import com.service.ArchiveStoresService;
import com.service.ArchiveStoresLockersService;

public class SysArchiveStoresByLockersIdVo {
    public static ArchiveStoresService archiveStoresService;
    public static ArchiveStoresLockersService archiveStoresLockersService1;

    /**
     * tl
     *  根据id 查询柜子
     *  @param id       [必填]    柜子id
     * @return
     */
    public static ArchiveStoresBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        ArchiveStoresBean resulstBean = null;
        try {
            String storeId = archiveStoresLockersService1.findInvolvedStoresLockersById(id).getStoreId();
            resulstBean = archiveStoresService.findArchiveStoresById(storeId);
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
        ArchiveStoresBean resulstBean = null;
        try{
            resulstBean = findById(id);
        }catch (Exception e){e.printStackTrace();}
        System.err.println(resulstBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(resulstBean)){
            if (!CommonValidate.isEmpty(resulstBean.getName())){
                resultName = resulstBean.getName();
            }
        }
        return resultName;
    }
}
