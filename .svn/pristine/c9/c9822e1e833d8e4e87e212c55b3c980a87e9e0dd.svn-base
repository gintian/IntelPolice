package com.utils;

import java.util.Random;
/**
 * 产生随机数类
 */
public class RandomUtils {
    /**
     *
     * @param m  机构首写字母
     * @param code 机构码
     * @return   生成 机构首写字母 + 机构码 + 当前时间 + 3位随机数(100-999)
     */
    public static String RandomCode(String m,String code){
        if("-1".equals(code)){
            code = "520421000000";
        }
        Random rand = new Random();
        int MAX = 999;
        int MIN = 100;
        int randomNum = (rand.nextInt(MAX - MIN + 1) + MIN);
        long curTime = System.currentTimeMillis();
        return m + code + curTime + randomNum;
    }
}
