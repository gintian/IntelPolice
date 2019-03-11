<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="150px"><label class="control-label">行政区域代码：</label>
                </td>
                <td>${entity.xzqhdm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">反馈单编号：</label>
                </td>
                <td>${entity.fkdbh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">接警单编号：</label>
                </td>
                <td>${entity.jjdbh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">处警单编号：</label>
                </td>
                <td>${entity.cjdbh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">到达现场时间：</label>
                </td>
                <td><hs:datefmt value="${entity.ddxcsj}" type="dateTimeFormat"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">反馈录音号：</label>
                </td>
                <td>${entity.fklyh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">反馈单位代码/联动单位代码：</label>
                </td>
                <td>${entity.fkdwdm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">反馈员编号/联动单位人员编号：</label>
                </td>
                <td>${entity.fkybh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">反馈员姓名/联动单位人员姓名：</label>
                </td>
                <td>${entity.fkyxm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">警情类别代码：</label>
                </td>
                <td>${entity.jqlbdm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">出动单位代码/<br>联动单位代码：</label>
                </td>
                <td>${entity.cddwdm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">反馈超时标志：</label>
                </td>
                <td>${entity.fkcsbz}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">警情发生时间：</label>
                </td>
                <td><hs:datefmt value="${entity.jqfssj}" type="dateTimeFormat"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">警情结束时间：</label>
                </td>
                <td><hs:datefmt value="${entity.jqjssj}" type="dateTimeFormat"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">警情等级代码：</label>
                </td>
                <td>${entity.jqdjdm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">火灾等级代码：</label>
                </td>
                <td>${entity.hzdjdm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">处理完毕时间：</label>
                </td>
                <td><hs:datefmt value="${entity.clwbsj}" type="dateTimeFormat"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">出警情况：</label>
                </td>
                <td>${entity.cjqk}</td>
            </tr>
            <tr>---</tr>
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