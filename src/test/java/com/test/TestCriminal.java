package com.test;

import com.constant.CommonConstant;
import com.model.Criminal;
import com.model.bean.CriminalBean;
import com.page.PageBean;
import com.service.mapper.CriminalBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20 0020.
 */
public class TestCriminal {
    private CriminalBeanMapper criminalBeanMapper;

    //分页相关的参数，请谨慎修改

    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new
                String[]{"applicationContext.xml"});
        criminalBeanMapper = ac.getBean(CriminalBeanMapper.class);
    }

    @Test
    public void test01() throws Exception{
        PageBean<Criminal> pageBean = new PageBean<Criminal>();
        pageBean.setPage(1);
        pageBean.setPageSize(PageBean.PAGESIZE);
        CriminalBean bean = new CriminalBean();
        List<CriminalBean> list = criminalBeanMapper.findBeanPageForModule(pageBean, bean, CommonConstant.MODULE_RECORD_NOINPUT);
        System.out.println(list);
    }
}
