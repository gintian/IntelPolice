<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.INVESTIGATIONEXPALARM_INFORM_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <input name="parentId" id="parentId" type="hidden">
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
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
               data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<table class="table table-bordered table-hover table-striped table-top data_table table_center"
       data-selected-multi="true">
    <thead>
    <tr class="line_top">
        <th align="center">操作</th>
        <th align="center">执法部门</th>
        <th align="center">可疑异常类型</th>
        <th align="center">可疑发现时间</th>
        <th align="center">案事件编号</th>
        <th align="center">接警单编号</th>
        <th align="center">处警单编号</th>
        <th align="center">反馈单编号</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <tr>
            <td class="option">
                <a href="${root}<%=Url.getUrl(Url.INVESTIGATIONEXPALARM_DETAIL_SHOW)%>?id=${item.exceptionId}"
                   class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                   data-height="500" data-confirm-msg="详情">异常详情</a>
            </td>
            <td title="${item.deptName}"><hs:out value="${item.deptName}" length="10"/></td>
            <td title="${item.exceptionType}"><hs:out value="${item.exceptionType}" length="15"/></td>
            <td><fmt:formatDate value="${item.registerTime}" type="date"/></td>
            <td title="${item.caseId}"><hs:out value="${item.caseId}" length="20"/></td>
            <td title="${item.jjdbh}"><hs:out value="${item.jjdbh}" length="20"/></td>
            <td title="${item.cjdbh}"><hs:out value="${item.cjdbh}" length="20"/></td>
            <td title="${item.fkdbh}"><hs:out value="${item.fkdbh}" length="20"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>