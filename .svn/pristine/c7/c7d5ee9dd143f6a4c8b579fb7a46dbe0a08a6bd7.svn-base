<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
        <c:if test="${stuts == 'wcg'}">
                <form id="${searchFormId}" data-toggle="ajaxsearch"
                     action="${root}<%=Url.getUrl(Url.CRIMINAL_SMS_NOTCG_PAGE_SHOW)%>" method="post">
        </c:if>
        <c:if test="${stuts == 'wfx'}">
            <form id="${searchFormId}" data-toggle="ajaxsearch"
                  action="${root}<%=Url.getUrl(Url.CRIMINAL_SMS_NOTFS_PAGE_SHOW)%>" method="post">

        </c:if>
        <c:if test="${stuts == 'cf'}">
            <form id="${searchFormId}" data-toggle="ajaxsearch"
                  action="${root}<%=Url.getUrl(Url.CRIMINAL_SMS_CF_PAGE_SHOW)%>" method="post">
        </c:if>
        <div class="bjui-searchBar">
            <label for="caseid" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">案件编号：</label>
            <input name="caseid" id="caseid" placeholder="请输入案件编号" style="width: 200px;"
                   value="${searchObj.caseid}">
            <label for="casename" class="control-label"
                   style="margin-left: 0px; padding-left: 0px; width: 60px;">案件名称：</label>
            <input name="casename" id="casename" placeholder="请输入案件名称" style="width: 200px;"
                   value="${searchObj.casename}">
            <button type="button" class="showMoreSearch" data-toggle="moresearch"
                    data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <div class="bjui-moreSearch">
                <label for="alarmtype" class="control-label"
                       style="margin-left: 0px; padding-left: 0px; width: 60px;">警情类别：</label>
                <input name="alarmtype" id="alarmtype" placeholder="警情类别"
                       style="width: 200px;" value="${searchObj.alarmtype}">
            </div>
            <button type="submit" class="btn-blue" data-icon="search"
                    id="query_base_show">查询
            </button>
            <a class="btn btn-orange reset" href="javascript:;"
               data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>

        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table
            class="table table-bordered table-hover table-striped table-top data_table table_center"
            data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="50" align="center">操作</th>
            <th width="70" align="center">案件编号</th>
            <th width="100" align="center">案件名称</th>
            <th width="70" align="center">接收人</th>
            <th width="70" align="center">接收电话</th>
            <th width="70" align="center">${stuts == 'cf'? '重复':'发送'}内容</th>
            <th width="70" align="center">是否发送</th>
            <th width="70" align="center">是否成功</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
                <tr>
                    <td class="option" align="center">
                        <sys:permission url="<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>?caseid=${item.caseid}"
                               class="btn btn-green" data-toggle="dialog" data-mask="true"
                               data-width="800" data-height="500">详情</a>
                        </sys:permission>
                    </td>
                    <td title="${item.caseid}"><hs:out
                            value="${item.caseid}" length="5"/></td>
                    <td title="${item.casename}"><hs:out
                            value="${item.casename}"/></td>
                    <c:if test="${stuts == 'wcg'}">
                            <td title="${item.smsLogBean.personId}"><hs:out
                                    value="${item.smsLogBean.personId}"/></td>
                            <td title="${item.smsLogBean.telephone}"><hs:out
                                    value="${item.smsLogBean.telephone}"/></td>
                            <td title="${item.smsLogBean.content}"><hs:out
                                    value="${item.smsLogBean.content}"/></td>
                            <td >是</td>
                            <td >否</td>

                    </c:if>
                    <c:if test="${stuts == 'wfx'}">
                        <td >--</td>
                        <td >--</td>
                        <td >--</td>
                        <td >否</td>
                        <td >--</td>
                    </c:if>
                    <c:if test="${stuts == 'cf'}">
                        <td title="${item.smsLogBean.personId}"><hs:out
                                value="${item.smsLogBean.personId}"/></td>
                        <td title="${item.smsLogBean.telephone}"><hs:out
                                value="${item.smsLogBean.telephone}"/></td>
                        <td title="${item.smsLogBean.content}"><hs:out
                                value="${item.smsLogBean.content}"/></td>
                        <td >是</td>
                        <td >是</td>
                    </c:if>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>