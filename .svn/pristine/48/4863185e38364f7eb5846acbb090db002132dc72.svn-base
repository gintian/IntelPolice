package com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonValidate {

    private final static String EMAIL_PATTERN             = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final static String MOBILE_PATTERN            = "^[0-9]{5,11}$";
    private final static String TELEPHONE_PATTERN         = "^[0-9-]{5,20}$";// 带区号
    private final static String TELEPHONE_WITHOUT_PATTERN = "^[0-9-]{5,20}$";// 不带区号
    private final static String NUMBER_PATTERN            = "[0-9]+";
    private final static String CHINESE_PATTERN           = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\s]+";
    private final static String SORT_PATTERN              = "^[1-9]{1}[0-9]{0,5}$";
    private final static String POSITIVE_NUMBE_PATTERN    = "^[0-9]*[1-9][0-9]*$";
    private final static String PASSWORD_PATTERN            = "^[A-Za-z0-9]{6,15}$";//密码6到15位长度的数字和字母
    private final static String RANDOMCODE_PATTERN          = "^[0-9A-Z]{4}$"; //随机码，如页面提交的动态验证码，手机注册码等
    private final static String regex = "[^'&\"~`\\|^☺<>%]{1,}"; //验证特殊字符
    private final static String SCIENTIFIC_PATTERN  =  "^-?\\d+(\\.\\d+)?(E-?\\d+)?$";  // 验证是否是科学计数法。
    private final static String DOUBLE_PATTERN  =  "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";  // 验证是否是科学计数法。
    private final static String ID_NO = "(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])";//身份证号
    private final static String BIRTHDAY = "^\\d{4}[\\/\\-](0?[1-9]|1[012])[\\/\\-](0?[1-9]|[12][0-9]|3[01])$";//生日


    public static boolean isIdNo(String idNo) {
        if(isEmpty(idNo)) {
            return false;
        }
        Pattern pattern = Pattern.compile(ID_NO);
        return pattern.matcher(idNo).matches();
    }

    /**
     * 验证是否包含特殊字符
     * @param str
     * @return
     */
    public static boolean isSpecial(String... str){
        Pattern p=Pattern.compile(regex);
        for(String s : str){
            Matcher m=p.matcher(s);
            if(m.matches() == false){
                return true;
            }
        }
        return false;
    }

    /**
     * 随机数
     */
    public static boolean isRandomCode(String randomCode) {
        if(isEmpty(randomCode)) {
            return false;
        }
        Pattern pattern = Pattern.compile(RANDOMCODE_PATTERN);
        return pattern.matcher(randomCode).matches();
    }

    /**
     * 验证是否是科学计数法
     */
    public static boolean isScientific(String randomCode) {
        if(isEmpty(randomCode)) {
            return false;
        }
        Pattern pattern = Pattern.compile(SCIENTIFIC_PATTERN);
        return pattern.matcher(randomCode).matches();
    }

    /**
     * 验证是否浮点数
     */
    public static boolean isDouble(String randomCode) {
        if(isEmpty(randomCode)) {
            return false;
        }
        Pattern pattern = Pattern.compile(DOUBLE_PATTERN);
        return pattern.matcher(randomCode).matches();
    }

    /**
     * 验证是否为中文字符
     */
    public static boolean isChineseCharacters(String characters) {
        Pattern pattern = Pattern.compile(CHINESE_PATTERN);
        return pattern.matcher(characters).matches();
    }

    /**
     * 验证是否为电子邮件
     */
    public static boolean isEmail(String email) {
        Matcher matcher = Pattern.compile(EMAIL_PATTERN).matcher(email);
        return matcher.matches();
    }

    /**
     * 验证是否为移动电话
     */
    public static boolean isMobile(String mobile) {
        Matcher matcher = Pattern.compile(MOBILE_PATTERN).matcher(mobile);
        return matcher.matches();
    }

    /**
     * 验证是否为移动电话
     */
    public static boolean matches(String mobile, String pattern) {
        Matcher matcher = Pattern.compile(MOBILE_PATTERN).matcher(mobile);
        return matcher.matches();
    }

    /**
     * 验证是否为电话
     */
    public static boolean isPhone(String phone) {
        if(isEmpty(phone)) {
            return false;
        }
        Matcher matcher;
        boolean result;
        Pattern p1 = Pattern.compile(TELEPHONE_PATTERN); // 验证带区号的
        Pattern p2 = Pattern.compile(TELEPHONE_WITHOUT_PATTERN); // 验证没有区号的
        if (phone.length() > 9) {
            matcher = p1.matcher(phone);
            result = matcher.matches();
        } else {
            matcher = p2.matcher(phone);
            result = matcher.matches();
        }
        return result;
    }

    public static boolean isMobileOrPhone(String str) {
        return isMobile(str) || isPhone(str);
    }

    public static boolean isNotAge(int age){
        return age < 1 || age > 150;
    }

    public static boolean isNotBirthday(String time){
        Pattern pattern = Pattern.compile(BIRTHDAY);
        Matcher matcher = pattern.matcher(time);
        return !matcher.matches();
    }

    /**
     * 检验密码
     * @param md5pw    加密后的密码，与数据库中的对应
     * @param shapw    sha后的密码
     * @return
     */
    public static boolean validatePw(String shapw, String md5pw) {
        // 验证密码是否正确
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(shapw, md5pw);
    }

    /**
     * 验证是否为数字
     */
    public static boolean isNumber(String number) {
        Matcher matcher = Pattern.compile(NUMBER_PATTERN).matcher(number);
        return matcher.matches();
    }

    /**
     * 验证对象是否是empty
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if(obj == null) {
            return true;
        }
        if(obj instanceof String) {
            String str = (String) obj;
            str = str.trim();
            return str.length() == 0;
        }
        if(obj instanceof List) {
            List list = (List) obj;
            return list.size() == 0;
        }
        if(obj instanceof Object[]) {
            Object[] arr = (Object[]) obj;
            return arr.length == 0;
        }
        return false;
    }

    /**
     * 验证对象是否是empty
     * @param objs
     * @return
     */
    public static boolean areEmpty(Object... objs) {
        boolean result = false;
        for (Object obj : objs) {
            if (obj == null) {
                result = true;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                result = str.length() == 0;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                result = list.size() == 0;
            }
            if (obj instanceof Object[]) {
                Object[] arr = (Object[]) obj;
                result = arr.length == 0;
            }
        }
        return result;
    }

    /**
     * 判断上传图片数量是否是限制的数量,默认至少上传1张以上的图片
     * @Param  objects         每一张图片名称
     * @return 没有图片返回false，否则返回ture
     */
    public static boolean uploadImgNum(Object... objects) {
        boolean result = false;
        for (Object object : objects) {
            if (object != null && object instanceof String && object != "") {
                result = true;
            }
        }
        return result;
    }

    /**
     * 传入图片字符串判断上传图片数量是否是限制的数量,默认至少上传1张以上的图片
     * @Param  imgStr       图片字符串（每张图片名称用','隔开）
     * @Param  num         图片数量
     * @return 超出限制返回true，否则返回false
     */
    public static boolean imgNumIsLong(String imgStr,int num) {
        if(isEmpty(imgStr)){
            return false;
        }else{
            String[] strArray = imgStr.split(",");
            if(strArray.length <= num){
                return false;
            }else {
                return true;
            }
        }
    }

    /**
     * 验证字符串是否不为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 验证数据是否在某个区间
     */
    public static boolean isInRange(String data, int minLength, int maxLength) {
        if (data.length() < minLength || data.length() > maxLength) {
            return false;
        }
        return true;
    }

    public static boolean isSort(Integer sort){
        Matcher matcher = Pattern.compile(SORT_PATTERN).matcher(sort.toString());
        return matcher.matches();
    }

    /**
     * 验证是否老人ID集合字符串
     *     只验证字段包括数字和字符串，防止注入；如果输入了其他东西或太长，数据库那边会报错。
     * @param str
     * @return
     */
    public static boolean isOldmanIdsStr(String str){

        if (CommonValidate.isEmpty(str)) {
            return false;
        }

        Pattern p = Pattern.compile("^[0-9,]*$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

//    public static void main(String[] a){
//        boolean aa = isMobileOrPhone("18900000001");
//        System.out.println(aa);
//    }

    private static void uploadImage(){
        System.out.println("upload-------------->" + uploadImgNum());
    }

    private static void testIsImgFileName() {

    }

    private static void testIsEmpty() {

        String a1 = null;
        String a2 = "";
        String a3 = "  ";
        String a4 = "1";

        List<String> b1 = null;
        List<String> b2 = new ArrayList<>();
        List<String> b3 = new ArrayList<>();
        b3.add("a");

        String[] c1 = null;
        String[] c2 = {};
        String[] c3 = {""};

        Integer d1 = null;
        Integer d2 = 0;

        System.out.println("a1===" + isEmpty(a1));
        System.out.println("a2===" + isEmpty(a2));
        System.out.println("a3===" + isEmpty(a3));
        System.out.println("a4===" + isEmpty(a4));
        System.out.println();
        System.out.println("b1===" + isEmpty(b1));
        System.out.println("b2===" + isEmpty(b2));
        System.out.println("b3===" + isEmpty(b3));
        System.out.println();
        System.out.println("c1===" + isEmpty(c1));
        System.out.println("c2===" + isEmpty(c2));
        System.out.println("c3===" + isEmpty(c3));
        System.out.println();
        System.out.println("d1===" + isEmpty(d1));
        System.out.println("d2===" + isEmpty(d2));

    }
}
