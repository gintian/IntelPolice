<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
	<c:choose>
		<c:when test="${empty entity or empty entity.id}">
			<form action="${root}<%=Url.getUrl(Url.DEPT_ADD_SUBMIT)%>"
				data-toggle="validate" data-reload-navtab="true" method="post">
		</c:when>
		<c:otherwise>
			<form action="${root}<%=Url.getUrl(Url.DEPT_UPDATE_SUBMIT)%>"
				data-toggle="validate" data-reload-navtab="true" method="post">
				<input type="hidden" name="id" value="${entity.id}">
		</c:otherwise>
	</c:choose>
	<div class="bjui-row col-2">
		<label class="row-label" for="dept_name">部门名称<span
			class="required">*</span>：
		</label>
		<div class="row-input required">
			<input type="text" id="dept_name" name="name"
				data-rule="required" maxlength="40" value="${entity.name}"
				placeholder="请输入名称，最多40字">
		</div>
		<label class="row-label" >上级部门<span
			class="required">*</span>：
		</label>
		<div class="row-input required">
			<input name="parentId" id="dept_parentId" value="${entity.parentId}" type="hidden">
			<input name="parentName" id="dept_parentName" value="<hs:dept value="${entity.parentId}"/>" data-rule="required" readonly type="text">
			<a href="${root}<%=Url.getUrl(Url.DEPT_TREE_SHOW)%>" data-icon="search" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>

		</div>
		<label class="row-label" for="dept_customId">业务对照码：
		</label>
		<div class="row-input">
			<input type="text" id="dept_customId" name="customId"
				maxlength="50" value="${entity.customId}"
				placeholder="50">
		</div>
		<label class="row-label" for="dept_status">启用状态： </label>
		<div class="row-input required">
		<c:choose>
				<c:when test="${entity.status == 0}">
					<input name="status" id="dept_status" data-toggle="icheck" data-rule="required"  value="0"
						checked="checked" data-label="不启用" type="radio">
					<input name="status" id="dept_status" data-toggle="icheck" data-rule="required"  value="1"
						data-label="启用" type="radio">
				</c:when>
				<c:otherwise>
					<input name="status" id="dept_status" data-toggle="icheck" data-rule="required"  value="0"
						data-label="不启用" type="radio">
					<input name="status" id="dept_status" data-toggle="icheck" data-rule="required"  value="1"
						checked="checked" data-label="启用" type="radio">
				</c:otherwise>
		</c:choose>
		</div>
		<label class="row-label" for="dept_sortNo">排序号：
		</label>
		<div class="row-input">
			<input type="text" id="dept_sortNo" name="sortNo"
				maxlength="50" width="50" value="${entity.sortNo}"
				placeholder="50" >
		</div>
		<label class="row-label" for="dept_leaf">是否为子部门： </label>
		<div class="row-input required">
		<c:choose>
				<c:when test="${entity.leaf == 0}">
					<input name="leaf" id="dept_leaf" data-toggle="icheck" data-rule="required"  value="0"
						checked="checked" data-label="否" type="radio">
					<input name="leaf" id="dept_leaf" data-toggle="icheck" data-rule="required"  value="1"
						data-label="是" type="radio">
				</c:when>
				<c:otherwise>
					<input name="leaf" id="dept_leaf" data-toggle="icheck" data-rule="required"  value="0"
						data-label="否" type="radio">
					<input name="leaf" id="dept_leaf" data-toggle="icheck" data-rule="required"  value="1"
						checked="checked" data-label="是" type="radio">
				</c:otherwise>
		</c:choose>
		</div>
		<label class="row-label" for="dept_remark">备注： </label>
		<div class="row-input">
			<textarea name="remark" id="dept_remark" maxlength="400" data-toggle="autoheight" cols="60" rows="1">
				${entity.remark}
			</textarea>
		</div><br>
		<label class="row-label" for="dept_isCaseUnit">是否执法单位： </label>
		<div class="row-input">
		<c:choose>
				<c:when test="${entity.isCaseUnit == 0}">
					<input name="isCaseUnit" id="dept_isCaseUnit" data-toggle="icheck" value="0"
						checked="checked" data-label="否" type="radio">
					<input name="isCaseUnit" id="dept_isCaseUnit" data-toggle="icheck" value="1"
						data-label="是" type="radio">
				</c:when>
				<c:otherwise>
					<input name="isCaseUnit" id="dept_isCaseUnit" data-toggle="icheck" value="0"
						data-label="否" type="radio">
					<input name="isCaseUnit" id="dept_isCaseUnit" data-toggle="icheck" value="1"
						checked="checked" data-label="是" type="radio">
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</form>
</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button class="btn-close btn" type="button" data-icon="close">
				<i class="fa fa-close">取消</i>
			</button></li>
		<li><button class="btn-close btn" type="submit"  data-icon="save" data-toggle="navtab" >保存</button></li>
	</ul>
</div>