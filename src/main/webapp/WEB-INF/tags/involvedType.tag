<%@ tag import="com.utils.CommonValidate" %>
<%@ tag import="com.utils.SysInvolvedTypesVo" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
    if (value == null) {
        out.print("--");
    } else {
        String addr = "";
        if (!CommonValidate.isEmpty(value)) {
            addr = SysInvolvedTypesVo.getNameByCode(value);
            if (addr.equals("")) {
                addr = "--";
            }
            System.out.println(addr);
            out.print(addr);
        }
    }
%>