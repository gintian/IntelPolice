package com.task;
import com.conn.PoilceConnection;
import com.utils.DateUtils;
import com.utils.DbUtils;
import com.utils.PropertiesUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Date;

/**
 * Created by tl on 2018/5/30 0030.
 */
public class AllTask {
    private static Logger logger = Logger.getLogger(AllTask.class);
    public static void main(String[] args) {
        AllTask allTask = new AllTask();
        //allTask.doCopyData()
    }

    /**
     *
     * 执行
     * @param sourceConn                【必填】        数据源
     * @param targetConn                【必填】        目标数据
     * @param dateStrat                 【必填】        开始时间
     * @param dateEnd                   [必填]           结束时间
     * @param key                       【必填】           表名
     * @param propertiesName             [必填]           对应属性文件名
     * @return
     * @throws Exception            抛出数据执行失败异常
     */
    public int doCopyData(Connection sourceConn, Connection targetConn, String dateStrat, String dateEnd, String key, String propertiesName) throws Exception{
        logger.info(key+"数据查询时间： " + dateStrat + "---"+ dateEnd);
        Date sdate = DateUtils.getCurrentDate();
        int result = doGetData(sourceConn, targetConn, dateStrat, dateEnd, key, propertiesName);
        Date enndate = DateUtils.getCurrentDate();
        logger.info(key + "数据执行时间： "+ sdate + "--"+enndate+", 执行结果： " + (DateUtils.getCurrentDate().getTime() - sdate.getTime()));
        return result;
    }

    /**
     * 执行
     *
     * @param sourceConn                【必填】        数据源
     * @param targetConn                【必填】        目标数据
     * @param dateStrat                 【必填】        开始时间
     * @param dateEnd                   [必填]           结束时间
     * @param key                       【必填】           表名
     * @param propertiesName             [必填]           对应属性文件名
     * @return
     * @throws Exception            抛出数据执行失败异常
     */
    public int doCopyDataFForCode(Connection sourceConn, Connection targetConn, String dateStrat, String dateEnd, String key, String propertiesName) throws Exception{
        logger.info(key + " 数据查询时间： " + dateStrat + "---"+ dateEnd);
        Date sdate = DateUtils.getCurrentDate();
        int result = doGetDataForCode(sourceConn, targetConn, dateStrat, dateEnd, key, propertiesName);
        Date enndate = DateUtils.getCurrentDate();
        logger.info(key + " 数据执行时间： "+ sdate + "--"+enndate+", 执行结果： " + (DateUtils.getCurrentDate().getTime() - sdate.getTime()));
        return result;
    }

    /**
     * 数据获取
     *
     * @param sourceConn                【必填】        数据源
     * @param targetConn                【必填】        目标数据
     * @param dateStrat                 【必填】        开始时间
     * @param dateEnd                   [必填]           结束时间
     * @param key                       【必填】           表名
     * @param propertiesName             [必填]           对应属性文件名
     * @return
     * @throws Exception            抛出数据执行失败异常
     */
    private int doGetDataForCode(Connection sourceConn, Connection targetConn, String dateStrat, String dateEnd, String key, String propertiesName) throws Exception{
        //主键字段名
        String principalFileName = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".principalFileName", propertiesName);
        //表名
        String tableName = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".tableName", propertiesName);
        //基础字段
        String base_column_list_1 = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".selectSql", propertiesName);
        //基础字段
        String base_column_list = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".insertSql", propertiesName);

        if (principalFileName == null || tableName == null || base_column_list == null|| base_column_list_1 == null){
//            throw new RuntimeException("没有"+key+"找到要同步的参数");
            logger.info("没有"+key+"找到要同步的参数");
            logger.debug("没有"+key+"找到要同步的参数");
            return 0;
        }
        //查询语句
        String selectSql = "select "+base_column_list_1+" from "+tableName;
        //插入
        String insertSql = "insert into "+tableName+" ("+base_column_list+") " +
                "values ("+ DbUtils.getZWF(base_column_list)+")";
        //总条数查询语句
        String sqlCount = "select count("+principalFileName+") from "+tableName;
        try {
            return DbUtils.doAnalysisDataForCode(sourceConn,
                    targetConn,
                    dateStrat,
                    dateEnd,
                    principalFileName,
                    selectSql,
                    sqlCount,
                    insertSql,
                    tableName,
                    base_column_list_1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.info(tableName+"获取数据异常");
            throw new RuntimeException(tableName+"获取数据异常");
        }finally {
            base_column_list = null;
            selectSql = null;
            insertSql = null;
        }
    }
    /**
     * 获取数据
     */
    private int doGetData(Connection sourceConn, Connection targetConn, String dateStrat, String dateEnd, String key, String propertiesName) throws Exception{
        //主键字段名
        String principalFileName = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".principalFileName", propertiesName);
        //表名
        String tableName = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".tableName", propertiesName);
        //基础字段
        String base_column_list_1 = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".selectSql", propertiesName);
        //基础字段
        String base_column_list = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".insertSql", propertiesName);

        //lyds

        logger.info("------------------------开始获取"+tableName+"数据------------------------");

        if (principalFileName == null || tableName == null || base_column_list == null|| base_column_list_1 == null){
//            throw new RuntimeException("没有"+key+"找到要同步的参数");
            logger.info("没有"+key+"找到要同步的参数");
            logger.error("没有"+key+"找到要同步的参数");
            return 0;
        }

        //查询语句
        String selectSql = "select "+base_column_list_1+" from "+tableName + " ";
        //插入
        String insertSql = "insert into "+tableName+" ("+base_column_list+") " +
                "values ("+ DbUtils.getZWF(base_column_list)+")";
        //总条数查询语句
        String sqlCount = "select count("+principalFileName+") from "+tableName + " ";
        try {
            return DbUtils.doAnalysisData2(sourceConn,
                    targetConn,
                    dateStrat,
                    dateEnd,
                    principalFileName,
                    selectSql,
                    sqlCount,
                    insertSql,
                    key,
                    propertiesName,
                    tableName,
                    base_column_list_1);
        } catch (Exception e) {
            logger.error("出错", e);
            e.printStackTrace();
            logger.info(tableName+"获取数据异常");
            throw new RuntimeException(tableName+"获取数据异常");
        }finally {
            base_column_list = null;
            selectSql = null;
            insertSql = null;
        }
    }

}
