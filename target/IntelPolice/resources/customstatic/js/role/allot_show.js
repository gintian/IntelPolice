/**
 * Created by admin on 2017/3/14.
 */

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
        console.log(nodes[nodes.length -1].id);
        $.CurrentNavtab.find("#user_deptId").val(nodes[nodes.length -1].id);
        $.CurrentNavtab.find("#user_deptName").val(nodes[nodes.length -1].name);
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