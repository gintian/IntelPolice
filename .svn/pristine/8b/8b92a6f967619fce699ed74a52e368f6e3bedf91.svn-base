
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.CODE_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">对照字段：</label>
      <input name="field" id="label"  placeholder="请输入对照字段" style="width: 200px;" value="${searchObj.field}">
      <label class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">对照字段名称：</label>
      <input name="fieldname" placeholder="请输入对照字段名称" style="width: 200px;" value="${searchObj.fieldname}">

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
        <sys:permission url="<%=Url.getUrl(Url.CODE_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.CODE_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="新增">新增</a>
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
      <th>ID</th>
      <th>对照字段</th>
      <th>对照字段名称</th>
      <th>代码</th>
      <th>代码描述</th>
      <th>启动状态</th>
      <th>编辑模式</th>
      <th>排序号</th>
      <th>备注</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option">
          <sys:permission url="<%=Url.getUrl(Url.CODE_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.CODE_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.CODE_UPDATE_SHOW)%>">
            <c:if test="${item.enabled eq '1'}">
              <a href="${root}<%=Url.getUrl(Url.CODE_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>
            </c:if>
           </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.CODE_DELETE_SUBMIT)%>">
            <a href="${root}<%=Url.getUrl(Url.CODE_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
          </sys:permission>
        </td>
        <td title="${item.id}"><hs:out value="${item.id}"/></td>
        <td title="${item.field}"><hs:out value="${item.field}"/></td>
        <td title="${item.fieldname}"><hs:out value="${item.fieldname}"/></td>
        <td title="${item.code}"><hs:out value="${item.code}"/></td>
        <td title="${item.codedesc}"><hs:out value="${item.codedesc}"/></td>
        <td title="${item.enabled eq '1' ? '启动' : '禁用'}">
          <hs:out value="${item.enabled eq '1' ? '启动' : '禁用'}"/></td>
        <td title="${item.editmode eq '1' ? '可编辑' : '只读'}">
          <hs:out value="${item.editmode eq '1' ? '可编辑' : '只读'}"/></td>
        <td title="${item.sortno}"><hs:out value="${item.sortno}"/></td>
        <td title="${item.remark}"><hs:out value="${item.remark}" length="5" /></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
