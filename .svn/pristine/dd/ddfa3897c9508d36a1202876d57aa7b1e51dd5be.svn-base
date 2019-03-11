
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.DICTORY_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <input name="parentId" id="parentId" type="hidden">
      <label for="name" class="control-label" >名称：</label>
      <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.cwmc}">

      <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
        <i class="fa fa-angle-double-down"></i>
      </button>
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <button type="btn btn-orange reset" class="btn-blue" data-icon="undo">清空查询</button>
    </div>
  </form>
</div>

<div class="bjui-pageContent tableContent">
  <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
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
          <sys:permission url="<%=Url.getUrl(Url.INVOLVED_APPROVE_TASK_SHOW_BY_INVOLVEDID)%>">
            <a href="${root}<%=Url.getUrl(Url.INVOLVED_APPROVE_TASK_SHOW_BY_INVOLVEDID)%>?id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.INVOLVED_APPROVE_TASK_SHOW_BY_INVOLVEDID)%>">
            <a href="${root}<%=Url.getUrl(Url.INVOLVED_APPROVE_TASK_SHOW_BY_INVOLVEDID)%>?id=${item.id}" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">提交申请保管</a>
          </sys:permission>
          <c:choose>
            <c:when  test="${item.taskState == 0}">
              <sys:permission url="<%=Url.getUrl(Url.DICTORY_UPDATE_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.DICTORY_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>
              </sys:permission>
              <sys:permission url="<%=Url.getUrl(Url.DICTORY_DELETE_SUBMIT)%>">
                <a href="${root}<%=Url.getUrl(Url.DICTORY_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
              </sys:permission>
            </c:when>
          </c:choose>
        </td>
        <td title="${item.objId}"><hs:out value="${item.objId}" length="5"/></td>
        <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5"/></td>
        <td title="${item.cwmc}"><hs:out value="${item.cwmc}" length="5"/></td>
        <td ><hs:datefmt value="${item.djsj}" stringDatePatten="dateTimeFormat"/></td>
        <td title="${item.lrry}"><hs:out value="${item.lrry}" length="5" /></td>
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
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
