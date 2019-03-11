<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">储物柜ID：</label>
                </td>
                <td>${entity.lockersId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">所属部门：</label>
                </td>
                <td>${entity.deptId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">仓库ID：</label>
                </td>
                <td>${entity.storeId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">类型：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.type==1}">
                            智能保管柜
                        </c:when>
                        <c:when test="${entity.type==2}">
                            普通保管柜
                        </c:when>
                        <c:when test="${entity.type==3}">
                            恒温保管柜
                        </c:when>
                        <c:when test="${entity.type==4}">
                            保险柜
                        </c:when>
                        <c:when test="${entity.type==5}">
                            货架
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">储物柜名称：</label>
                </td>
                <td>${entity.lockersName}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">门数：</label>
                </td>
                <td>${entity.lockerGate}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">请求地址：</label>
                </td>
                <td>${entity.postPath}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">host端口号：</label>
                </td>
                <td>${entity.host}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">保管员：</label>
                </td>
                <td><hs:user value="${entity.userId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">生成用户：</label>
                </td>
                <td><hs:user value="${entity.createUserId}"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">添加时间：</label>
                </td>
                <td><hs:datefmt value="${entity.createTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">修改时间：</label>
                </td>
                <td><hs:datefmt value="${entity.editTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">是否删除：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.isDelete==0}">
                            不删除
                        </c:when>
                        <c:when test="${entity.isDelete==1}">
                            删除
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">集成类型：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.integration==1}">
                            socket集成
                        </c:when>
                        <c:when test="${entity.integration==2}">
                            webservice集成
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close" data-target="menu01071004"
                    onclick="BJUI.navtab('refresh', 'menu01071004')">关闭
            </button>
        </li>

    </ul>
</div>