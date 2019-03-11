<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<div class="panel panel-default" style="height: 600px;overflow: auto">
    <div class="panel-body">
        <div class="form-horizontal">
            <c:if test="${empty entity or empty entity.personId}" var="flag">
                <form id="person_form" action="${root}<%=Url.getUrl(Url.RECORD_PERSON_ADD_SUBMIT)%>"
                      data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false" enctype="multipart/form-data">
                    <input type="hidden" name="addTime" value="${currentTime}">
                    <input name="addUser" value="${currentUser.id}" type="hidden">
            </c:if>
            <c:if test="${not flag}">
                <form id="person_form" action="${root}<%=Url.getUrl(Url.RECORD_PERSON_UPDATE_SUBMIT)%>"
                      data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false" enctype="multipart/form-data">
                    <input type="hidden" name="personId" value="${entity.personId}">
                <input type="hidden" name="modifyUser" value="${currentUser.id}">
                    <input type="hidden" name="modifyTime" value="${currentTime}">
            </c:if>
                    <div class="form-group">
                        <label for="name" class="col-md-4">人员名称：</label>
                        <div class="col-md-8">
                            <input id="name" name="name" data-rule="required" value=" ${entity.name}" class="form-control" maxlength="50" placeholder="请输入人员名称(50字以内)" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idcard" class="col-md-4">身份证号：</label>
                        <div class="col-md-8">
                            <input type="text" id="idcard"  value="${entity.idcard}"  name="idcard" class="form-control" maxlength="18" placeholder="请输入身份证号码" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="files" class="col-md-4" >上传照片：</label>
                        <div class="col-md-8">
                            <s:file id="files"  name="fileBean.file" label="files" data-rule="required"  class="form-control"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bxwrPhone" class="col-md-4">联系电话：</label>
                        <div class="col-md-8">
                            <input id="bxwrPhone" name="bxwrPhone"  data-rule="required" value="${entity.bxwrPhone}" class="form-control" maxlength="11" placeholder="请输入联系电话" autocomplete="off"  />
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-md-4">人大代表：</label>
                            <div class="col-md-8">
                                <label class="radio-inline">
                                    <%--<input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2--%>
                                    <input  type="radio" name="isrddb" class="form-control" value="0" ${entity.isrddb eq "0" ? "checked" : "" } >&nbsp; &nbsp; 是
                                </label>
                                <label class="radio-inline">
                                    <input  type="radio" name="isrddb"  class="form-control" value="1" ${empty entity.isrddb or entity.isrddb eq "1" ? "checked" : "" } > &nbsp; &nbsp;否
                                </label>
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="bxwrAddr" class="col-md-4">居住地址：</label>
                        <div class="col-md-8">
                            <input id="bxwrAddr" name="bxwrAddr"  data-rule="required" value="${entity.bxwrAddr}" class="form-control" maxlength="50" placeholder="请输入居住地址" autocomplete="off"  />
                        </div>
                    </div>
        <div class="bjui-pageFooter navbar-fixed-bottom">
            <ul>
                <li>
                    <button class="btn-close btn" type="button" data-icon="close">
                        <i class="fa fa-close">取消</i>
                    </button>
                </li>
                <li>
                    <button class="btn btn-success" type="submit" data-icon="save"
                            data-target="menu01090101" onclick="BJUI.navtab('refresh', 'menu01090101')">保存
                    </button>
                </li>
            </ul>
        </div>
                </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/bootstrapvalidator/js/language/zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/bootsrap-fileinput-4.4.9/js/fileinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/bootsrap-fileinput-4.4.9/js/locales/zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/bootstrap-datetimepicker-2.4.4/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/bootstrap-datetimepicker-2.4.4/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/bootsrap/person_add.js"></script>
<script>
    $(function(){
        <c:if test="${ empty entity or empty entity.personId}" var="a">
        </c:if>
        <c:if test="${not a}">
            pic =[ //预览图片的设置
                '<img src="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=${entity.pic}" class="file-preview-image kv-preview-data" style="width:auto;height:auto;max-width:100%;max-height:100%;"  >',
            ];
        </c:if>
    });
</script>