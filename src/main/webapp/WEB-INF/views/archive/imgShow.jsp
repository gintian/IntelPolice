<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <img  src="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=${imgPath}">
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn-close" data-icon="close">取消</button></li>

  </ul>
</div>