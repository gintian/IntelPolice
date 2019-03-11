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
			$("#dataForm").form("clear");
			// 打开对话框
			$("#Datagrid").dialog("open");
		}
		//删除
		function Del() {
			//判断：是否选中，没有选：弹一个提示；选中：弹一个删除的确认框
			var rows = $("#Datagrid").datagrid('getSelections');//获取一行
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
											$("#Datagrid").datagrid('reload');
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
			$("#dataDialog").dialog('open').dialog('center').dialog('setTitle',
			'视频文件添加');
			//userForm:清空表单
			$("#dataForm").form('clear');
			//加载视频数据
			queryMedia();
			//打开dialog的时候：设置一个状态的默认值：defaultValue
			//$("#defaultValue").attr("checked",true);
			$("#defaultValue").prop("checked", true);
		}
		
		//修改
		function Edit() {
			//判断是否选中一条需要编辑的数据
			//选中再弹出
			var rows = $("#Datagrid").datagrid('getSelections');//获取一行
			if (rows.length<2&rows.length>0) {
				//弹出dialog
				$("#dataDialog").dialog('open').dialog('center').dialog('setTitle',
						'笔录编辑');
				//dataForm：load：回显
				$("#dataForm").form('load', rows[0]);
			} else {
				$.messager.alert('温馨提示', '请选择一行你要编辑的数据', "info")
			}
		}
		
		function queryMedia(){
			var url ='${root}<%=Url.getUrl(Url.MEDIA_LIST_DATA)%>';
			$.post(url,[],function(data){
				var sdata = $.parseJSON(data);

				$("#mediaId").empty();
		          	//循环遍历加载数据
				    $.each( sdata, function(index, content){ 

					    $("#mediaId").append("<option value='"+content.mediaId+"'>"+content.mediaName+"</option>");

					});
			});
		}
		
		//查询
		function doSearch(){
			$("#dataSearch").form('submit',{
				url : '${root}<%=Url.getUrl(Url.MEDIAFILES_QUERY_PAGE_SHOW)%>',
				success : function(data) {
					//json字符串转为对象
					var $data = $.parseJSON(data);
					$('#dataDialog').datagrid('loadData',$data);
				}
			})
		}
		//保存
		function Save() {
				var url;
	            if ($("#ID").val()){
	                url = '${root}<%=Url.getUrl(Url.MEDIAFILES_UPDATE_SUBMIT)%>'
	            }else {
	                url = '${root}<%=Url.getUrl(Url.MEDIAFILES_ADD_SUBMIT)%>'
	            }
	            $("#dataForm").form('submit', {
	                url : url,
					onSubmit: function(param){

						fromData = $('#dataForm').serializeJson();// 调用serializeJson方法获取表单内容,自定义方法

					},
	                success : function(data) {
						var $data = $.parseJSON(data);
						if ($data.success) {
							$.messager.alert('温馨提示', "操作成功", "info");
							$("#dataDialog").dialog('close');//关闭
							//刷新datagrid
							$("#Datagrid").datagrid('reload');
							 flushDataPage();
						} else {
							//失败
							$.messager.alert('温馨提示', $data.message, "error");
							$("#dataDialog").dialog('close');//关闭
						}
					}
				});
			}
		//取消
		function Cancle() {
			$("#dataDialog").dialog('close');//关闭
		}
</script>
<script type="text/javascript">
	$(function() {
		//刷新
		$("#refresh").click(function() {
			//reload
			$("#Datagrid").datagrid("reload");
		})
	})
	$(function() {
		$('#Datagrid').datagrid({
			title : "音视频文件",
			iconCls : 'icon-ok',
			width : 600,
			pageSize : 10,//默认选择的分页是每页5行数据  
			pageList : [ 10, 20, 30, 50 ],//可以选择的分页集合  
			nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
			striped : true,//设置为true将交替显示行背景。  
			collapsible : true,//显示可折叠按钮  
			toolbar : "#Tool",//在添加 增添、删除、修改操作的按钮要用到这个  
			url : '${root}<%=Url.getUrl(Url.MEDIAFILES_QUERY_PAGE_SHOW)%>',//url调用Action方法  
			loadMsg : '数据装载中......', 
			fitColumns : true,//允许表格自动缩放，以适应父容器  
			fit : "true",
			sortName : 'mediaFileId',//当数据表格初始化时以哪一列来排序
			remoteSort : false,
			pagination : true,//分页  
			rownumbers : true,
			singleSelect :true     //只能选择单行
		});
	});

