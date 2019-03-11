package com.test;

import com.model.bean.DeptBean;
import com.page.PageBean;
import com.service.DeptService;
import com.service.mapper.DeptBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/4/20 0020.
 */
public class TestDept {
    private DeptBeanMapper deptBeanMapper;
    private DeptService deptService;
    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new
                String[]{"applicationContext.xml"});
        deptBeanMapper = ac.getBean(DeptBeanMapper.class);
        deptService= ac.getBean(DeptService.class);
    }

    @Test
    public void test01() throws Exception{
        deptService.cacheDeptAll();
    }
}
