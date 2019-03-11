<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.page.PageBean" %>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页</span>
        <%--隐藏掉选项，固定20条 start --%>
        <span>&nbsp;${pageSize}&nbsp;</span>
        <div class="selectPagesize" style="display: none;">
            <select name="pageSize" data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="<%=PageBean.PAGESIZE%>"><%=PageBean.PAGESIZE%></option>
            </select>
        </div>
        <%--隐藏掉选项，固定20条 end --%>
        <%--LQZ 如果没有数据，显示0条--%>
        <span>条，共 <c:if test="${empty total}">0</c:if><c:if test="${not empty total}">${total}</c:if> 条</span>
    </div>
    <div data-toggle="pagination" data-total="${total}"
         data-page-size="${pageSize}" data-page-current="${pageCurrent}" data-options="{pageSize:${pageSize}, pageCurrent:${pageCurrent}, form:'#${searchFormId}'}">
    </div>
</div>

<script>
    /* zxc优化开始 */
    // 解决多个列表间的字段排序冲突问题
    $(".page.unitBox.fade.in > .bjui-pageHeader > #pagerForm > [name='orderField']").val("");
    $(".page.unitBox.fade.in > .bjui-pageHeader > #pagerForm > [name='orderDirection']").val("");

    // 解决多个列表间的分页大小冲突问题
    var selectedPagesize = $(".pages > .selectPagesize > select").val();
    $(".page.unitBox.fade.in > .bjui-pageHeader > #pagerForm > [name='pageSize']").val(selectedPagesize);
    $(".page.unitBox.fade.in > .bjui-pageFooter > .pagination-box").attr('data-page-size',selectedPagesize);
</script>