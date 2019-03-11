
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
    <c:choose>
        <c:when test="${empty entity or empty entity.id}">
                <form action="${root}<%=Url.getUrl(Url.RECORD_QUESTION_ADD_SUBMIT)%>"
                     data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                    <input type="hidden" name="addTime" value="${currentTime}">
         </c:when>
     <c:otherwise>
                <form action="${root}<%=Url.getUrl(Url.RECORD_QUESTION_UPDATE_SUBMIT)%>"
                      data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                        <input type="hidden" name="id" value="${entity.id}">
                        <input type="hidden" name="modifyTime" value="${currentTime}">
     </c:otherwise>
     </c:choose>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <label for="content" class="control-label" >问题内容：</label>
                                <textarea name="content" style="height: 150px;width: 350px;/*resize: none;*/" class="form-control" placeholder="500字以内"  id="content"  maxlength="150" type="text">${entity.content}</textarea>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-body">
                                <label for="type" class="control-label" >问题类型：</label>
                                <select id="type"  class="form-control text-center" data-toggle="selectpicker" name="type" data-val="${entity.caseType}" data-width="200">
                                    <option value="0"  ${"0" eq entity.type ? "selected" : ""} >询问</option>
                                    <option value="1"  ${"1" eq entity.type ? "selected" : ""} >讯问</option>
                                    <option value="2"  ${"2" eq entity.type ? "selected" : ""} >辩论</option>
                                </select>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <label for="caseclass" class="control-label" >案件类型：</label>
                                <select id="caseclass" data-toggle="selectpicker" name="caseType" data-val="${entity.caseType}" data-width="200">
                                    <c:forEach var="item" items="${codeBeanList}">
                                        <option value="${item.code}"  ${item.code eq entity.caseType ? "selected" : ""} >${item.codedesc}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="btn-primary" type="submit" data-icon="save"
                                data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">保存
                        </button>
                    </div>
                </form>
<div class="bjui-pageFooter" >
    <ul style="margin-right: 15px">
        <li>
            <button class="btn-close btn" type="button" data-icon="close">
                <i class="fa fa-close">取消</i>
            </button>
        </li>
       <%-- <li>
            <button class="btn-primary" type="submit" data-icon="save"
                    data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">保存
            </button>
        </li>--%>
    </ul>
</div>