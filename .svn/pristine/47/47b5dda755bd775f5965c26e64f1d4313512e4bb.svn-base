package com.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tl on 2018/5/15 0015.
 */
public class PropertiesUtils {
    private static Properties properties;
    private static Properties propertiesSql;
    /*static {
        //缓存
        readFile();
    }*/
    private static void readFile(){
        try{
            properties = new Properties();
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
            // 使用properties对象加载输入流
            properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void readFileSql(){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(String key){
        //每次重新读取
        readFile();
        // 获取key对应的value值
       return properties.getProperty(key);
    }
    public static String getSql(String key){
        //每次重新读取
        readFileSql();
        // 获取key对应的value值
        return propertiesSql.getProperty(key);
    }

    public static String getConfigForPropertiesNameAndKey(String key, String propertiesName) throws Exception{
        Properties propertiesx = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream inSql = PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesName+".properties");
        // 使用properties对象加载输入流
        propertiesx.load(inSql);
        // 获取key对应的value值
        return propertiesx.getProperty(key);
    }

    public static void main(String[] args) {
        try {
                    String principalFileName = PropertiesUtils.getConfigForPropertiesNameAndKey("case_s_caseinfo"+".principalFileName", "configCase");
            System.out.println(principalFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
