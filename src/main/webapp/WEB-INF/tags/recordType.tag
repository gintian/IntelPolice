<%@ tag import="com.utils.CommonValidate" %>
<%@ tag import="com.utils.SysRecordTypeVo" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
    if (value == null) {
        out.print("--");
    } else {
        String addr = "";
        System.out.println(value);
        if (!CommonValidate.isEmpty(value)) {
            addr = SysRecordTypeVo.getNameById(value);
            if (addr.equals("")) {
                addr = "--";
            }
            System.out.println(addr);
            out.print(addr);
        }
    }
%>