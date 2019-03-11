<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script src="${root}/resources/customstatic/js/role/allot_show.js"></script>
<script src="${root}/resources/customstatic/js/common/commonUtil.validate.js"></script>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr>
          <td>
            <c:if test="${empty deptBeanList}">
              暂无数据
            </c:if>
            <c:if test="${!empty deptBeanList}">
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
                <c:forEach items="${deptBeanList}" var="item">
                  <li data-id="${item.id}"
                      data-pid="${item.parentId}"
                      data-faicon="ellipsis-v"
                      data-title="${item.name}"
                        <c:if test='${deptId == item.id}'>data-checked="true"</c:if>
                      >
                    <hs:out value="${item.name}" length="25"/>
                  </li>
                  <c:if test="${deptId == item.id}">
                    1111
                  </c:if>
                </c:forEach>
              </ul>
            </c:if>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>