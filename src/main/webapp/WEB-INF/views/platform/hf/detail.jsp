<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="150px"><label class="control-label">回访核实单编号：</label>
                </td>
                <td>${entity.hfhsdbh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">接警单编号：</label>
                </td>
                <td>${entity.jjdbh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">回访核实录音号：</label>
                </td>
                <td>${entity.hfhslyh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">回访时间：</label>
                </td>
                <td><hs:datefmt value="${entity.hfsj}" type="dateTimeFormat"/>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">回访人员姓名：</label>
                </td>
                <td>${entity.hfryxm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">回访电话号码：</label>
                </td>
                <td>${entity.hfdhhm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">被回访人姓名：</label>
                </td>
                <td>${entity.bhfrxm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">被回访人电话号码：</label>
                </td>
                <td>${entity.bhfrdhhm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">回访核实情况：</label>
                </td>
                <td>${entity.hfhsqk}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">出警速度：</label></td>
                <td>
                    <c:choose>
                        <c:when test="${entity.cjsd==1}">
                            满意
                        </c:when>
                        <c:when test="${entity.cjsd==2}">
                            基本满意
                        </c:when>
                        <c:when test="${entity.cjsd==3}">
                            不满意
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">出警民警态度：</label></td>
                <td>
                    <c:choose>
                        <c:when test="${entity.cjmjtd==1}">
                            良好
                        </c:when>
                        <c:when test="${entity.cjmjtd==2}">
                            一般
                        </c:when>
                        <c:when test="${entity.cjmjtd==3}">
                            恶劣
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">出警民警警容风纪：</label></td>
                <td>
                    <c:choose>
                        <c:when test="${entity.cjmjjrfj==1}">
                            规范
                        </c:when>
                        <c:when test="${entity.cjmjjrfj==2}">
                            一般
                        </c:when>
                        <c:when test="${entity.cjmjjrfj==3}">
                            不规范
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">处理结果：</label></td>
                <td>
                    <c:choose>
                        <c:when test="${entity.cljg==1}">
                            满意
                        </c:when>
                        <c:when test="${entity.cljg==2}">
                            不满意
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>

    </ul>
</div>