<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <form action="${root}<%=Url.getUrl(Url.ROLE_UPDATE_PERMISSION_SUBMIT)%>" data-toggle="validate"
        data-reload-navtab="true" method="post">
    <input type="hidden" name="id" value="${roleId}">

    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%" cellspacing="10">
        <tbody>
        <c:forEach items="${dictoryBeanList}" var="dictoryBean">
          <tr>
            <td align="right" style="width: 200px;">
              <label class="control-label">${dictoryBean.label}：</label>
            </td>
            <td>
              <c:forEach items="${beanList}" var="bean" varStatus="status">
                <div style="width:160px; float: left;">
                  <c:if test="${bean.type == dictoryBean.id}">
                    <c:forEach items="${permissionIds}" var="permissionId">
                        <c:if test="${permissionId == bean.id}">
                              <c:set var="flag" value="checked=''"></c:set>
                        </c:if>
                    </c:forEach>

                    <input type="checkbox" name="permissoinIds" ${flag} value="${bean.id}" data-toggle="icheck" data-label="<hs:out value="${bean.name}" length="8"/>">
                    <c:if test="${status.count % 4 == 0}"><br/></c:if>
                    <c:set var="flag" value=""></c:set>
                  </c:if>
                    </div>
              </c:forEach>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.ROLE_PAGE_SHOW)%>"type="submit" class="btn btn-close" data-icon="close">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>