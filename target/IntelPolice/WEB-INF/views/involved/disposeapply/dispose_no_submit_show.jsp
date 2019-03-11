<!-- 未提交处置的财务 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent tableContent">
    <%@ include file="/WEB-INF/views/common/_page_left_involved.jsp" %>
    <div style="overflow:hidden;">
        <div style="overflow:hidden;">
            <fieldset style="height:100%;">
                <div id="layout-01" style="height:94%; overflow:hidden;">
                    <div class="bjui-pageHeader">
                        <form id="${searchFormId}" data-toggle="ajaxsearch"
                              action="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_NO_SUBMIT_SHOW)%>"
                              method="post">
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


                                <div class="pull-right">
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_ADD_SHOW)%>" class="btn btn-blue"
                                       data-toggle="dialog" data-mask="true" data-width="500" data-height="500"
                                       data-title="新增">新增</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
                           data-selected-multi="true" style="font-size:14px;">
                        <thead>
                        <tr class="line_top">
                            <th>操作</th>
                            <th>案事件系统财物序号</th>
                            <th>财物编码</th>
                            <th>财物名称</th>
                            <th>登记时间</th>
                            <th>登记人员</th>
                            <th>财物分类</th>
                            <th>扣押原因</th>
                            <th>财物物主</th>
                            <th>财物备注</th>
                            <th>是否经过保管审批</th>
                            <th>保管到期时间</th>
                            <th>财物是否涉案</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td class="option">
                                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_DISPOSE_TASK_START_SHOW)%>">
                                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_TASK_START_SHOW)%>?involvedId=${item.id}&remark=${item.remark}"
                                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="600"
                                           data-height="500" data-confirm-msg="申请处置">申请处置</a>
                                    </sys:permission>
                                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>">
                                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}"
                                           class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                                           data-height="500" data-confirm-msg="详情">详情</a>
                                    </sys:permission>
                                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SHOW)%>">
                                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SHOW)%>?id=${item.id}"
                                           class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="600"
                                           data-height="500" data-confirm-msg="编辑">编辑</a>
                                    </sys:permission>
                                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_DELETE_SUBMIT)%>">
                                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DELETE_SUBMIT)%>?id=${item.id}"
                                           class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                                    </sys:permission>
                                </td>
                                <td title="${item.objId}"><hs:out value="${item.objId}" length="5"/></td>
                                <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5"/></td>
                                <td title="${item.cwmc}"><hs:out value="${item.cwmc}" length="5"/></td>
                                <td><hs:datefmt value="${item.djsj}" stringDatePatten="dateTimeFormat"/></td>
                                <td title="${item.lrry}"><hs:out value="${item.lrry}" length="5"/></td>
                                <td title="${item.cwflCode}"><hs:out value="${item.cwflCode}" length="5"/></td>
                                <td title="${item.kyyy}"><hs:out value="${item.kyyy}" length="5"/></td>
                                <td title="${item.cwwz}"><hs:out value="${item.cwwz}" length="5"/></td>
                                <td title="${item.bz}"><hs:out value="${item.bz}" length="5"/></td>
                                <td title="${item.isBgsp}"><hs:out value="${item.isBgsp}" length="5"/></td>
                                <td><hs:datefmt value="${item.bgdqsj}" stringDatePatten="dateTimeFormat"/></td>
                                <td title="${item.isSa}"><hs:out value="${item.isSa}" length="5"/></td>
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