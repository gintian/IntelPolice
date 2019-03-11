<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
    <c:when test="${empty entity or empty entity.id}">
      <form action="${root}<%=Url.getUrl(Url.MEDIA_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
    </c:when>
    <c:otherwise>
      <form action="${root}<%=Url.getUrl(Url.MEDIA_UPDATE_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true" method="post">
        <input type="hidden" name="id" value="${entity.id}">
    </c:otherwise>
  </c:choose>
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
          <tr>
            <td align="right">
              <label class="control-label" for="media_name">名称<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_name" name="name" data-rule="required" maxlength="25" value="${entity.name}" placeholder="请输入名称，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="media_tjrbh">添加人警号<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_tjrbh" name="tjrbh" data-rule="required" maxlength="25" value="${entity.tjrbh}" placeholder="请输入添加人警号，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="media_tjrxm">添加人姓名<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_tjrxm" name="tjrxm" data-rule="required" maxlength="25" value="${entity.tjrxm}" placeholder="请输入添加人姓名，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="media_jlybh">执法记录仪编号<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_jlybh" name="jlybh" data-rule="required" maxlength="25" value="${entity.jlybh}" placeholder="请输入执法记录仪编号，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="media_jldd">记录地点<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_jldd" name="jldd" data-rule="required" maxlength="25" value="${entity.jldd}" placeholder="请输入记录地点，最多25字">
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="media_jlddzb">记录地点坐标<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_jlddzb" name="jlddzb" data-rule="required" maxlength="25" value="${entity.jlddzb}" placeholder="请输入记录地点坐标，最多25字">
            </td>
          </tr>
         <tr>
            <td align="right">
              <label class="control-label" for="media_jlsj">记录时间<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_jlsj" name="jlsj" data-rule="required"
                     data-toggle="datepicker" placeholder="请输入记录时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                     value="<hs:datefmt value="${entity.jlsj}" type="dateTimeSecPattern"/>" />
            </td>
          </tr>
          <tr>
            <td align="right">
              <label class="control-label" for="media_dqsj">到期时间<span class="required">*</span>：</label>
            </td>
            <td>
              <input type="text" id="media_dqsj" name="dqsj" data-rule="required"
                     data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                     value="<hs:datefmt value="${entity.dqsj}" type="dateTimeSecPattern"/>" />
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