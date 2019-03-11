<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.DEMO_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.DEMO_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}">
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" for="demo_title">title<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="demo_title" name="title" data-rule="required" maxlength="20" value="${entity.title}" placeholder="请输入xx，最多20字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="demo_content">content<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="demo_content" name="content" data-rule="required" maxlength="20" value="${entity.content}" placeholder="请输入xx，最多20字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="demo_tm">tm<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="demo_tm" name="tm" data-rule="required" maxlength="20" value="${entity.tm}" placeholder="请输入xx，最多20字">
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.DEMO_PAGE_SHOW)%>" class="btn btn-red" data-toggle="navtab" data-id="navtab">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>