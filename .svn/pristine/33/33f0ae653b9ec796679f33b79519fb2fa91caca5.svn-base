<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-hover hw-table-long-input" width="100%">
        <tbody>
        <tr class="info">
          <td align="right">
            <label class="control-label">执行开始时间<span class="required">*</span>：</label>
          </td>
          <td>
            <hs:datefmt value='${entity.syncdate}' type='date'/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">执行结束时间<span class="required">*</span>：</label>
          </td>
          <td>
            <hs:datefmt value='${entity.executiondate}' type='date'/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步类型<span class="required">*</span>：</label>
          </td>
          <td>
            <c:if test="${entity.synctype == 0 || entity.synctype == null}">
              自动
            </c:if>
            <c:if test="${entity.synctype == 0 || entity.synctype == null}">
              手动
            </c:if>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步模块名称<span class="required">*</span>：</label>
          </td>
          <td>
            ${entity.synclable}
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步模块值<span class="required">*</span>：</label>
          </td>
          <td>
            ${entity.syncvalue}
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">是否同步成功<span class="required">*</span>：</label>
          </td>
          <td>
            <c:if test="${entity.syncstatus == '0'}">
                  不成功
            </c:if>
            <c:if test="${entity.syncstatus == '1'}">
                  成功
            </c:if>
            <c:if test="${entity.syncstatus == null}">
              --
            </c:if>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">同步执行详情<span class="required">*</span>：</label>
          </td>
          <td>
            <hs:out value="${entity.executionvalue}" length="200"/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">数据修改开始时间<span class="required">*</span>：</label>
          </td>
          <td >
            <hs:datefmt value='${entity.datestarttime}' type='date'/>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="control-label">数据修改结束时间<span class="required">*</span>：</label>
          </td>
          <td>
            <hs:datefmt value='${entity.dataendtime}' type='date'/>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn btn-close" data-icon="close">取消</button></li>

  </ul>
</div>