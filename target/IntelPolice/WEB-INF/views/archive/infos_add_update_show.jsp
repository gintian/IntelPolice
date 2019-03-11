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
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-3">
                    <input type="hidden" name="addTime" value="${currentTime}">
                    <input type="hidden" name="caseid" value="${caseid}">
        </c:when>
        <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-3">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="caseid" value="${entity.id}">
        </c:otherwise>
    </c:choose>
                    <label class="row-label" for="archive_archiveName">卷宗名称：</label>
                    <div class="row-input required" style="width: 220px">
                        <input type="text" id="archive_archiveName" name="name"
                               data-rule="required" maxlength="40" value="${entity.name}"
                               placeholder="请输入名称，最多40字" style="width: 200px">
                    </div><br><br>
                    <label class="row-label" for="lockers_type">类型：</label>
                    <div class="row-input required" style="width: 160px">
                        <select class="form-control" id="lockers_type" name="type">
                            <option value="0" ${entity.type eq 0 ? "selected" : "" }>电子卷宗</option>
                            <option value="1" ${entity.type eq 1 ? "selected" : "" }>实体卷宗</option>
                        </select></div><br>
                    <label class="row-label" for="archive_archiveCode">卷宗编号：</label>
                    <div class="row-input required" style="width: 220px">
                        <input type="text" id="archive_archiveCode" name="code"
                               data-rule="required" maxlength="40" value="${entity.code}"
                               placeholder="请输入编号，最多40字" style="width: 200px">
                    </div><br>
<%--                    <label class="row-label" for="archive_archiveBusinessType">卷宗分类：</label>
                    <div class="row-input required" style="width: 160px">
                        <select class="form-control" id="archive_archiveBusinessType" name="businessType">
                            <option value="0" ${entity.businessType eq 0 ? "selected" : "" }>类型一</option>
                            <option value="1" ${entity.businessType eq 1 ? "selected" : "" }>类型二</option>
                        </select>
                    </div><br>--%>
                    <label class="row-label" for="archive_archiveNum">卷宗数量：</label>
                    <div class="row-input required" style="width: 220px">
                        <input type="number" min="0" max="99" id="archive_archiveNum" name="num"
                               data-rule="required" maxlength="40" value="${entity.num}"
                               placeholder="0-99" style="width: 200px">
                    </div><br>
                    <label class="row-label" for="archive_archiveNum">备注：</label>
                    <div class="row-input">
                        <input type="text" id="archive_archiveRemark" name="remark"
                               maxlength="40" value="${entity.remark}"
                               placeholder="请输入备注，最多40字" style="width: 200px">
                    </div><br>
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
                    <button class="btn-default" type="submit" data-icon="save"
                            data-target="menu01071004" onclick="BJUI.navtab('refresh', 'menu01071004')">保存
                    </button>
                </li>
            </ul>
        </div>
