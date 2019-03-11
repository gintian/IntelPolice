package com.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.CJ;
import com.service.CJService;

public class TestCJ {
	private CJService service;
	/**
	* 这个 before 方法在所有的测试方法之前执行，并且只执行一次
	* 所有做 Junit 单元测试时一些初始化工作可以在这个方法里面进行
	* 比如在 before 方法里面初始化 ApplicationContext 和 userService
	*/
	@Before
	public void before(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new
				String[]{"spring.xml","spring-hibernate.xml"});
		service = (CJService) ac.getBean("cjService");
	}
	
	@Test
	public void testa() throws Exception {

	}
	
}
