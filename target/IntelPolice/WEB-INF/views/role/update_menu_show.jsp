<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script src="${root}/resources/customstatic/js/role/menu_tree_allot_show.js"></script>
<script src="${root}/resources/customstatic/js/common/commonUtil.validate.js"></script>
<div class="bjui-pageContent">
    <form action="${root}<%=Url.getUrl(Url.ROLE_UPDATE_MENU_SUBMIT)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
        <input type="hidden" id="roleId" name="id" value="${roleId}">
        <input type="hidden" id="funIds" name="funIds">

        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-hover hw-table-long-input" width="100%">
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
                           enable: true,
			                 chkStyle: 'checkbox'
                        }
                    }">
                                    <%--菜单树--%>
                                <c:forEach items="${menuBeanList}" var="item">
                                    <li data-id="${item.id}"
                                        data-pid="${item.parentId}"
                                        data-faicon="ellipsis-v"
                                        data-title="${item.name}"
                                        <c:forEach items="${menuIds}" var="menuId">
                                            <c:if test='${menuId == item.id}'>data-checked="true"</c:if>
                                        </c:forEach>
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
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><a href="${root}<%=Url.getUrl(Url.ROLE_PAGE_SHOW)%>" type="submit" class="btn btn-close"
               data-icon="close">取消</a></li>

        <li>
            <button type="submit" class="btn btn-success" data-icon="save">保存</button>
        </li>
    </ul>
</div>
