
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageHeader">
  <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_PAGE_SHOW)%>" method="post">
    <div class="bjui-searchBar">
     <%-- <label class="row-label">已经同步</label>
      <select name="syncstatus" id="j_custom_sale" data-toggle="selectpicker" data-width="50">
        <option>全部</option>
        <option value="0">是</option>
        <option value="1">否</option>
      </select>--%>
      <label class="row-label">所属模块</label>
      <select name="syncvalue" data-toggle="selectpicker" data-width="300">
        <option value="">请选择</option>
        <option value="<%=CommonConstant.SYSNC_BPIP%>" <c:if test="${searchObj.syncvalue == 'unit'}">selected</c:if>>部门</option>
        <option value="user" <c:if test="${searchObj.syncvalue == 'user'}">selected</c:if>>用户</option>
        <option value="police" <c:if test="${searchObj.syncvalue == 'police'}">selected</c:if>>110</option>
        <option value="case" <c:if test="${searchObj.syncvalue == 'case'}">selected</c:if>>案事件</option>
        <option value="doc" <c:if test="${searchObj.syncvalue == 'doc'}">selected</c:if>>文书</option>
        <option value="humiture" <c:if test="${searchObj.syncvalue == 'humiture'}">selected</c:if>>温湿度计</option>
        <option value="investigation" <c:if test="${searchObj.syncvalue == 'investigation'}">selected</c:if>>受立案监督</option>
        <option value="code" <c:if test="${searchObj.syncvalue == 'code'}">selected</c:if>>code</option>
        <option value="durg" <c:if test="${searchObj.syncvalue == 'durg'}">selected</c:if>>毒品</option>
        <option value="smslog" <c:if test="${searchObj.syncvalue == 'smslog'}">selected</c:if>>信息</option>
      </select>
      <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
        <i class="fa fa-angle-double-down"></i>
      </button>
  <%--    <div class="bjui-moreSearch">
        &lt;%&ndash;<label for="media_jlsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">记录时间：</label>
        <input type="text" id="media_jlsj" name="jlsj" data-rule="required"
               data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
               value="<hs:datefmt value="${searchObj.jlsj}" type="date"/>" />
        <label for="media_dqsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">到期时间：</label>
        <input type="text" id="media_dqsj" name="dqsj" data-rule="required"
               data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
               value="<hs:datefmt value="${searchObj.dqsj}" type="date"/>" />&ndash;%&gt;

      </div>--%>
      <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
      <a class="btn btn-orange reset" href="javascript:;"
         data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
      <div class="pull-right">
      </div>
    </div>
  </form>
</div>
<div class="bjui-pageContent tableContent">
  <table class="table table-bordered table-hover table-striped table-top data_table table_center"  data-selected-multi="true">
    <thead>
    <tr class="line_top">
      <th>操作</th>
      <th>模块名称</th>
      <th>模块值</th>
      <th>准备执行时间</th>
      <th>开始执行时间</th>
      <th>结束执行时间</th>
      <th>同步类型</th>
      <th>成功</th>
      <th>执行详情</th>
      <th>数据库同步开始日期</th>
      <th>数据库同步结束日期</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
      <tr>
        <td class="option">
          <sys:permission url="<%=Url.getUrl(Url.DATA_SYNCTASK_DETAIL_SHOW)%>">
            <a href="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_DETAIL_SHOW)%>?Id=${item.id}" class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600" data-height="500"  data-confirm-msg="详情">详情</a>
          </sys:permission>
        </td>
        <td title="${item.synclable}"><hs:out value="${item.synclable}" length="5"/></td>
        <td title="${item.syncvalue}">
          <hs:out value="${item.syncvalue}" length="10"/>
        </td>
        <td title="${item.syncdate}"><hs:datefmt value="${item.syncdate}" type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss"/></td>
        <td title="${item.executionstartdate}"><hs:datefmt value="${item.executionstartdate}" type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss"/></td>
        <td title="${item.executiondate}"><hs:datefmt value="${item.executiondate}" type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss"/></td>
        <td>
          <c:choose>
            <c:when  test="${item.synctype == 0}">
              自动同步
            </c:when>
            <c:when  test="${item.synctype == 1}">
              手动同步
            </c:when>
          </c:choose>
        </td>
        <td title="${item.syncstatus}">
          <c:if test="${item.syncstatus == '0'}">
          不成功
        </c:if>
          <c:if test="${item.syncstatus == '1'}">
            成功
          </c:if>
        </td>
        <td title="${item.executionvalue}"><hs:out value="${item.executionvalue}" length="10"/></td>
        <td title="${item.datestarttime}">
          <hs:datefmt value="${item.datestarttime}" type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss" />
        </td>
        <td title="${item.dataendtime}">
          <hs:datefmt value="${item.dataendtime}" type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
