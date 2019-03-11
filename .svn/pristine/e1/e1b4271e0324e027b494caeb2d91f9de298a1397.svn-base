<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %><%
        // 权限验证  
        if(session.getAttribute(SessionKey.USER)==null){
            response.sendRedirect("login.jsp");  
            return;  
        } else {
            request.setAttribute("currentUser", (User)session.getAttribute(SessionKey.USER));
        }
%>  
<%
 response.setHeader("Pragma","No-cache");
 response.setHeader("Cache-Control","No-cache");
 response.setDateHeader("Expires", -1);
 response.setHeader("Cache-Control", "No-store");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<%@include file="/WEB-INF/views/common_bjui.jsp"%>
<%-- <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>执法智慧化管理平台</title>
<style type="text/css">
.echartsDiv{padding:10px;
	background:url(${root}/resources/images/jscdivbg.jpg);
	filter:'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')';
	-moz-background-size:100% 100%;
	background-size:100% 100%;
	float:left;
	margin-left: 20px;
	margin-top: 20px;
}
</style>
<!-- init -->
<script type="text/javascript">
$(function() {
    BJUI.init({
        JSPATH       : '${root}/B-JUI.1.31/B-JUI/',         //[可选]框架路径
        PLUGINPATH   : '${root}/B-JUI.1.31/B-JUI/plugins/', //[可选]插件路径
        loginInfo    : {url:'${root}/B-JUI.1.31/login_timeout.html', title:'登录', width:440, height:240}, // 会话超时后弹出登录对话框
        statusCode   : {ok:200, error:300, timeout:301}, //[可选]
        ajaxTimeout  : 300000, //[可选]全局Ajax请求超时时间(毫秒)
        alertTimeout : 3000,  //[可选]信息提示[info/correct]自动关闭延时(毫秒)
        pageInfo     : {total:'totalRow', pageCurrent:'pageCurrent', pageSize:'pageSize', orderField:'orderField', orderDirection:'orderDirection'}, //[可选]分页参数
        keys         : {statusCode:'statusCode', message:'message'}, //[可选]
        ui           : {
                         sidenavWidth     : 220,
                         showSlidebar     : true, //[可选]左侧导航栏锁定/隐藏
                         overwriteHomeTab : false //[可选]当打开一个未定义id的navtab时，是否可以覆盖主navtab(我的主页)
                       },
        debug        : true,    // [可选]调试模式 [true|false，默认false]
        theme        : 'green' // 若有Cookie['bjui_theme'],优先选择Cookie['bjui_theme']。皮肤[五种皮肤:default, orange, purple, blue, red, green]
    })
    //时钟
    var today = new Date(), time = today.getTime()
    $('#bjui-date').html(today.formatDate('yyyy/MM/dd'))
    setInterval(function() {
        today = new Date(today.setSeconds(today.getSeconds() + 1))
        $('#bjui-clock').html(today.formatDate('HH:mm:ss'))
    }, 1000)
})

/*window.onbeforeunload = function(){
    return "确定要关闭本系统 ?";
}*/

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
        $(event.target).dialog({id:treeNode.targetid, url:treeNode.url, title:treeNode.name})
    else if (treeNode.target && treeNode.target == 'navtab')
        $(event.target).navtab({id:treeNode.targetid, url:treeNode.url, title:treeNode.name, fresh:treeNode.fresh, external:treeNode.external})
}

// 满屏开关
var bjui_index_container = 'container_fluid'

function bjui_index_exchange() {
    bjui_index_container = bjui_index_container == 'container_fluid' ? 'container' : 'container_fluid'
    $('#bjui-top').find('> div').attr('class', bjui_index_container)
    $('#bjui-navbar').find('> div').attr('class', bjui_index_container)
    $('#bjui-body-box').find('> div').attr('class', bjui_index_container)
}
</script>
</head>
<body>
    <!--[if lte IE 7]>
        <div id="errorie"><div>您还在使用老掉牙的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
    <![endif]-->
    <div id="bjui-top" class="bjui-header">
        <div class="container_fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapsenavbar" data-target="#bjui-top-collapse" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <nav class="collapse navbar-collapse" id="bjui-top-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="datetime"><a><span id="bjui-date">0000/00/00</span> <span id="bjui-clock">00:00:00</span></a></li>
