<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
    request.setAttribute("caseid", request.getParameter("caseid"));
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            <input type="hidden" name="addTime" value="${currentTime}">
            <input type="hidden" name="caseid" value="${caseid}">
        </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    </c:otherwise>
                    </c:choose>

                    <input type="hidden" name="userId" value="${currentUser.id}">
                    <input type="hidden" name="userName" value="${currentUser.name}">

                    <label class="row-label" for="archive_name">卷宗名称<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="archive_name" name="name"
                               data-rule="required" maxlength="40" value="${entity.name}"
                               placeholder="请输入卷宗名称，最多40字">
                    </div>
                    <label class="row-label">卷宗类型</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.type == 0}">
                                <input type="radio" name="type" id="archive_type" data-toggle="icheck"
                                       data-rule="required" value="0" checked="checked" data-label="电子卷宗">
                                <input type="radio" name="type" id="archive_type" data-toggle="icheck"
                                       data-rule="required" value="1" data-label="实体卷宗">
                            </c:when>
                            <c:when test="${entity.type == 1}">
                                <input type="radio" name="type" id="archive_type" data-toggle="icheck"
                                       data-rule="required" value="0" data-label="电子卷宗">
                                <input type="radio" name="type" id="archive_type" data-toggle="icheck"
                                       data-rule="required" value="1" checked="checked" data-label="实体卷宗">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="type" id="archive_status" data-toggle="icheck"
                                       data-rule="required" value="0" data-label="电子卷宗">
                                <input type="radio" name="type" id="archive_status" data-toggle="icheck"
                                       data-rule="required" value="1" data-label="实体卷宗">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="archive_code">卷宗编号：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="archive_code" name="code"
                               data-rule="required" maxlength="40" value="${entity.code}"
                               placeholder="请输入卷宗编号，最多40字">
                    </div>
                    <label class="row-label">卷宗分类</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.businessType==1}">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="1" checked="checked" data-label="类型一">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="2" data-label="类型二">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="0" data-label="其他类型">
                            </c:when>
                            <c:when test="${entity.businessType==2}">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="1" data-label="类型一">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="2" checked="checked" data-label="类型二">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="0" data-label="其他类型">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="1" data-label="类型一">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="2" data-label="类型二">
                                <input type="radio" name="businessType" id="archive_businessType" data-toggle="icheck"
                                       value="0" checked="checked" data-label="其他类型">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="archive_num">卷宗数量：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="archive_num" name="num"
                               data-rule="required" maxlength="40" value="${entity.num}"
                               placeholder="请输入卷宗数量，最多40字">
                    </div>
                    <label class="row-label" for="archive_remark">备注：
                    </label>
                    <div class="row-input">
                        <input type="text" id="archive_remark" name="remark"
                               maxlength="400" value="${entity.remark}"
                               placeholder="请输入备注，最多400字">
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