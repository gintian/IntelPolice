<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.model.Dept" %>
<%@ page import="com.utils.DateUtils" %>
<%
    // 权限验证
    if (session.getAttribute(SessionKey.USER) == null) {
        response.sendRedirect("login.jsp");
        return;
    } else {
        request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
        request.setAttribute("currentDept", (Dept) session.getAttribute(SessionKey.DEPT));
        request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
    }
%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "No-cache");
    response.setDateHeader("Expires", -1);
    response.setHeader("Cache-Control", "No-store");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>执法智慧化管理平台</title>
    <%@include file="/WEB-INF/views/common_prefix.jsp" %>
    <%@include file="/WEB-INF/views/common_bjui.jsp" %>
    <!-- init -->
    <script type="text/javascript">

        $(function () {
            BJUI.init({
                JSPATH: '${root}/B-JUI.1.31/B-JUI/',         //[可选]框架路径
                PLUGINPATH: '${root}/B-JUI.1.31/B-JUI/plugins/', //[可选]插件路径
                loginInfo: {
                    url: '${root}<%=Url.getUrl(Url.USER_LOGIN_TIMEOUT_SHOW)%>',
                    title: '登录',
                    width: 440,
                    height: 240
                }, // 会话超时后弹出登录对话框
                statusCode: {ok: 200, error: 300, timeout: 301}, //[可选]
                ajaxTimeout: 300000, //[可选]全局Ajax请求超时时间(毫秒)
                alertTimeout: 3000,  //[可选]信息提示[info/correct]自动关闭延时(毫秒)
                pageInfo: {
                    total: 'totalRow',
                    pageCurrent: 'pageCurrent',
                    pageSize: 'pageSize',
                    orderField: 'orderField',
                    orderDirection: 'orderDirection'
                }, //[可选]分页参数
                keys: {statusCode: 'statusCode', message: 'message'}, //[可选]
                ui: {
                    sidenavWidth: 220,
                    showSlidebar: true, //[可选]左侧导航栏锁定/隐藏
                    overwriteHomeTab: false //[可选]当打开一个未定义id的navtab时，是否可以覆盖主navtab(我的主页)
                },
                debug: true,    // [可选]调试模式 [true|false，默认false]
                theme: 'green' // 若有Cookie['bjui_theme'],优先选择Cookie['bjui_theme']。皮肤[五种皮肤:default, orange, purple, blue, red, green]
            })
            //时钟
            var today = new Date(), time = today.getTime()
            $('#bjui-date').html(today.formatDate('yyyy/MM/dd'))
            setInterval(function () {
                today = new Date(today.setSeconds(today.getSeconds() + 1))
                $('#bjui-clock').html(today.formatDate('HH:mm:ss'))
            }, 1000)
        });

        //菜单-事件-zTree
        function MainMenuClick(event, treeId, treeNode) {
            debugger;
            if (treeNode.target && treeNode.target == 'dialog' || treeNode.target == 'navtab')
                event.preventDefault()
            if (treeNode.isParent) {
                var zTree = $.fn.zTree.getZTreeObj(treeId)
                zTree.expandNode(treeNode)
                return
            }
            if (treeNode.target && treeNode.target == 'dialog')
                $(event.target).dialog({id: treeNode.targetid, url: treeNode.url, title: treeNode.name})
            else if (treeNode.target && treeNode.target == 'navtab')
                $(event.target).navtab({
                    id: treeNode.targetid,
                    url: treeNode.url,
                    title: treeNode.name,
                    fresh: treeNode.fresh,
                    external: treeNode.external
                })
        }

        // 满屏开关
        var bjui_index_container = 'container_fluid'

        function bjui_index_exchange() {
            bjui_index_container = bjui_index_container == 'container_fluid' ? 'container' : 'container_fluid'
            $('#bjui-top').find('> div').attr('class', bjui_index_container)
            $('#bjui-navbar').find('> div').attr('class', bjui_index_container)
            $('#bjui-body-box').find('> div').attr('class', bjui_index_container)
        }
       $(document).ready(function () {
          $('.bjui-pageContent .pageFormContent table').attr('class','table');
       });
        ; (function ($) {
            $.extend({
                'nicenav': function (con) {
                    con = typeof con === 'number' ? con : 400;
                    var $lis = $('#nav>li'), $h = $('#buoy')
                    $lis.hover(function () {
                        $h.stop().animate({
                            'left': $(this).offsetParent().context.offsetLeft
                        }, con);
                    }, function () {
                        $h.stop().animate({
                            'left': '-157px'
                        }, con);
                    })
                }
            });
        }(jQuery));
    </script>

