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
    <form action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            <input type="hidden" name="createTime" value="${currentTime}">
            <input type="hidden" name="createUserId" value="${currentUser.id}">
            <input type="hidden" name="state" value="0">
            <input name="storeId" id="involved_storeId" value="${storeId}" type="hidden">
            <input name="lockerId" id="involved_lockerId" value="${lockerId}" type="hidden">
            <label class="row-label" for="involvedStoresBox_boxNo">箱子编号：</label>
            <div class="row-input required">
                <input type="text" id="involvedStoresBox_boxNo" name="boxNo"
                       data-rule="required" maxlength="40" value="${boxNo}"
                       readonly>
            </div>
            <br/>
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    <input name="storeId" id="involved_storeId" value="${entity.storeId}" type="hidden">
                    <input name="lockerId" id="involved_lockerId" value="${entity.lockerId}" type="hidden">
                    <label class="row-label" for="involvedStoresBox_boxNo">箱子编号：</label>
                    <div class="row-input required">
                        <input type="text" id="involvedStoresBox_boxNo" name="boxNo"
                               data-rule="required" maxlength="40" value="${entity.boxNo}"
                               readonly>
                    </div>
                    <br/>
                    </c:otherwise>
                    </c:choose>
                    <label class="row-label" for="userTree_userId">保管员：</label>
                    <div class="row-input required">
                        <input name="userName" id="userTree_userName" readonly
                               data-rule="required" value="<hs:user value='${entity.userId}'/>"
                               type="text">
                        <input name="userId" id="userTree_userId"
                               value="${entity.userId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div>
                    <br/>
                    <label class="row-label" for="involvedStoresBox_length">长：</label>
                    <div class="row-input required">
                        <input type="text" id="involvedStoresBox_length" name="length"
                               data-rule="required" maxlength="40" value="${entity.length}"
                               placeholder="请输入长（阿拉伯数字）">
                    </div>
                    <br/>
                    <label class="row-label" for="involvedStoresBox_width">宽：</label>
                    <div class="row-input required">
                        <input type="text" id="involvedStoresBox_width" name="width"
                               data-rule="required" maxlength="40" value="${entity.width}"
                               placeholder="请输入宽（阿拉伯数字）">
                    </div>
                    <br/>
                    <label class="row-label" for="involvedStoresBox_height">高：</label>
                    <div class="row-input required">
                        <input type="text" id="involvedStoresBox_height" name="height"
                               data-rule="required" maxlength="40" value="${entity.height}"
                               placeholder="请输入高（阿拉伯数字）">
                    </div>
                    <br/>
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
                            data-target="menu01071005" onclick="BJUI.navtab('refresh', 'menu01071005')">保存
                    </button>
                </li>
            </ul>
        </div>