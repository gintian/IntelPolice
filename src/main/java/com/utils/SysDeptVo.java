package com.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.exception.WebMessageException;
import com.model.bean.DeptBean;
import com.service.DeptService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tl on 2018/4/13 0013.
 */
public class SysDeptVo {
    public static DeptService deptService;
    private static List<DeptBean> sysdeptBeanList = new ArrayList<DeptBean>();    //相同的标签对象添加到一个set里边
    //标志数据，缓存完成
    private static boolean flag = false;
    public static void setSysDeptBeanList(List<DeptBean> deptBeanList){
        //加锁同步数据
        sysdeptBeanList = deptBeanList;
        flag = true;
    }

    /**
     * 父类id
     * 请谨慎修改此方法   tl
     * @param parentId                  [必填]
     * @return
     */
    public static List<DeptBean> findByParentId(String parentId){
        List<DeptBean> resultList = new ArrayList<>();
        if (CommonValidate.isEmpty(parentId)){
            return resultList;
        }
        if (!flag){
            return resultList;
        }

        //查询跟部门
        DeptBean parentDeptBean = findById(parentId);
        if (!CommonValidate.isEmpty(parentDeptBean)) {
            for (DeptBean deptBean : sysdeptBeanList) {
                if (deptBean.getParentId().startsWith(parentId)) {
                    resultList.add(deptBean);
                }
            }
        }

        return resultList;
    }

    /**
     * tl
     *  根据id 查询部门
     *  @param id       [必填]    部门id
     * @return
     */
    public static DeptBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        DeptBean resulstBean = null;
        try {
            resulstBean = deptService.findDeptBeanByDeptId(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
       /* if (!flag){
            return null;
        }

        for (DeptBean deptBean : sysdeptBeanList){
            if (deptBean.getId().equals(id)){
                try {
                    resulstBean = new DeptBean();
                    BeanUtils.copyProperties(resulstBean, deptBean);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("根据id 查询部门复制参数出错！");
                }
                break;
            }
        }*/
        return resulstBean;
    }

    /**
     * tl
     * 根据部门id 查询部门名称
     * @param id                [必填]        部门id
     * @return      部门名称
     */
    public static String getNameById(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        DeptBean deptBean = findById(id);
        String resultName = "";
        if (!CommonValidate.isEmpty(deptBean)){
            if (!CommonValidate.isEmpty(deptBean.getName())){
                resultName = deptBean.getName();
            }
        }
        return resultName;
    }
    /**
     * tl
     * 返回所有的数据
     * @return
     */
    public static List<DeptBean> findAll(){
        return new ArrayList<>(sysdeptBeanList);
    }
}
