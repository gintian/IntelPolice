
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.RECORD_PERSON_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label for="bxwr" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">名字：</label>
      <input name="bxwr" id="bxwr" placeholder="请输入名称" style="width: 200px;" value="${searchObj.name}">
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
        <sys:permission url="<%=Url.getUrl(Url.RECORD_PERSON_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog"
             data-mask="true" data-width="650" data-height="700" data-options="{id:'user1'}" data-title="新增">新增</a>
        </sys:permission>
      </div>
    </div>
  </form>
</div>
<div class="bjui-pageContent tableContent">
  <table class="table table-bordered table-hover table-striped
   table-top data_table table_center" data-selected-multi="true" id="bt">
    <thead>
    <tr class="line_top">
      <th>操作</th>
      <th align="center">姓名</th>
      <th align="center">身份证号</th>
      <th align="center">人大代表</th>
      <th align="center">居住地址</th>
      <th align="center">联系方式</th>
      <th align="center">创建人</th>
      <th align="center">创建时间</th>
      <th align="center">修改人</th>
      <th align="center">修改时间</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty list}" var="flag">
      <tr><td colspan="10" style="color: #d9534f;"> 暂无数据！</td></tr>
    </c:if>
    <c:if test="${not flag}">
      <c:forEach items="${list}" var="item">
        <tr>
          <td>
            <sys:permission url="<%=Url.getUrl(Url.RECORD_PERSON_DETAIL_SHOW)%>">
              <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_DETAIL_SHOW)%>?personId=${item.personId}" class="btn btn-green"
                 data-toggle="dialog" data-mask="true" data-width="600" data-height="600" data-confirm-msg="详情">详情</a>
            </sys:permission>
            <sys:permission url="<%=Url.getUrl(Url.RECORD_PERSON_UPDATE_SHOW)%>">
              <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_UPDATE_SHOW)%>?personId=${item.personId}" class="btn btn-blue"
                 data-toggle="dialog" data-mask="true" data-width="650" data-height="700" data-options="{id:'user'}" data-confirm-msg="编辑">编辑</a>
            </sys:permission>
            <sys:permission url="<%=Url.getUrl(Url.RECORD_PERSON_DELETE_SUBMIT)%>">
              <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_DELETE_SUBMIT)%>?personId=${item.personId}" class="btn btn-red"
                 data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
            </sys:permission>
          </td>
          <td title="${item.name}"><hs:out value="${item.name}" length="25"/></td>
          <td title="${item.idcard}"><hs:out value="${item.idcard}" length="10"/></td>
          <td ><hs:out value="${item.isrddb eq '0' ? '是' : '否'}" length="15"/></td>
          <td title="${item.bxwrAddr}"><hs:out value="${item.bxwrAddr}" length="5"/></td>
          <td title="${item.bxwrPhone}"><hs:out value="${item.bxwrPhone}" length="5"/></td>
          <td><hs:user value="${item.addUser}"/></td>
          <td><hs:datefmt value="${item.addTime}" type="dateTimeFormat"/></td>
          <td>
            <c:if test="${empty item.modifyUser}" var="flag" >--</c:if>
            <c:if test="${not flag}"><hs:user value="${item.modifyUser}"/></c:if>
          </td>
          <td>
            <c:if test="${empty item.modifyTime}" var="flag" >--</c:if>
            <c:if test="${not flag}"><hs:datefmt value="${item.modifyTime}" type="dateTimeFormat"/></c:if>
          </td>
        </tr>
      </c:forEach>
    </c:if>
    </tbody>
  </table>
</div>
  <%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
