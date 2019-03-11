package com.utils;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import com.model.User;

/**
 * Created by Administrator on 2018/4/11 0011.
 */
public class CheckPermissionTag extends BodyTagSupport {
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {

        //this.getBodyContent()得到代表标签体的bodyContent对象
        BodyContent bodyContent = this.getBodyContent();

        //拿到标签体
        String content = bodyContent.getString();
        HttpSession session = this.pageContext.getSession();

        try {
            //判断当前的用户是否是系统管理员角色
            User user = (User) session.getAttribute(SessionKey.USER);
            if (user.getId().equals("1") || user.getDeptId().equals("-1")) {
                //不做权限拦截，直接输出内容
                //输出修改后的内容
                this.pageContext.getOut().write(content);
            } else {
                boolean flag = AccessUtils.isPatternUri(url, (Set<String>) session.getAttribute(SessionKey.USER_PERMISSION_URL));
                if (flag) {
                    //输出修改后的内容
                    this.pageContext.getOut().write(content);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Tag.EVAL_PAGE;
    }
}
