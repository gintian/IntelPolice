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
          action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">卷宗柜ID：</label>
            <input name="id" id="id" placeholder="请输入编号" style="width: 200px;"
                   value="${searchObj.id}">
            <label for="name" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">卷宗柜名称：</label>
            <input name="name" id="name" placeholder="请输入卷宗名" style="width: 200px;"
                   value="${searchObj.name}">

            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>
            <c:choose>
                <c:when test="${status==null}">
                    <div class="pull-right">
                        <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_ADD_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_ADD_SHOW)%>" data-toggle="navtab"
                               class="btn btn-blue"
                               data-id="navtab" data-title="新增">新增</a>
                        </sys:permission>
                    </div>
                </c:when>
            </c:choose>
        </div>
    </form>
</div>
<script>
    function getName(id, name) {
        $.CurrentNavtab.find("#archive_storesId").val(id);
        $.CurrentNavtab.find("#archive_storesName").val(name);
        parent.window.document.getElementById("archive_storesId").value=id;
        parent.window.document.getElementById("archive_storesName").value=name;
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="180" align="center">操作</th>
            <th width="70" align="center">卷宗柜ID</th>
            <th width="100" align="center">卷宗柜名称</th>
            <th width="150" align="center">卷宗柜地址</th>
            <th width="150" align="center">所属机构</th>
            <th width="150" align="center">保管员</th>
            <th width="150" align="center">添加时间</th>
            <th width="150" align="center">修改时间</th>
            <th align="center">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_DETAIL_SHOW)%>?id=${item.id}"
                           class="btn btn-green"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    </sys:permission>
                    <c:choose>
                        <c:when test="${status==null}">
                            <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_UPDATE_SHOW)%>">
                                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_UPDATE_SHOW)%>?id=${item.id}"
                                   class="btn btn-blue"
                                   data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                            </sys:permission>
                            <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_DELETE_SUBMIT)%>">
                                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_DELETE_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-red"
                                   data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                            </sys:permission>
                            <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_PAGE_SHOW)%>">
                                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_PAGE_SHOW)%>?storeId=${item.id}"
                                   class="btn btn-blue"
                                   data-toggle="navtab" data-id="navtab" data-title="管理卷宗柜">管理卷宗柜</a>
                            </sys:permission>
                        </c:when>
                        <c:otherwise>
                            <a onclick="getName('${item.id}','${item.name}')" class="btn btn-close"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><hs:out value="${item.id}" length="5"/></td>
                <td><hs:out value="${item.name}"/></td>
                <td><hs:out value="${item.address}" length="5"/></td>
                <td><hs:dept value="${item.deptId}" /></td>
                <td> <hs:user value="${item.userId}" /></td>
                <td align="center"><hs:datefmt value="${item.addTime}"
                                               stringDatePatten="dataTimeFormat"/></td>
                <td align="center"><hs:datefmt value="${item.editTime}"
                                               stringDatePatten="dataTimeFormat"/></td>
                <td><hs:out value="${item.remark}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>