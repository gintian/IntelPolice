<%@ page import="com.utils.SessionKey" %>
<%@ page import="com.model.User" %>
<%@ page import="com.utils.DateUtils" %>
<%
    request.setAttribute("currentUser", (User) session.getAttribute(SessionKey.USER));
    request.setAttribute("currentTime", DateUtils.getCurrentDateTime());
%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<style>
    .level-0,.level-1,.level-2{
        cursor: pointer;
    }
    .level:hover{color: #fff6f6; background: #003bb3}
    .level-1,.level-2{
        display: none;
    }
    .selected{color: #fff6f6; background: #003bb3}
</style>
<script>
    var personArray=new Array(8);
    var person1 = {id:'1','name':'张三','idCard':"1123",'address':'成都','btn':true};
    var person2 = {id:'2','name':'李四','idCard':"2123",'address':'成都','btn':true};
    var person3 = {id:'3','name':'王五','idCard':"3123",'address':'成都','btn':true};
    personArray[0]=person1;
    personArray[1]=person2;
    personArray[5]=person3;
    $(function(){
        $(".select-type").show();
        $(".list-group").on("click",".level",function() {
            var pid = $(this).data("id");
            var order = $(this).data("order");
            if($(this).parent().hasClass("level-0")){
                $(".level-1").hide();
                $(".level-2").hide();
                $(".level-0 .level").removeClass("selected");
                $(".level-1 .level").removeClass("selected");
                $(".level-2 .level").removeClass("selected");
                $("#" + pid).show();
            }
            if($(this).parent().hasClass("level-1")){
                $(".level-2").hide();
                $(".level-1 .level").removeClass("selected");
                $(".level-2 .level").removeClass("selected");
                $("#" + pid).show();
            }
            if($(this).parent().hasClass("level-2")){
                $(".level-2 .level").removeClass("selected");
            }
            $(this).addClass("selected");
            if(order == 0){
                deleteAll();
                var modelId =  $(this).data("modelid");
                $(".typeId").val($(this).data("id"));
                $(".modelId").val(modelId);
                $(".type").val($(this).html());
                if(modelId == "002"){
                    $("#personNum").val('');
                    $("#person").html("辨认人*：");
                    $(".personTable").show();
                }else{
                    $("#personNum").val(0);
                    $("#person").html("被询/讯问人*：");
                    $(".personTable").hide();
                }
            }
        });
        rePersonTable();
        /*$("#form_person").bjuiajax('ajaxform', {
            url: '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>',
            validate: true,
            loadingmask: true,
            confirmMsg:'是否提交数据',
            okalert:false,
            forward:'${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>'
        })*/
    });
    //清空
    function deleteAll(){
        personArray=new Array(8);
        rePersonTable();
    }
    //删除
    function deletePerson(id){
        personArray[id - 1] = null;
        rePersonTable();
    }
    //遍历personArray
    function rePersonTable(){
        var personNum = 0;
        for(var i = 0; i < personArray.length; i++){
            var j = i + 1;
            if(personArray[i] != null){
                personNum++;
                $(".person_id_" + j).val(personArray[i]['id']);
                $(".person_name_" + j).html(personArray[i]['name']);
                $(".person_idCard_" + j).html(personArray[i]['idCard']);
                $(".person_address_" + j).html(personArray[i]['address']);
                if(personArray[i]['btn']){
                    var btn ="<button class='btn btn-red' type='button' onclick='deletePerson(" + j + ")' >删除</button>";
                    $(".person_btn_" + j).html(btn);
                }
            }else{
                $(".person_id_" + j).val("");
                $(".person_name_" + j).html("");
                $(".person_idCard_" + j).html("");
                $(".person_address_" + j).html("");
                $(".person_btn_" + j).html("");
            }
        }
        if(personNum == 0){
            $(".personNum").val("");
        }else {
            $("#personNum").val(personNum);
        }
    }
</script>
        <div style="width: 100%; padding: 20px 10%">
            <div class="panel panel-default">
                <%--<c:if test="${status eq '0'}">--%>
                    <form id="form_person"  data-toggle="ajaxform"  method="post" data-alertmsg="false" data-id="form_person"
                           data-options="{url: '${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_PERSON_SHOW)%>',validate: true,loadingmask: true,confirmMsg:'是否提交数据',
                          okalert:false,forward:'${root}<%=Url.getUrl(Url.RECORD_IN_WRITING_SHOW)%>',closeCurrent:true} " >
                        <input name="status" value="0" type="hidden">
                        <input type="hidden" name="caseIdPerson1" value="${caseIdPerson}">
                            <ul class="list-group" style="margin-bottom: 0px">
                                <li class="list-group-item">
                                            <div class="form-inline">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="row-label" for="userTree_userId">主案人<span
                                                                    class="required">*</span>：</label>
                                                            <input  id="userTree_userName" readonly
                                                                    data-rule="required" value="<hs:user value='${bpipUser.userId}'/>"
                                                                    type="text">
                                                            <input name="userId" id="userTree_userId"
                                                                   value="${bpipUser.userId}" type="hidden">
                                                            <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW)%>" data-icon="search"
                                                               data-id="navtab_record1"
                                                               class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600"
                                                               data-title="查询"></a>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label class="row-label" for="userTree_userId1">笔录人<span  class="required">*</span>：</label>
                                                            <input  id="userTree_userName1" readonly data-rule="required" value="<hs:user value='${entity.id}'/>"  type="text">
                                                            <input name="userId1" id="userTree_userId1" value="${entity.id}" type="hidden">
                                                            <a href="${root}<%=Url.getUrl(Url.USER_TREE_SHOW1)%>" data-id="navtab_record2" data-icon="search"   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                </li>
                                <li class="list-group-item">
                                    <input type="hidden" class="typeId" name="type" value="">
                                    <input type="hidden" class="modelId" name="model" value="">
                                    <div class="form-inline">
                                        <div class="form-group">
                                            <label class="row-label" for="typeId">类型：<span  class="required">*</span>：</label>
                                            <input  id="typeId" readonly class="type" data-rule="required" value="" type="text">
                                        </div>
                                    </div>

                                    <%--<button  type="button" data-rule="required" class="btn btn-primary btn-type">选择</button>--%>
                                    <%--一级--%>
                                    <div class="row select-type" style="display: none;margin-top: 20px;margin-right: 10px;">
                                        <%--一级--%>
                                        <div class="col-md-4">
                                            <ul class="list-group level-0">
                                                <c:forEach items="${recordTypeBeanList}" var="ecordTypeBean">
                                                    <li  class=" list-group-item level" data-order="${ecordTypeBean.order}" data-id="${ecordTypeBean.id}" data-modelId="${ecordTypeBean.model}">${ecordTypeBean.name}</li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                        <%--二级--%>
                                        <div class="col-md-4">
                                            <c:forEach items="${recordTypeBeanList}" var="ecordTypeBean">
                                                <ul class="list-group level-1" id="${ecordTypeBean.id}" data-pid="${ecordTypeBean.id}">
                                                    <c:forEach items="${ecordTypeBean.sonList}" var="ecordTypeOne">
                                                        <li class="list-group-item level" data-order="${ecordTypeOne.order}" data-id="${ecordTypeOne.id}" data-modelId="${ecordTypeOne.model}">${ecordTypeOne.name}</li>
                                                    </c:forEach>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                        <%--三级--%>
                                        <div class="col-md-4">
                                            <c:forEach items="${recordTypeBeanList}" var="ecordTypeBean">
                                                <c:forEach items="${ecordTypeBean.sonList}" var="ecordTypeOne">
                                                    <ul class="list-group level-2 " id="${ecordTypeOne.id}" data-pid="${ecordTypeOne.id}">
                                                        <c:forEach items="${ecordTypeOne.sonList}" var="ecordTypeTwo">
                                                            <li  class="list-group-item level" data-order="${ecordTypeTwo.order}" data-id="${ecordTypeTwo.id}" data-modelId="${ecordTypeTwo.model}">${ecordTypeTwo.name}</li>
                                                        </c:forEach>
                                                    </ul>
                                                </c:forEach>
                                            </c:forEach>
                                        </div>
                                    </div>
                                   </li>
                                <li class="list-group-item personSelect">
                                    <div class="form-inline">
                                        <div class="form-group">
                                            <label class="row-label" for="userTree_userId" id="person">被问人/辨认人<span  class="required">*</span>：</label>
                                            <input  id="ecordPerson_name" readonly data-rule="required" value=""  type="text">
                                            <input name="personId" id="recordPerson_personId" value="" type="hidden">
                                            <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_TREE_SHOW)%>" data-id="navtab_record3" data-icon="search"   class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="800" data-height="600" data-title="查询"></a>
                                        </div>
                                    </div>
                                  </li>
                                <li class="list-group-item personTable" style="display: none;padding:0;">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th colspan="10">
                                                被辨认人(至少1人)*：&nbsp;<input id="personNum" class="personNum" readonly style="width:50px;text-align:center;"
                                                                  data-rule="required" value=""
                                                                  type="text"> &nbsp;&nbsp;人数
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="10">
                                                <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_TREE_SHOW1)%>" data-id="navtab_record4"    class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="1050" data-height="600" >增加</a>
                                            </th>

                                        </tr>
                                            <tr>
                                                <th>序号</th>
                                                <th>姓名</th>
                                                <th>身份证</th>
                                                <th>居住地址</th>
                                                <th>操作</th>
                                                <th>序号</th>
                                                <th>姓名</th>
                                                <th>身份证</th>
                                                <th>居住地址</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>1 <input type="hidden" class="person_id_1" name="personesId" value=""> </td>
                                            <td class="person_name_1" >张三</td>
                                            <td class="person_idCard_1"></td>
                                            <td class="person_address_1"></td>
                                            <td class="person_btn_1">
                                                <button class="btn btn-blue" type="button">修改</button>
                                                <button class="btn btn-red" type="button" >删除</button>
                                            </td>
                                            <td>5<input type="hidden" class="person_id_5" name="personesId" value=""></td>
                                            <td class="person_name_5"></td>
                                            <td class="person_idCard_5"></td>
                                            <td class="person_address_5"></td>
                                            <td class="person_btn_5"></td>
                                        </tr>
                                        <tr>
                                            <td>2<input type="hidden" class="person_id_2" name="personesId" value=""></td>
                                            <td class="person_name_2"></td>
                                            <td class="person_idCard_2"></td>
                                            <td class="person_address_2"></td>
                                            <td class="person_btn_2"></td>
                                            <td>6</td>
                                            <td class="person_name_6"></td>
                                            <td class="person_idCard_6"></td>
                                            <td class="person_address_6"></td>
                                            <td class="person_btn_6"></td>
                                        </tr>
                                        <tr>
                                            <td>3<input type="hidden" class="person_id_3" name="personesId" value=""></td>
                                            <td class="person_name_3"></td>
                                            <td class="person_idCard_3"></td>
                                            <td class="person_address_3"></td>
                                            <td class="person_btn_3"></td>
                                            <td>7<input type="hidden" class="person_id_7" name="personesId" value=""></td>
                                            <td class="person_name_7"></td>
                                            <td class="person_idCard_7"></td>
                                            <td class="person_address_7"></td>
                                            <td class="person_btn_7"></td>
                                        </tr>
                                        <tr>
                                            <td>4<input type="hidden" class="person_id_4" name="personesId" value=""></td>
                                            <td class="person_name_4"></td>
                                            <td class="person_idCard_4"></td>
                                            <td class="person_address_4"></td>
                                            <td class="person_btn_4"></td>
                                            <td>8<input type="hidden" class="person_id_8" name="personesId" value=""></td>
                                            <td class="person_name_8"></td>
                                            <td class="person_idCard_8"></td>
                                            <td class="person_address_8"></td>
                                            <td class="person_btn_8"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </li>
                            </ul>
                        <div class="bjui-pageFooter navbar-fixed-bottom">
                            <ul>
                                <li>
                                    <button class="btn-close btn" type="button" data-icon="close">
                                        <i class="fa fa-close">取消</i>
                                    </button>
                                </li>
                                <li>
                                    <button class="btn btn-success"  type="submit" data-icon="save" >提交</button>
                                </li>
                            </ul>
                        </div>
                    </form>
                    </div>
        </div>