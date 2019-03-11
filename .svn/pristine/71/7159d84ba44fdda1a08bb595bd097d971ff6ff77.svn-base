<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="100px">
                    <label class="control-label">消息ID：</label>
                </td>
                <td>${entity.id}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">消息标题：</label>
                </td>
                <td>${entity.title}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">删除状态：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.status == 0}">
                            已回收
                        </c:when>
                        <c:when test="${entity.status == 1}">
                            正常
                        </c:when>
                        <%-- <c:when test="${entity.status == 2}">
                             置顶
                         </c:when>--%>
                        <c:otherwise>
                            状态异常
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">接收人员id：</label>
                </td>
                <td>${entity.receiveUserId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">接收人姓名：</label>
                </td>
                <td>${entity.receiveUserName}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">创建时间：</label>
                </td>
                <td><hs:datefmt value="${entity.createTime}" type="dateTimeFormat"/></td>

            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">创建人员id：</label>
                </td>
                <td>${entity.createUserId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">创建人员姓名：</label>
                </td>
                <td>${entity.createUserName}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">是否查看：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.isVisit == 0}">
                            未查看
                        </c:when>
                        <c:otherwise>
                            查看
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">查看时间：</label>
                </td>
                <td><hs:datefmt value="${entity.visitTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">消息内容：</label>
                </td>
                <td>${entity.content}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close" data-target="menu01060201"
                    onclick="BJUI.navtab('refresh', 'menu01060201')">关闭
            </button>
        </li>

    </ul>
</div>