</head>
<script>
    $(document).ready(function () {
        setTimeout(function () {
            pop_init("提示", "<ul><li>欢迎您，<font style=\"color:blue\">${currentUser.name}</font></li><li><a id=\"open\" href=\"${root}<%=Url.getUrl(Url.MESSAGE_INDEX_SHOW)%>\" data-toggle=\"dialog\" data-mask=\"true\" data-id=\"viewMessage\"data-width=\"600\" data-height=\"300\"data-title=\"待办事项\">您有${messageNum}条未读消息</a></li><li>登陆时间：${currentTime}</li></ul>");
            $('#pop_div').fadeIn(400);
        }, 1500);
        setTimeout(function () {
            $('#pop_div').fadeOut(400);
        }, 5000)
    });

</script>
<style>

    .tc{text-align:center;}
    #navs{display: none;z-index:3;position:fixed;right:4px;width:80px;height:80px;line-height:80px;list-style-type:none;margin:0;padding:0;text-align:center;color:#fff;cursor:pointer;}
    #navs>li,#navs:after{position:absolute;left:0;top:0;width:100%;height:100%;border-radius:50%;-webkit-border-radius:50%;background-color:#4ECDC4;}
    #navs>li{transition:all .6s;-webkit-transition:all .6s;-moz-transition:.6s;}
    #navs:after{content:attr(data-close);z-index:1;border-radius:50%;-webkit-border-radius:50%;}
    #navs.active:after{content:attr(data-open);}
    #navs a{width:80px;height:40px;display:inline-block;border-radius:50%;-webkit-border-radius:50%;text-decoration:none;color:#fff;font-size:0.8em;}
    @media (max-width: 1200px) {
        .ribbon{display: none;}
        #navs{display: block;}
    }
</style>
<body>
<!--[if lte IE 7]>
<div id="errorie">
    <div>您还在使用老掉牙的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank"
                                                 href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a
            href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div>
