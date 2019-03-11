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
          action="${root}<%=Url.getUrl(Url.MESSAGE_SEND_SHOW)%>" method="post">
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
                       style="width: 200px;" value="${searchObj.createUserId}">
                <label for="createUserName" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">创建人姓名：</label>
                <input name="createUserName" id="createUserName" placeholder="请输入创建人姓名"
                       style="width: 200px;" value="${searchObj.createUserName}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>

            <c:choose>
            <c:when test="${status!=0}">
            <div class="pull-right">
                <a href="${root}<%=Url.getUrl(Url.MESSAGE_ADD_SHOW)%>" data-toggle="navtab" class="btn btn-blue"
                   data-id="navtab" data-title="新增">新增</a>
                </c:when>
                </c:choose>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="200" align="center">操作</th>
            <th width="70" align="center">消息ID</th>
            <th width="80" align="center">消息标题</th>
            <th width="80" align="center">发送人</th>
            <th align="center">操作时间</th>
            <th width="80" align="center">是否查看</th>
            <th align="center">查看时间</th>
            <th width="60" align="center">状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <td class="option" align="center">
                <c:choose>
                    <c:when test="${item.createUserId==currentUser.id}">
                        <a href="${root}<%=Url.getUrl(Url.MESSAGE_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                           data-toggle="dialog" data-id="edit" data-width="800" data-height="550" data-title="编辑">编辑</a>
                        <c:choose>
                            <c:when test="${item.status==0}">
                                <a href="${root}<%=Url.getUrl(Url.MESSAGE_RECOVER_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-orange"
                                   data-toggle="doajax" data-confirm-msg="确定要从回收站还原吗？">还原</a>
                                <a href="${root}<%=Url.getUrl(Url.MESSAGE_DELETE_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-red"
                                   data-toggle="doajax" data-confirm-msg="确定要彻底删除吗？">删除</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${root}<%=Url.getUrl(Url.MESSAGE_RECOVER_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-orange"
                                   data-toggle="doajax" data-confirm-msg="确定要放入回收站吗？">放入回收站</a>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${item.status==0}">
                                <a href="${root}<%=Url.getUrl(Url.MESSAGE_RECOVER_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-orange"
                                   data-toggle="doajax" data-confirm-msg="确定要从回收站还原吗？">还原</a>
                                <a href="${root}<%=Url.getUrl(Url.MESSAGE_DELETE_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-red"
                                   data-toggle="doajax" data-confirm-msg="确定要彻底删除吗？">删除</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${root}<%=Url.getUrl(Url.MESSAGE_RECOVER_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-orange"
                                   data-toggle="doajax" data-confirm-msg="确定要放入回收站吗？">放入回收站</a>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </td>
            <td><hs:out value="${item.id}" length="5"/></td>
            <td><hs:out value="${item.title}"/></td>
            <td align="center"><hs:out value="${item.createUserName}"/></td>
            <td align="center"><hs:datefmt value="${item.createTime}"
                                           stringDatePatten="dataTimeFormat"/></td>
            <td align="center">
                <c:choose>
                    <c:when test="${item.isVisit == 0}">
                        未查看
                    </c:when>
                    <c:otherwise>
                        已查看
                    </c:otherwise>
                </c:choose>
            </td>
            <td align="center"><hs:datefmt value="${item.visitTime}"
                                           stringDatePatten="dataTimeFormat"/></td>
            <td align="center">
                <c:choose>
                    <c:when test="${item.status == 0}">
                        已回收
                    </c:when>
                    <c:when test="${item.status == 1}">
                        正常
                    </c:when>
                    <c:otherwise>
                        状态异常
                    </c:otherwise>
                </c:choose>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>