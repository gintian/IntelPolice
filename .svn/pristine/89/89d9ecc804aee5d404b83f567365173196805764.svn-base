<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.DEPT_PAGE_SHOW)%>"
          method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">部门ID：</label>
            <input name="id" id="id" placeholder="请输入ID" style="width: 200px;" value="${searchObj.id}">
            <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">部门名称：</label>
            <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.name}">

            <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>

            <div class="bjui-moreSearch">
                <label for="parentId" class="control-label" style="margin-left: 0px;padding-left: 0px;width:90px;">部门父级ID：</label>
                <input name="parentId" id="parentId" placeholder="请输入父级ID" style="width: 200px;"
                       value="${searchObj.parentId}">
            </div>

            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;"
               data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

            <div class="pull-right">
                <sys:permission url="<%=Url.getUrl(Url.DEPT_ADD_SHOW)%>">
                    <a href="${root}<%=Url.getUrl(Url.DEPT_ADD_SHOW)%>" class="btn btn-blue" data-toggle="navtab"
                       data-id="navtab" data-title="新增">新增</a>
                </sys:permission>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center">
        <thead>
        <tr class="line_top">
            <th align="center">操作</th>
            <th width="70" align="center">部门编号</th>
            <th align="center">部门名称</th>
            <th width="70" align="center">上级部门</th>
            <th width="80" align="center">业务对照码</th>
            <th width="70" align="center">启用状态</th>
            <th width="50" align="center">排序号</th>
            <th width="50" align="center">是否为子部门</th>
            <th width="40" align="center">备注</th>
            <th width="50" align="center">是否执法单位</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <sys:permission url="<%=Url.getUrl(Url.DEPT_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEPT_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.DEPT_UPDATE_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEPT_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                           data-toggle="navtab" data-id="navtab">编辑</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.DEPT_DELETE_SUBMIT)%>">
                        <a href="${root}<%=Url.getUrl(Url.DEPT_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red"
                           data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                    </sys:permission>
                </td>
                <td title="${item.id}"><hs:out value="${item.id}" length="15"/></td>
                <td title="${item.name}"><hs:out value="${item.name}" length="30"/></td>
                <td title="${item.parentId}"><hs:out value="${item.parentId}" length="15"/></td>
                <td title="${item.customId}"><hs:out value="${item.customId}" length="5"/></td>
                <td title='<hs:code value="${item.status}" field="DEPT-STRUTS" />' align="center">
                    <hs:code value="${item.status}" field="DEPT-STRUTS" />
                </td>
                <td title="${item.sortNo}" align="center"><hs:out value="${item.sortNo}" length="5"/></td>
                <td title='<hs:code value="${item.leaf}" field="ISSTRUTS" />' align="center">
                    <hs:code value="${item.leaf}" field="ISSTRUTS" />
                </td>
                <td title="${item.remark}" align="center"><hs:out value="${item.remark}" length="5"/></td>
                <td title=' <hs:code value="${item.isrddb}" field="ISSTRUTS" />' align="center">
                    <hs:code value="${item.isCaseUnit}" field="ISSTRUTS" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>