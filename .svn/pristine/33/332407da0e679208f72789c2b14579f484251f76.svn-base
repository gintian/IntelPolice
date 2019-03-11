<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.LY_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="lybh" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">录音编号：</label>
            <input name="lybh" id="lybh" placeholder="请输入编号"
                   style="width: 200px;" value="${searchObj.lybh}">

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="xzqhdm" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">行政区划代码：</label>
                <input name="xzqhdm" id="xzqhdm" placeholder="请输入编号"
                       style="width: 200px;" value="${searchObj.xzqhdm}">
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
            <th align="center">操作</th>
            <th align="center">录音编号</th>
            <th align="center">电话类型</th>
            <th align="center">来电号码</th>
            <th align="center">坐席号</th>
            <th align="center">操作员编号</th>
            <th align="center">接警编号</th>
            <th align="center">录音开始时间</th>
            <th align="center">录音结束时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center">
                    <a href="${root}<%=Url.getUrl(Url.LY_DETAIL_SHOW)%>?cjdbh=${item.cjdbh}"
                       class="btn btn-green" data-toggle="dialog" data-mask="true"
                       data-width="800" data-height="500">详情</a></td>
                <td title="${item.lybh}" align="center"><hs:out value="${item.lybh}" length="10"/></td>
                <td title="${item.dhlx}" align="center"><hs:out value="${item.dhlx}" length="20"/></td>
                <td title="${item.ldhm}" align="center"><hs:out value="${item.ldhm}" length="20"/></td>
                <td title="${item.zxh}" align="center"><hs:out value="${item.zxh}" length="10"/></td>
                <td title="${item.czybh}" align="center"><hs:out value="${item.czybh}" length="10"/></td>
                <td title="${item.jjdbh}" align="center"><hs:out value="${item.jjdbh}" length="10"/></td>
                <td title="${item.lykssj}" align="center"><hs:datefmt value="${item.lykssj}"
                                                                      stringDatePatten="dateTimeFormat"/></td>
                <td title="${item.lyjssj}" align="center"><hs:datefmt value="${item.lyjssj}"
                                                                      stringDatePatten="dateTimeFormat"/></td>
                <td title="${item.xzqhdm}" align="center"><hs:out value="${item.xzqhdm}" length="10"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>