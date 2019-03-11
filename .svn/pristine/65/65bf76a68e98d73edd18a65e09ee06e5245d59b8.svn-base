<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.ROLE_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.ROLE_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}">
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" for="role_name">名称<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="role_name" name="name" data-rule="required" size="30" maxlength="25" value="${entity.name}" placeholder="请输入名称，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">所属部门<span class="required">*</span>：</label>
            </td>
            <td>
              <input name="deptId" id="user_deptId" value="${entity.deptId}" size="30" data-rule="required" readonly=""  type="hidden">
              <input name="deptName" id="user_deptName" type="text" size="30" readonly="" value="<hs:dept value="${entity.deptId}"/>">
              <c:if test="${entity.deptId == null || entity.deptId == ''}">
                   <a href="${root}<%=Url.getUrl(Url.ROLE_DEPT_TREE_SHOW)%>" data-id="dept_tree" data-icon="search" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
              </c:if>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="role_type">角色类型<span class="required">*</span>：</label>
            </td>
            <td>
              <select id="role_type" data-toggle="selectpicker" name="type" data-width="300" data-val="${entity.type}">
                <option value="1" <c:if test="${entity.type == 1}">selected</c:if>>业务类型</option>
                <option value="2" <c:if test="${entity.type == 2 or entity.type == '' or entity.type == null}">selected</c:if>>管理类型</option>
                <option value="3" <c:if test="${entity.type == 3}">selected</c:if>>系统内置类型</option>
              </select>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">锁定标识<span class="required">*</span>：</label>
            </td>
            <td>
              <c:choose>
                <c:when test="${entity.locked == 0}">
                  <input type="radio" name="locked" data-toggle="icheck" value="0" checked="" data-label="锁定">
                  <input type="radio" name="locked" data-toggle="icheck" value="1" data-label="激活">
                </c:when>
                <c:when test="${entity.locked == 1}">
                  <input type="radio" name="locked" data-toggle="icheck" value="0" data-label="锁定">
                  <input type="radio" name="locked"  data-toggle="icheck" value="1" checked="" data-label="激活">
                </c:when>
                <c:otherwise>
                  <input type="radio" name="locked"  data-toggle="icheck" value="0" data-label="锁定">
                  <input type="radio" name="locked" data-toggle="icheck" value="1"  checked="" data-label="激活">
                </c:otherwise>
              </c:choose>

            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="role_key">权限标志：</label>
            </td>
            <td>
              <input type="text" id="roleKey" name="roleKey" size="30" maxlength="25" value="${entity.roleKey}" placeholder="请输入权限标志，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">是否可修改<span class="required">*</span>：</label>
            </td>
            <td>
              <c:choose>
                <c:when test="${entity.changeInd == 0}">
                  <input type="radio" name="changeInd"data-toggle="icheck" value="0"checked="" data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1" data-label="否">
                </c:when>
                <c:when test="${entity.changeInd == 1}">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="0" data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1"  checked="" data-label="否">
                </c:when>
                <c:otherwise>
                  <input type="radio" name="changeInd" data-toggle="icheck" value="0" checked="" data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1" data-label="否">
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">备注：</label>
            </td>
            <td>
              <input type="text" name="remark"size="30" maxlength="200" height="200" value="${entity.remark}"/>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li>
      <button class="btn btn-close" data-toggle="menu01010203" type="button" data-icon="close">
        <i class="fa fa-close">取消</i>
     <%-- <button type="button" class="btn btn-success" data-icon="close">保存</button>--%>
      <%--<a href="${root}<%=Url.getUrl(Url.ROLE_PAGE_SHOW)%>" data-target="navtab" data-id="navtab" class="btn btn-close" data-icon="close">取消</a>--%>
    </li>
    <li><button type="submit" class="btn btn-success" data-toggle="menu01010203" onclick="BJUI.navtab('refresh', 'menu01010103')" data-icon="save">保存</button></li>
  </ul>
</div>