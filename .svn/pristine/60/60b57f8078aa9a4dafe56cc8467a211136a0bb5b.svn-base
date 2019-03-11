<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.model.bean.RecordPersonBean" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<style>
    /* 左边笔录信息 start */
    #left{height: 600px;padding-left: 0;padding-right: 0;}
    #menu li{list-style: none;float: left;}
    #menu button{height: 30px;}
    #menu_info{height: 600px;}
        .menu_info_up{border: 1px #c5c4c4 solid;height: 600px;overflow: auto;}
    /* 左边笔录信息 end */
</style>
<%
    RecordPersonBean recordPersonBean = (RecordPersonBean) request.getAttribute("person");
    session.setAttribute("record-person",recordPersonBean);
%>
    <!-- menu_info start -->
    <div id="menu_info">
        <!-- 记录人 start -->
        <div class="menu_info_up" style="display: block;">
            <input type="hidden" name="caseId" value="${caseS.caseid}" >
            <fieldset>
                <legend>案件信息：</legend>
                <table class="table">
                    <tr>
                        <td>案件名称:</td>
                        <td>${caseS.casename}</td>
                    </tr>
                    <tr>
                        <td>案件地点:</td>
                        <td>${caseS.caseaddress}</td>
                    </tr>
                    <tr>
                        <td>案件时间:</td>
                        <td><hs:datefmt value="${caseS.casetimestart}" stringDatePatten="dateTimeFormat"/></td>
                    </tr>
                    <tr>
                        <td>案件起因:</td>
                        <td title="${caseS.disposedetails}" style="cursor: pointer"><hs:out value="${caseS.disposedetails}" length="10"/></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>人员信息</legend>
                <input type="hidden" name="xwrId" value="${userId}">
                <input type="hidden" name="blryId" value="${userId1}">
                <input type="hidden" name="${modelId eq '001'? 'bxwr' : 'brr'}" value="${person.personId}">
                <table class="table">
                    <tr>
                        <td>姓名：</td>
                        <td>${person.name}</td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td>
                            ${num}
                            <c:if test="${fn:length(person.idcard) eq 15}">
                                <c:set value="${fn:substring(person.idcard, 14, 15)}" var="num" />
                                ${ num % 2 == 0 ? "女" : "男"}
                            </c:if>
                            <c:if test="${fn:length(person.idcard) eq 18}">
                                <c:set value="${fn:substring(person.idcard, 16, 17)}" var="num" />
                                ${ num % 2 == 0 ? "女" : "男"}
                            </c:if>

                        </td>
                    </tr>
                    <tr>
                        <td>出生地：</td>
                        <td>${person.bxwrAddr}</td>
                    </tr>
                    <tr>
                        <td>身份证号：</td>
                        <td>${person.idcard}</td>
                    </tr>
                </table>
            </fieldset>

        </div>
        <!-- 记录人 end -->
<%--
        <!-- 被受理人 strat -->
        <div class="menu_info_up" style="display: none;">
            <fieldset>
                <legend>案件参与者</legend>
                <table class="table">
                    <tr>
                        <td>姓名：</td>
                        <td>某某某</td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td>某</td>
                    </tr>
                    <tr>
                        <td>出生地：</td>
                        <td>某地</td>
                    </tr>
                    <tr>
                        <td>身份证号：</td>
                        <td>000000000000000</td>
                    </tr>
                    <tr>
                        <td>学历：</td>
                        <td>学历</td>
                    </tr>
                    <tr>
                        <td>籍贯：</td>
                        <td>某地</td>
                    </tr>
                    <tr>
                        <td>出生年月：</td>
                        <td>年月日</td>
                    </tr>
                </table>
            </fieldset>
        </div>--%>
        <!-- 被受理人 end -->
    </div>
    <!-- menu_info end -->