
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common_prefix.jsp"%>
<div class="bjui-pageContent tableContent">
    <form id="j_custom_form" data-toggle="validate" data-alertmsg="false">
        <input type="hidden" name="custom.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <div class="bjui-row col-1">
            <label class="row-label">所属业务</label>
            <div class="row-input required">
                <select name="custom.sale" id="j_custom_sale" data-toggle="selectpicker" data-rule="required">
                    <option value="">全部</option>
                    <option value="1">业务1</option>
                    <option value="2">业务2</option>
                </select>
            </div>
            <label class="row-label">表示颜色</label>
            <div class="row-input">
                <input type="text" name="custom.color" id="j_custom_color" value="" data-toggle="colorpicker" data-bgcolor="true" size="10" readonly="">
                <a href="javascript:;" title="清除颜色" data-toggle="clearcolor" data-target="#j_custom_color">清除颜色</a>
            </div>
            <label class="row-label">职业</label>
            <div class="row-input">
                <input type="text" name="custom.profession" id="j_custom_profession" value="耍家" data-toggle="findgrid" data-options="{
                group: 'custom',
                include: 'profession:name',
                dialogOptions: {title:'查询职业'},
                gridOptions: {
                    local: 'local',
                    dataUrl: '../../json/datagrid-profession.json',
                    columns: [
                        {name:'name', label:'名称', width:100},
                        {name:'desc', label:'描述'},
                        {name:'date', label:'创建日期'}
                    ]
                }
            }">
            </div>
            <br>
            <label class="row-label">客人姓名</label>
            <div class="row-input required">
                <input type="text" name="custom.name" id="j_custom_name" value="张三" data-rule="required">
            </div>
            <label class="row-label">拼音姓</label>
            <div class="row-input required">
                <input type="text" name="custom.fname" id="j_custom_fname" value="Zhang" data-rule="required;letters">
            </div>
            <label class="row-label">拼音名</label>
            <div class="row-input required">
                <input type="text" name="custom.lname" id="j_custom_lname" value="San" data-rule="required;letters">
            </div>
            <label class="row-label">性别</label>
            <div class="row-input required">
                <input type="radio" name="custom.isshow" id="j_custom_sex1" data-toggle="icheck" value="true" data-rule="checked" data-label="男  ">
                <input type="radio" name="custom.isshow" id="j_custom_sex2" data-toggle="icheck" value="false" data-label="女">
            </div>
            <label class="row-label">出生日期</label>
            <div class="row-input required">
                <input type="text" name="custom.birthday" id="j_custom_birthday" value="1980-08-08" data-toggle="datepicker" data-rule="required;date">
            </div>
            <label class="row-label">出生地</label>
            <div class="row-input required">
                <input type="text" name="custom.birthplace" id="j_custom_birthplace" value="四川" data-rule="required">
            </div>
            <label class="row-label">居住地</label>
            <div class="row-input required">
                <input type="text" name="custom.add" id="j_custom_add" value="成都九眼桥" data-rule="required">
            </div>
            <label class="row-label">护照号</label>
            <div class="row-input required">
                <input type="text" name="custom.passportno" id="j_custom_passportno" value="" data-rule="required">
            </div>
            <label class="row-label">签发日期</label>
            <div class="row-input required">
                <input type="text" name="custom.issuedate" id="j_custom_issuedate" value="2014-10-01" data-toggle="datepicker" data-rule="required;date">
            </div>
            <label class="row-label">有效日期</label>
            <div class="row-input required">
                <input type="text" name="custom.indate" id="j_custom_indate" value="2024-09-30" data-toggle="datepicker" data-rule="required;date">
            </div>
            <label class="row-label">签发地</label>
            <div class="row-input required">
                <input type="text" name="custom.issueat" id="j_custom_issueat" value="成都" data-rule="required">
            </div>
            <br>
            <label class="row-label">手机</label>
            <div class="row-input required">
                <input type="text" name="custom.mobile" id="j_custom_mobile" value="" data-rule="required;mobile">
            </div>
            <label class="row-label">关键字</label>
            <div class="row-input">
                <input type="text" name="custom.tags" id="j_custom_tags" value="" data-toggle="tags" data-url="../../json/ajaxTags.json" data-width="100%" size="20" placeholder="输入关键字，回车提交">
            </div>
            <br>
            <label class="row-label">占床</label>
            <div class="row-input">
                <input type="checkbox" name="custom.room" id="j_custom_room" data-toggle="icheck" value="true" data-label="是否占床" checked="" data-rule="checked">
            </div>
            <label class="row-label">签证</label>
            <div class="row-input">
                <input type="checkbox" name="custom.visa" id="j_custom_visa" data-toggle="icheck" value="true" data-label="需要签证">
            </div>
            <label class="row-label">素食</label>
            <div class="row-input">
                <input type="checkbox" name="custom.vegetarian" id="j_custom_vegetarian" data-toggle="icheck" value="true" data-label="是否素食">
            </div>
            <label class="row-label">同行人数</label>
            <div class="row-input">
                <input type="text" name="custom.total" id="j_custom_total" value="1" size="" data-toggle="spinner" data-min="0" data-max="100" data-step="1" data-rule="integer">
            </div>
            <label class="row-label">备注</label>
            <div class="row-input">
                <textarea name="custom.note" id="j_custom_note" data-toggle="autoheight" cols="60" rows="1"></textarea>
            </div>
        </div>
    </form>
    <form id="custom_form" data-toggle="validate" data-alertmsg="false">
        <input type="hidden" name="custom.id" value="edce142bc2ed4ec6b623aacaf602a4de">
        <div class="bjui-row col-1">
            <label class="row-label">所属业务</label>
            <div class="row-input required">
                <select name="custom.sale" id="j_custom_sale" data-toggle="selectpicker" data-rule="required">
                    <option value="">全部</option>
                    <option value="1">业务1</option>
                    <option value="2">业务2</option>
                </select>
            </div>
            <label class="row-label">表示颜色</label>
            <div class="row-input">
                <input type="text" name="custom.color" id="j_custom_color" value="" data-toggle="colorpicker" data-bgcolor="true" size="10" readonly="">
                <a href="javascript:;" title="清除颜色" data-toggle="clearcolor" data-target="#j_custom_color">清除颜色</a>
            </div>
            <label class="row-label">职业</label>
            <div class="row-input">
                <input type="text" name="custom.profession" id="j_custom_profession" value="耍家" data-toggle="findgrid" data-options="{
            group: 'custom',
            include: 'profession:name',
            dialogOptions: {title:'查询职业'},
            gridOptions: {
                local: 'local',
                dataUrl: '../../json/datagrid-profession.json',
                columns: [
                    {name:'name', label:'名称', width:100},
                    {name:'desc', label:'描述'},
                    {name:'date', label:'创建日期'}
                ]
            }
        }">
            </div>
            <br>
            <label class="row-label">客人姓名</label>
            <div class="row-input required">
                <input type="text" name="custom.name" id="j_custom_name" value="张三" data-rule="required">
            </div>
            <label class="row-label">拼音姓</label>
            <div class="row-input required">
                <input type="text" name="custom.fname" id="j_custom_fname" value="Zhang" data-rule="required;letters">
            </div>
            <label class="row-label">拼音名</label>
            <div class="row-input required">
                <input type="text" name="custom.lname" id="j_custom_lname" value="San" data-rule="required;letters">
            </div>
            <label class="row-label">性别</label>
            <div class="row-input required">
                <input type="radio" name="custom.isshow" id="j_custom_sex1" data-toggle="icheck" value="true" data-rule="checked" data-label="男  ">
                <input type="radio" name="custom.isshow" id="j_custom_sex2" data-toggle="icheck" value="false" data-label="女">
            </div>
            <label class="row-label">出生日期</label>
            <div class="row-input required">
                <input type="text" name="custom.birthday" id="j_custom_birthday" value="1980-08-08" data-toggle="datepicker" data-rule="required;date">
            </div>
            <label class="row-label">出生地</label>
            <div class="row-input required">
                <input type="text" name="custom.birthplace" id="j_custom_birthplace" value="四川" data-rule="required">
            </div>
            <label class="row-label">居住地</label>
            <div class="row-input required">
                <input type="text" name="custom.add" id="j_custom_add" value="成都九眼桥" data-rule="required">
            </div>
            <label class="row-label">护照号</label>
            <div class="row-input required">
                <input type="text" name="custom.passportno" id="j_custom_passportno" value="" data-rule="required">
            </div>
            <label class="row-label">签发日期</label>
            <div class="row-input required">
                <input type="text" name="custom.issuedate" id="j_custom_issuedate" value="2014-10-01" data-toggle="datepicker" data-rule="required;date">
            </div>
            <label class="row-label">有效日期</label>
            <div class="row-input required">
                <input type="text" name="custom.indate" id="j_custom_indate" value="2024-09-30" data-toggle="datepicker" data-rule="required;date">
            </div>
            <label class="row-label">签发地</label>
            <div class="row-input required">
                <input type="text" name="custom.issueat" id="j_custom_issueat" value="成都" data-rule="required">
            </div>
            <br>
            <label class="row-label">手机</label>
            <div class="row-input required">
                <input type="text" name="custom.mobile" id="j_custom_mobile" value="" data-rule="required;mobile">
            </div>
            <label class="row-label">关键字</label>
            <div class="row-input">
                <input type="text" name="custom.tags" id="j_custom_tags" value="" data-toggle="tags" data-url="../../json/ajaxTags.json" data-width="100%" size="20" placeholder="输入关键字，回车提交">
            </div>
            <br>
            <label class="row-label">占床</label>
            <div class="row-input">
                <input type="checkbox" name="custom.room" id="j_custom_room" data-toggle="icheck" value="true" data-label="是否占床" checked="" data-rule="checked">
            </div>
            <label class="row-label">签证</label>
            <div class="row-input">
                <input type="checkbox" name="custom.visa" id="j_custom_visa" data-toggle="icheck" value="true" data-label="需要签证">
            </div>
            <label class="row-label">素食</label>
            <div class="row-input">
                <input type="checkbox" name="custom.vegetarian" id="j_custom_vegetarian" data-toggle="icheck" value="true" data-label="是否素食">
            </div>
            <label class="row-label">同行人数</label>
            <div class="row-input">
                <input type="text" name="custom.total" id="j_custom_total" value="1" size="" data-toggle="spinner" data-min="0" data-max="100" data-step="1" data-rule="integer">
            </div>
            <label class="row-label">备注</label>
            <div class="row-input">
                <textarea name="custom.note" id="j_custom_note" data-toggle="autoheight" cols="60" rows="1"></textarea>
            </div>
        </div>
    </form>
</div>