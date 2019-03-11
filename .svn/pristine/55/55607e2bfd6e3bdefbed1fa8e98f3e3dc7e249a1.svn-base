
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<style>
    .level-0,.level-1,.level-2{
        cursor: pointer;
    }
    .level:hover{color: #fff6f6; background: #003bb3}
    .level-1,.level-2{
        display: none;
    }
    .selected{color: #fff6f6; background: #003bb3}
</style>
<script>
    $(function(){
        $(".btn-type").click(function(){
            $(".select-type").toggle();
        });
        $(".list-group").on("click",".level",function() {
            var pid = $(this).data("id");
            var order = $(this).data("order");
            if($(this).parent().hasClass("level-0")){
                $(".level-1").hide();
                $(".level-2").hide();
                $(".level-0 .level").removeClass("selected");
                $(".level-1 .level").removeClass("selected");
                $(".level-2 .level").removeClass("selected");
                $("#" + pid).show();
            }
            if($(this).parent().hasClass("level-1")){
                $(".level-2").hide();
                $(".level-1 .level").removeClass("selected");
                $(".level-2 .level").removeClass("selected");
                $("#" + pid).show();
            }
            if($(this).parent().hasClass("level-2")){
                $(".level-2 .level").removeClass("selected");
            }
            $(this).addClass("selected");
            if(order == 0){
                $(".typeId").val($(this).data("id"));
                $(".type").val($(this).html());
                $(".select-type").hide();
            }
        })
    });
</script>
    <c:choose>
        <c:when test="${empty entity or empty entity.id}">
                <form action="${root}<%=Url.getUrl(Url.RECORD_QUESTION_ADD_SUBMIT)%>"
                     data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                    <input type="hidden" name="addTime" value="${currentTime}">
         </c:when>
     <c:otherwise>
                <form action="${root}<%=Url.getUrl(Url.RECORD_QUESTION_UPDATE_SUBMIT)%>"
                      data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                        <input type="hidden" name="id" value="${entity.id}">
                                <
                        <input type="hidden" name="modifyTime" value="${currentTime}" >
     </c:otherwise>
     </c:choose>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <label for="content" class="control-label" >问题内容：</label>
                                <textarea name="content" style="height: 150px;width: 350px;/*resize: none;*/" class="form-control" placeholder="500字以内"  id="content"  maxlength="150" type="text">${entity.content}</textarea>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-body">
                                    <input type="hidden" class="typeId" name="type" value="${entity.type}">
                                    <input  id="typeId" readonly class="type" data-rule="required" value="${entity.type}" type="text">
                                    <button  type="button" data-rule="required" class="btn btn-primary btn-type">选择</button>
                                    <%--一级--%>
                                    <div class="row select-type" style="display: none">
                                        <%--一级--%>
                                        <div class="col-md-4">
                                            <ul class="list-group level-0">
                                                <c:forEach items="${recordTypeBeanList}" var="ecordTypeBean">
                                                    <li  class=" list-group-item level" data-order="${ecordTypeBean.order}" data-id="${ecordTypeBean.id}">${ecordTypeBean.name}</li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                            <%--二级--%>
                                        <div class="col-md-4">
                                            <c:forEach items="${recordTypeBeanList}" var="ecordTypeBean">
                                                <ul class="list-group level-1" id="${ecordTypeBean.id}" data-pid="${ecordTypeBean.id}">
                                                    <c:forEach items="${ecordTypeBean.sonList}" var="ecordTypeOne">
                                                        <li class="list-group-item level" data-order="${ecordTypeOne.order}" data-id="${ecordTypeOne.id}">${ecordTypeOne.name}</li>
                                                    </c:forEach>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                            <%--三级--%>
                                        <div class="col-md-4">
                                            <c:forEach items="${recordTypeBeanList}" var="ecordTypeBean">
                                                <c:forEach items="${ecordTypeBean.sonList}" var="ecordTypeOne">
                                                    <ul class="list-group level-2 " id="${ecordTypeOne.id}" data-pid="${ecordTypeOne.id}">
                                                        <c:forEach items="${ecordTypeOne.sonList}" var="ecordTypeTwo">
                                                            <li  class="list-group-item level" data-order="${ecordTypeTwo.order}" data-id="${ecordTypeTwo.id}">${ecordTypeTwo.name}</li>
                                                        </c:forEach>
                                                    </ul>
                                                </c:forEach>
                                            </c:forEach>
                                        </div>
                                    </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <label for="caseclass" class="control-label" >案件类型：</label>
                                <select id="caseclass" data-toggle="selectpicker" name="caseType" data-val="${entity.caseType}" data-width="200">
                                    <c:forEach var="item" items="${codeBeanList}">
                                        <option value="${item.code}"  ${item.code eq entity.caseType ? "selected" : ""} >${item.codedesc}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="btn-primary" type="submit" data-icon="save"
                                data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">保存
                        </button>
                    </div>
                </form>
<div class="bjui-pageFooter" >
    <ul style="margin-right: 15px">
        <li>
            <button class="btn-close btn" type="button" data-icon="close">
                <i class="fa fa-close">取消</i>
            </button>
        </li>
       <%-- <li>
            <button class="btn-primary" type="submit" data-icon="save"
                    data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">保存
            </button>
        </li>--%>
    </ul>
</div>