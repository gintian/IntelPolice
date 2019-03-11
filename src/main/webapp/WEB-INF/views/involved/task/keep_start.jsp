<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_START)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-hover hw-table-long-input" width="100%">
                <tbody>
                <tr>
                    <input type="hidden" id="id" name="id" value="${entity.id}">
                    <td align="right">
                        <label class="control-label" for="outcome">操作：</label>
                    </td>
                    <td>
                        <input type="radio" name="outcome" id="outcome" data-toggle="icheck"
                               value="提交" checked="checked"
                               data-label="申请保管">
                    </td>
                </tr>
                <tr>
                    <div><label><h4>申请财务：</h4></label></div>
                </tr>
                <tr>
                    <div><label>财物编码:${entity.cwbm}</label></div>
                    <div><label>财物名称:${entity.cwmc}</label></div>
                    <div><label>财物类型:<hs:involvedType value="${entity.cwflCode}"/></label></div>
                    <div><label>财物物主:${entity.cwwz}</label></div>
                    <div><label>登记时间:${entity.djsj}</label></div>
                    <div><label>扣押原因:${entity.kyyy}</label></div>
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