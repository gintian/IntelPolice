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
          action="${root}<%=Url.getUrl(Url.NOTICE_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">ID：</label>
            <input name="id" id="id" placeholder="请输入ID" style="width: 200px;"
                   value="${searchObj.id}">
            <label for="title" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">标题：</label>
            <input name="title" id="title" placeholder="请输入标题" style="width: 200px;"
                   value="${searchObj.title}">

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="createUserId" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">创建人ID：</label>
                <input name="createUserId" id="createUserId" placeholder="请输入创建人ID"
                       style="width: 200px;" value="${searchObj.userId}">
                <label for="createUserName" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">创建人姓名：</label>
                <input name="createUserName" id="createUserName" placeholder="请输入创建人姓名"
                       style="width: 200px;" value="${searchObj.userName}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>

            <div class="pull-right">
                <a href="${root}<%=Url.getUrl(Url.NOTICE_ADD_SHOW)%>" data-toggle="navtab" class="btn btn-blue"
                   data-id="navtab" data-title="新增">新增</a>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th align="center">操作</th>
            <th align="center">公告ID</th>
            <th align="center">公告标题</th>
            <th align="center">显示状态</th>
            <th align="center">创建者ID</th>
            <th align="center">创建者姓名</th>
            <th align="center">创建者单位名</th>
            <th align="center">创建者单位代码</th>
            <th align="center">创建时间</th>
            <th align="center">业务类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <td class="option">
                <a href="${root}<%=Url.getUrl(Url.NOTICE_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                   data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                <a href="${root}<%=Url.getUrl(Url.NOTICE_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                   data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                <a href="${root}<%=Url.getUrl(Url.NOTICE_DELETE_SUBMIT)%>?id=${item.id}"
                   class="btn btn-red"
                   data-toggle="doajax" data-confirm-msg="确定要彻底删除吗？">删除</a>
                <c:choose>
                    <c:when test="${item.status==0}">
                        <a href="${root}<%=Url.getUrl(Url.NOTICE_SETLOCKABLE_SUBMIT)%>?id=${item.id}"
                           class="btn btn-orange"
                           data-toggle="doajax" data-confirm-msg="确定要显示该公告吗？">显示</a>
                        <a href="${root}<%=Url.getUrl(Url.NOTICE_SETTOP_SUBMIT)%>?id=${item.id}"
                           class="btn btn-blue"
                           data-toggle="doajax" data-confirm-msg="确定要置顶该公告吗？">置顶</a>
                    </c:when>
                    <c:when test="${item.status==2}">
                        <a href="${root}<%=Url.getUrl(Url.NOTICE_SETLOCKABLE_SUBMIT)%>?id=${item.id}"
                           class="btn btn-orange"
                           data-toggle="doajax" data-confirm-msg="确定要隐藏该公告吗？">隐藏</a>
                        <a href="${root}<%=Url.getUrl(Url.NOTICE_SETTOP_SUBMIT)%>?id=${item.id}"
                           class="btn btn-blue"
                           data-toggle="doajax" data-confirm-msg="确定要取消置顶该公告吗？">取消置顶</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${root}<%=Url.getUrl(Url.NOTICE_SETLOCKABLE_SUBMIT)%>?id=${item.id}"
                           class="btn btn-orange"
                           data-toggle="doajax" data-confirm-msg="确定要隐藏该公告吗？">隐藏</a>
                        <a href="${root}<%=Url.getUrl(Url.NOTICE_SETTOP_SUBMIT)%>?id=${item.id}"
                           class="btn btn-blue"
                           data-toggle="doajax" data-confirm-msg="确定要置顶该公告吗？">置顶</a>
                    </c:otherwise>
                </c:choose>
            </td>
            <td><hs:out value="${item.id}" length="5"/></td>
            <td><hs:out value="${item.title}"/></td>
            <td align="center">
                <c:choose>
                    <c:when test="${item.status == 0}">
                        不显示
                    </c:when>
                    <c:when test="${item.status == 1}">
                        正常
                    </c:when>
                    <c:when test="${item.status == 2}">
                        置顶
                    </c:when>
                    <c:otherwise>
                        状态异常
                    </c:otherwise>
                </c:choose>
            </td>
            <td><hs:out value="${item.userId}"/></td>
            <td><hs:out value="${item.userName}"/></td>
            <td><hs:out value="${item.unitName}"/></td>
            <td><hs:out value="${item.unitCode}"/></td>
            <td><hs:datefmt value="${item.createTime}"
                            stringDatePatten="dataTimeFormat"/></td>
            <td align="center">
                <c:choose>
                    <c:when test="${item.businessType == 1}">
                        类型一
                    </c:when>
                    <c:when test="${item.businessType == 2}">
                        类型二
                    </c:when>
                    <c:otherwise>
                        其他类型
                    </c:otherwise>
                </c:choose>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>