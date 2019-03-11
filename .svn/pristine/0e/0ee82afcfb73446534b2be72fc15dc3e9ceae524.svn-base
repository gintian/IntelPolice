<%@ page language="java" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/common_prefix.jsp"%>

<div class="bjui-pageContent">
	<input type="hidden" id="roleUrl" value="${root}<%=Url.getUrl(Url.USER_MENU_BY_DEPTID)%>">
	<c:choose>
		<c:when test="${empty entity or empty entity.id}">
			<form action="${root}<%=Url.getUrl(Url.USER_ADD_SUBMIT)%>"
				data-toggle="validate" data-reload-navtab="true" method="post">
		</c:when>
		<c:otherwise>
			<form action="${root}<%=Url.getUrl(Url.USER_UPDATE_SUBMIT)%>"
				data-toggle="validate" data-reload-navtab="true" method="post">
				<input type="hidden" name="id" value="${entity.id}">
		</c:otherwise>
	</c:choose>
	<div class="bjui-row col-2">
		<label class="row-label" for="user_name">姓名<span class="required">*</span>：
		</label>
		<div class="row-input required">
			<input type="text" id="user_name" name="name" data-rule="required"
				maxlength="40" value="${entity.name}" placeholder="请输入名称，最多40字">
		</div>
		<label class="row-label" for="user_account">账户<span class="required">*</span>：
		</label>
		<div class="row-input required">
			<input type="text" id="user_account" name="account"
				data-rule="required" maxlength="30" value="${entity.account}"
				placeholder="请输入账户，最多30字">
		</div>
		<br>
		<c:if test="${empty entity or empty entity.id}">
			<label class="row-label" for="user_password">密码<span class="required">*</span>：
			</label>
			<div class="row-input required">
				<input type="password" id="user_password" <c:if test="${entity.id != null && entity.id != ''}">readonly</c:if> name="password"
					   data-rule="password" maxlength="30"
					   placeholder="50">
			</div>
		</c:if>
		<br>
		<label class="row-label">性别<span class="required">*</span>：
		</label>
		<div class="row-input required">

			<c:choose>
				<c:when test="${entity.sex == 0}">
					<input name="sex" id="user_sex" data-toggle="icheck" value="0"
						checked="checked" data-label="未知" type="radio">
					<input name="sex" id="user_sex" data-toggle="icheck" value="1"
						data-label="男" type="radio">
					<input name="sex" id="user_sex" data-toggle="icheck" value="2"
						data-label="女" type="radio">
				</c:when>
				<c:when test="${entity.sex == 1}">
					<input name="sex" id="user_sex" data-toggle="icheck" value="0"
						data-label="未知" type="radio">
					<input name="sex" id="user_sex" data-toggle="icheck" value="1"
						checked="checked" data-label="男" type="radio">
					<input name="sex" id="user_sex" data-toggle="icheck" value="2"
						data-label="女" type="radio">
				</c:when>
				<c:otherwise>
					<input name="sex" id="user_sex" data-toggle="icheck" value="0"
						data-label="未知" type="radio">
					<input name="sex" id="user_sex" data-toggle="icheck" value="1"
						data-label="男" type="radio">
					<input name="sex" id="user_sex" data-toggle="icheck" value="2"
						checked="checked" data-label="女" type="radio">
				</c:otherwise>
			</c:choose>
		</div>
		<label class="row-label" for="user_locked">锁定状态<span
			class="required">*</span>：
		</label>
		<div class="row-input required">
			<c:choose>
				<c:when test="${entity.locked == 0}">
					<input name="locked" id="user_locked" data-toggle="icheck"
						value="0" checked="checked" data-label="激活" type="radio">
					<input name="locked" id="user_locked" data-toggle="icheck"
						value="1" data-label="锁定" type="radio">
				</c:when>
				<c:otherwise>
					<input name="locked" id="user_locked" data-toggle="icheck"
						value="0" data-label="激活" type="radio">
					<input name="locked" id="user_locked" data-toggle="icheck"
						value="1" checked="checked" data-label="锁定" type="radio">
				</c:otherwise>
			</c:choose>
		</div>
		<br>
		<label class="row-label">所属部门<span
				class="required">*</span>：
		</label>
		<div class="row-input required">
			<input name="deptName" id="user_deptName" readonly data-rule="required" value="<hs:dept value='${entity.deptId}'/>"  type="text">
			<input name="deptId" id="user_deptId" value="${entity.deptId}" type="hidden">
			<a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-icon="search" class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
		</div>

		<label class="row-label">人员角色： </label>
		<div class="row-input">
			<%--<select id="select_RoleId" name="roleIds" data-rule="required" data-width="200" multiple="">
			</select>--%>
			<select id="select_RoleId"  name="roleIds" data-rule="required">
				<option value="">请选择部门</option>
			</select>
		</div>
		<br>
		<label class="row-label">用户类型： </label>
		<div class="row-input">
			<select data-toggle="selectpicker" name="userType" data-width="200">
				<c:forEach items="${userTypeBeanList}" var="type">
					<option value="${type.id}" <c:if test="${fn:indexOf(entity.userType, type.id) != -1}">selected</c:if>>${type.label}</option>
				</c:forEach>
			</select>
		</div>
		<label class="row-label" for="user_policeNumber">警号： </label>
		<div class="row-input">
			<input type="text" id="user_policeNumber" name="policeNumber"
				maxlength="100" value="${entity.policeNumber}"
				placeholder="请输入警号，最多100字">
		</div>
		<br>
		<label class="row-label" for="user_shortPhone">短号： </label>
		<div class="row-input">
			<input type="text" id="user_shortPhone" name="shortPhone"
				maxlength="15" data-rule="tel" value="${entity.shortPhone}"
				placeholder="请输入短号，最多15字">
		</div>
		<label class="row-label" for="user_phone">联系电话： </label>
		<div class="row-input">
			<input type="text" id="user_phone" name="phone" maxlength="15"
				data-rule="mobile" value="${entity.phone}"
				placeholder="请输入联系电话，最多15字">
		</div>
		<br>
		<label class="row-label" for="user_status">启用状态<span
			class="required">*</span>：
		</label>
		<div class="row-input required">
			<c:choose>
				<c:when test="${entity.status == 1 || entity == null || entity.status == null}">
					<input name="status" id="user_status" data-toggle="icheck"
						value="0"  data-label="不启用" type="radio">
					<input name="status" id="user_status" data-toggle="icheck"
						value="1" checked="checked" data-label="启用" type="radio">
				</c:when>
				<c:otherwise>
					<input name="status" id="user_status" data-toggle="icheck"
						value="0" checked="checked" data-label="不启用" type="radio">
					<input name="status" id="user_status" data-toggle="icheck"
						value="1"  data-label="启用" type="radio">
				</c:otherwise>
			</c:choose>
		</div>
		<label class="row-label" for="user_identityCard">身份证号： </label>
		<div class="row-input">
			<input type="text" id="user_identityCard" name="identityCard"
				maxlength="20" data-rule="IDcard" data-rule="required" value="${entity.identityCard}"
				placeholder="请输入添加人警号，最多20字">
		</div>
		<br>
		<label class="row-label" for="user_remark">备注： </label>
		<div class="row-input">
			<textarea name="remark" id="user_remark" maxlength="400"
					  data-toggle="autoheight" cols="60" rows="1">
				${entity.remark}
			</textarea>
		</div>
		<br>
	</div>
	</form>
