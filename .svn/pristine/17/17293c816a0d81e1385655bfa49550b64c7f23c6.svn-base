package com.filter;


import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Url;
import com.constant.WebExceptionConstant;
import com.utils.*;
import com.exception.WebMessageException;
import com.model.User;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
public class SessionFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---------session拦截开始------");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("utf-8");
        try {
            dofilter(request, response);
        } catch (WebMessageException e) {
            e.printStackTrace();
            response.sendRedirect(WebUtils.getFullRoot(request) + "/tologin.jsp");
            //返回登录页面
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("-------------拦截结束----------");
    }

    /**
     * 权限拦截
     * @param request
     * @param response
     * @throws WebMessageException
     */
    private void dofilter(HttpServletRequest request, HttpServletResponse response) throws WebMessageException{

        String uri = this.getUri(request);
        User user = getUser(request);
        //对登录页面，登录提交 与注销请求直接放行,不予拦截  ,
        if (uri.endsWith("/login.action") || uri.endsWith("/logout.action")
                || uri.endsWith("/login.jsp") || uri.endsWith("/")
                || uri.endsWith(Url.getUrl(Url.USER_LOGIN_VALIDATE))
                || uri.endsWith("/tologin.jsp")){
            System.out.println("-------放行-------------");
            System.out.println(uri);
            return;
        }
        if (uri.startsWith("/B-JUI.1.31") || uri.startsWith("/resources")){
            System.out.println("-------放行-------------");
            System.out.println(uri);
            return;
        }
        if (uri.endsWith("/loginout.action") || uri.endsWith("/failer.jsp")
                || uri.endsWith("/index.jsp")){
            System.out.println("-------放行-------------");
            System.out.println(uri);
            return;
        }

        //TODO无需登录就可以访问的url


        // 1、判断用户是否登录 抛出异常
        if (user == null) {
            throw new WebMessageException(WebExceptionConstant.LOGIN_ERROR);
        } else {
            //如果是超级管理员放行
            if (user.getId().equals("1") || user.getDeptId().equals("-1")){
                System.out.println("有权访问放行" + uri + user.getName());
                return;
            }
            //当用户登录，获取菜单权限放行
            if (uri.endsWith("/menu/aLL_list.action")){
                System.out.println("有权访问放行" + uri + user.getName());
                return;
            }
            //当用户登录，获取菜单权限放行
            if (uri.endsWith("/user/to_error_show.action")){
                System.out.println("有权访问放行" + uri + user.getName());
                return;
            }

            System.out.println("当前用户所拥有的rul");
            System.out.println(getPermissionUrls(request));
            //用户登录后是否有权限访问的url
            boolean flag = AccessUtils.isPatternUri(uri, getPermissionUrls(request));
            //测试放开，不做拦截
           /* if (true){
                System.out.println("测试访问放行" + uri + user.getName());
                return;
            }*/

            if (flag){
                //有权，放行
                System.out.println("有权访问放行" + uri + user.getName());
                return;
            }else {
                try {
                    System.out.println("无权访问！系统出现非法访问者" + uri +" == "+ user.getName()+ " == "+user.getId());
                    request.setAttribute(CommonConstant.SYSTEM_MESSAGE, WebExceptionConstant.USER_NONE_PERMISSION);
                    String url = WebUtils.getFullRoot(request)+Url.getUrl(Url.USER_TO_ERROR_SHOW);
                    response.sendRedirect(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //返回无权显示 页面
                return;
            }
        }
    }
    /**
     * 取得uri
     * @param request
     * @return
     */
    private String getUri(HttpServletRequest request) {
        String root = request.getContextPath();
        String uri = request.getRequestURI().replace(root, "");
        System.out.println(uri);
        return uri;
    }

    /**
     * 获取当前session用户
     * @param request
     * @return
     */
    private User getUser(HttpServletRequest request){

        return (User) request.getSession().getAttribute(SessionKey.USER);
    }

    /**
     * 获取用户的权限url
     * @param request
     * @return
     */
    private Set<String> getPermissionUrls(HttpServletRequest request){
        return (Set<String>)request.getSession().getAttribute(SessionKey.USER_PERMISSION_URL);
    }
}
