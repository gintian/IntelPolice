
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>

    <table id="j_datagrid_tree" data-toggle="datagrid" data-options="{
    width: '100%',
    height: '100%',
    <%--gridTitle: '树状datagrid 示例 ',--%>
    showToolbar: true,
    toolbarItem:'add, cancel, del, save',
    local: 'local',
    dataUrl: '${root}<%=Url.getUrl(Url.RECORD_QUESTION_TYPE_PAGE_SHOWLIST)%>',
    inlineEditMult: false,
    updateRowUrl:'${root}<%=Url.getUrl(Url.RECORD_QUESTION_TYPE_UPDATE_SUBMIT)%>',
    editUrl: '${root}<%=Url.getUrl(Url.RECORD_QUESTION_TYPE_ADD_SUBMIT)%>',
    delUrl:'${root}<%=Url.getUrl(Url.RECORD_QUESTION_TYPE_DELETE_SUBMIT)%>',
    delConfirm:'是否删除',
    isTree: 'name',
    addLocation: 'last',
    fieldSortable: false,
    columnMenu: false,
    paging: false,
    treeOptions: {
        expandAll: false,
        add: true,
        simpleData: true,
        keys: {
            parentKey: 'parentid'
        }
    },
    dropOptions: {
        drop: true,
        position: 'before',
        dropUrl: '${root}<%=Url.getUrl(Url.RECORD_QUESTION_TYPE_ADD_SUBMIT)%>',
        beforeDrag: datagrid_tree_beforeDrag,
        beforeDrop: datagrid_tree_beforeDrop,
        afterDrop: 'array'
    }
}">
        <thead>
        <tr>
            <th data-options="{name:'name', align:'center', width:300, rule:'required'}">类型</th>
            <th data-options="{name:'model', align:'center',width:100, type:'select', items:model}">模板</th>
            <th data-options="{render:datagrid_tree_operation}">操作列</th>
        </tr>
        </thead>
    </table>

<script type="text/javascript">
    // department
    function model() {
        return [{'000':''},{'001':'笔录'},{'002':'辨认'}]
    }
    // 操作列
    function datagrid_tree_operation() {
        if($(".datagrid-tree-td").data("title") == "类型"){
            $(".datagrid-tree-level-0").removeClass("btn-green ,btn-red");
        }
        var html =
            '<button type="button" class="btn-green" data-toggle="edit.datagrid.tr">编辑</button>'
            + '<button type="button" class="btn-red" data-toggle="del.datagrid.tr"  >删除</button>'
        return html
    }
    //不能拖动一级父节点
    function datagrid_tree_beforeDrag(tr, data) {
        if (data && data.level == 0) {
            return false
        }

        return true
    }
    // 不能将子节点拖为一级父节点
    function datagrid_tree_beforeDrop(data, targetData, position) {
        if (targetData && targetData.level == 0 && position !== 'append') {
            return false
        }
        return true
    }
    $(function(){
        $(".datagrid-tree-level-0").removeClass("btn-green ,btn-red");
    })
</script>