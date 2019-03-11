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
            <label class="control-label">所属部门：</label>
          </td>
          <td>
            <hs:dept value='${entity.deptId}'/>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">用户类型：</label>
          </td>
          <td>
            <c:choose>
              <c:when  test="${entity.type == 1}">
                业务角色
              </c:when>
              <c:when  test="${entity.type == 2}">
                管理角色
              </c:when>
              <c:when  test="${entity.type == 3}">
                系统内置角色
              </c:when>
            </c:choose>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">锁定标识：</label>
          </td>
          <td>
            <c:choose>
              <c:when  test="${entity.locked == 0}">
                锁定
              </c:when>
              <c:otherwise>
                激活
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">是否可以修改：</label>
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