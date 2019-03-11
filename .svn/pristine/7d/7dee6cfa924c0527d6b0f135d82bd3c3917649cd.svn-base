package com.utils;

import com.exception.WebMessageException;
import com.model.bean.ArchiveStoresBean;
import com.model.bean.UserBean;
import com.service.ArchiveStoresService;
import com.service.UserService;

public class SysArchiveStoresVo {
    public static ArchiveStoresService archiveStoresService;

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
            resulstBean = archiveStoresService.findArchiveStoresById(id);
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
        ArchiveStoresBean archiveStoresBean = findById(id);
        System.err.println(archiveStoresBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(archiveStoresBean)){
            if (!CommonValidate.isEmpty(archiveStoresBean.getName())){
                resultName = archiveStoresBean.getName();
            }
        }
        return resultName;
    }
}
