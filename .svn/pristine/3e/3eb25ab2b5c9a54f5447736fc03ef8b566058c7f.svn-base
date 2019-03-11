<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr class="info">
          <td align="right" width="150px">
            <label class="control-label">名称：</label>
          </td>
          <td>
            ${entity.name}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">图标：</label>
          </td>
          <td>
            ${entity.iconCls}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">是否展开：</label>
          </td>
          <td>
            <c:if test="${entity.expanded == 0}">
              否
            </c:if>
            <c:if test="${entity.expanded == 1}">
              是
            </c:if>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">请求地址：</label>
          </td>
          <td>
            ${entity.request}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">叶子节点：</label>
          </td>
          <td>
            <c:if test="${entity.leaf == 0}">
              否
            </c:if>
            <c:if test="${entity.leaf == 1}">
              是
            </c:if>
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
            <label class="control-label">类型：</label>
          </td>
          <td>
            <c:if test="${entity.type == 0}">
              业务菜单
            </c:if>
            <c:if test="${entity.type == 1}">
              系统菜单
            </c:if>
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
        </tbody>
      </table>
    </div>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn btn-close" data-icon="close">取消</button></li>

  </ul>
</div>