<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.constant.Url" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path ;
    request.setAttribute("basePath", basePath);
    String current_account = request.getParameter("current_account");
    request.setAttribute("current_account", current_account);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>贵州公安智慧执法办案平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/themes/css/bootstrap.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/B-JUI.1.31/assets/ico/logo.png">
    <style type="text/css">
        * {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -ms-box-sizing: border-box;
            -o-box-sizing: border-box;
            box-sizing: border-box;
        }

        html {
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        #login_box{
            position: absolute;
            top: 55%;
            left: 49%;
            margin: -200px 0 0 -180px;
            padding: 15px 20px;
            width: 400px;
            height: 400px;
            min-width: 320px;
            background: #FAFAFA;
            background: rgba(255,255,255,0.1);
            box-shadow: 1px 5px 8px #888888;
            border-radius: 6px;}
        .line{margin-top: 10px;}
        #text_main{text-align: center;font-family: pictos;
            color: #113e53;font-size: 29px;}
        span{background-color: #638cce;}

        @font-face {
            font-family: pictos;
            src: url("${pageContext.request.contextPath }/B-JUI/themes/fonts/glyphicons-halflings-regular.ttf");
        }
        body{
            background: url("${pageContext.request.contextPath }/resources/images/new_back.png")no-repeat center center fixed;
            background-size: cover;
            -webkit-background-size: cover;/* 兼容Webkit内核浏览器如Chrome和Safari */
            -o-background-size: cover;/* 兼容Opera */
            zoom: 1;
        }
    </style>
    <script src="${pageContext.request.contextPath }/resources/index/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/customstatic/js/common/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/customstatic/js/common/commonUtil.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/customstatic/js/user/login.js"></script>

    <script type="text/javascript">
        if (navigator.appName == "Microsoft Internet Explorer" &&
                (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
                navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
                navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
        ) {
            alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
        }

    </script>
</head>
<body>
<script>
    //监听Enter键自动提交事件
    $(document).keyup(function(event){
        if(event.keyCode ==13){
            validte_login();
        }
    });
    $(function () {
        $("input").blur(function () {
            var val = $(this).val();
            if (CommonUtilValidate.isEmpty(val)){
                $(this).next().css("display", "block");
            }else {
                $(this).next().css("display", "none");
            }
        })

        $("input").focus(function(){
            $(this).next().css("display","none").fadeOut(2000);
            $("#showValidateMessage").html("");
        });
    })

    var errorcount = 0
    function validte_login() {
        if (!validataOnclickIsOverTime()){
            return;
        }
        var urlc = "${basePath}<%=Url.getUrl(Url.USER_LOGIN_VALIDATE)%>";
        var validateSuccessUrl = "${basePath}<%=Url.getUrl(Url.USER_LOGIN)%>";
        var jsonForm = $("#loginform").serializeJson();
        if (CommonUtilValidate.isEmpty(jsonForm.account)){
           $("#showAccountMessage").css("display", "block");
            return;
        }else {
            $("#showAccountMessage").css("display", "none");
        }
        if (CommonUtilValidate.isEmpty(jsonForm.password)){
            $("#showPasswordMessage").css("display", "block");
            return;
        }else {
            $("#showPasswordMessage").css("display", "none");
        }
        start();
        $.ajax({
            url: urlc,
            data: $("#loginform").serialize(),
            dataType: 'json',
            success: function (json) {
                if (!CommonUtilValidate.isEmpty(json)){
                    if (json.statusCode == 300){
                        //失败次数加一
                        errorcount ++;
                        var html = json.message;

                        //登录失败次数，大于5次，做延迟处理
                        if (errorcount > 5){
                            $("#showValidateMessage").html("操作过于频繁,10秒钟后再操作");
                            errorcount = 0;
                            $("button").css("display", "none");
                            setTimeout(function () {
                                $("#showValidateMessage").html("");
                                $("button").css("display", "block");
                            }, 10000);
                            clear();
                            return;
                        }else {
                            //提示显示
                            $("#showValidateMessage").html(html);
                        }
                    }else if (json.statusCode == 200){
                        window.location.href = validateSuccessUrl;

                    }else {
                        $("#showValidateMessage").html("系统维护中！");
                    }
                }
                setTimeout(function () {
                    clear();
                }, 300);
            }
        });
    }
</script>
<div class="container">

    <div class="row" id="login_div">
        <div class="center-block" id="login_box">
            <div id="text">
                <div id="text_main" class="col-md-offset-0">
                    <p>贵州公安智慧执法办案平台</p>
                </div>
            </div>
          <%--  <h2><font size="20px" style="width: 80px;" color="WHITE">贵州公安智慧执法办案平台</font></h2>--%>
            <form id="loginform" method="post">
                <div class="row" style="margin-top: 70px;">
                    <div class="line input-group col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-3">
                    <c:choose>
                        <c:when test="${current_account!=null}">
                            <label id="accountLabel"><font color="red"><h3>当前用户：${current_account}</h3></font></label>
                            <input type="hidden" name="already" value="1"/>
                            <input type="hidden" id="accountInput" name="account" placeholder="用户名" required="required" maxlength="30" value="${current_account}">
                            <span id="showAccountMessage" style="display: none;">用户名不能为空</span>
                        </c:when>
                        <c:otherwise>
                            <span style="background-color: #638cce;top:0;" class="glyphicon glyphicon-user input-group-addon" id="sizing-addon2"></span>
                            <input type="text" class="form-control" name="account" placeholder="用户名" required="required" maxlength="30" aria-describedby="sizing-addon2">
                            <span id="showAccountMessage" style="display: none;">用户名不能为空</span>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>

                <div class="row" style="margin-top: 40px;">
                    <div class="line input-group col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-3">
                        <span style="background-color: #638cce;top:0;" class="glyphicon glyphicon-lock input-group-addon" id="sizing-addon3"></span>
                        <input type="password" class="form-control" name="password" placeholder="密码" required="required" maxlength="30" aria-describedby="sizing-addon3">
                        <span id="showPasswordMessage" style="display: none;">密码不能为空</span>
                        <span id="showValidateMessage"></span>
                    </div>
                </div>
            </form>
              <div class="row" style="margin-top: 30px;">
                  <p>
                    <button class="btn btn-primary col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-3 col-xs-12" onclick="validte_login()">登录</button>
                  </p>
              </div>
            <div class="row">
                <div>
                    <canvas id="myCanvas" style="margin: auto; " width="400px" height="100">数据请求中</canvas>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>