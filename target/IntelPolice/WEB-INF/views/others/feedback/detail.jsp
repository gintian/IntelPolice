<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="100px">
                    <label class="control-label">留言ID：</label>
                </td>
                <td>${entity.id}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">留言标题：</label>
                </td>
                <td>${entity.title}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">操作人id：</label>
                </td>
                <td>${entity.createUserId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">操作人姓名：</label>
                </td>
                <td>${entity.createUserName}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">联系电话：</label>
                </td>
                <td>${entity.telephone}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">地址：</label>
                </td>
                <td>${entity.address}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">显示状态：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.status == 0}">
                            不显示
                        </c:when>
                        <c:when test="${entity.status == 1}">
                            显示
                        </c:when>
                        <c:when test="${entity.status == 2}">
                            置顶
                        </c:when>
                        <c:otherwise>
                            状态异常
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">浏览次数：</label>
                </td>
                <td>${entity.lookTimes}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">操作次数：</label>
                </td>
                <td>${entity.processTimes}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">操作时间：</label>
                </td>
                <td><hs:datefmt value="${entity.createTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">业务类型：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.businessType == 1}">
                            类型一
                        </c:when>
                        <c:when test="${entity.businessType == 2}">
                            类型二
                        </c:when>
                        <c:otherwise>
                            其他类型
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">留言内容：</label>
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