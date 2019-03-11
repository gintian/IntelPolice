<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
  <c:choose>
  <c:when test="${empty entity or empty entity.id}">
  <form action="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_ADD_SUBMIT)%>" data-toggle="validate" data-reload-navtab="true"
        method="post">
    </c:when>
    <c:otherwise>
    <form action="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_UPDATE_SUBMIT)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
      <input type="hidden" name="id" value="${entity.id}">
      </c:otherwise>
      </c:choose>

    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr>
          <td align="right">
            <label class="control-label">开始执行时间<span class="required">*</span>：</label>
          </td>
          <td>
            <input type="text" name="syncdate" data-rule="required" value="<hs:datefmt value='${entity.syncdate}' type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss"/>"
                   data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:00"
                   type="date"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步类型<span class="required">*</span>：</label>
          </td>
          <td>
            <input name="synctype" data-toggle="icheck" value="0" data-rule="checked" <c:if test="${entity.synctype == 0 || entity.synctype == null}">checked</c:if> data-label="自动" type="radio">
            <input name="synctype" data-toggle="icheck" value="1" <c:if test="${entity.synctype == 1}">checked</c:if> data-label="手动" type="radio">
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步模块名称<span class="required">*</span>：</label>
          </td>
          <td>
            <input type="text" name="synclable" value="${entity.synclable}" data-rule="required" size="30" maxlength="25 placeholder="请输入同步模块名称，最多25字">
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步模块值<span class="required">*</span>：</label>
          </td>
          <td>
            <select name="syncvalue" data-toggle="selectpicker" data-rule="required">
              <option value="unit" <c:if test="${entity.syncvalue == 'unit' || entity == null}">selected</c:if>>部门</option>
              <option value="user" <c:if test="${entity.syncvalue == 'user'}">selected</c:if>>用户</option>
              <option value="police" <c:if test="${entity.syncvalue == 'police'}">selected</c:if>>110</option>
              <option value="case" <c:if test="${entity.syncvalue == 'case'}">selected</c:if>>案事件</option>
              <option value="doc" <c:if test="${entity.syncvalue == 'doc'}">selected</c:if>>文书</option>
              <option value="humiture" <c:if test="${entity.syncvalue == 'humiture'}">selected</c:if>>温湿度计</option>
              <option value="investigation" <c:if test="${entity.syncvalue == 'investigation'}">selected</c:if>>受立案监督</option>
              <option value="code" <c:if test="${entity.syncvalue == 'code'}">selected</c:if>>code</option>
              <option value="durg" <c:if test="${entity.syncvalue == 'durg'}">selected</c:if>>毒品</option>
              <option value="smslog" <c:if test="${entity.syncvalue == 'smslog'}">selected</c:if>>信息</option>
            </select>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">数据开始修改时间<span class="required">*</span>：</label>
          </td>
          <td>
            <input type="text" name="datestarttime" data-rule="required" value="<hs:datefmt value='${entity.datestarttime}' type="date" stringDatePatten="yyyy-MM-dd HH:mm:ss"/>"
                   data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                   type="date"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">数据开始结束时间：</label>
          </td>
          <td>
            <input type="text" name="dataendtime" value="<hs:datefmt value='${entity.dataendtime}' type='date' stringDatePatten="yyyy-MM-dd HH:mm:ss"/>"
                   data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                   type="date"/>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </form>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><a href="${root}<%=Url.getUrl(Url.DATA_SYNCTASK_PAGE_SHOW)%>"type="submit" class="btn btn-close" data-icon="close">取消</a></li>
    <li><button type="submit" class="btn btn-success" data-icon="save">保存</button></li>
  </ul>
</div>