</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button class="btn-close btn" type="button" data-icon="close">
				<i class="fa fa-close">取消</i>
			</button></li>
		<li><button class="btn-close btn" type="submit" data-icon="save"
				 data-target="menu01010202" onclick="BJUI.navtab('refresh', 'menu01010202')">保存</button>
		</li>
	</ul>
</div>
<script>
	var deptId ="${entity.deptId}";
	var roleUrl = $("#roleUrl").val();
	var roleIds = "${roleIds}";
	$(function () {
		if (deptId) {
			query_menuByDeptId();
		}
	})

	//根据部门查询角色
	function query_menuByDeptId() {

		BJUI.ajax('doajax', {
			url:roleUrl,
			data:{"deptId":deptId},
			okCallback: function(json, options) {
				console.log('返回内容：\n'+ JSON.stringify(json))
				$.CurrentNavtab.find("#select_RoleId").html("");
				if (CommonUtilValidate.isEmpty(json.list)){
					$.CurrentNavtab.find("#select_RoleId").html("<option value=''>请选择部门</option>");
				}

				$.each(json.list, function (n, role) {
					var select = "";
					if (roleIds.indexOf(role.id) != -1){
						select = "selected";
					}
					var html = "<option value='"+role.id+"'"+select+">"+role.name+"</option>"
					$.CurrentNavtab.find("#select_RoleId").append(html);
				});
			}
		})
	}
	var appendSelect = function (json) {

	}
</script>

