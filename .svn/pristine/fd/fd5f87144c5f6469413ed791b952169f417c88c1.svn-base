package com.utils;



import com.model.bean.CodeBean;
import com.service.CodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysCodeVo {
    public static CodeService codeService;
    private static List<CodeBean> sysdeptBeanList = new ArrayList<CodeBean>(); //相同的标签对象添加到一个set里边

    public static void setSysCodeBeanList(List<CodeBean> codeBeanList){
        //加锁同步数据
        sysdeptBeanList = codeBeanList;
        System.out.println("菜单缓存成功");
    }
    /**
     * 添加数据
     * @param sysCode [必填]
     */
    public static void addCodeBeanList(CodeBean sysCode) {
        sysdeptBeanList.add(sysCode);
    }

    /**
     * tl
     * 根据字段名field和代码Code 查询代码描述
     * @param field   [必填]        字段名
     * @param  code   [必填]        代码
     * @return      代码描述
     */
    public static String getCodeDescByFieldAndCode(String field , String code){
        if (CommonValidate.isEmpty(field)||CommonValidate.isEmpty(code)) {
            return "";
        }
        String resultValue = "";
        for(CodeBean sysCode : sysdeptBeanList) {
            if (sysCode.getField().trim().equals(field) && sysCode.getCode().trim().equals(code)){
                resultValue = sysCode.getCodedesc();
            }
        }
        return resultValue;
    }

    /**
     * 更新缓存数据
     * @param sysCode [必填] 修改后的对象（根据ID比较对象）
     */
    public static void updateDictoryBeanList(CodeBean sysCode) {
        if (CommonValidate.isEmpty(sysCode)) {
            return;
        }
        for (int i = 0; i < sysdeptBeanList.size(); i++) {
            CodeBean sys = sysdeptBeanList.get(i);
            if (sys.getId().equals(sysCode.getId())) {
                sys.setField(sysCode.getField());
                sys.setFieldname(sysCode.getFieldname());
                sys.setCode(sysCode.getCode());
                sys.setCodedesc(sysCode.getCodedesc());
                sys.setEnabled(sysCode.getEnabled());
                sys.setEditmode(sysCode.getEditmode());
                sys.setSortno(sysCode.getSortno());
                sys.setRemark(sysCode.getRemark());
                sysdeptBeanList.set(i,sys);
            }
        }
    }

    /**
     * 删除缓存
     * @param sysCode [必填] 删除的对象（根据ID比较对象）
     */
    public static void delDictoryBeanList(CodeBean sysCode) {
        if (CommonValidate.isEmpty(sysCode)) {
            return;
        }
        for (int i = 0; i < sysdeptBeanList.size(); i++) {
            CodeBean sys = sysdeptBeanList.get(i);
            if (sys.getId().equals(sysCode.getId())) {
                sysdeptBeanList.remove(i);
            }
        }
    }

    /**
     *  清空缓存
     */
    public static void clearCache(){
        System.out.println("=======================清空字典缓存===================");
        sysdeptBeanList.clear();
    }
}
