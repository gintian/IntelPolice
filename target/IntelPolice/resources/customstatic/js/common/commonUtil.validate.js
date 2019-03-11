
var CommonUtilValidate = function() {
    return {
        //同isPassword
        isPassword : function(password) {
            if (/^[A-Za-z0-9]{6,15}$/.test(password)) {
                return true;
            }
            return "密码不正确，请输入6到15位数字或字母";
        },
        //同isMobile
        isPhone : function(phone) {
            if((/^((13[ 0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$/.test(phone))){
                return true;
            }
            return "手机号不正确";
        },
        isRegCode : function(regCode) {
            if(/^[0-9]{4}$/.test(regCode)) {
                return true;
            }
            return "我们的验证码是4位数字";
        },
        isUserName : function(userName) {
            if(/^[\u4e00-\u9fa5]+$/.test(userName)) {
                if(userName.length>5 || userName.length<2) {
                    return "中文姓名2到5个汉字";
                }
                return true;
            }
            if(/^[a-zA-Z]+$/.test(userName)) {
                if(userName.length > 7) {
                    return "英文姓名不能超过7个字母";
                }
                return true;
            }
            return "姓名不能为空，请输入姓名（全中文或全英文）";
        },
        isCourseCardId : function(cadId) {
            if((/^\d{15}$/.test(cadId))){
                return true;
            }
            return "我们的课程卡号是15位数字";
        },
        isEmpty : function(str) {
            if(str == null) {
                return true;
            }
            if(typeof(str) == "undefined") {
                return true;
            }
            if(str.length == 0) {
                return true;
            }
            if(str == ""){
                return true;
            }
            return false;;
        },
        isComment : function(comment) {
            if((comment.length-1)<0 || (comment.length-150)>0) {
                return "评论请输入1~150个字";
            }
            var unExistStr = "'<>&";    //不允许出现的字符,字符串的形式
            for(i=0; i<unExistStr.length; i++) {
                var unExistChar = unExistStr.charAt(i);
                if(comment.indexOf(unExistChar) > -1) {
                    return "不能输入:  " + unExistChar;
                }
            }
            return true;
        }
    }
}();