<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.DICTORY_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.DICTORY_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}" >
        <input type="hidden" name="parentId" value="${entity.parentId}" >
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <c:if test="${entity.id == null}">
          <tr>
            <td align="right">
              <label class="control-label">id：</label>
            </td>
            <td>
              <input type="text" name="id" size="30" maxlength="25" value="${entity.id}" placeholder="请输入id，最多25字">
            </td>
          </tr>
            <tr>
              <td align="right">
                <label class="control-label" for="dictory_parentId">父类id<span class="required">*</span>：</label>
              </td>
              <td>
                <input type="text" id="dictory_parentId" name="parentId" data-rule="required" size="30" maxlength="25" value="${entity.parentId}" placeholder="请输入标父类id，最多25字">
              </td>
            </tr>
        </c:if>
          <tr>
            <td align="right">
              <label class="control-label">类型<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text"  name="type" data-rule="required" size="30" maxlength="25" value="${entity.type}" <c:if test="${entity.type != null}">readonly</c:if> placeholder="请输入资源路径，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="dictory_label">标签名<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="dictory_label" name="label" data-rule="required" size="30" maxlength="25" value="${entity.label}" placeholder="请输入标签，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="dictory_value">标签值<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="dictory_value" name="value" size="30" maxlength="25" value="${entity.value}" placeholder="请输入标签值，最多25字">
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
                  <input type="radio" name="changeInd" data-toggle="icheck" value="0" checked=""  data-label="是">
                  <input type="radio" name="changeInd" data-toggle="icheck" value="1"data-rule="checked" data-label="否">
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="dictory_sort">排序标识<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="dictory_sort" name="sort" data-rule="required" size="30" maxlength="25" value="${entity.sort}" placeholder="请输入资源路径，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label">描述：</label>
            </td>
            <td>
              <input type="text" name="descp"size="30" maxlength="200" height="200" value="${entity.descp}"/>
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