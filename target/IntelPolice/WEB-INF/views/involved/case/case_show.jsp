
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="panel panel-primary">
    <!-- Default panel contents -->
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-6" title="${criminalBean.caseid}">
                案事件编码：<hs:out value=" ${criminalBean.caseid}" length="30" />
            </div>
            <div class="col-md-6" title="${criminalBean.casename}">
                案事件名称： <hs:out value=" ${criminalBean.casename}" length="30" />
            </div>
        </div>
    </div>
    <div class="panel-body">
        <div class="well" style="text-indent: 2em;" title="${criminalBean.disposedetails}"><hs:out value="${criminalBean.disposedetails}" length="150" /></div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_ADD_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_ADD_SHOW)%>?caseid=${criminalBean.caseid}"
                   class="btn btn-green"  data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-options="{id:'archiveAdd',onClose:function(){opener.location.reload()}}">添加</a>
            </sys:permission>
        </div>
        <!-- Table -->
        <table class="table table-bordered">
            <thead>
                <tr>
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
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>
                        <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}"
                               class="btn btn-green"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                        </sys:permission>
                        <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SHOW)%>?id=${item.id}"
                               class="btn btn-blue"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-title="编辑"  data-options="{id:'involvedUpdate',onClose:function(){opener.location.reload()}}">编辑</a>
                        </sys:permission><br>

                        <sys:permission url="<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_START_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_START_SHOW)%>?involvedId=${item.id}"
                               class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="600"
                               data-height="500" data-confirm-msg="申请保管">申请保管</a>
                        </sys:permission>
                        <sys:permission url="<%=Url.getUrl(Url.INVOLVED_INFOS_DELETE_SUBMIT)%>">
                            <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DELETE_SUBMIT)%>?id=${item.id}"
                               class="btn btn-red"
                               data-toggle="doajax" data-options="{forwardConfirm:true}" data-confirm-msg="确定要删除吗？">删除</a>
                        </sys:permission>
                    </td>
                    <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5" /></td>
                    <td title="${item.cwmc}"><hs:out value="${item.cwmc}" length="5"/></td>
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
    </div>
</div>
<script>
    function getName(userId,userName) {
        $.CurrentDialog.find("#userTree_userId").val(userId);
        $.CurrentDialog.find("#userTree_userName").val(userName);
    }
</script>