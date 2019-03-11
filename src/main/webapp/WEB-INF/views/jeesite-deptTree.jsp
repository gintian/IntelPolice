<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	$("#officeButton,#officeName").click(function(){
		if ($("#officeButton").hasClass("disabled")){
			return true;
		}
		var options = {
			type: 2,
			maxmin: true,
			shadeClose: true,
			title: '选择部门',
			area: ['300px', '400px'],
			content: '/js/tags/treeselect',
			contentFormData: {
				url: $('#officeDiv').attr('data-url'),
				checkbox: 'false',
				expandLevel: '-1',
				selectCodes: $("#officeCode").val()
			},
			success: function(layero, index){
				if ($(js.layer.window).width() < 300
					|| $(js.layer.window).height() < 400){
					js.layer.full(index);
				}
			},
			btn: ['<i class="fa fa-check"></i> 确定'],
			btn1: function(index, layero){
				var win = js.layer.iframeWindow(index);
				win.$('#keyword').val('').change(); 			
				var codes = [], names = [], nodes;
				if ("false" == "true"){
					nodes = win.tree.getCheckedNodes(true);
				}else{
					nodes = win.tree.getSelectedNodes();
				}
				for(var i=0; i<nodes.length; i++) {
					if (nodes[i].level == 0 && nodes[i].isParent){
						js.showMessage("不能选择根节点（"+nodes[i].name+"）请重新选择。");
						return false;
					}
					var code = nodes[i].value || nodes[i].id, name = nodes[i].name;
					codes.push(code.replace(/^u_/g,''));
					names.push(name.replace(/\([0-9]*\)/g,''));
					break;
				}
				if(typeof treeselectCheck == 'function'){
					if (!treeselectCheck('office', nodes)){
						return false;
					}
				}
				$("#officeCode").val(codes.join(',')).change();
				$("#officeName").val(names.join(',')).change();
				try { $('#officeCode,#officeName').valid(); }catch(e){}
				if(typeof treeselectCallback == 'function'){
					treeselectCallback('office', 'ok', index, layero, nodes);
				}
			}
		};
		options.btn.push('<i class="fa fa-eraser"></i> 清除');
		options['btn'+options.btn.length] = function(index, layero){
			$("#officeCode").val('').change();
			$("#officeName").val('').change();
			if(typeof treeselectCallback == 'function'){
				treeselectCallback('office', 'clear', index, layero);
			}
		};
		options.btn.push('<i class="fa fa-close"></i> 关闭');
		options['btn'+options.btn.length] = function(index, layero){
			if(typeof treeselectCallback == 'function'){
				treeselectCallback('office', 'cancel', index, layero);
			}
		};
		js.layer.open(options);
	});
	</script>
</body>
</html>