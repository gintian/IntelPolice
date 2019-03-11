<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
	<form id="${searchFormId}" data-toggle="ajaxsearch"
		action="${root}<%=Url.getUrl(Url.CJ_TIMEOUT_UNTREATED_SHOW)%>" method="post">
		<div class="bjui-searchBar">
			<label for="cjdbh" class="control-label"
				style="margin-left: 0px; padding-left: 0px; width: 60px;">处警单编号：</label>
			<input name="cjdbh" id="cjdbh" placeholder="请输入编号"
				style="width: 200px;" value="${searchObj.cjdbh}">

			<button type="button" class="showMoreSearch" data-toggle="moresearch"
				data-name="custom">
				<i class="fa fa-angle-double-down"></i>
			</button>
			<div class="bjui-moreSearch">
				<label for="jjdbh" class="control-label"
					style="margin-left: 0px; padding-left: 0px; width: 60px;">接警单编号：</label>
				<input name="jjdbh" id="jjdbh" placeholder="请输入编号"
					style="width: 200px;" value="${searchObj.jjdbh}"> <label
					for="xzqhdm" class="control-label"
					style="margin-left: 0px; padding-left: 0px; width: 60px;">行政区划代码：</label>
				<input name="xzqhdm" id="xzqhdm" placeholder="请输入编号"
					style="width: 200px;" value="${searchObj.xzqhdm}">
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
				<th align="center">行政区划代码</th>
				<th align="center">处警单编号</th>
				<th align="center">接警单编号</th>
				<th align="center">处警单位代码</th>
				<th align="center">处警员编号</th>
				<th align="center">处警时间</th>
				<th align="center">处警意见</th>
				<th align="center">警情状态代码</th>
				<th align="center">案件类型</th>
				<th align="center">立案情况</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td class="option" align="center"><a
							href="${root}<%=Url.getUrl(Url.CJ_TIMEOUT_CSWLA_DETAIL_SHOW)%>?cjdbh=${item.cjdbh}"
							class="btn btn-green" data-toggle="dialog" data-mask="true"
							data-width="800" data-height="500">详情</a></td>
					<td title="${item.xzqhdm}" align="center"><hs:out
							value="${item.xzqhdm}" length="10" /></td>
					<td title="${item.cjdbh}"><hs:out value="${item.cjdbh}"
							length="20" /></td>
					<td title="${item.jjdbh}"><hs:out value="${item.jjdbh}"
							length="20" /></td>
					<td title="${item.cjdwdm}"><hs:out value="${item.cjdwdm}"
							length="10" /></td>
					<td title="${item.cjybh}" align="center"><hs:out
							value="${item.cjybh}" length="10" /></td>
					<td title="${item.cjsj}" align="center"><hs:datefmt
							value="${item.cjsj}" stringDatePatten="dateTimeFormat" /></td>
					<td title="${item.cjyj}" align="center"><hs:out
							value="${item.cjyj}" length="5" /></td>
					<td title="${item.jqztdm}" align="center"><hs:out
							value="${item.jqztdm}" length="5" /></td>
					<c:set var="caseTypeCode" value="${fn:substring(item.caseType,0,2)}" />
					<td  align="center">
						<c:if test="${caseTypeCode eq '01'}">
							刑事案件
						</c:if>
						<c:if test="${caseTypeCode eq '02'}">
							行政案件
						</c:if>
					</td>
					<td>
						<c:if test="${caseTypeCode eq '01'}">
							<c:if test="${item.atimeDouble > 3 and item.atimeDouble <= 30}">
								提醒
							</c:if>
							<c:if test="${item.atimeDouble > 30}">
								异常
							</c:if>
						</c:if>
						<c:if test="${caseTypeCode eq '02'}">
							<c:if test="${item.atimeDouble > 1 and item.atimeDouble <= 3}">
								提醒
							</c:if>
							<c:if test="${item.atimeDouble > 3}">
								异常
							</c:if>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp"%>