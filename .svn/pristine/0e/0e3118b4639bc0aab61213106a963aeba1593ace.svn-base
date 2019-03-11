/**
 * Created by admin on 2017/3/14.
 */
function onClick(e, treeId, treeNode) {
    if (treeNode.isParent) //如果不是叶子结点，结束
        return;
    var oneParent ="";
    var twoParent ="";
    var oneParentId ="";
    var twoParentId ="";
    if(treeNode.getParentNode() != null){
        if(treeNode.getParentNode().name != null){
            oneParent = treeNode.getParentNode().name + "-";
            oneParentId =treeNode.getParentNode().id + "-";
        }
        if(treeNode.getParentNode().getParentNode() != null){
            if(treeNode.getParentNode().getParentNode().name != null){
                twoParent = treeNode.getParentNode().getParentNode().name + "-";
                twoParentId = treeNode  .getParentNode().getParentNode().id + "-";
            }
        }
    }
    var addHref =twoParent + oneParent +   treeNode.name;
    var updateHref = twoParentId + oneParentId + treeNode.id;
    console.log(oneParent + twoParent +  treeNode.name);
    $("#showDeletebutonn1").html(addHref);
    $("#showDeletebutonn").html(updateHref);
    $("#showoperation").css("display", "block");
    //console.log(treeNode.id);//获取当前结点上的相关属性数据，执行相关逻辑

};
var SysPermissionAllot = function() {
    //操作节点
    var funIds = "#funIds";
    var sys_permission_ztree = "sys_permission_ztree";

    /**
     * 选择或者取消
     * @param event
     * @param treeId
     * @param treeNode
     */

    var handleMenuCheck = function(event, treeId, treeNode) {
        var treeObj = $.fn.zTree.getZTreeObj(treeId);
        var nodes = treeObj.getCheckedNodes(true);
        var val = "";
        for(var i=0; i<nodes.length; i++){
            var id = nodes[i].id;
            var length = String(id).length;
            val += id + ",";
        }

        if (nodes[nodes.length -1]) {
            var oneParent ="";
            var twoParent ="";
            var oneParentId ="";
            var twoParentId ="";
            if(nodes[nodes.length - 1].getParentNode() != null){
                if(nodes[nodes.length - 1].getParentNode().name != null){
                    oneParent = nodes[nodes.length - 1].getParentNode().name + "-";
                    oneParentId =nodes[nodes.length - 1].getParentNode().id + "-";
                }
                if(nodes[nodes.length - 1].getParentNode().getParentNode() != null){
                    if(nodes[nodes.length - 1].getParentNode().getParentNode().name != null){
                        twoParent = nodes[nodes.length - 1].getParentNode().getParentNode().name + "-";
                        twoParentId = nodes[nodes.length - 1].getParentNode().getParentNode().id + "-";
                    }
                }
            }
            console.log(oneParent + twoParent +  nodes[nodes.length - 1].name);
            var updateHref = "<a href='"+$("#menuurlUpdate").val() + "?id=" + nodes[nodes.length - 1].id+"&date="+new Date()+"' class='btn btn-blue' data-toggle='dialog' data-mask='true'data-width='800' data-height='600'>编辑</a>"
            var addHref = "<a href='"+$("#menuurlAdd").val() + "?parentId=" + nodes[nodes.length - 1].id+"&date="+new Date()+"' class='btn btn-blue' data-toggle='dialog' data-mask='true'data-width='800' data-height='600'>新增</a>";
            //addHref = oneParent + twoParent +  nodes[nodes.length - 1].name;
            var deletHref = "<a href='"+ $("#menuurlDelete").val() + "?id=" + nodes[nodes.length - 1].id+"&date="+new Date()+"' class='btn btn-blue' data-toggle='doajax' data-confirm-msg='确定要删除吗？'>删除</a>";
            $("#showAddbutonn").html(addHref);
            $("#showUpdatebutonn").html(updateHref);
            $("#showDeletebutonn").html(deletHref);
            //显示按钮
            $("#showoperation").css("display", "block");
        }else {
            $("#showoperation").css("display", "none");
        }
    }

    /**
     * 迭代选择
     * @param treeObj
     * @param node
     */
    var handleChecked = function(treeObj, node){
        node.checked = true;
        treeObj.updateNode(node);
        var parent = node.getParentNode();
        if (!CommonUtilValidate.isEmpty(parent)) {
            handleChecked(treeObj, parent);
        }
    }


    return {
        init: function() {
            var interval =  setInterval(function(){
                var treeObj = $.fn.zTree.getZTreeObj(sys_permission_ztree);
                if (!CommonUtilValidate.isEmpty(treeObj)) {
                    var nodes = treeObj.getCheckedNodes(true);
                    for(var i=0; i<nodes.length; i++){
                        handleChecked(treeObj, nodes[i]);
                    }
                    clearInterval(interval);
                }
            }, 100);
        },
        handleMenuCheck : function(event, treeId, treeNode) {
            handleMenuCheck(event, treeId, treeNode);
        }
    };

}();

$(function(){
    SysPermissionAllot.init();
})