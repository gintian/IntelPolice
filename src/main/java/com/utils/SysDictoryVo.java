package com.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.bean.DictoryBean;

public class SysDictoryVo {

    private static Map<Integer, List<DictoryBean>> sysDictoryMap = new HashMap<>();//相同的标签对象添加到一个set里边

    /**
     * 添加数据
     *
     * @param key              [必填] 标签类型
     * @param sysDictoryList [必填] 标签类型是key的集合
     */
    public static void addDictoryBeanList(Integer key, List<DictoryBean> sysDictoryList) {
        sysDictoryMap.put(key, sysDictoryList);
    }

    /**
     * 添加数据
     *
     * @param key            [必填] 标签类型
     * @param sysDictoryList [必填] 标签类型是key的集合
     */
    public static void addDictoryBean(Integer key, DictoryBean sysDictoryList) {
        List<DictoryBean> list = sysDictoryMap.get(key);
        if(CommonValidate.isEmpty(list)){
            list = new ArrayList<>();
            sysDictoryMap.put(key, list);
        }
        list.add(sysDictoryList);
    }

    /**
     * 根据标签类型 获取该类型的所有标签
     *
     * @param key [必填] 标签类型
     * @return
     */
    public static List<DictoryBean> getDictoryBeanList(Integer key) {
        List<DictoryBean> sysDictoryList = new ArrayList<>();
        List<DictoryBean> baseDictoryBeanList = sysDictoryMap.get(key);

        if (CommonValidate.isEmpty(baseDictoryBeanList)){
            return sysDictoryList;
        }
        for (DictoryBean sysDictory : baseDictoryBeanList){
            DictoryBean sysDictoryRet = new DictoryBean();
            sysDictoryRet.setId(sysDictory.getId());
            sysDictoryRet.setLabel(sysDictory.getLabel());
            sysDictoryRet.setValue(sysDictory.getValue());
            sysDictoryRet.setDescp(sysDictory.getDescp());
            sysDictoryRet.setType(sysDictory.getType());
            sysDictoryRet.setSort(sysDictory.getSort());
            sysDictoryRet.setChangeInd(sysDictory.getChangeInd());
            sysDictoryRet.setParentId(sysDictory.getParentId());
            sysDictoryList.add(sysDictoryRet);
        }
        return sysDictoryList;
    }

    /**
     * t通过key  label 确定值
     * @param key
     * @param value
     * @return
     */
    public static String getDictoryBeanIdByKeyAndValue(Integer key, String value){
        List<DictoryBean> sysDictoryList = sysDictoryMap.get(key);
        if(CommonValidate.isEmpty(sysDictoryList)){
            return "0";
        }
        for(DictoryBean sysDictory : sysDictoryList) {
            if (sysDictory.getLabel().trim().equals(value)){
                return sysDictory.getId();
            }
        }
        return "0";
    }

    /**
     * 更新缓存数据
     *
     * @param key        [必填] 标签类型
     * @param sysDictory [必填] 修改后的对象（根据ID比较对象）
     */
    public static void updateDictoryBeanList(Integer key, DictoryBean sysDictory) {
        boolean b = true;
        List<DictoryBean> list = sysDictoryMap.get(key);
        if (CommonValidate.isEmpty(list)) {
            return;
        }
        for (DictoryBean sys : list) {
            if (sys.getId().equals(sysDictory.getId())) {
                sys.setLabel(sysDictory.getLabel());
                sys.setValue(sysDictory.getValue());
                b = false;
            }
        }
        if (b) {
            list.add(sysDictory);
        }
    }

    /**
     * 删除缓存
     *
     * @param key        [必填] 标签类型
     * @param sysDictory [必填] 删除的对象（根据ID比较对象）
     */
    public static void delDictoryBeanList(Integer key, DictoryBean sysDictory) {
        List<DictoryBean> list = sysDictoryMap.get(key);
        if(CommonValidate.isEmpty(list)){
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            DictoryBean sys = list.get(i);
            if (sys.getId().equals(sysDictory.getId())) {
                list.remove(i);
            }
        }
    }

    /**
     *  清空缓存
     */
    public static void clearCache(){
        System.out.println("=======================清空字典缓存===================");
        sysDictoryMap.clear();
    }
}
