<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">ID：</label>
            <input name="id" id="id" placeholder="请输入ID" style="width: 200px;"
                   value="${searchObj.id}">

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="code" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">卷宗ID：</label>
                <input name="code" id="code" placeholder="请输入卷宗ID"
                       style="width: 200px;" value="${searchObj.archiveId}">
                <label for="userId" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">案件ID：</label>
                <input name="userId" id="userId" placeholder="请输入案件ID"
                       style="width: 200px;" value="${searchObj.caseId}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>

            <div class="pull-right">
                <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_CASE_ADD_SHOW)%>">
                    <a href="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_ADD_SHOW)%>" data-toggle="navtab"
                       class="btn btn-blue"
                       data-id="navtab" data-title="新增">新增</a>
                </sys:permission>

            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="220" align="center">操作</th>
            <th align="center">ID</th>
            <th align="center">卷宗ID</th>
            <th align="center">案件ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center">
                    <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_CASE_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_DETAIL_SHOW)%>?id=${item.id}"
                           class="btn btn-green"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_CASE_UPDATE_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_UPDATE_SHOW)%>?id=${item.id}"
                           class="btn btn-blue"
                           data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_CASE_DELETE_SUBMIT)%>">
                        <a href="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_DELETE_SUBMIT)%>?id=${item.id}"
                           class="btn btn-red"
                           data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                    </sys:permission>
                </td>
                <td><hs:out value="${item.id}"/></td>
                <td><hs:out value="${item.archiveId}"/></td>
                <td><hs:out value="${item.caseId}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>