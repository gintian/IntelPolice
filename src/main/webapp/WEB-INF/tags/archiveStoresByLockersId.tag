<%@ tag import="com.utils.CommonValidate" %>
<%@ tag import="com.utils.SysArchiveStoresByLockersIdVo" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" body-content="empty" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<%
    if (value == null) {
        out.print("--");
    } else {
        String addr = "";
        System.err.println(value);
        if (!CommonValidate.isEmpty(value)) {
            addr = SysArchiveStoresByLockersIdVo.getNameById(value);
            if (addr.equals("")) {
                addr = "--";
            }
            System.out.println(addr);
            out.print(addr);
        }
    }
%>