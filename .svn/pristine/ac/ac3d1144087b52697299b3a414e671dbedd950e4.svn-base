<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@include file="/WEB-INF/views/common_e.jsp"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<script type="text/javascript">
		function Create() {
			// 清空对话框里面的表单内容
			$("#recordForm").form("clear");
			// 打开对话框
			$("#recordDatagrid").dialog("open");
		}
		//删除
		function Del() {
			//判断：是否选中，没有选：弹一个提示；选中：弹一个删除的确认框
			var rows = $("#recordDatagrid").datagrid('getSelections');//获取一行
			if (rows.length<2&rows.length>0) {
				//有数据
				$.messager.confirm('温馨提示', '你确定要删除ID为：\'' + rows[0].recordId + '\'的笔录吗？',
						function(r) {
							if (r) {
								$.get('${root}<%=Url.getUrl(Url.RECORD_DELETE_SUBMIT)%>',{
									recordId : rows[0].recordId
								},function(result) {
										//Result：json
										if (result.success) {
											$.messager.alert('温馨提示',
													result.message, "info")
											//刷新datagrid
											$("#recordDatagrid").datagrid('reload');
										} else {
											//删除失败
											$.messager.alert('温馨提示',
													result.message, "error")
									 }
								}, 'json');
							}
						});
			} else {
				$.messager.alert('温馨提示', '请选择你要删除的数据', "info")
			}
		}
		//添加
		function Add() {
			//弹出dialog
			$("#recordDialog").dialog('open').dialog('center').dialog('setTitle',
			'笔录添加');
			//userForm:清空表单
			$("#recordForm").form('clear');
			//打开dialog的时候：设置一个状态的默认值：defaultValue
			//$("#defaultValue").attr("checked",true);
			$("#defaultValue").prop("checked", true);
		}
		//修改
		function Edit() {
			//判断是否选中一条需要编辑的数据
			//选中再弹出
			var rows = $("#recordDatagrid").datagrid('getSelections');//获取一行
			if (rows.length<2&rows.length>0) {
				//弹出dialog
				$("#recordDialog").dialog('open').dialog('center').dialog('setTitle',
						'笔录编辑');
				//recordForm：load：回显
				$("#recordForm").form('load', rows[0]);
			} else {
				$.messager.alert('温馨提示', '请选择一行你要编辑的数据', "info")
			}
		}
		//查询
		function doSearch(){
			$("#recordSearch").form('submit',{
				success : function(data) {
					//json字符串转为对象
					var $data = $.parseJSON(data);
	    			$('#recordDatagrid').datagrid('loadData',$data);
				}
			})
	    }
		//保存
		function Save() {
				var url;
				alert($("#recordId").val);
	            debugger;
	            if ($("#recordId").val()){
	                url = '${root}<%=Url.getUrl(Url.RECORD_UPDATE_SUBMIT)%>'
	            }else {
	                url = '${root}<%=Url.getUrl(Url.RECORD_ADD_SUBMIT)%>'
	            }
	            $("#recordForm").form('submit', {
	                url : url,
	                success : function(data) {
						var $data = $.parseJSON(data);
						if ($data.success) {
							$.messager.alert('温馨提示', "操作成功", "info");
							$("#recordDialog").dialog('close');//关闭
							//刷新datagrid
							$("#recordDatagrid").datagrid('reload');
							 flushDataPage();
						} else {
							//失败
							$.messager.alert('温馨提示', $data.message, "error");
							$("#recordDialog").dialog('close');//关闭
						}
					}
				});
			}
		//取消
		function Cancle() {
			$("#recordDialog").dialog('close');//关闭
		}
</script>
<script type="text/javascript">
	$(function() {
		//刷新
		$("#refresh").click(function() {
			//reload
			$("#recordDatagrid").datagrid("reload");
		})
	})
	$(function() {
		$('#recordDatagrid').datagrid({
			title : "笔录",
			iconCls : 'icon-ok',
			width : 600,
			pageSize : 10,//默认选择的分页是每页5行数据  
			pageList : [ 10, 20, 30, 50 ],//可以选择的分页集合  
			nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
			striped : true,//设置为true将交替显示行背景。  
			collapsible : true,//显示可折叠按钮  
			toolbar : "#recordTool",//在添加 增添、删除、修改操作的按钮要用到这个  
			loadMsg : '数据装载中......', 
			fitColumns : true,//允许表格自动缩放，以适应父容器  
			fit : "true",
			sortName : 'recordId',//当数据表格初始化时以哪一列来排序  
			sortOrder : 'asc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
			remoteSort : false,
			pagination : true,//分页  
			rownumbers : true
		});
	});
