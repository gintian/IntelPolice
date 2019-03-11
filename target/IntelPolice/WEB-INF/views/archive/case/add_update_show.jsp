<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>

<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
        <div class="bjui-row col-2">
        </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_CASE_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    </c:otherwise>
                    </c:choose>

                    <label class="row-label" for="archiveCase_archiveId">卷宗ID<span
                            class="required">*</span>：
                    </label>
                    <div class="row-input required">
                        <input type="text" id="archiveCase_archiveId" name="archiveId"
                               data-rule="required" maxlength="40" value="${entity.archiveId}"
                               placeholder="请输入卷宗ID，最多40字">
                    </div>
                    <label class="row-label" for="archiveCase_casrId">案件ID</label>
                    <div class="row-input required">
                        <input type="text" id="archiveCase_casrId" name="casrId"
                               maxlength="40" value="${entity.casrId}"
                               placeholder="请输入案件ID，最多40字">
                    </div>
                </div>
            </form>
        </div>
        <div class="bjui-pageFooter">
            <ul>
                <li>
                    <button class="btn-close btn" type="button" data-icon="close">
                        <i class="fa fa-close">取消</i>
                    </button>
                </li>
                <li>
                    <button class="btn btn-success" type="submit" data-icon="save"
                            data-target="menu01090101" onclick="BJUI.navtab('refresh', 'menu01090101')">保存
                    </button>
                </li>
            </ul>
        </div>