<%--                     <li class="dropdown"><a  href="#" class="dropdown-toggle bjui-fonts-tit" data-toggle="dropdown" title="个人信息及修改">${currentUser.userName}</a> --%>
<!--                    		 <ul class="dropdown-menu" role="menu" id="bjui-person"> -->
<!-- 							个人信息和修改密码 -->
<!-- 							<li><a href="javascript:;" class="btn-blue" data-toggle="dialog" onclick="read();"> 个人信息</a></li> -->
<!--                             <li><a href="javascript:;" class="btn-orange" data-toggle="dialog" onclick="change();"> 修改密码</a></li> -->
<!-- 						</ul> -->
<!-- 					</li> -->
                    <li><a href="javascript:;">${currentUser.name}</a></li>
                    <li><a href="javascript:;">角色：${currentUser.userType}</a></li>
                    <li><a href="${root}/resources/html/jsc.jsp">驾驶舱</a></li>
                    <li><a href="${root}/B-JUI.1.31/changepassword.html" data-toggle="dialog" data-id="sys_user_changepass" data-mask="true" data-width="400" data-height="300">修改密码</a></li>
                    <li><a href="#" onclick="window.confirm('确定注销吗？')?this.href='${root}<%=Url.getUrl(Url.USER_LOGOUT)%>':this.href='javascript:void(0)';"  style="font-weight:bold;">&nbsp;<i class="fa fa-power-off"></i> 注销登陆</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle bjui-fonts-tit" data-toggle="dropdown" title="更改字号">
                            <i class="fa fa-font"></i> 大</a>
                        <ul class="dropdown-menu" role="menu" id="bjui-fonts">
                            <li><a href="javascript:;" class="bjui-font-a" data-toggle="fonts"><i class="fa fa-font"></i> 特大</a></li>
                            <li><a href="javascript:;" class="bjui-font-b" data-toggle="fonts"><i class="fa fa-font"></i> 大</a></li>
                            <li><a href="javascript:;" class="bjui-font-c" data-toggle="fonts"><i class="fa fa-font"></i> 中</a></li>
                            <li><a href="javascript:;" class="bjui-font-d" data-toggle="fonts"><i class="fa fa-font"></i> 小</a></li>
                        </ul>
                    </li>
                    <li><a href="${root}/resources/html/sd.html">锁定屏幕</a></li>
                    <li class="dropdown active"><a href="#" class="dropdown-toggle theme" data-toggle="dropdown" title="切换皮肤"><i class="fa fa-tree"></i></a>
                        <ul class="dropdown-menu" role="menu" id="bjui-themes">
<!--                             <li><a href="javascript:;" class="theme_default" data-toggle="theme" data-theme="default">&nbsp;<i class="fa fa-tree"></i> 黑白分明&nbsp;&nbsp;</a></li> -->
<!--                             <li><a href="javascript:;" class="theme_orange" data-toggle="theme" data-theme="orange">&nbsp;<i class="fa fa-tree"></i> 橘子红了</a></li> -->
                            <li><a href="javascript:;" class="theme_purple" data-toggle="theme" data-theme="purple">&nbsp;<i class="fa fa-tree"></i> 紫罗兰</a></li>
                            <li class="active"><a href="javascript:;" class="theme_blue" data-toggle="theme" data-theme="blue">&nbsp;<i class="fa fa-tree"></i> 天空蓝</a></li>
                            <li><a href="javascript:;" class="theme_green" data-toggle="theme" data-theme="green">&nbsp;<i class="fa fa-tree"></i> 绿草如茵</a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:;" onclick="bjui_index_exchange()" title="横向收缩/充满屏幕"><i class="fa fa-exchange"></i></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <header class="navbar bjui-header" id="bjui-navbar">
        <div class="container_fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" id="bjui-navbar-collapsebtn" data-toggle="collapsenavbar" data-target="#bjui-navbar-collapse" aria-expanded="false">
                    <i class="fa fa-angle-double-right"></i>
                </button>
                <a class="navbar-brand" >
                    <img src="${root}/resources/images/logo.gif" height="35">
                </a>
            </div>
            <nav class="collapse navbar-collapse" id="bjui-navbar-collapse">
                <ul class="nav navbar-nav navbar-right" id="bjui-hnav-navbar">
                    <li class="active">
                        <a href="${root}<%=Url.getUrl(Url.MENU_ALL_LIST)%>" data-toggle="sidenav" data-id-key="targetid"></a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
    <div id="bjui-body-box">
        <div class="container_fluid" id="bjui-body" style="background-image:url(${root}/resources/images/jscbg.jpg);background-repeat:no-repeat;height:100%;text-align: center;">
        	<div class="echartsDiv" style="width:720px;height:420px;">
       			<div id="data110" style="width: 700px; height: 400px;"></div>
       		</div>
       		<div class="echartsDiv" style="width:420px;height:420px;">
       			<div id="anshijian" style="width: 400px; height: 400px;"></div>
       		</div>
       		<div class="echartsDiv" style="width:420px;height:420px;">
       			<div id="yinshipin" style="width: 400px; height: 400px;"></div>
       		</div>
       		<div class="echartsDiv" style="width:520px;height:420px;">
       			<div id="yujingqushi" style="width: 500px; height: 400px;"></div>
       		</div>
        </div>
    </div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('data110'));

    var option = {
   	    title: {
   	        text: '110',
	   	    textStyle: {
	        	color: '#FFF'
	        }
   	    },
   	    tooltip: {
   	        trigger: 'axis'
   	    },
   	    legend: {
   	        data:['所有案件','处理中的案件','已处理的案件'],
   	     	textStyle: {
	        	color: '#FFF'
	        }
   	    },
   	    grid: {
   	        left: '3%',
   	        right: '4%',
   	        bottom: '3%',
   	        containLabel: true
   	    },
   	    toolbox: {
   	        feature: {
   	            saveAsImage: {}
   	        }
   	    },
   	    xAxis: {
   	        type: 'category',
   	        boundaryGap: false,
   	        data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
	 	    axisLine: {
		       	lineStyle: {
		       		color: '#FFF'
		       	}
	        }
   	    },
   	    yAxis: {
   	        type: 'value',
   	     	axisLine: {
		       	lineStyle: {
		       		color: '#FFF'
		       	}
	        }
   	    },
   	    series: [
   	        {
   	            name:'所有案件',
   	            type:'line',
   	            stack: '总量',
   	            data:[120, 132, 101, 134, 90, 230, 210,200,320,450,251,350]
   	        },
   	        {
   	            name:'处理中的案件',
   	            type:'line',
   	            stack: '总量',
   	            data:[220, 182, 191, 234, 290, 330, 310,221,512,153,145,452]
   	        },
   	        {
   	            name:'已处理的案件',
   	            type:'line',
   	            stack: '总量',
   	            data:[150, 232, 201, 154, 190, 330, 410,235,512,332,652,155]
   	        }
   	    ]
   	};

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
	//基于准备好的dom，初始化echarts实例
	var asjChart = echarts.init(document.getElementById('anshijian'));
	var option = {
	    color: ['#3398DB'],
	    title: {
            left: 'center',
            text: '案事件',
            textStyle: {
            	color: '#FFF'
            }
        },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
	            axisTick: {
	                alignWithLabel: true
	            },
	            axisLine: {
	            	lineStyle: {
	            		color: '#FFF'
	            	}
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            axisLine: {
	            	lineStyle: {
	            		color: '#FFF'
	            	}
	            }
	        }
	    ],
	    series : [
	        {
	            name:'直接访问',
	            type:'bar',
	            barWidth: '60%',
	            data:[10, 52, 200, 334, 390, 330, 220]
	        }
	    ]
	};
	//使用刚指定的配置项和数据显示图表。
	asjChart.setOption(option);
