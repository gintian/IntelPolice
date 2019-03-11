<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
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
					<td align="right" width="150px"><label class="control-label">处警单编号：</label>
					</td>
					<td>${entity.cjdbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警单编号：</label>
					</td>
					<td>${entity.jjdbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警单位代码：</label>
					</td>
					<td>${entity.cjdwdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警员编号：</label>
					</td>
					<td>${entity.cjybh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警员姓名：</label>
					</td>
					<td>${entity.cjyxm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警录音号：</label>
					</td>
					<td>${entity.cjlyh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警意见：</label>
					</td>
					<td>${entity.cjyj}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">出动单位代码/<br>联动单位代码：</label>
					</td>
					<td>${entity.cddwdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">出动警员编号/<br>联动单位人员编号：</label>
					</td>
					<td>${entity.cdjybh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">出动警员姓名/<br>联动单位人员姓名：</label>
					</td>
					<td>${entity.cdjyxm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">入库时间戳：</label>
					</td>
					<td><hs:datefmt value="${entity.rksjc}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">处警时间：</label>
					</td>
					<td><hs:datefmt value="${entity.cjsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">派单到达时间：</label>
					</td>
					<td><hs:datefmt value="${entity.pdddsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">派单接收时间：</label>
					</td>
					<td><hs:datefmt value="${entity.pdjssj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">退单标志：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.tdbz == -1}">
            		退单被拒绝
            	</c:when>
							<c:when test="${entity.tdbz == 1}">
            		退单申请中
            	</c:when>
							<c:when test="${entity.tdbz == 2}">
            		已退单
            	</c:when>
							<c:otherwise>
            		正常
            	</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">签收超时标志：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.tdbz == 1}">
            		签收超时
            	</c:when>
							<c:otherwise>
            		正常
            	</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">出动人员：</label>
					</td>
					<td>${entity.cdry}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">出动车辆：</label>
					</td>
					<td>${entity.cdcl}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">警情状态代码：</label>
					</td>
					<td>${entity.jqztdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">更新时间戳：</label>
					</td>
					<td><hs:datefmt value="${entity.gxsjc}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否重点单位：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.tdbz == 1}">
	            		是
	            	</c:when>
							<c:otherwise>
	            		否
	            	</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">重点单位名称：</label>
					</td>
					<td>${entity.zddwmc}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">所属系统：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.ssxt==01}">
						天维尔
            		</c:when>
							<c:when test="${entity.ssxt==02}">
						迪爱斯
            		</c:when>
							<c:when test="${entity.ssxt==03}">
						富晋天维
            		</c:when>
							<c:otherwise>
            			未知
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