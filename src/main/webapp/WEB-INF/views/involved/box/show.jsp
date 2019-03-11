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
                  action="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_PAGE_SHOW)%>" method="post">
                <div class="bjui-searchBar">
                    <label for="id" class="control-label"
                           style="margin-left: 0px; padding-left: 0px; width: 60px;">箱子ID：</label>
                    <input name="id" id="id" placeholder="请输入箱子ID" style="width: 200px;"
                           value="${searchObj.id}">
                    <label for="boxNo" class="control-label"
                           style="margin-left: 0px; padding-left: 0px; width: 60px;">箱子编号：</label>
                    <input name="boxNo" id="boxNo" placeholder="请输入箱子编号" style="width: 200px;"
                           value="${searchObj.boxNo}">

                    <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
                    <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                       data-clear-query="true"
                       data-icon="undo">清空查询</a>

                    <div class="pull-right">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_ADD_SHOW)%>?storeId=${storeId}&lockerId=${lockerId}"
                           data-toggle="navtab" class="btn btn-blue" data-id="navtab" data-title="新增">新增</a>
                    </div>
                </div>
            </form>
        </div>
    </c:when>
</c:choose>
<script>
    function getBoxNo(id, boxNo) {
        $.CurrentNavtab.find("#involved_boxId").val(id);
        $.CurrentNavtab.find("#involved_boxNo").val(boxNo);
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="160" align="center">操作</th>
            <th align="center">箱子ID</th>
            <th align="center">箱子编号</th>
            <th align="center">仓库ID</th>
            <th align="center">储物柜ID</th>
            <th align="center">长</th>
            <th align="center">宽</th>
            <th align="center">高</th>
            <th align="center">保管员</th>
            <c:choose>
                <c:when test="${status==null}">
                    <th align="center">生产人员</th>
                    <th align="center">生成时间</th>
                    <th align="center">修改时间</th>
                    <th align="center">开关状态</th>
                </c:when>
            </c:choose>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option">
                    <c:choose>
                        <c:when test="${status==null}">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_OPEN_BOX)%>?id=${item.id}"
                               class="btn btn-green"
                               data-toggle="doajax" data-confirm-msg="确定要打开箱子吗？">开箱</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_DETAIL_SHOW)%>?id=${item.id}"
                               class="btn btn-green"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_UPDATE_SHOW)%>?id=${item.id}"
                               class="btn btn-blue"
                               data-toggle="navtab" data-id="navtab" data-title="编辑">编辑</a>
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_DELETE_SUBMIT)%>?id=${item.id}"
                               class="btn btn-red"
                               data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="getBoxNo('${item.id}','${item.boxNo}')" class="btn btn-close"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><hs:out value="${item.id}" length="5"/></td>
                <td><hs:out value="${item.boxNo}"/></td>
                <td><hs:involvedStores value="${item.storeId}"/></td>
                <td><hs:involvedStoresLockers value="${item.lockerId}"/></td>
                <td><hs:out value="${item.length}" length="5"/></td>
                <td><hs:out value="${item.width}" length="5"/></td>
                <td><hs:out value="${item.height}" length="5"/></td>
                <td><hs:user value="${item.userId}"/></td>
                <c:choose>
                    <c:when test="${status==null}">
                        <td><hs:user value="${item.createUserId}"/></td>
                        <td align="center"><hs:datefmt value="${item.createTime}"
                                                       stringDatePatten="dataTimeFormat"/></td>
                        <td align="center"><hs:datefmt value="${item.editTime}"
                                                       stringDatePatten="dataTimeFormat"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${item.state==0}">
                                    关闭
                                </c:when>
                                <c:when test="${item.state==1}">
                                    打开
                                </c:when>
                                <c:otherwise>
                                    未知
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>