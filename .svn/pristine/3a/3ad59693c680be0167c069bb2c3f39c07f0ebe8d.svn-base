<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.CODE_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.CODE_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}" >
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label">对照字段<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text"  name="field" data-rule="required" size="30" maxlength="25" value="${entity.field}" placeholder="请输入对照字段，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">对照字段名称<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text"  name="fieldname" data-rule="required" size="30" maxlength="25" value="${entity.fieldname}" placeholder="请输入对照字段名称，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">代码<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text"  name="code" data-rule="required" size="30" maxlength="25" value="${entity.code}" placeholder="请输入代码，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">代码描述<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text"  name="codedesc" data-rule="required" size="30" maxlength="25" value="${entity.codedesc}" placeholder="请输入代码，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">启动状态<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="radio" name="enabled"data-toggle="icheck" value="1"   ${empty entity.code or entity.code eq '1'? '  data-rule="checked"  checked' : ''}  data-label="启动">
              <input type="radio" name="enabled" data-toggle="icheck" value="0" ${entity.code eq '0'? '  data-rule="checked"  checked' : ''} data-label="禁用">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">编辑模式<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="radio" name="editmode"data-toggle="icheck" value="1"   ${empty entity.enabled or entity.enabled eq '1'? '  data-rule="checked"  checked' : ''}  data-label="可编辑">
              <input type="radio" name="editmode" data-toggle="icheck" value="0" ${entity.enabled eq '0'? '  data-rule="checked"  checked' : ''} data-label="只读">
            </td>
          </tr>
        <tr>
          <td align="right">
            <label class="control-label">排序号<span class="required">*</span>：</label>
          </td>
          <td>
            <input type="text"  name="sortno" data-rule="required" size="30" maxlength="25" value="${entity.sortno}" placeholder="请输入排序号，最多25字">
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">备注<span class="required">*</span>：</label>
          </td>
          <td>
            <input type="text"  name="remark"  size="30" maxlength="100" value="${entity.remark}" placeholder="请输入排序号，最多100字">
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.DICTORY_PAGE_SHOW)%>"type="submit" class="btn btn-close" data-icon="close">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>