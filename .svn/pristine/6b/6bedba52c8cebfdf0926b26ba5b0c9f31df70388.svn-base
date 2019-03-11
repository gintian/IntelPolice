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
 * 信息
 */
public class SmsLogConnection implements Runnable{
    private static Logger logger = Logger.getLogger(SmsLogConnection.class);
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
        Connection sourceConn = DbUtils.getConnection("dbSmsLog");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_SMS_LOG, CommonConstant.DATAENDTIME_SMS_LOG);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();
                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错", e);;
                return;
            }
            try {
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int sms_log_count = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);
                    String propertiesName = "configSmsLog";
                    logger.info("------------------------开始备份sms_log数据-------------------------");
                    sms_log_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"sms_log", propertiesName);
                    logger.info("------------------------备份sms_log结束------------------------------");


                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("sms_log_count:" + sms_log_count);
                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), sms_log_count, "1", stringBuilder.toString(), startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "信息",
                            CommonConstant.SYSNC_SMS_LOG);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();
                }

            } catch (Exception e) {
                logger.error("出错", e);;
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
