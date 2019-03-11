<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%@ page import="com.model.bean.RecordPersonBean" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/in_writing.css">
    <div class="container-fluid" style="background: #F9F9F9;">
        <!-- mp3 start -->
        <div class="row-fluid" id="mp3">
            <%@include file="/public/header.jsp" %>
        </div>
        <!-- mp3 end -->
        <form id="casePersonForm" ata-toggle="ajaxform"   method="post"  >
            <%--<input type="hidden" name="xwsj" value="${currentTime}">--%>
            <%--<input type="hidden" name="blsj" value="${currentTime}">--%>
            <input type="hidden" name="recordType" value="${typeId}">
            <div class="row-fluid">
                <!-- left info start -->
                <div class="col-md-3" id="left">
                    <%@include file="/public/left_info.jsp" %>
                </div>
                <!-- left info end -->

            <!-- mid info start -->
            <div class="col-md-6" id="mid">
                <!-- editor start -->
                <div id="editor">
                    <div>
                        <h1>笔录问答</h1>
                    </div>
                </div>
                <!-- editor end -->

                <!-- info start 笔录信息 -->
                <div id="info">
                    <input type="hidden" name="id" value="1" />
                    <textarea class="textContent"  style="display: none;"  name="recordContent"   style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea>
                    <table class="table table-hover" id="editor_table" >
                        <tbody>
                            <c:forEach items="${recordQuestionList}" var="recordQuestion" varStatus="i">
                                <tr class="question">
                                    <th><strong class="question1">问：</strong></th>
                                    <td class="question2">${recordQuestion.content}</td>
                                    <td>
                                        <input value="删除" data-id="${recordQuestion.id}" class="btn  btn-danger delete" type="button" />
                                    </td>
                                </tr>
                                <tr class="answer">
                                    <th><strong>答：</strong></th>
                                    <td>
                                        <textarea class="required" name="record" id="" style="border: none;max-width: 560px;min-width: 560px;min-height: 45px;" cols="60" rows="1"></textarea>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- info end -->

            </div>
            <!-- mid info end -->
                <!-- foot info start -->
                <%--<div class="row-fluid">
                    <div class="col-md-12" id="foot">
                        <%@include file="/public/footer.jsp" %>
                    </div>
                </div>--%>
                <!-- foot info end -->
            </div>
            <%@include file="/public/footer.jsp" %>
        </form>
            <!-- right info start -->
            <div class="col-md-3" id="right">
                <%--<form id="${searchFormId}" data-toggle="ajaxsearch"
                      action="${root}<%=Url.getUrl(Url.RECORD_QUESTION_PAGE_SHOW1)%>" method="post">--%>
                     <input type="hidden" id="typeId" value="${typeId}">
                    <div class="bjui-searchBar">
                        <div class="form-group">
                            <label for="contentQuestion" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">问题：</label>
                            <input class="form-control"  id="contentQuestion" placeholder="请输入名称" >
                        </div>
                        <div class="form-group">
                            <label for="typeQuestion" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">类型：</label>
                            <select id="typeQuestion" class="form-control">
                                <option value="-1">请选择</option>
                                <c:forEach items="${recordTypeList}" var="recordType">
                                    <option value="${recordType.id}">${recordType.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <button type="button" class="btn-blue" data-icon="search" id="query_base_show" onclick="btnQuestion()">查询</button>
                        <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
                           data-icon="undo">清空查询</a>
                    </div>
                 <%--</form>--%>
                <!-- menu_right_info start -->
                <div id="menu_right_info" style="position: relative">
                        <ul>
                            <c:forEach items="${entityList}" var="recordQuestion" varStatus="i">
                                <li >
                                    <span>${recordQuestion.content}</span>
                                    <button class="btn btn-info insertBtn" id="insertBtn-${recordQuestion.id}" data-id="${recordQuestion.id}" style="float: right;">添加</button>
                                </li>
                            </c:forEach>
                        </ul>
                </div>
                <!-- menu_right_info end -->
               <%-- <%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>--%>
            </div>
            <!-- right info start -->

        </div>


<script>

    function reportBtn(){
        var record_start_time = $("#record_start_time").val();
        var record_end_time = $("#record_end_time").val();
        var url;
        var json = {user1:"${userId1}",user:"${userId}",
                       content:content(),"record_start_time":record_start_time,"record_end_time":record_end_time};
        var i =0;
        i++;
        $.ajax({
            url:"${root}<%=Url.getUrl(Url.REPORT_RECORD_DATA)%>",
            data:json,
            type:"post",
            success:function(data){
                var b="";
                for (var i = 0;i<data.length;i++){
                    if(data.charAt(i) != '"'){
                        b +=data.charAt(i);
                    }
                }
                var path = "${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=";
                url = "<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=" + b;
                window.open("${root}/pdf/web/viewer.jsp?files="+url, "打印预览");
            },
            error:function(e){
                alert("错误！！");
            }
        });
    }
 function btnQuestion(){
        var name = $("#contentQuestion").val();
        var typeId = $("#typeId").val();
        var type = $("#typeQuestion").val();
         var json;
        if(type == "-1"){
           json = {content:name,typeId:typeId};
        }else{
            json = {content:name,typeId:typeId,type:type};
        }

        $.ajax({
            url:"${root}<%=Url.getUrl(Url.RECORD_QUESTION_PAGE_SHOW1)%>",
            data:json,
            type:"post",
            success:function(data){
                var content="";
                $.each(JSON.parse(data),function(index,item){
                    var flag = "";
                    var id = item.id;
                    var delete1 = $("#delete-" + id).html();
                    if(delete1 == '删除'){
                        flag = "disabled";
                    }
                    content += '<li >\n' +
                        '  <span>' + item.content + '</span>\n' +
                        '        <button  ' +  flag +
                        '   class="btn btn-info insertBtn" id="insertBtn-' + item.id + '" data-id="' + item.id + '" style="float: right;">添加</button>\n' +
                        '  </li>';
                })
                $("#menu_right_info>ul").html(content);
                console.log(data);
            },
            error:function(e){
                alert("2错误！！");
            }
        })
    }
    $("#casePersonForm").submit(function(){
        $("#casePersonForm").bjuiajax('ajaxform', {
            url: '${root}<%=Url.getUrl(Url.RECORD_ADD_CASE_SUBMIT)%>',
            //form:$.CurrentDialog.find('#casePersonForm'),
            validate: true,
            okCallback:function(){
                $(this).navtab('refresh');//刷新当前页签
                $(this).dialog('closeCurrent');//关闭当前弹窗
                //opener.parent.location.reload()
                //window.parent.location.reload();
            },
            loadingmask: true,
            confirmMsg:'是否提交数据',
            beforeSubmit:function(){
                $(".textContent").html(content());
                return true;
            }
        })
    });
    function content() {
        var question = $('#editor_table tr[class=question]');
        var answer = $('#editor_table tr[class=answer]');
        var $text = $('#editor_table tr[class=answer] textarea');
        var question1_content = [];
        question.find(".question1").each(function (i) {
            question1_content[i] = $(this).text().trim();
            //return question_content;
        });
        var question2_content = [];
        question.find(".question2").each(function (i) {
            question2_content[i] = $(this).text().trim();
            //return question_content;
        });
        var question_content = [];
        question.each(function (i) {
            question_content[i] = question1_content[i]+question2_content[i];
            //return question_content;
        });
        var answer_content = [];
        answer.each(function (i) {
            answer_content[i] = $(this).text().trim()+$(this).find('td textarea').val().trim();
            //return answer_content;
        });
        var content="";
        for (var i=0;i<question_content.length;i++){
            content +='<br><br>'+ question_content[i].trim()+'<br>'+answer_content[i].trim();
            console.log(question_content[i]+'\n'+answer_content[i]);
        }
        return content
    }

    function directpdfprint(srcFile) {
        debugger;
        var pdfprint = document.getElementById("createPDF");
        if (pdfprint != undefined && pdfprint != null) {
            var parentNode = pdfprint.parentNode;
            parentNode.removeChild(pdfprint);
        }
        var pdfprintdiv = document.getElementById("createPDFDIV");

        var p = document.createElement("object");
        try {
            p.id = "createPDF";
            p.classid = "CLSID:CA8A9780-280D-11CF-A24D-444553540000";
            p.width = 1;
            p.height = 1;
            p.src = encodeURI(encodeURI(srcFile));// 处理中文名称
            pdfprintdiv.appendChild(p);
            p.printWithDialog();// 带打印窗口的直接打印
            // p.printAll();//直接打印
        } catch (e) {
            // alert(e);
            $.messager.alert("提示", '请确保已安装Adobe，并开启Adobe加载项！' + e, "warning");
        }
    }
    //})
</script>
<script src="${pageContext.request.contextPath }/B-JUI.1.31/B-JUI/plugins/js/in_writing.js"></script>