</script>

	<table id="recordDatagrid" class="table table-hover easyui-datagrid"
		style="width: 100%; height: 100%;">
		<thead> 
			<tr>
				<th data-options="field:'rowId',checkbox:true"></th> 
				<th data-options="field:'recordId',width:'100',title:'笔录ID',sortable:true"></th>
				<th data-options="field:'caseId',width:'100',title:'案件ID',sortable:true"></th>
				<th data-options="field:'deptId',width:'100',title:'笔录单位ID',sortable:true"></th>
				<th data-options="field:'userId',width:'100',title:'询问人ID',sortable:true"></th>
				<th data-options="field:'xwsj',width:'100',title:'询问时间',sortable:true"></th>
				<th data-options="field:'blryid',width:'100',title:'笔录人员ID',sortable:true"></th>
				<th data-options="field:'recordContent',width:'150',title:'笔录内容',sortable:true"></th>
				<th data-options="field:'blsj',width:'150',title:'笔录时间',sortable:true"></th>
				<th data-options="field:'bxwr',width:'150',title:'被询问人',sortable:true"></th>
				<th data-options="field:'bxwrsfz',width:'150',title:'被询问人身份证号',sortable:true"></th>
				<th data-options="field:'isrddb',width:'150',title:'是否为人大代表',sortable:true"></th>
				<th data-options="field:'bxwraddr',width:'150',title:'居住地址',sortable:true"></th>
				<th data-options="field:'bxwrphone',width:'150',title:'联系方式',sortable:true"></th>
			</tr>
		</thead>
	</table>
<!-- 表格工具栏开始 -->
<div id="recordTool" style="padding: 5px; height: auto">
			<div style="margin-bottom: 5px">
				<a href="javascript:void(0)" onclick="Add()" class="easyui-linkbutton c1" iconCls="icon-add" plain="true" style="width: 100px">新增</a> 
				<a href="javascript:void(0)" onclick="Edit()" class="easyui-linkbutton c3" iconCls="icon-edit" plain="true" style="width: 100px">修改</a> 
				<a href="javascript:void(0)" onclick="Del()" class="easyui-linkbutton c7" iconCls="icon-remove" plain="true" style="width: 100px">删除</a>
			</div>
			<form id="recordSearch">
				<span>笔录ID:</span>
					 <input id="recordId" name="recordId" class="easyui-text" style="width:80px">
				<span>案件ID:</span>
					 <input id="caseId" name="caseId" class="easyui-text" style="width:80px">
					<a href="#" class="easyui-linkbutton c4" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>
			</form>
</div>
<!-- 表格工具栏结束 -->
<!-- 	添加或者修改的dialog：模态窗口 -->
    <div id="recordDialog" class="easyui-dialog" style="width:600px"
            closed="true" buttons="#dlg-buttons" data-options=" modal:true,
                draggable:false, resizable:false">
        <form id="recordForm" method="post" novalidate style="margin:0;padding:20px 50px">
		<!-- 编辑的隐藏域 -->
			<table>
				<tr><td><input id="recordId" name="recordId" type="hidden"></td></tr>
				 <tr>
        	    	<td>案件ID:</td><td> <input name="caseId" type="text" class="easyui-validatebox" required="true"/></td>
        	 	 </tr>
				 <tr>
        	    	<td>笔录单位ID:</td><td> <input name="deptId" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>询问人ID:</td><td> <input name="userId" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>询问时间:</td><td> <input name="xwsj" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>笔录人员ID:</td><td> <input name="blryid" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>笔录内容:</td><td> <input name="recordContent" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>笔录时间:</td><td> <input name="blsj" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>被询问人:</td><td> <input name="bxwr" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>被询问人身份证号:</td><td> <input name="bxwrsfz" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>是否为人大代表:</td><td> <input name="isrddb" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>居住地址:</td><td> <input name="bxwraddr" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
				 <tr>
        	    	<td>联系方式:</td><td> <input name="bxwrphone" type="text" class="easyui-validatebox" /></td>
        	 	 </tr>
			</table>
        </form>
    </div>
   <div id="dlg-buttons">
        <a href="javascript:void(0)" onclick="userSave()" class="easyui-linkbutton c6" iconCls="icon-ok"  style="width:90px">保存</a>
        <a href="javascript:void(0)" onclick="userCancle()" class="easyui-linkbutton" iconCls="icon-cancel"  style="width:90px">取消</a>
    </div>
</body>
</html>