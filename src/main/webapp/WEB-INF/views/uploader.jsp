<%--
  Created by IntelliJ IDEA.
  User: OnJuly
  Date: 2018/5/24
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <form action="" id="upload" data-toggle="validate">
        <td align="right">
            <label class="control-label" for="dictory_label">上传文件：</label>
        </td>
        <td>
            <input data-name="filePath" type="file" id="dictory_label" data-toggle="webuploader"
                   data-options="
                {
                    pick: {label: '点击选择文件'},
                    server: '${root}<%=Url.getUrl(Url.FILE_UPLOAD)%>',
                    fileNumLimit: 1,
                    formData: {dir:'filesFile'},
                    required: true,
                    uploaded: '',
                    basePath: '',
                    accept: {
                        title: '*',
                        extensions: '.*',
                        mimeTypes: '.*'
                    },
                }">
        </td>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button class="btn-close btn" type="button" data-icon="close">
                <i class="fa fa-close">取消</i>
            </button>
        </li>
        <li>
            <%--<a href="${root}<%=Url.getUrl(Url.FILES_ADD_DETAIL_SHOW)%>?currentType=${currentType}"--%>
            <%--data-toggle="navtab" class="btn btn-close"--%>
            <%--data-id="navtab" data-title="填写文件信息">填写文件信息</a>--%>
            <%--<a onclick="alert('${name}')">as</a>--%>
            <%--&name=${name}&size=${size}&path=${path}--%>
            <%--<button class="btn btn-close" data-icon="save"--%>
                    <%--onclick="BJUI.dialog('reload', 'fileAdd')">--%>
                <%--继续填写信息--%>
            <%--</button>--%>
                <a href="${root}<%=Url.getUrl(Url.FILES_ADD_DETAIL_SHOW)%>?currentType=${currentType}"
                   data-toggle="dialog" class="btn btn-close" data-width="600" data-height="400"
                   data-id="dialog" data-title="上传" style="width: 100px">填写其他信息</a>
        </li>
    </ul>
</div>