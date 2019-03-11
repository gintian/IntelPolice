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
          action="${root}<%=Url.getUrl(Url.FILES_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">ID：</label>
            <input name="id" id="id" placeholder="请输入ID" style="width: 200px;"
                   value="${searchObj.id}">
            <label for="name" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">文件名称：</label>
            <input name="name" id="name" placeholder="请输入标题" style="width: 200px;"
                   value="${searchObj.name}">
            <input name="status" type="hidden" value="1">

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="userName" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">上传者：</label>
                <input name="userName" id="userName" placeholder="请输入创建人ID"
                       style="width: 200px;" value="${searchObj.userName}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>

        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="50" align="center">操作</th>
            <th width="80" align="center">文件名称</th>
            <th width="80" align="center">文件大小</th>
            <th width="90" align="center">上传时间</th>
            <th width="60" align="center">上传者</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <td class="option" align="center">
                <a href="${root}<%=Url.getUrl(Url.FILES_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                   data-toggle="dialog" data-mask="true" data-width="600" data-height="500">查看</a>
                <a href="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?name=${item.name}&path=${item.path}"
                   class="btn btn-green">下载</a>
            </td>
            <td><hs:out value="${item.name}"/></td>
            <td><hs:out value="${item.sizes}"/></td>
            <td align="center"><hs:datefmt value="${item.createTime}"
                                           stringDatePatten="dataTimeFormat"/></td>
            <td align="center"><hs:out value="${item.userName}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>