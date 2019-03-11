<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
	<form id="${searchFormId}" data-toggle="ajaxsearch"
		action="${root}<%=Url.getUrl(Url.HF_PAGE_SHOW)%>" method="post">
		<div class="bjui-searchBar">
			<label for="hfhsdbh" class="control-label"
				style="margin-left: 0px; padding-left: 0px; width: 60px;">回访核实单编号：</label>
			<input name="hfhsdbh" id="hfhsdbh" placeholder="请输入编号"
				style="width: 200px;" value="${searchObj.hfhsdbh}">

			<button type="button" class="showMoreSearch" data-toggle="moresearch"
				data-name="custom">
				<i class="fa fa-angle-double-down"></i>
			</button>
			<div class="bjui-moreSearch">
				<label for="jjdbh" class="control-label"
					style="margin-left: 0px; padding-left: 0px; width: 60px;">接警单编号：</label>
				<input name="jjdbh" id="jjdbh" placeholder="请输入编号"
					style="width: 200px;" value="${searchObj.jjdbh}">
			</div>
			<button type="submit" class="btn-blue" data-icon="search"
				id="query_base_show">查询</button>
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
				<th align="center">回访核实单编号</th>
				<th align="center">接警单编号</th>
				<th align="center">回访核实录音号</th>
				<th align="center">回访时间</th>
				<th align="center">回访人员姓名</th>
				<th align="center">被回访人姓名</th>
				<th align="center">回访核实情况</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td class="option" align="center"><a
							href="${root}<%=Url.getUrl(Url.HF_DETAIL_SHOW)%>?cjdbh=${item.hfhsdbh}"
							class="btn btn-green" data-toggle="dialog" data-mask="true"
							data-width="800" data-height="500">详情</a></td>
					<td title="${item.hfhsdbh}"><hs:out value="${item.hfhsdbh}"
							length="20" /></td>
					<td title="${item.jjdbh}"><hs:out value="${item.jjdbh}"
							length="20" /></td>
					<td title="${item.hfhslyh}"><hs:out value="${item.hfhslyh}"
							length="10" /></td>
					<td title="${item.hfsj}" align="center"><hs:datefmt
							value="${item.hfsj}" stringDatePatten="dateTimeFormat" /></td>
					<td title="${item.hfryxm}" align="center"><hs:out
							value="${item.hfryxm}" length="10" /></td>
					<td title="${item.bhfrxm}" align="center"><hs:out
							value="${item.bhfrxm}" length="5" /></td>
					<td title="${item.hfhsqk}" align="center"><hs:out
							value="${item.hfhsqk}" length="5" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp"%>