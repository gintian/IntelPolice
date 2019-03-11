
var role_show = function () {
    var zTree;
    var setting = {
        view: {
            dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
            showLine: false,//是否显示节点之间的连线
            showIcon:false,//是否显示图标
            fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
            selectedMulti: false //设置是否允许同时选中多个节点
        },
        check:{
            chkboxType: { "Y": "ps", "N": "ps" },
            //chkboxType: { "Y": "", "N": "" },
            chkStyle: "radio",//复选框类型
            radioType: "all",
            /*chkStyle: "checkbox",//复选框类型
             enable: true //每个节点上是否显示 CheckBox */
        },
        data: {
            simpleData: {//简单数据模式
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                zTree = $.fn.zTree.getZTreeObj("role_tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);//如果是父节点，则展开该节点
                }else{
                    zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
                }
            },
            onCheck: S_NodeCheck,
            //onClick: S_NodeClick
        }


    };
    var S_NodeCheck = function () {
        debugger;
        var zTree = $.fn.zTree.getZTreeObj(treeId),
            nodes = zTree.getCheckedNodes(true)
        var ids = '', names = ''

        for (var i = 0; i < nodes.length; i++) {
            ids   += ','+ nodes[i].id
            names += ','+ nodes[i].name
        }
        if (ids.length > 0) {
            ids = ids.substr(1), names = names.substr(1)
        }

        var $from = $('#'+ treeId).data('fromObj')

        if ($from && $from.length) $from.val(ids)
        //if ($from && $from.length) $from.val(name)
    }
    //动态加载树形结构数据
    var onLoadZTree = function (){
        console.log("加载角色");
        var treeNodes;
        BJUI.ajax('doajax', {
            url:$('#roleUrl').val(),
            data:{"deptId":'001001'},
            okCallback: function(json, options) {
                console.log('返回内容：\n'+  JSON.stringify(json.list));
                //请求成功后处理函数
                treeNodes = json.list;//把后台封装好的简单Json格式赋给treeNodes
                var t = $("#role_tree");
                console.log(t);
                t = $.fn.zTree.init(t, setting, treeNodes);
            }
        })

    }

    return{
        loadZTree:function () {
            onLoadZTree();
        }
    }
}();
