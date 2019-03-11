
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.ROLE_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">名称：</label>
      <input name="name" id="name" placeholder="请输入名称" size="20" maxlength="30" value="${searchObj.name}">

      <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">部门名称：</label>
      <input name="deptName" id="user_deptName" value="${searchObj.deptName}" size="20" type="text">
      <input name="deptId" id="user_deptId" value="${searchObj.deptId}" size="20" type="hidden">
      <a href="${root}<%=Url.getUrl(Url.ROLE_DEPT_TREE_SHOW)%>" data-id="dept_tree" data-icon="search" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>

      <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
        <i class="fa fa-angle-double-down"></i>
      </button>
     <%-- <div class="bjui-moreSearch">
        <label for="media_jlsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">记录时间：</label>
        <input type="text" id="media_jlsj" name="jlsj" data-rule="required"
               data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
               value="<hs:datefmt value="${searchObj.jlsj}" type="dateTimeSecPattern"/>" />
        <label for="media_dqsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">到期时间：</label>
        <input type="text" id="media_dqsj" name="dqsj" data-rule="required"
               data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
               value="<hs:datefmt value="${searchObj.dqsj}" type="dateTimeSecPattern"/>" />
      </div>--%>
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <a class="btn btn-orange reset" href="javascript:;"
         data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
      <div class="pull-right">
        <sys:permission url="<%=Url.getUrl(Url.ROLE_ADD_SHOW)%>">
          <a href="${root}<%=Url.getUrl(Url.ROLE_ADD_SHOW)%>" class="btn btn-blue" data-toggle="navtab" data-id="navtab" data-title="新增">新增</a>
        </sys:permission>
      </div>
    </div>
  </form>
</div>
<div class="bjui-pageContent tableContent">
  <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
    <thead>
    <tr class="line_top">
      <th>操作</th>
      <th>名称</th>
      <th>所属部门</th>
      <th>角色类型</th>
      <th>备注</th>
      <th>锁定标志</th>
      <th>权限标志</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option">
          <sys:permission url="<%=Url.getUrl(Url.ROLE_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.ROLE_DETAIL_SHOW)%>?Id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>

          <c:choose>
            <c:when  test="${item.changeInd == 0}">
              <sys:permission url="<%=Url.getUrl(Url.ROLE_UPDATE_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.ROLE_UPDATE_SHOW)%>?Id=${item.id}" class="btn btn-blue" data-toggle="navtab" data-id="navtab" data-confirm-msg="编辑">编辑</a>
              </sys:permission>
              <sys:permission url="<%=Url.getUrl(Url.ROLE_DELETE_SUBMIT)%>">
                <a href="${root}<%=Url.getUrl(Url.ROLE_DELETE_SUBMIT)%>?Id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
              </sys:permission>
              <sys:permission url="<%=Url.getUrl(Url.ROLE_UPDATE_PERMISSION_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.ROLE_UPDATE_PERMISSION_SHOW)%>?Id=${item.id}" class="btn btn-orange" data-toggle="dialog" data-mask="true" data-width="1000" data-height="600" data-confirm-msg="权限编辑">权限编辑</a>
              </sys:permission>
              <sys:permission url="<%=Url.getUrl(Url.ROLE_UPDATE_MENU_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.ROLE_UPDATE_MENU_SHOW)%>?Id=${item.id}" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-confirm-msg="菜单编辑">菜单编辑</a>
              </sys:permission>
            </c:when>
          </c:choose>
        </td>
        <td title="${item.name}"><hs:out value="${item.name}" length="5"/></td>
        <td title="<hs:dept value="${item.deptId}"/>">
          <hs:dept value='${item.deptId}'/>
        </td>
        <td>
          <c:choose>
            <c:when  test="${item.type == 1}">
              业务角色
            </c:when>
            <c:when  test="${item.type == 2}">
              管理角色
            </c:when>
            <c:when  test="${item.type == 3}">
              系统内置角色
            </c:when>
          </c:choose>
        </td>
        <td title="${item.remark}"><hs:out value="${item.remark}" length="5"/></td>
        <td>
          <c:choose>
            <c:when  test="${item.locked == 0}">
                锁定
            </c:when>
            <c:otherwise>
                激活
            </c:otherwise>
          </c:choose>
        </td>
        <td title="${item.roleKey}"><hs:out value="${item.roleKey}" length="5"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
