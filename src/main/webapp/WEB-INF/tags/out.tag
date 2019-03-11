<%@ tag import="com.utils.CommonValidate" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%@ attribute name="length" type="java.lang.Integer" required="false" %>
<%@ attribute name="outType" type="java.lang.Integer" required="false"%>
<%@attribute name="defaultValue" type="java.lang.Object" required="false" %>
<%--
type=0 普通输出：无替换
type=1 textarea输出：替换换行符
type=2 input输出：替换为空格
type=3 页面输出：替换为br标签
type=3 页面输出：替换为br标签
type=4 去掉\r\n
type=5 将逗号分隔的字符串转成换行输入，如列表中输出一个人的角色，只在某些地方专用
type=6 替换html标签，可用于富文本框输入内容后，在列表显示等地方
type=7 关键html标签转义
type=8 富文本输出：替换为<
--%>
<%
    if(value==null || "".equals(value)) {
        if(CommonValidate.isEmpty(defaultValue)){
            out.print("--");
        }else {
            out.print(defaultValue);
        }
    }else {
        //替换换行符
        if(outType != null){
            if(outType == 1){
                value = value.replaceAll("\n", "\\\\n");
            }else if(outType == 2){
                value = value.replaceAll("\n", "　");
            }else if(outType == 3){
                value = value.replaceAll("\n", "<br/>");
            }else if(outType == 4){
                value = value.replaceAll("\r\n","");
            }else if(outType == 5){
                value = value.replaceAll(",", "<br/>");
            }else if(outType == 6){
                value = value.replaceAll("</?[^>]+/?>","");//替换所有html标签
            }else if(outType == 7){
                value = value.replaceAll("&", "&amp;");
                value = value.replaceAll("<", "&lt;");
                value = value.replaceAll(">", "&gt;");
                value = value.replaceAll(" ", "&nbsp;");
            }else if(outType == 8){
                value = value.replaceAll("&lt;", "&amp;lt;");
            }
        }
        //限制长度
        if(length==null || length<=0) {
            out.print(value);
        }else {
            //有长度限制
            int valueLength = value.length();
            if(valueLength <= length) {
                out.print(value);
            }else {
                String outStr = value.substring(0, length-1);
                outStr += "...";
                out.print(outStr);
            }
        }
    }
%>

