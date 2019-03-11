<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<c:choose>
    <c:when test="${empty entity or empty entity.id}">
        <script>
            $(function setDetail() {
                $("#file_name").val('${file.name}');
                $("#file_sizes").val('${file.size}');
                $("#file_path").val('${file.path}');
            })
            <%
                request.getSession().removeAttribute("file");
            %>
        </script>
    </c:when>
</c:choose>
<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.FILES_ADD_SUBMIT)%>"
          data-toggle="validate" data-reload-navtab="true" method="post">
        <div class="bjui-row col-2">
            <td align="right">
                <label class="row-label">上传文件：</label>
            </td>
            <a href="${root}<%=Url.getUrl(Url.FILES_ADD_UPLOAD_SHOW)%>?currentType=${currentType}"
               data-toggle="dialog" class="btn btn-blue" data-width="600" data-height="300"
               data-id="dialog" data-title="上传" style="width: 100px">上&emsp;传&emsp;文&emsp;件</a>
            <label class="btn" ><font color="red">请&nbsp;先&nbsp;上&nbsp;传&nbsp;文&nbsp;件&nbsp;，&nbsp;信&nbsp;息&nbsp;会&nbsp;自&nbsp;动&nbsp;填&nbsp;充</font></label><br/>
            <input type="hidden" name="type" value="${currentType}">
            <input type="hidden" name="createTime" value="${currentTime}">
            <input type="hidden" name="userName" value="${currentUser.name}">
            </c:when>
            <c:otherwise>
            <form action="${root}<%=Url.getUrl(Url.FILES_UPDATE_SUBMIT)%>"
                  data-toggle="validate" data-reload-navtab="true" method="post">
                <div class="bjui-row col-2">
                    <input type="hidden" name="id" value="${entity.id}">
                    <input type="hidden" name="type" value="${entity.type}">
                    </c:otherwise>
                    </c:choose>

                    <td align="right">
                        <label class="row-label" for="file_name">文件名：</label>
                    </td>
                    <div class="row-input required">
                        <input type="text" data-rule="required" id="file_name" name="name" value="${entity.name}">
                    </div><br/>
                    <td align="right">
                        <label class="row-label" for="file_path">文件路径：</label>
                    </td>
                    <div class="row-input required">
                        <input type="text" data-rule="required" id="file_path" name="path" value="${entity.path}" readonly>
                    </div><br/>
                    <td align="right">
                        <label class="row-label" for="file_sizes">文件大小：</label>
                    </td>
                    <div class="row-input required">
                        <input type="text" data-rule="required" id="file_sizes" name="sizes" value="${entity.sizes}" readonly>
                    </div><br/>
                    <td align="right">
                        <label class="row-label" for="files_description">文件描述：</label>
                    </td>
                    <div class="row-input">
                        <input type="text" id="files_description" name="description"
                               maxlength="400" value="${entity.description}"
                               placeholder="请输入文件描述，最多400字">
                    </div><br/>
                    <td align="right">
                        <label class="row-label" for="files_sortCode">排序号：</label>
                    </td>
                    <div class="row-input">
                        <input type="text" id="files_sortCode" name="sortCode"
                               maxlength="40" value="${entity.sortCode}"
                               placeholder="请输入排序号，最多40字">
                    </div><br/>
                    <c:choose>
                        <c:when test="${currentType==11||currentType==12||currentType==13||currentType==14||currentType==15
                ||entity.type==11||entity.type==12||entity.type==13||entity.type==14||entity.type==15}">
                            <input type="hidden" name="status" id="files_status" value="2">
                        </c:when>
                        <c:otherwise>
                            <td align="right">
                                <label class="row-label" for="files_status">启用状态<span class="required">*</span>：</label>
                            </td>
                            <div class="row-input required">
                                <c:choose>
                                    <c:when test="${entity.status==1}">
                                        <input type="radio" name="status" id="files_status" data-toggle="icheck"
                                               value="1"
                                               checked="checked" data-label="正常查询">
                                        <input type="radio" name="status" id="files_status" data-toggle="icheck"
                                               value="2"
                                               data-label="仅作模板">
                                    </c:when>
                                    <c:when test="${entity.status==2}">
                                        <input type="radio" name="status" id="files_status" data-toggle="icheck"
                                               value="1"
                                               data-label="正常查询">
                                        <input type="radio" name="status" id="files_status" data-toggle="icheck"
                                               value="2"
                                               checked="checked" data-label="仅作模板">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="status" id="files_status" data-toggle="icheck"
                                               value="1"
                                               data-label="正常查询">
                                        <input type="radio" name="status" id="files_status" data-toggle="icheck"
                                               value="2"
                                               data-label="仅作模板">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${currentType==11||currentType==12||currentType==13||currentType==14||currentType==15}">
                            <td align="right">
                                <label class="row-label" for="files_objId">同步财物ID：</label>
                            </td>
                            <div class="row-input">
                                <input type="text" id="files_objId" name="objId"
                                       maxlength="40" value="${entity.objId}"
                                       placeholder="请输入同步过来的财物ID">
                            </div>
                            <td align="right">
                                <label class="row-label" for="files_spoilsId">涉案财物id：</label>
                            </td>
                            <div class="row-input">
                                <input type="text" id="files_spoilsId" name="spoilsId"
                                       maxlength="40" value="${entity.spoilsId}"
                                       placeholder="请输入涉案财物id">
                            </div>
                        </c:when>
                    </c:choose>
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
                    <button class="btn btn-success" type="submit" data-icon="save"
                            data-target="menu01060502" onclick="BJUI.navtab('refresh', 'menu01060502')">保存
                    </button>
                </li>
            </ul>
        </div>
