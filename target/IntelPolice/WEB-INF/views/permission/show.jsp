
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.PERMISSION_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">名称：</label>
      <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.name}">
      <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">模块：</label>
      <select data-toggle="selectpicker" name="type" data-val="${searchObj.type}" data-width="200">
        <option value="" selected>请选择</option>
        <c:forEach items="${dictorylist}" var="dictory">
          <c:choose>
            <c:when test="${dictory.id == searchObj.type}">
              <option value="${dictory.id}" selected>${dictory.label}</option>
            </c:when>
            <c:otherwise>
              <option value="${dictory.id}">${dictory.label}</option>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </select>
      <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
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
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <a class="btn btn-orange reset" href="javascript:;"
         data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

      <div class="pull-right">
        <sys:permission url="<%=Url.getUrl(Url.PERMISSION_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.PERMISSION_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="新增">新增</a>
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
      <th>名称</th>
      <th>资源路径</th>
      <th>描述</th>
      <th>所属模板</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option">
          <sys:permission url="<%=Url.getUrl(Url.PERMISSION_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.PERMISSION_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>
          <c:choose>
            <c:when  test="${item.changeInd == 0}">
              <sys:permission url="<%=Url.getUrl(Url.PERMISSION_UPDATE_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.PERMISSION_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>

              </sys:permission>
              <sys:permission url="<%=Url.getUrl(Url.PERMISSION_DELETE_SUBMIT)%>">
                <a href="${root}<%=Url.getUrl(Url.PERMISSION_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
              </sys:permission>
            </c:when>
          </c:choose>
        </td>
        <td title="${item.name}"><hs:out value="${item.name}"/></td>
        <td title="${item.url}"><hs:out value="${item.url}" length="40"/></td>
        <td title="${item.descp}"><hs:out value="${item.descp}" length="5"/></td>

        <td title="${item.type}">
          <hs:typeDictory value="${item.type}" type="PERMISSION_TYPE" valueType="id"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
