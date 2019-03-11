<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.CMD_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="id" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">ID：</label>
            <input name="id" id="id" placeholder="请输入ID" style="width: 200px;"
                   value="${searchObj.id}">

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="sjbh" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">事件编号：</label>
                <input name="sjbh" id="sjbh" placeholder="请输入编号"
                       style="width: 200px;" value="${searchObj.sjbh}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search"
                    id="query_base_show">查询
            </button>
            <a class="btn btn-orange reset" href="javascript:;"
               data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table
            class="table table-bordered table-hover table-striped table-top data_table table_center"
            data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="50" align="center">操作</th>
            <th width="40" align="center">编号</th>
            <th width="70" align="center">事件编号</th>
            <th width="70" align="center">报警时间</th>
            <th width="100" align="center">指令下发时间</th>
            <th width="100" align="center">发案地点</th>
            <th width="100" align="center">指定出警单位</th>
            <th width="120" align="center">接处警系统编号</th>
            <th width="100" align="center">指令到达时间</th>
            <th width="60" align="center">状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center">
                    <sys:permission url="<%=Url.getUrl(Url.CMD_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.CMD_DETAIL_SHOW)%>?id=${item.id}"
                           class="btn btn-green" data-toggle="dialog" data-mask="true"
                           data-width="800" data-height="500">详情</a>
                    </sys:permission>
                </td>
                <td title="${item.id}" align="center"><hs:out
                        value="${item.id}" length="5"/></td>
                <td title="${item.sjbh}" align="center"><hs:out
                        value="${item.sjbh}" length="5"/></td>
                <td title="${item.bjsj}" align="center"><hs:datefmt
                        value="${item.bjsj}" stringDatePatten="dataTimeFormat"/></td>
                <td title="${item.zlxfsj}" align="center"><hs:datefmt
                        value="${item.zlxfsj}" stringDatePatten="dataTimeFormat"/></td>
                <td title="${item.fadd}"><hs:out
                        value="${item.fadd}"/></td>
                <td title="${item.zdcjdw}" align="center"><hs:out
                        value="${item.zdcjdw}"/></td>
                <td title="${item.jcjxtbh}" align="center"><hs:out
                        value="${item.jcjxtbh}"/></td>
                <td title="${item.zlddsj}" align="center"><hs:datefmt value="${item.zlddsj}"
                                                                      stringDatePatten="dataTimeFormat"/></td>
                <td title="${item.jcjxtbh}" align="center"><c:choose>
                    <c:when test="${item.jcjxtbh == 0}">
                        未处理
                    </c:when>
                    <c:when test="${item.jcjxtbh == 1}">
                        已处警
                    </c:when>
                    <c:otherwise>
                        无效警
                    </c:otherwise>
                </c:choose></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>