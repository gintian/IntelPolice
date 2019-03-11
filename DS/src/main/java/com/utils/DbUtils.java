package com.utils;

import com.constant.CommonConstant;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.log4j.Logger;

import javax.persistence.Column;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tl on 2018/5/15 0015.
 */
public class DbUtils {
    private static Logger logger = Logger.getLogger(DbUtils.class);

    /**
     * 获取连接  connection
     * @return
     */
    public synchronized static Connection getConnection(String dbname) throws Exception{
        Connection conn = null;
        try {
            Class.forName(PropertiesUtils.get(dbname + ".driver"));//找到oracle驱动器所在的类
            String url = PropertiesUtils.get(dbname + ".url"); //URL地址
            String username = PropertiesUtils.get(dbname + ".username");
            String password = PropertiesUtils.get(dbname + ".password");

            conn = DriverManager.getConnection(url, username, password);
            logger.info("获取连接："+PropertiesUtils.get(dbname + ".driver") + PropertiesUtils.get(dbname + ".url") + PropertiesUtils.get(dbname + ".username") + PropertiesUtils.get(dbname + ".password") +" 对象地址："+ conn);
        }catch (Exception e){
            logger.error("出错",e);
            throw new RuntimeException(dbname + "连接异常");
        }
        return conn;
    }

    public synchronized static void close(Connection conn){
        if(conn !=null){
            try {
                logger.info("关闭连接："+conn.getMetaData().getDriverName() + conn.getMetaData().getURL() +" 对象地址："+conn);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void close(PreparedStatement pstmt){
        if(pstmt !=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized static void close(ResultSet rs){
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    * 将rs结果转换成对象列表
    * @param rs jdbc结果集
    * @param clazz 对象的映射类
    * return 封装了对象的结果列表
    */
    public synchronized static List populate(ResultSet rs , Class clazz) throws SQLException, InstantiationException, IllegalAccessException{
        //结果集的字段对象,包含字段名称与类型
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取结果集的字段个数
        int colCount = rsmd.getColumnCount();
        //返回结果的列表集合
        List list = new ArrayList();
        //获取所有声明的字段,包括public,private和proteced
        Field[] fields = clazz.getDeclaredFields();
        while(rs.next()){//对每一条记录进行操作
            Object obj = clazz.newInstance();//构造业务对象实体
            //将每一个字段取出进行赋值
            for(int i = 1;i<=colCount;i++){
                Object value = rs.getObject(i);
                //寻找该列对应的对象属性
                for(int j=0;j<fields.length;j++){
                    Field f = fields[j];
                    if (f.isAnnotationPresent(Column.class)) {//判断是否存在@Column注解
                        Column column = f.getAnnotation(Column.class);
                        if (column.name().equalsIgnoreCase(rsmd.getColumnName(i)) && rsmd.getColumnName(i) != null) {
                            boolean flag = f.isAccessible();//
                            f.setAccessible(true);//开启private成员变量的读写权限
                            f.set(obj, value);
                            f.setAccessible(flag);
                            break;
                        }
                    }else if(f.getName().equalsIgnoreCase(rsmd.getColumnName(i))){
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(obj, value);
                        f.setAccessible(flag);
                        break;
                    }
                }
            }
            list.add(obj);
        }
        return list;
    }

    /**
     * 获取总条数
     * @param sql                                   [必填]     sql 语句
     * @param connection                           [必填]     连接对象
     * @return                                      查询条数
     * @throws Exception                            sql 执行 异常
     */
    public static int selectCount(String sql, Connection connection) throws Exception{
        logger.info("查询条数sql: " + sql);
        logger.info("sql超时 : " + Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SETQUERYTIMEOUT, "System")));
        //分页数据
        PreparedStatement countPrepare = connection.prepareStatement(sql);
        countPrepare.setQueryTimeout(Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SETQUERYTIMEOUT, "System")));
        ResultSet countSet = countPrepare.executeQuery();
        int count = 0;
        while (countSet.next()){
            count = countSet.getInt(1);
        }
        DbUtils.close(countSet);
        DbUtils.close(countPrepare);
        return  count;
    }

    /**
     * 查询数据，
     * @param sql                  [必填]  sql
     * @param connection           [必填]     连接对象
     * @return
     * @throws Exception
     */
    public static List selectData(String sql, Connection connection, Class tClass) throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setQueryTimeout(Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SETQUERYTIMEOUT, "System")));
        logger.info("查询sql : "+sql);

