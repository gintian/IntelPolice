package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class TestSpring {
	@Test
	public void test(){
		//通过 spring.xml 配置文件创建 Spring 的应用程序上下文环境
		//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
		ApplicationContext ac = new ClassPathXmlApplicationContext(new
				String[]{"spring.xml","spring-hibernate.xml"});
		//从 Spring 的 IOC 容器中获取 bean 对象
		UserService userService = (UserService) ac.getBean("userService");
	}
}
