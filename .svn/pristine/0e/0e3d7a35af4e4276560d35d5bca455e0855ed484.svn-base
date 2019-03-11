<%@ tag import="com.utils.CommonValidate" %>
<%@ tag import="com.utils.SysDictoryVo" %>
<%@ tag import="java.util.List" %>
<%@ tag import="com.model.bean.DictoryBean" %>
<%@ tag import="com.constant.Indicator" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %> <%--  保存的值 --%>
<%@ attribute name="type" type="java.lang.String" required="true" %> <%--  如：SYS_DICTORY_TYPE_5 --%>
<%@ attribute name="valueType" type="java.lang.String" required="true" %><%--value,id--%>
<!--
根据数据字典标签值',,输出第一个能匹配的标签名
-->
<%
    if (CommonValidate.isEmpty(value)) {
        out.print("--");
    } else {
        Indicator indicator = Indicator.valueOf(type);
        List<DictoryBean> sysDictoryList = SysDictoryVo.getDictoryBeanList(Integer.valueOf(indicator.getCode()));
        for (DictoryBean sysDictory : sysDictoryList) {
            if ("value".equals(valueType)) {
                if (sysDictory.getValue().equals(value)) {
                    out.print(sysDictory.getLabel());
                    return;
                }
            } else if ("id".equals(valueType)) {
                if (sysDictory.getId().equals(value)) {
                    out.print(sysDictory.getLabel());
                    return;
                }
            }

        }
    }
%>