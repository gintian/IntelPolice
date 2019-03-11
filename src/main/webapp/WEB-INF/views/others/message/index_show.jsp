<%--
  Created by IntelliJ IDEA.
  User: 45509
  Date: 2018/6/5
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
            <c:choose>
            <c:when test="${status!=0}">
            <div class="pull-right">
                <a href="${root}<%=Url.getUrl(Url.MESSAGE_ADD_SHOW)%>" data-toggle="navtab" class="btn btn-blue"
                   data-id="navtab" data-title="新增">新增</a>
                </c:when>
                </c:choose>
            </div>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th align="center">操作</th>
            <th align="center" width="300">消息标题</th>
            <th align="center">发送人</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
        <c:when test="${list.size()>0}">
        <c:forEach items="${list}" var="item">
            <td class="option" align="center">
                <a href="${root}<%=Url.getUrl(Url.MESSAGE_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                   data-toggle="dialog" data-id="viewMessageShow" data-mask="true" data-width="600"
                   data-height="500">查看</a>
                <a href="${root}<%=Url.getUrl(Url.MESSAGE_RECOVER_SUBMIT)%>?id=${item.id}"
                   class="btn btn-orange"
                   data-toggle="doajax" data-confirm-msg="确定要放入回收站吗？">放入回收站</a>
            </td>
            <td><hs:out value="${item.title}"/></td>
            <td align="center"><hs:out value="${item.createUserName}"/></td>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:when>
    <c:otherwise>
        </tbody>
        </table>
        <h3 align="center">当前没有新消息</h3>
    </c:otherwise>
    </c:choose>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>