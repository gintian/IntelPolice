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
            <td>${entity.criminal.caseid}</td>
          </tr>
          <tr>
            <td align="right" width="150px"><label class="control-label">案件名称：</label>
            </td>
            <td>${entity.criminal.casename}</td>
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
                  <td>${entity.criminal.casewhid}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案件登记方式：</label>
                  </td>
                  <td>
                  ${entity.criminal.businesstype}</tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">补录原因：</label>
                  </td>
                  <td>${entity.criminal.makupreason}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">补录单位行政区划：</label>
                  </td>
                  <td>${entity.criminal.makeupcode}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">辖区：</label>
                  </td>
                  <td>${entity.criminal.xq}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案件类型：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.caseclass==1}">
                      接处警
                    </c:when>
                    <c:when test="${entity.criminal.caseclass==2}">
                      一般刑事
                    </c:when>
                    <c:when test="${entity.criminal.caseclass==3}">
                      经济案件
                    </c:when>
                    <c:when test="${entity.criminal.caseclass==4}">
                      毒品案件
                    </c:when>
                    <c:when test="${entity.criminal.caseclass==5}">
                      交通案件
                    </c:when>
                    <c:when test="${entity.criminal.caseclass==6}">
                      行政案件
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案件类别：</label>
                  </td>
                  <td>${entity.criminal.casesort}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案件性质：</label>
                  </td>
                  <td>${entity.criminal.casekind}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案由：</label>
                  </td>
                  <td>${entity.criminal.casereason}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">督办级别：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.superintendlevel}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">保密级别：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.secrecylevel}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案件状态：</label>
                  </td>
                  <td>${entity.criminal.casestate}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发现时间起：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.discovertimestart}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发现时间止：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.discovertimeend}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发案时间起：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.casetimestart}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发案时间止：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.casetimeend}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">涉及国家地区：</label>
                  </td>
                  <td>${entity.criminal.countries}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发案地行政区划：</label>
                  </td>
                  <td>${entity.criminal.districtcode}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发案社区：</label>
                  </td>
                  <td>${entity.criminal.community}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">发案地点：</label>
                  </td>
                  <td>${entity.criminal.caseaddress}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">地点经度：</label>
                  </td>
                  <td>${entity.criminal.longitude}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">地点纬度：</label>
                  </td>
                  <td>${entity.criminal.latitude}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">死亡人数：</label>
                  </td>
                  <td>${entity.criminal.dienum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">受伤人数：</label>
                  </td>
                  <td>${entity.criminal.lnjurenum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">损失总价值：</label>
                  </td>
                  <td>${entity.criminal.lossvalue}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否涉外：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.iffremdness==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.iffremdness==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">简要案情：</label>
                  </td>
                  <td>${entity.criminal.details}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案情关键词：</label>
                  </td>
                  <td>${entity.criminal.casekeyword}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否可以归档：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifarchive==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifarchive==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">并案标识：</label>
                  </td>
                  <td>${entity.criminal.unionflag}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">并案主案件编号：</label>
                  </td>
                  <td>${entity.criminal.maincaseid}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">案件带破单位：</label>
                  </td>
                  <td>${entity.criminal.inputunit}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否侵犯财产案：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.isagainst==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.isagainst==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否命案：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ismurder==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ismurder==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否涉枪案：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.isgun==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.isgun==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否劳教案件：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifdetention==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifdetention==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否涉密案件：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifclassified==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifclassified==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否上报拐卖案件系统：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifuptraffick==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifuptraffick==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否上报涉枪案件系统：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifupgun==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifupgun==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否上报敲诈案件系统：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifupblackmail==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifupblackmail==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否上报命案系统：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifupmurder==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifupmurder==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否上报禁毒系统：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.isupdurg==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.isupdurg==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">上报禁毒系统时间：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.updurgtime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">当前办理单位：</label>
                  </td>
                  <td>${entity.criminal.dqbldw}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">协作编号：</label>
                  </td>
                  <td>${entity.criminal.crossregionno}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否打包上传：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.isBswsPack==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.isBswsPack==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否申请删除：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.ifappdel==0}">
                      否
                    </c:when>
                    <c:when test="${entity.criminal.ifappdel==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">标注率：</label>
                  </td>
                  <td>${entity.criminal.markedrate}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">录入人：</label>
                  </td>
                  <td>${entity.criminal.inputpsn}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">录入时间：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.inputtime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">修改人：</label>
                  </td>
                  <td>${entity.criminal.modifiedpsn}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">修改时间：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.modifiedtime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">入地市库时间：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.districttime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">入省库时间：</label>
                  </td>
                  <td><hs:datefmt value="${entity.criminal.provincetime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">上报标识：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.tag == 0}">
                      不需要
                    </c:when>
                    <c:when test="${entity.criminal.tag == 1}">
                      需要
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">修改标识：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.modifiedtag == 0}">
                      不需要
                    </c:when>
                    <c:when test="${entity.criminal.modifiedtag == 1}">
                      需要
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">删除标识：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.criminal.deletag == 0}">
                      不需要
                    </c:when>
                    <c:when test="${entity.criminal.deletag == 1}">
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
                  <td>${entity.jj.alarmtype}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">接警时间：</label>
                  </td>
                  <td><hs:datefmt value="${entity.jj.reportime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">接警形式：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.jj.reportmode == 0}">
                      未处理
                    </c:when>
                    <c:when test="${entity.jj.reportmode == 1}">
                      已处警
                    </c:when>
                    <c:when test="${entity.jj.reportmode == 2}">
                      无效警
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">接警人：</label>
                  </td>
                  <td>${entity.jj.receivepsn}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">接警单位：</label>
                  </td>
                  <td>${entity.jj.receiveunit}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">报警内容：</label>
                  </td>
                  <td>${entity.jj.reportdetails}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">报警电话：</label>
                  </td>
                  <td>${entity.jj.rvcallno}</td>
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
                  <td><hs:datefmt value="${entity.cj.arrivetime}" type="datetimeFormat"/>
                  </td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">出动警力数：</label>
                  </td>
                  <td>${entity.cj.policenum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">出动协勤数：</label>
                  </td>
                  <td>${entity.cj.policeassnum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">出动机动车（次）：</label>
                  </td>
                  <td>${entity.cj.voiturenum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">出动船支（次）：</label>
                  </td>
                  <td>${entity.cj.boatnum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">救助群众：</label>
                  </td>
                  <td>${entity.cj.salvationpeo}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">救助伤员：</label>
                  </td>
                  <td>${entity.cj.salvationwou}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">解救人质数：</label>
                  </td>
                  <td>${entity.cj.rescuehnum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">解救被拐卖妇女数：</label>
                  </td>
                  <td>${entity.cj.rescuewnum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">解救被拐卖儿童数：</label>
                  </td>
                  <td>${entity.cj.rescueynum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">留置审查人数：</label>
                  </td>
                  <td>${entity.cj.censornum}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">处警单位：</label>
                  </td>
                  <td>${entity.cj.disposeunit}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">处警人1：</label>
                  </td>
                  <td>${entity.cj.disposepsn}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">处警人2：</label>
                  </td>
                  <td>${entity.cj.disposepsn2}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">接处警简要情况：</label>
                  </td>
                  <td>${entity.cj.disposedetails}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">处警结果：</label>
                  </td>
                  <td>${entity.cj.disposeresult}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">处警意见：</label>
                  </td>
                  <td>${entity.cj.disposeopinion}</td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否现场处罚：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.cj.ifspotfine==0}">
                      否
                    </c:when>
                    <c:when test="${entity.cj.ifspotfine==1}">
                      是
                    </c:when>
                  </c:choose></td>
                </tr>
                <tr>
                  <td align="right" width="150px"><label class="control-label">是否现场调解：</label>
                  </td>
                  <td><c:choose>
                    <c:when test="${entity.cj.ifspotreconcile==0}">
                      否
                    </c:when>
                    <c:when test="${entity.cj.ifspotreconcile==1}">
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