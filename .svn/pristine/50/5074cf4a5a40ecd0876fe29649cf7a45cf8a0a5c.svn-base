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
 * code
 */
public class CodeConnection implements Runnable{
    private static Logger logger = Logger.getLogger(CodeConnection.class);
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
        Connection sourceConn = DbUtils.getConnection("dbCode");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_CODE, CommonConstant.DATAENDTIME_CODE);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();
                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                logger.error("出错", e);
                return;
            }
            try {
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int code_ajjs_count = 0;
                    int code_ajlb_count = 0;
                    int code_ajlx_count = 0;
                    int code_ajly_count = 0;

                    int code_ajxz_count = 0;
                    int code_ajywlx_count = 0;
                    int code_ajzt_count = 0;
                    int code_approval_count = 0;

                    int code_arrestmanner_count = 0;
                    int code_ay_count = 0;
                    int code_babs_count = 0;
                    int code_cjjg_count = 0;

                    int code_clfs_count = 0;
                    int code_gjdq_count = 0;
                    int code_involvetype_count = 0;
                    int code_jggj_count = 0;

                    int code_jjxs_count = 0;
                    int code_jjzt_count = 0;
                    int code_jqlb_count = 0;
                    int code_ob_state_count = 0;

                    int code_ob_type_count = 0;
                    int code_pafs_count = 0;
                    int code_salx_count = 0;
                    int code_sawp_count = 0;

                    int code_slfs_count = 0;
                    int code_xzqh_count = 0;
                    int code_yslx_count = 0;
                    int code_zayy_count = 0;

                    int xz_sp_018_count = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);

                    String propertiesName = "configCode";
                    logger.info("------------------------开始备份code_ajjs数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajjs_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajjs", propertiesName);
                    logger.info("------------------------备份code_ajjs结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ajlb数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajlb_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajlb", propertiesName);
                    logger.info("------------------------备份code_ajlb结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ajlx数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajlx_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajlx", propertiesName);
                    logger.info("------------------------备份code_ajlx结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ajly数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajly_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajly", propertiesName);
                    logger.info("------------------------备份code_ajly结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ajxz数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajxz_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajxz", propertiesName);
                    logger.info("------------------------备份code_ajxz结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ajywlx数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajywlx_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajywlx", propertiesName);
                    logger.info("------------------------备份code_ajywlx结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ajzt数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ajzt_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ajzt", propertiesName);
                    logger.info("------------------------备份code_ajzt结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_approval数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_approval_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_approval", propertiesName);
                    logger.info("------------------------备份code_approval结束"+DateUtils.getCurrentDateTime()+"------------------------------");

//-----------------------------
                    logger.info("------------------------开始备份code_arrestmanner数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_arrestmanner_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_arrestmanner", propertiesName);
                    logger.info("------------------------备份code_arrestmanner结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ay数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ay_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ay", propertiesName);
                    logger.info("------------------------备份code_ay结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_babs数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_babs_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_babs", propertiesName);
                    logger.info("------------------------备份code_babs结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_cjjg数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_cjjg_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_cjjg", propertiesName);
                    logger.info("------------------------备份code_cjjg结束"+DateUtils.getCurrentDateTime()+"------------------------------");
//---------------------------
//-----------------------------
                    logger.info("------------------------开始备份code_clfs数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_clfs_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_clfs", propertiesName);
                    logger.info("------------------------备份code_clfs结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_gjdq数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_gjdq_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_gjdq", propertiesName);
                    logger.info("------------------------备份code_gjdq结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_involvetype数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_involvetype_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_involvetype", propertiesName);
                    logger.info("------------------------备份code_involvetype结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_jggj数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_jggj_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_jggj", propertiesName);
                    logger.info("------------------------备份code_jggj结束"+DateUtils.getCurrentDateTime()+"------------------------------");
//---------------------------
//-----------------------------
                    logger.info("------------------------开始备份code_jjxs数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_jjxs_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_jjxs", propertiesName);
                    logger.info("------------------------备份code_jjxs结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_jjzt数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_jjzt_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_jjzt", propertiesName);
                    logger.info("------------------------备份code_jjzt结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_jqlb数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_jqlb_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_jqlb", propertiesName);
                    logger.info("------------------------备份code_jqlb结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_ob_state数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ob_state_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ob_state", propertiesName);
                    logger.info("------------------------备份code_ob_state结束"+DateUtils.getCurrentDateTime()+"------------------------------");
