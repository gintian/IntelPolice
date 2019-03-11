<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent">
	<div class="pageFormContent" data-layout-h="0">
		<table class="table table-hover hw-table-long-input" width="100%">
			<tbody>
				<tr class="warning">
					<td align="right" width="150px"><label class="control-label">编号：</label>
					</td>
					<td>${entity.id}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">事件编号：</label>
					</td>
					<td>${entity.sjbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警时间：</label>
					</td>
					<td><hs:datefmt value="${entity.bjsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">指令下发时间：</label>
					</td>
					<td><hs:datefmt value="${entity.zlxfsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警人姓名：</label>
					</td>
					<td>${entity.bjrxm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警人电话：</label>
					</td>
					<td>${entity.bjrdh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">发案地点：</label>
					</td>
					<td>${entity.fadd}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警内容：</label>
					</td>
					<td>${entity.bjnr}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警员姓名：</label>
					</td>
					<td>${entity.jjyxm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">指定出警单位：</label>
					</td>
					<td>${entity.zdcjdw}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接处警系统编号：</label>
					</td>
					<td>${entity.jcjxtbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">指令到达时间：</label>
					</td>
					<td><hs:datefmt value="${entity.zlddsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">状态：</label>
					</td>
					<td><c:choose>
							<c:when test="${item.jcjxtbh == 0}">
								未处理
							</c:when>
							<c:when test="${item.jcjxtbh == 1}">
								已处警
							</c:when>
							<c:otherwise>
								无效警
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警人：</label>
					</td>
					<td>${entity.cjr}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否反馈：</label>
					</td>
					<td><c:choose>
							<c:when test="${item.jcjxtbh == 0}">
								否
							</c:when>
							<c:otherwise>
								是
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否接警处理：</label>
					</td>
					<td><c:choose>
							<c:when test="${item.sfjjcl == 0}">
								否
							</c:when>
							<c:otherwise>
								是
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">案件编号：</label>
					</td>
					<td><hs:datefmt value="${entity.caseid}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">录入人：</label>
					</td>
					<td><hs:datefmt value="${entity.inputpsn}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">录入时间：</label>
					</td>
					<td><hs:datefmt value="${entity.inputtime}" type="dateTimeFormat" />
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
					<td><hs:datefmt value="${entity.modifiedtime}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">入地市库时间：</label>
					</td>
					<td><hs:datefmt value="${entity.districttime}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">入省库时间：</label>
					</td>
					<td><hs:datefmt value="${entity.provincetime}" type="dateTimeFormat" />
					</td>
				</tr>
					<tr>
					<td align="right" width="150px"><label class="control-label">上报标识：</label>
					</td>
					<td><c:choose>
							<c:when test="${item.tag == 0}">
								不需要
							</c:when>
							<c:otherwise>
								需要
							</c:otherwise>
						</c:choose></td>
				</tr>
					<tr>
					<td align="right" width="150px"><label class="control-label">修改标识：</label>
					</td>
					<td><c:choose>
							<c:when test="${item.modifiedtag == 0}">
								不需要
							</c:when>
							<c:otherwise>
								需要
							</c:otherwise>
						</c:choose></td>
				</tr>
					<tr>
					<td align="right" width="150px"><label class="control-label">删除标识：</label>
					</td>
					<td><c:choose>
							<c:when test="${item.deletag == 0}">
								不需要
							</c:when>
							<c:otherwise>
								需要
							</c:otherwise>
						</c:choose></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn btn-close" data-icon="close">取消</button></li>

	</ul>
</div>