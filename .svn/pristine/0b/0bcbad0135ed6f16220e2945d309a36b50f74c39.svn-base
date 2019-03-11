<!-- 已通过保管的财物 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent tableContent">
    <div style="overflow:hidden;">
        <div style="overflow:hidden;">
            <fieldset style="height:100%;">
                <div id="layout-01" style="height:94%; overflow:hidden;">
                    <div class="bjui-pageHeader">
                        <form id="${searchFormId}" data-toggle="ajaxsearch"
                              action="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_FINISHED_SHOW)%>" method="post">
                            <div class="bjui-searchBar">
                                <input name="cwflCode" id="cwflCode" type="hidden">
                                <label for="name" class="control-label">名称：</label>
                                <input name="name" id="name" placeholder="请输入名称" style="width: 200px;"
                                       value="${searchObj.cwmc}">
                                <button type="button" class="showMoreSearch" data-toggle="moresearch"
                                        data-name="custom">
                                    <i class="fa fa-angle-double-down"></i>
                                </button>
                                <%-- <div class="bjui-moreSearch">
                                   <label for="media_jlsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">记录时间：</label>
                                   <input type="text" id="media_jlsj" name="jlsj" data-rule="required"
                                          data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                                          value="<hs:datefmt value="${searchObj.jlsj}" type="dateTimeSecPattern"/>" />
                                   <label for="media_dqsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">到期时间：</label>
                                   <input type="text" id="media_dqsj" name="dqsj" data-rule="required"
                                          data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                                          value="<hs:datefmt value="${searchObj.dqsj}" type="dateTimeSecPattern"/>" />
                                 </div>--%>
                                <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询
                                </button>
                                <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch"
                                   data-clear-query="true" data-icon="undo">清空查询</a>

                            </div>
                        </form>
                    </div>
                    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
                           data-selected-multi="true" style="font-size:14px;">
                        <thead>
                        <tr class="line_top">
                            <th>操作</th>
                            <th>流程ID</th>
                            <th>流程名</th>
                            <th>财务编码</th>
                            <th>财务名称</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td class="option">
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}&remark=${item.remark}"
                                       class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                                       data-height="500" data-confirm-msg="财务详情">财务详情</a>
                                </td>
                                <td title="${item.processId}"><hs:out value="${item.processId}"/></td>
                                <td title="${item.processName}"><hs:out value="${item.processName}"/></td>
                                <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="10"/></td>
                                <td title="${item.cwmc}"><hs:out value="${item.cwmc}" length="10"/></td>
                                <td><hs:datefmt value="${item.startTime}" stringDatePatten="dateTimeFormat"/></td>
                                <c:choose>
                                    <c:when test="${item.endTime==null}">
                                        <td title="${item.endTime}"><hs:out value="未结束，当前任务：${item.taskName}"/></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><hs:datefmt value="${item.endTime}" stringDatePatten="dateTimeFormat"/></td>
                                    </c:otherwise>
                                </c:choose>
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