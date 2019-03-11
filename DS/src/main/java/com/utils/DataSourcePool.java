package com.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tl on 2018/5/16 0016.
 * 自定义连接池对象
 */
public class DataSourcePool {
    /**
     * 最大连接数
     */
    private static final int COUNT = 10;

    /**
     * 存放数据库 连接
     */
    private static final Map<String, LinkedList<Connection>> map = new HashMap<String, LinkedList<Connection>>();

    /**
     * 创建锁
     */
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();
    /**
     * 初始化信息
     */
    static {
        try {
            //目标对象
            map.put("dbTarget", new LinkedList<Connection>());
            //日志
            map.put("dbDataSync", new LinkedList<Connection>());
            //部门
            map.put("dbUnit", new LinkedList<Connection>());
            //110
            map.put("dbPoilce", new LinkedList<Connection>());
            //用户
            map.put("dbUser", new LinkedList<Connection>());

            for (int i = 0; i < 3; i++) {
                Connection connection = DbUtils.getConnection("dbTarget");
                map.get("dbTarget").add(connection);
            }

            for (int i = 0; i < 3; i++) {
                Connection connection = DbUtils.getConnection("dbDataSync");
                map.get("dbDataSync").add(connection);
            }

            for (int i = 0; i < 3; i++) {
                Connection connection = DbUtils.getConnection("dbUnit");
                map.get("dbUnit").add(connection);
            }

            for (int i = 0; i < 3; i++) {
                Connection connection = DbUtils.getConnection("dbPoilce");
                map.get("dbPoilce").add(connection);
            }

            for (int i = 0; i < 3; i++) {
                Connection connection = DbUtils.getConnection("dbPoilce");
                map.get("dbUser").add(connection);
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection  线程安全
     */
    public static Connection getConnection(String key) {
        final ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            //如果没有连接了，则等待着新放入的连接
            if (map.get(key).isEmpty()) {
                notEmpty.await();
            }
            Connection connection = map.get(key).removeFirst();
            notFull.signalAll();
            System.out.println("取得连接"+ connection +", 当前连接次数" + map.get(key).size());
            return connection;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }

    /**
     * 释放连接  线程安全
     *
     * @param connection
     */
    public static void release(Connection connection, String key) {
        System.out.println("释放连接"+ connection +", 当前连接次数" + map.get(key).size());

        final ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (map.get(key).size() == COUNT) {
                System.out.println("连接池为空");
                notFull.await();
            }
            //恢复默认值
            if (connection.getAutoCommit() == false) {
                connection.setAutoCommit(true);
            }
            map.get(key).add(connection);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
       Connection connection = getConnection("dbPoilce");
        System.out.println(connection);
    }
}