//---------------------------
//-----------------------------
                    logger.info("------------------------开始备份code_ob_type数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_ob_type_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_ob_type", propertiesName);
                    logger.info("------------------------备份code_ob_type结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_pafs数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_pafs_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_pafs", propertiesName);
                    logger.info("------------------------备份code_pafs结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_salx数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_salx_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_salx", propertiesName);
                    logger.info("------------------------备份code_salx结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_sawp数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_sawp_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_sawp", propertiesName);
                    logger.info("------------------------备份code_sawp结束"+DateUtils.getCurrentDateTime()+"------------------------------");
//---------------------------
//-----------------------------
                    logger.info("------------------------开始备份code_slfs数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_slfs_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_slfs", propertiesName);
                    logger.info("------------------------备份code_slfs结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_xzqh数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_xzqh_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_xzqh", propertiesName);
                    logger.info("------------------------备份code_xzqh结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_yslx数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_yslx_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_yslx", propertiesName);
                    logger.info("------------------------备份code_yslx结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份code_zayy数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    code_zayy_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"code_zayy", propertiesName);
                    logger.info("------------------------备份code_zayy结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.info("------------------------开始备份xz_sp_018数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    xz_sp_018_count = allTask.doCopyDataFForCode(sourceConn, targetConn, dateStrat, dateEnd,"xz_sp_018", propertiesName);
                    logger.info("------------------------备份xz_sp_018结束"+DateUtils.getCurrentDateTime()+"------------------------------");

//---------------------------
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("code_ajjs:" + code_ajjs_count);
                    stringBuilder.append("&#&code_ajlb:" + code_ajlb_count);
                    stringBuilder.append("&#&code_ajlx:" + code_ajlx_count);
                    stringBuilder.append("&#&code_ajly:" + code_ajly_count);

                    stringBuilder.append("&#&code_ajxz:" + code_ajxz_count);
                    stringBuilder.append("&#&code_ajywlx:" + code_ajywlx_count);
                    stringBuilder.append("&#&code_ajzt:" + code_ajzt_count);
                    stringBuilder.append("&#&code_approval:" + code_approval_count);

                    stringBuilder.append("&#&code_arrestmanner:" + code_arrestmanner_count);
                    stringBuilder.append("&#&code_ay:" + code_ay_count);
                    stringBuilder.append("&#&code_babs:" + code_babs_count);
                    stringBuilder.append("&#&code_cjjg:" + code_cjjg_count);

                    stringBuilder.append("&#&code_clfs:" + code_clfs_count);
                    stringBuilder.append("&#&code_gjdq:" + code_gjdq_count);
                    stringBuilder.append("&#&code_involvetype:" + code_involvetype_count);
                    stringBuilder.append("&#&code_jggj:" + code_jggj_count);

                    stringBuilder.append("&#&code_jjxs:" + code_jjxs_count);
                    stringBuilder.append("&#&code_jjzt:" + code_jjzt_count);
                    stringBuilder.append("&#&code_jqlb:" + code_jqlb_count);
                    stringBuilder.append("&#&code_ob_state:" + code_ob_state_count);

                    stringBuilder.append("&#&code_ob_type:" + code_ob_type_count);
                    stringBuilder.append("&#&code_pafs:" + code_pafs_count);
                    stringBuilder.append("&#&code_salx:" + code_salx_count);
                    stringBuilder.append("&#&code_sawp:" + code_sawp_count);

                    stringBuilder.append("&#&code_slfs:" + code_slfs_count);
                    stringBuilder.append("&#&code_xzqh:" + code_xzqh_count);
                    stringBuilder.append("&#&code_yslx:" + code_yslx_count);
                    stringBuilder.append("&#&code_zayy:" + code_zayy_count);
                    stringBuilder.append("&#&xz_sp_018:" + xz_sp_018_count);


                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(),
                            new Date(),
                            code_ajjs_count, "1", stringBuilder.toString(), startDate);

                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "code表",
                            CommonConstant.SYSNC_CODE);
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
