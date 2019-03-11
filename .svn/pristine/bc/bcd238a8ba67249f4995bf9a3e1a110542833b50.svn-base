<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input table-bordered" width="100%">
            <tbody class="boxTbody">
            <c:forEach items="${list}" var="obj">
            <tr style="background-color: #D9E7F2;">
                <th><strong>案件名称</strong></th>
                <th><strong>${obj.casename}</strong></th>
            </tr>
            <tr>
                <td>财物名称</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${obj.involvedBeanList}" var="involved">
            <tr>
                <td>${involved.cwmc}</td>
                <td>
                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_STORES_BOX_OPEN_BOX)%>">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_OPEN_BOX)%>?id=${involved.id}"
                           class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要开箱吗？">取出/存入</a>
                    </sys:permission>
                    <a type="button" class="btn-default btn" onclick="alert('待开发')">移交检察院</a>
                </td>
            </tr>
            </c:forEach>
            </c:forEach>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close">关闭</button>
        </li>

    </ul>
</div>