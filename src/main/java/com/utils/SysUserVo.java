package com.utils;

import com.exception.WebMessageException;
import com.model.bean.UserBean;
import com.service.UserService;

public class SysUserVo {
    public static UserService userService;

    /**
     * tl
     *  根据id 查询用户
     *  @param id       [必填]    用户id
     * @return
     */
    public static UserBean findById(String id){
        if (CommonValidate.isEmpty(id)){
            return null;
        }
        UserBean resulstBean = null;
        try {
            resulstBean = userService.findUserById(id);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据用户id 查询用户名称
     * @param id                [必填]        用户id
     * @return      用户名称
     */
    public static String getNameById(String id){
        if (CommonValidate.isEmpty(id)) {
            return "";
        }
        UserBean userBean = findById(id);
        System.err.println(userBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(userBean)){
            if (!CommonValidate.isEmpty(userBean.getName())){
                resultName = userBean.getName();
            }
        }
        return resultName;
    }

    /**
     * tl
     *  根据identityCard查询用户
     *  @param identityCard [必填]    用户identityCard
     * @return
     */
    public static UserBean findByIdentityCard(String identityCard){
        if (CommonValidate.isEmpty(identityCard)){
            return null;
        }
        UserBean resulstBean = null;
        try {
            resulstBean = userService.findUserByIdentityCard(identityCard);
        } catch (WebMessageException e) {
            e.printStackTrace();
        }
        return resulstBean;
    }

    /**
     * tl
     * 根据用户identityCard查询用户名称
     * @param identityCard  [必填]  用户identityCard
     * @return      用户名称
     */
    public static String getNameByIdentityCard(String identityCard){
        if (CommonValidate.isEmpty(identityCard)) {
            return "";
        }
        UserBean userBean = findByIdentityCard(identityCard);
        System.err.println(userBean);
        String resultName = "";
        if (!CommonValidate.isEmpty(userBean)){
            if (!CommonValidate.isEmpty(userBean.getName())){
                resultName = userBean.getName();
            }
        }
        return resultName;
    }
}
