<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">财物编码：</label>
                </td>
                <td>
                    ${involved.cwbm}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">财物名称：</label>
                </td>
                <td>
                    ${involved.cwmc}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">案事件ID：</label>
                </td>
                <td>
                    ${entity.caseId}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">存放仓库：</label>
                </td>
                <td>
                    <hs:involvedStores value="${entity.storeId}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">存放柜子：</label>
                </td>
                <td>
                    <hs:involvedStoresLockers value="${entity.lockersId}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">存放箱子：</label>
                </td>
                <td>
                    ${entity.boxNo}
                </td>
            </tr>
            <tr>
                <td align="right" width="150px">
                    <label class="control-label">保管到期时间：</label>
                </td>
                <td>
                    <hs:datefmt value="${involved.bgdqsj}" type="dayFormat"/>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close" data-icon="close">取消</button>
        </li>

    </ul>
</div>