</div>
<![endif]-->
<header id="bjui-navbar">
    <div class="container_fluid">
        <div class="navbar-header">
            <a class="navbar-logo">
                <img src="${root}/resources/images/logo.gif" height="66">
            </a>
            <span>公安机关执法智慧化管理平台</span>
        </div>
                <%--<nav class="collapse navbar-collapse" id="bjui-top-collapse">--%>
        <div id="btn_change_leftAndRight">
            <a href="#" class="btn_change" id="prev"><img src="${pageContext.request.contextPath}/B-JUI.1.31/images/prev.png" alt=""></a>
            <a href="#" class="btn_change" id="next"><img src="${pageContext.request.contextPath}/B-JUI.1.31/images/next.png" alt=""></a>
        </div>
                    <div id="top_menu" class="">
                        <div id="top_menu_div">
                            <ul>

                            </ul>
                            <script>
                                $(function () {
                                    join();
                                    mouse_hover($('.btn_change'));
                                    x();
                                });

                                function join() {
                                    var li = $('#top_menu #top_menu_div li');

                                    $.ajax({
                                        url:'${root}<%=Url.getUrl(Url.MENU_ALL_LIST)%>',
                                        type:'GET',
                                        dataType:'json',
                                        success: function (data){
                                            var html = '';
                                            $.each(data,function (i,j) {
                                                html += '<li class="btn_li">';
                                                html += '<span>';
                                                html += '<img src="${pageContext.request.contextPath}/B-JUI.1.31/images/system_'+i+'.png">';
                                                html += '</span>';
                                                html += '<p>'+j.name+'</P>';
                                                html += '</li>';
                                            });
                                            $('#top_menu #top_menu_div ul').append(html);
                                            $('#top_menu #top_menu_div li').on('mouseover',function () {
                                                $(this).css({'cursor':'pointer','transform':'scale(1.2)'});
                                            }).on('mouseout',function () {
                                                $(this).css('transform','scale(1.0)');
                                            });
                                            var leng = $('#top_menu li');
                                            var wid = leng.width();//单个li的宽度
                                            var div = $('#top_menu').width();//获取li所在区域宽度
                                            var mus = parseInt(div/wid); //计算出需要显示的子元素的数量
                                            var length = leng.length-mus;//计算子元素可移动次数（被隐藏的子元素数量）
                                            var i = 0;
                                            $('#next').click(function () {
                                                i++;//点击i加1
                                                if(i<length){
                                                    $("#top_menu_div").animate({left:-(wid*i)});
                                                    //子元素集合向左移动，距离为子元素的宽度乘以i。
                                                }else{
                                                    i=length;
                                                    $("#top_menu_div").animate({left:-(wid*length)});
                                                    //超出可移动范围后点击不再移动。最后几个隐藏的元素显示时i数值固定位已经移走的子元素数量。
                                                }
                                            });
                                            $("#prev").click(function(){
                                                i--;
                                                //点击i减1
                                                if(i>=0){
                                                    $("#top_menu_div").animate({left:-(wid*i)});
                                                    //子元素集合向右移动，距离为子元素的宽度乘以i。
                                                }else{
                                                    i=0;
                                                    $("#top_menu_div").animate({left:0});
                                                    //超出可移动范围后点击不再移动。最前几个子元素被显示时i为0。
                                                }
                                            });

                                            $('#top_menu>#top_menu_div li').each(function () {
                                                var s = $(this).index();
                                                $(this).on('click',function () {
                                                    var btn = $(this).index();
                                                    var _li = $('<li></li>');
                                                    var _a = $('<a class="right-arrow">' +
                                                        '<i class="fa fa-caret-right"></i>' +
                                                        '</a>');
                                                    var _b = $('<b><i class="fa fa-angle-right"></i></b>');
                                                    var html = '';
                                                    var ul = $('<ul>');
                                                    $.each(data[btn].children,function (i,j) {
                                                        html += '<li>';
                                                        html += '<span class="close_menu">';
                                                        html += 'x';
                                                        html += '</span>';
                                                        html += '<a href="javascript:;">';
                                                        html += j.name;
                                                        html += '<img src="B-JUI.1.31/images/off.png">';
                                                        html += '</a>';
                                                        html += '</li>';
                                                    });
                                                    $('#tree').append(html);
                                                    $('#tree>li>a').on('click',function (){
                                                        var name = $(this).text();
                                                        var join_li = '';
                                                        $.each(data[btn].children,function (i,j) {
                                                            if(name === j.name){
                                                                $.each(data[btn].children[i].children,function (i,j) {
                                                                    join_li += '<li class="'+j.target+'-'+j.id+'">';
                                                                    join_li += '<a href="'+j.url+'" ' +
                                                                        'data-toggle="'+j.target+'" ' +
                                                                        'data-options="{'+'id'+':'+"'"+j.id+"'"+','+'title'+':'+"'"+j.name+"'"+'}">';
                                                                    join_li += j.name;
                                                                    join_li += '</a>';
                                                                    join_li += '</li>';
                                                                    console.log(j)
                                                                });
                                                            }
                                                        });
                                                        var ul_length = $(this).next('ul').length;
                                                        if(ul_length === 0){
                                                            $(this).parent('li').append('<ul>');
                                                            $(this).next('ul').wrapInner(join_li);
                                                            $(this).next('ul').css('padding-left','0');
                                                            $(this).next('ul').show();
                                                        }
                                                    });

                                                });
                                            });
                                        }
                                    }) ;
                                }
                                function x(){
                                    $('#tree').on('click','a',function () {
                                        // if(typeof ($(this).next('ul').attr('display') === 'undefined')){
                                        //     $(this).next('ul').removeAttr('display');
                                        // }else{
                                            // $(this).next('ul').attr('display','none');
                                            // $(this).next('ul').toggle();
                                        // }
                                        // console.log(typeof ($(this).next('ul').attr('display')))
                                        $(this).next('ul').toggle();
                                    });
                                    $('#tree').on('click','.close_menu',function () {
                                        $(this).parent('li').remove();
                                    });
                                }
                                // $('#tree li').on('click','a',function () {
                                //     if($(this).next('ul').hasClass('add_ul')){
                                //         $(this).next('ul').addClass('add_ul_hide').removeClass('add_ul');
                                //     }else{
                                //         $(this).next('ul').addClass('add_ul').removeClass('add_ul_hide');
                                //     }
                                // });
                                function  mouse_hover(change) {
                                    change.mouseover(function () {
                                        $(this).css('opacity','1');
                                    }).mouseout(function () {
                                        $(this).css('opacity','0.4');
                                    });
                                }
                            </script>
                        </div>
                    </div>
                    <ul class="nav navbar-nav navbar-right ribbon">

                                <%--&lt;%&ndash;<li class="dropdown">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<a href="#" class="dropdown-toggle bjui-fonts-tit" data-toggle="dropdown" title="更改字号">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<i class="fa fa-font"></i>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<h5>大</h5>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<ul class="dropdown-menu" role="menu" id="bjui-fonts">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" class="bjui-font-a" data-toggle="fonts"><i class="fa fa-font"></i> 特大</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" class="bjui-font-b" data-toggle="fonts"><i class="fa fa-font"></i> 大</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" class="bjui-font-c" data-toggle="fonts"><i class="fa fa-font"></i> 中</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" class="bjui-font-d" data-toggle="fonts"><i class="fa fa-font"></i> 小</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li class="dropdown active"><a href="#" class="dropdown-toggle theme" data-toggle="dropdown" title="切换皮肤"><i class="fa fa-tree"></i></a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<ul class="dropdown-menu" role="menu" id="bjui-themes">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<!--                             <li><a href="javascript:;" class="theme_default" data-toggle="theme" data-theme="default">&nbsp;<i class="fa fa-tree"></i> 黑白分明&nbsp;&nbsp;</a></li> -->&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<!--                             <li><a href="javascript:;" class="theme_orange" data-toggle="theme" data-theme="orange">&nbsp;<i class="fa fa-tree"></i> 橘子红了</a></li> -->&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" class="theme_purple" data-toggle="theme" data-theme="purple">&nbsp;<i class="fa fa-tree"></i> 紫罗兰</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li class="active"><a href="javascript:;" class="theme_blue" data-toggle="theme" data-theme="blue">&nbsp;<i class="fa fa-tree"></i> 天空蓝</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" class="theme_green" data-toggle="theme" data-theme="green">&nbsp;<i class="fa fa-tree"></i> 绿草如茵</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                        <%--<li>--%>
                                <%--<a href="${root}/login.jsp?current_account=${currentUser.account}">--%>
                               <%--<span><i class="Hui-iconfont">&#xe60e;</i>--%>
                                    <%--锁定屏幕</span>--%>
                                <%--</a>--%>
                                <%--&lt;%&ndash;<li><a href="javascript:;" onclick="bjui_index_exchange()" title="横向收缩/充满屏幕"><i class="fa fa-exchange"></i></a></li>&ndash;%&gt;--%>
                        <%--</li>--%>
                    </ul>
                        <%--                     <li class="dropdown"><a  href="#" class="dropdown-toggle bjui-fonts-tit" data-toggle="dropdown" title="个人信息及修改">${currentUser.userName}</a> --%>
                        <!--                    		 <ul class="dropdown-menu" role="menu" id="bjui-person"> -->
                        <!-- 							个人信息和修改密码 -->
                        <!-- 							<li><a href="javascript:;" class="btn-blue" data-toggle="dialog" onclick="read();"> 个人信息</a></li> -->
                        <!--                             <li><a href="javascript:;" class="btn-orange" data-toggle="dialog" onclick="change();"> 修改密码</a></li> -->
                        <!-- 						</ul> -->
                        <!-- 					</li> -->
                    <%-- 缩小页面的菜单栏 start --%>
                    <%--<ul id="navs" data-open="收起" data-close="展开">--%>
                        <%--<li>--%>
                            <%--<a href="${root}<%=Url.getUrl(Url.USER_DETAIL_SHOW)%>?id=${currentUser.id}"--%>
                               <%--data-toggle="dialog" data-mask="true" data-width="600"--%>
                               <%--data-height="500"/>${currentUser.name}--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="${root}<%=Url.getUrl(Url.DEPT_DETAIL_SHOW)%>?id=${currentDept.id}"--%>
                               <%--data-toggle="dialog" data-mask="true" data-width="600"--%>
                               <%--data-height="500"/>${currentDept.name}--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="${root}/resources/html/jsc.jsp">驾驶舱</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<sys:permission url="<%=Url.getUrl(Url.USER_PASSWORD_CHANGE_SHOW)%>">--%>
                                <%--<a href="${root}<%=Url.getUrl(Url.USER_PASSWORD_CHANGE_SHOW)%>" data-toggle="dialog"--%>
                                   <%--data-id="sys_user_changepass" data-mask="true" data-width="400" data-height="300">--%>
                                        <%--修改密码--%>
                                <%--</a>--%>
                            <%--</sys:permission>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#"--%>
                               <%--onclick="window.confirm('确定注销吗？')?this.href='${root}<%=Url.getUrl(Url.USER_LOGOUT)%>':this.href='javascript:void(0)';">--%>
                                <%--注销登陆--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="${root}/login.jsp?current_account=${currentUser.account}">--%>
                                    <%--锁定屏幕--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<script>--%>
                        <%--(function(){--%>
                            <%--var ul=$("#navs"),li=$("#navs li"),i=li.length,n=i-1,r=240,y = 80;--%>
                            <%--ul.click(function(){--%>
                                <%--$(this).toggleClass('active');--%>
                                <%--if($(this).hasClass('active')){--%>
                                    <%--for(var a=0;a<i;a++){--%>
                                        <%--li.eq(a).css({--%>
                                            <%--'transition-delay':""+(50*a)+"ms",--%>
                                            <%--'-webkit-transition-delay':""+(50*a)+"ms",--%>
                                            <%--'-o-transition-delay':""+(50*a)+"ms",--%>
                                            <%--'transform':"translate("+(-r*Math.cos(90/n*0*(Math.PI/90)))+"px,"+(y*a)+"px",--%>
                                            <%--'-webkit-transform':"translate("+(-r*Math.cos(90/n*0*(Math.PI/90)))+"px,"+(y*a)+"px",--%>
                                            <%--'-o-transform':"translate("+(-r*Math.cos(90/n*0*(Math.PI/90)))+"px,"+(y*a)+"px",--%>
                                            <%--'-ms-transform':"translate("+(-r*Math.cos(90/n*0*(Math.PI/90)))+"px,"+(y*a)+"px"--%>
                                        <%--});--%>
                                    <%--}--%>
                                <%--}else{--%>
                                    <%--li.removeAttr('style');--%>
                                <%--}--%>
                            <%--});--%>
                        <%--})($);--%>
                    <%--</script>--%>
                    <%-- 缩小页面的菜单栏 end --%>
                <%--</nav>--%>
        </div>

