
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.RECORD_PAGE_SHOW_NO_INPUT)%>" method="post">
        <div class="bjui-searchBar">
            <label for="caseid" class="control-label" >案件编号：</label>
            <input name="caseid" id="caseid" placeholder="请输入案件编号" size="20" maxlength="30" value="${searchObj.caseid}">

            <label for="casename" class="control-label" >案件名称：</label>
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
            <th  align="center">操作</th>
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
                    <sys:permission url="<%=Url.getUrl(Url.RECORD_INTERROGATION_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_SHOW)%>?caseId=${item.caseid}&status=0" class="btn btn-blue" data-toggle="navtab" data-id="navtab_record" data-confirm-msg="讯问笔录">讯问笔录</a>
                    </sys:permission><br>
                    <sys:permission url="<%=Url.getUrl(Url.RECORD_INQUIRY_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_SHOW)%>?caseId=${item.caseid}&status=1" class="btn btn-red" data-toggle="navtab" data-id="navtab_record"  data-confirm-msg="询问笔录">询问笔录</a>
                    </sys:permission>
                    <sys:permission url="<%=Url.getUrl(Url.RECORD_IDENTIFY_SHOW)%>">
                        <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_SHOW)%>?caseId=${item.caseid}&status=2" class="btn btn-blue" data-toggle="navtab" data-id="navtab_record"  data-confirm-msg="辨认">辨认</a>
                    </sys:permission>
                </td>
                <td title="${item.caseid}"><hs:out value="${item.caseid}" length="10"/></td>
                <td title="${item.casename}"><hs:out value="${item.casename}" length="10"/></td>
                <td title=""><hs:out value="${item.codedesc}" /></td>
                <td>${item.processPersonName}</td>
                <td></td>
                <td title="${item.disposedetails}"><hs:out value="${item.disposedetails}" length="10"/></td>
                <td><hs:datefmt value="${item.inputtime}" /></td>
                <td><hs:datefmt value="${item.modifiedtime}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>