<%@page import="com.utils.ServiceUtils" %>
<%
    request.setAttribute("treeId", ServiceUtils.generatePrimaryKey());
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {
        var setting = {
            async: {
                enable: true,
                url: getUrl
            },
            view: {
                fontCss: {"font-size": "12px"},
                expandSpeed: ""
            },
            data: {
                key: {
                    name: 'name'
                },
                simpleData: {
                    enable: true,
                    idKey: 'id',
                    pIdKey: 'parentId',
                    rootPId: '0'
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
            async: true,
            url: '${root}<%=Url.getUrl(Url.DEPT_SHOW_BY_PARENTID)%>?parentId=520400000000',
            loadingmask: true,
            okCallback: function (json, options) {
                $.fn.zTree.init($("#${treeId}"), setting, json);
                //默认展开第一个节点
                var treeObj = $.fn.zTree.getZTreeObj("${treeId}");
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
        var zTree = $.fn.zTree.getZTreeObj("${treeId}"),
            totalCount = treeNode.count;
        if (treeNode.children.length < totalCount) {
            setTimeout(function () {
                ajaxGetNodes(treeNode);
            }, perTime);
        } else {
            treeNode.icon = "";
            zTree.updateNode(treeNode);
            zTree.selectNode(treeNode.children[0]);
        }
    }

    function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
        var zTree = $.fn.zTree.getZTreeObj("${treeId}");
        alert("异步获取数据出现异常。");
        treeNode.icon = "";
        zTree.updateNode(treeNode);
    }

    function ajaxGetNodes(treeNode, reloadType) {
        var zTree = $.fn.zTree.getZTreeObj("${treeId}");
        if (reloadType == "refresh") {
            treeNode.icon = "${root}/B-JUI.1.31/B-JUI/plugins/ztree/img/loading.gif";
            zTree.updateNode(treeNode);
        }
        zTree.reAsyncChildNodes(treeNode, reloadType, true);
    }

    function do_open_layout(event, treeId, treeNode) {
        //DEPT输入框赋值
        $("#parentId").val(treeNode.id);
        //添加刷新datatable
        $("#${searchFormId}").submit();
        if (treeNode.isParent) {
            var zTree = $.fn.zTree.getZTreeObj(treeId);

            zTree.expandNode(treeNode);
            return
        }
        $(event.target).bjuiajax('doLoad', {url: treeNode.url, target: treeNode.divid});

        event.preventDefault();

    }
</script>

<div style="float:left; width:220px;margin-right:4px;overflow: auto;">
    <fieldset style="height:100%;">
        <ul id="${treeId}" class="ztree" data-toggle="ztree" style="width: 200px;height: 500px">
        </ul>
    </fieldset>
</div>