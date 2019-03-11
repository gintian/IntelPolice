package com.listener;

import com.exception.WebMessageException;
import com.service.AccessManager;
import com.service.DeptService;
import com.service.DictoryService;
import com.service.MenuService;
import com.service.mapper.MenuBeanMapper;
import com.utils.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2018/4/16 0016.
 */
public class WebContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
   private AccessManager accessManager;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("spring容器启动完成后，所做的事情！缓存");

        //开启线程，
       Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //缓存部门信息
                try {
                    System.out.println("============================strat cache data====================");
                    //缓存数据
                    accessManager.doCacheData();

                    System.out.println("============================end cache data======================");

                    //手动注入service

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("系统启动，缓存出问题！");
                }
            }
        });
       thread.start();
    }
}
