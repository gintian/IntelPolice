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
            <label class="control-label">添加人警号：</label>
          </td>
          <td>
            ${entity.tjrbh}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">添加人姓名：</label>
          </td>
          <td>
            ${entity.tjrxm}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">执法记录仪编号：</label>
          </td>
          <td>
            ${entity.jlybh}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">记录地点：</label>
          </td>
          <td>
            ${entity.jldd}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">记录地点坐标：</label>
          </td>
          <td>
            ${entity.jlddzb}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">记录时间：</label>
          </td>
          <td>
            <hs:datefmt value="${entity.jlsj}" type="dateTimeFormat"/>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">到期时间：</label>
          </td>
          <td>
            <hs:datefmt value="${entity.dqsj}" type="dateTimeFormat"/>
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