        ResultSet  resultSet = preparedStatement.executeQuery();
        List list = DbUtils.populate(resultSet, tClass);
        DbUtils.close(resultSet);
        DbUtils.close(preparedStatement);
        logger.info("需要备份的数据："+list.size());
        return list;
    }

    /**
     * 根据查询条数， 分析数据
     * @param sourceConn                           [必填]                     源数据连接
     * @param targetConn                           [必填]                     目标数据连接
     *   @param dateStrat                              [必填]                    查询时间   必须是操作hck_gxsj
     *   @param principalFileName                   [必填]                    操作表的主键
     *   @param selectSql                            [必填]                     查询sql
     *   @param sqlCount                            [必填]                      查询数量  sql
     *   @param insertSql                           [必填]                      插入Sql
     *   @param tableName                           [必填]                      操作表名
     *   @param base_column_list                    [必填]                    基础字段
     * @throws Exception
     */
    public static int doAnalysisData2(Connection sourceConn,
                                     Connection targetConn,
                                     String dateStrat,
                                     String dateEnd,
                                     String principalFileName,
                                     String selectSql,
                                     String sqlCount,
                                     String insertSql,
                                     String key,
                                     String propertiesName,
                                     String tableName,
                                     String base_column_list) throws Exception{
        logger.info("------------------------开始分析"+tableName+"数据------------------------");
        //判断sourceConn  数据源的连接对象
        String dirverName = sourceConn.getMetaData().getDriverName();
        String sys_areaId = PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.AREAID,"System");
        String sync_all = PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SYNC_ALL,"System");
        //行政区划筛选字段
        String areaId = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".areaId", propertiesName);
        //辨识更新
        String domain = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".domain", propertiesName);
        //where
        String where = PropertiesUtils.getConfigForPropertiesNameAndKey(key+".where", propertiesName);

        if (domain==null || domain.equals("")){
            domain = "hck_gxsj";
        }

        String select_where_sql_time = "";
        String select_where_sql = "";
        if (areaId.contains("${areaId}")){
            areaId = areaId.replace("${areaId}",sys_areaId);
        }
        if (dirverName.equals(CommonConstant.MYSQL_DRINAME)){
            if (!sync_all.equals("1") && !domain.equals("0")){
                select_where_sql_time = domain + " between '"+dateStrat+"' and '"+dateEnd+"' and ";
            }
            select_where_sql = " where " + select_where_sql_time + areaId;
        }else if(dirverName.equals(CommonConstant.ORACLE_DRINAME)){
            if (!sync_all.equals("1") && !domain.equals("0")){
                select_where_sql_time = domain + " between to_date('"+dateStrat+"', 'yyyy-MM-dd HH24:mi:ss') and to_date('"+dateEnd+"', 'yyyy-MM-dd HH24:mi:ss') and ";
            }
            select_where_sql = " sa where rowid in (select max(rowid) from " + tableName + " sc where " + select_where_sql_time
                    + principalFileName+" is not null " + " and " + areaId + " and sa."+ principalFileName +"= sc."+ principalFileName +")";
        }else {
            if (!sync_all.equals("1") && !domain.equals("0")){
                select_where_sql_time = domain + " between '"+dateStrat+"' and '"+dateEnd+"' and ";
            }
            select_where_sql = " where " + select_where_sql_time + areaId;
        }

        if (areaId.equals("0") && select_where_sql_time.equals("")){
            select_where_sql.replace("where","");
        }

        if (where!=null && !where.equals("")){
            if (where.contains("${areaId}")){
                where = where.replace("${areaId}",sys_areaId);
            }
            if (!domain.equals("0")){
                select_where_sql_time = "sa." + select_where_sql_time;
            }
            select_where_sql = where.replace("where","where " + select_where_sql_time);
        }

        logger.info("------------------------拼接"+tableName+"sql------------------------");



        //sql  拼接
        sqlCount = sqlCount + select_where_sql;
        selectSql = selectSql + select_where_sql;
        //查询总条数
        int count = DbUtils.selectCount(sqlCount, sourceConn);
        logger.info("                                         ");
        logger.info("查询sql :"+selectSql);
        logger.info(tableName +"_count :"+ count);
        logger.info("                                         ");
        //分页条数
        int page_count = Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.PAGE_COUNT, "System"));
        //根据条数是否， 分页查询
        if (count == 0){
            return 0;
        }else if(count < 1000){
            DbUtils.doSetDataForTable2(insertSql, targetConn, tableName, principalFileName,sourceConn,selectSql);
        }else {
            //大于  1000  分页查
            // 并且判断数据源

            if (dirverName.equals(CommonConstant.MYSQL_DRINAME)){
                //mysql 数据库
                for (int i = 0; i < count; i = i + page_count) {
                    //分页语句
                    String sql = selectSql + " limit " + i + ", "+page_count+"";
                    DbUtils.doSetDataForTable2(insertSql, targetConn, tableName, principalFileName,sourceConn,sql);
                }

            }else if(dirverName.equals(CommonConstant.ORACLE_DRINAME)){

                //oracel 数据库
                for (int i = 0; i < count; i = i + page_count) {
                    String pageSql = "select " + base_column_list + " from " +
                            "(select rownum AS rowno, sb.* from " +
                            "("+ selectSql + ") sb " +
                            "where rownum <= " + (i + page_count) + " ) table_alias where table_alias.rowno > " + i + "";
                    //封装list数据
                    DbUtils.doSetDataForTable2(insertSql, targetConn, tableName, principalFileName,sourceConn,pageSql);
                }
            }else {
                //其他数据库，，暂时使用mysql为默认
                for (int i = 0; i < count; i = i + page_count) {
                    //分页语句
                    String sql = selectSql + " limit " + i + ", "+page_count+"";
                    //封装list数据
                    DbUtils.doSetDataForTable2(insertSql, targetConn, tableName, principalFileName,sourceConn,sql);
                }
            }

        }
        return count;
    }

    /**
     * 根据查询条数， 分析数据
     * @param sourceConn                           [必填]                     源数据连接
     * @param targetConn                           [必填]                     目标数据连接
     *   @param dateStrat                              [必填]                    查询时间   必须是操作hck_gxsj
     *   @param principalFileName                   [必填]                    操作表的主键
     *   @param selectSql                            [必填]                     查询sql
     *   @param sqlCount                            [必填]                      查询数量  sql
     *   @param insertSql                           [必填]                      插入Sql
     *   @param tableName                           [必填]                      操作表名
     *   @param base_column_list                    [必填]                    基础字段
     * @throws Exception
     */
    public static int doAnalysisDataForCode(Connection sourceConn,
                                      Connection targetConn,
                                      String dateStrat,
                                      String dateEnd,
                                      String principalFileName,
                                      String selectSql,
                                      String sqlCount,
                                      String insertSql,
                                      String tableName,
                                      String base_column_list
    ) throws Exception{
        //判断sourceConn  数据源的连接对象
        String dirverName = sourceConn.getMetaData().getDriverName();
        String select_where_sql = "";
        if (dirverName.equals(CommonConstant.MYSQL_DRINAME)){
            select_where_sql = " where hck_gxsj > '"+dateStrat+"' and hck_gxsj < '"+dateEnd+"' and "+principalFileName+" is not null";
        }else if(dirverName.equals(CommonConstant.ORACLE_DRINAME)){
            select_where_sql =" where hck_gxsj > to_date('"+dateStrat+"', 'yyyy-MM-dd HH24:mi:ss') and hck_gxsj < to_date('"+dateEnd+"', 'yyyy-MM-dd HH24:mi:ss') and "+principalFileName+" is not null";
        }else {
            select_where_sql = " where hck_gxsj > '"+dateStrat+"' and hck_gxsj < '"+dateEnd+"' and "+principalFileName+" is not null";
        }
        //sql  拼接
        selectSql = selectSql + select_where_sql;
        sqlCount = sqlCount + select_where_sql;
        //查询总条数
        int count = DbUtils.selectCount(sqlCount, sourceConn);
        logger.info("                                         ");
        logger.info(tableName +"_count:"+ count);
        logger.info("                                         ");
        //分页条数
        int page_count = Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.PAGE_COUNT, "System"));
        //根据条数是否， 分页查询
        if (count == 0){
            return 0;
        }else if(count < 1000){
            DbUtils.doSetDataForTableForCode(insertSql, targetConn, tableName, principalFileName,sourceConn,selectSql);
        }else {
            if (dirverName.equals(CommonConstant.MYSQL_DRINAME)){
                //mysql 数据库
                for (int i = 0; i < count; i = i + page_count) {
                    //分页语句
                    String sql = selectSql + " limit " + i + ", "+page_count+"";
                    DbUtils.doSetDataForTableForCode(insertSql, targetConn, tableName, principalFileName,sourceConn,sql);
                }
            }else if(dirverName.equals(CommonConstant.ORACLE_DRINAME)){
                //oracel 数据库
                for (int i = 0; i < count; i = i + page_count) {
                    //分页语句
                    String pageSql = "select " + base_column_list + " from " +
                            "(select rownum AS rowno, sb.* from " +
                            "(select " + base_column_list + " from " + tableName + " sa" +
                            " where sa.hck_gxsj > to_date('" + dateStrat + "', 'yyyy-MM-dd HH24:mi:ss') " +
                            "and sa.hck_gxsj < to_date('" + dateEnd + "', 'yyyy-MM-dd HH24:mi:ss')"+
                            "and sa." + principalFileName + " is not null) sb " +
                            "where rownum <= " + (i + page_count) + " ) table_alias where table_alias.rowno > " + i + "";
                    //封装list数据
                    DbUtils.doSetDataForTableForCode(insertSql, targetConn, tableName, principalFileName,sourceConn,pageSql);
                }
            }else {
                //其他数据库，，暂时使用mysql为默认
                for (int i = 0; i < count; i = i + page_count) {
                    //分页语句
                    String sql = selectSql + " limit " + i + ", "+page_count+"";
                    //封装list数据
                    DbUtils.doSetDataForTableForCode(insertSql, targetConn, tableName, principalFileName,sourceConn,sql);
                }
            }

        }
        return count;
    }

    /**
     * 存数据
     * @param insertSql                             [必填]     插入sql 语句
     * @param connection                            [必填]     jdbc  连接对象
     *  @param tableName                             [必填]     操作表名
     *  @param principalFileName                    [必填]     操作表的主键字段
     */
    public static void doSetDataForTable2(String insertSql,
                                          Connection connection,
                                          String tableName,
                                          String principalFileName,
                                          Connection sourceConn,
                                          String selectSql) throws Exception{
        //封装list数据
        PreparedStatement preparedStatementSelect = null;
        PreparedStatement deletePreparedStatement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        String deleteSql = "delete from "+tableName+" where "+principalFileName+" = ?";
        StringBuilder sb = new StringBuilder("delete from "+tableName+" where "+principalFileName+" in");
        sb.append("(");
        try {
            preparedStatementSelect = sourceConn.prepareStatement(selectSql);
            preparedStatementSelect.setQueryTimeout(Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SETQUERYTIMEOUT, "System")));
            logger.info(tableName+"查询sql : "+selectSql);
            resultSet = preparedStatementSelect.executeQuery();

            logger.info(tableName+"插入sql :"+insertSql);
            preparedStatement= connection.prepareStatement(insertSql);

            //结果集的元素对象
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //获取结果集的元素个数
            int colCount = rsmd.getColumnCount();
            //对每一条记录进行操作
            String principal1 = "";
            String principal2 = "";
            while(resultSet.next()){
                if (resultSet.getObject(principalFileName) != null) {
                    principal2 = (String) resultSet.getObject(principalFileName);
                    if (principal1.equals(principal2)){
                        continue;
                    }else {
                        principal1 = principal2;
                    }
                    sb.append("'" + resultSet.getObject(principalFileName) + "', ");
//                    deletePreparedStatement.setObject(1, resultSet.getObject(principalFileName));
                }
                //将每一个字段取出进行赋值
                for(int i = 1;i<= colCount;i++) {
                    Object value = resultSet.getObject(i);
                    if (value != null) {
                        if (value instanceof Blob) {
                            Blob blob = resultSet.getBlob(i);
                            preparedStatement.setBlob(i, blob.getBinaryStream());
                        } else if (value instanceof Clob) {
                            Clob clob = resultSet.getClob(i);
                            preparedStatement.setClob(i, clob.getCharacterStream());
                        } else if(value instanceof java.sql.Date){
                            preparedStatement.setDate(i, resultSet.getDate(i));
                        }else {
                            preparedStatement.setObject(i, value);
                        }
                    }else {
                        preparedStatement.setObject(i, value);
                    }
                }
//                deletePreparedStatement.addBatch();
                preparedStatement.addBatch();
            }
            String deleteSql = sb.substring(0, sb.lastIndexOf(",")) + ")";
            deletePreparedStatement = connection.prepareStatement(deleteSql);
            logger.debug(deleteSql);
            deletePreparedStatement.executeUpdate();
            logger.debug(insertSql);
            preparedStatement.executeBatch();
        } finally {
            //关闭连接释放内存
            DbUtils.close(deletePreparedStatement);
            DbUtils.close(resultSet);
            DbUtils.close(preparedStatementSelect);
            DbUtils.close(preparedStatement);

        }
    }

    /**
     * 存数据
     * @param insertSql                             [必填]     插入sql 语句
     * @param connection                            [必填]     jdbc  连接对象
     *  @param tableName                             [必填]     操作表名
     *  @param principalFileName                    [必填]     操作表的主键字段
     */
    public static void doSetDataForTableForCode(String insertSql,
                                                Connection connection,
                                                String tableName,
                                                String principalFileName,
                                                Connection sourceConn,
                                                String selectSql) throws Exception{
        //封装list数据
        PreparedStatement preparedStatementSelect = null;
        PreparedStatement deletePreparedStatement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder("delete from "+tableName);
        try {
            preparedStatementSelect = sourceConn.prepareStatement(selectSql);
            preparedStatementSelect.setQueryTimeout(Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SETQUERYTIMEOUT, "System")));
            logger.info(tableName+"查询sql : "+selectSql);
            resultSet = preparedStatementSelect.executeQuery();

            deletePreparedStatement = connection.prepareStatement(sb.toString());
            logger.debug("deleteSql: " + sb.toString());
            deletePreparedStatement.executeUpdate();

            preparedStatement= connection.prepareStatement(insertSql);
            logger.debug(insertSql);
            //结果集的元素对象
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //获取结果集的元素个数
            int colCount = rsmd.getColumnCount();
            //对每一条记录进行操作
            while(resultSet.next()){
                //将每一个字段取出进行赋值
                for(int i = 1;i<= colCount;i++) {
                    Object value = resultSet.getObject(i);
                    if (value != null) {
                        if (value instanceof Blob) {
                            Blob blob = resultSet.getBlob(i);
                            preparedStatement.setBlob(i, blob.getBinaryStream());
                        } else if (value instanceof Clob) {
                            Clob clob = resultSet.getClob(i);
                            preparedStatement.setClob(i, clob.getCharacterStream());
                        } else {
                            preparedStatement.setObject(i, value);
                        }
                    }else {
                        preparedStatement.setObject(i, value);
                    }
                }
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } finally {
            //关闭连接，释放内存
            sb = null;
            DbUtils.close(preparedStatement);
            //关闭连接释放内存
            DbUtils.close(deletePreparedStatement);
            DbUtils.close(resultSet);
            DbUtils.close(preparedStatementSelect);
        }
    }
    /**
     * 存数据
     * @param list                                   [必填]     需要存list
     * @param insertSql                             [必填]     插入sql 语句
     * @param connection                            [必填]     jdbc  连接对象
     *  @param tableName                             [必填]     操作表名
     *  @param principalFileName                    [必填]     操作表的主键字段
     *  @param  clazz                               [必填]    class类型
     */
    public static void doSetDataForTable(List<Object> list, String insertSql, Connection connection, String tableName, String principalFileName, Class clazz) throws Exception{
        PreparedStatement deletePreparedStatement = null;
        PreparedStatement preparedStatement = null;
        StringBuilder sb = new StringBuilder("delete from "+tableName+" where "+principalFileName+" in");
        try {
            //判断是否相同的数据，有相同的数据删除
            sb.append("(");
            for (int i = 0; i < list.size(); i++) {
                String id = BeanUtils.getProperty(list.get(i), principalFileName);
                sb.append("'" + id + "', ");
            }
            String deletesql = sb.substring(0, sb.lastIndexOf(",")) + ")";
            deletePreparedStatement = connection.prepareStatement(deletesql);
            deletePreparedStatement.executeUpdate();

            preparedStatement= connection.prepareStatement(insertSql);
            logger.debug(insertSql);
            //遍历源数据对象
            for (Object obj : list){
                //获取所有的属性
                Field[] filelds = clazz.getDeclaredFields();
                int count = filelds.length;
                //遍历
                for (int i = 0; i < count; i++) {
                    int index = i + 1;
                    //取得当前属性
                    Field f = filelds[i];
                    //若当前属性有Column注解
                    if (f.isAnnotationPresent(Column.class)) {
                        //获取注解类 Column
                        Column column = f.getAnnotation(Column.class);
                        //取得注解  Column.columnDefinition 值
                        String type = column.columnDefinition();
                        //若type 为空
                        if (type == null || type.equals("")){
                            //默认取String    preparedStatement设置String
                            preparedStatement.setString(index, BeanUtils.getProperty(obj, f.getName()));
                        }else {
                            //若type  为date
                            if (type.equals("date")){
                                //取值 并强转为DAte
                                PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
                                Date d = (Date)propertyUtilsBean.getNestedProperty(obj, f.getName());

                                //preparedStatement 设置 timestamp
                                preparedStatement.setTimestamp(index, d != null ? new Timestamp(d.getTime()) : null);
                            }else if(type.equals("clob")){
                                PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
                                String data  = (String)propertyUtilsBean.getNestedProperty(obj, f.getName());
                                preparedStatement.setClob(index, data != null? new StringReader(data) : null);
                            }else {
                                //若type   为其他值  preparedStatement默认设置为 String
                                preparedStatement.setString(index, BeanUtils.getProperty(obj, f.getName()));
                            }
                        }
                    }else {
                        //若当前属性没有注解Column
                        String value = BeanUtils.getProperty(obj, f.getName());
                        preparedStatement.setString(index, value);
                    }

                }
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } finally {
            //关闭连接，释放内存
            sb = null;
            DbUtils.close(preparedStatement);
            //关闭连接释放内存
            DbUtils.close(deletePreparedStatement);
            list.clear();
        }
    }

    public static String getZWF(String insertField){
        StringBuilder sb = new StringBuilder("");
        for (String s : insertField.split(",")){
            sb.append("?");
            sb.append(",");
        }

        String zwf = sb.substring(0, sb.length() - 1);
        return zwf;
    }
}
