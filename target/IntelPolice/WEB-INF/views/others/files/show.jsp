<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.constant.CommonConstant" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <c:choose>
    <c:when test="${currentType==11}">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.FILES_LIST_DETAIN_PAGE_SHOW)%>" method="post">
        </c:when>
        <c:when test="${currentType==12}">
        <form id="${searchFormId}" data-toggle="ajaxsearch"
              action="${root}<%=Url.getUrl(Url.FILES_LIST_IN_PAGE_SHOW)%>" method="post">
            </c:when>
            <c:when test="${currentType==13}">
            <form id="${searchFormId}" data-toggle="ajaxsearch"
                  action="${root}<%=Url.getUrl(Url.FILES_LIST_EXTRACT_PAGE_SHOW)%>" method="post">
                </c:when>
                <c:when test="${currentType==14}">
                <form id="${searchFormId}" data-toggle="ajaxsearch"
                      action="${root}<%=Url.getUrl(Url.FILES_LIST_TRANSFER_PAGE_SHOW)%>"
                      method="post">
                    </c:when>
                    <c:when test="${currentType==15}">
                    <form id="${searchFormId}" data-toggle="ajaxsearch"
                          action="${root}<%=Url.getUrl(Url.FILES_LIST_OUT_PAGE_SHOW)%>" method="post">
                        </c:when>
                        <c:otherwise>
                        <form id="${searchFormId}" data-toggle="ajaxsearch"
                              action="${root}<%=Url.getUrl(Url.FILES_PAGE_SHOW)%>" method="post">
                            </c:otherwise>
                            </c:choose>
                            <div class="bjui-searchBar">
                                <label for="id" class="control-label"
                                       style="margin-left: 0px; padding-left: 0px; width: 60px;">ID：</label>
                                <input name="id" id="id" placeholder="请输入ID" style="width: 200px;"
                                       value="${searchObj.id}">
                                <label for="name" class="control-label"
                                       style="margin-left: 0px; padding-left: 0px; width: 60px;">文件名称：</label>
                                <input name="name" id="name" placeholder="请输入标题" style="width: 200px;"
                                       value="${searchObj.name}">

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
                                <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询
                                </button>
                                <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                                   data-clear-query="true"
                                   data-icon="undo">清空查询</a>

                                <c:choose>
                                <c:when test="${status!=0}">
                                <div class="pull-right">
                                    <a href="${root}<%=Url.getUrl(Url.FILES_ADD_DETAIL_SHOW)%>?currentType=${currentType}"
                                       data-toggle="dialog" class="btn btn-blue" data-width="600" data-height="400"
                                       data-id="fileAdd" data-title="新增">新增</a>
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
            <th width="70" align="center">文件ID</th>
            <th width="80" align="center">文件名称</th>
            <th width="80" align="center">文件路径(相对路径)</th>
            <th width="90" align="center">文件描述</th>
            <th width="80" align="center">文件大小</th>
            <th width="60" align="center">上传者</th>
            <th width="90" align="center">上传时间</th>
            <th width="80" align="center">排序号</th>
            <th width="60" align="center">状态</th>
            <c:choose>
                <c:when test="${currentType==11||currentType==12||currentType==13||currentType==14||currentType==15}">
                    <th width="60" align="center">同步过来的财物ID</th>
                    <th width="60" align="center">涉案财物ID</th>
                </c:when>
            </c:choose>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <td class="option">
                <a href="${root}<%=Url.getUrl(Url.FILES_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                   data-toggle="dialog" data-mask="true" data-width="600" data-height="500">查看</a>
                <a href="${root}<%=Url.getUrl(Url.FILES_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                   data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                <a href="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?name=${item.name}&path=${item.path}"
                   class="btn btn-green">下载</a>
                <a href="${root}<%=Url.getUrl(Url.FILES_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red"
                   data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
            </td>
            <td><hs:out value="${item.id}" length="5"/></td>
            <td><hs:out value="${item.name}" length="5"/></td>
            <td><hs:out value="${item.path}" length="5"/></td>
            <td align="center"><hs:out value="${item.description}"/></td>
            <td><hs:out value="${item.sizes}"/></td>
            <td align="center"><hs:out value="${item.userName}"/></td>
            <td align="center"><hs:datefmt value="${item.createTime}"
                                           stringDatePatten="dataTimeFormat"/></td>
            <td align="center"><hs:out value="${item.sortCode}"/></td>
            <td align="center">
                <c:choose>
                    <c:when test="${item.status == 1}">
                        正常查询
                    </c:when>
                    <c:when test="${item.status == 2}">
                        仅作模板
                    </c:when>
                    <c:otherwise>
                        状态异常
                    </c:otherwise>
                </c:choose>
            </td>
            <c:choose>
                <c:when test="${currentType==11||currentType==12||currentType==13||currentType==14||currentType==15}">
                    <td align="center"><hs:out value="${item.objId}"/></td>
                    <td align="center"><hs:out value="${item.spoilsId}"/></td>
                </c:when>
            </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>