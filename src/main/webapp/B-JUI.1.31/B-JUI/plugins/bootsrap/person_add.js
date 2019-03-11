var add = function(){
    var addForm = $("#book-form");
    var bootstrapValidator;
    var handlerReset = function () {
        $("button:contains('重置')").click(function(){
            addForm[0].reset();
            bootstrapValidator.resetForm();
        });
    }

    var handlerFileinput = function () {
        $("#files").fileinput({
            language: 'zh', //设置语言
            //uploadUrl:"http://127.0.0.1/testDemo/fileupload/upload.do", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            //uploadAsync: true, //默认异步上传
            showUpload:false, //是否显示上传按钮
            showRemove :true, //显示移除按钮
            showPreview :true, //是否显示预览
            showCaption:false,//是否显示标题
            browseClass:"btn btn-primary", //按钮样式    
            dropZoneEnabled: false,//是否显示拖拽区域
            minImageWidth: 50, //图片的最小宽度
            minImageHeight: 50,//图片的最小高度
            // maxImageWidth: 4000,//图片的最大宽度
            //maxImageHeight: 4000,//图片的最大高度
            maxFileSize:2048,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount:1, //表示允许同时上传的最大文件个数
            enctype:'multipart/form-data',
            validateInitialCount:true,
            initialPreview: pic,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        }).on("fileuploaded", function (event, data, previewId, index){
            bootstrapValidator
            //把createDate的验证状态更新为不验证
                .updateStatus("file", 'NOT_VALIDATED')
                //单独验证
                .validateField("file");
        });
    }
    var handlerData = function () {
        $(".form_datetime").datetimepicker({
            language:  'zh-CN',//设置语言
            format: 'yyyy-mm-dd',//设置时间格式
            weekStart: 0, //一周从哪一天开始
            minView: "month",//能选择的最小精度
            startView: 'decade',//初始显示的日期部分
            autoclose:true//选择完日期是否自动关闭日期控件
        })
            .on("hide", function(e) {
                bootstrapValidator
                //把createDate的验证状态更新为不验证
                    .updateStatus("createDate", 'NOT_VALIDATED')
                    //单独验证
                    .validateField("createDate");
            });
    }
    var handlerValidator = function () {
        $("#person_form").bootstrapValidator({
            //定制验证图标
            feedbackIcons: {
                valid: "glyphicon glyphicon-ok",//验证通过时的图标
                invalid: "glyphicon glyphicon-remove",//验证未通过时的图标
                validating: "glyphicon glyphicon-refresh"//刷新的图标
            },
            //定制验证规则
            fields:{
                name: {
                    message: "名称不能为空",//默认提示信息
                    validators:{
                        notEmpty:{
                            message: '名称必填不能为空'
                        },
                        StringLength:{
                            max:50,
                            message:'名称长度不能超过%s字'
                        }
                    }
                },
                bxwrPhone:{
                    validators:{
                        notEmpty:{
                            message:'联系电话不能为空'
                        },
                        stringLength:{
                            min:11,
                            max:11,
                            message:'长度为11个数字'
                        }
                    }
                },
                idcard:{
                    validators : {
                        notEmpty : {
                            message : '身份证号码不能为空！'
                        },
                        regexp: {
                            regexp: /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/,
                            message: '身份证号码格式不正确，为15位和18位身份证号码！'
                        },
                        callback: {/*自定义，可以在这里与其他输入项联动校验*/
                            message: '身份证号码无效！',
                            callback:function(value, validator,$field){
                                //15位和18位身份证号码的正则表达式
                                var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
                                //如果通过该验证，说明身份证格式正确，但准确性还需计算
                                var idCard = value;
                                if (regIdCard.test(idCard)) {
                                    if (idCard.length == 18) {
                                        var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
                                        var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
                                        var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
                                        for (var i = 0; i < 17; i++) {
                                            idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
                                        }
                                        var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
                                        var idCardLast = idCard.substring(17);//得到最后一位身份证号码
                                        //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
                                        if (idCardMod == 2) {
                                            if (idCardLast == "X" || idCardLast == "x") {
                                                return true;
                                                //alert("恭喜通过验证啦！");
                                            } else {
                                                return false;
                                                //alert("身份证号码错误！");
                                            }
                                        } else {
                                            //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                                            if (idCardLast == idCardY[idCardMod]) {
                                                //alert("恭喜通过验证啦！");
                                                return true;
                                            } else {
                                                return false;
                                                //alert("身份证号码错误！");
                                            }
                                        }
                                    }
                                } else {
                                    //alert("身份证格式不正确!");
                                    return false;
                                }
                            }
                        }
                    }
                },
                bxwrAddr:{
                    validators:{
                        notEmpty:{
                            message:'地址不能为空'
                        },
                        stringLength:{
                            max:50,
                            message:'地址长度不能超过%s个字符'
                        }
                    }
                },
                file:{
                    validators:{
                        notEmpty:{
                            message:'照片不能为空'
                        }
                    }
                }
            }
        });
        bootstrapValidator = addForm.data("bootstrapValidator");
    }
    return {
        init: function(){
            handlerFileinput();
            handlerData();
            handlerValidator();
            handlerReset();
        }
    }
}();
var pic;
function getPic(pic1) {
    pic = pic1;
}
$(function(){
    add.init();
});
