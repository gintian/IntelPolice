<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%@ page import="com.model.Dept" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentDept", (Dept) session.getAttribute(SessionKey.DEPT));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.NOTICE_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.NOTICE_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    </c:otherwise>
                    </c:choose>

                    <input type="hidden" name="userId" value="${currentUser.id}">
                    <input type="hidden" name="userName" value="${currentUser.name}">
                    <input type="hidden" name="unitCode" value="${currentUser.deptId}">
                    <input type="hidden" name="unitName" value="${currentDept.name}">
                    <input type="hidden" name="createTime" value="${currentTime}">
                    <input type="hidden" name="gxfw" value="0">
                    <label class="row-label" for="notice_title">公告标题<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="notice_title" name="title"
                               data-rule="required" maxlength="40" value="${entity.title}"
                               placeholder="请输入标题，最多40字">
                    </div>
                    <label class="row-label">显示状态</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.status==0}">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="0" checked="checked" data-label="隐藏">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="1" data-label="正常显示">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="2" data-label="置顶">
                            </c:when>
                            <c:when test="${entity.status==2}">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="0" data-label="隐藏">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="1" data-label="正常显示">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="2" checked="checked" data-label="置顶">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="0" data-label="隐藏">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="1" checked="checked" data-label="正常显示">
                                <input type="radio" name="status" id="notice_status" data-toggle="icheck"
                                       data-rule="required" value="2" data-label="置顶">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label">业务类型</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.businessType==1}">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="1" checked="checked" data-label="业务一">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="2" data-label="业务二">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="0" data-label="其他业务">
                            </c:when>
                            <c:when test="${entity.businessType==2}">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="1" data-label="业务一">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="2" checked="checked" data-label="业务二">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="0" data-label="其他业务">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="1" data-label="业务一">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="2" data-label="业务二">
                                <input type="radio" name="businessType" id="notice_businessType" data-toggle="icheck"
                                       value="0" checked="checked" data-label="其他业务">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <br>
                    <label class="row-label" for="notice_content">公告内容<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                <textarea name="content" id="notice_content" name="content" class="j-content" style="width: 500px;"
                          data-toggle="kindeditor" data-minheight="100" data-rule="required" maxlength="400">
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
                            data-target="menu01060302" onclick="BJUI.navtab('refresh', 'menu01060302')">保存
                    </button>
                </li>
            </ul>
        </div>