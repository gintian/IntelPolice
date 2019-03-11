<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent tableContent">
    <div style="overflow:hidden;">
        <div style="overflow:hidden;">
            <fieldset style="height:100%;">
                <div id="layout-01" style="height:94%; overflow:hidden;">
                    <div class="bjui-pageHeader">
                        <form id="${searchFormId}" data-toggle="ajaxsearch"
                              action="${root}<%=Url.getUrl(Url.INVOLVED_TEMP_CASE_PAGE_SHOW)%>" method="post">
                            <input type="hidden" value="${caseid}" name="caseid">
                            <div class="bjui-searchBar">
                                <input name="parentId" id="parentId" type="hidden">
                                <label for="objectname" class="control-label">名称：</label>
                                <input name="objectname" id="objectname" placeholder="请输入名称" style="width: 200px;"
                                       value="${searchObj.objectname}">
                                <button type="button" class="showMoreSearch" data-toggle="moresearch"
                                        data-name="custom">
                                    <i class="fa fa-angle-double-down"></i>
                                </button>
                                <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询
                                </button>
                                <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                                   data-clear-query="true" data-icon="undo">清空查询</a>
                            </div>
                        </form>
                    </div>
                    <form action="${root}<%=Url.getUrl(Url.INVOLVED_TEMP_CASE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
                        <input type="hidden" value="${caseid}" name="caseid">
                        <div class="panel panel-default">
                            <!-- Default panel contents -->
                            <div class="panel-heading">
                                <button type="submit"  class="btn btn-blue">同步</button>
                            </div>
                            <table class="table table-bordered table-hover">
                                <thead class="tempThead">
                                <tr class="success">
                                    <th>名称</th>
                                    <th>数量</th>
                                    <th>数量单位</th>
                                    <th>规格</th>
                                    <th>特征</th>
                                    <th>描述</th>
                                    <th>持有人</th>
                                    <th>持有人信息</th>
                                    <th>备注</th>
                                </tr>
                                </thead>
                                <tbody class="tempTbody">
                                <c:forEach items="${list}" var="temp" >
                                    <tr>
                                        <td title="${temp.objectname}">
                                            <input name="ids" value="${temp.id}">
                                            <hs:out value="${temp.objectname}" length="5" />
                                        </td>
                                        <td title="${temp.amounts}"><hs:out value="${temp.amounts}" length="5" /></td>
                                        <td title="${temp.amountunit}"><hs:out value="${temp.amountunit}" length="5" /></td>
                                        <td title="${temp.spec}"><hs:out value="${temp.spec}" length="5" /></td>
                                        <td title="${temp.characteristic}"><hs:out value="${temp.characteristic}" length="5" /></td>
                                        <td title="${temp.description}"><hs:out value="${temp.description}" length="5" /></td>
                                        <td title="${temp.personname}"><hs:out value="${temp.personname}" length="5" /></td>
                                        <td title="${temp.personinfo}"><hs:out value="${temp.personinfo}" length="5" /></td>
                                        <td title="${temp.annex}"><hs:out value="${temp.annex}" length="10" /> </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>


                    <%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script>
    $(function(){
        function initTableCheckbox() {
            var $thr = $('.tempThead tr');
            var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');
            /*将全选/反选复选框添加到表头最前，即增加一列*/
            $thr.prepend($checkAllTh);
            /*“全选/反选”复选框*/
            var $checkAll = $thr.find('input');
            $checkAll.click(function(event){
                /*将所有行的选中状态设成全选框的选中状态*/
                $tbr.find('input').prop('checked',$(this).prop('checked'));
                /*并调整所有选中行的CSS样式*/
                if ($(this).prop('checked')) {
                    $tbr.find('input').parent().parent().addClass('warning');
                } else{
                    $tbr.find('input').parent().parent().removeClass('warning');
                }
                /*阻止向上冒泡，以防再次触发点击操作*/
                event.stopPropagation();
            });
            /*点击全选框所在单元格时也触发全选框的点击操作*/
            $checkAllTh.click(function(){
                $(this).find('input').click();
            });
            var $tbr = $('.tempTbody tr');
            var $checkItemTd = $('<td><input type="checkbox" name="checkItem" /></td>');
            /*每一行都在最前面插入一个选中复选框的单元格*/
            $tbr.prepend($checkItemTd);
            /*点击每一行的选中复选框时*/
            $tbr.find('input').click(function(event){
                /*调整选中行的CSS样式*/
                $(this).parent().parent().toggleClass('warning');
                /*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
                $checkAll.prop('checked',$tbr.find('input:checked').length == $tbr.length ? true : false);
                /*阻止向上冒泡，以防再次触发点击操作*/
                event.stopPropagation();
            });
            /*点击每一行时也触发该行的选中操作*/
            $tbr.click(function(){
                $(this).find('input').click();
            });
        }
        initTableCheckbox();
    });
</script>