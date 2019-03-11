<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr class="info">
          <td align="right" width="150px">
            <label class="control-label">部门编号：</label>
          </td>
          <td>
            ${entity.id}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">部门名称：</label>
          </td>
          <td>
            ${entity.name}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">上级部门：</label>
          </td>
          <td>
              <hs:dept value="${entity.parentId}"/>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">业务对照码：</label>
          </td>
          <td>
            ${entity.customId}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">启用状态：</label>
          </td>
          <td>
            ${entity.status}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">排序号：</label>
          </td>
          <td>
            ${entity.sortNo}
          </td>
        </tr>
         <tr>
          <td align="right" width="150px">
            <label class="control-label">是否为子部门：</label>
          </td>
          <td>
            ${entity.leaf}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">备注：</label>
          </td>
          <td>
            ${entity.remark}
          </td>
        </tr>
         <tr>
          <td align="right" width="150px">
            <label class="control-label">是否执法单位：</label>
          </td>
          <td>
            ${entity.isCaseUnit}
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