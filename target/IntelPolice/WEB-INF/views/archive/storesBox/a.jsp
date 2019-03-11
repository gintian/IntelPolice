<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <style>
        .cabinet{white-space:nowrap}
        .case{
            margin:auto;
            width: 300px;
            height: 600px;
            display:inline-block;
        }
        .lattice{
            width: 134px;
            height: 103px;
            background:url("timg.jpg") no-repeat -2px -200px;
            float: left;
        }
        .lattice-btn{
            width: 124px;
            height: 93px;
            background:rgba(255,255,255,0.8);
           /* background:red;*/
            margin: 5px;
            position: relative;
            cursor: pointer;
        }
        .lattice-code{
            top:10px;
            right:10px;
            position:absolute;
            color: rgba(255,255,255,0.8);
            border: 2px solid rgba(255,255,255,0.8);
            text-align: center;
            width: 25px;
            border-radius: 50% / 50%;
        }
        .d{
            display: none;
            position: fixed;
            left: 0px;
            top:0px;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.4);
        }
        .e{
            position:relative;
            margin: 50px auto;
            height: 300px;
            width: 450px;
            padding: 10px;
            background: rgba(255,255,255,1);
            border-radius: 5px;
        }
        .x{
            position: absolute;
            top:10px;
            right: 10px;
            border: 1px solid #000;
            height: 20px;
            width: 20px;
            text-align: center;
            cursor: pointer;
            border-radius: 3px;
        }
        .x:hover{
            color: darkorange;
            border: 1px solid darkorange;
        }
        .title{
            text-align: center;
        }
        .clear{clear: both ; }
        ul{padding: 0}
        ul li {text-align: center;list-style-type: none;height: 70px;}
        .btnBox{
            width: 80px;
            height: 40px;
            color: #fff;
            background: darkorange;
            border: 1px solid rgba(0,0,0,0.3);
            border-radius: 3px;
        }
    </style>
    <body>
        <div>
            <input type="text" class="inp" placeholder="输入格子数">
            <button class="btn1">提交</button>
        </div>
        <div class="cabinet">
            <!--<div class="b">
                <button class="c">
                    01
                </button>
            </div>-->
        </div>
        <!--提示栏-->
        <div class="d">
            <div class="e">
                <div>
                    <div class="title"><span class="title1"></span></div>
                    <div class="x">X</div>
                </div>
                <hr>
                <ul>
                    <li>
                        <button class="btnBox">打开</button>
                    </li>
                    <li>
                        <button class="btnBox">编辑</button>
                    </li>
                    <li>
                        <button class="btnBox">查看</button>
                    </li>
                    <li>
                        <button class="btnBox qx">取消</button>
                    </li>
                </ul>
            </div>
        </div>
        <script src="jquery-1.11.2.js" rel="stylesheet"></script>
        <script>
            $(function(){
                $(".btn1").click(function(){
                    var total = $(".inp").val();
                    var group = 0;
                    var content = "";
                    var count = 2;
                        group = Math.ceil(total / (2 * 6));
                    for(var i = 1; i<= group; i++){
                        var count1= total - i*count * 6 <= 0 ? total :i*count * 6;
                        var j = (i - 1)*count * 6 + 1;
                        content += "<div class='case'>";
                        for(; j<= count1 ; j++ ){
                            content += "<div class='lattice' >" +
                                    "<button class='lattice-btn' id='box-"  + j +  "'>" +
                                    "<div class='lattice-code' >" + j +"</div>"+
                                    "<div class='lattice-content' >" + "空" +"</div>"+
                                    "</button></div>";

                        }
                        content +="</div>";
                    }

                    $(".cabinet").html(content);
                    a();
                });
                var json = [{"id":1,"code":12312},{"id":7,"code":"as1231"},{"id":4,"code":"zxcqw123"}];

                function a(){
                    $.each(json, function(idx, obj) {
                       var _this =  $("#box-"+ obj.id);
                        _this.css( {"background":"rgba(255,255,255,0)"});
                        _this.children(".lattice-content").html("编号："+obj.code);
                    });
                }
                $(".cabinet").on("click",".lattice .lattice-btn", function(){
                    $(".title1").html($(this).children(".lattice-code").html());
                    $(".d").show();
                });
                $(".x").click(function(){
                    $(".d").hide();
                });
                $('.qx').click(function(){
                    $(".d").hide();
                });
            });
        </script>
    </body>
</html>