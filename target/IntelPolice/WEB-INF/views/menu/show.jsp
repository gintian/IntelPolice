
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<script src="${root}/resources/customstatic/js/menu/allot_show.js"></script>
<script src="${root}/resources/customstatic/js/common/commonUtil.validate.js"></script>

<div class="bjui-pageHeader">
  <input type="hidden" id="menuurlAdd" value="${root}<%=Url.getUrl(Url.MENU_ADD_SHOW)%>"/>
  <input type="hidden" id="menuurlUpdate" value="${root}<%=Url.getUrl(Url.MENU_UPDATE_SHOW)%>"/>
  <input type="hidden" id="menuurlDelete" value="${root}<%=Url.getUrl(Url.MENU_DELETE_SUBMIT)%>"/>
  <div id="showoperation" class="pull-right" style="display: none;">
    <sys:permission url="<%=Url.getUrl(Url.MENU_DELETE_SUBMIT)%>">
      <span id="showDeletebutonn"></span>
    </sys:permission>
    <sys:permission url="<%=Url.getUrl(Url.MENU_UPDATE_SHOW)%>">
      <span id="showUpdatebutonn"></span>
    </sys:permission>
    <sys:permission url="<%=Url.getUrl(Url.MENU_ADD_SHOW)%>">
      <span id="showAddbutonn"></span>
    </sys:permission>
  </div>
</div>
<div class="bjui-pageContent" style="margin-top: 25px;">
  <input type="hidden" id="roleUrl" value="${root}<%=Url.getUrl(Url.USER_MENU_BY_DEPTID)%>">
  <div class="pageFormContent" data-layout-h="0">
    <table class="table-hover hw-table-long-input" width="100%">
      <tbody>
      <tr>
        <td>
          <c:if test="${empty menuBeanList}">
            暂无数据
          </c:if>
          <c:if test="${!empty menuBeanList}">
            <ul id="sys_permission_ztree" class="ztree"
                data-expand-all="false"
                data-check-enable="true"
                data-on-check="SysPermissionAllot.handleMenuCheck"
                data-toggle="ztree"
                data-setting= "{
                        check: {
                           chkStyle: 'radio',
                           radioType: 'all'
                        }
                    }">
                <%--菜单树--%>
              <c:forEach items="${menuBeanList}" var="item">
                <li data-id="${item.id}"
                    data-pid="${item.parentId}"
                    data-faicon="ellipsis-v"
                    data-title="${item.name}"
                >
                  <hs:out value="${item.name}" length="25"/>
                </li>
              </c:forEach>
            </ul>
          </c:if>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</div>