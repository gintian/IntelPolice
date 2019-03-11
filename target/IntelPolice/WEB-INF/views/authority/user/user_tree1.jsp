<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script>
    function getName1(userId,userName) {
        $.CurrentNavtab.find("#userTree_userId1").val(userId);
        $.CurrentNavtab.find("#userTree_userName1").val(userName);
       parent.window.document.getElementById("userTree_userId1").value=userId;
       parent.window.document.getElementById("userTree_userName1").value=userName;
    }
</script>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped
   table-top data_table table_center" data-selected-multi="true" id="bt">
        <thead>
        <tr class="line_top">
            <th></th>
            <th align="center">姓名</th>
            <th align="center">身份证号</th>
            <th align="center">账户</th>
            <th align="center">警号</th>
            <th align="center">电话</th>
            <th align="center">短号</th>
            <th style="width: 50px;" align="center">性别</th>
            <th style="width: 80px;" align="center">人员类型</th>
            <th align="center">所属部门</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td><a onclick="getName1('${item.id}','${item.name}')" class="btn btn-close"
                       data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a></td>
                <td><hs:out value="${item.name}" length="25"/></td>
                <td><hs:out value="${item.identityCard}" length="10"/></td>
                <td><hs:out value="${item.account}" length="15"/></td>
                <td><hs:out value="${item.policeNumber}" length="5"/></td>
                <td><hs:out value="${item.phone}" length="5"/></td>
                <td><hs:out value="${item.shortPhone}" length="5"/></td>
                <td align="center">
                    <c:choose>
                        <c:when test="${item.sex ==1}">
                            男
                        </c:when>
                        <c:when test="${item.sex ==2}">
                            女
                        </c:when>
                        <c:otherwise>
                            保密
                        </c:otherwise>
                    </c:choose>
                </td>
                <td align="center">
                    <hs:typeDictory value="${item.userType}" type="USER_TYPE" valueType="id"/>
                </td>
                <td align="center">
                    <hs:dept value="${item.deptId}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
