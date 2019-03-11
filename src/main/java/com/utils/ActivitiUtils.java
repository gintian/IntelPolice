package com.utils;

import org.activiti.engine.*;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

public class ActivitiUtils {

    public static RepositoryService repositoryService;

    public static RuntimeService runtimeService;

    public static TaskService taskService;

    public static FormService formService;

    public static HistoryService historyService;

    /**
     * 部署流程定义
     * 通过上传ZIP文件部署
     */
    public static void saveDeploye(FileInputStream fileInputStream, String fileName) {
        try {
            //将File类型的文件转化成ZipInputStream流
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            repositoryService.createDeployment()//创建部署对象
                    .name(fileName)//添加部署名称
                    .addZipInputStream(zipInputStream)//
                    .deploy();//完成部署
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过任务ID得到目标变量
     *
     * @param taskId
     * @param variable
     * @return
     */
    public static Object getVariableByTaskId(String taskId, String variable) {
        return taskService.getVariable(taskId, variable);
    }

    /**
     * 通过流程ID得到目标变量
     *
     * @param processId
     * @param variable
     * @return
     */
    public static Object getVariableByProcessId(String processId, String variable) {
        return historyService.createHistoricVariableInstanceQuery().processInstanceId(processId).variableName(variable).singleResult().getValue();
    }

    /**
     * 通过流程ID得到下一个一个任务
     *
     * @param processId
     * @return
     */
    public static String getNextTask(String processId) {
        HistoricActivityInstance hai = historyService.createHistoricActivityInstanceQuery()//
                .processInstanceId(processId)//
                .unfinished()
                .singleResult();
        return hai == null ? "流程已结束" : hai.getActivityName();
    }

    /**
     * 查看流程图
     *
     * @param deploymentId
     * @param diagramResourceName
     * @param response
     * @return
     * @throws Exception
     */
    public static String showView(String deploymentId, String diagramResourceName, HttpServletResponse response) throws Exception {
        InputStream inputStream = repositoryService.getResourceAsStream(deploymentId, diagramResourceName);
        OutputStream out = response.getOutputStream();
        for (int b = -1; (b = inputStream.read()) != -1; ) {
            out.write(b);
        }
        out.close();
        inputStream.close();
        return null;
    }

    /**
     * 查看流程图
     *
     * @param taskId
     * @param response
     * @return
     * @throws Exception
     */
    public static String showViewByTaskId(String taskId, HttpServletResponse response) throws Exception {
        HistoricTaskInstance hti = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        String processDefinitionId = hti.getProcessDefinitionId(); // 获取流程定义id
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        InputStream inputStream = repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getDiagramResourceName());
        OutputStream out = response.getOutputStream();
        for (int b = -1; (b = inputStream.read()) != -1; ) {
            out.write(b);
        }
        out.close();
        inputStream.close();
        return null;
    }

    /**
     * 查询部署对象列表信息，对应表（act_re_deployment）
     */
    public static List<Deployment> findDeploymentList() {
        List<Deployment> list = repositoryService.createDeploymentQuery()//创建部署对象查询
                .orderByDeploymenTime().asc()//
                .list();
        return list;
    }

    /**
     * 查询流程定义的列表信息，对应表（act_re_procdef）
     */
    public static List<ProcessDefinition> findProcessDefinitionList() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()//创建流程定义查询
                .orderByProcessDefinitionVersion().asc()//
                .list();
        return list;
    }

