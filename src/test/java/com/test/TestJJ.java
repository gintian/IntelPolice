package com.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.model.JJ;
import com.service.JJService;

public class TestJJ {
	@Autowired
	private JJService jjService;
	/**
	* 这个 before 方法在所有的测试方法之前执行，并且只执行一次
	* 所有做 Junit 单元测试时一些初始化工作可以在这个方法里面进行
	* 比如在 before 方法里面初始化 ApplicationContext 和 userService
	*/
	@Before
	public void before(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new
				String[]{"spring.xml","spring-hibernate.xml"});
		jjService = (JJService) ac.getBean("jjService");
	}
	
	
	
	@Test
	public void testa() {
		System.out.println(jjService.getClass());
//		List<JJ> list = jjService.getAll("JJ");
//		for (int j = 0; j < list.size(); j++) {
//			System.out.println(list.get(j));
//		}
	}
	
	@Test
	public void testb() {
	    Date date=new Date();      
	    //输出毫秒值    
	    System.out.println(JSON.toJSONString(date));    
	    //默认格式为yyyy-MM-dd HH:mm:ss      
	    System.out.println(JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));    
	    //根据自定义格式输出日期   第一个参数是obj类型  
	    System.out.println(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:ss", SerializerFeature.WriteDateUseDateFormat));   
	}
}
