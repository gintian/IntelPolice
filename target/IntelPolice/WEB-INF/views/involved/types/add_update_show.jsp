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
    <form action="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_ADD_SUBMIT)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
        <div class="bjui-row col-2">
            <input type="hidden" name="userid" value="${currentUser.id}">
            <input type="hidden" name="createtime" value="${currentTime}">
            <label class="row-label" for="typeName">类别父类：</label>
            <div class="row-input">
                <input name="parentname" id="typeName" readonly  value="<hs:involvedType value=''/>"  type="text">
                <input name="parentid" id="typeId" value="" type="hidden">
                <a href="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_TREE_SHOW)%>" data-icon="search" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
            </div>
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_UPDATE_SUBMIT)%>" data-toggle="validate"
                  data-reload-navtab="true" method="post">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <label class="row-label" for="typeName">类别父类：</label>
                    <div class="row-input">
                        <input name="parentname" id="typeName" readonly value="<hs:involvedType value='${entity.parentid}'/>"  type="text">
                        <input name="parentid" id="typeId" value="${entity.parentid}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_TYPES_TREE_SHOW)%>" data-icon="search" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                    </div>
                    </c:otherwise>
                    </c:choose>

                    <label class="row-label" for="name">类别名称</label>
                    <div class="row-input required">
                        <input type="text" id="name" name="name" data-rule="required" maxlength="50"
                               value="${entity.name}" placeholder="请输入类别名称，最多50字">
                    </div>
                    <%--<label class="row-label" for="code">编号</label>--%>
                    <%--<div class="row-input required">--%>
                        <%--<input type="text" id="code" name="code" data-rule="required" maxlength="50"--%>
                               <%--value="${entity.code}" placeholder="请输入三位数类别编号">--%>
                    <%--</div>--%>
                    <label class="row-label" for="sortcode">排序号</label>
                    <div class="row-input">
                        <input type="text" id="sortcode" name="sortcode" maxlength="10"
                               value="${entity.sortcode}" placeholder="请输入三位数排序号">
                    </div>
                    <label class="row-label" for="remark">备注</label>
                    <div class="row-input">
                        <input type="text" id="remark" name="remark" maxlength="50"
                               value="${entity.remark}" placeholder="请输入备注">
                    </div>
                    <label class="row-label" for="isinvolved">是否涉案</label>
                    <div class="row-input">
                        <c:choose>
                            <c:when test="${entity.isinvolved=='0'}">
                                <input type="radio" name="isinvolved" id="isinvolved" data-toggle="icheck"
                                       value="0" checked="checked" data-label="否">
                                <input type="radio" name="isinvolved" id="isinvolved" data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:when>
                            <c:when test="${entity.isinvolved=='1'}">
                                <input type="radio" name="isinvolved" id="isinvolved" data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isinvolved" id="isinvolved" data-toggle="icheck"
                                       value="1" checked="checked" data-label="是">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="isinvolved" id="isinvolved" data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isinvolved" id="isinvolved" data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="state">类别状态</label>
                    <div class="row-input">
                        <c:choose>
                            <%--<c:when test="${entity.state=='01'}">--%>
                                <%--<input type="radio" name="state" id="state" data-toggle="icheck"--%>
                                       <%--value="01" checked="checked" data-label="正常使用">--%>
                                <%--<input type="radio" name="state" id="state" data-toggle="icheck"--%>
                                       <%--value="02" data-label="弃用">--%>
                            <%--</c:when>--%>
                            <c:when test="${entity.state=='02'}">
                                <input type="radio" name="state" id="state" data-toggle="icheck"
                                       value="01" data-label="正常使用">
                                <input type="radio" name="state" id="state" data-toggle="icheck"
                                       value="02" checked="checked" data-label="弃用">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="state" id="state" data-toggle="icheck"
                                       value="01" checked="checked" data-label="正常使用">
                                <input type="radio" name="state" id="state" data-toggle="icheck"
                                       value="02" data-label="弃用">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="maxmoney">本单位自行处理的最大限额</label>
                    <div class="row-input">
                        <input type="text" id="maxmoney" name="maxmoney" maxlength="25"
                               value="${entity.maxmoney}" placeholder="请输入最大限额">
                    </div>
                    <label class="row-label" for="isinvolved">是否必须有上级审批</label>
                    <div class="row-input">
                        <c:choose>
                            <c:when test="${entity.issuperexamine=='0'}">
                                <input type="radio" name="issuperexamine" id="issuperexamine"
                                       data-toggle="icheck"
                                       value="0" checked="checked" data-label="否">
                                <input type="radio" name="issuperexamine" id="issuperexamine"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:when>
                            <c:when test="${entity.issuperexamine=='1'}">
                                <input type="radio" name="issuperexamine" id="issuperexamine"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="issuperexamine" id="issuperexamine"
                                       data-toggle="icheck"
                                       value="1" checked="checked" data-label="是">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="issuperexamine" id="issuperexamine"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="issuperexamine" id="issuperexamine"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="isprocessdirect">特殊物品本单位是否可以直接处理</label>
                    <div class="row-input">
                        <c:choose>
                            <c:when test="${entity.isprocessdirect=='0'}">
                                <input type="radio" name="isprocessdirect" id="isprocessdirect"
                                       data-toggle="icheck"
                                       value="0" checked="checked" data-label="否">
                                <input type="radio" name="isprocessdirect" id="isprocessdirect"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:when>
                            <c:when test="${entity.isprocessdirect=='1'}">
                                <input type="radio" name="isprocessdirect" id="isprocessdirect"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isprocessdirect" id="isprocessdirect"
                                       data-toggle="icheck"
                                       value="1" checked="checked" data-label="是">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="isprocessdirect" id="isprocessdirect"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isprocessdirect" id="isprocessdirect"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="keepunit">必须交保管的单位</label>
                    <div class="row-input">
                        <input type="text" id="keepunit" name="keepunit" maxlength="25"
                               value="${entity.keepunit}" placeholder="请输入单位">
                    </div>
                    <label class="row-label" for="isprocessbykeepunit">是否可由保管单位自行处理</label>
                    <div class="row-input">
                        <c:choose>
                            <c:when test="${entity.isprocessbykeepunit=='0'}">
                                <input type="radio" name="isprocessbykeepunit" id="isprocessbykeepunit"
                                       data-toggle="icheck"
                                       value="0" checked="checked" data-label="否">
                                <input type="radio" name="isprocessbykeepunit" id="isprocessbykeepunit"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:when>
                            <c:when test="${entity.isprocessbykeepunit=='1'}">
                                <input type="radio" name="isprocessbykeepunit" id="isprocessbykeepunit"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isprocessbykeepunit" id="isprocessbykeepunit"
                                       data-toggle="icheck"
                                       value="1" checked="checked" data-label="是">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="isprocessbykeepunit" id="isprocessbykeepunit"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isprocessbykeepunit" id="isprocessbykeepunit"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <label class="row-label" for="isappointkeepunit">是否指定专门单位保管</label>
                    <div class="row-input">
                        <c:choose>
                            <c:when test="${entity.isappointkeepunit=='0'}">
                                <input type="radio" name="isappointkeepunit" id="isappointkeepunit"
                                       data-toggle="icheck"
                                       value="0" checked="checked" data-label="否">
                                <input type="radio" name="isappointkeepunit" id="isappointkeepunit"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
                            </c:when>
                            <c:when test="${entity.isappointkeepunit=='1'}">
                                <input type="radio" name="isappointkeepunit" id="isappointkeepunit"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isappointkeepunit" id="isappointkeepunit"
                                       data-toggle="icheck"
                                       value="1" checked="checked" data-label="是">
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="isappointkeepunit" id="isappointkeepunit"
                                       data-toggle="icheck"
                                       value="0" data-label="否">
                                <input type="radio" name="isappointkeepunit" id="isappointkeepunit"
                                       data-toggle="icheck"
                                       value="1" data-label="是">
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
                            data-target="menu01090101" onclick="BJUI.navtab('refresh', 'menu01071006')">保存
                    </button>
                </li>
            </ul>
        </div>
    </form>