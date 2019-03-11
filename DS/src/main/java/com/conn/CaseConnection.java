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
 * 案事件
 */
public class CaseConnection implements Runnable{
    private static Logger logger = Logger.getLogger(CaseConnection.class);
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
        Connection sourceConn = DbUtils.getConnection("dbCase");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_CASE, CommonConstant.DATAENDTIME_CASE);
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
                    int case_m_110cmd_count = 0;
                    int case_m_criminal_count = 0;
                    int case_s_caseinfo_count = 0;
                    int case_s_progress_count = 0;
                    int case_s_move_count = 0;
                    int case_r_sufferpsn_count = 0;
                    int case_s_dellog_count = 0;
                    //-----------------------------
                    int case_r_suspicionpsn_count = 0;
                    int case_s_peculiarity_count = 0;
                    int case_s_progresschange_count = 0;
                    int case_s_resolve_count = 0;
                    int case_s_resort_count = 0;
                    int case_s_solve_count = 0;
                    int case_union_record_count = 0;
                    int object_m_criminal_count = 0;
                    int object_r_objectresource_count = 0;
                    int object_s_photo_count = 0;
                    int psn_m_criminal_count = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);
                    String propertiesName = "configCase";
                    logger.info("------------------------开始备份case_m_110cmd数据-------------------------");
                    case_m_110cmd_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_m_110cmd", propertiesName);
                    logger.info("------------------------备份case_m_110cmd结束------------------------------");

                    logger.info("------------------------开始备份case_m_criminal数据-----------------------");
                    case_m_criminal_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_m_criminal", propertiesName);
                    logger.info("------------------------case_m_criminal 结束-------------------------");

                    logger.info("------------------------开始备份case_m_110cmd数据-------------------------");
                    case_s_caseinfo_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_caseinfo", propertiesName);
                    logger.info("------------------------备份case_s_caseinfo结束------------------------------");

                    logger.info("------------------------开始备份case_s_progress数据-----------------------");
                    case_s_progress_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_progress", propertiesName);
                    logger.info("------------------------case_s_progress 结束-------------------------");

                    logger.info("------------------------开始备份case_s_move数据-------------------------");
                    case_s_move_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_move", propertiesName);
                    logger.info("------------------------备份case_s_move结束------------------------------");

                    logger.info("------------------------开始备份case_r_sufferpsn数据-----------------------");
                    case_r_sufferpsn_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_r_sufferpsn", propertiesName);
                    logger.info("------------------------case_r_sufferpsn 结束-------------------------");

                    logger.info("------------------------开始备份case_s_dellog数据-------------------------");
                    case_s_dellog_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_dellog", propertiesName);
                    logger.info("------------------------备份case_s_dellog结束------------------------------");

                    //--------------------
                    logger.info("------------------------开始备份case_r_suspicionpsn数据-------------------------");
                    case_r_suspicionpsn_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_r_suspicionpsn", propertiesName);
                    logger.info("------------------------备份case_r_suspicionpsn结束------------------------------");

                    logger.info("------------------------开始备份case_s_peculiarity数据-------------------------");
                    case_s_peculiarity_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_peculiarity", propertiesName);
                    logger.info("------------------------备份case_s_peculiarity结束------------------------------");

                    logger.info("------------------------开始备份case_s_progresschange数据-------------------------");
                    case_s_progresschange_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_progresschange", propertiesName);
                    logger.info("------------------------备份case_s_progresschange结束------------------------------");

                    logger.info("------------------------开始备份case_s_resolve数据-------------------------");
                    case_s_resolve_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_resolve", propertiesName);
                    logger.info("------------------------备份case_s_resolve结束------------------------------");

                    logger.info("------------------------开始备份case_s_resort数据-------------------------");
                    case_s_resort_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_resort", propertiesName);
                    logger.info("------------------------备份case_s_resort结束------------------------------");

                    logger.info("------------------------开始备份case_s_solve数据-------------------------");
                    case_s_solve_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_s_solve", propertiesName);
                    logger.info("------------------------备份case_s_solve结束------------------------------");

                    logger.info("------------------------开始备份case_union_record数据-------------------------");
                    case_union_record_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"case_union_record", propertiesName);
                    logger.info("------------------------备份case_union_record结束------------------------------");

                    logger.info("------------------------开始备份object_m_criminal数据-------------------------");
                    object_m_criminal_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"object_m_criminal", propertiesName);
                    logger.info("------------------------备份object_m_criminal结束------------------------------");

                    logger.info("------------------------开始备份object_r_objectresource数据-------------------------");
                    object_r_objectresource_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"object_r_objectresource", propertiesName);
                    logger.info("------------------------备份object_r_objectresource结束------------------------------");

                    logger.info("------------------------开始备份object_s_photo数据-------------------------");
                    object_s_photo_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"object_s_photo", propertiesName);
                    logger.info("------------------------备份object_s_photo结束------------------------------");

                    logger.info("------------------------开始备份psn_m_criminal数据-------------------------");
                    psn_m_criminal_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"psn_m_criminal", propertiesName);
                    logger.info("------------------------备份psn_m_criminal结束------------------------------");


                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), case_m_110cmd_count, "1",
                            "case_m_110cmd_count:" + case_m_110cmd_count + "&#&case_m_criminal_count:" + case_m_criminal_count
                                    + "&#&case_s_caseinfo_count:" + case_s_caseinfo_count
                                    + "&#&case_s_progress_count:" + case_s_progress_count
                                    + "&#&case_s_move_count:" + case_s_move_count
                                    + "&#&case_r_sufferpsn_count:" + case_r_sufferpsn_count
                                    + "&#&case_s_dellog_count:" + case_s_dellog_count
                                    + "&#&case_r_suspicionpsn_count:" + case_r_suspicionpsn_count
                                    + "&#&case_s_peculiarity_count:" + case_s_peculiarity_count
                                    + "&#&case_s_progresschange_count:" + case_s_progresschange_count
                                    + "&#&case_s_resolve_count:" + case_s_resolve_count
                                    + "&#&case_s_resort_count:" + case_s_resort_count
                                    + "&#&case_s_solve_count:" + case_s_solve_count
                                    + "&#&case_union_record_count:" + case_union_record_count
                                    + "&#&object_m_criminal_count:" + object_m_criminal_count
                                    + "&#&object_r_objectresource_count:" + object_r_objectresource_count
                                    + "&#&object_s_photo_count:" + object_s_photo_count
                                    + "&#&psn_m_criminal_count:" + psn_m_criminal_count, startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "案事件",
                            CommonConstant.SYSNC_CASE);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错",e);
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
