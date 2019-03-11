<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/in_writing.css">
<div class="container-fluid" style="background: #F9F9F9;">
    <!-- mp3 start -->
    <div class="row-fluid" id="mp3">
        <%@include file="/public/header.jsp" %>
    </div>
    <!-- mp3 end -->
        <div class="row-fluid">
            <!-- left info start -->
            <div class="col-md-3" id="left">
                <%@include file="/public/left_info.jsp" %>
            </div>
            <!-- left info end -->

            <!-- mid info start -->
            <div class="col-md-9" id="mid" style="padding-right: 0px">
                <!-- editor start -->
                <div id="editor">
                    <div>
                        <h1>笔录问答</h1>
                    </div>
                </div>
                <!-- editor end -->

                <div id="info">
                    ${entity.recordContent}
                </div>
                <!-- info end -->
            </div>
            <!-- mid info end -->
        </div>
</div>
<div class="bjui-pageFooter navbar-fixed-bottom">
    <ul>
        <li style="margin-top: 10px;">
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>
        <li style="margin-top: 10px;">
            <button class="btn-blue btn reportBtn" type="button" onclick="reportBtn()">
                打印
            </button>
        </li>
    </ul>
</div>
<script src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/js/in_writing.js"></script>
<script>
    function reportBtn(){
        var record_start_time ='<hs:datefmt value="${entity.xwsj}" type="timeFormatDate"/>' ;
        var record_end_time ='<hs:datefmt value="${entity.blsj}" type="timeFormatDate"/>' ;
        var content = $("#info").html();
        var url;
        var json = {user1:"${entity.blryId}",user:"${entity.xwrId}",
            content:content,"record_start_time":record_start_time,"record_end_time":record_end_time};
        var i =0;
        i++;
        $.ajax({
            url:"${root}<%=Url.getUrl(Url.REPORT_RECORD_DATA)%>",
            data:json,
            type:"post",
            success:function(data){
                var b="";
                for (var i = 0;i<data.length;i++){
                    if(data.charAt(i) != '"'){
                        b +=data.charAt(i);
                    }
                }
                var path = "${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=";
                url = "/file/download.action?path=" + b;
                window.open("${root}/pdf/web/viewer.jsp?files="+url, "打印预览");
            },
            error:function(e){
                alert("错误！！");
            }
        });
    }
</script>