<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="150px">
                    <label class="control-label">类别名称：</label>
                </td>
                <td>
                    ${entity.name}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">编码：</label>
                </td>
                <td>
                    ${entity.code}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">排序号：</label>
                </td>
                <td>
                    ${entity.sortcode}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">类别父类：</label>
                </td>
                <td>
                    ${entity.parentid}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">备注：</label>
                </td>
                <td>
                    ${entity.remark}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">创建人：</label>
                </td>
                <td>
                    ${entity.userid}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">创建时间：</label>
                </td>
                <td>
                    <hs:datefmt value="${entity.createtime}" type="dateTimeFormat"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">是否涉案：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="isinvolved=0">
                            否
                        </c:when>
                        <c:when test="isinvolved=1">
                            是
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">类别状态：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="state=01">
                            正常使用
                        </c:when>
                        <c:when test="state=02">
                            弃用
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">本单位自行处理的最大限额：</label>
                </td>
                <td>
                    ${entity.maxmoney}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">是否必须有上级审批：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="issuperexamine=0">
                            否
                        </c:when>
                        <c:when test="issuperexamine=1">
                            是
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">特殊物品本单位是否可以直接处理：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="isprocessdirect=0">
                            否
                        </c:when>
                        <c:when test="isprocessdirect=1">
                            是
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">必须交保管的单位：</label>
                </td>
                <td>
                    ${entity.keepunit}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">是否可由保管单位自行处理：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="isprocessbykeepunit=0">
                            否
                        </c:when>
                        <c:when test="isprocessbykeepunit=1">
                            是
                        </c:when>
                        <c:otherwise>
                            未知
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">是否指定专门单位保管：</label>
                </td>
                <td>
                    <c:choose>
                        <c:when test="isappointkeepunit=0">
                            否
                        </c:when>
                        <c:when test="isappointkeepunit=1">
                            是
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
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>

    </ul>
</div>