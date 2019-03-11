
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.DICTORY_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">标签名：</label>
      <input name="label" id="label" placeholder="请输入标签名" style="width: 200px;" value="${searchObj.label}">
      <label class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">父类id：</label>
      <input name="parentId"  placeholder="请输入父类id" style="width: 200px;" value="${searchObj.parentId}">

      <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
        <i class="fa fa-angle-double-down"></i>
      </button>
      <div class="bjui-moreSearch">
        <label class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">id：</label>
        <input name="id"  placeholder="请输入id" style="width: 200px;" value="${searchObj.id}">
      </div>
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <a class="btn btn-orange reset" href="javascript:;"
         data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

      <div class="pull-right">
        <sys:permission url="<%=Url.getUrl(Url.DICTORY_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.DICTORY_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="新增">新增</a>
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
      <th>id</th>
      <th>标签名</th>
      <th>标签值</th>
      <th>类型</th>
      <th>父类id</th>
      <th>描述</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option">
          <sys:permission url="<%=Url.getUrl(Url.DICTORY_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.DICTORY_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>
          <c:choose>
            <c:when  test="${item.changeInd == 0}">
              <sys:permission url="<%=Url.getUrl(Url.DICTORY_UPDATE_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.DICTORY_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>

              </sys:permission>
              <sys:permission url="<%=Url.getUrl(Url.DICTORY_DELETE_SUBMIT)%>">
                <a href="${root}<%=Url.getUrl(Url.DICTORY_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
              </sys:permission>
            </c:when>
          </c:choose>
        </td>
        <td title="${item.id}"><hs:out value="${item.id}"/></td>
        <td title="${item.label}"><hs:out value="${item.label}"/></td>
        <td title="${item.value}"><hs:out value="${item.value}" length="40"/></td>
        <td title="${item.type}"><hs:out value="${item.type}" length="5"/></td>
        <td title="${item.parentId}">${item.parentId}</td>
        <td title="${item.descp}"><hs:out value="${item.descp}" length="20"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
