
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
            <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_ADD_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_SHOW)%>?caseid=${criminalBean.caseid}"
                   class="btn btn-green"  data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-options="{id:'archiveAdd',onClose:function(){opener.location.reload()}}">添加</a>
            </sys:permission>
        </div>
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
            <c:forEach items="${list}" var="archive">
                <tr>
                    <td>
                        <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_DETAIL_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_DETAIL_SHOW)%>?id=${archive.id}"
                               class="btn btn-green"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500">详情</a>
                        </sys:permission>
                        <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_UPDATE_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_UPDATE_SHOW)%>?id=${archive.id}"
                               class="btn btn-blue"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-title="编辑"  data-options="{id:'archiveUpdate',onClose:function(){opener.location.reload()}}">编辑</a>
                        </sys:permission><br>

                        <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_WARE_SHOW)%>">
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_STORES_BOX_WARE_SHOW)%>?archiveBean.id=${archive.id}&criminalBean.caseid=${criminalBean.caseid}"
                               class="btn btn-blue"
                               data-toggle="dialog" data-mask="true" data-width="600" data-height="500" data-title="入库"  data-options="{id:'archiveUpdate',onClose:function(){opener.location.reload()}}">入库</a>
                        </sys:permission>
                        <sys:permission url="<%=Url.getUrl(Url.ARCHIVE_DELETE_SUBMIT)%>">
                            <a href="${root}<%=Url.getUrl(Url.ARCHIVE_DELETE_SUBMIT)%>?id=${archive.id}"
                               class="btn btn-red"
                               data-toggle="doajax" data-options="{forwardConfirm:true}" data-confirm-msg="确定要删除吗？">删除</a>
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
    </div>
</div>
<script>
    function getName(userId,userName) {
        $.CurrentDialog.find("#userTree_userId").val(userId);
        $.CurrentDialog.find("#userTree_userName").val(userName);
    }
</script>