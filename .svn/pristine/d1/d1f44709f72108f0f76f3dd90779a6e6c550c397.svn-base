
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.RECORD_QUESTION_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label for="questionCode" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">问题编号：</label>
      <input name="questionCode" id="questionCode" placeholder="请输入名称" style="width: 200px;" value="${searchObj.questionCode}">
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
        <sys:permission url="<%=Url.getUrl(Url.RECORD_QUESTION_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.RECORD_QUESTION_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog"
             data-mask="true" data-width="600" data-height="500" data-title="新增">新增</a>
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
      <th style="width:320px">问题编号</th>
      <th>问题内容</th>
      <th>问题类型</th>
      <th>案件类型</th>
      <th>创建人员</th>
      <th>创建时间</th>
      <th>修改时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option" align="center">
          <sys:permission url="<%=Url.getUrl(Url.RECORD_QUESTION_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.RECORD_QUESTION_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
               data-toggle="dialog" data-mask="true" data-width="600" data-height="600" data-confirm-msg="详情">详情</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.RECORD_QUESTION_UPDATE_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.RECORD_QUESTION_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
               data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>
          </sys:permission>
          <sys:permission url="<%=Url.getUrl(Url.RECORD_QUESTION_DELETE_SUBMIT)%>">
          <a href="${root}<%=Url.getUrl(Url.RECORD_QUESTION_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red"
             data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
        </sys:permission>
        </td>
        <td title="${item.questionCode}"><hs:out value="${item.questionCode}" /></td>
        <td title="${item.content}"><hs:out value="${item.content}" length="15"/></td>
        <c:if test="${'0' eq item.type}">
          <td title="询问">询问</td>
        </c:if>
        <c:if test="${'1' eq item.type}">
          <td title="询问">讯问</td>
        </c:if>
        <c:if test="${'2' eq item.type}">
          <td title="询问">辩论</td>
        </c:if>
        </td>
        <c:forEach items="${codeBeanList}" var="codeBean">
          <c:if test="${codeBean.code eq item.caseType}">
              <td title="${codeBean.codedesc}"><hs:out value="${codeBean.codedesc}" length="5"/></td>
          </c:if>
        </c:forEach>
        <td title="${item.addUser}"><hs:user value="${item.addUser}"/></td>
        <td><hs:datefmt value="${item.addTime}" stringDatePatten="dateTimeFormat"/></td>
        <td ><hs:datefmt value="${item.modifyTime}" stringDatePatten="dateTimeFormat"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>