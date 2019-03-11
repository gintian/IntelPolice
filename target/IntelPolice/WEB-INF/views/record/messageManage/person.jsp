<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
     <c:if test="${status eq '0'}">
            <c:set var="newName" value="讯问" />
        </c:if>
        <c:if test="${status eq '1'}">
            <c:set var="newName" value="询问" />
        </c:if>
        <c:if test="${status eq '2'}">
            <c:set var="newName" value="辨认" />
        </c:if>
        <div style="width: 100%; padding: 20px 10%">
            <div class="panel panel-default">
                <c:if test="${status eq '0'}">
                    <form id="form_person" data-toggle="ajaxform"    method="post" data-alertmsg="false"
                          data-options="{url: '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>',validate: true,loadingmask: true,confirmMsg:'是否提交数据',okalert:false,forward:'${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'}">
                        <input name="status" value="0" type="hidden">
                </c:if>
                <c:if test="${status eq '1'}">
                    <form id="form_person" method="post" data-toggle="ajaxform" data-alertmsg="false"
                          data-options="{url: '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>',validate: true,loadingmask: true,confirmMsg:'是否提交数据',okalert:false,forward:'${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'}">
                        <input name="status" value="1" type="hidden">
                </c:if>
                 <c:if test="${status eq '2'}">
                    <form id="form_person" data-toggle="ajaxform"  method="post" data-alertmsg="false"
                          data-options="{url: '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>',validate: true,loadingmask: true,confirmMsg:'是否提交数据',okalert:false,forward:'${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'}">>
                        >
                        <input name="status" value="2" type="hidden">
                 </c:if>
                        <input type="hidden" name="caseIdPerson1" value="${caseIdPerson}">
                            <ul class="list-group" style="margin-bottom: 0px">
                                <li class="list-group-item">
                                    <label class="row-label" for="userTree_userId">${newName}人<span
                                            class="required">*</span>：</label>
                                    <input  id="userTree_userName" readonly
                                            data-rule="required" value="<hs:user value='${bpipUser.userId}'/>"
                                            type="text">

                                    <input name="userId" id="userTree_userId"
                                           value="${bpipUser.userId}" type="hidden">
                                    <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search"
                                       class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                                       data-title="查询"></a>
                                </li>
                                <li class="list-group-item">
                                    <label class="row-label" for="userTree_userId">笔录人<span  class="required">*</span>：</label>
                                    <div class="row-input required">
                                        <input  id="userTree_userName1" readonly data-rule="required" value="<hs:user value='${entity.id}'/>"  type="text">
                                        <input name="userId1" id="userTree_userId1" value="${entity.id}" type="hidden">
                                        <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW1)%>" data-icon="search"   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                                    </div>
                                   </li>
                                <li class="list-group-item">
                                    <label class="row-label" for="userTree_userId">被${newName}人<span  class="required">*</span>：</label>
                                    <div class="row-input required">
                                        <input  id="ecordPerson_name" readonly data-rule="required" value=""  type="text">
                                        <input name="personId" id="recordPerson_personId" value="" type="hidden">
                                        <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_TREE_SHOW)%>" data-icon="search"   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                                    </div>
                                  </li>
                            </ul>
                        <div class="bjui-pageFooter navbar-fixed-bottom">
                            <ul>
                                <li>
                                    <button class="btn-close btn" type="button" data-icon="close">
                                        <i class="fa fa-close">取消</i>
                                    </button>
                                </li>
                                <li>
                                    <button class="btn btn-success" type="submit" data-icon="save"
                                          <%--data-target="menu01090101" onclick="BJUI.navtab('refresh', 'menu01090101')"--%>>提交
                                    </button>
                                </li>
                            </ul>
                        </div>
                    </form>
                    </div>
        </div>
<script>
    /*$(function(){
        $("#form_person").submit(function(){
            BJUI.ajax('ajaxform', {
                /!*url:
                    <%--<c:if test="${status eq '0'}">
                        '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>'
                    </c:if>
                    <c:if test="${status eq '1'}">
                        '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>'
                    </c:if>
                    <c:if test="${status eq '2'}">
                        '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>'
                    </c:if>--%>
                ,*!/
                form: $.CurrentNavtab.find('#form_person'),
                validate: true,
                loadingmask: true,
                confirmMsg:'是否提交数据',
                okalert:false,//请求正常返回后，是否弹出相应的信息提示。
                forward:
                    <c:if test="${status eq '0'}">
                        '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'
                    </c:if>
                    <c:if test="${status eq '1'}">
                        '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'
                    </c:if>
                    <c:if test="${status eq '2'}">
                        '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'
                    </c:if>
            })
        });
    })*/
</script>