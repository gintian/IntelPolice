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
    <form action="${root}<%=Url.getUrl(Url.FEEDBACK_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post">
        <div class="bjui-row col-2">
            <input type="hidden" name="lookTimes" value="0">
            <input type="hidden" name="processTimes" value="1">
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.FEEDBACK_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input style="padding: 0;border-width: 0;" type="hiiden" name="lookTimes" value="${entity.lookTimes}">
                    <input style="padding: 0;border-width: 0;" type="hiiden" name="processTimes" value="${entity.processTimes}">
                    </c:otherwise>
                    </c:choose>

                    <input type="hidden" name="createUserId" value="${currentUser.id}">
                    <input type="hidden" name="createUserName" value="${currentUser.name}">
                    <input style="padding: 0;border-width: 0;" type="hiiden" name="createTime" value="${currentTime}">
                    <label class="row-label" for="feedback_title">留言标题<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="feedback_title" name="title"
                               data-rule="required" maxlength="40" value="${entity.title}"
                               placeholder="请输入标题，最多40字">
                    </div>
                    <label class="row-label" for="feedback_telephone">联系电话</label>
                    <div class="row-input">
                        <input type="text" id="feedback_telephone" name="telephone"
                               data-rule="mobile" maxlength="40" value="${entity.telephone}"
                               placeholder="请输入联系电话，最多40字">
                    </div>
                    <label class="row-label" for="feedback_address">地址</label>
                    <div class="row-input">
                        <input type="text" id="feedback_address" name="address"
                               data-rule="required" maxlength="40" value="${entity.address}"
                               placeholder="请输入地址，最多40字">
                    </div>
                    <label class="row-label">显示状态</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.status==0}">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="0" checked="checked" data-label="隐藏">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="1" data-label="正常显示">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="2" data-label="置顶">
                            </c:when>
                            <c:when test="${entity.status==2}">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="0" data-label="隐藏">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="1" data-label="正常显示">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="2" checked="checked" data-label="置顶">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="0" data-label="隐藏">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="1" checked="checked" data-label="正常显示">
                                <input type="radio" name="status" id="feedback_status" data-toggle="icheck" value="2" data-label="置顶">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label">业务类型</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.businessType==1}">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="1" checked="checked" data-label="业务一">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="2" data-label="业务二">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="0" data-label="其他业务">
                            </c:when>
                            <c:when test="${entity.businessType==2}">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="1" data-label="业务一">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="2" checked="checked" data-label="业务二">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="0" data-label="其他业务">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="1" data-label="业务一">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="2" data-label="业务二">
                                <input type="radio" name="businessType" id="feedback_businessType" data-toggle="icheck" value="0" checked="checked" data-label="其他业务">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <br>
                    <label class="row-label" for="feedback_content">留言内容<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                <textarea name="content" id="feedback_content" name="content" class="j-content" style="width: 500px;"
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
                            data-target="menu01060402" onclick="BJUI.navtab('refresh', 'menu01060402')">保存
                    </button>
                </li>
            </ul>
        </div>