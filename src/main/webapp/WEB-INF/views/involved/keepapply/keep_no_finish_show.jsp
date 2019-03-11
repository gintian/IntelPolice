<!-- 申请保管的财物 -->
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
                              action="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_NO_FINISH_SHOW)%>" method="post">
                            <div class="bjui-searchBar">
                                <input name="cwflCode" id="cwflCode" type="hidden">
                                <label for="taskName" class="control-label">名称：</label>
                                <input name="taskName" id="taskName" placeholder="请输入名称" style="width: 200px;"
                                       value="${searchObj.taskName}">
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
                                <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                                   data-clear-query="true" data-icon="undo">清空查询</a>

                            </div>
                        </form>
                    </div>
                    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
                           data-selected-multi="true" style="font-size:14px;">
                        <thead>
                        <tr class="line_top">
                            <th>操作</th>
                            <th>任务ID</th>
                            <th>任务名称</th>
                            <th>财务编码</th>
                            <th>财务名</th>
                            <th>申请人</th>
                            <th>申请时间</th>
                            <th>批注</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td class="option">
                                    <c:choose>
                                        <c:when test="${item.taskName=='申请保管'}">
                                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_SUBMIT_SHOW)%>?taskId=${item.taskId}&taskName=申请&remark=${item.remark}"
                                               class="btn btn-orange" data-toggle="dialog" data-mask="true" data-width="600"
                                               data-height="500" data-confirm-msg="处理">处理</a>
                                        </c:when>
                                        <c:when test="${item.taskName=='上交财务'}">
                                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_SUBMIT_SHOW)%>?taskId=${item.taskId}&taskName=上交&remark=${item.remark}"
                                               class="btn btn-orange" data-toggle="dialog" data-mask="true" data-width="600"
                                               data-height="500" data-confirm-msg="上交财务">上交财务</a>
                                        </c:when>
                                    </c:choose>
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}"
                                       class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                                       data-height="500">财务详情</a>
                                </td>
                                <td title="${item.taskId}"><hs:out value="${item.taskId}" length="5"/></td>
                                <td title="${item.taskName}"><hs:out value="${item.taskName}"/></td>
                                <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5"/></td>
                                <td title="${item.cwmc}"><hs:out value="${item.cwmc}" length="5"/></td>
                                <td title="${item.identityCard}"><hs:userByIdentityCard value="${item.identityCard}"/></td>
                                <td><hs:datefmt value="${item.startTime}" stringDatePatten="dateTimeFormat"/></td>
                                <td title="${item.remark}"><hs:out value="${item.remark}"/></td>
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