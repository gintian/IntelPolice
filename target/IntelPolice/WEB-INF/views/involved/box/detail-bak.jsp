<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="100px">
                    <label class="control-label">箱子ID：</label>
                </td>
                <td>${entity.id}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">箱号：</label>
                </td>
                <td>${entity.boxNo}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">箱子编码：</label>
                </td>
                <td>${entity.boxCode}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">所属仓库：</label>
                </td>
                <td><hs:involvedStores value="${entity.storeId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">所属柜子：</label>
                </td>
                <td><hs:involvedStoresLockers value="${entity.lockerId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">保管员：</label>
                </td>
                <td><hs:user value="${entity.userId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">长：</label>
                </td>
                <td>${entity.length}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">宽：</label>
                </td>
                <td>${entity.width}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">高：</label>
                </td>
                <td>${entity.height}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">开关状态：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.state==0}">
                            关闭
                        </c:when>
                        <c:when test="${entity.state==1}">
                            打开
                        </c:when>
                        <c:otherwise>
                            异常
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">生成用户：</label>
                </td>
                <td><hs:user value="${entity.createUserId}"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">创建时间：</label>
                </td>
                <td><hs:datefmt value="${entity.createTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">修改时间：</label>
                </td>
                <td><hs:datefmt value="${entity.editTime}" type="dateTimeFormat"/></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close">关闭</button>
        </li>

    </ul>
</div>