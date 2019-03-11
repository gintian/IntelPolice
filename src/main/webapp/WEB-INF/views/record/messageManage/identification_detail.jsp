<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/identification.css">
<div class="container-fluid">
    <!-- 头部 start 8-->
    <div id="header">
        <%@include file="/public/header.jsp" %>
    </div>
        <div class="row-fluid">
            <div class="col-md-3" id="info_left">
                <%@include file="/public/left_info.jsp" %>
            </div>
            <div class="col-md-9" id="info_right">
                <div id="info_image_top">
                    <fiedset style=" min-height:  200px;">
                        <legend>指认照片</legend>
                        <ul>
                            <c:forEach items="${personList}" var="person" varStatus="i">
                                <li>
                                    <div>
                                        <img class="img-responsive img-rounded" src="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=${person.pic}" alt="">
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </fiedset>
                </div>
                <div class="row-fluid" id="info_image_down">
                    <div class="ocl-md-12">
                        <fieldset>
                            <legend>辨认信息</legend>
                            <div>
                                ${entity.recordContent}
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
</div>
<div class="bjui-pageFooter navbar-fixed-bottom">
    <ul>
        <li style="margin-top: 10px;">
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>
    </ul>
</div>
<script src="${pageContext.request.contextPath }/js/identification.js"></script>