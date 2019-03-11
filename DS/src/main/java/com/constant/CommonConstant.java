package com.constant;

/**
 * Created by tl on 2018/5/22 0022.
 * 静态标识类
 */
public class CommonConstant {
    public static String SYNCHDATE = "SYNCHDATE" ;                                             //以秒为单位  自动生成下一次执行时间
    public static String DATAENDTIME = "DATAENDTIME" ;                                         //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_UNIT = "DATAENDTIME_UNIT" ;                               //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_USER = "DATAENDTIME_USER" ;                               //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_POILCE = "DATAENDTIME_POILCE" ;                           //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_CASE = "DATAENDTIME_CASE" ;                               //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_DOC = "DATAENDTIME_DOC" ;                                 //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_HUMITURE = "DATAENDTIME_HUMITURE" ;                       //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_INVESTIGATION = "DATAENDTIME_INVESTIGATION" ;             //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_CODE = "DATAENDTIME_CODE" ;                               //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_DURG = "DATAENDTIME_DURG" ;                               //以秒为单位 生成查询结束日期
    public static String DATAENDTIME_SMS_LOG = "DATAENDTIME_SMS_LOG" ;                         //以秒为单位 生成查询结束日期


    public static String HEARTBEAT_TIME = "HEARTBEAT_TIME";                                    //心跳执行间隔时间
    public static String PAGE_COUNT = "PAGE_COUNT";                                            //分页条数

    public static String SYSNC_BPIP = "unit";                                                  //syncvalue         部门类型
    public static String SYSNC_USER = "user";                                                  //syncvalue         用户类型
    public static String SYSNC_POILCE = "police";                                              //syncvalue         110
    public static String SYSNC_CASE = "case";                                                  //syncvalue         案事件
    public static String SYSNC_DOC = "doc";                                                    //syncvalue         文书
    public static String SYSNC_HUMITURE = "humiture";                                          //syncvalue         温湿度计
    public static String SYSNC_INVESTIGATION = "investigation";                                //syncvalue         受立案监督
    public static String SYSNC_CODE = "code";                                                  //syncvalue       code
    public static String SYSNC_DURG = "durg";                                                  //syncvalue       durg
    public static String SYSNC_SMS_LOG = "smslog";                                             //syncvalue       smslog

    public static String SYNCTYPE = "0";                                                       //synctype  是否自动同步 0为自动     类型


    //数据源判断说明，整个Ds  数据备份  只判断了  mysql  和oracle  如果有其他数据源默认为  mysql
    public static String MYSQL_DRINAME = "MySQL-AB JDBC Driver";                               //mysql 数据源
    public static String ORACLE_DRINAME = "Oracle JDBC driver";                                //oracle 数据源


    public static String SETQUERYTIMEOUT = "SETQUERYTIMEOUT";                                  //sql超时时间
    public static final String AREAID = "AREAID";
    public static final String SYNC_ALL = "SYNC_ALL";
}
