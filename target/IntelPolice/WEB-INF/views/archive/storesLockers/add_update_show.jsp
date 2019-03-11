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
    <c:when test="${empty entity or empty entity.lockersId}">
    <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-3">
            <input type="hidden" name="createTime" value="${currentTime}">
            <input type="hidden" name="createUserId" value="${currentUser.id}">
            <label class="row-label" for="archive_storesId">仓库<span
                    class="required">*</span>：</label>
            <div class="row-input required">
                <input  id="archive_storesName" readonly
                       data-rule="required" value="<hs:archiveStores value='${storeId}'/>"
                       type="text">
                <input name="storeId" id="archive_storesId"
                       value="${storeId}" type="hidden">
                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_TREE_SHOW)%>" data-icon="search"
                   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                   data-title="查询"></a>
            </div><br>
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_LOCKERS_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-3">
                    <input type="hidden" name="lockersId" value="${entity.lockersId}">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    <label class="row-label" for="archive_storesId">仓库<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input  id="archive_storesName" readonly
                               data-rule="required" value="<hs:archiveStores value='${entity.storeId}'/>"
                               type="text">
                        <input name="storeId" id="archive_storesId"
                               value="${entity.storeId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div><br>
                    </c:otherwise>
                    </c:choose>
                    <label class="row-label" for="userTree_userId">保管员<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input  id="userTree_userName" readonly
                               data-rule="required" value="<hs:user value='${entity.userId}'/>"
                               type="text">
                        <input name="userId" id="userTree_userId"
                               value="${entity.userId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div><br>
                    <label class="row-label" for="deptTree_deptId">所属部门<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input  id="deptTree_deptName" readonly
                               data-rule="required" value="<hs:dept value='${entity.userId}'/>"
                               type="text">
                        <input name="deptId" id="deptTree_deptId"
                               value="${entity.userId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                           data-title="查询"></a>
                    </div><br>
                    <label class="row-label" for="lockers_type">类型<span class="required"></span>：</label>
                    <div class="row-input required">
                        <select id="lockers_type" name="type">
                            <option value="1" ${entity.type eq 1 ? "selected" : "" }>智能保管柜</option>
                            <option value="2" ${entity.type eq 2 ? "selected" : "" }>普通保管柜</option>
                            <option value="3" ${entity.type eq 3 ? "selected" : "" }>恒温保管柜</option>
                            <option value="4" ${entity.type eq 4 ? "selected" : "" }>保险柜</option>
                            <option value="5" ${entity.type eq 5 ? "selected" : "" }>货架</option>
                        </select>
                    </div><br>
                    <label class="row-label" for="lockers_lockerName">储物柜名称<span
                            class="required">*</span>：</label>
                    <div class="row-input required">
                        <input type="text" id="lockers_lockerName" name="lockersName"
                               data-rule="required" maxlength="40" value="${entity.lockersName}"
                               placeholder="请输入储物柜名称，最多40字">
                    </div><br>
                    <label class="row-label" for="lockers_lockerGate">门数<span class="required"></span>：</label>
                    <div class="row-input required">
                        <input type="text" id="lockers_lockerGate" name="lockerGate"
                               data-rule="required" maxlength="40" value="${entity.lockerGate}"
                               placeholder="门数">
                    </div><br>
                    <label class="row-label" for="lockers_postPath">请求地址<span class="required"></span>：</label>
                    <div class="row-input required">
                        <input type="text" id="lockers_postPath" name="postPath"
                               data-rule="required" maxlength="40" value="${entity.postPath}"
                               placeholder="webservice请求地址">
                    </div><br>
                    <label class="row-label" for="lockers_host">host端口号<span class="required"></span>：</label>
                    <div class="row-input required">
                        <input type="text" id="lockers_host" name="host"
                               data-rule="required" maxlength="40" value="${entity.host}"
                               placeholder="host端口号">
                    </div><br>
                    <label class="row-label" for="lockers_type">是否删除<span class="required"></span>：</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.type==0}">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="0" data-toggle="icheck"
                                       data-label="不删除" checked="checked">
                                <input type="radio" name="isDelete" id="lockers_isDelete1" value="1" data-toggle="icheck"
                                       data-label="删除">
                            </c:when>
                            <c:when test="${entity.type==1}">
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="0" data-toggle="icheck"
                                       data-label="不删除">
                                <input type="radio" name="isDelete" id="lockers_isDelete1" value="1" data-toggle="icheck"
                                       data-label="删除" checked="checked">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="isDelete" id="lockers_isDelete" value="0" data-toggle="icheck"
                                       data-label="不删除">
                                <input type="radio" name="isDelete" id="lockers_isDelete1" value="1" data-toggle="icheck"
                                       data-label="删除">
                            </c:otherwise>
                        </c:choose>
                    </div><br>
                    <label class="row-label" for="lockers_type">集成类型<span class="required"></span>：</label>
                    <div class="row-input required">
                        <c:choose>
                            <c:when test="${entity.type==0}">
                                <input type="radio" name="integration" id="lockers_integration" value="1"
                                       data-toggle="icheck" data-label="socket" checked="checked">
                                <input type="radio" name="integration" id="lockers_integration1" value="2"
                                       data-toggle="icheck" data-label="webservice">
                            </c:when>
                            <c:when test="${entity.type==1}">
                                <input type="radio" name="integration" id="lockers_integration" value="1"
                                       data-toggle="icheck" data-label="socket">
                                <input type="radio" name="integration" id="lockers_integration1" value="2"
                                       data-toggle="icheck" data-label="webservice" checked="checked">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="integration" id="lockers_integration" value="1"
                                       data-toggle="icheck" data-label="socket">
                                <input type="radio" name="integration" id="lockers_integration1" value="2"
                                       data-toggle="icheck" data-label="webservice">
                            </c:otherwise>
                        </c:choose>
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