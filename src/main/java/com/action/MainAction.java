package com.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constant.Url;
import com.model.Menu;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MainService;

/**
 * 类名称：MainAction
 * 类描述：用户控制器的实现
 */
@Action(value = Url.MAIN)//使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action 的名字为 struts2Test
//@Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class MainAction extends ActionSupport {
    /**
     * 注入 userService
     */
    @Autowired
    private MainService mainService;

    @ResponseBody
    public List<Menu> menu() throws Exception {
        return null;
    }
}
