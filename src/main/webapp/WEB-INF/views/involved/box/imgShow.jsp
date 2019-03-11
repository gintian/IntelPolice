<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<style>
    .cabinet {
        white-space: nowrap;
        margin: 0px auto;
        margin-bottom: 80px;
        overflow: auto;
        height: 500px;
    }

    .case {
        margin: auto;
        width: 300px;
        height: 600px;
        display: inline-block;
    }

    .lattice {
        width: 134px;
        height: 103px;
        background: url("${root}/resources/images/timg.jpg") no-repeat -2px -200px;
        float: left;
        position: relative;
    }

    .lattice-btn {
        width: 124px;
        height: 93px;
        background: rgba(255, 255, 255, 0.8);
        /* background:red;*/
        margin: 5px;
        position: relative;
        cursor: pointer;
    }

    .lattice-code {
        top: 10px;
        right: 10px;
        position: absolute;
        color: rgba(255, 255, 255, 1);
        border: 2px solid rgba(255, 255, 255, 1);
        text-align: center;
        width: 25px;
        border-radius: 50% / 50%;
    }

    .lattice-content {
        position: relative;
        text-align: center;
    }

    .lattice-content1 {
        display: none;
    }

    .btn-type1 {
        margin-top: 5px;
    }

    .lattice-boxCode{
        left: 0px;
        top: 30px;
        position:absolute;
        width: 100%;
    }
</style>
<div class="cabinet">
    <c:forEach items="${boxgroup}" varStatus="i">
        <div class='case'>
            <c:forEach items="${entityList}" var="entity" varStatus="j" begin="${i.index * fn:length(boxnum)}" end="${i.count * fn:length(boxnum) - 1}">
                <div class='lattice' title="编号：${empty entity.boxCode  ?  '无' : entity.boxCode}">
                    <div class='lattice-code' >${i.index * fn:length(boxnum) + j.count }</div>
                    <c:if test="${empty entity}" var="flag">
                        <div class='btn lattice-content lattice-btn' id='box-${ i.index * fn:length(boxnum) + j.count }' >
                            <div class="lattice-boxCode " ><p><c:out value="${fn:substring(entity.boxCode, 0, 11)}" /></p>
                                <p><c:out value="${fn:substring(entity.boxCode, 12, fn:length(entity.boxCode))}" /></p></div>
                            <div class='lattice-content1'>
                                <sys:permission url="<%=Url.getUrl(Url.INVOLVED_STORES_BOX_ADD_SHOW)%>">
                                    <a href='${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_ADD_SHOW)%>?storeId=${requestScope.involvedLocker.storeId}&lockerId=${requestScope.involvedLocker.id}&boxNo=${i.index * fn:length(boxnum) + j.count }' data-toggle='navtab' data-id='navtab' data-title='新增箱子' class='btn btn-warning btn-type1'>新增</a>
                                </sys:permission>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not flag}">
                        <div class='btn btn-primary lattice-content lattice-btn' id='box-${ i.index * fn:length(boxnum) + j.count }' style="background:rgba(255,255,255,0);" >
                            <div class="lattice-boxCode" >
                                <p><c:out value="${fn:substring(entity.boxCode, 0, 11)}" /></p>
                                <p><c:out value="${fn:substring(entity.boxCode, 12, fn:length(entity.boxCode))}" /></p>
                            </div>
                            <div class='lattice-content1'>
                                <c:if test="${state eq 0}" var="flag1">
                                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_STORES_BOX_DETAIL_SHOW)%>">
                                        <a href='${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_DETAIL_SHOW)%>?id=${entity.id}' data-toggle='dialog' data-mask='true' data-width='600' data-height='500' class='btn btn-info btn-type1'>查看</a><br>
                                    </sys:permission>
                                </c:if>
                                <c:if test="${not flag1 and isBoxUser[entity.boxNo] eq 1}">
                                    <sys:permission url="<%=Url.getUrl(Url.INVOLVED_STORES_BOX_DETAIL_SHOW)%>">
                                        <a href='${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_DETAIL_SHOW)%>?id=${entity.id}' data-toggle='dialog' data-mask='true' data-width='600' data-height='500' class='btn btn-info btn-type1'>查看</a><br>
                                    </sys:permission>
                                </c:if>
                                <sys:permission url="<%=Url.getUrl(Url.INVOLVED_STORES_BOX_UPDATE_SHOW)%>">
                                    <a href='${root}<%=Url.getUrl(Url.INVOLVED_STORES_BOX_UPDATE_SHOW)%>?id=${entity.id}' class='btn btn-default btn-type1' data-toggle='navtab' data-id='navtab' data-title='编辑'>编辑</a>
                                </sys:permission>
                            </div>
                        </div>
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>

<script>
    $(function(){
        $(".cabinet").parent().css("overflow","auto");
        $(".cabinet").on("mouseover",".case .lattice .lattice-content",function(){
            $(this).children(".lattice-content1").show();
            $(this).children(".lattice-boxCode").hide();
        });
        $(".cabinet").on("mouseout",".case .lattice .lattice-content",function(){
            $(this).children(".lattice-content1").hide();
            $(this).children(".lattice-boxCode").show();
        });
    });
</script>