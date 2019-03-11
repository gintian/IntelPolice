<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_DISPOSE_TASK_SUBMIT)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
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
                    <c:choose>
                        <c:when test="${entity.taskName=='申请'}">
                            <td>
                                <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                                       value="提交申请" checked="checked"
                                       data-label="提交申请">
                                <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                                       value="取消申请" checked="checked"
                                       data-label="取消申请">
                            </td>
                        </c:when>
                        <c:when test="${entity.taskName=='确认'}">
                            <td>
                                <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                                       value="确认处置" checked="checked"
                                       data-label="确认处置">
                            </td>
                        </c:when>
                    </c:choose>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="remark">批注：</label>
                    </td>
                    <td>
                        <input type="text" id="remark" name="remark" maxlength="3000" value=""
                               placeholder="请输入批注信息">
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