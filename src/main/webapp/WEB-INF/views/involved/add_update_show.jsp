<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <c:choose>
    <c:when test="${empty entity or empty entity.id}">
    <form action="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_ADD_SUBMIT)%>" data-toggle="validate"
          data-reload-navtab="true" method="post">
        <input type="hidden" id="djsj" name="djsj" value="${currentTime}"/>
        <input type="hidden" id="caseid" name="caseid" value="${caseid}"/>
        </c:when>
        <c:otherwise>
        <form action="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SUBMIT)%>" data-toggle="validate"
              data-reload-navtab="true" method="post">
            <input type="hidden" name="id" value="${entity.id}">
            </c:otherwise>
            </c:choose>
            <div class="pageFormContent" data-layout-h="0">
                <table class="table table-hover hw-table-long-input" width="100%">
                    <tbody>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="objId">案事件系统财物序号<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="objId" name="objId" data-rule="required" maxlength="3000"
                                   value="${entity.objId}" placeholder="请输入案事件系统财物序号">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="cwmc">财物名称<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="cwmc" name="cwmc" data-rule="required" maxlength="100"
                                   value="${entity.cwmc}" placeholder="请输入财物名称，最多100字">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="cwflCode">财物分类<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="cwflCode" name="cwflCode" data-rule="required" maxlength="25"
                                   value="${entity.cwflCode}" placeholder="请输入财物分类，最多30字">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="kyyy">扣押原因<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="kyyy" name="kyyy" data-rule="required" maxlength="2000"
                                   value="${entity.kyyy}" placeholder="请输入扣押原因，最多2000字">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="cwwz">财务物主<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="cwwz" name="cwwz" data-rule="required" maxlength="25"
                                   value="${entity.cwwz}" placeholder="请输入财务物主，最多25字">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="wzxx">物主信息<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="wzxx" name="wzxx" data-rule="required" maxlength="1000"
                                   value="${entity.wzxx}" placeholder="请输入物主信息，最多1000字">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="cwsl">物品数量<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="cwsl" name="cwsl" data-rule="required" maxlength="25"
                                   value="${entity.cwsl}" placeholder="请输入物品数量">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="cwjz">财务价值<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="cwjz" name="cwjz" data-rule="required" maxlength="200"
                                   value="${entity.cwjz}" placeholder="请输入财务价值">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="cwtz">财务特征<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="cwtz" name="cwtz" data-rule="required" maxlength="3000"
                                   value="${entity.cwtz}" placeholder="请输入财务特征">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="bz">财务备注<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="bz" name="bz" data-rule="required" maxlength="3000"
                                   value="${entity.bz}" placeholder="请输入财务备注">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="processMode">处置方式<span class="required">*</span>：</label>
                        </td>
                        <td>
                            <input type="text" id="processMode" name="processMode" data-rule="required" maxlength="2"
                                   value="${entity.processMode}" placeholder="请输入处置方式">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <label class="control-label" for="bgdqsj">保存到期时间：</label>
                        </td>
                        <td>
                            <input type="text" id="bgdqsj" name="bgdqsj"
                                   data-toggle="datepicker" placeholder="请输入保存到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                                   value="<hs:datefmt value="${entity.bgdqsj}" type="dateTimeSecPattern"/>"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_PAGE_SHOW)%>" type="submit" class="btn btn-close"
               data-icon="close">取消</a></li>
        <li>
            <button type="submit" class="btn btn-success" data-icon="save">保存</button>
        </li>
    </ul>
</div>