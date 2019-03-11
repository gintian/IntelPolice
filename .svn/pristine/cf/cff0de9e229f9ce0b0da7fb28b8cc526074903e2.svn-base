package com.test;

import com.exception.WebMessageException;
import com.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.MenuService;

public class TestMenu {
	private MenuService menuService;
	
	@Before
	public void before(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new
				String[]{"applicationContext.xml"});
		menuService = (MenuService) ac.getBean("menuService");
	}
	@Test
	public void test011(){
		try {
			System.out.println(menuService.findMenuBeanList());
		} catch (WebMessageException e) {

		}
	}
}
