<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input table-bordered" width="100%">
            <tbody class="boxTbody">
                <c:forEach  items="${list}" var="obj">
                    <tr style="background-color: #D9E7F2;">
                        <th><strong>案件名称</strong></th>
                        <th><strong>${obj.casename}</strong></th>
                    </tr>
                    <tr>
                        <td>卷宗名称</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${obj.archiveBeanList}" var="archive">
                        <tr>
                            <td>${archive.name}</td>
                            <td>
                                <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_OPEN_BOX)%>">
                                    <a type="button" href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_OPEN_BOX)%>">取出/存入</a> &nbsp;&nbsp;
                                </sys:permission>
                                <a type="button" class="btn-default btn">移交检察院</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:forEach>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close" data-target="menu01090101"
                    onclick="BJUI.navtab('refresh', 'menu01090101')">关闭
            </button>
        </li>
    </ul>
</div>
