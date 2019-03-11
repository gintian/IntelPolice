<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%
    // 权限验证
    if(session.getAttribute(SessionKey.USER)==null){
        response.sendRedirect("login.jsp");
        return;
    } else {
        request.setAttribute("currentUser", (User)session.getAttribute(SessionKey.USER));
    }
%>
<div class="bjui-pageContent">
    <form action="${root}<%=Url.getUrl(Url.USER_PASSWORD_CHANGE_SUBMIT)%>" data-toggle="validate" method="post" data-close-current="true">
        <input type="hidden" name="account" value="${currentUser.account}"/>
        <div class="bjui-row col-1">
            <label class="row-label">姓名:</label>
            <div class="row-input">${currentUser.name}</div>
            <label class="row-label">登陆账号:</label>
            <div class="row-input">${currentUser.account}</div>
            <label class="row-label">旧密码:</label>
            <div class="row-input required">
                <input type="password" id="j_userinfo_changepass_oldpass" name="oldpassword" maxlength="30" value="" data-rule="required">
            </div>
            <label class="row-label">新密码:</label>
            <div class="row-input required">
                <input type="password" id="j_userinfo_changepass_newpass" name="password" maxlength="30" value="" data-rule="新密码:required;length(6~)">
            </div>
            <label class="row-label">确认密码:</label>
            <div class="row-input required">
                <input type="password" id="j_userinfo_changepass_confirmpass" name="" maxlength="30" value="" data-rule="required;match(#j_userinfo_changepass_newpass)">
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn btn-close" data-icon="check">确认修改</button></li>
    </ul>
</div>