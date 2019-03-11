<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script type="application/javascript">
    var a ;
    function a1(obj) {
        a = $("#involved_storeId").val();
        $(obj).attr("href","${root}<%=Url.getUrl(Url.INVOLVED_STORES_LOCKERS_TREE_SHOW)%>"+"?storeId="+a);
    }
    function a2(obj) {
        a = $("#involved_lockerId").val();
        $(obj).attr("href","${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_TREE_SHOW)%>"+"?lockerId="+a);
    }
</script>
<div class="bjui-pageContent">
    <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_KEEP_UPDATE_SUBMIT)%>"
          data-toggle="validate"
          data-reload-navtab="true" method="post">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table-hover hw-table-long-input" width="100%">
                <tbody>
                <<input type="hidden" name="id" value="${entity.id}">
                <tr>
                    <td align="right">
                        <label class="control-label" for="outcome">操作：</label>
                    </td>
                    <td>
                        <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                               value="提交" checked="checked"
                               data-label="修改存放信息">
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="involved_storeId">仓库：</label>
                    </td>
                    <td>
                        <input name="storeName" id="involved_storeName" readonly
                               value="<hs:involvedStores value='${storeId}'/>"
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
                               value="<hs:involvedStoresLockers value='${lockerId}'/>"
                               type="text" style="width: 300px">
                        <input name="lockerId" id="involved_lockerId"
                               value="${lockerId}" type="hidden">
                        <a onclick="a1(this)" href=""
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
                               value="<hs:involvedStoresBox value='${boxId}'/>"
                               type="text" style="width: 300px">
                        <input name="boxId" id="involved_boxId"
                               value="${boxId}" type="hidden">
                        <a onclick="a2(this)" href="" data-icon="search"
                           class="btn btn-blue" data-toggle="dialog" data-id="involcvedBox" data-mask="true"
                           data-width="800" data-height="600"
                           data-title="查询"></a>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="control-label" for="bgdqsj">保存到期时间 ：</label>
                    </td>
                    <td>
                        <input type="text" id="bgdqsj" name="bgdqsj"
                               data-toggle="datepicker" data-pattern="yyyy-MM-dd"
                               value="<hs:datefmt value="${entity.bgdqsj}" type="dateTimeSecPattern"/>"/>
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