</header>
<div id="bjui-body-box">
    <div class="container_fluid" id="bjui-body">
        <div id="bjui-sidenav-col">
            <div id="bjui-sidenav">
                <div id="bjui-sidenav-arrow" data-toggle="tooltip" data-placement="left" data-title="隐藏左侧菜单">
                    <i class="fa fa-long-arrow-left"></i>
                </div>
                <div class="toggleCollapse">
                    <h4 class="text-center" style="text-align: left;"><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h4>
                </div>

                <div id="bjui-sidenav-box" class="list">
                    <%--<nav class="collapse navbar-collapse" id="bjui-navbar-collapse">--%>
                        <%--<ul class="nav navbar-nav navbar-right" id="bjui-hnav-navbar">--%>
                            <%--<li class="active">--%>
                                <%--<a href="${root}<%=Url.getUrl(Url.MENU_ALL_LIST)%>" data-toggle="sidenav"--%>
                                   <%--data-id-key="targetid"></a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                        <ul id="tree">

                        </ul>
                    <%--</nav>--%>
                </div>
            </div>
        </div>
        <div id="bjui-navtab" class="tabsPage">
            <div id="bjui-sidenav-btn" data-toggle="tooltip" data-title="显示左侧菜单" data-placement="right">
                <i class="fa fa-bars"></i>
            </div>
            <script type="text/javascript">
                $('#bjui-sidenav-btn').mouseover(function () {
                    $(this).css('left','0px');
                }).mouseout(function () {
                    $(this).css('left','-24px');
                });
                // $('#bjui-sidenav-btn').click(function () {
                //     $(this).css('left','-24px');
                // });
            </script>
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent">
                    <ul class="navtab-tab nav nav-tabs">
                        <li><a href="javascript:;"><span><i class="fa fa-home"></i> #maintab#</span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft"><i class="fa fa-angle-double-left"></i></div>
                <div class="tabsRight"><i class="fa fa-angle-double-right"></i></div>
                <div class="tabsMore"><i class="fa fa-angle-double-down"></i></div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">#maintab#</a></li>
            </ul>
            <div class="navtab-panel tabsPageContent">
                <div class="navtabPage unitBox">
                    <div class="bjui-pageContent">
                        <%--<div style="width: 50%;float: left;height: 100%;padding-right: 15px">--%>
                            <%--<div class="col-md-12" style="height: 100%;padding: 0;">--%>
                                <%--<div class="panel panel-default" style="height: 97%;overflow: auto;">--%>
                                    <%--<div class="panel-heading"><h3 class="panel-title">公告</h3></div>--%>
                                    <%--<div class="panel-body bjui-doc" style="padding:0 20px;overflow:auto">--%>
                                        <%--<table id="notice">--%>
                                            <%--${noticeBean.content}--%>
                                            <%--<a href="${root}<%=Url.getUrl(Url.NOTICE_LIST_SHOW)%>"--%>
                                               <%--data-toggle="dialog" data-mask="true" data-title="公告列表" data-width="600"--%>
                                               <%--data-height="500" data-id="viewNotice"><font--%>
                                                    <%--color="#1e90ff"> >>更多</font></a>--%>
                                        <%--</table>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                            <div class="row-fluid">
                                <div id="up-left" class="col-md-6">
                                    <div class="top">
                                        <div id="admin">
                                            <p>欢迎你！
                                                <span>
                                                     <a href="${root}<%=Url.getUrl(Url.USER_DETAIL_SHOW)%>?id=${currentUser.id}"
                                                        data-toggle="dialog" data-mask="true" data-width="600"
                                                        data-height="500"/>
                                                            <span>
                                                            ${currentUser.name}
                                                             </span>
                                                     </a>
                                                </span>
                                            </p>
                                        </div>

                                        <a href="#"
                                           onclick="window.confirm('确定注销吗？')?this.href='${root}<%=Url.getUrl(Url.USER_LOGOUT)%>':this.href='javascript:void(0)';">
                                                    <span><i class="Hui-iconfont">&#xe726;</i>
                                                    注销登陆</span>
                                        </a>
                                    </div>
                                    <div class="down">

                                        <%--功能按钮 start --%>
                                        <ul id="left_menu">
                                                 <li class="datetime">
                                                     <a href="javascript:;">
                                                         <i style="margin-top: 10px;margin-bottom: 10px;" class="Hui-iconfont">&#xe690;</i>
                                                         <p id="bjui-date">0000/00/00</p>
                                                         <p id="bjui-clock">00:00:00</p>
                                                     </a>
                                                 </li>

                                                 <%--<li>--%>
                                                     <%--<a href="${root}<%=Url.getUrl(Url.USER_DETAIL_SHOW)%>?id=${currentUser.id}"--%>
                                                        <%--data-toggle="dialog" data-mask="true" data-width="600"--%>
                                                        <%--data-height="500"/>--%>
                                                     <%--<span><i class="Hui-iconfont">&#xe60d;</i>--%>
                                                         <%--${currentUser.name}</span>--%>
                                                     <%--</a>--%>
                                                 <%--</li>--%>

                                                 <li>

                                                     <a href="${root}<%=Url.getUrl(Url.DEPT_DETAIL_SHOW)%>?id=${currentDept.id}"
                                                        data-toggle="dialog" data-mask="true" data-width="600"
                                                        data-height="500"/>
                                                     <span><i class="Hui-iconfont">&#xe62b;</i>
                                                         ${currentDept.name}</span>
                                                     </a>
                                                 </li>

                                                 <li>
                                                     <a href="${root}/resources/html/jsc.jsp">
                                                        <span>
                                                            <i class="Hui-iconfont">&#xe72d;</i>
                                                            驾驶舱
                                                        </span>
                                                     </a>
                                                 </li>

                                                 <li>
                                                     <sys:permission url="<%=Url.getUrl(Url.USER_PASSWORD_CHANGE_SHOW)%>">
                                                         <a href="${root}<%=Url.getUrl(Url.USER_PASSWORD_CHANGE_SHOW)%>" data-toggle="dialog"
                                                            data-id="sys_user_changepass" data-mask="true" data-width="400" data-height="300">
                                                             <span>
                                                                  <i class="Hui-iconfont">&#xe63f;</i>
                                                                    修改密码
                                                              </span>
                                                         </a>
                                                     </sys:permission>
                                                 </li>
                                        </ul>
                                            <%--功能按钮 end --%>

                                        <%--<li>--%>
                                                     <%--<a href="#"--%>
                                                        <%--onclick="window.confirm('确定注销吗？')?this.href='${root}<%=Url.getUrl(Url.USER_LOGOUT)%>':this.href='javascript:void(0)';">--%>
                                                        <%--<span>--%>
                                                            <%--<i class="Hui-iconfont">&#xe726;</i>--%>
                                                        <%--注销登陆--%>
                                                        <%--</span>--%>
                                                     <%--</a>--%>
                                                 <%--</li>--%>
                                            <%--公告 start --%>
                                        <div style="height: 100%;">
                                            <div class="panel panel-default" style="height: 100%;overflow: auto;">
                                                <div class="panel-heading"><h3 class="panel-title">公告</h3></div>
                                                <div class="panel-body bjui-doc" style="padding:0 20px;overflow:auto">
                                                    <table id="notice">
                                                        ${noticeBean.content}
                                                        <a href="${root}<%=Url.getUrl(Url.NOTICE_LIST_SHOW)%>"
                                                           data-toggle="dialog" data-mask="true" data-title="公告列表" data-width="600"
                                                           data-height="500" data-id="viewNotice"><font
                                                                color="#1e90ff"> >>更多</font></a>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                            <%--公告 end --%>

                                    </div>
                                </div>
                                <%--报表 start --%>
                                <div id="up_right" class="col-md-6">
                                    <div class="top">
                                        <filedset>
                                            <legend>报表</legend>
                                        </filedset>
                                    </div>
                                    <div class="down">
                                        <%--<div class="panel-heading" style="height: 38px">--%>
                                            <%--<h3 class="panel-title" style="float: left">待办事项</h3>--%>
                                            <%--<a id="refresh" style="float: right">--%>
                                                <%--<i class="Hui-iconfont">&#xe68f;</i>--%>
                                                <%--<b>刷新</b>--%>
                                            <%--</a>--%>
                                        <%--</div>--%>
                                        <%--<div class="panel-body bjui-doc" style="padding:0;height:450px;overflow:auto">--%>
                                            <%--<ul>--%>
                                                <%--<li>--%>
                                                    <%--<h4>--%>
                                                        <%--<a id="open" href="${root}<%=Url.getUrl(Url.MESSAGE_INDEX_SHOW)%>"--%>
                                            <%--data-toggle="dialog" data-mask="true" data-id="viewMessage"--%>
                                            <%--data-width="600" data-height="300"--%>
                                            <%--data-title="待办事项">您有${messageNum}条未读消息--%>
                                                        <%--</a>--%>
                                                    <%--</h4>--%>
                                                <%--</li>--%>
                                            <%--</ul>--%>
                                        <%--</div>--%>
                                    </div>
                                </div>
                                <%--报表 end --%>
                            </div>
                            <div class="row-fluid">
                                <div id="down_left" class="col-md-6">
                                    <div class="top">
                                        <filedset>
                                            <legend>公告</legend>
                                        </filedset>
                                    </div>
                                    <div class="down">

                                    </div>
                                </div>
                                <div id="down_right" class="col-md-6">
                                    <div class="top">

                                    </div>
                                    <div class="down">

                                    </div>
                                </div>
                            </div>
                        <script>
                            window.onload = function () {
                                setInterval(function () {
                                    var url = "${root}<%=Url.getUrl(Url.MESSAGE_REFRESH_SUBMIT)%>";
                                    $.ajax({
                                        type: 'post',
                                        async: true,
                                        url: url,
                                        dataType: "json",
                                        timeout: 1000,
                                        success: function (datas) {
                                            if (datas.messageNum != "0") {
                                                $("#open").text("您有"+dates.messageNum+"条未读消息");
                                                // location.reload();
                                                $('#pop_div').fadeIn(400);
                                                setTimeout(function () {
                                                    $('#pop_div').fadeOut(400);
                                                }, 4000);
                                            }
                                        }
                                        // error: function () {
                                        //     alert("刷新失败");
                                        // }
                                    })
                                }, 60000)
                            }

                            $.nicenav(300);

                            $(document).on("click", "#refresh", function () {
                                var url = "${root}<%=Url.getUrl(Url. MESSAGE_REFRESH_SUBMIT)%>";
                                $.ajax({
                                    type: 'post',
                                    async: true,
                                    url: url,
                                    dataType: "json",
                                    timeout: 1000,
                                    success: function (dates) {
                                        $("#open").text("您有"+dates.messageNum+"条未读消息");
                                    },
                                    error: function () {
                                        alert("刷新失败");
                                    }
                                })
                            })
                        </script>
                        <%--<div style="width: 50%;float: left;height: 100%;">--%>
                            <%--<div class="col-md-12" style="height: 100%;padding: 0;">--%>
                                <%--<div class="panel panel-default" id="messageDiv" style="height: 97%;">--%>
                                    <%--<div class="panel-heading" style="height: 38px">--%>
                                        <%--<h3 class="panel-title" style="float: left">待办事项</h3>--%>
                                        <%--<a id="refresh" style="float: right">--%>
                                            <%--<i class="Hui-iconfont">&#xe68f;</i><b>刷新</b></a>--%>
                                    <%--</div>--%>
                                    <%--<div class="panel-body bjui-doc" style="padding:0;height:450px;overflow:auto">--%>
                                        <%--<ul><li><h4><a id="open" href="${root}<%=Url.getUrl(Url.MESSAGE_INDEX_SHOW)%>"--%>
                                               <%--data-toggle="dialog" data-mask="true" data-id="viewMessage"--%>
                                               <%--data-width="600" data-height="300"--%>
                                               <%--data-title="待办事项">您有${messageNum}条未读消息</a></h4></li></ul>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>
