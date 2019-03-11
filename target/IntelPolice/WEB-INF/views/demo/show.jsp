<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.DEMO_PAGE_SHOW)%>"
          method="get">
        <div class="bjui-searchBar">

            <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>

            <div class="bjui-moreSearch">
            </div>

            <div class="pull-right">
                <sys:permission url="<%=Url.getUrl(Url.DEMO_ADD_SHOW)%>">
                    <a href="${root}<%=Url.getUrl(Url.DEMO_ADD_SHOW)%>" data-toggle="navtab" class="btn btn-blue"
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
            <th>操作</th>
            <th>id</th>
            <th>title</th>
            <th>content</th>
            <th>tm</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <sys:permission url="<%=Url.getUrl(Url.DEMO_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEMO_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                           data-toggle="dialog" data-id="demo_detail" data-width="700" data-height="200"
                           data-confirm-msg="详情">详情</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.DEMO_UPDATE_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEMO_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                           data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.DEMO_DELETE_SUBMIT)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEMO_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-orange"
                           data-toggle="doajax" data-confirm-msg="确定要删除吗？">软删除</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.DEMO_DELETE_SUBMIT)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEMO_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red"
                           data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                    </sys:permission>
                </td>
                <td><hs:out value="${item.id}"/></td>
                <td><hs:out value="${item.title}"/></td>
                <td><hs:out value="${item.content}"/></td>
                <td><hs:out value="${item.tm}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>