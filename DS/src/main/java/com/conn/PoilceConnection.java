package com.conn;

import com.constant.CommonConstant;
import com.model.DataSyncTask;
import com.task.*;
import com.utils.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by tl on 2018/5/21 0021.
 * 110  备份任务
 */
public class PoilceConnection implements Runnable{
    private static Logger logger = Logger.getLogger(PoilceConnection.class);
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
        Connection sourceConn = DbUtils.getConnection("dbPoilce");
        //备份库
        Connection targetConn = DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_POILCE, CommonConstant.DATAENDTIME_POILCE);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();
                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错", e);
                return;
            }
            try {
                //判断时间，是否在当前时间以前
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int jjdbCount = 0;
                    int cjdbCount = 0;
                    int fkdbCount = 0;
                    int lydbCount = 0;
                    int jqrybCount = 0;
                    int hfdbCount = 0;
                    int sjglbCount = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);
                    String propertiesName = "configPolice";
                    logger.info("------------------------开始备份jjdbTask数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    jjdbCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"jjdb", propertiesName);
                    logger.info("------------------------备份jjdbTask结束:"+DateUtils.getCurrentDateTime()+"-------------------------");

                    logger.info("------------------------开始备份cjdbTask数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    cjdbCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"cjdb", propertiesName);
                    logger.info("------------------------备份cjdbTask结束:"+DateUtils.getCurrentDateTime()+"-------------------------");

                    logger.info("------------------------开始备份fkdb数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    fkdbCount  = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"fkdb", propertiesName);
                    logger.info("------------------------备份fkdb结束:"+DateUtils.getCurrentDateTime()+"-------------------------");

                    logger.info("------------------------开始备份lydb数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    lydbCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"lydb", propertiesName);
                    logger.info("------------------------备份lydb结束:"+DateUtils.getCurrentDateTime()+"-------------------------");

                    logger.info("------------------------开始备份jqryb数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    jqrybCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"jqryb", propertiesName);
                    logger.info("------------------------备份jqryb结束:"+DateUtils.getCurrentDateTime()+"-------------------------");

                    logger.info("------------------------开始备份hfdb数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    hfdbCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"hfdb", propertiesName);
                    logger.info("------------------------备份hfdb结束:"+DateUtils.getCurrentDateTime()+"-------------------------");

                    logger.info("------------------------开始备份sjglb数据:"+DateUtils.getCurrentDateTime()+"-----------------------");
                    sjglbCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"sjglb", propertiesName);
                    logger.info("------------------------备份sjglb结束:"+DateUtils.getCurrentDateTime()+"-------------------------");


                    //记录日志
                    LogUtils.updateDataSyncLog(dataSyncTask.getId(),
                            new Date(),
                            jjdbCount,
                            "1",
                            "JJDB:" + jjdbCount +
                                    "&#&CJDB:" + cjdbCount +
                                    "&#&FKDB:" + fkdbCount +
                                    "&#&LYDB:" + lydbCount +
                                    "&#&JQRYDB:" + jqrybCount+
                                    "&#&hfdbCount:" + hfdbCount+
                                    "&#&sjglbCount:" + sjglbCount,
                            startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "110",
                            CommonConstant.SYSNC_POILCE);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错", e);
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
            logger.info("关闭释放连接!");
            DbUtils.close(sourceConn);
            DbUtils.close(targetConn);
        }
    }
}
