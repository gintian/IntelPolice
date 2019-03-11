package com.utils;

import javax.persistence.Column;
import java.lang.reflect.Field;

/**
 * Created by tl on 2018/5/19 0019.
 */
public class BeanUtils {
    public static void setBeanValue(Class cls, String key, String value, Object bean){
        for (Field f : cls.getDeclaredFields()) {
            try {
                    if (f.isAnnotationPresent(Column.class)) {
                        Column column = f.getAnnotation(Column.class);
                        if (column.name().equalsIgnoreCase(key)) {
                            boolean flag = f.isAccessible();
                            f.setAccessible(true);
                            f.set(bean, value);
                            f.setAccessible(flag);
                        }
                    }else if(f.getName().equalsIgnoreCase(key)){
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(bean, value);
                        f.setAccessible(flag);
                    }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("字段设置异常");
            }
        }
    }
}
