package com.utils;

import com.exception.WebMessageException;
import com.model.bean.InvolvedStoresBoxBean;
import com.service.InvolvedStoresBoxService;

public class SysInvolvedStoresBoxVo {
    public static InvolvedStoresBoxService involvedStoresBoxService;

    /**
     * tl
     *  根据箱子id 查询箱子
     *  @param id       [必填]    箱子id
     * @return
     */
    public static InvolvedStoresBoxBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        InvolvedStoresBoxBean resulstBean = null;
        try {
            resulstBean = involvedStoresBoxService.findInvolvedStoresBoxById(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据箱子id 查询箱子编号
     * @param id                [必填]        箱子id
     * @return      箱子编号
     */
    public static String getBoxNoById(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        InvolvedStoresBoxBean resulstBean = findById(id);
        System.err.println(resulstBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(resulstBean)){
            if (!CommonValidate.isEmpty(resulstBean.getBoxNo())){
                resultName = resulstBean.getBoxNo();
            }
        }
        return resultName;
    }
}
