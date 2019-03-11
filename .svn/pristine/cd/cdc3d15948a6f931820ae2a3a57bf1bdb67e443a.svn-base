<%@ page import="com.utils.WebUtils" %>
<%@ page import="com.constant.Url" %>
<%@ page import="com.constant.CommonConstant" %>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>   <%--请不要删除，页面引入时有用--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="/sys" prefix="sys" %>
<%@ taglib prefix="hs" tagdir="/WEB-INF/tags" %>
<!-- 引入公共js -->
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/customstatic/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/customstatic/js/common/commonUtil.validate.js"></script>
<%
    request.setAttribute("root", WebUtils.getFullRoot(request));
    request.setAttribute("currentUser", (User)session.getAttribute(SessionKey.USER));
%>