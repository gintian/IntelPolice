<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<script>
    function getPerson(personId, name, idCard,address) {
        var isEx = false;
        for(var i = 0; i < personArray.length; i++){
            if(personArray[i] == null){
                isEx = true;
                var person = {'id':personId,'name':name,'idCard':idCard,'address':address,'btn':true};
                personArray[i] = person;
                console.log(person);
                rePersonTable();
                break;
            }
        }
        if(!isEx){
            BJUI.alertmsg('warn', '人员已经满员！', {
            });
        }
    }
</script>
<div class="bjui-pageHeader" style="height: 90px">
  <form id="${searchFormId}" data-toggle="ajaxsearch"
        action="${root}<%=Url.getUrl(Url.RECORD_PERSON_TREE_SHOW1)%>" method="post">
    <div class="bjui-searchBar">
      <label for="name" class="control-label"
             style="margin-left: 0px; padding-left: 0px; width: 60px;">姓名：</label>
      <input name="name" id="name" placeholder="请输入姓名" style="width: 200px;"
             value="${searchObj.name}">
      <label for="idcard" class="control-label"
             style="margin-left: 0px; padding-left: 0px; width: 60px;">身份号：</label>
      <input name="idcard" id="idcard" placeholder="请输入身份号码" style="width: 200px;"
             value="${searchObj.idcard}">
      <label for="bxwrAddr" class="control-label"
             style="margin-left: 0px; padding-left: 0px; width: 60px;">地址：</label>
      <input name="bxwrAddr" id="bxwrAddr" placeholder="请输入居住地址" style="width: 200px;"
             value="${searchObj.bxwrAddr}">
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
         data-icon="undo">清空查询</a>
    </div>
  </form>
</div>
<div class="bjui-pageContent tableContent" style="top: 90px">
  <table class="table table-bordered table-hover table-striped
   table-top data_table table_center" data-selected-multi="true" id="bt" >
    <thead>
    <tr class="line_top">
      <th>操作</th>
      <th align="center">姓名</th>
      <th align="center">身份证号</th>
      <th align="center">人大代表</th>
      <th align="center">居住地址</th>
      <th align="center">联系方式</th>
      <th align="center">创建人</th>
      <th align="center">创建时间</th>
      <th align="center">修改人</th>
      <th align="center">修改时间</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty list}" var="flag">
      <tr><td colspan="10" style="color: #d9534f;"> 暂无数据！</td></tr>
    </c:if>
    <c:if test="${not flag}">
      <c:forEach items="${list}" var="item">
        <tr>
          <td><a onclick="getPerson('${item.personId}', '${item.name}', '${item.idcard}', '${item.bxwrAddr}')" class="btn btn-close"
                 data-toggle="dialog" data-mask="true" data-width="600" data-height="500">选择</a></td>
          <td title="${item.name}"><hs:out value="${item.name}" length="25"/></td>
          <td title="${item.idcard}"><hs:out value="${item.idcard}" length="10"/></td>
          <td ><hs:out value="${item.isrddb eq '0' ? '是' : '否'}" length="15"/></td>
          <td title="${item.bxwrAddr}"><hs:out value="${item.bxwrAddr}" length="5"/></td>
          <td title="${item.bxwrPhone}"><hs:out value="${item.bxwrPhone}" length="5"/></td>
          <td title="${item.addUser}"><hs:user value="${item.addUser}"/></td>
          <td><hs:datefmt value="${item.addTime}" type="dateTimeFormat"/></td>
          <td title="${item.modifyUser}"><hs:user value="${item.modifyUser}"/></td>
          <td><hs:datefmt value="${item.modifyTime}" type="dateTimeFormat"/></td>
        </tr>
      </c:forEach>
    </c:if>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>