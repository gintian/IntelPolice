<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.JJ_UNRELATED_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="jjdbh" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">接警单编号：</label>
            <input name="jjdbh" id="jjdbh" placeholder="请输入编号"
                   style="width: 200px;" value="${searchObj.jjdbh}">

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
            <th align="center">行政区划代码</th>
            <th align="center">接警单编号</th>
            <th align="center">报警时间</th>
            <th align="center">接警时间</th>
            <th align="center">报警人姓名</th>
            <th align="center">报警电话</th>
            <th align="center">警情地址</th>
            <th align="center">报警内容</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center"><a
                        href="${root}<%=Url.getUrl(Url.JJ_DETAIL_SHOW)%>?jjdbh=${item.jjdbh}"
                        class="btn btn-green" data-toggle="dialog" data-mask="true"
                        data-width="800" data-height="500">详情</a></td>
                <td title="${item.xzqhdm}" align="center"><hs:out
                        value="${item.xzqhdm}"/></td>
                <td title="${item.jjdbh}"><hs:out
                        value="${item.jjdbh}" length="5"/></td>
                <td title="${item.bjsj }" align="center"><hs:datefmt
                        value="${item.bjsj}" stringDatePatten="dateTimeFormat"/></td>
                <td title="${item.jjsj}" align="center"><hs:datefmt
                        value="${item.jjsj}" stringDatePatten="dateTimeFormat"/></td>
                <td title="${item.bjrxm}" align="center"><hs:out
                        value="${item.bjrxm}" length="5"/></td>
                <td title="${item.bjdh}" align="center"><hs:out
                        value="${item.bjdh}" length="13"/></td>
                <td title="${item.jqdz}" align="center"><hs:out
                        value="${item.jqdz}" length="10"/></td>
                <td title="${item.bjnr}" align="center"><hs:out
                        value="${item.bjnr}" length="10"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>