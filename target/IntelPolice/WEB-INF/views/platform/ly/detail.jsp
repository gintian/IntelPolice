<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <table class="table table-hover hw-table-long-input" width="100%">
            <tbody>
            <tr class="info">
                <td align="right" width="150px"><label class="control-label">录音编号：</label>
                </td>
                <td>${entity.lybh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">电话类型：</label>
                </td>
                <td>${entity.dhlx}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">来电号码：</label>
                </td>
                <td>${entity.ldhm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">坐席号：</label>
                </td>
                <td>${entity.zxh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">操作员编号：</label>
                </td>
                <td>${entity.czybh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">录音开始时间：</label>
                </td>
                <td><hs:datefmt value="${entity.lykssj}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">录音结束时间：</label>
                </td>
                <td><hs:datefmt value="${entity.lyjssj}" type="dateTimeFormat"/></td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">接警编号：</label>
                </td>
                <td>${entity.jjdbh}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">拨出电话号码：</label>
                </td>
                <td>${entity.bcdhhm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">本机号码：</label>
                </td>
                <td>${entity.bjhm}</td>
            </tr>
            <tr>
                <td align="right" width="150px"><label class="control-label">行政区划代码：</label>
                </td>
                <td>${entity.xzqhdm}</td>
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