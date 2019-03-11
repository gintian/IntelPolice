package com.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * web输入校验类
 */
public class WebUtils {

    //获取客户端IP
    public static String getLocalRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    public static String getModelByUserAgentHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        if (org.apache.commons.lang3.StringUtils.isEmpty(userAgent)) {
            return null;
        }
        Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
        Matcher matcher = pattern.matcher(userAgent);
        String model = null;
        if (matcher.find()) {
            model = matcher.group(1).trim();
        }
        return model;
    }

    /**
     * 处理分页页码
     *
     * @param pageIndexString
     * @return
     */
    public static int handlePageIndex(String pageIndexString) {
        int page = 1;
        if (!StringUtils.isEmpty(pageIndexString)) {
            try {
                page = Integer.valueOf(pageIndexString);
                if (page < 1) {
                    page = 1;
                }
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        return page;
    }


    /**
     * 获得跟路径，这个路径包括IP及端口
     *
     * @return
     */
    public static String getFullRoot(HttpServletRequest request) {
        String serverName = request.getServerName();
        Integer port = request.getServerPort();
        String contextPath = request.getContextPath();
        StringBuilder root = new StringBuilder("http://");
        root.append(serverName);
        if (port != null && port != 80) {
            root.append(":");
            root.append(port);
        }
        if (!StringUtils.isEmpty(contextPath)) {
            root.append(contextPath);
        }
        return root.toString();
    }

    /**
     * 获取访问的url地址
     *
     * @param request
     * @return
     */
    public static String getAccessUrl(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();
        StringBuilder url = new StringBuilder(getFullRoot(request));
        if (!StringUtils.isEmpty(servletPath)) {
            url.append(servletPath);
        }
        if (!StringUtils.isEmpty(queryString)) {
            url.append("?");
            url.append(queryString);
        }
        return url.toString();
    }

    public static String getBrowserName(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        agent = agent.toLowerCase();
        if (agent.indexOf("msie 7") > 0) {
            return "ie7";
        } else if (agent.indexOf("msie 8") > 0) {
            return "ie8";
        } else if (agent.indexOf("msie 9") > 0) {
            return "ie9";
        } else if (agent.indexOf("msie 10") > 0) {
            return "ie10";
        } else if (agent.indexOf("msie") > 0) {
            return "ie";
        } else if (agent.indexOf("opera") > 0) {
            return "opera";
        } else if (agent.indexOf("opera") > 0) {
            return "opera";
        } else if (agent.indexOf("firefox") > 0) {
            return "firefox";
        } else if (agent.indexOf("webkit") > 0) {
            return "webkit";
        } else if (agent.indexOf("gecko") > 0 && agent.indexOf("rv:11") > 0) {
            return "ie11";
        } else {
            return "Others";
        }
    }
}
