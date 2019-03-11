<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="panel panel-default" style="height: 500px;overflow: auto">
    <div class="panel-body">
        <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-4">人员名称：</label>
                        <div class="col-md-8">
                            <span>${entity.name}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-md-4">身份证号：</label>
                        <div class="col-md-8">
                            <span>${entity.idcard}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4" >上传照片：</label>
                        <div class="col-md-8">
                            <img width="200px" height="200px" class="img-rounded" src="${root}<%=Url.getUrl(Url.FILE_DOWNLOAD)%>?path=${entity.pic}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4">联系电话：</label>
                        <div class="col-md-8">
                            <span >${entity.bxwrPhone}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-md-4">人大代表：</label>
                        <div class="col-md-8">
                            <hs:code value="${item.isrddb}" field="ISSTRUTS" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4">居住地址：</label>
                        <div class="col-md-8">
                            <span>${entity.bxwrAddr}</span>
                        </div>
                    </div>
                        <div class="form-group">
                            <label class="col-md-4" >创建人<span  class="required">*</span>：</label>
                            <div class="col-md-8 required">
                                <span> <hs:user value='${entity.addUser}'/></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4" >修改人<span  class="required">*</span>：</label>
                            <div class="col-md-8 required">
                                <span> <hs:user value='${entity.modifyUser}'/></span>
                            </div>
                        </div>
        </div>
    </div>
</div>
<div class="bjui-pageFooter navbar-fixed-bottom">
    <ul>
        <li>
            <button type="button" class="btn btn-close" data-icon="close">取消</button>
        </li>

    </ul>
</div>