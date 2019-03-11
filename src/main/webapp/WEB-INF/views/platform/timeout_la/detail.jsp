<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <fieldset>
            <legend>信息</legend>
            <!-- Tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class=""><a href="#jjdb" role="tab" data-toggle="tab" data-reload="false">接警单</a></li>
                <li class=""><a href="#cjdb" role="tab" data-toggle="tab" data-reload="false">处警单</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade active in" id="jjdb">
                    <div class="bjui-pageContent">
                        <div style="margin:15px auto 0;">
                            <table class="table table-condensed table-hover">
                                <tbody>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${jJbean.jjsj}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警形式：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${jJbean.jjlx == 0}">
                                            未处理
                                        </c:when>
                                        <c:when test="${jJbean.jjlx == 1}">
                                            已处警
                                        </c:when>
                                        <c:when test="${jJbean.jjlx == 2}">
                                            无效警
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警人：</label>
                                    </td>
                                    <td>${jJbean.jjyxm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警单位：</label>
                                    </td>
                                    <td><hs:dept value=" ${jJbean.jjdwdm}" /></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">报警内容：</label>
                                    </td>
                                    <td>${jJbean.bjnr}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">报警电话：</label>
                                    </td>
                                    <td>${jJbean.bjdh}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="cjdb">
                    <div class="bjui-pageContent">
                        <div style="margin:15px auto 0;">
                            <table class="table table-condensed table-hover">
                                <tbody>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">到达现场时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.pdddsj}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动警力人员：</label>
                                    </td>
                                    <td>${entity.cdjyxm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动机动车：</label>
                                    </td>
                                    <td>${entity.cdcl}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警单位：</label>
                                    </td>
                                    <td><hs:dept value="${entity.cjdwdm}" /></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警人：</label>
                                    </td>
                                    <td>${entity.cjyxm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警意见：</label>
                                    </td>
                                    <td>${entity.cjyj}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="resizeMarker" style="display:none; height:300px; left:57px;"></div>
                <div class="resizeProxy" style="left:377px; display:none; height:300px;"></div>
            </div>
    </div>
    </fieldset>
</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li>
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>

    </ul>
</div>