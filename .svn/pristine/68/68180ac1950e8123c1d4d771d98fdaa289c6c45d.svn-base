<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <table class="table table-bordered" width="100%">
        <tbody>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">卷宗编号：</label>
          </td>
          <td>
            ${entity.code}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">卷宗名称：</label>
          </td>
          <td>
            ${entity.name}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">卷宗类型：</label>
          </td>
          <td>
            ${entity.type == "0" ? "电子卷宗" : "实体卷宗"}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">卷宗分类：</label>
          </td>
          <td>
            ${empty entity.businessType ? "--" :  entity.businessType}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">卷宗数量：</label>
          </td>
          <td>
            ${entity.num}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">登记人员：</label>
          </td>
          <td>
            ${entity.userId}
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">登记时间：</label>
          </td>
          <td>
            <hs:datefmt value="${entity.addTime}" type="dateTimeFormat"/>
          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">修改时间：</label>
          </td>
          <td>
            <c:if test="${empty entity.editTime}" var="flag" >
              --
            </c:if>
            <c:if test="${not flag}">
              <hs:datefmt value="entity.editTime" type="dateTimeFormat"/>
            </c:if>

          </td>
        </tr>
        <tr>
          <td align="right" width="150px">
            <label class="control-label">备注：</label>
          </td>
          <td>
            ${entity.remark}
          </td>
        </tr>
        </tbody>
      </table>
    </div>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn-close" data-icon="close">取消</button></li>

  </ul>
</div>