<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.FEEDBACK_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">ID：</label>
            <input name="id" id="id" placeholder="请输入ID" style="width: 200px;"
                   value="${searchObj.id}">
            <label for="title" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">标题：</label>
            <input name="title" id="title" placeholder="请输入标题" style="width: 200px;"
                   value="${searchObj.title}">
            <label for="status" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">显示类型：</label>
            <select name="status" id="status" data-toggle="selectpicker">
                <option value="3">全部</option>
                <option value="1">正常</option>
                <option value="2">置顶</option>
            </select>

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="createUserId" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">留言ID：</label>
                <input name="createUserId" id="createUserId" placeholder="请输入创建人ID"
                       style="width: 200px;" value="${searchObj.createUserId}">
                <label for="createUserName" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">留言人姓名：</label>
                <input name="createUserName" id="createUserName" placeholder="请输入创建人姓名"
                       style="width: 200px;" value="${searchObj.createUserName}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>

        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="50" align="center">操作</th>
            <th align="center">留言标题</th>
            <th align="center">留言姓名</th>
            <th align="center">联系电话</th>
            <th width="80" align="center">地点</th>
            <th align="center">创建时间</th>
            <th align="center">业务类型</th>
            <th width="40" align="center">浏览次数</th>
            <th width="40" align="center">处理次数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <td class="option" align="center">
                <a href="${root}<%=Url.getUrl(Url.FEEDBACK_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                   data-toggle="dialog" data-mask="true" data-width="600" data-height="500">查看</a>
            </td>
            <td><hs:out value="${item.title}"/></td>
            <td><hs:out value="${item.createUserName}"/></td>
            <td><hs:out value="${item.telephone}"/></td>
            <td align="center"><hs:out value="${item.address}"/></td>
            <td><hs:datefmt value="${item.createTime}"
                            stringDatePatten="dataTimeFormat"/></td>
            <td align="center">
                <c:choose>
                    <c:when test="${item.businessType == 1}">
                        类型一
                    </c:when>
                    <c:when test="${item.businessType == 2}">
                        类型二
                    </c:when>
                    <c:otherwise>
                        其他类型
                    </c:otherwise>
                </c:choose>
            </td>
            <td align="center"><hs:out value="${item.lookTimes}"/></td>
            <td align="center"><hs:out value="${item.processTimes}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>