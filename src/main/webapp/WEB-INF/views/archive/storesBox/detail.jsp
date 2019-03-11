<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%@ page import="com.model.bean.ArchiveStoresBoxBean" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
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
                                    <input type="hidden" name="stuts" value="${empty archive.struts or archive.struts == '1' ? '2' : '1'}">

                                    <a type="button" class="btn-primary btn" data-toggle="dialog" href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_OPEN_BOX)%>?id=${achiveBox.id}&achiveId=${archive.id}&caseId=${obj.caseid}&logTime=${currentTime}&stuts=${empty archive.struts or archive.struts == '1' ? '2' : '1'}">
                                        <c:if test="${empty archive.struts or archive.struts eq '0'or archive.struts eq '3' or archive.struts eq '2'}">
                                            <hs:code value="1" field="ARCHIVE-STRUTS" />
                                        </c:if>
                                        <c:if test="${archive.struts eq '1'}">
                                            <hs:code value="2" field="ARCHIVE-STRUTS" />
                                        </c:if>
                                        </a> &nbsp;&nbsp;
                                </sys:permission>
                                <c:if test="${archive.struts eq '3'}">
                                    <a type="button" class="btn-default btn">已移交检察院</a>
                                </c:if>
                                <c:if test="${archive.struts eq '2'}">
                                    <a type="button" class="btn-default btn">已取出</a>
                                </c:if>
                                <c:if test="${archive.struts eq '1'}">
                                    <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_OPEN_BOX)%>">
                                        <a type="button" data-toggle="dialog" href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_OPEN_BOX)%>?id=${achiveBox.id}&achiveId=${archive.id}&caseId=${obj.caseid}&logTime=${currentTime}&stuts=3" class="btn-warning btn">移交检察院</a>
                                    </sys:permission>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter navbar-fixed-bottom">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close" data-target="menu01090101"
                    onclick="BJUI.navtab('refresh', 'menu01090101')">关闭
            </button>
        </li>
    </ul>
</div>
