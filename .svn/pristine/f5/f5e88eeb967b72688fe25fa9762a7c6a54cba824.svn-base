package com.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.model.bean.MenuBean;

/**
 * Created by Administrator on 2018/4/13 0013.
 */
public class SysMenuVo {
    private static List<MenuBean> sysdeptBeanList = new ArrayList<MenuBean>();    //相同的标签对象添加到一个set里边
    //标志数据，缓存完成
    private static boolean flag = false;
    public static void setSysMenuBeanList(List<MenuBean> deptBeanList){
        //加锁同步数据
        sysdeptBeanList = deptBeanList;
        flag = true;
        System.out.println("菜单缓存成功");
    }
    public static void clearCache(){
        sysdeptBeanList.clear();
    }
    /**
     * 根据父类查询子类及其所有子类
     * @param parentId                  [必填]
     * @return
     */
    public static List<MenuBean> findByLikeParentId(String parentId){
        List<MenuBean> resultList = new ArrayList<>();
        if (!flag){
            return resultList;
        }
        for (MenuBean deptBean : sysdeptBeanList){
            if (deptBean.getParentId().startsWith(parentId)){
                    resultList.add(deptBean);
            }
        }
        return resultList;
    }

    /**
     * 根据id 查询Bean
     * @param id                [必填]     id
     * @return
     */
    public static MenuBean findById(String id){
        //id为空
        if (StringUtils.isEmpty(id)){
            return null;
        }
        //缓存数据未完成
        if (!flag){
            return null;
        }
        //查询返回
        for (MenuBean deptBean : sysdeptBeanList){
            if (id.equals(deptBean.getId())){
                MenuBean menuBean = new MenuBean();
                try {
                    BeanUtils.copyProperties(menuBean, deptBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return menuBean;
            }
        }
        //未查询到对象 返回null;
        return null;
    }

    /**
     * 根据父类查询子一代类
     * @param parentId                  [必填]
     * @return
     */
    public static List<MenuBean> findByEqParentId(String parentId){
        List<MenuBean> resultList = new ArrayList<>();
        if (!flag){
            return resultList;
        }
        for (MenuBean deptBean : sysdeptBeanList){
            if (deptBean.getParentId().equals(parentId)){
                resultList.add(deptBean);
            }
        }
        return resultList;
    }
    /**
     * 返回所有的数据
     * @return
     */
    public static List<MenuBean> findAll(){
        return new ArrayList<>(sysdeptBeanList);
    }
}
