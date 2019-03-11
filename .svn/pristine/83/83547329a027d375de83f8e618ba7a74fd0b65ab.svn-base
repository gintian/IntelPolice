package com.conn;

import com.constant.CommonConstant;
import com.model.DataSyncTask;
import com.task.AllTask;
import com.utils.DateUtils;
import com.utils.DbUtils;
import com.utils.LogUtils;
import com.utils.PropertiesUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by tl on 2018/5/21 0021.
 * 受立案监督
 */
public class InvestigationConnection implements Runnable{
    private static Logger logger = Logger.getLogger(InvestigationConnection.class);
    @Override
    public void run() {
        try {
            doSynchronized();
        } catch (Exception e) {
            logger.debug("出错", e);
        }
    }
    private AllTask allTask = new AllTask();
    private synchronized void doSynchronized() throws Exception{
        //源数据库
        Connection sourceConn = DbUtils.getConnection("dbInvestigation");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_INVESTIGATION, CommonConstant.DATAENDTIME_INVESTIGATION);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();
                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                logger.info(e.getMessage());
                logger.error("出错", e);;
                return;
            }
            try {
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int exp_alarm_count = 0;
                    int exp_inform_count = 0;
                    int exptype_count = 0;
                    int juc_dept_count = 0;
                    int keywords_count = 0;
                    int related_count = 0;
                    int sup_alarm = 0;
                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);

                    logger.info("------------------------开始备份ea_investigation_exp_alarm数据-------------------------");
                    exp_alarm_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_exp_alarm", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_exp_alarm结束------------------------------");

                    logger.info("------------------------开始备份ea_investigation_exp_inform数据-------------------------");
                    exp_inform_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_exp_inform", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_exp_inform结束------------------------------");

                    logger.info("------------------------开始备份ea_investigation_exptype数据-------------------------");
                    exptype_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_exptype", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_exptype结束------------------------------");

                    logger.info("------------------------开始备份ea_investigation_juc_dept数据-------------------------");
                    juc_dept_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_juc_dept", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_juc_dept结束------------------------------");

                    logger.info("------------------------开始备份ea_investigation_keywords数据-------------------------");
                    keywords_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_keywords", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_keywords结束------------------------------");

                    logger.info("------------------------开始备份ea_investigation_related数据-------------------------");
                    related_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_related", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_related结束------------------------------");

                    logger.info("------------------------开始备份ea_investigation_sup_alarm数据-------------------------");
                    sup_alarm = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"ea_investigation_sup_alarm", "configInvestigation");
                    logger.info("------------------------备份ea_investigation_sup_alarm结束------------------------------");


                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), exp_alarm_count, "1", "bpip_unit:" + exp_alarm_count
                            + "&#&exp_inform_count:" + exp_inform_count
                            + "&#&exptype_count:" + exptype_count
                            + "&#&exp_inform_count:" + exp_inform_count
                            + "&#&juc_dept_count:" + juc_dept_count
                            + "&#&keywords_count:" + keywords_count
                            + "&#&related_count:" + related_count
                            + "&#&sup_alarm:" + sup_alarm, startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "部门",
                            CommonConstant.SYSNC_INVESTIGATION);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();
                }

            } catch (Exception e) {
                logger.error("出错", e);
                e.printStackTrace();
                try {
                    logger.info("sourceConn回滚");
                    sourceConn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    logger.info("targetConn回滚");
                    targetConn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }finally {
            //释放连接
            DbUtils.close(sourceConn);
            DbUtils.close(targetConn);
        }
    }
}
