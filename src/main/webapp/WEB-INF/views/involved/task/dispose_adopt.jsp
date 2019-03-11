<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <c:choose>
        <c:when test="${iden=='法制'}">
        <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_TASK_FZ_ADOPT)%>" data-toggle="validate"
              data-reload-navtab="true" method="post">
        </c:when>
        <c:when test="${iden=='领导'}">
            <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_TASK_LD_ADOPT)%>" data-toggle="validate"
                  data-reload-navtab="true" method="post">
        </c:when>
    </c:choose>
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-hover hw-table-long-input" width="100%">
                <tbody>
                <input id="taskId" name="taskId" type="hidden" value="${entity.taskId}"/>
                <c:choose>
                    <c:when test="${entity.remark!=null}">
                        <tr>
                            <td align="right">
                                <label class="control-label" for="oldRemark">历史批注：</label>
                            </td>
                            <td>
                                <label class="control-label" id="oldRemark">${entity.remark}</label>
                            </td>
                        </tr>
                    </c:when>
                </c:choose>
                <tr>
                    <td align="right">
                        <label class="control-label" for="outcome">操作：</label>
                    </td>
                    <td>
                        <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                               value="批准" checked="checked"
                               data-label="批准">
                        <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                               value="驳回" checked="checked"
                               data-label="驳回">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="remark">批注：</label>
                    </td>
                    <td>
                        <input type="text" id="remark" name="remark" maxlength="3000" value=""
                               placeholder="请输入备注信息">
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
            <button type="submit" class="btn-green" data-icon="save">确定</button>
        </li>
    </ul>
</div>