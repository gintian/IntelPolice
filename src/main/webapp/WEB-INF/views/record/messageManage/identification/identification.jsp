<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/identification.css">
    <div class="container-fluid">
        <!-- 头部 start 8-->
        <div id="header">
            <%@include file="/public/header.jsp" %>
        </div>
        <form id="casePersonForm1" ata-toggle="ajaxform"   method="post"  >
            <input type="hidden" name="xwsj" value="${currentTime}">
            <input type="hidden" name="blsj" value="${currentTime}">
            <input type="hidden" name="recordType" value="${typeId}">
            <div class="row-fluid">
                <div class="col-md-3" id="info_left">
                    <%@include file="/public/left_info.jsp" %>
                </div>
                <div class="col-md-9" id="info_right">
                    <div id="info_image_top">
                            <fiedset>
                                <legend>指认照片</legend>
                                <ul>
                                    <c:forEach items="${personList}" var="person" varStatus="i">
                                        <li>
                                            <div>
                                                <input type="hidden" name="bbrr${i.count}" value="${person.personId}">
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
                                <textarea  placeholder="在此输入..." id="j_form_content" class="j-content" name="recordContent" style="width: 100%;" data-toggle="kindeditor" data-minheight="200">
                                </textarea>
                            </fieldset>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div id="footer">
                        <%@include file="/public/footer.jsp" %>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath }/js/identification.js"></script>
<script>
    $("#casePersonForm1").submit(function(){
        $("#casePersonForm1").bjuiajax('ajaxform', {
            url: '${root}<%=Url.getUrl(Url.RECORD_ADD_CASE_SUBMIT)%>',
            validate: true,
            okCallback:function(){
                $(this).navtab('refresh');//刷新当前页签
                $(this).dialog('closeCurrent');//关闭当前弹窗
            },
            loadingmask: true,
            confirmMsg:'是否提交数据',
    });
    });
</script>