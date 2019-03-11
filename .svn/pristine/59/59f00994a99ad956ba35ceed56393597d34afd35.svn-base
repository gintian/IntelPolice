<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>

<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<c:set var="files" value="${fileList}" />
<%
    request.getSession().removeAttribute("file");
    request.getSession().removeAttribute("fileList");
%>
<div class="bjui-pageContent">
    <c:choose>
        <c:when test="${empty entity or empty entity.id}">
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-3">
                    <input type="hidden" name="addTime" value="${currentTime}">
                    <input type="hidden" id="caseid" name="caseid" value="${caseid}">
        </c:when>
        <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.ARCHIVE_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                <div class="bjui-row col-3">
                    <input type="hidden" name="editTime" value="${currentTime}">
                    <input type="hidden" id="id" name="id" value="${entity.id}">
                    <input type="hidden" id="caseid" name="caseid" value="${caseid}">
        </c:otherwise>
    </c:choose>
                    <label class="row-label" for="archive_archiveName">卷宗名称：</label>
                    <div class="row-input required" style="width: 220px">
                        <input type="text" id="archive_archiveName" name="name"
                               data-rule="required" maxlength="40" value="${entity.name}"
                               placeholder="请输入名称，最多40字" style="width: 200px">
                    </div><br><br>
                    <label class="row-label" for="lockers_type">类型：</label>
                    <div class="row-input required" style="width: 160px;">
                        <select id="lockers_type" name="type" data-toggle="selectpicker" data-width="200" onchange="clickOption()">
                            <option value="0"  ${entity.type eq 0 ? "selected" : "" }>电子卷宗</option>
                            <option value="1"  ${entity.type eq 1 ? "selected" : "" }>实体卷宗</option>
                        </select></div><br>
                        <div class="uploadOption" style="${entity.type eq 1 ? 'display:none' : ''}">
                            <a id="sx"  onclick="xs()" href="#"
                               data-toggle="dialog" class="btn btn-blue" data-width="600" data-height="300"
                                data-title="上传" style="width: 100px">上传文件</a>
                            <label class="btn" ><font color="red">请&nbsp;先&nbsp;上&nbsp;传&nbsp;文&nbsp;件&nbsp;，&nbsp;信&nbsp;息&nbsp;会&nbsp;自&nbsp;动&nbsp;填&nbsp;充</font></label><br/>
                            <div class="row-input required imgParhs">
                                <c:set var="sizeFiles" value="0" />
                                <c:forEach items="${files}" var="file" >
                                    <input type="hidden"  data-rule="required" id="file_path" name="imgPathes" value="${file.path}">
                                    <img  data-max="true" width="500px" height="500px" src="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=${file.path}">
                                </c:forEach>
                            </div><br/>
                        </div>

                        <label class="row-label" for="archive_archiveNum">卷宗数量：</label>
                        <div class="row-input required" style="width: 220px">
                            <input type="number" min="0" max="99" id="archive_archiveNum" name="num"
                                   data-rule="required" maxlength="40" value="${entity.num}"
                                   placeholder="0-99" style="width: 200px">
                        </div><br>
                        <label class="row-label" for="archive_archiveNum">备注：</label>
                        <div class="row-input">
                            <input type="text" id="archive_archiveRemark" name="remark"
                                   maxlength="40" value="${entity.remark}"
                                   placeholder="请输入备注，最多40字" style="width: 200px">
                        </div><br>
                </div>
            </form>
        </div>
        <div class="bjui-pageFooter">
            <ul>
                <li>
                    <button class="btn-close btn" type="button" data-icon="close">
                        <i class="fa fa-close">取消</i>
                    </button>
                </li>
                <li>
                    <button class="btn-default" type="submit" data-icon="save"
                            data-target="menu01071004" onclick="BJUI.navtab('refresh', 'menu01071004')">保存
                    </button>
                </li>
            </ul>
        </div>
<script>
    function clickOption() {
        var num = $("#lockers_type").val();
        if(num == 0){
            $(".uploadOption").show();
        }
        if(num == 1){
            $(".imgParhs").remove();
            $(".uploadOption").hide();
        }
    }
    function xs(){
        var id = $("#id").val();
        var caseid = $("#caseid").val();
        var name = $("#archive_archiveName").val();
        var type = $("#lockers_type").val();
        var num = $("#archive_archiveNum").val();
        var content ="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_UPLOAD_SHOW)%>?${empty entity or empty entity.id ? 'addTime':'editTime'}=${currentTime}";
        if(id != null){
            content += "&id="+ id ;
        }
        if(caseid != null){
            content += "&caseid="+ caseid;
        }
        if(name != null){
            content += "&name="+ name;
        }
        if(type != null){
            content += "&type="+ type;
        }
        if(num != null){
            content += "&num="+ num;
        }
        var content = "${root}<%=Url.getUrl(Url.ARCHIVE_ADD_UPLOAD_SHOW)%>?id="+ id +"&caseid="+ caseid +"&name="+ name +"&type="+ type +"&num="+ num +
            "&${empty entity or empty entity.id ? 'addTime':'editTime'}=${currentTime}";
        $("#sx").prop("href",content);
    }
</script>