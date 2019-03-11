package com.service;

import com.exception.WebMessageException;
import com.model.User;

public interface AccessManager {

    /**
     * 检查用户可否访问指定uri
     *     说明：1、如果uri匹配到系统内置的无需登录访问权限 COM01 ,跳过所有权限控制，直接返回
     *           2、如果uri非上面第 1 点指定的uri，先检查 user 是否为 null，如果为 null 抛出未登录异常
     *           3、如果 user 不为 null，检查指定uri与用户可访问 uri 集合是否匹配，如果能匹配，方法完成并return
     *           4、如果上面第三步没能匹配到任何 uri 集合，抛出无权访问异常
     *     注意：上面列出了注意检验步骤，不等于不会抛出其他异常
     * @param uri     [必填] uri
     * @param user    [非必填] 当前登录用户
     */
    public void checkAccessUrl(String uri, User user) throws WebMessageException;

    /**
     * 缓存系统数据
     */
    public void doCacheData();
}