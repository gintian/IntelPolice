<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.PERMISSION_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.PERMISSION_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="status" value="${entity.status}">
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" for="permission_name">所属模板<span class="required">*</span>：</label>
            </td>
            <td>
              <select data-toggle="selectpicker" name="type" data-val="${entity.type}" data-width="200">
                <c:forEach items="${dictorylist}" var="dictory">
                  <c:choose>
                    <c:when test="${dictory.id == entity.type}">
                      <option value="${dictory.id}" selected>${dictory.label}</option>
                    </c:when>
                    <c:otherwise>
                      <option value="${dictory.id}">${dictory.label}</option>
                    </c:otherwise>
                  </c:choose>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="permission_name">名称<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="permission_name" name="name" data-rule="required" size="30" maxlength="30" value="${entity.name}" placeholder="请输入名称，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="permission_url">资源路径<span class="required">*</span>：</label>
            </td>
            <td>
              <%--<input type="text" id="permission_url" name="url" data-rule="required" size="30" maxlength="1000" value="${entity.url}" placeholder="请输入资源路径，最多80字">--%>
                <textarea name="url" id="permission_url" data-rule="required" data-toggle="autoheight"  size="30" maxlength="1000" rows="3">
                  ${entity.url}
                </textarea>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">修改标识<span class="required">*</span>：</label>
            </td>
            <td>
              <c:choose>
                <c:when test="${entity.changeInd == 0}">
                  <input type="radio" name="changeInd"data-toggle="icheck" value="0" data-rule="checked" checked="" data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1" data-label="否">
                </c:when>
                <c:when test="${entity.changeInd == 1}">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="0" data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1" checked=""  data-rule="checked" data-label="否">
                </c:when>
                <c:otherwise>
                  <input type="radio" name="changeInd" data-toggle="icheck" value="0" data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1" checked="" data-rule="checked" data-label="否">
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="permission_sort">排序标识<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="permission_sort" name="sort" data-rule="required" size="30" maxlength="25" value="${entity.sort}" placeholder="请输入资源路径，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="role_descp">描述：</label>
            </td>
            <td>
              <textarea name="descp" id="role_descp" data-toggle="autoheight"  size="30" maxlength="100" rows="2">
                ${entity.descp}
              </textarea>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.PERMISSION_PAGE_SHOW)%>"type="submit" class="btn btn-close" data-icon="close">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>