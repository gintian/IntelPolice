<%@ tag import="com.utils.DateUtils" %>
<%@ tag import="java.util.Date" %>
<%@ tag import="com.utils.CommonValidate" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="value" type="java.lang.Object" required="false"%>
<%@ attribute name="type" type="java.lang.String" required="false" description="defualt to datetime" %>
<%@ attribute name="isShowOnEmpty" type="java.lang.Boolean" required="false" description="defualt to datetime" %><%--当时间为空时，是否显示"--" 默认 不显示--%>
<%@ attribute name="stringDatePatten" type="java.lang.String" required="false" %>
<%
    request.setAttribute("dateFormat", DateUtils.DEFAULT_DATE_PATTERN);//yyyy-MM-dd HH:mm:ss
    request.setAttribute("timeFormat", DateUtils.DEVICE_TIME_PATTERN);//HH:mm
    request.setAttribute("timeFormatSecond", DateUtils.DEVICE_TIME_PATTERN_SECOND);//HH:mm
    request.setAttribute("dateTimeFormat", DateUtils.DEVICE_DATE_PATTERN);//yyyy-MM-dd HH:mm
    request.setAttribute("shortDateTimeFormat", DateUtils.DEVICE_DAY_PATTERN_4);//MM-dd HH:mm
    request.setAttribute("dateTimeSecPattern", DateUtils.DEFAULT_DATE_PATTERN);//yyyy-MM-dd HH:mm:ss
    request.setAttribute("dayFormat", DateUtils.DEFAULT_DAY_PATTERN);//yyyy-MM-dd
    request.setAttribute("monthFormat", DateUtils.DEVICE_MONTH_PATTERN);//yyyy-MM
    Date date = null;
    if(CommonValidate.isNotEmpty(value)) {
        if(value instanceof Date) {
            date = (Date) value;
        }else if(value instanceof String) {
            date = DateUtils.stringToDate((String) value, stringDatePatten);
        }
    }

    request.setAttribute("date", date);
%>
<c:choose>
    <c:when test="${empty date}">
        <c:if test="${isShowOnEmpty.equals(true)}" >
            --
        </c:if>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${type eq 'time'}">
                <fmt:formatDate value="${date}" pattern="${timeFormat}"/>
            </c:when>
            <c:when test="${type eq 'date'}">
                <fmt:formatDate value="${date}" pattern="${dateFormat}"/>
            </c:when>
            <c:when test="${type eq 'shortdt'}">
                <fmt:formatDate value="${date}" pattern="${shortDateTimeFormat}"/>
            </c:when>
            <c:when test="${type eq 'dateTimeSec'}">
                <fmt:formatDate value="${date}" pattern="${dateTimeSecPattern}"/>
            </c:when>
            <c:when test="${type eq 'day'}">
                <fmt:formatDate value="${date}" pattern="${dayFormat}"/>
            </c:when>
            <c:when test="${type eq 'month'}">
                <fmt:formatDate value="${date}" pattern="${monthFormat}"/>
            </c:when>
            <c:when test="${type eq 'timeFormatSecond'}">
                <fmt:formatDate value="${date}" pattern="${timeFormatSecond}"/>
            </c:when>
            <c:otherwise>
                <fmt:formatDate value="${date}" pattern="${dateTimeFormat}"/>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>