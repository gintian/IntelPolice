package com.utils;

import com.exception.WebMessageException;
import com.model.bean.InvolvedTypesBean;
import com.service.InvolvedTypesService;

public class SysInvolvedTypesVo {
    public static InvolvedTypesService involvedTypesService;

    /**
     * tl
     *  根据id 查询财物分类
     *  @param id       [必填]    仓库id
     * @return
     */
    public static InvolvedTypesBean findByCode(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        InvolvedTypesBean resulstBean = null;
        try {
            resulstBean = involvedTypesService.findInvolvedTypesByCode(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据仓库id 查询财物分类名称
     * @param id                [必填]        仓库id
     * @return      仓库名称
     */
    public static String getNameByCode(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        InvolvedTypesBean resulstBean = findByCode(id);
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
