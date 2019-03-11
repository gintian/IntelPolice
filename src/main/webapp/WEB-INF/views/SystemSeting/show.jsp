<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent tableContent">
    <form action="${root}<%=Url.getUrl(Url.SYSTEM_SETTINGS_CURRENT_DEPT_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post">
        <div class="bjui-row col-2">
            <label class="row-label">使用网点<span class="required">*</span>：
            </label>
            <div class="row-input required">
                <input name="deptName" id="user_deptName" value="${searchObj.deptName}" size="20" readonly type="text">
                <input name="deptId" id="user_deptId" value="${searchObj.deptId}" size="20" type="hidden">
                <a href="${root}<%=Url.getUrl(Url.USER_DEPT_TREE_SHOW)%>" data-id="dept_tree" data-icon="search"
                   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                   data-title="查询"></a>
            </div>
            <button type="submit" class="btn-blue">保存</button>
        </div>

    </form>
</div>