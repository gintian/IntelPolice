
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.INVOLVED_CASE_NO_INPUT)%>" method="post">
        <div class="bjui-searchBar">
            <label for="caseid" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">案件编号：</label>
            <input name="caseid" id="caseid" placeholder="请输入案件编号" size="20" maxlength="30" value="${searchObj.caseid}">

            <label for="casename" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">案件名称：</label>
            <input name="casename" id="casename" value="${searchObj.casename}" size="20" type="text">

            <label for="caseclass" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">案件类型：</label>
            <%--<input name="caseclass" id="caseclass" value="${searchObj.caseclass}" size="20" type="text">--%>

            <select id="caseclass" data-toggle="selectpicker" name="caseclass" data-val="${searchObj.caseclass}" data-width="200">
                <option value="" selected>请选择</option>
                <c:forEach var="item" items="${caseclassmap}">
                    ${item.key} > ${item.value} <br>
                    <c:choose>
                        <c:when test="${item.key == searchObj.caseclass}">
                            <option value="${item.key}" selected>${item.value}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.key}">${item.value}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>

            <%--<label for="processpersonname" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">办案人员：</label>--%>
            <%--<input name="processpersonname" id="processpersonname" value="${searchObj.processpersonname}" size="20" type="text">--%>

            <%--<label for="unitname" class="control-label" style="margin-left: 0px;padding-left: 0px;width:80px;">执法单位：</label>--%>
            <%--<input name="unitname" id="unitname" value="${searchObj.unitname}" size="20" type="text">--%>

            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <%--<button class="btn-blue reset" data-icon="undo">清空查询</button>--%>
            <a href="#" class="btn btn-green reset" data-width="600" data-height="500"  data-confirm-msg="清空查询">清空查询</a>

        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th width="220" align="center">操作</th>
            <th>案件编号</th>
            <th>案件名称</th>
            <th>案件类型</th>
            <th>办案人员</th>
            <th>办案单位</th>
            <th>简要案情</th>
            <th>录入时间</th>
            <th>修改时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td align="center">
                    <sys:permission url="<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>?caseid=${item.caseid}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="800" data-height="500">查看</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_CASE_SYNC_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_CASE_SYNC_SHOW)%>?caseid=${item.caseid}" class="btn btn-blue" data-id="sync" data-toggle="navtab" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="同步财务">同步财务</a>
                    </sys:permission>

                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_CASE_NO_REQUIRE_SYNC)%>">
                        <a href="${root}<%=Url.getUrl(Url.INVOLVED_CASE_NO_REQUIRE_SYNC)%>?caseid=${item.caseid}" class="btn btn-orange" data-toggle="doajax" data-confirm-msg="确定要无需同步吗？">无需同步</a>
                    </sys:permission>
                </td>
                <td title="${item.caseid}"><hs:out value="${item.caseid}" length="10"/></td>
                <td title="${item.casename}"><hs:out value="${item.casename}" length="10"/></td>
                <td title=""><hs:out value="${item.codedesc}" /></td>
                <td></td><td></td>
                <%--<td title=""><hs:out value="${item.processpersonname}"/></td>--%>
                <%--<td title="${item.unitname}"><hs:out value="${item.unitname}" length="10"/></td>--%>
                <td title="${item.disposedetails}"><hs:out value="${item.disposedetails}" length="10"/></td>
                <td><hs:datefmt value="${item.inputtime}" /></td>
                <td><hs:datefmt value="${item.modifiedtime}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>