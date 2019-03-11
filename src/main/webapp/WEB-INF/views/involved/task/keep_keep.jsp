<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script type="application/javascript">

</script>
<div class="bjui-pageContent">
    <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_KEEP)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table-hover hw-table-long-input" width="100%">
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
                               value="提交" checked="checked"
                               data-label="入库">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="involved_storeId">仓库：</label>
                    </td>
                    <td>
                        <input name="storeName" id="involved_storeName" readonly
                               data-rule="required" value="<hs:involvedStores value='${storeId}'/>"
                               type="text" style="width: 300px">
                        <input name="storeId" id="involved_storeId"
                               value="${storeId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_TREE_SHOW)%>?userId=${currentUser.id}"
                           data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-id="involcvedStores" data-mask="true"
                           data-width="800" data-height="600"
                           data-title="查询"></a>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="involved_lockerName">柜子：</label>
                    </td>
                    <td>
                        <input name="lockerName" id="involved_lockerName" readonly
                               data-rule="required" value="<hs:involvedStoresLockers value='${lockerId}'/>"
                               type="text" style="width: 300px">
                        <input name="lockerId" id="involved_lockerId"
                               value="${lockerId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_TREE_SHOW)%>"
                           data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-id="involcvedLockers" data-mask="true"
                           data-width="800" data-height="600"
                           data-title="查询"></a>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="involved_BoxId">箱子：</label>
                    </td>
                    <td>
                        <input name="boxNo" id="involved_boxNo" readonly
                               data-rule="required" value="<hs:involvedStoresBox value='${boxId}'/>"
                               type="text" style="width: 300px">
                        <input name="boxId" id="involved_boxId"
                               value="${boxId}" type="hidden">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_TREE_SHOW)%>" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-id="involcvedBox" data-mask="true"
                           data-width="800" data-height="600"
                           data-title="查询"></a>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="bgdqsj">保存到期时间：</label>
                    </td>
                    <td>
                        <input type="text" id="bgdqsj" name="bgdqsj"
                               data-toggle="datepicker" placeholder="请输入保存到期时间" data-pattern="yyyy-MM-dd"
                               value="<hs:datefmt value="${entity.bgdqsj}" type="dateTimeSecPattern"/>"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="remark">批注：</label>
                    </td>
                    <td>
                        <input type="text" id="remark" name="remark" maxlength="3000" value=""
                               placeholder="请输入备注信息" style="width: 300px">
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
            <button type="button" class="btn-close" data-icon="close">取消</button>
        </li>
        <li>
            <button type="submit" class="btn-green" data-icon="save">确定</button>
        </li>
    </ul>
</div>