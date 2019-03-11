<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" for="dictory_label">上传文件<span class="required">*</span>：</label>
            </td>
            <td>
              <input data-name="filePath" id="dictory_label" data-rule="required" data-toggle="webuploader" data-options="
                {
                    pick: {label: '点击选择文件'},
                    server: '${root}<%=Url.getUrl(Url.ACTIVITI_ADD_SUBMIT)%>',
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

    <li><a href="${root}<%=Url.getUrl(Url.ACTIVITI_PAGE_SHOW)%>"type="submit" onclick="BJUI.navtab('reload', 'menu01010201')" class="btn-close" data-icon="close">确定</a></li>
  </ul>
</div>