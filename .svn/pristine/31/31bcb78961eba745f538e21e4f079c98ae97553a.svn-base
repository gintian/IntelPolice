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
 * 毒品
 */
public class DurgConnection implements Runnable{
    private static Logger logger = Logger.getLogger(DurgConnection.class);
    @Override
    public void run() {
        try {
            doSynchronized();
        } catch (Exception e) {
            logger.debug("出错",e);
        }
    }
    private AllTask allTask = new AllTask();
    private synchronized void doSynchronized() throws Exception{
        //源数据库
        Connection sourceConn = DbUtils.getConnection("dbDurg");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_DURG, CommonConstant.DATAENDTIME_DURG);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();
                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                logger.info(e.getMessage());
                logger.error("出错",e);

                return;
            }
            try {
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int durg_m_criminal_count = 0;
                    int durg_s_booty_count = 0;
                    int durg_s_funds_count = 0;
                    int durg_s_kinds_count = 0;
                    int durg_s_material_count = 0;


                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);
                    String propertiesName = "configDurg";
                    logger.info("------------------------开始备份durg_m_criminal数据-------------------------");
                    durg_m_criminal_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"durg_m_criminal", propertiesName);
                    logger.info("------------------------备份durg_m_criminal结束------------------------------");

                    logger.info("------------------------开始备份durg_s_booty数据-----------------------");
                    durg_s_booty_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"durg_s_booty", propertiesName);
                    logger.info("------------------------备份durg_s_booty结束-------------------------");

                    //---------
                    logger.info("------------------------开始备份durg_s_funds数据-----------------------");
                    durg_s_funds_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"durg_s_funds", propertiesName);
                    logger.info("------------------------备份durg_s_funds结束-------------------------");

                    logger.info("------------------------开始备份durg_s_kinds数据-----------------------");
                    durg_s_kinds_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"durg_s_kinds", propertiesName);
                    logger.info("------------------------备份durg_s_kinds结束-------------------------");

                    logger.info("------------------------开始备份durg_s_material数据-----------------------");
                    durg_s_material_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"durg_s_material", propertiesName);
                    logger.info("------------------------备份durg_s_material结束-------------------------");


                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("durg_m_criminal:" + durg_m_criminal_count);
                    stringBuilder.append("&#&durg_s_booty:" + durg_s_booty_count);
                    stringBuilder.append("&#&durg_s_funds_count:" + durg_s_funds_count);
                    stringBuilder.append("&#&durg_s_kinds_count:" + durg_s_kinds_count);
                    stringBuilder.append("&#&durg_s_material_count:" + durg_s_material_count);
                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), durg_m_criminal_count, "1", stringBuilder.toString(), startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "毒品",
                            CommonConstant.SYSNC_DURG);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();
                }

            } catch (Exception e) {
                logger.error("出错",e);
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
