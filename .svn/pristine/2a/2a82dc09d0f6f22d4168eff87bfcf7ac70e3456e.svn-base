<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageHeader">
    <form id="${searchFormId}" data-toggle="ajaxsearch" action="${root}<%=Url.getUrl(Url.MEDIA_PAGE_SHOW)%>"
          method="post">
        <div class="bjui-searchBar">
            <label for="name" class="control-label" style="margin-left: 0px;padding-left: 0px;width:60px;">名称：</label>
            <input name="name" id="name" placeholder="请输入名称" style="width: 200px;" value="${searchObj.name}">
            <button type="button" class="showMoreSearch" data-toggle="moresearch" data-name="custom">
                <i class="fa fa-angle-double-down"></i>
            </button>
            <%-- <div class="bjui-moreSearch">
               <label for="media_jlsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">记录时间：</label>
               <input type="text" id="media_jlsj" name="jlsj" data-rule="required"
                      data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                      value="<hs:datefmt value="${searchObj.jlsj}" type="dateTimeSecPattern"/>" />
               <label for="media_dqsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">到期时间：</label>
               <input type="text" id="media_dqsj" name="dqsj" data-rule="required"
                      data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                      value="<hs:datefmt value="${searchObj.dqsj}" type="dateTimeSecPattern"/>" />
             </div>--%>
            <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询</button>
            <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true"
               data-icon="undo">清空查询</a>


            <div class="pull-right">
                <sys:permission url="<%=Url.getUrl(Url.MEDIA_ADD_SHOW)%>">
                    <a href="${root}<%=Url.getUrl(Url.MEDIA_ADD_SHOW)%>" class="btn btn-blue" data-toggle="dialog"
                       data-mask="true" data-width="500" data-height="500" data-title="新增">新增</a>
                </sys:permission>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
           data-selected-multi="true">
        <thead>
        <tr class="line_top">
            <th align="center">操作</th>
            <th>名称</th>
            <th>添加人警号</th>
            <th>添加人姓名</th>
            <th>文件类型</th>
            <th>上传时间</th>
            <th>拍摄时间</th>
            <th>到期时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td class="option" align="center">
                    <sys:permission url="<%=Url.getUrl(Url.VIEWDOC_CORRELATE_SUBMIT)%>">
                        <a href="${root}<%=Url.getUrl(Url.VIEWDOC_CORRELATE_SUBMIT)%>?docId=${item.docId}&jjdbh=${jjdbh}&cjdbh=${cjdbh}&caseid=${caseid}"
                           class="btn btn-green"
                           data-toggle="dialog" data-mask="true" data-width="600" data-height="500"
                           data-confirm-msg="关联"
                           onclick="dialog_onClose()">关联1</a>
                    </sys:permission>


                </td>
                <td title="${item.docName}"><hs:out value="${item.docName}" length="5"/></td>
                <td title="${item.policeId}"><hs:out value="${item.policeId}" length="5"/></td>
                <td title="${item.name}"><hs:out value="${item.name}" length="5"/></td>
                <td title="${item.cate}"><hs:code value="${item.cate}" field="JVD_CATE"/></td>
                <td><hs:datefmt value="${item.uploadTime}" stringDatePatten="dateTimeFormat"/></td>
                <td><hs:datefmt value="${item.createTime}" stringDatePatten="dateTimeFormat"/></td>
                <td><hs:datefmt value="${item.explryTime}" stringDatePatten="dateTimeFormat"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>