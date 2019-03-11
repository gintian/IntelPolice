
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.RECORD_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label for="bxwr" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">名称：</label>
      <input name="bxwr" id="bxwr" placeholder="请输入名称" style="width: 200px;" value="${searchObj.bxwr}">
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
      <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>


      <div class="pull-right">
        <sys:permission url="<%=Url.getUrl(Url.RECORD_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.RECORD_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog"
             data-mask="true" data-width="500" data-height="500" data-title="新增">新增</a>
        </sys:permission>
      </div>
    </div>
  </form>
</div>

<div class="bjui-pageContent tableContent">
  <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
    <thead>
    <tr class="line_top">
      <th align="center">操作</th>
      <th>笔录单位</th>
      <th>询问人</th>
      <th>询问时间</th>
      <th>笔录人员</th>
      <th>记录地点</th>
      <th>笔录内容</th>
      <th>笔录时间</th>
      <th>被询问人</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option" align="center">
          <sys:permission url="<%=Url.getUrl(Url.RECORD_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.RECORD_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
               data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="详情">详情</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.RECORD_UPDATE_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.RECORD_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
               data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.RECORD_ADD_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.RECORD_ADD_SHOW)%>?id=${item.id}" class="btn btn-green"
               data-toggle="dialog" data-mask="true" data-width="600" data-options="{max:true}" data-height="500" data-confirm-msg="详情">添加询/讯问笔录</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.RECORD_DELETE_SUBMIT)%>">
            <a href="${root}<%=Url.getUrl(Url.RECORD_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red"
               data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
          </sys:permission>
        </td>
        <td title="${item.deptId}"><hs:out value="${item.deptId}" length="5"/></td>
        <td title="${item.xwrId}"><hs:out value="${item.xwrId}" length="5"/></td>
        <td title="${item.xwsj}"><hs:out value="${item.xwsj}" length="5"/></td>
        <td title="${item.blryId}"><hs:out value="${item.blryId}" length="5"/></td>
        <td title="${item.bxwraddr}"><hs:out value="${item.bxwraddr}" length="5" /></td>
        <td title="${item.recordcontent}"><hs:out value="${item.recordcontent}" length="5"/></td>
        <td ><hs:datefmt value="${item.blsj}" stringDatePatten="dateTimeFormat"/></td>
        <td><hs:datefmt value="${item.bxwr}" stringDatePatten="dateTimeFormat"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>