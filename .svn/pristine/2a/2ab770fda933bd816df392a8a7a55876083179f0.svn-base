<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.USER_PAGE_SHOW)%>"
          method="post">
        <div class="bjui-searchBar">
            <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">用户名称：</label>
            <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.name}">

            <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">部门名称：</label>
            <input name="deptName" id="user_deptName" value="${searchObj.deptName}" size="20" readonly type="text">
            <input name="deptId" id="user_deptId" value="${searchObj.deptId}" size="20" type="hidden">
            <a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-id="dept_tree" data-icon="search"
               class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
               data-title="查询"></a>

            <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">人员类型：</label>
                <select data-toggle="selectpicker" name="userType" data-width="200">
                    <option value="">请选择</option>
                    <c:forEach items="${userTypeBeanList}" var="type">
                        <option value="${type.id}"
                                <c:if test="${fn:indexOf(searchObj.userType, type.id) != -1}">selected</c:if>>${type.label}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;"
               data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div class="pull-right">
                <sys:permission url="<%=Url.getUrl(Url.USER_ADD_SHOW)%>">
                    <a href="${root}<%=Url.getUrl(Url.USER_ADD_SHOW)%>" class="btn btn-blue" data-toggle="navtab"
                       data-id="navtab" data-title="新增">新增</a>
                </sys:permission>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped
   table-top data_table table_center" data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="300" align="center">操作</th>
            <th>姓名</th>
            <th>身份证号</th>
            <th>账户</th>
            <th>警号</th>
            <th>电话</th>
            <th>短号</th>
            <th style="width: 50px;" align="center">性别</th>
            <th style="width: 80px;">人员类型</th>
            <th align="center">所属部门</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <c:choose>
                        <c:when test="${item.id != '1' || item.deptId != -1}">
                            <sys:permission url="<%=Url.getUrl(Url.USER_DETAIL_SHOW)%>">
                                <a href="${root}<%=Url.getUrl(Url.USER_DETAIL_SHOW)%>?id=${item.id}"
                                   class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                                   data-height="500">详情</a>
                            </sys:permission>
                            <sys:permission url="<%=Url.getUrl(Url.USER_UPDATE_SHOW)%>">
                                <a href="${root}<%=Url.getUrl(Url.USER_UPDATE_SHOW)%>?id=${item.id}"
                                   class="btn btn-blue" data-toggle="navtab" data-id="navtab">编辑</a>
                            </sys:permission>
                            <sys:permission url="<%=Url.getUrl(Url.USER_DELETE_SUBMIT)%>">
                                <a href="${root}<%=Url.getUrl(Url.USER_DELETE_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                            </sys:permission>
                            <sys:permission url="<%=Url.getUrl(Url.USER_RESET_PASSWORD_SUBMIT)%>">
                                <a href="${root}<%=Url.getUrl(Url.USER_RESET_PASSWORD_SUBMIT)%>?id=${item.id}"
                                   class="btn btn-orange" data-toggle="doajax" data-confirm-msg="确定要重置密码吗？,新密码为111111">重置密码</a>
                            </sys:permission>

                            <sys:permission url="<%=Url.getUrl(Url.USER_LOCKED_SUBMIT)%>">
                                <c:choose>
                                    <c:when test="${item.locked == 0}">
                                        <a href="${root}<%=Url.getUrl(Url.USER_LOCKED_SUBMIT)%>?id=${item.id}&locked=1"
                                           class="btn btn-orange" data-toggle="doajax" data-confirm-msg="确定要锁定吗？">锁定</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="${root}<%=Url.getUrl(Url.USER_LOCKED_SUBMIT)%>?id=${item.id}&locked=0"
                                           class="btn btn-orange" data-toggle="doajax" data-confirm-msg="确定要激活吗？">激活</a>
                                    </c:otherwise>
                                </c:choose>
                            </sys:permission>
                        </c:when>
                    </c:choose>
                </td>
                <td title="${item.name}"><hs:out value="${item.name}" length="25"/></td>
                <td title="${item.identityCard}"><hs:out value="${item.identityCard}" length="10"/></td>
                <td title="${item.account}"><hs:out value="${item.account}" length="15"/></td>
                <td title="${item.policeNumber}"><hs:out value="${item.policeNumber}" length="5"/></td>
                <td title="${item.phone}"><hs:out value="${item.phone}" length="5"/></td>
                <td title="${item.shortPhone}"><hs:out value="${item.shortPhone}" length="5"/></td>
                <td title="${item.sex}" align="center">
                    <c:choose>
                        <c:when test="${item.sex ==1}">
                            男
                        </c:when>
                        <c:when test="${item.sex ==2}">
                            女
                        </c:when>
                        <c:otherwise>
                            保密
                        </c:otherwise>
                    </c:choose>
                </td>
                <td title="${item.userType}" align="center">
                    <hs:typeDictory value="${item.userType}" type="USER_TYPE" valueType="id"/>
                </td>
                <td align="center">
                    <hs:dept value="${item.deptId}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>