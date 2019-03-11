
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_TODAY_BOX)%>" method="post">
        <%--<div class="bjui-searchBar">
            <label for="caseid" class="control-label" >案件编号：</label>
            <input name="caseid" id="caseid" placeholder="请输入案件编号" size="20" maxlength="30" value="${searchObj.caseid}">

            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            &lt;%&ndash;<button class="btn-blue reset" data-icon="undo">清空查询</button>&ndash;%&gt;
            <a href="#" class="btn btn-green reset" data-width="600" data-height="500"  data-confirm-msg="清空查询">清空查询</a>
        </div>--%>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th  align="center">操作</th>
            <th>案件编号</th>
            <th>案件名称</th>
            <th>卷宗编号</th>
            <th>卷宗名称</th>
            <th>是否24小时内存入</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td align="center">
                    <sys:permission url="<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>?caseid=${item.criminalBean.caseid}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="800" data-height="500">详情</a>
                    </sys:permission>
                </td>
                <td title="${item.criminalBean.caseid}"><hs:out value="${item.criminalBean.caseid}" length="10"/></td>
                <td title="${item.criminalBean.casename}"><hs:out value="${item.criminalBean.casename}" length="10"/></td>
                <td title="${item.code}"><hs:out value="${item.code}" length="10"/></td>
                <td title="${item.name}"><hs:out value="${item.name}" length="10"/></td>
                <td>
                    <c:if test="${empty item.struts}">
                        --
                    </c:if>
                    <c:if test="${item.struts == '0'}">
                        --
                    </c:if>
                    <c:if test="${item.struts == '1'}">
                        是
                    </c:if>
                    <c:if test="${item.struts == '2'}">
                        ${item.operationTime > 1 ? '否' : '是'}
                    </c:if>
                    <c:if test="${item.struts == '3'}">
                        --
                    </c:if>
                </td>
                <td>

                    <c:if test="${empty item.struts}" var="flag">
                        未存入
                    </c:if>
                    <c:if test="${not flag}">
                        <hs:code value="${item.struts}" field="ARCHIVE-STRUTS" />
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>