
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_NEXT_TASK_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
     
      <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
        <i class="fa fa-angle-double-down"></i>
      </button>
    <%--  <div class="bjui-moreSearch">
      </div>--%>
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <a class="btn btn-orange reset" href="javascript:;"
         data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
      <div class="pull-right">
        <sys:permission url="<%=Url.getUrl(Url.DATA_SYNCTASK_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="新增">新增</a>
        </sys:permission>
      </div>
    </div>
  </form>
</div>
<div class="bjui-pageContent tableContent">
  <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
    <thead>
    <tr class="line_top">
      <th>操作</th>
      <th>模块名称</th>
      <th>模块值</th>
      <th>开始执行时间</th>
      <th>同步类型</th>
      <th>数据库同步开始日期</th>
      <th>数据库同步结束日期</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option">
          <sys:permission url="<%=Url.getUrl(Url.DATA_SYNCTASK_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_DETAIL_SHOW)%>?Id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.DATA_SYNCTASK_UPDATE_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_UPDATE_SHOW)%>?Id=${item.id}" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="修改">修改</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.DATA_SYNCTASK_DELETE_SUBMIT)%>">
            <a href="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_DELETE_SUBMIT)%>?Id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
          </sys:permission>
        </td>
        <td title="${item.synclable}"><hs:out value="${item.synclable}" length="5"/></td>
        <td title="${item.syncvalue}">
          <hs:out value="${item.syncvalue}" length="10"/>
        </td>
        <td title="${item.syncdate}">
          <hs:datefmt value="${item.syncdate}" type="date"/>
        </td>
        <td>
          <c:choose>
            <c:when  test="${item.synctype == 0}">
              自动同步
            </c:when>
            <c:when  test="${item.synctype == 1}">
              手动同步
            </c:when>
          </c:choose>
        </td>
        <td>
          <hs:datefmt value="${item.datestarttime}" type="date"/>
        </td>
        <td>
          <hs:datefmt value="${item.dataendtime}" type="date"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
