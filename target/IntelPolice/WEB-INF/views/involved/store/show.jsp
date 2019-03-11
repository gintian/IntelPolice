<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<c:choose>
    <c:when test="${status==null}">
        <div class="bjui-pageHeader">
            <form id="${searchFormId}" data-toggle="ajaxsearch"
                  action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_PAGE_SHOW)%>" method="post">
                <div class="bjui-searchBar">
                    <label for="id" class="control-label"
                           style="margin-left: 0px; padding-left: 0px; width: 60px;">仓库ID：</label>
                    <input name="id" id="id" placeholder="请输入仓库编号" style="width: 200px;"
                           value="${searchObj.id}">
                    <label for="name" class="control-label"
                           style="margin-left: 0px; padding-left: 0px; width: 60px;">仓库名称：</label>
                    <input name="name" id="name" placeholder="请输入仓库名" style="width: 200px;"
                           value="${searchObj.name}">

                    <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
                    <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                       data-clear-query="true"
                       data-icon="undo">清空查询</a>
                    <c:choose>
                        <c:when test="${status==null}">
                            <div class="pull-right">
                                <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_ADD_SHOW)%>" data-toggle="navtab"
                                   class="btn btn-blue"
                                   data-id="navtab" data-title="新增">新增</a>
                            </div>
                        </c:when>
                    </c:choose>
                </div>
            </form>
        </div>
    </c:when>
</c:choose>
<script>
    function getName(id, name) {
        $.CurrentNavtab.find("#involved_storeId").val(id);
        $.CurrentNavtab.find("#involved_storeName").val(name);
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="160" align="center">操作</th>
            <th align="center">仓库ID</th>
            <th align="center">仓库名称</th>
            <th align="center">仓库地址</th>
            <th align="center">所属机构</th>
            <th align="center">保管员</th>
            <c:choose>
                <c:when test="${status==null}">
                    <th align="center">创建人员</th>
                    <th align="center">备注</th>
                    <th align="center">添加时间</th>
                    <th align="center">修改时间</th>
                    <th align="center">排序号</th>
                </c:when>
            </c:choose>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_DETAIL_SHOW)%>?id=${item.id}"
                       class="btn btn-green"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    <c:choose>
                        <c:when test="${status==null}">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_UPDATE_SHOW)%>?id=${item.id}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="store-update" data-title="仓库编辑">编辑</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_DELETE_SUBMIT)%>?id=${item.id}"
                               class="btn btn-red"
                               data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_PAGE_SHOW)%>?storeId=${item.id}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="store-manage" data-title="管理仓库：${item.name}">管理仓库</a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="getName('${item.id}','${item.name}')" class="btn btn-close">选择</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><hs:out value="${item.id}" length="5"/></td>
                <td><hs:out value="${item.name}"/></td>
                <td><hs:out value="${item.location}" length="5"/></td>
                <td><hs:dept value="${item.deptId}"/></td>
                <td><hs:user value='${item.userId}'/></td>
                <c:choose>
                    <c:when test="${status==null}">
                        <td><hs:user value='${item.createUserId}'/></td>
                        <td><hs:out value="${item.remark}"/></td>
                        <td align="center"><hs:datefmt value="${item.createTime}"
                                                       stringDatePatten="dataTimeFormat"/></td>
                        <td align="center"><hs:datefmt value="${item.editTime}"
                                                       stringDatePatten="dataTimeFormat"/></td>
                        <td><hs:out value="${item.sortCode}"/></td>
                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>