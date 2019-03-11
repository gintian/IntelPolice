<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr class="info">
          <td align="right" width="150px">
            <label class="control-label">所属模板：</label>
          </td>
          <td>
            <hs:typeDictory value="${item.type}" type="PERMISSION_TYPE" valueType="id"/>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">名称：</label>
          </td>
          <td>
            ${entity.name}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">资源路径：</label>
          </td>
          <td>
            ${entity.url}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">排序标识：</label>
          </td>
          <td>
            ${entity.sort}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">描述：</label>
          </td>
          <td>
            ${entity.descp}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">修改标识：</label>
          </td>
          <td>
            <c:choose>
              <c:when  test="${entity.changeInd == 0}">
                是
              </c:when>
              <c:otherwise>
                否
              </c:otherwise>
            </c:choose>
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