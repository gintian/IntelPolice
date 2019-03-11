<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
      <form id="${searchFormId}" action="${root}<%=Url.getUrl(Url.MEDIA_FILE_SUBMIT)%>" data-toggle="validate"
            enctype="multipart/form-data" data-reload-navtab="true" method="post">
      <input type="hidden" name="id" value="${entity.id}">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" >文件上传<span class="required">*</span>：</label>
            </td>
            <td>

                <input data-name="filePath" data-rule="required" data-toggle="webuploader" data-options="
                {
                    pick: {label: '点击选择文件'},
                    server: '${root}<%=Url.getUrl(Url.FILE_UPLOAD)%>',
                    fileNumLimit: 1,
                    formData: {dir:'custompic'},
                    required: true,
                    uploaded: '',
                    basePath: '',
                    accept: {
                        title: '文件',
                        extensions: '.*',
                        mimeTypes: '.*'
                    }
                }" type="file">
              </td>
          </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.MEDIA_PAGE_SHOW)%>"type="submit" class="btn btn-close" data-icon="close">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>