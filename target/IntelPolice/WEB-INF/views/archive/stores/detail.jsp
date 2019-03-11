<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="100px">
                    <label class="control-label">卷宗柜ID：</label>
                </td>
                <td>${entity.id}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">卷宗柜名称：</label>
                </td>
                <td>${entity.name}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">卷宗柜地址：</label>
                </td>
                <td>${entity.address}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">所属部门：</label>
                </td>
                <td>${entity.deptId}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">保管员：</label>
                </td>
                <td>${entity.userId}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">添加时间：</label>
                </td>
                <td><hs:datefmt value="${entity.addTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">修改时间：</label>
                </td>
                <td><hs:datefmt value="${entity.editTime}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">备注：</label>
                </td>
                <td>${entity.remark}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close" data-target="menu01090201"
                    onclick="BJUI.navtab('refresh', 'menu01090201')">关闭
            </button>
        </li>

    </ul>
</div>