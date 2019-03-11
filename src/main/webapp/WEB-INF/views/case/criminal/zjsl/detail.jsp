<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <fieldset>
            <legend>案件信息</legend>
            <!-- Tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class=""><a href="#case" role="tab" data-toggle="tab" data-reload="false">案件信息</a></li>
                <li class=""><a href="#jjdb" role="tab" data-toggle="tab" data-reload="false">接警单</a></li>
                <li class=""><a href="#cjdb" role="tab" data-toggle="tab" data-reload="false">处警单</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <%--<div class="tab-pane fade active in" id="base"><div class="bjui-pageContent">--%>
                <table class="table table-hover hw-table-long-input" width="100%">
                    <tbody>
                    <tr class="warning">
                        <td align="right" width="150px">
                            <label class="control-label">案件编号：</label>
                        </td>
                        <td>${entity.caseid}</td>
                    </tr>
                    <tr>
                        <td align="right" width="150px"><label class="control-label">案件名称：</label>
                        </td>
                        <td>${entity.casename}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="tab-pane fade active in" id="case">
                    <div class="bjui-pageContent">
                        <div style="margin:15px auto 0;">
                            <table class="table table-condensed table-hover">
                                <tbody>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件文号：</label>
                                    </td>
                                    <td>${entity.casewhid}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件登记方式：</label>
                                    </td>
                                    <td>
                                    ${entity.businesstype}</tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">补录原因：</label>
                                    </td>
                                    <td>${entity.makupreason}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">补录单位行政区划：</label>
                                    </td>
                                    <td>${entity.makeupcode}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">辖区：</label>
                                    </td>
                                    <td>${entity.xq}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件类型：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.caseclass==1}">
                                            接处警
                                        </c:when>
                                        <c:when test="${entity.caseclass==2}">
                                            一般刑事
                                        </c:when>
                                        <c:when test="${entity.caseclass==3}">
                                            经济案件
                                        </c:when>
                                        <c:when test="${entity.caseclass==4}">
                                            毒品案件
                                        </c:when>
                                        <c:when test="${entity.caseclass==5}">
                                            交通案件
                                        </c:when>
                                        <c:when test="${entity.caseclass==6}">
                                            行政案件
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件类别：</label>
                                    </td>
                                    <td>${entity.casesort}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件性质：</label>
                                    </td>
                                    <td>${entity.casekind}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案由：</label>
                                    </td>
                                    <td>${entity.casereason}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">督办级别：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.superintendlevel}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">保密级别：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.secrecylevel}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件状态：</label>
                                    </td>
                                    <td>${entity.casestate}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发现时间起：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.discovertimestart}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发现时间止：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.discovertimeend}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案时间起：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.casetimestart}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案时间止：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.casetimeend}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">涉及国家地区：</label>
                                    </td>
                                    <td>${entity.countries}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案地行政区划：</label>
                                    </td>
                                    <td>${entity.districtcode}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案社区：</label>
                                    </td>
                                    <td>${entity.community}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案地点：</label>
                                    </td>
                                    <td>${entity.caseaddress}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">地点经度：</label>
                                    </td>
                                    <td>${entity.longitude}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">地点纬度：</label>
                                    </td>
                                    <td>${entity.latitude}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">死亡人数：</label>
                                    </td>
                                    <td>${entity.dienum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">受伤人数：</label>
                                    </td>
                                    <td>${entity.lnjurenum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">损失总价值：</label>
                                    </td>
                                    <td>${entity.lossvalue}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否涉外：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.iffremdness==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.iffremdness==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">简要案情：</label>
                                    </td>
                                    <td>${entity.details}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案情关键词：</label>
                                    </td>
                                    <td>${entity.casekeyword}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否可以归档：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifarchive==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifarchive==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">并案标识：</label>
                                    </td>
                                    <td>${entity.unionflag}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">并案主案件编号：</label>
                                    </td>
                                    <td>${entity.maincaseid}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件带破单位：</label>
                                    </td>
                                    <td>${entity.inputunit}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否侵犯财产案：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.isagainst==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.isagainst==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否命案：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ismurder==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ismurder==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否涉枪案：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.isgun==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.isgun==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否劳教案件：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifdetention==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifdetention==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否涉密案件：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifclassified==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifclassified==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报拐卖案件系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifuptraffick==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifuptraffick==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报涉枪案件系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifupgun==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifupgun==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报敲诈案件系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifupblackmail==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifupblackmail==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报命案系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifupmurder==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifupmurder==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报禁毒系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.isupdurg==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.isupdurg==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">上报禁毒系统时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.updurgtime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">当前办理单位：</label>
                                    </td>
                                    <td>${entity.dqbldw}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">协作编号：</label>
                                    </td>
                                    <td>${entity.crossregionno}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否打包上传：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.isBswsPack==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.isBswsPack==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否申请删除：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifappdel==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifappdel==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">标注率：</label>
                                    </td>
                                    <td>${entity.markedrate}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">录入人：</label>
                                    </td>
                                    <td>${entity.inputpsn}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">录入时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.inputtime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">修改人：</label>
                                    </td>
                                    <td>${entity.modifiedpsn}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">修改时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.modifiedtime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">入地市库时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.districttime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">入省库时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.provincetime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">上报标识：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.tag == 0}">
                                            不需要
                                        </c:when>
                                        <c:when test="${entity.tag == 1}">
                                            需要
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">修改标识：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.modifiedtag == 0}">
                                            不需要
                                        </c:when>
                                        <c:when test="${entity.modifiedtag == 1}">
                                            需要
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">删除标识：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.deletag == 0}">
                                            不需要
                                        </c:when>
                                        <c:when test="${entity.deletag == 1}">
                                            需要
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="jjdb">
                    <div class="bjui-pageContent">
                        <div style="margin:15px auto 0;">
                            <table class="table table-condensed table-hover">
                                <tbody>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">警情类别：</label>
                                    </td>
                                    <td>${entity.alarmtype}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.reportime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警形式：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.reportmode == 0}">
                                            未处理
                                        </c:when>
                                        <c:when test="${entity.reportmode == 1}">
                                            已处警
                                        </c:when>
                                        <c:when test="${entity.reportmode == 2}">
                                            无效警
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警人：</label>
                                    </td>
                                    <td>${entity.receivepsn}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警单位：</label>
                                    </td>
                                    <td>${entity.receiveunit}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">报警内容：</label>
                                    </td>
                                    <td>${entity.reportdetails}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">报警电话：</label>
                                    </td>
                                    <td>${entity.rvcallno}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="bjui-pageFooter">
                        <ul>
                            <li>
                                <button type="button" class="btn btn-close" data-icon="close"><i
                                        class="fa fa-close"></i> 关闭
                                </button>
                            </li>
                        </ul>
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
                                    <td><hs:datefmt value="${entity.arrivetime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动警力数：</label>
                                    </td>
                                    <td>${entity.policenum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动协勤数：</label>
                                    </td>
                                    <td>${entity.policeassnum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动机动车（次）：</label>
                                    </td>
                                    <td>${entity.voiturenum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动船支（次）：</label>
                                    </td>
                                    <td>${entity.boatnum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">救助群众：</label>
                                    </td>
                                    <td>${entity.salvationpeo}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">救助伤员：</label>
                                    </td>
                                    <td>${entity.salvationwou}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">解救人质数：</label>
                                    </td>
                                    <td>${entity.rescuehnum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">解救被拐卖妇女数：</label>
                                    </td>
                                    <td>${entity.rescuewnum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">解救被拐卖儿童数：</label>
                                    </td>
                                    <td>${entity.rescueynum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">留置审查人数：</label>
                                    </td>
                                    <td>${entity.censornum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警单位：</label>
                                    </td>
                                    <td>${entity.disposeunit}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警人1：</label>
                                    </td>
                                    <td>${entity.disposepsn}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警人2：</label>
                                    </td>
                                    <td>${entity.disposepsn2}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接处警简要情况：</label>
                                    </td>
                                    <td>${entity.disposedetails}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警结果：</label>
                                    </td>
                                    <td>${entity.disposeresult}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警意见：</label>
                                    </td>
                                    <td>${entity.disposeopinion}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否现场处罚：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifspotfine==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifspotfine==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否现场调解：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.ifspotreconcile==0}">
                                            否
                                        </c:when>
                                        <c:when test="${entity.ifspotreconcile==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
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