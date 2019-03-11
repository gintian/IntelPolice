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
    <form action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
            <input type="hidden" name="createTime" value="${currentTime}">
            <input type="hidden" name="createUserId" value="${currentUser.id}">
            <label class="row-label" for="involved_storeId">仓库：<span
                    class="required">*</span>：</label>
            <div class="row-input required">
                <input name="storeName" id="involved_storeName" readonly
                       data-rule="required" value="<hs:involvedStores value='${storeId}'/>"
                       type="text">
                <input name="storeId" id="involved_storeId"
                       value="${storeId}" type="hidden">
                <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_TREE_SHOW)%>" data-icon="search"
                   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                   data-title="查询"></a>
            </div>
            <br/>
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    <label class="row-label" for="involved_storeId">仓库：<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input name="storeName" id="involved_storeName" readonly
                               data-rule="required" value="<hs:involvedStores value='${entity.storeId}'/>"
                               type="text">
                        <input name="storeId" id="involved_storeId"
                               value="${entity.storeId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div>
                    <br/>
                    </c:otherwise>
                    </c:choose>
                    <label class="row-label" for="userTree_userId">保管员：<span
                            class="required">*</span>：</label>
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
                    <label class="row-label" for="deptTree_deptId">所属部门：<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input name="deptName" id="deptTree_deptName" readonly
                               data-rule="required" value="<hs:dept value='${entity.deptId}'/>"
                               type="text">
                        <input name="deptId" id="deptTree_deptId"
                               value="${entity.deptId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_type">类型：</label>
                    <div class="row-input required" style="width: 160px">
                        <c:choose>
                            <c:when test="${entity.type==0}">
                                <input type="radio" name="type" id="lockers_type" value="0" data-toggle="icheck"
                                       data-label="普通柜" checked="checked">
                                <input type="radio" name="type" id="lockers_type" value="1" data-toggle="icheck"
                                       data-label="智能柜">
                            </c:when>
                            <c:when test="${entity.type==1}">
                                <input type="radio" name="type" id="lockers_type" value="0" data-toggle="icheck"
                                       data-label="普通柜">
                                <input type="radio" name="type" id="lockers_type" value="1" data-toggle="icheck"
                                       data-label="智能柜" checked="checked">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="type" id="lockers_type" value="0" data-toggle="icheck"
                                       data-label="普通柜">
                                <input type="radio" name="type" id="lockers_type" value="1" data-toggle="icheck"
                                       data-label="智能柜">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_lockerName">储物柜名称<span
                            class="required">*</span>：</label>
                    <div class="row-input required" style="width: 220px">
                        <input type="text" id="lockers_lockerName" name="lockerName"
                               data-rule="required" maxlength="40" value="${entity.lockerName}"
                               placeholder="请输入储物柜名称，最多40字" style="width: 200px">
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_lockerRow">排数：</label>
                    <div class="row-input required" style="width: 75px">
                        <input type="text" id="lockers_lockerRow" name="lockerRow"
                               data-rule="required" maxlength="40" value="${entity.lockerRow}"
                               placeholder="排数" style="width: 50px">
                    </div>
                    <label class="row-label" for="lockers_lockerGate" style="width: 75px">门数：</label>
                    <div class="row-input required" style="width: 75px">
                        <input type="text" id="lockers_lockerGate" name="lockerGate"
                               data-rule="required" maxlength="40" value="${entity.lockerGate}"
                               placeholder="门数" style="width: 50px">
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_postPath">请求地址：</label>
                    <div class="row-input required">
                        <input type="text" id="lockers_postPath" name="postPath"
                               data-rule="required" maxlength="40" value="${entity.postPath}"
                               placeholder="webservice请求地址">
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_host">host端口号：</label>
                    <div class="row-input required">
                        <input type="text" id="lockers_host" name="host"
                               data-rule="required" maxlength="40" value="${entity.host}"
                               placeholder="host端口号">
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_type">是否删除：</label>
                    <div class="row-input required" style="width: 150px">
                        <c:choose>
                            <c:when test="${entity.type==0}">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="0" data-toggle="icheck"
                                       data-label="不删除" checked="checked">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="1" data-toggle="icheck"
                                       data-label="删除">
                            </c:when>
                            <c:when test="${entity.type==1}">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="0" data-toggle="icheck"
                                       data-label="不删除">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="1" data-toggle="icheck"
                                       data-label="删除" checked="checked">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="0" data-toggle="icheck"
                                       data-label="不删除">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="1" data-toggle="icheck"
                                       data-label="删除">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <br/>
                    <label class="row-label" for="lockers_type">集成类型：</label>
                    <div class="row-input required" style="width: 200px">
                        <c:choose>
                            <c:when test="${entity.type==0}">
                                <input type="radio" name="integration" id="lockers_integration" value="1"
                                       data-toggle="icheck" data-label="socket" checked="checked">
                                <input type="radio" name="integration" id="lockers_integration" value="2"
                                       data-toggle="icheck" data-label="webservice">
                            </c:when>
                            <c:when test="${entity.type==1}">
                                <input type="radio" name="integration" id="lockers_integration" value="1"
                                       data-toggle="icheck" data-label="socket">
                                <input type="radio" name="integration" id="lockers_integration" value="2"
                                       data-toggle="icheck" data-label="webservice" checked="checked">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="integration" id="lockers_integration" value="1"
                                       data-toggle="icheck" data-label="socket">
                                <input type="radio" name="integration" id="lockers_integration" value="2"
                                       data-toggle="icheck" data-label="webservice">
                            </c:otherwise>
                        </c:choose>
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
                            data-target="menu01071004" onclick="BJUI.navtab('refresh', 'menu01071004')">保存
                    </button>
                </li>
            </ul>
        </div>