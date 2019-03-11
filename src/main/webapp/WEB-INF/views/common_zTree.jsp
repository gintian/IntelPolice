<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

//jsp调用ztree模态框的按钮
<!-- <button type="button" class="btn-green" data-icon="search"  data-toggle="dialog"  -->
<%-- data-options="{id:'deptTree', url:'${pageContext.request.contextPath }/resources/html/deptTree.html', title:'部门树', width:400, height:300, mask:true}" ></button> --%>
//多选
/* var setting = {
		check: {
			enable: true,
			chkStyle: "checkbox"//如果要单选框更改checkbox为radio
		}
	}; */
</script>
<script language="JavaScript">
	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	var setting = {};
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var zNodes = [
	    {id:"001",name:"总部门",children:[
	   		{id:"00101",name:"一级部门1",children:[
	    		{id:"0010101",name:"二级部门1",children:[
				    {id:"001010101",name:"三级部门1"},
				    {id:"001010102",name:"三级部门2"},
				    {id:"001010103",name:"三级部门3"}
				]},
			    {id:"0010102",name:"二级部门2"},
			    {id:"0010103",name:"二级部门3"}
			]},
		    {id:"00102",name:"一级部门2",children:[
			    {id:"0010201",name:"二级部门4"},
			    {id:"0010202",name:"二级部门5"},
			    {id:"0010203",name:"二级部门6"}
			]},
		    {id:"00103",name:"一级部门3"},
		    {id:"00104",name:"一级部门4"},
		    {id:"00105",name:"一级部门5"}
		    ]}
	];
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
</script>
</head>
<body>
	<div>
	 <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>