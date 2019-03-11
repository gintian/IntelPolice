<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            <input type="hidden" name="addTime" value="${currentTime}">
            <label class="row-label" for="deptTree_deptId">所属机构<span
                    class="required">*</span>：</label>
            <div class="row-input required">
                <input name="deptName" id="deptTree_deptName" readonly data-rule="required"
                       value="<hs:dept value='${currentUser.deptId}'/>" type="text">
                <input name="deptId" id="deptTree_deptId" value="${currentUser.deptId}" type="hidden">
                <a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-icon="search" class="btn btn-blue"
                   data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
            </div>
            <label class="row-label" for="userTree_userId">保管员<span
                    class="required">*</span>：</label>
            <div class="row-input required">
                <input name="userName" id="userTree_userName" readonly data-rule="required"
                       value="<hs:user value='${currentUser.id}'/>" type="text">
                <input name="userId" id="userTree_userId" value="${currentUser.id}" type="hidden">
                <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search" class="btn btn-blue"
                   data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
            </div>
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    <label class="row-label" for="deptTree_deptId">所属机构<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input name="deptName" id="deptTree_deptName" readonly data-rule="required"
                               value="<hs:dept value='${entity.deptId}'/>" type="text">
                        <input name="deptId" id="deptTree_deptId" value="${entity.deptId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div>
                    <label class="row-label" for="userTree_userId">保管员<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input name="userName" id="userTree_userName" readonly data-rule="required"
                               value="<hs:user value='${entity.userId}'/>" type="text">
                        <input name="userId" id="userTree_userId" value="${entity.userId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search" class="btn btn-blue"
                           data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                    </div>
                    </c:otherwise>
                    </c:choose>

                    <label class="row-label" for="archiveStores_name">卷宗柜名称<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input type="text" id="archiveStores_name" name="name"
                               data-rule="required" maxlength="40" value="${entity.name}"
                               placeholder="请输入卷宗柜名称，最多40字">
                    </div>
                    <label class="row-label" for="archiveStores_address">卷宗柜地址：</label>
                    <div class="row-input required">
                        <input type="text" id="archiveStores_address" name="address"
                               data-rule="required" maxlength="40" value="${entity.address}"
                               placeholder="请输入卷宗柜地址，最多40字">
                    </div>
                    <label class="row-label" for="archiveStores_remark">备注：
                    </label>查询
                    <div class="row-input">
                        <input type="text" id="archiveStores_remark" name="remark"
                               maxlength="400" value="${entity.remark}"
                               placeholder="请输入备注，最多40字">
                    </div>
                </div>
            </form>
        </div>
        <div class="bjui-pageFooter">
            <ul>
                <li>
                    <button class="btn-close btn" type="button" data-icon="close">
                        <i class="fa fa-close">取消</i>
                    </button>
                </li>
                <li>
                    <button class="btn btn-success" type="submit" data-icon="save"
                            data-target="menu01090101" onclick="BJUI.navtab('refresh', 'menu01090101')">保存
                    </button>
                </li>
            </ul>
        </div>