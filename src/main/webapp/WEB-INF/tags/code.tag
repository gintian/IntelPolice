<%@ tag import="com.utils.CommonValidate" %>
<%@ tag import="com.utils.SysCodeVo" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%@ attribute name="field" type="java.lang.String" required="false" %>
<%
    if (value == null) {
        out.print("--");
    } else {
        String code_desc = "";
        System.out.println(value);
        if (!CommonValidate.isEmpty(value)) {
            code_desc = SysCodeVo.getCodeDescByFieldAndCode(field , value);
            if (code_desc.equals("")) {
                code_desc = "--";
            }
            System.out.println(code_desc);
            out.print(code_desc);
        }
    }
%>