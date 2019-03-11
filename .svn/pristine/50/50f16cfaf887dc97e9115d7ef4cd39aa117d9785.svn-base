package com.utils;

import com.exception.WebMessageException;
import com.model.bean.InvolvedStoresBean;
import com.service.InvolvedStoresService;

public class SysInvolvedStoresVo {
    public static InvolvedStoresService involvedStoresService;

    /**
     * tl
     *  根据id 查询仓库
     *  @param id       [必填]    仓库id
     * @return
     */
    public static InvolvedStoresBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        InvolvedStoresBean resulstBean = null;
        try {
            resulstBean = involvedStoresService.findInvolvedStoresById(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据仓库id 查询仓库名称
     * @param id                [必填]        仓库id
     * @return      仓库名称
     */
    public static String getNameById(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        InvolvedStoresBean resulstBean = findById(id);
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
