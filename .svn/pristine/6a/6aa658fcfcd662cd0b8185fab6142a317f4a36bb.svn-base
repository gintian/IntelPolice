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
        <td align="right">
            <label class="control-label" for="dictory_label">上传文件：</label>
        </td>
        <td>
            <input data-name="filePath" type="file" id="dictory_label" data-toggle="webuploader"
                   data-options="
                {
                    pick: {label: '点击选择文件'},
                    server: '${root}<%=Url.getUrl(Url.FILE_UPLOAD)%>',
                    <%--fileNumLimit: 1,--%>
                    formData: {dir:'filesFile'},
                    required: true,
                     threads:'1',        //同时运行1个线程传输
                    uploaded: '',
                    basePath: '',
                    accept: {
                        title: '*',
                        extensions: 'gif,jpg,jpeg,bmp,png',
                        mimeTypes: 'img/*'
                    },
                }">
        </td>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button class="btn-close btn" type="button" data-icon="close">
                <i class="fa fa-close">取消</i>
            </button>
        </li>
        <li>
                <a href="${root}<%=Url.getUrl(Url.ARCHIVE_ADD_DETAIL_SHOW)%>?caseid=${caseid}&entity=${entity}"
                   data-toggle="dialog" class="btn btn-primary" data-width="800" data-height="600"
                    data-title="添加" >填写其他信息</a>
        </li>
    </ul>
</div>