</script>

	<table id="Datagrid" class="table table-hover easyui-datagrid"
		style="width: 100%; height: 100%;">
		<thead> 
			<tr>
				<th data-options="field:'mediaId',width:'100',title:'音视频记录Id',sortable:true"></th>
				<th data-options="field:'fileSize',width:'100',title:'文件大小',sortable:true"></th>
				<th data-options="field:'fileSype',width:'100',title:'文件类型',sortable:true"></th>
				<th data-options="field:'filePath',width:'100',title:'文件地址',sortable:true"></th>
			</tr>
		</thead>
	</table>
	<%@include file="/WEB-INF/views/common_page.jsp"%>
<!-- 表格工具栏开始 -->
<div id="Tool" style="padding: 5px; height: auto">
			<div style="margin-bottom: 5px">
				<a href="javascript:void(0)" onclick="Add()" class="easyui-linkbutton c1" iconCls="icon-add" plain="true" style="width: 100px">新增</a> 
				<a href="javascript:void(0)" onclick="Edit()" class="easyui-linkbutton c3" iconCls="icon-edit" plain="true" style="width: 100px">修改</a> 
				<a href="javascript:void(0)" onclick="Del()" class="easyui-linkbutton c7" iconCls="icon-remove" plain="true" style="width: 100px">删除</a>
			</div>
			<form id="dataSearch">
				<span>音视频记录Id:</span>
					 <input id="recordId" name="mediaId" class="easyui-text" style="width:80px">
				<span>文件类型:</span>
					 <input id="caseId" name="fileSype" class="easyui-text" style="width:80px">
					<a href="#" class="easyui-linkbutton c4" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>
			</form>
</div>
<!-- 表格工具栏结束 -->
<!-- 	添加或者修改的dialog：模态窗口 -->
    <div id="dataDialog" class="easyui-dialog" style="width:600px"
            closed="true" buttons="#dlg-buttons" data-options=" modal:true,
                draggable:false, resizable:false">
        <form id="dataForm" method="post" novalidate style="margin:0;padding:20px 50px">
		<!-- 编辑的隐藏域 -->
			<table>
				<tr><td><input id="ID" name="mediaFileId" type="hidden"></td></tr>
				 <tr>
        	    	<td>音视频记录ID:</td>
        	    	<td>
        	    	    <select id="mediaId" name="mediaId" style="width:300px;">

        	    	    </select> 
        	       	</td>
        	 	 </tr>
				 <tr>
        	    	<td>文件大小:</td><td> <input name="fileSize" type="number" required="true" min="0"  style="width:300px"/></td>
        	 	 </tr>
				 <tr>
        	    	<td>文件格式:</td><td> <input name="fileSype" type="text" class="easyui-validatebox" maxlength="25"  style="width:300px"/></td>
        	 	 </tr>
				 <tr>
        	    	<td>文件地址:</td><td> <input name="filePath" type="text" class="easyui-validatebox" maxlength="25"  style="width:300px"/></td>
        	 	 </tr>
			</table>
        </form>
    </div>
   <div id="dlg-buttons">
        <a href="javascript:void(0)" onclick="Save()" class="easyui-linkbutton c6" iconCls="icon-ok"  style="width:90px">保存</a>
        <a href="javascript:void(0)" onclick="Cancle()" class="easyui-linkbutton" iconCls="icon-cancel"  style="width:90px">取消</a>
    </div>
</body>
</html>