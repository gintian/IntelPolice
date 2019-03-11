package com.utils;

import com.exception.WebMessageException;
import com.model.bean.RecordPersonBean;
import com.service.RecordPersonService;

public class SysRecordPersonVo {
    public static RecordPersonService recordPersonService;

    /**
     * tl
     *  根据id 查询仓库
     *  @param id       [必填]    仓库id
     * @return
     */
    public static RecordPersonBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        RecordPersonBean resulstBean = null;
        try {
            resulstBean = recordPersonService.findRecordById(id);
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
        RecordPersonBean resulstBean = findById(id);
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
