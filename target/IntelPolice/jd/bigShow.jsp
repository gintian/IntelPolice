<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent tableContent">
    <div class="bjui-pageHeader">
        <form id="${searchFormId}" data-toggle="ajaxsearch"
              action="${root}<%=Url.getUrl(Url.JD_BIGSHOW)%>" method="post">
            <div class="bjui-searchBar">
                <input name="parentId" id="parentId" type="hidden">
                <label for="name" class="control-label">名称：</label>
                <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.cwmc}">
                <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
                    <i class="fa fa-angle-double-down"></i>
                </button>
                <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
                <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
                   data-icon="undo">清空查询</a>


                <div class="pull-right">
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_ADD_SHOW)%>" class="btn btn-blue"
                       data-toggle="dialog" data-mask="true" data-width="500" data-height="500" data-title="新增">新增</a>
                </div>
            </div>
        </form>
    </div>
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true" style="font-size:14px;">
        <thead>
        <tr class="line_top">
            <th>操作</th>
            <th>ID</th>
            <th>展示名称</th>
            <th>展示内容</th>
            <th>登记人员</th>
            <th>登记时间</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500"
                       data-confirm-msg="详情">详情</a>
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500"
                       data-confirm-msg="编辑">编辑</a>
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DELETE_SUBMIT)%>?id=${item.id}"
                       class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                </td>
                <td title="${item.objId}"><hs:out value="${item.objId}" length="5"/></td>
                <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5"/></td>
                <td title="${item.cwmc}"><hs:out value="${item.cwmc}" length="5"/></td>
                <td><hs:datefmt value="${item.djsj}" stringDatePatten="dateTimeFormat"/></td>
                <td title="${item.lrry}"><hs:out value="${item.lrry}" length="5"/></td>
                <td title="${item.cwflCode}"><hs:out value="${item.cwflCode}" length="5"/></td>
                <td title="${item.kyyy}"><hs:out value="${item.kyyy}" length="5"/></td>
                <td title="${item.cwwz}"><hs:out value="${item.cwwz}" length="5"/></td>
                <td title="${item.bz}"><hs:out value="${item.bz}" length="5"/></td>
                <td title="${item.isBgsp}"><hs:out value="${item.isBgsp}" length="5"/></td>
                <td><hs:datefmt value="${item.bgdqsj}" stringDatePatten="dateTimeFormat"/></td>
                <td title="${item.isSa}"><hs:out value="${item.isSa}" length="5"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
</div>