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
          action="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">类别ID：</label>
            <input name="id" id="id" placeholder="请输入类别编号" style="width: 200px;"
                   value="${searchObj.id}">
            <label for="name" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">类别名称：</label>
            <input name="name" id="name" placeholder="请输入类别名称" style="width: 200px;"
                   value="${searchObj.name}">

            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>
            <c:choose>
                <c:when test="${status==null}">
                    <div class="pull-right">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_ADD_SHOW)%>" data-toggle="navtab"
                           class="btn btn-blue"
                           data-id="navtab" data-title="新增">新增</a>
                    </div>
                </c:when>
            </c:choose>
        </div>
    </form>
</div>
<script>
    function getName(id, name) {
        $.CurrentNavtab.find("#typeId").val(id);
        $.CurrentNavtab.find("#typeName").val(name);
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="180" align="center">操作</th>
            <th align="center">类别ID</th>
            <th align="center">类别名称</th>
            <th align="center">编码</th>
            <th align="center">排序号</th>
            <th align="center">类别父类</th>
            <th align="center">创建人</th>
            <th align="center">创建时间</th>
            <th align="center">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_DETAIL_SHOW)%>?id=${item.id}"
                       class="btn btn-green"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    <c:choose>
                        <c:when test="${status==null and item.id!='0001'}">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_UPDATE_SHOW)%>?id=${item.id}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_DELETE_SUBMIT)%>?id=${item.id}"
                               class="btn btn-red"
                               data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                        </c:when>
                        <c:when test="${status!=null}">
                            <a onclick="getName('${item.id}','${item.name}')" class="btn btn-close"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a>
                        </c:when>
                    </c:choose>
                </td>
                <td><hs:out value="${item.id}"/></td>
                <td><hs:out value="${item.name}"/></td>
                <td><hs:out value="${item.code}"/></td>
                <td><hs:out value="${item.sortcode}"/></td>
                <td><hs:involvedType value="${item.parentid}"/></td>
                <td><hs:user value='${item.userid}'/></td>
                <td align="center"><hs:datefmt value="${item.createtime}"
                                               stringDatePatten="dataTimeFormat"/></td>
                <td><hs:out value="${item.remark}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>