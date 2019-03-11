package com.conn;

import com.constant.CommonConstant;
import com.model.DataSyncTask;
import com.task.AllTask;
import com.utils.*;
import com.utils.ws.Exception_Exception;
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
 * 机构同步任务
 */
public class BpipConnection implements Runnable{
    private static Logger logger = Logger.getLogger(BpipConnection.class);
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
        Connection sourceConn = DbUtils.getConnection("dbUnit");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");

        String areId = PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.AREAID,"system");

        String sync_all = PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SYNC_ALL,"System");

        try {
            //数据备份实体类
            DataSyncTask dataSyncTask = null;
            //执行时间点
            Date execDate = null;
            //开始时间
            String dateStrat = null;
            //结束时间
            String dateEnd = null;

            //获取数据备份实体
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_BPIP, CommonConstant.DATAENDTIME_UNIT);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();

                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                //异常抛出结束
                logger.info(e.getMessage());
                logger.error("出错",e);
                return;
            }
            try {
                //判断任务执行时间点是否是当前时间段内
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {

                    Date startDate = new Date();
                    int pipUnitZjCount = 0;
                    int bpipUnitCount = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);

                    logger.info("------------------------开始备份bpipUnitTask数据");
                    bpipUnitCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"dbUnit", "configUnit");
                    logger.info("------------------------备份bpipUnitTask结束------------------------------");

                    logger.info("------------------------开始备份BpipUnitZjTask数据-----------------------");
                    pipUnitZjCount = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"dbUnitZj", "configUnit");
                    logger.info("------------------------备份BpipUnitZjTask 结束-------------------------");

                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), bpipUnitCount, "1", "bpip_unit:" + bpipUnitCount + "&#&bpip_unit_zj:" + pipUnitZjCount, startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "部门",
                            CommonConstant.SYSNC_BPIP);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();

                    if (sync_all.equals("1")){
                        dateStrat = "";
                        dateEnd = "";
                    }

                    final String areIdS = areId;
                    final String dateStratS = dateStrat;
                    final String dateEndS = dateEnd;

                    Thread th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                WebServiceUtils.getWebServiceAnalysis().doAnalysisBpipUnit(areIdS, dateStratS, dateEndS);
                            } catch (Exception_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    th.start();
                }

            } catch (Exception e) {
                //抛出异常，终止整个模块的备份，数据回滚
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