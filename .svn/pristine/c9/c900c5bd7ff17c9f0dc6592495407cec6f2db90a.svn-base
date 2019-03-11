<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch"
          action="${root}<%=Url.getUrl(Url.FK_PAGE_SHOW)%>" method="post">
        <div class="bjui-searchBar">
            <label for="fkdbh" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">反馈单编号：</label>
            <input name="fkdbh" id="fkdbh" placeholder="请输入编号"
                   style="width: 200px;" value="${searchObj.fkdbh}">
            <label for="xzqhdm" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">行政区划代码：</label>
            <input name="xzqhdm" id="xzqhdm" placeholder="请输入编号"
                   style="width: 200px;" value="${searchObj.xzqhdm}">

            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="jjdbh" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">接警单编号：</label>
                <input name="jjdbh" id="jjdbh" placeholder="请输入编号"
                       style="width: 200px;" value="${searchObj.jjdbh}">
                <label for="cjdbh" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">处警单编号：</label>
                <input name="cjdbh" id="cjdbh" placeholder="请输入编号"
                       style="width: 200px;" value="${searchObj.cjdbh}">
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
            <th align="center">反馈单编号</th>
            <th align="center">接警单编号</th>
            <th align="center">处警单编号</th>
            <th align="center">出警情况</th>
            <th align="center">处理结果</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center"><a
                        href="${root}<%=Url.getUrl(Url.FK_DETAIL_SHOW)%>?fkdbh=${item.fkdbh}"
                        class="btn btn-green" data-toggle="dialog" data-mask="true"
                        data-width="800" data-height="500">详情</a></td>
                <td title="${item.xzqhdm}" align="center"><hs:out value="${item.xzqhdm}" length="10"/></td>
                <td title="${item.fkdbh}"><hs:out value="${item.fkdbh}" length="5"/></td>
                <td title="${item.jjdbh}"><hs:out value="${item.jjdbh}" length="5"/></td>
                <td title="${item.cjdbh}"><hs:out value="${item.cjdbh}" length="5"/></td>
                <td title="${item.cjqk}"><hs:out value="${item.cjqk}" length="10"/></td>
                <td title="${item.cljg}"><hs:out value="${item.cljg}" length="10"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>