</script>
<script type="text/javascript">
	//基于准备好的dom，初始化echarts实例
	var ysnChart = echarts.init(document.getElementById('yinshipin'));
	var option = {
		title: {
            left: 'center',
            text: '执法音视频',
            textStyle: {
            	color: '#FFF'
            }
        },
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        x: 'left',
	        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎'],
	        textStyle: {
	        	color: '#FFF'
	        }
	    },
	    series: [
	        {
	            name:'访问来源',
	            type:'pie',
	            radius: ['50%', '70%'],
	            avoidLabelOverlap: false,
	            label: {
	                normal: {
	                    show: false,
	                    position: 'center'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '30',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:335, name:'直接访问'},
	                {value:310, name:'邮件营销'},
	                {value:234, name:'联盟广告'},
	                {value:135, name:'视频广告'},
	                {value:1548, name:'搜索引擎'}
	            ]
	        }
	    ]
	};
	//使用刚指定的配置项和数据显示图表。
	ysnChart.setOption(option);
</script>
<script type="text/javascript">
	//基于准备好的dom，初始化echarts实例
	var yjqsChart = echarts.init(document.getElementById('yujingqushi'));
	var option = {
	    title: {
	        text: '预警趋势',
	        left: 'center',
            textStyle: {
            	color: '#FFF'
            }
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎'],
	        textStyle: {
	        	color: '#FFF'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: ['周一','周二','周三','周四','周五','周六','周日'],
	        axisLine: {
            	lineStyle: {
            		color: '#FFF'
            	}
            }
	    },
	    yAxis: {
	        type: 'value',
	        axisLine: {
            	lineStyle: {
            		color: '#FFF'
            	}
            }
	    },
	    series: [
	        {
	            name:'邮件营销',
	            type:'line',
	            stack: '总量',
	            data:[120, 132, 101, 134, 90, 230, 210]
	        },
	        {
	            name:'联盟广告',
	            type:'line',
	            stack: '总量',
	            data:[220, 182, 191, 234, 290, 330, 310]
	        },
	        {
	            name:'视频广告',
	            type:'line',
	            stack: '总量',
	            data:[150, 232, 201, 154, 190, 330, 410]
	        },
	        {
	            name:'直接访问',
	            type:'line',
	            stack: '总量',
	            data:[320, 332, 301, 334, 390, 330, 320]
	        },
	        {
	            name:'搜索引擎',
	            type:'line',
	            stack: '总量',
	            data:[820, 932, 901, 934, 1290, 1330, 1320]
	        }
	    ]
	};
	//使用刚指定的配置项和数据显示图表。
	yjqsChart.setOption(option);
</script>
</body>
</html>