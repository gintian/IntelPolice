package com.test;

import com.activiti.service.InvolvedActivitiService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestActiviti {
    @Autowired
    private InvolvedActivitiService involvedActivitiService;
	/**
     * 测试创建流程引擎并自动创建表
     */  
    @Test  
    public void test1() {  
        // 创建一个流程引擎配置对象 
        ApplicationContext ac = new ClassPathXmlApplicationContext(new
				String[]{"applicationContext.xml","applicationContext-activiti.xml"});
        ProcessEngineConfiguration conf = (ProcessEngineConfiguration) ac.getBean("processEngineConfiguration");
        //ProcessEngineConfiguration conf = (ProcessEngineConfiguration) ac.getBean("involvedActivitiService");
        conf.setDatabaseSchemaUpdate("drop-create");
        ProcessEngine processEngine = conf.buildProcessEngine();
        System.out.println("processEngine:"+ processEngine);
    }  
    
    /**
     * addInputStream方式
     * @throws Exception
     */
    @Test
	public void testAddInputStream() throws Exception {
//        InputStream inputStream=ProcessEnginesDemo.class.getClassLoader().getResourceAsStream("demo1.bpmn");  
//        Deployment deploy = repositoryService.createDeployment().addInputStream("addInputStream", inputStream).deploy();  
//       System.out.println(deploy);  
	}
    
    /**
     *addZipInputStream方式
     * @throws Exception
     */
    @Test
	public void testAddZipInputStream() throws Exception {
//    	InputStream inputStream=ProcessEnginesDemo.class.getClassLoader().getResourceAsStream("demo1.zip");
//    	ZipInputStream zipInputStream=new ZipInputStream(inputStream);
//    	Deployment deploy2 =repositoryService.createDeployment().addZipInputStream(zipInputStream).deploy();
	}

    /**
     * 测试通过task得到财务
     */
    @Test
    public void testGetInvolved() throws Exception {
//        List<Task> list = involvedActivitiService.findTaskListByIdentityCard("1");
//            System.out.println(list);
    }
}
