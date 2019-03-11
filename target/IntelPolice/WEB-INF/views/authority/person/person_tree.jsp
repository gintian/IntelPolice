<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script>
    function getName(personId,name) {
        $.CurrentNavtab.find("#recordPerson_personId").val(personId);
        $.CurrentNavtab.find("#ecordPerson_name").val(name);
    }
</script>
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
          <td><a onclick="getName('${item.personId}','${item.name}')" class="btn btn-close"
                 data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a></td>
          <td title="${item.name}"><hs:out value="${item.name}" length="25"/></td>
          <td title="${item.idcard}"><hs:out value="${item.idcard}" length="10"/></td>
          <td ><hs:out value="${item.isrddb eq '0' ? '是' : '否'}" length="15"/></td>
          <td title="${item.bxwrAddr}"><hs:out value="${item.bxwrAddr}" length="5"/></td>
          <td title="${item.bxwrPhone}"><hs:out value="${item.bxwrPhone}" length="5"/></td>
          <td title="${item.addUser}"><hs:out value="${item.addUser}" length="5"/></td>
          <td><hs:datefmt value="${item.addTime}" type="dateTimeFormat"/></td>
          <td title="${item.modifyUser}"><hs:out value="${item.modifyUser}" length="5"/></td>
          <td><hs:datefmt value="${item.modifyTime}" type="dateTimeFormat"/></td>
        </tr>
      </c:forEach>
    </c:if>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>