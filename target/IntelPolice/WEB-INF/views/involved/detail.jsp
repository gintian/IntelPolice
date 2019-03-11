<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr class="info">
          <td align="right" width="150px">
            <label class="control-label">财物ID：</label>
          </td>
          <td>
            ${entity.id}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">财物编码：</label>
          </td>
          <td>
            ${entity.cwbm}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">财物名称：</label>
          </td>
          <td>
            ${entity.cwmc}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">登记时间：</label>
          </td>
          <td>
            <hs:datefmt value="${entity.djsj}" type="dateTimeFormat"/>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">登记人员ID：</label>
          </td>
          <td>
            ${entity.djryId}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">登记人员单位ID：</label>
          </td>
          <td>
            ${entity.djrydwId}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">登记人员单位机构：</label>
          </td>
          <td>
            ${entity.djrydw}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">扣押原因：</label>
          </td>
          <td>
            ${entity.kyyy}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">财物物主：</label>
          </td>
          <td>
            ${entity.cwwz}
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