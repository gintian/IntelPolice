<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<script type="text/javascript">
j_login_changecode()

$('#j_login_captcha_img').click(function(){
    j_login_changecode()
})

function j_login_changecode(){
    $('#j_login_captcha_img').attr('src', 'login/getCaptcha?t='+ new Date())
}

function sys_login_submit() {
    var key      = CryptoJS.enc.Base64.parse($('#j_login_password_key').val())
    var iv       = CryptoJS.enc.Latin1.parse('0102030405060708')
    var password = CryptoJS.AES.encrypt($('#j_login_password').val(), key, {iv:iv, mode:CryptoJS.mode.CBC, padding:CryptoJS.pad.Pkcs7 })
    
    $('#j_login_password_hash').val(password)
    $('#j_login_form').submit()
    
    $('#j_login_captcha').val('')
    j_login_changecode()
}

$('#j_login_captcha').bind('keyup', function(event) {
    if (event.keyCode == 13) {
        sys_login_submit()
    }
})
</script>
<div class="bjui-pageContent">
    <form action="${root}<%=Url.getUrl(Url.USER_LOGIN)%>" data-toggle="validate" method="post" id="j_login_form" class="bjui-form col-1" data-close-current="true">
        <input type="hidden" id="j_login_password_key" name="">
        <input type="hidden" id="j_login_password_hash" name="password">
        <div class="bjui-row col-2">
            <label class="row-label">账号:</label>
            <div class="row-input required">
                <input type="text" data-rule="required" size="30" id="j_login_username" name="account" placeholder="身份证号、职工号">
            </div>
            <br>
            <label class="row-label">密码:</label>
            <div class="row-input required">
                <input type="password" data-rule="required" size="30" id="j_login_password" name="password" placeholder="密码">
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn btn-close" data-icon="remove">取消</button></li>
        <li><button type="button" class="btn btn-success" data-icon="check">登录</button></li>
    </ul>
</div>