    /**
     * 通过流程key查询流程定义的信息，对应表（act_re_procdef）
     */
    public static ProcessDefinition findProcessDefinition(String processKey) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()//创建流程定义查询
                .processDefinitionKey(processKey.split("\\.")[0])
                .orderByProcessDefinitionVersion().asc()//
                .singleResult();
        return processDefinition;
    }

    /**
     * 使用部署对象ID和资源图片名称，获取图片的输入流
     */
    public static InputStream findImageInputStream(String deploymentId, String imageName) {
        return repositoryService.getResourceAsStream(deploymentId, imageName);
    }

    /**
     * 使用部署对象ID，删除流程定义
     */
    public static void deleteProcessDefinitionByDeploymentId(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
    }

    /**
     * 使用任务ID查询历史任务办理人
     *
     * @param taskId
     * @return
     */
    public static String findAssigneeByTaskId(String taskId) {
        HistoricTaskInstance task = historyService.createHistoricTaskInstanceQuery()
                .taskId(taskId)
                .singleResult();
        return task.getAssignee();
    }

    /**
     * 使用当前用户身份证号查询正在执行的任务总条数
     *
     * @param identityCard
     * @return
     */
    public static int findTaskCountByIdentityCard(String identityCard) {
        List<Task> list = taskService.createTaskQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .orderByTaskCreateTime().asc()//
                .list();
        return list.size();
    }

    /**
     * 使用当前用户身份证号查询正在执行的任务表，获取当前任务的集合List<Task>
     *
     * @param identityCard
     * @return
     */
    public static List<Task> findTaskListByIdentityCard(String identityCard) {
        List<Task> list = taskService.createTaskQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .orderByTaskCreateTime().asc()//
                .list();
        return list;
    }

    /**
     * 使用当前用户身份证号查询正在执行的任务表，获取当前任务分页的集合List<Task>
     *
     * @param identityCard
     * @return
     */
    public static List<Task> findTaskListByIdentityCard(String identityCard, String processKey, int firstResult, int maxResults) {
        List<Task> list = taskService.createTaskQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .processDefinitionKeyLike(processKey+"%")
                .orderByTaskCreateTime().asc()//
                .listPage(firstResult, maxResults);
        return list;
    }

    /**
     * 使用当前用户身份证号查询历史的任务总条数
     *
     * @param identityCard
     * @return
     */
    public static int findHistoricTaskCountByIdentityCard(String identityCard) {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .orderByTaskCreateTime().asc()//
                .list();
        return list.size();
    }

    /**
     * 使用历史流程实例ID，获取上一个任务
     *
     * @param processId
     * @return
     */
    public static HistoricTaskInstance findLastHistoricTaskByProcessId(String processId) {
        List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery()//
                .processInstanceId(processId)
                .orderByTaskCreateTime().desc()//
                .list();
        if (tasks.size() > 1) {
            return tasks.get(1);
        }
        return tasks.get(0);
    }

    /**
     * 使用历史流程实例ID，获取当前最新任务
     *
     * @param processId
     * @return
     */
    public static HistoricTaskInstance findCurrentHistoricTaskByProcessId(String processId) {
        HistoricTaskInstance task = historyService.createHistoricTaskInstanceQuery()//
                .processInstanceId(processId)
                .orderByTaskCreateTime().desc()//
                .list().get(0);
        return task;
    }

    /**
     * 使用当前用户身份证号查询历史的任务表，获取当前任务的集合List<Task>
     *
     * @param identityCard
     * @return
     */
    public static List<HistoricTaskInstance> findHistoricTaskListByIdentityCard(String identityCard) {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .orderByTaskCreateTime().asc()//
                .list();
        return list;
    }

    /**
     * 使用当前用户身份证号查询历史的任务表，获取当前任务分页的集合List<Task>
     *
     * @param identityCard
     * @return
     */
    public static List<HistoricTaskInstance> findHistoricTaskListByIdentityCard(String identityCard, int firstResult, int maxResults) {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .orderByTaskCreateTime().asc()
                .listPage(firstResult, maxResults);
        return list;
    }

    /**
     * 使用当前用户身份证号查询历史的流程表，获取当前流程分页的集合List<Task>
     *
     * @param identityCard
     * @return
     */
    public static List<HistoricProcessInstance> findHistoricProcessListByIdentityCard(String identityCard, String processKey, int firstResult, int maxResults) {
        List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery()//
                .taskAssignee(identityCard)//指定个人任务查询
                .processInstanceBusinessKeyLike(processKey + "%")//指定流程查询
                .finished()
                .listPage(firstResult, maxResults);
        List<HistoricProcessInstance> processes = new ArrayList<>();
        List processInstanceIds = new ArrayList();
        for (HistoricTaskInstance task : tasks) {
            //2：使用任务对象Task获取流程实例ID
            String processInstanceId = task.getProcessInstanceId();
            if (processInstanceIds.size() == 0 || !processInstanceIds.contains(processInstanceId)) {
                processInstanceIds.add(processInstanceId);
                HistoricProcessInstance pi = historyService.createHistoricProcessInstanceQuery()//
                        .processInstanceId(processInstanceId)//使用流程实例ID查询
                        .singleResult();
                processes.add(pi);
            }
        }
        return processes;
    }

    /**
     * 使用任务ID，获取当前任务节点中对应的Form key中的连接的值
     */
    public static String findTaskFormKeyByTaskId(String taskId) {
        TaskFormData formData = formService.getTaskFormData(taskId);
        //获取Form key的值
        String url = formData.getFormKey();
        return url;
    }

    /**
     * 获取整个流程批注信息，传递的是当前任务ID，获取历史任务ID对应的批注
     */
    public static List<Comment> findProcessInstanceCommentByTaskId(String taskId) {
        List<Comment> list = new ArrayList<Comment>();
        //使用当前的任务ID，查询当前流程对应的历史任务ID
        //使用当前任务ID，获取当前任务对象
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
//		//使用流程实例ID，查询历史任务，获取历史任务对应的每个任务ID
//		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()//历史任务表查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.list();
//		//遍历集合，获取每个任务ID
//		if(htiList!=null && htiList.size()>0){
//			for(HistoricTaskInstance hti:htiList){
//				//任务ID
//				String htaskId = hti.getId();
//				//获取批注信息
//				List<Comment> taskList = taskService.getTaskComments(htaskId);//对用历史完成后的任务ID
//				list.addAll(taskList);
//			}
//		}
        list = taskService.getProcessInstanceComments(processInstanceId);
        return list;
    }

    /**
     * 获取目标任务批注信息（历史任务），传递的是当前任务ID，获取历史任务ID对应的批注
     */
    public static List<Comment> findTaskCommentByTaskId(String taskId) {
        List<Comment> list = new ArrayList<Comment>();
        list = taskService.getTaskComments(taskId);
        return list;
    }

    /**
     * 1根据任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
     */
    public static ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
        //使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程定义ID
        String processDefinitionId = task.getProcessDefinitionId();
        //查询流程定义的对象
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()//创建流程定义查询对象，对应表act_re_procdef
                .processDefinitionId(processDefinitionId)//使用流程定义ID查询
                .singleResult();
        return pd;
    }

    /**
     * 根据流程定义ID获取流程实例
     */
    public static ProcessInstance getProcessInstanceByDefinitionId(String processDefinitionId) {
        return runtimeService.createProcessInstanceQuery()
                .processDefinitionId(processDefinitionId)
                .singleResult();
    }

    /**
     * 根据任务ID，获取流程实例ID
     *
     * @param taskId
     * @return
     */
    public static String getProcessInstanceIdByTaskId(String taskId) {
        //使用任务ID，查询任务对象，获取流程流程实例ID
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程实例ID
        return task.getProcessInstanceId();
    }

    /**
     * 根据流程实例ID，获取任务ID
     *
     * @param processInstanceId
     * @return
     */
    public static String getTaskIdByProcessInstanceId(String processInstanceId) {
        //使用任务ID，查询任务对象，获取流程流程实例ID
        Task task = taskService.createTaskQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .active()
                .singleResult();
        //获取流程实例ID
        return task.getId();
    }

    /**
     * 根据流程实例ID，查询流程是否完成
     *
     * @param processInstanceId
     * @return
     */
    public static boolean isProcessEnd(String processInstanceId) {
        //在完成任务之后，判断流程是否结束
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        if (pi == null) {
            return true;
        }
        return false;
    }

    /**
     * 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中
     */
    public static List<String> findOutComeListByTaskId(String taskId) {
        //返回存放连线的名称集合
        List<String> list = new ArrayList<String>();
        //1:使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //2：获取流程定义ID
        String processDefinitionId = task.getProcessDefinitionId();
        //3：查询ProcessDefinitionEntiy对象
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
        //使用任务对象Task获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        //获取当前活动的id
        String activityId = pi.getActivityId();
        //4：获取当前的活动
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
        //5：获取当前活动完成之后连线的名称
        List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
        if (pvmList != null && pvmList.size() > 0) {
            for (PvmTransition pvm : pvmList) {
                String name = (String) pvm.getProperty("name");
                if (StringUtils.isNotBlank(name)) {
                    list.add(name);
                } else {
                    list.add("提交");
                }
            }
        }
        return list;
    }

    /**
     * 查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
     * map集合的key：表示坐标x,y,width,height
     * map集合的value：表示坐标对应的值
     */
    public static Map<String, Object> findCoordingByTask(String taskId) {
        //存放坐标
        Map<String, Object> map = new HashMap<String, Object>();
        //使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程定义的ID
        String processDefinitionId = task.getProcessDefinitionId();
        //获取流程定义的实体对象（对应.bpmn文件中的数据）
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
        //流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();
        //获取当前活动的ID
        String activityId = pi.getActivityId();
        //获取当前活动对象
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
        //获取坐标
        map.put("x", activityImpl.getX());
        map.put("y", activityImpl.getY());
        map.put("width", activityImpl.getWidth());
        map.put("height", activityImpl.getHeight());
        return map;
    }
}
