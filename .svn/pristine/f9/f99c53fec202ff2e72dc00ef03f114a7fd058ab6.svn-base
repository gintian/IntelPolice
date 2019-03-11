
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
            <sys:permission url="<%=Url.getUrl(Url.RECORD_PERSON_SHOW)%>">
                <a href="${root}<%=Url.getUrl(Url.RECORD_PERSON_SHOW)%>?caseid=${criminalBean.caseid}"
                   class="btn btn-green"  data-toggle="dialog" data-mask="true" data-max="true" data-width="1000" data-height="800" data-options="{id:'recordAdd',onClose:function(){opener.location.reload()}}">添加</a>
            </sys:permission>
        </div>
        <!-- Table  RECORD_PERSON_SHOW -->
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
            <c:forEach items="${list}" var="record">
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
    </div>
</div>