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
    <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            <input type="hidden" name="addTime" value="${currentTime}">
                <input name="archiveStoresId" id="archive_storesId" value="${storesId}" type="hidden">
        </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    </c:otherwise>
                    </c:choose>

                    <input type="hidden" name="userId" value="${currentUser.id}">

                    <label class="row-label" for="archiveStoresBox_num">箱号：</label>
                    <div class="row-input required">
                        <input type="hidden"  value="${entity.code == null ? code : entity.code}" name="code">
                        <input type="text" id="archiveStoresBox_num"
                               data-rule="required" maxlength="40" value="${entity.code == null ? code : entity.code}" disabled >
                    </div><br/>
                    <%--<label class="row-label" for="archiveStoresBox_code">箱编码：</label>
                    <div class="row-input required">
                        <input type="text" id="archiveStoresBox_code"
                               data-rule="required" maxlength="40" value="" >
                    </div><br/>--%>
                    <label class="row-label" for="userTree_userId">使用者：</label>
                    <div class="row-input required">
                        <input  id="userTree_userName" readonly
                                data-rule="required" value="<hs:user value='${entity.boxUser}'/>"
                                type="text">
                        <input name="boxUser" id="userTree_userId"
                               value="${entity.boxUser}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div><br>
                    <label class="row-label" for="archiveStoresBox_remark">备注：
                    </label>
                    <div class="row-input">
                        <input type="text" id="archiveStoresBox_remark" name="remark"
                               maxlength="40" value="${entity.remark}"
                               placeholder="请输入备注，最多40字" style="width: 200px">
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
                            data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">保存
                    </button>
                </li>
            </ul>
        </div>