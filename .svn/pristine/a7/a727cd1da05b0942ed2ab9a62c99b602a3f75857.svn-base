package com.utils;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

public class AccessUtils {

    public static final String COMMOM_FUN_NAME = "COMMOM_FUN"; //数据库中无需登录的权限名
    private static Set<String> UN_LOGIN_URI_SET;                    //保存无需登录的uri集合
    private static List<String> ALL_USER_URI_LIST;                   //保存需要登录的uri集合
    private static final AntPathMatcher MATCHER = new AntPathMatcher();//匹配器，只保留一个实例

    public static void setUnLoginUriSet(Set<String> uriSet) {
        UN_LOGIN_URI_SET = uriSet;
    }

    public static boolean isUnloginUri(String uri) {
        return isPatternUri(uri, UN_LOGIN_URI_SET);
    }

    /**
     * 用户登录，异常日志输出
     * @param loginErrorCount
     * @param context
     */
    public static void doLogErrorForAcount(Integer loginErrorCount, ActionContext context){
        HttpServletRequest request = ServletActionContext.getRequest();
        if (CommonValidate.isEmpty(loginErrorCount)){
            context.getSession().put(SessionKey.USER_LOGIN_ERROR_COUNT, 1);
        }else {
            //登录错误次数，大于5，记录日志，登录用户， 网址，
            if (loginErrorCount > 5){
                //记录日志，可能有攻击
                System.out.println("记录日志，可能有攻击");
                System.out.println(request.getLocalAddr());
                System.out.println(request.getRemoteAddr());
            }
            context.getSession().put(SessionKey.USER_LOGIN_ERROR_COUNT, loginErrorCount + 1);
        }
    }
    /**
     * 判断url 是否有权限
     * @param uri
     * @param uriSet
     * @return
     */
    public static boolean isPatternUri(String uri, Set<String> uriSet) {

        if (uriSet == null || uriSet.size() == 0) {
            return false;
        }

        for (String pattern : uriSet) {
            if (pattern.indexOf(uri) != -1){
                return true;
            }
            if (MATCHER.match(pattern, uri)) {
                // 如果匹配到，返回
                return true;
            }
        }

        return false;
    }

//    public static void main(String[] args){
////        new Proxy(AccessUtils.class.getClassLoader(), )
//    }
}
