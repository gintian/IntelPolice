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
					<td align="right" width="150px"><label class="control-label">接警单位代码：</label>
					</td>
					<td>${entity.jjdwdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警单编号：</label>
					</td>
					<td>${entity.jjdbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警类型：</label>
					</td>
					<td>${entity.jjlx}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警方式：</label>
					</td>
					<td>${entity.bjfs}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">重复警情编号：</label>
					</td>
					<td>${entity.cfjqbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">来话类型代码：</label>
					</td>
					<td>${entity.lhlx}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">关联警情编号：</label>
					</td>
					<td>${entity.gljqbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警录音号：</label>
					</td>
					<td>${entity.jjlyh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">特服号码：</label>
					</td>
					<td>${entity.tfhm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警员编号：</label>
					</td>
					<td>${entity.jjybh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警员姓名：</label>
					</td>
					<td><hs:out value="${entity.jjyxm}" /></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警席位号：</label>
					</td>
					<td><hs:out value="${entity.seatno}" /></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警时间：</label>
					</td>
					<td><hs:datefmt value="${entity.bjsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">接警时间：</label>
					</td>
					<td><hs:datefmt value="${entity.jjsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">话终时间：</label>
					</td>
					<td><hs:datefmt value="${entity.hzsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">事件时间：</label>
					</td>
					<td><hs:datefmt value="${entity.sjsj}" type="dateTimeFormat" />
					</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警人身份证号：</label>
					</td>
					<td>${entity.bjrsfzh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警电话：</label>
					</td>
					<td>${entity.bjdh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警电话用户姓名：</label>
					</td>
					<td>${entity.bjdhyhxm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警电话用户地址：</label>
					</td>
					<td>${entity.bjdhyhdz}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警人姓名：</label>
					</td>
					<td>${entity.bjrxm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警人性别代码：</label>
					</td>
					<td>${entity.bjrxbdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">联系电话：</label>
					</td>
					<td>${entity.lxdh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否当事人：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.sfdsr==0}">
					否
            	</c:when>
							<c:when test="${entity.sfdsr==1}">
					是
            	</c:when>
							<c:otherwise>
            		未知
            	</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否重点单位：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.sfzddw==1}">
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
					<td align="right" width="150px"><label class="control-label">警情地址：</label>
					</td>
					<td>${entity.jqdz}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警内容：</label>
					</td>
					<td>${entity.bjnr}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">管辖单位代码：</label>
					</td>
					<td>${entity.gxdwdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">警情类别代码：</label>
					</td>
					<td>${entity.jqlbdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">路灯杆编号：</label>
					</td>
					<td>${entity.ldgbh}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">有无危险物质：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.ywwxwz==1}">
            		有
            	</c:when>
							<c:otherwise>
					无
            	</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">有无爆炸/泄漏：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.ywbzxl==1}">
            			有
            		</c:when>
							<c:otherwise>
						无
            		</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警车号牌种类代码：</label>
					</td>
					<td>${entity.bjchpzldm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">报警车牌号：</label>
					</td>
					<td>${entity.bjcph}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">车辆颜色：</label>
					</td>
					<td>${entity.clys}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否涉外：</label>
					</td>
					<td><c:choose>
							<c:when test="${entity.sfsw==1}">
            			是
            		</c:when>
							<c:otherwise>
						否
            		</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否是
							外语报警：</label></td>
					<td><c:choose>
							<c:when test="${entity.sfswybj==1}">
            			是
            		</c:when>
							<c:otherwise>
						否
            		</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">自动定位X坐标（报警人位置）：</label>
					</td>
					<td>${entity.zddwxzb}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">自动定位Y坐标（报警人位置）：</label>
					</td>
					<td>${entity.zddwyzb}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">手工定位X坐标（报警人位置）：</label>
					</td>
					<td>${entity.sgdwxzb}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">手工定位X坐标（报警人位置）：</label>
					</td>
					<td>${entity.sgdwxzb}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">补充接警内容：</label>
					</td>
					<td>${entity.bcjjnr}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">入库时间戳：</label>
					</td>
					<td><hs:datefmt value="${entity.rksjc}" type="dateTimeFormat" /></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">修改时间：</label>
					</td>
					<td><hs:datefmt value="${entity.xgsj}" type="dateTimeFormat" /></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">警情状态代码：</label>
					</td>
					<td>${entity.jqztdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">作案工具代码：</label>
					</td>
					<td>${entity.zagjdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">更新时间戳：</label>
					</td>
					<td><hs:datefmt value="${entity.gxsjc}" type="dateTimeFormat" /></td>
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
					<td align="right" width="150px"><label class="control-label">起火建筑结构代码：</label>
					</td>
					<td>${entity.qhjzjgdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">火灾场所代码：</label>
					</td>
					<td>${entity.hzcsdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">起火建筑情况描述：</label>
					</td>
					<td>${entity.qhjzqkms}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">毗邻情况：</label>
					</td>
					<td>${entity.plqk}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">起火物代码：</label>
					</td>
					<td>${entity.qhwdm}</td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">有无逃逸：</label></td>
					<td><c:choose>
							<c:when test="${entity.ywty==1}">
            			有
            		</c:when>
							<c:otherwise>
						无
            		</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td align="right" width="150px"><label class="control-label">是否是危化车辆：</label></td>
					<td><c:choose>
							<c:when test="${entity.sfswhcl==1}">
            			是
            		</c:when>
							<c:otherwise>
						否
            		</c:otherwise>
						</c:choose></td>
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
            			其它
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