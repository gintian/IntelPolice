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
    <form action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            <input type="hidden" name="createTime" value="${currentTime}">
            <input type="hidden" name="createUserId" value="${currentUser.id}">
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    </c:otherwise>
                    </c:choose>

                    <label class="row-label" for="involvedStores_name">仓库名称：</label>
                    <div class="row-input required">
                        <input type="text" id="involvedStores_name" name="name"
                               data-rule="required" maxlength="40" value="${entity.name}"
                               placeholder="请输入仓库名称，最多40字">
                    </div>
                    <br/>
                    <label class="row-label" for="involvedStores_location">仓库地址：</label>
                    <div class="row-input required">
                        <input type="text" id="involvedStores_location" name="location"
                               data-rule="required" maxlength="40" value="${entity.location}"
                               placeholder="请输入仓库地址，最多40字">
                    </div>
                    <br/>
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
                    <label class="row-label" for="involvedStores_sortCode">排序号：</label>
                    <div class="row-input">
                        <input type="text" id="involvedStores_sortCode" name="sortCode"
                               maxlength="400" value="${entity.sortCode}"
                               placeholder="请输入排序号，最多40字">
                    </div>
                    <br/>
                    <label class="row-label" for="involvedStores_remark">备注：</label>
                    <div class="row-input">
                        <input type="text" id="involvedStores_remark" name="remark"
                               maxlength="400" value="${entity.remark}"
                               placeholder="请输入备注，最多40字">
                    </div>
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
                    data-target="menu01071003" onclick="BJUI.navtab('refresh', 'menu01071003')">保存
            </button>
        </li>
    </ul>
</div>