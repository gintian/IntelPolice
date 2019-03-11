<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_TASK_START)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-hover hw-table-long-input" width="100%">
                <tbody>
                <input id="id" name="id" type="hidden" value="${entity.id}"/>
                <%--<tr>--%>
                    <%--<td align="right">--%>
                        <%--<label class="control-label" for="remark">备注：</label>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<input type="text" id="remark" name="remark" maxlength="3000" value="${entity.remark}"--%>
                               <%--placeholder="请输入备注信息">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <tr>
                    <td align="right">
                        <label class="control-label" for="outcome">操作：</label>
                    </td>
                    <td>
                        <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                               value="提交" checked="checked"
                               data-label="申请处置">
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>
        <li>
            <button type="submit" class="btn-green" data-icon="save">保存</button>
        </li>
    </ul>
</div>