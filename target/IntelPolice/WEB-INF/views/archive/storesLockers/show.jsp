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
          action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">储物柜ID：</label>
            <input name="id" id="id" placeholder="请输入储物柜编号" style="width: 200px;"
                   value="${searchObj.lockersId}">
            <label for="lockersName" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">储物柜名称：</label>
            <input name="lockersName" id="lockersName" placeholder="请输入储物柜名称" style="width: 200px;"
                   value="${searchObj.lockersName}">

            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>
            <c:choose>
                <c:when test="${status==null}">
                    <div class="pull-right">
                        <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_ADD_SHOW)%>?storeId=${storeId}"
                           data-toggle="navtab"
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
        $.CurrentNavtab.find("#archive_lockerId").val(id);
        $.CurrentNavtab.find("#archive_lockersName").val(name);
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="160" align="center">操作</th>
            <th align="center">部门名称</th>
            <th align="center">仓库名称</th>
            <th align="center">类型</th>
            <th align="center">储物柜名称</th>
            <th align="center">门数</th>
            <th align="center">请求地址</th>
            <th align="center">host端口号</th>
            <th align="center">保管员</th>
            <th align="center">创建人员</th>
            <th align="center">生成时间</th>
            <th align="center">修改时间</th>
            <%--<th align="center">是否删除</th>--%>
            <th align="center">集成类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_DETAIL_SHOW)%>?lockersId=${item.lockersId}"
                       class="btn btn-green"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    <c:choose>
                        <c:when test="${status==null}">
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_UPDATE_SHOW)%>?lockersId=${item.lockersId}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_DELETE_SUBMIT)%>?lockersId=${item.lockersId}"
                               class="btn btn-red"
                               data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_PAGE_SHOW)%>?archiveStoresId=${item.lockersId}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="navtab" data-title="管理储物柜：${item.lockersName}">管理储物柜</a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="getName('${item.lockersId}','${item.lockersName}')" class="btn btn-close"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><hs:dept value="${item.deptId}" /></td>
                <td><hs:archiveStores value='${item.storeId}' /></td>

                <td>
                    <c:if test="${item.type eq '1'}"> 智能保管柜</c:if>
                    <c:if test="${item.type eq '2'}"> 普通保管柜</c:if>
                    <c:if test="${item.type eq '3'}"> 恒温保管柜</c:if>
                    <c:if test="${item.type eq '4'}"> 保险柜</c:if>
                    <c:if test="${item.type eq '5'}"> 货架</c:if>
                </td>
                <td title="${item.lockersName}"><hs:out value="${item.lockersName}" length="5"/></td>
                <td>${item.lockerGate}</td>
                <td title="${item.postPath}"><hs:out value="${item.postPath}" length="5"/></td>
                <td title="${item.host}"><hs:out value="${item.host}" length="5"/></td>
                <td><hs:user value="${item.userId}"/></td>
                <td><hs:user value="${item.createUserId}"/></td>
                <td align="center"><hs:datefmt value="${item.createTime}"
                                               stringDatePatten="dataTimeFormat"/></td>
                <td align="center"><hs:datefmt value="${item.editTime}"
                                               stringDatePatten="dataTimeFormat"/></td>
                <%--<td><hs:out value="${item.isDelete}"/></td>--%>
                <td>
                    <c:if test="${item.integration eq '1'}">socket</c:if>
                    <c:if test="${item.integration eq '2'}">webservice</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>