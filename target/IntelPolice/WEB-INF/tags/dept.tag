<%@ tag import="com.utils.CommonValidate" %>
<%@ tag import="com.model.bean.DeptBean" %>
<%@ tag import="com.utils.SysDeptVo" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
    if (value == null) {
        out.print("--");
    } else {
        String addr = "";
        if (!CommonValidate.isEmpty(value)) {
            addr = SysDeptVo.getNameById(value);
            if (addr.equals("")) {
                addr = "--";
            }
            out.print(addr);
        }
    }
%>