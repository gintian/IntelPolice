<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">

  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.MENU_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.MENU_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}">
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <input type="hidden" name="parentId" value="${entity.parentId}">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" for="menu_menuName">名称<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="menu_menuName" name="name" data-rule="required" size="30" maxlength="25" value="${entity.name}" placeholder="请输入名称，最多25字">
            </td>
          </tr>

          <tr>
            <td align="right">
              <label class="control-label" for="menu_iconCls">图标</span>：</label>
            </td>
            <td>
              <input type="text" id="menu_iconCls" name="iconCls" size="30" maxlength="25" value="${entity.iconCls}" placeholder="请输入图标，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">是否展开<span class="required">*</span>：</label>
            </td>
            <td>
              是：<input type="radio" name="expanded" value="1" <c:if test="${entity.expanded == 1}">checked</c:if>/>
              否：<input type="radio" name="expanded" value="0" <c:if test="${entity.expanded == 0 || entity.expanded == '' || entity.expanded == null }">checked</c:if>/>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="menu_request">请求地址：</label>
            </td>
            <td>
              <input type="text" id="menu_request" name="request" size="30" maxlength="90" value="${entity.request}">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">叶子节点<span class="required">*</span>：</label>
            </td>
            <td>
              是：<input type="radio" name="leaf" value="1" <c:if test="${entity.leaf == 1}">checked</c:if>/>
              否：<input type="radio" name="leaf" value="0" <c:if test="${entity.leaf == 0 || entity.leaf == '' || entity.leaf == null }">checked</c:if>/>
            </td>
          </tr>
         <tr>
            <td align="right">
              <label class="control-label">排序号<span class="required">*</span>：</label>
            </td>
            <td>
                 <input name="sortNo" value="${entity.sortNo}" value="1" size="30" data-toggle="spinner" data-min="0" data-max="100" data-step="1" data-rule="integer" type="text">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">类型<span class="required">*</span>：</label>
            </td>
            <td>
              <select data-toggle="selectpicker" data-width="300" name="type">
                <option value="1" <c:if test="${entity.type == 1}">selected</c:if>>系统菜单</option>
                <option value="0" <c:if test="${entity.type == 0}">selected</c:if>>业务菜单</option>
              </select>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" >备注<span class="required">*</span>：</label>
            </td>
            <td>
              <textarea name="remark" data-toggle="autoheight" cols="30" rows="1">${entity.remark}</textarea>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.MENU_PAGE_SHOW)%>"type="submit" class="btn btn-close" data-icon="close">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>