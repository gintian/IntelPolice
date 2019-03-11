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
 * 温湿度计
 */
public class HumitureConnection implements Runnable{
    private static Logger logger = Logger.getLogger(HumitureConnection.class);
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
        Connection sourceConn = DbUtils.getConnection("dbHumiture");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_HUMITURE, CommonConstant.DATAENDTIME_HUMITURE);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();
                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                logger.error("出错", e);;
                return;
            }
            try {
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int pipUnitZjCount = 0;
                    int bpipUnitCount = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);

                    logger.info("------------------------开始备份bpipUnitTask数据-------------------------");
                    bpipUnitCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"dbUnit", "configUnit");
                    logger.info("------------------------备份bpipUnitTask结束------------------------------");


                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), bpipUnitCount, "1", "bpip_unit:" + bpipUnitCount + "&#&bpip_unit_zj:" + pipUnitZjCount, startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "温湿度计",
                            CommonConstant.SYSNC_HUMITURE);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();
                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错", e);;
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
