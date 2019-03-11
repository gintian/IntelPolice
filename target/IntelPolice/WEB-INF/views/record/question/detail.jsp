<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
      <div class="panel panel-default">
        <ul class="list-group">
          <li class="list-group-item">
            <label for="content" class="control-label" >问题内容：</label>
            <textarea name="content" disabled style="height: 150px;width: 450px;resize: none;" class="form-control"  id="content" type="text">${entity.content}</textarea>
          </li>
          <li class="list-group-item">
            <label  class="control-label" >问题类型：</label>
            <c:if test="${'0' eq entity.type}">
              <span title="询问">询问</span>
            </c:if>
            <c:if test="${'1' eq entity.type}">
              <span title="询问">讯问</span>
            </c:if>
            <c:if test="${'2' eq entity.type}">
              <span title="询问">辩论</span>
            </c:if>
          </li>
          <li class="list-group-item">
            <label  class="control-label" >案件类型：</label>
            <c:forEach items="${codeBeanList}" var="codeBean">
              <c:if test="${codeBean.code eq entity.caseType}">
                <span title="${codeBean.codedesc}">${codeBean.codedesc}</span>
              </c:if>
            </c:forEach>
          </li>
          <li class="list-group-item">
            <label  class="control-label" >创建人员：</label>
            <span><hs:user value="${entity.addUser}"/></span>
          </li>
          <li class="list-group-item">
            <label  class="control-label" >创建时间：</label>
            <span><hs:datefmt value="${entity.addTime}" stringDatePatten="dateTimeFormat"/></span>
          </li>
          <li class="list-group-item">
            <label  class="control-label" >修改时间：</label>
            <span>
              <c:if test="${empty entity.modifyTime}" var="flag">
                --
              </c:if>
              <c:if test="${not flag}" >
                <hs:datefmt value="${entity.modifyTime}" stringDatePatten="dateTimeFormat"/>
              </c:if>
            </span>
          </li>
        </ul>
      </div>
    </div>
</div>
<div class="bjui-pageFooter">
  <ul>
    <li><button type="button" class="btn-close" data-icon="close">取消</button></li>

  </ul>
</div>