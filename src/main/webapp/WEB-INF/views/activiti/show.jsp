<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <div class="bjui-searchBar">
        <div class="pull-right">
            <a href="${root}<%=Url.getUrl(Url.ACTIVITI_ADD_SHOW)%>" data-toggle="dialog" class="btn btn-blue"
               data-id="add_detail" data-width="700" data-height="400" data-title="新增">新增</a>
        </div>
    </div>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th>操作</th>
            <th>流程ID</th>
            <th>流程名称</th>
            <th>流程Key</th>
            <th>流程版本</th>
            <th>流程文件名</th>
            <th>流程图片名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <a href="${root}<%=Url.getUrl(Url.ACTIVITI_DETAIL_SHOW)%>?deploymentId=${item.deploymentId}&diagramResourceName=${item.diagramResourceName}"
                       class="btn btn-green" data-toggle="dialog" data-id="navtab" data-title="查看流程图">查看流程图</a>
                    <a href="${root}<%=Url.getUrl(Url.ACTIVITI_DELETE_SUBMIT)%>?deploymentId=${item.deploymentId}"
                       class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                </td>
                <td><hs:out value="${item.id}"/></td>
                <td><hs:out value="${item.name}"/></td>
                <td><hs:out value="${item.key}"/></td>
                <td><hs:out value="${item.version}"/></td>
                <td><hs:out value="${item.resourceName}"/></td>
                <td><hs:out value="${item.diagramResourceName}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>