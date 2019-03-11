<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script type="text/javascript">
  $(document).ready(function(){
    var setting = {
      async: {
        enable: true,
        url: getUrl
      },
      view: {
        fontCss : {"font-size": "12px"},
        expandSpeed: ""
      },
      data:{
        key:{
          name: 'name'
        },
        simpleData : {
          enable : true,
          idKey : 'id',
          pIdKey : 'parentId',
          rootPId : ${currentUser.deptId}
        }
      },
      callback: {
        beforeExpand: beforeExpand,
        onAsyncSuccess: onAsyncSuccess,
        onAsyncError: onAsyncError,
        onClick: do_open_layout
      }
    };
    BJUI.ajax('doajax', {
      async:true,
      url: '${root}<%=Url.getUrl(Url.DEPT_SHOW_BY_ID)%>?deptId=${currentUser.deptId}',
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
  function getUrl(treeId, treeNode) {
    return "${root}<%=Url.getUrl(Url.DEPT_SHOW_BY_PARENTID)%>?parentId=" + treeNode.id;
  }
  function beforeExpand(treeId, treeNode) {
    if (!treeNode.isAjaxing) {
      startTime = new Date();
      treeNode.times = 1;
      ajaxGetNodes(treeNode, "refresh");
      return true;
    } else {
      alert("zTree 正在下载数据中，请稍后展开节点。。。");
      return false;
    }
  }
  function onAsyncSuccess(event, treeId, treeNode, msg) {
    if (!msg || msg.length == 0) {
      return;
    }
    var zTree = $.fn.zTree.getZTreeObj("layout-tree"),
            totalCount = treeNode.count;
    if (treeNode.children.length < totalCount) {
      setTimeout(function() {ajaxGetNodes(treeNode);}, perTime);
    } else {
      treeNode.icon = "";
      zTree.updateNode(treeNode);
      zTree.selectNode(treeNode.children[0]);
    }
  }
  function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
    var zTree = $.fn.zTree.getZTreeObj("layout-tree");
    alert("异步获取数据出现异常。");
    treeNode.icon = "";
    zTree.updateNode(treeNode);
  }
  function ajaxGetNodes(treeNode, reloadType) {
    var zTree = $.fn.zTree.getZTreeObj("layout-tree");
    if (reloadType == "refresh") {
      treeNode.icon = "${root}/B-JUI.1.31/B-JUI/plugins/ztree/img/loading.gif";
      zTree.updateNode(treeNode);
    }
    zTree.reAsyncChildNodes(treeNode, reloadType, true);
  }
  /*
    点击事件
   */
  function do_open_layout(event, treeId, treeNode) {
    //DEPT输入框赋值
    $.CurrentNavtab.find("#user_deptId").val(treeNode.id);
    $.CurrentNavtab.find("#user_deptName").val(treeNode.name);
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
