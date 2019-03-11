<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script type="text/javascript">
  $(document).ready(function(){
    var setting = {
      view: {
        fontCss : {"font-size": "12px"}
      },
      data:{
        key:{
          name: 'name'
        },
        simpleData : {
          enable : true,
          idKey : 'id',
          pIdKey : 'parentId',
          rootPId : '001001'
        }
      },
      callback: {
        onClick: do_open_layout
      }
    };
    BJUI.ajax('doajax', {
      async:true,
      url: '${root}<%=Url.getUrl(Url.DEPT_ALL)%>',
      loadingmask: true,
      okCallback: function(json, options) {
        $.fn.zTree.init($("#layout-tree"), setting, json);
        //默认展开第一个节点
        var treeObj = $.fn.zTree.getZTreeObj("layout-tree");
        var sNodes = treeObj.getNodes();
        if (sNodes.length > 0) {
          treeObj.expandNode(sNodes[0], true);
        }
      }
    });

  });

  function do_open_layout(event, treeId, treeNode) {
    //DEPT输入框赋值
    $.CurrentNavtab.find("#user_deptId").val(treeNode.id);
    $.CurrentNavtab.find("#user_deptName").val(treeNode.name);
      $.CurrentNavtab.find
  }
</script>
<div class="bjui-pageContent">
  <ul id="layout-tree" class="ztree" data-toggle="ztree">
  </ul>
</div>

<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn btn-close" data-icon="save">保存</button></li>
  </ul>
</div>

<script>
  var deptId = $.CurrentNavtab.find("#user_deptId").val();
  var roleUrl = $("#roleUrl").val();
  //根据部门查询角色
  function query_menuByDeptId() {
    BJUI.ajax('doajax', {
      url:roleUrl,
      data:{"deptId":deptId},
      okCallback: function(json, options) {
        appendSelect(json);
      }
    })
  }
  var appendSelect = function (json) {
    $.CurrentNavtab.find("#select_RoleId").html("");
    $.each(json.list, function (n, role) {
      var select = "";
      if (role.id ==  deptId){
        select = "selected";
      }
      var html = "<option value='"+role.id+"'"+select+">"+role.name+"</option>"
      $.CurrentNavtab.find("#select_RoleId").append(html);
    });
  }
</script>
