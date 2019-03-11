<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime",DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.MESSAGE_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post">
        <div class="bjui-row col-3">
            <input type="hidden" name="isVisit" value="0">
            <input type="hidden" name="status" value="1">
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.MESSAGE_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post">
                <div class="bjui-row col-3">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="isVisit" value="${entity.isVisit}">
                    <input type="hidden" name="status" value="${entity.status}">
                </c:otherwise>
                </c:choose>

                    <input type="hidden" name="createUserId" value="${currentUser.id}">
                    <input type="hidden" name="createUserName" value="${currentUser.name}">
                    <input type="hidden" name="createTime" value="${currentTime}">
                    <label class="row-label" for="message_title">消息标题<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="message_title" name="title"
                               data-rule="required" maxlength="40" value="${entity.title}"
                               placeholder="请输入标题，最多40字">
                    </div>
                    <label class="row-label" for="userTree_userId">接收人ID</label>
                    <div class="row-input required">
                        <input name="receiveUserName" id="userTree_userName" readonly data-rule="required"
                               value="<hs:user value='${entity.receiveUserId}'/>" type="text">
                        <input name="receiveUserId" id="userTree_userId" value="${entity.receiveUserId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search" class="btn btn-blue"
                           data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                    </div>
                    <br>
                    <label class="row-label" for="message_content">消息内容<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                <textarea name="content" id="message_content" name="content" class="j-content" style="width: 500px;"
                          data-toggle="kindeditor" data-minheight="80" data-rule="required" maxlength="400">
                    ${entity.content}
                </textarea>
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
                            data-target="menu01060201" onclick="BJUI.navtab('refresh', 'menu01060201')">保存
                    </button>
                </li>
            </ul>
        </div>
