package com.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by tl on 2018/5/15 0015.
 */
public class PropertiesUtils {
//    private static Properties properties;
    public static Map<String,Properties> properties_map = new HashMap<>();
    /*static {
        //缓存
        readFile();
    }*/
    private static void readFile(String fileName){
        try{
            if (properties_map.get(fileName) == null) {
                Properties properties = new Properties();
                // 使用ClassLoader加载properties配置文件生成对应的输入流
                InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName + ".properties");
                // 使用properties对象加载输入流
                properties.load(in);
                properties_map.put(fileName,properties);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get(String fileName,String key){
        //每次重新读取
        readFile(fileName);
        // 获取key对应的value值
       return properties_map.get(fileName).getProperty(key);
    }
}
