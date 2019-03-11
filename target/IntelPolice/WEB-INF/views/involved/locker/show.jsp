<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<c:choose>
    <c:when test="${status==null}">
        <div class="bjui-pageHeader">
            <form id="${searchFormId}" data-toggle="ajaxsearch"
                  action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_PAGE_SHOW)%>" method="post">
                <div class="bjui-searchBar">
                    <label for="id" class="control-label"
                           style="margin-left: 0px; padding-left: 0px; width: 60px;">储物柜ID：</label>
                    <input name="id" id="id" placeholder="请输入储物柜编号" style="width: 200px;"
                           value="${searchObj.id}">
                    <label for="lockerName" class="control-label"
                           style="margin-left: 0px; padding-left: 0px; width: 60px;">储物柜名称：</label>
                    <input name="lockerName" id="lockerName" placeholder="请输入储物柜名称" style="width: 200px;"
                           value="${searchObj.lockerName}">

                    <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
                    <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                       data-clear-query="true"
                       data-icon="undo">清空查询</a>
                    <c:choose>
                        <c:when test="${status==null}">
                            <div class="pull-right">
                                <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_ADD_SHOW)%>?storeId=${storeId}"
                                   data-toggle="navtab"
                                   class="btn btn-blue"
                                   data-id="navtab" data-title="新增">新增</a>
                            </div>
                        </c:when>
                    </c:choose>
                </div>
            </form>
        </div>
    </c:when>
</c:choose>
<script>
    function getName(id, name) {
        $.CurrentNavtab.find("#involved_lockerId").val(id);
        $.CurrentNavtab.find("#involved_lockerName").val(name);
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="160" align="center">操作</th>
            <th align="center">储物柜ID</th>
            <th align="center">储物柜名称</th>
            <th align="center">类型</th>
            <th align="center">排数</th>
            <th align="center">门数</th>
            <th align="center">所属部门</th>
            <th align="center">所属仓库</th>
            <th align="center">保管员</th>
            <%--<c:choose>--%>
                <%--<c:when test="${status==null}">--%>
                    <%--<th align="center">创建人员</th>--%>
                    <%--<th align="center">生成时间</th>--%>
                    <%--<th align="center">修改时间</th>--%>
                    <%--<th align="center">集成类型</th>--%>
                <%--</c:when>--%>
            <%--</c:choose>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_DETAIL_SHOW)%>?id=${item.id}"
                       class="btn btn-green"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                    <c:choose>
                        <c:when test="${status==null}">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_UPDATE_SHOW)%>?id=${item.id}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="locker-update" data-title="储物柜编辑">编辑</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_DELETE_SUBMIT)%>?id=${item.id}"
                               class="btn btn-red"
                               data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_PAGE_SHOW)%>?lockerId=${item.id}&storeId=${storeId}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="locker-manage" data-title="管理储物柜：${item.lockerName}">管理储物柜</a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="getName('${item.id}','${item.lockerName}')" class="btn btn-close"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td align="center"><hs:out value="${item.id}" length="5"/></td>
                <td align="center"><hs:out value="${item.lockerName}" length="5"/></td>
                <td align="center"><c:choose>
                    <c:when test="${item.type=='0'}">
                        普通柜
                    </c:when>
                    <c:when test="${item.type=='1'}">
                        智能柜
                    </c:when>
                </c:choose></td>
                <td align="center"><hs:out value="${item.lockerRow}" length="5"/></td>
                <td align="center"><hs:out value="${item.lockerGate}" length="5"/></td>
                <td align="center"><hs:dept value="${item.deptId}"/></td>
                <td align="center"><hs:involvedStores value="${item.storeId}"/></td>
                <td align="center"><hs:user value="${item.userId}"/></td>
                <%--<c:choose>--%>
                    <%--<c:when test="${status==null}">--%>
                        <%--<td align="center"><hs:user value="${item.createUserId}"/></td>--%>
                        <%--<td align="center"><hs:datefmt value="${item.createTime}"--%>
                                                       <%--stringDatePatten="dataTimeFormat"/></td>--%>
                        <%--<td align="center"><hs:datefmt value="${item.editTime}"--%>
                                                       <%--stringDatePatten="dataTimeFormat"/></td>--%>
                        <%--<td align="center"><c:choose>--%>
                            <%--<c:when test="${item.integration=='1'}">--%>
                                <%--Socket集成--%>
                            <%--</c:when>--%>
                            <%--<c:when test="${item.integration=='2'}">--%>
                                <%--WebService集成--%>
                            <%--</c:when>--%>
                        <%--</c:choose></td>--%>
                    <%--</c:when>--%>
                <%--</c:choose>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>