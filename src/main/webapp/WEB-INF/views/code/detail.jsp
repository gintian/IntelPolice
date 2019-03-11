<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">对照字段：</label>
          </td>
          <td>
            ${entity.field}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">对照字段名称：</label>
          </td>
          <td>
            ${entity.fieldname}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">代码：</label>
          </td>
          <td>
            ${entity.code}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">代码描述：</label>
          </td>
          <td>
            ${entity.codedesc}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">启动状态：</label>
          </td>
          <td>
            ${item.enabled eq '1' ? '启动' : '禁用'}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">编辑模式：</label>
          </td>
          <td>
            ${item.editmode eq '1' ? '可编辑' : '只读'}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">排序号：</label>
          </td>
          <td>
            ${item.sortno}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">备注：</label>
          </td>
          <td>
            ${item.remark}
          </td>
        </tr>
        </tbody>
      </table>
    </div>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn btn-close" data-icon="close">取消</button></li>

  </ul>
</div>