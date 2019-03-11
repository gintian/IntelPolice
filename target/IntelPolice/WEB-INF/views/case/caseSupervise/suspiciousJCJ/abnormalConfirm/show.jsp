<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent tableContent">
    <%@ include file="/WEB-INF/views/common/_page_left_dept.jsp" %>
    <div style="overflow:hidden;">
        <div style="overflow:hidden;">
            <fieldset style="height:100%;">
                <div id="layout-01" style="height:94%; overflow:hidden;">
                    <div class="bjui-pageHeader">
                        <form id="${searchFormId}" data-toggle="ajaxsearch"
                              action="${root}<%=Url.getUrl(Url.CASE_PAGE_SHOW)%>" method="post">
                            <div class="bjui-searchBar">
                                <label for="caseid" class="control-label"
                                       style="margin-left: 0px; padding-left: 0px; width: 60px;">案事件编号：</label>
                                <input name="caseid" id="caseid" placeholder="请输入案事件编号" style="width: 200px;"
                                       value="${searchObj.caseid}">

                                <button type="button" class="showMoreSearch" data-toggle="moresearch"
                                        data-name="custom">
                                    <i class="fa fa-angle-double-down"></i>
                                </button>
                                <div class="bjui-moreSearch">
                                    <label for="jjdbh" class="control-label"
                                           style="margin-left: 0px; padding-left: 0px; width: 60px;">接警单编号：</label>
                                    <input name="jjdbh" id="jjdbh" placeholder="请输入接警单编号" style="width: 200px;"
                                           value="${searchObj.jjdbh}">
                                    <label for="cjdbh" class="control-label"
                                           style="margin-left: 0px; padding-left: 0px; width: 60px;">处警单编号：</label>
                                    <input name="cjdbh" id="cjdbh" placeholder="请输入处警单编号" style="width: 200px;"
                                           value="${searchObj.cjdbh}"><br/>
                                    <label for="fkdbh" class="control-label"
                                           style="margin-left: 0px; padding-left: 0px; width: 60px;">反馈单编号：</label>
                                    <input name="fkdbh" id="fkdbh" placeholder="请输入编号"
                                           style="width: 200px;" value="${searchObj.fkdbh}">
                                    <label for="deptId" class="control-label"
                                           style="margin-left: 0px; padding-left: 0px; width: 60px;">执法单位：</label>
                                    <input name="deptId" id="deptId" placeholder="请输入编号"
                                           style="width: 200px;" value="${searchObj.deptId}">
                                    <label for="alarmtype" class="control-label"
                                           style="margin-left: 0px; padding-left: 0px; width: 60px;">异常类型：</label>
                                    <input name="alarmtype" id="alarmtype" placeholder="请输入编号"
                                           style="width: 200px;" value="${searchObj.alarmtype}">
                                </div>
                                <button type="submit" class="btn-blue" data-icon="search"
                                        id="query_base_show">查询
                                </button>
                                <a class="btn btn-orange reset" href="javascript:;"
                                   data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
                            </div>
                        </form>
                    </div>

                    <%--<div class="bjui-pageContent tableContent">--%>
                    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
                           data-selected-multi="true">
                        <thead>
                        <tr class="line_top">
                            <th width="50" align="center">操作</th>
                            <th width="100" align="center">执法部门</th>
                            <th width="100" align="center">可疑异常类型</th>
                            <th width="100" align="center">可疑发现时间</th>
                            <th width="100" align="center">案事件编号</th>
                            <th width="100" align="center">接警单编号</th>
                            <th width="100" align="center">处警单编号</th>
                            <th width="100" align="center">反馈单编号</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td class="option" align="center">
                                    <sys:permission url="<%=Url.getUrl(Url.ABNORMAL_CONFIRM_DETAIL_SHOW)%>">
                                        <a href="${root}<%=Url.getUrl(Url.ABNORMAL_CONFIRM_DETAIL_SHOW)%>?caseid=${item.caseid}"
                                           class="btn btn-green" data-toggle="dialog" data-mask="true"
                                           data-width="800" data-height="500">详情</a>
                                    </sys:permission>
                                </td>
                                <td title="${item.caseid}"><hs:out
                                        value="${item.caseid}" length="5"/></td>
                                <td title="${item.casename}"><hs:out
                                        value="${item.casename}"/></td>
                                <td title="${item.casewhid}" align="center"><hs:out
                                        value="${item.casewhid}" length="5"/></td>
                                <td title="${item.caseclass}" align="center"><c:choose>
                                    <c:when test="${item.caseclass == 1}">
                                        接处警
                                    </c:when>
                                    <c:when test="${item.caseclass == 2}">
                                        一般刑事
                                    </c:when>
                                    <c:when test="${item.caseclass == 3}">
                                        经济案件
                                    </c:when>
                                    <c:when test="${item.caseclass == 4}">
                                        毒品案件
                                    </c:when>
                                    <c:when test="${item.caseclass == 5}">
                                        一般刑事
                                    </c:when>
                                    <c:when test="${item.caseclass == 6}">
                                        一般刑事
                                    </c:when>
                                    <c:otherwise>
                                        其他类型
                                    </c:otherwise>
                                </c:choose></td>
                                <td title="${item.caseaddress}"><hs:out
                                        value="${item.caseaddress}"/></td>
                                <td title="${item.casestate}" align="center"><hs:out
                                        value="${item.casestate}"/></td>
                                <td title="${item.casetimestart}" align="center"><hs:datefmt
                                        value="${item.casetimestart}" stringDatePatten="dataTimeFormat"/></td>
                                <td title="${item.casetimeend}" align="center"><hs:datefmt
                                        value="${item.casetimeend}" stringDatePatten="dataTimeFormat"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
                </div>
            </fieldset>
        </div>
    </div>
</div>
