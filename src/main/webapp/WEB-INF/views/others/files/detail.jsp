<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="100px">
                    <label class="control-label">文件ID：</label>
                </td>
                <td>${entity.id}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">文件名：</label>
                </td>
                <td>${entity.name}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">文件路径(相对路径)：</label>
                </td>
                <td>${entity.path}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">文件描述：</label>
                </td>
                <td>${entity.description}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">文件大小：</label>
                </td>
                <td>${entity.sizes}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">上传时间：</label>
                </td>
                <td><hs:datefmt value="${entity.createTime}" type="dateTimeFormat"/></td>

            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">文件类型：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${entity.type == '01'}">
                            财物图片
                        </c:when>
                        <c:when test="${entity.type == '02'}">
                            财物扣押附件
                        </c:when>
                        <c:when test="${entity.type == '03'}">
                            涉案财物处理附件
                        </c:when>
                        <c:when test="${entity.type == '04'}">
                            出库图片
                        </c:when>
                        <c:when test="${entity.type == '05'}">
                            处理文书文件
                        </c:when>
                        <c:when test="${entity.type == '06'}">
                            入库附件
                        </c:when>
                        <c:when test="${entity.type == '10'}">
                            台账模板
                        </c:when>
                        <c:when test="${entity.type == '11'}">
                            扣押清单模板
                        </c:when>
                        <c:when test="${entity.type == '12'}">
                            入库清单模板
                        </c:when>
                        <c:when test="${entity.type == '13'}">
                            出库清单模板
                        </c:when>
                        <c:when test="${entity.type == '14'}">
                            移交附件
                        </c:when>
                        <c:when test="${entity.type == '15'}">
                            案件统计模板
                        </c:when>
                        <c:when test="${entity.type == '16'}">
                            省厅和地州级通报模板
                        </c:when>
                        <c:when test="${entity.type == '17'}">
                            区县级通报模板
                        </c:when>
                        <c:otherwise>
                            其他类型
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">排序号：</label>
                </td>
                <td>${entity.sortCode}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">状态：</label>
                </td>
                <td>
                <c:choose>
                    <c:when test="${entity.status == 1}">
                        正常查询
                    </c:when>
                    <c:when test="${entity.status == 2}">
                        仅作模板
                    </c:when>
                    <c:otherwise>
                        状态异常
                    </c:otherwise>
                </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">上传者：</label>
                </td>
                <td><hs:datefmt value="${entity.createTime}" type="dateTimeFormat"/></td>

            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">同步过来的财物ID：</label>
                </td>
                <td>${entity.objId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">涉案财物ID：</label>
                </td>
                <td>${entity.spoilsId}</td>
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