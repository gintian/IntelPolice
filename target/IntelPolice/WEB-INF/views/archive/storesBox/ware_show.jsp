<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
            <div class="bjui-pageContent">
                <form action="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_WARE_SUBMIT)%>"
                      data-toggle="validate" data-reload-navtab="true" method="post" data-alertmsg="false">
                    <input type="hidden" value="${caseid}" name="caseId">
                    <input type="hidden" value="${archiveid}" name="archiveId">
                    <input type="hidden" value="" name="boxId" id="boxId">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>操作</th>
                                <th>仓库名称</th>
                                <th>柜名称</th>
                                <th>箱号</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty list}" var="flag">
                            <tr>
                                <td colspan="4" style="color: #c9302c;text-align: center">未分配箱子，请联系管理员！</td>
                            </tr>
                        </c:if>
                        <c:if test="${not flag}">
                            <c:forEach items="${list}" var="box" varStatus="i">
                                <tr>
                                    <td>
                                        <c:if test="${empty box.archiveCaseBeanList}" var="isCase">
                                            <button class="btn-primary btn_ware" type="submit" data-icon="save"
                                                    data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">入库
                                                <input type="hidden" class="boxId" value="${box.id}">
                                            </button>
                                        </c:if>
                                        <c:if test="${not isCase}">
                                            <c:forEach items="${box.archiveCaseBeanList}" var="archiveCaseBean" varStatus="j">
                                                <c:if test="${archiveCaseBean.archiveId eq archiveid}">
                                                    <c:set var="flag1" value="true" />
                                                    <button class="btn-default" type="button">已入此箱</button>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${flag1 ne 'true'}">
                                                <button class="btn-primary btn_ware" type="submit" data-icon="save"
                                                        data-target="menu01090202" onclick="BJUI.navtab('refresh', 'menu01090202')">入库
                                                    <input type="hidden" class="boxId" value="${box.id}">
                                                </button>
                                            </c:if>
                                        </c:if>
                                    </td>
                                    <td>
                                        <hs:archiveStoresByLockersId value='${box.archiveStoresId}'/>
                                    </td>
                                    <td>
                                        <hs:archiveStoresLockers value='${box.archiveStoresId}'/>
                                    </td>
                                    <td>
                                            ${box.code}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </form>
            </div>
            <div class="bjui-pageFooter">
                <ul>
                    <li>
                        <button class="btn-close btn" type="button" data-icon="close">
                            <i class="fa fa-close">取消</i>
                        </button>
                    </li>
                </ul>
            </div>
<script>
    $(function(){
        $(".btn_ware").click(function(){
            $("#boxId").val($(this).children(".boxId").val());
        });
    });

</script>