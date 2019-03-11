<%--
  Created by IntelliJ IDEA.
  User: 45509
  Date: 2018/5/30
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.JD_MEDIA)%>" method="post">
        <div class="bjui-searchBar">
            <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">名称：</label>
            <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.name}">
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
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>


            <div class="pull-right">
                <sys:permission url="<%=Url.getUrl(Url.MEDIA_ADD_SHOW)%>">
                    <a href="${root}<%=Url.getUrl(Url.MEDIA_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog"
                       data-mask="true" data-width="500" data-height="500" data-title="新增">新增</a>
                </sys:permission>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th align="center">操作</th>
            <th>名称</th>
            <th>添加人警号</th>
            <th>添加人姓名</th>
            <th>执法记录仪编号</th>
            <th>记录地点</th>
            <th>记录地点坐标</th>
            <th>记录时间</th>
            <th>到期时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center">
                    <sys:permission url="<%=Url.getUrl(Url.MEDIA_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.MEDIA_DETAIL_SHOW)%>?id=${item.id}" class="btn btn-green"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="详情">详情</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.MEDIA_UPDATE_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.MEDIA_UPDATE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">编辑</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.MEDIA_DELETE_SUBMIT)%>">
                        <a href="${root}<%=Url.getUrl(Url.MEDIA_DELETE_SUBMIT)%>?id=${item.id}" class="btn btn-red"
                           data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.MEDIA_FILE_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.MEDIA_FILE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">查看文件</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.MEDIA_CASE_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.MEDIA_CASE_SHOW)%>?id=${item.id}" class="btn btn-blue"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-confirm-msg="编辑">关联案件</a>
                    </sys:permission>
                </td>
                <td title="${item.name}"><hs:out value="${item.name}" length="5"/></td>
                <td title="${item.tjrbh}"><hs:out value="${item.tjrbh}" length="5"/></td>
                <td title="${item.tjrxm}"><hs:out value="${item.tjrxm}" length="5"/></td>
                <td title="${item.jlybh}"><hs:out value="${item.jlybh}" length="5"/></td>
                <td title="${item.jldd}"><hs:out value="${item.jldd}" length="5" /></td>
                <td title="${item.jlddzb}"><hs:out value="${item.jlddzb}" length="5"/></td>
                <td ><hs:datefmt value="${item.jlsj}" stringDatePatten="dateTimeFormat"/></td>
                <td><hs:datefmt value="${item.dqsj}" stringDatePatten="dateTimeFormat"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>