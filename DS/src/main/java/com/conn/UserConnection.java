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
 * 用户同步任务
 */
public class UserConnection implements Runnable{
    private static Logger logger = Logger.getLogger(UserConnection.class);
    @Override
    public void run() {
        try {
            doSynchronized();
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }
    private AllTask allTask = new AllTask();

    private synchronized void doSynchronized() throws Exception{

        Connection sourceConn = DbUtils.getConnection("dbUser");
        //备份库
        Connection targetConn = DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_USER, CommonConstant.DATAENDTIME_USER);
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
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int count = 0;
                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);
                    //key
                    String key = CommonConstant.SYSNC_USER;
                    //属性文件名
                    String propertiesName = "configUser";
                    logger.info("------------------------开始备份bpipUserTask数据 "+DateUtils.getCurrentDateTime()+"-----------------------");
                    count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,key, propertiesName);
                    logger.info("------------------------备份BbpipUserTask 结束"+DateUtils.getCurrentDateTime()+"-------------------------");

                    //记录日志
                    LogUtils.updateDataSyncLog(dataSyncTask.getId(), new Date(), count, "1", "bpip_user:" + count, startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "用户",
                            CommonConstant.SYSNC_USER);

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
            //连接释放
            DbUtils.close(sourceConn);
            DbUtils.close(targetConn);
        }
    }
}
