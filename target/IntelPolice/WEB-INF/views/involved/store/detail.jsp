<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="100px">
                    <label class="control-label">仓库ID：</label>
                </td>
                <td>${entity.id}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">仓库名称：</label>
                </td>
                <td>${entity.name}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">仓库地址：</label>
                </td>
                <td>${entity.location}</td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">所属部门：</label>
                </td>
                <td><hs:dept value="${entity.deptId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">保管员：</label>
                </td>
                <td><hs:user value="${entity.userId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">创建人员：</label>
                </td>
                <td><hs:user value="${entity.createUserId}"/></td>
            </tr>
            <tr>
                <td align="right" width="100px">
                    <label class="control-label">备注：</label>
                </td>
                <td>${entity.remark}</td>
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
                    <label class="control-label">排序号：</label>
                </td>
                <td>${entity.sortCode}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn-close btn" data-icon="close" data-target="menu01071003"
                    onclick="BJUI.navtab('refresh', 'menu01071003')">关闭
            </button>
        </li>

    </ul>
</div>