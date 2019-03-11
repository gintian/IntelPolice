<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div class="bjui-pageContent">
    <div class="pageFormContent" data-layout-h="0">
        <fieldset>
            <legend>案件信息1.${criminalBean.caseid} 2.${jjBean} 3.${cjBean}</legend>

            <!-- Tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="" id="WJXQ"><a href="#view" role="tab" data-toggle="tab" data-reload="false">文件详情</a></li>
                <c:if test="${criminalBean!=null}">
                    <li class=""><a href="#case" role="tab" data-toggle="tab" data-reload="false">案件详情</a></li>
                </c:if>
                <c:if test="${jjBean !=null}">
                    <li class=""><a href="#jjdb" role="tab" data-toggle="tab" data-reload="false">接警单</a></li>
                </c:if>
                <c:if test="${cjBean !=null}">
                    <li class=""><a href="#cjdb" role="tab" data-toggle="tab" data-reload="false">处警单</a></li>
                </c:if>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <%--<div class="tab-pane fade active in" id="base"><div class="bjui-pageContent">--%>
                <table class="table table-hover hw-table-long-input" width="100%">
                    <tbody>
                    <tr class="warning">
                        <td align="right" width="150px">
                            <label class="control-label">文件号：</label>
                        </td>
                        <td>${entity.docId}</td>
                    </tr>
                    <tr>
                        <td align="right" width="150px"><label class="control-label">文件名称：</label>
                        </td>
                        <td>${entity.docName}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="tab-pane fade active in" id="view">
                    <div class="bjui-pageContent">
                        <div style="margin:15px auto 0;">
                            <table class="table table-condensed table-hover">
                                <tbody>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">文件大小：</label>
                                    </td>
                                    <td>${entity.docSize}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">URL地址：</label>
                                    </td>
                                    <td>
                                    ${entity.docUrl}</tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">重要级别：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.impLevl==0}">
                                            无定义
                                        </c:when>
                                        <c:when test="${entity.impLevl==1}">
                                            重要
                                        </c:when>
                                        <c:when test="${entity.impLevl==2}">
                                            一般
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">描述：</label>
                                    </td>
                                    <td>${entity.remark}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">文件类型：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${entity.cate==0}">
                                            图片
                                        </c:when>
                                        <c:when test="${entity.cate==1}">
                                            音频
                                        </c:when>
                                        <c:when test="${entity.cate==2}">
                                            视频
                                        </c:when>
                                        <c:when test="${entity.cate==3}">
                                            日志
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">站点编号：</label>
                                    </td>
                                    <td>${entity.siteNo}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">站点播放地址：</label>
                                    </td>
                                    <td>${entity.http}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">上传时间：</label>
                                    </td>

                                    <td><hs:datefmt value="${entity.uploadTime}" type="datetimeFormat"/>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">过期时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.explryTime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">视频拍摄时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${entity.createTime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">警员编号：</label>
                                    </td>
                                    <td>${entity.policeId}</td>
                                </tr>

                                <tr>
                                    <td align="right" width="150px"><label class="control-label">警员姓名：</label>
                                    </td>
                                    <td>${entity.name}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">警员身份证：</label>
                                    </td>
                                    <td>${entity.idNum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">手机号码：</label>
                                    </td>
                                    <td>${entity.mobile}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">所属机构：</label>
                                    </td>
                                    <td>${entity.orgName}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">机构代码：</label>
                                    </td>
                                    <td>${entity.orgCode}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">上级机构代码：</label>
                                    </td>
                                    <td>${entity.parentId}</td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="tab-pane fade" id="case">
                    <div class="bjui-pageContent">
                        <div style="margin:15px auto 0;">
                            <table class="table table-condensed table-hover">
                                <tbody>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件编号：</label>
                                    </td>
                                    <td>${criminalBean.caseid}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件名称：</label>
                                    </td>
                                    <td>${criminalBean.casename}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件文号：</label>
                                    </td>
                                    <td>${criminalBean.casewhid}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件登记方式：</label>
                                    </td>
                                    <td>
                                    ${criminalBean.businesstype}</tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">补录原因：</label>
                                    </td>
                                    <td>${criminalBean.makupreason}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">补录单位行政区划：</label>
                                    </td>
                                    <td>${criminalBean.makeupcode}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">辖区：</label>
                                    </td>
                                    <td>${criminalBean.xq}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件类型：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.caseclass==1}">
                                            接处警
                                        </c:when>
                                        <c:when test="${criminalBean.caseclass==2}">
                                            一般刑事
                                        </c:when>
                                        <c:when test="${criminalBean.caseclass==3}">
                                            经济案件
                                        </c:when>
                                        <c:when test="${criminalBean.caseclass==4}">
                                            毒品案件
                                        </c:when>
                                        <c:when test="${criminalBean.caseclass==5}">
                                            交通案件
                                        </c:when>
                                        <c:when test="${criminalBean.caseclass==6}">
                                            行政案件
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件类别：</label>
                                    </td>
                                    <td>${criminalBean.casesort}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件性质：</label>
                                    </td>
                                    <td>${criminalBean.casekind}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案由：</label>
                                    </td>
                                    <td>${criminalBean.casereason}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">督办级别：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.superintendlevel}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">保密级别：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.secrecylevel}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件状态：</label>
                                    </td>
                                    <td>${criminalBean.casestate}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发现时间起：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.discovertimestart}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发现时间止：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.discovertimeend}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案时间起：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.casetimestart}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案时间止：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.casetimeend}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">涉及国家地区：</label>
                                    </td>
                                    <td>${criminalBean.countries}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案地行政区划：</label>
                                    </td>
                                    <td>${criminalBean.districtcode}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案社区：</label>
                                    </td>
                                    <td>${criminalBean.community}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">发案地点：</label>
                                    </td>
                                    <td>${criminalBean.caseaddress}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">地点经度：</label>
                                    </td>
                                    <td>${criminalBean.longitude}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">地点纬度：</label>
                                    </td>
                                    <td>${criminalBean.latitude}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">死亡人数：</label>
                                    </td>
                                    <td>${criminalBean.dienum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">受伤人数：</label>
                                    </td>
                                    <td>${criminalBean.lnjurenum}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">损失总价值：</label>
                                    </td>
                                    <td>${criminalBean.lossvalue}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否涉外：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.iffremdness==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.iffremdness==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">简要案情：</label>
                                    </td>
                                    <td>${criminalBean.details}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案情关键词：</label>
                                    </td>
                                    <td>${criminalBean.casekeyword}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否可以归档：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifarchive==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifarchive==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">并案标识：</label>
                                    </td>
                                    <td>${criminalBean.unionflag}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">并案主案件编号：</label>
                                    </td>
                                    <td>${criminalBean.maincaseid}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">案件带破单位：</label>
                                    </td>
                                    <td>${criminalBean.inputunit}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否侵犯财产案：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.isagainst==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.isagainst==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否命案：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ismurder==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ismurder==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否涉枪案：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.isgun==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.isgun==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否劳教案件：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifdetention==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifdetention==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否涉密案件：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifclassified==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifclassified==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报拐卖案件系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifuptraffick==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifuptraffick==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报涉枪案件系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifupgun==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifupgun==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报敲诈案件系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifupblackmail==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifupblackmail==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报命案系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifupmurder==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifupmurder==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否上报禁毒系统：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.isupdurg==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.isupdurg==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">上报禁毒系统时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.updurgtime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">当前办理单位：</label>
                                    </td>
                                    <td>${criminalBean.dqbldw}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">协作编号：</label>
                                    </td>
                                    <td>${criminalBean.crossregionno}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否打包上传：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.isBswsPack==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.isBswsPack==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">是否申请删除：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.ifappdel==0}">
                                            否
                                        </c:when>
                                        <c:when test="${criminalBean.ifappdel==1}">
                                            是
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">标注率：</label>
                                    </td>
                                    <td>${criminalBean.markedrate}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">录入人：</label>
                                    </td>
                                    <td>${criminalBean.inputpsn}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">录入时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.inputtime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">修改人：</label>
                                    </td>
                                    <td>${criminalBean.modifiedpsn}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">修改时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.modifiedtime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">入地市库时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.districttime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">入省库时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${criminalBean.provincetime}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">上报标识：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.tag == 0}">
                                            不需要
                                        </c:when>
                                        <c:when test="${criminalBean.tag == 1}">
                                            需要
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">修改标识：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.modifiedtag == 0}">
                                            不需要
                                        </c:when>
                                        <c:when test="${criminalBean.modifiedtag == 1}">
                                            需要
                                        </c:when>
                                    </c:choose></td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">删除标识：</label>
                                    </td>
                                    <td><c:choose>
                                        <c:when test="${criminalBean.deletag == 0}">
                                            不需要
                                        </c:when>
                                        <c:when test="${criminalBean.deletag == 1}">
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
                                    <td align="right" width="150px"><label class="control-label">警情类行：</label>
                                    </td>
                                    <td>${jjBean.jjlx}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${jjBean.jjsj}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警员编号：</label>
                                    </td>
                                    <td>${jjBean.jjybh}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警员姓名：</label>
                                    </td>
                                    <td>${jjBean.jjyxm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">接警单位编号：</label>
                                    </td>
                                    <td>${jjBean.jjdwdm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">报警内容：</label>
                                    </td>
                                    <td>${jjBean.bjnr}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">报警电话：</label>
                                    </td>
                                    <td>${jjBean.bjdh}</td>
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
                                    <td align="right" width="150px"><label class="control-label">处警时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${cjBean.cjsj}" type="datetimeFormat"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警员编号：</label>
                                    </td>
                                    <td>${cjBean.cjybh}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">处警员姓名：</label>
                                    </td>
                                    <td>${cjBean.cjyxm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动警员：</label>
                                    </td>
                                    <td>${cjBean.cdjyxm}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">出动车辆：</label>
                                    </td>
                                    <td>${cjBean.cdcl}</td>
                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">派单到达时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${cjBean.pdddsj}" type="datetimeFormat"/></td>

                                </tr>
                                <tr>
                                    <td align="right" width="150px"><label class="control-label">派单接受时间：</label>
                                    </td>
                                    <td><hs:datefmt value="${cjBean.pdjssj}" type="datetimeFormat"/></td>
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