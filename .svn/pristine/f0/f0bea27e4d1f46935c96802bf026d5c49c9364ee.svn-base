
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" data-options="{progressmsg:'正在努力加载数据，请稍等...'}" action="${root}<%=Url.getUrl(Url.ONEKEYQUERY_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
      <div style="float: left">
        查询类型：
        <select name="type" style="width:150px;" data-toggle="selectpicker">
          <option value="0" ${type eq '0' ? 'selected': ''}>案件</option>
          <option value="1" ${type eq '1' ? 'selected': ''}>接警</option>
          <option value="2" ${type eq '2' ? 'selected': ''}>处警</option>
        </select>
      </div>
      <div style="float: left">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <label for="title" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">编号：</label>
        <input name="code" id="title" placeholder="请输入编号" style="width: 400px;" value="${code}">
        &nbsp;&nbsp;&nbsp;&nbsp;
      </div>
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
    </div>
  </form>
</div>

<div class="bjui-pageContent tableContent">

  <div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">接警</div>
    <c:if test="${not empty message}">
      <c:if test="${not empty jjBean and not empty jjBean.jjdbh}" var="flag">
        <!-- Table -->
        <table
                class="table table-bordered table-hover table-striped table-top data_table table_center"
                data-selected-multi="true">
          <thead>
          <tr class="line_top">
            <th align="center">操作</th>
            <th align="center">行政区划代码</th>
            <th align="center">接警单编号</th>
            <th align="center">报警时间</th>
            <th align="center">接警时间</th>
            <th align="center">报警人姓名</th>
            <th align="center">报警电话</th>
            <th align="center">警情地址</th>
            <th align="center">报警内容</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td class="option" align="center"><a
                    href="${root}<%=Url.getUrl(Url.JJ_DETAIL_SHOW)%>?jjdbh=${jjBean.jjdbh}"
                    class="btn btn-green" data-toggle="dialog" data-mask="true"
                    data-width="800" data-height="500">详情</a></td>
            <td title="${jjBean.xzqhdm}" align="center"><hs:out
                    value="${jjBean.xzqhdm}" length="10" /></td>
            <td title="${jjBean.jjdbh}"><hs:out value="${jjBean.jjdbh}"
                                                length="15" /></td>
            <td title="${jjBean.bjsj }" align="center"><hs:datefmt
                    value="${jjBean.bjsj}" stringDatePatten="dateTimeFormat" /></td>
            <td title="${jjBean.jjsj}" align="center"><hs:datefmt
                    value="${jjBean.jjsj}" stringDatePatten="dateTimeFormat" /></td>
            <td title="${jjBean.bjrxm}" align="center"><hs:out
                    value="${jjBean.bjrxm}" length="5" /></td>
            <td title="${jjBean.bjdh}" align="center"><hs:out
                    value="${jjBean.bjdh}" length="13" /></td>
            <td title="${jjBean.jqdz}" align="center"><hs:out
                    value="${jjBean.jqdz}" length="10" /></td>
            <td title="${jjBean.bjnr}" align="center"><hs:out
                    value="${jjBean.bjnr}" length="10" /></td>
          </tr>
          </tbody>
        </table>
      </c:if>
      <c:if test="${not flag}" >
        ${message}
      </c:if>
    </c:if>
  </div>

  <div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">处警</div>
    <c:if test="${not empty message}">
      <c:if test="${not empty cjBean and not empty cjBean.cjdbh}" var="flag">
        <!-- Table -->
        <table
                class="table table-bordered table-hover table-striped table-top data_table table_center"
                data-selected-multi="true">
          <thead>
          <tr class="line_top">
            <th align="center">操作</th>
            <th align="center">行政区划代码</th>
            <th align="center">处警单编号</th>
            <th align="center">接警单编号</th>
            <th align="center">处警单位代码</th>
            <th align="center">处警员编号</th>
            <th align="center">处警时间</th>
            <th align="center">处警意见</th>
            <th align="center">警情状态代码</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td class="option" align="center"><a
                    href="${root}<%=Url.getUrl(Url.CJ_DETAIL_SHOW)%>?cjdbh=${cjBean.cjdbh}"
                    class="btn btn-green" data-toggle="dialog" data-mask="true"
                    data-width="800" data-height="500">详情</a></td>
            <td title="${cjBean.xzqhdm}" align="center"><hs:out
                    value="${cjBean.xzqhdm}" length="10" /></td>
            <td title="${cjBean.cjdbh}"><hs:out value="${cjBean.cjdbh}"
                                                length="20" /></td>
            <td title="${cjBean.jjdbh}"><hs:out value="${cjBean.jjdbh}"
                                                length="20" /></td>
            <td title="${cjBean.cjdwdm}"><hs:out value="${cjBean.cjdwdm}"
                                                 length="10" /></td>
            <td title="${cjBean.cjybh}" align="center"><hs:out
                    value="${cjBean.cjybh}" length="10" /></td>
            <td title="${cjBean.cjsj}" align="center"><hs:datefmt
                    value="${cjBean.cjsj}" stringDatePatten="dateTimeFormat" /></td>
            <td title="${cjBean.cjyj}" align="center"><hs:out
                    value="${cjBean.cjyj}" length="5" /></td>
            <td title="${cjBean.jqztdm}" align="center"><hs:out
                    value="${cjBean.jqztdm}" length="5" /></td>
          </tr>
          </tbody>
        </table>
      </c:if>
      <c:if test="${not flag}" >
        ${message}
      </c:if>
    </c:if>

  </div>

  <div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">案件</div>
    <c:if test="${not empty message}">
      <c:if test="${not empty criminalBean and not empty criminalBean.caseid}" var="flag">
        <!-- Table -->
        <table
                class="table table-bordered table-hover table-striped table-top data_table table_center"
                data-selected-multi="true">
          <thead>
          <tr class="line_top">
            <th width="50" align="center">操作</th>
            <th width="70" align="center">案件编号</th>
            <th width="100" align="center">案件名称</th>
            <th width="70" align="center">案件文号</th>
            <th width="80" align="center">案件类型</th>
            <th width="100" align="center">案件地址</th>
            <th width="40" align="center">案情状况</th>
            <th width="70" align="center">案情开始时间</th>
            <th width="70" align="center">案情结束时间</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td class="option" align="center">
              <sys:permission url="<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.CRIMINAL_DETAIL_SHOW)%>?caseid=${criminalBean.caseid}"
                   class="btn btn-green" data-toggle="dialog" data-mask="true"
                   data-width="800" data-height="500">详情</a>
              </sys:permission>
            </td>
            <td title="${criminalBean.caseid}"><hs:out
                    value="${criminalBean.caseid}" length="5"/></td>
            <td title="${criminalBean.casename}"><hs:out
                    value="${criminalBean.casename}"/></td>
            <td title="${criminalBean.casewhid}" align="center"><hs:out
                    value="${criminalBean.casewhid}" length="5"/></td>
            <td title="${criminalBean.caseclass}" align="center"><c:choose>
              <c:when test="${criminalBean.caseclass == 1}">
                接处警
              </c:when>
              <c:when test="${criminalBean.caseclass == 2}">
                一般刑事
              </c:when>
              <c:when test="${criminalBean.caseclass == 3}">
                经济案件
              </c:when>
              <c:when test="${criminalBean.caseclass == 4}">
                毒品案件
              </c:when>
              <c:when test="${criminalBean.caseclass == 5}">
                一般刑事
              </c:when>
              <c:when test="${criminalBean.caseclass == 6}">
                一般刑事
              </c:when>
              <c:otherwise>
                其他类型
              </c:otherwise>
            </c:choose></td>
            <td title="${criminalBean.caseaddress}"><hs:out
                    value="${criminalBean.caseaddress}"/></td>
            <td title="${criminalBean.casestate}" align="center"><hs:out
                    value="${criminalBean.casestate}"/></td>
            <td title="${criminalBean.casetimestart}" align="center"><hs:datefmt
                    value="${criminalBean.casetimestart}" stringDatePatten="dataTimeFormat"/></td>
            <td title="${criminalBean.casetimeend}" align="center"><hs:datefmt
                    value="${criminalBean.casetimeend}" stringDatePatten="dataTimeFormat"/></td>
          </tr>
          </tbody>
        </table>
      </c:if>
      <c:if test="${not flag}" >
        ${message}
      </c:if>
    </c:if>

  </div>

  <div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">笔录</div>
    <c:if test="${not empty message}">
      <c:if test="${not empty recordBeanList}" var="flag">
        <!-- Table -->
        <table class="table table-bordered">
          <thead>
          <tr>
            <th>操作</th>
            <th>笔录编号</th>
            <th>询问人</th>
              <%--<th>询问单位</th>--%>
            <th>笔录人</th>
              <%--<th>笔录内容</th>--%>
            <th>笔录时间</th>
            <th>笔录类型</th>
            <th>询问/讯问人</th>
            <th>辨认人</th>
            <th>被辨认人1</th>
            <th>被辨认人2</th>
            <th>被辨认人3</th>
            <th>被辨认人4</th>
            <th>被辨认人5</th>
            <th>被辨认人6</th>
            <th>被辨认人7</th>
            <th>被辨认人8</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${recordBeanList}" var="record">
            <tr>
              <td>
                <sys:permission url="<%=Url.getUrl(Url.RECORD_MESSSAGEMANAGE_DETAIL_SHOW)%>">
                  <a href="${root}<%=Url.getUrl(Url.RECORD_MESSSAGEMANAGE_DETAIL_SHOW)%>?id=${record.id}&modelId=${empty record.brr ? '001' : '002'}&caseId=${criminalBean.caseid}"
                     class="btn btn-green"
                     data-toggle="dialog" data-mask="true" data-max="true" data-width="1000" data-height="900">详情</a>
                </sys:permission>
                  <%--                        <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_UPDATE_SHOW)%>">
                                              <a href="${root}<%=Url.getUrl(Url.ARCHIVE_UPDATE_SHOW)%>?id=${record.id}"
                                                 class="btn btn-blue"
                                                 data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-title="编辑"  data-options="{id:'archiveUpdate',onClose:function(){opener.location.reload()}}">编辑</a>
                                          </sys:permission><br>--%>
                  <%--<sys:permission url="<%=Url.getUrl(Url.ARCHIVE_DELETE_SUBMIT)%>">
                      <a href="${root}<%=Url.getUrl(Url.ARCHIVE_DELETE_SUBMIT)%>?id=${record.id}"
                         class="btn btn-red"
                         data-toggle="doajax" data-options="{forwardConfirm:true}" data-confirm-msg="确定要删除吗？">删除</a>
                  </sys:permission>--%>
              </td>
              <td title="${record.code}"><hs:out value="${record.code}" length="10" /></td>
              <td><hs:user value="${record.xwrId}" /></td>
                <%--<td >--</td>--%>
              <td><hs:user value="${record.blryId}" /></td>
                <%--<td title="${record.recordContent}"><hs:out value="${record.recordContent}" length="5"/></td>--%>
              <td><hs:datefmt value="${record.blsj}" stringDatePatten="dataTimeFormat"/></td>
              <td><hs:recordType value="${record.recordType}" /></td>
              <td>
                <hs:recordPerson value="${record.bxwr}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.brr}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr1}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr2}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr3}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr4}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr5}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr6}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr7}"/>
              </td>
              <td>
                <hs:recordPerson value="${record.bbrr8}"/>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
      <c:if test="${not flag}" >
        ${message}
      </c:if>
    </c:if>

  </div>

  <div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">财物</div>
    <c:if test="${not empty message}">
      <c:if test="${not empty involvedBeanList}" var="flag">
        <!-- Table -->
        <table class="table table-bordered table-hover table-striped table-top data_table table_center"
               data-selected-multi="true" style="font-size:14px;">
          <thead>
          <tr class="line_top">
            <th>操作</th>
            <th>财物编码</th>
            <th>财物名称</th>
            <th>登记时间</th>
            <th>财物分类</th>
            <th>财物物主</th>
            <th>是否经过保管审批</th>
            <th>保管到期时间</th>
            <th>财物是否涉案</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${involvedBeanList}" var="item">
            <tr>
              <td class="option">
                <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}"
                   class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                   data-height="500" data-confirm-msg="详情">详情</a>
              </td>
              <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5"/></td>
              <td title="${item.cwmc}"><hs:out value="${item.cwmc}"/></td>
              <td><hs:datefmt value="${item.djsj}" stringDatePatten="dateTimeFormat"/></td>
              <td title="${item.cwflCode}"><hs:involvedType value="${item.cwflCode}"/></td>
              <td title="${item.cwwz}"><hs:out value="${item.cwwz}"/></td>
              <td title="${item.isBgsp}" align="center"><hs:out value="${item.isBgsp eq '0' ? '未通过': item.isBgsp eq '1' ? '本单位保管':'警务保障室保管'}"/></td>
              <td><hs:datefmt value="${item.bgdqsj}" stringDatePatten="dateTimeFormat"/></td>
              <td title="${item.isSa}" align="center"><hs:out value="${item.isSa eq '0' ? '否':'是'}"/></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
      <c:if test="${not flag}" >
        ${message}
      </c:if>
    </c:if>


  </div>

  <div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">卷宗</div>
    <c:if test="${not empty message}">
      <c:if test="${not empty archiveBeanList}" var="flag">
        <!-- Table -->
        <table class="table table-bordered">
          <thead>
          <tr>
            <th>操作</th>
            <th>卷宗编号</th>
            <th>卷宗名称</th>
            <th>卷宗类型</th>
            <th>卷宗数量</th>
            <th>卷宗分类</th>
            <th>登记人员</th>
            <th>登记时间</th>
            <th>修改时间</th>
            <th>备注</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${archiveBeanList}" var="archive">
            <tr>
              <td>
                <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_DETAIL_SHOW)%>">
                  <a href="${root}<%=Url.getUrl(Url.ARCHIVE_DETAIL_SHOW)%>?id=${archive.id}"
                     class="btn btn-green"
                     data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                </sys:permission>
              </td>
              <td title="${archive.code}"><hs:out value="${archive.code}" length="5" /></td>
              <td title="${archive.name}"><hs:out value="${archive.name}" length="5"/></td>
              <td title="${archive.type eq '0' ? '电子卷宗' : '实体卷宗'}"><hs:out value="${archive.type eq '0' ? '电子卷宗' : '实体卷宗'}" length="5"/></td>
              <td title="${archive.num}"><hs:out value="${archive.num}" length="5"/></td>
              <td title="${archive.caseid}"><hs:out value="${archive.caseid}" length="5"/></td>
              <td title="${archive.userName}"><hs:out value="${archive.userName}" length="5"/></td>
              <td title="<hs:datefmt value="${archive.addTime}" stringDatePatten="dataTimeFormat"/>"><hs:datefmt value="${archive.addTime}" stringDatePatten="dataTimeFormat"/></td>
              <td title="<hs:datefmt value="${archive.editTime}" stringDatePatten="dataTimeFormat"/>"><hs:datefmt value="${archive.editTime}" stringDatePatten="dataTimeFormat"/></td>
              <td title="${archive.remark}"><hs:out value="${archive.remark}" length="5"/></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
      <c:if test="${not flag}" >
        ${message}
      </c:if>
    </c:if>

  </div>
</div>
<c:if test="${not empty message}">
  <script>
      BJUI.alertmsg('ok', '查询成功！')
  </script>
</c:if>