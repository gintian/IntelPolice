package com.utils;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static final String DATE_YYTOSS = "yyyyMMddHHmmss";
    public static final String DATE_DAY = "yyyyMMdd";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_MESEC_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DAY_PATTERN = "yyyy-MM-dd";
    public static final String DEVICE_DATE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String DEVICE_DAY_PATTERN = "yyyy-MM-dd";
    public static final String DEVICE_DAY_PATTERN_2 = "MM月dd日";
    public static final String DEVICE_DAY_PATTERN_3 = "yy-MM";
    public static final String DEVICE_TIME_PATTERN = "HH:mm";
    public static final String DEVICE_TIME_PATTERN_SECOND = "HH:mm:ss";
    public static final String DEVICE_TIME_PATTERN_1 = "MM/dd HH:mm:ss";
    public static final String DEVICE_DAY_PATTERN_EXCEL_DAY = "yyyy/MM/dd";
    public static final String DEVICE_DAY_PATTERN_EXCEL_MINUTE = "yyyy/MM/dd HH:mm";
    public static final String DEVICE_DAY_FILLSEC = "yyyy-MM-dd 00:00:00";
    public static final String DEVICE_MONTH_PATTERN = "yyyy-MM";
    public static final String DEVICE_DAY_PATTERN_4 = "MM-dd HH:mm";
    public static final String DEVICE_DAY_PATTERN_5 = "MM-dd";
    public static final String DEVICE_YEAR_PATTERN = "yyyy";
    public static final String DEVICE_MONTH_PATTERN_1 = "yyyyMM";
    public static final String DEVICE_DAY_MSG = "yyyy.MM.DD";
    public static final String DEFAULT_DAY_CHINESE = "yyyy年MM月dd";
    public static final String DEFAULT_DAY_CHINESE_PATTERN = "yyyy年MM月dd日  HH时mm分";


    public static Date getDate(long timestamp) {
        return new Date(timestamp);
    }

    public static Date addMinute(int to) {
        Calendar strDate = Calendar.getInstance();
        strDate.add(Calendar.MINUTE, to);
        return strDate.getTime();
    }


    public static Date stringToDate(String str, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 根据生日获取年龄
     *
     * @param birthday
     * @param nowDate
     * @return
     */
    public static int getAgeByBirthday(Date birthday, Date nowDate) {

        nowDate = nowDate == null ? DateUtils.getCurrentDate() : nowDate;

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(nowDate);
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(birthday);
        int birthYear = calendar.get(Calendar.YEAR);
        int birthMonth = calendar.get(Calendar.MONTH);
        int birthDay = calendar.get(Calendar.DAY_OF_MONTH);

        int ltMonthYear = -1;
        int nowDayCount = nowMonth * 100 + nowDay;
        int birthDayCount = birthMonth * 100 + birthDay;
        if (nowDayCount >= birthDayCount) {
            // 当前日期大于出生日期，已经过生日
            ltMonthYear = 0;
        }

        return nowYear - birthYear + ltMonthYear;
    }

    public static String getCurrentTime() {
        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        return timeFmt.format(new Date());
    }

    public static String getCurrentDayFillSec() {
        DateFormat timeFmt = new SimpleDateFormat(DEVICE_DAY_FILLSEC, Locale.CHINA);
        return timeFmt.format(new Date());
    }

    /**
     *得到yyyy-MM-dd HH:mm:ss格式的时间
     * @return
     */
    public static String getCurrentDateTime() {
        DateFormat timeFmt = new SimpleDateFormat(getDefaultDatePattern(), Locale.CHINA);
        return timeFmt.format(new Date());
    }

    /**
     * 获得当天的23点59分59秒999毫秒时间
     */
    public static Date getDayOfEndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取固定时间 结束时间
     *
     * @param date
     * @param hour
     * @param min
     * @return
     */
    public static Date getDateOfEndTime(Date date, int hour, int min) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取固定时间 开始时间
     *
     * @param date
     * @param hour
     * @param min
     * @return
     */
    public static Date getDateOfStartTime(Date date, int hour, int min) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 是不是同一天
     * @return
     */
    /**
     * 判断是不是同一天
     *
     * @param dateA 时间A
     * @param dateB 时间B
     * @return true = 是同一天; false = 不是同一天，或者有值为null
     */
    public static boolean isSameDay(Date dateA, Date dateB) {

        if (dateA == null || dateB == null) {
            //有一个是空，返回false
            return false;
        }

        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(dateA);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(dateB);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定时间的那年的第一天
     *
     * @param date
     * @return
     */
    public static Date getDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.MONDAY, 1);
        return cal.getTime();
    }

    /**
     * 获得当天的0点0分0秒0毫秒时间
     */
    public static Date getDayOfBeginTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取本月的第一天
     *
     * @param dt
     * @return
     */
    public static Date getMonthDay01(Date dt) {
        Calendar calendar = Calendar.getInstance();
        int month_day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
        if (month_day != 0) {
            calendar.add(Calendar.DAY_OF_MONTH, -month_day);
        }
        return calendar.getTime();
    }

    /**
     * 获取指定日期的上周五
     *
     * @param dt
     * @return
     */
    public static Date getLastWeekFive(Date dt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 7) {
            return calendar.getTime();
        }
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek != 0) {
            calendar.add(Calendar.DAY_OF_WEEK, -dayOfWeek);
        }
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        return calendar.getTime();
    }

    /**
     * 获取指定日期上月时间
     * @param dt
     * @return
     */
    public static Date getLastMonth(Date dt){
        if( null == dt ){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        return calendar.getTime();
    }

    /**
     * 获得当前时间3个月前的时间
     */
    public static Date getThreeMonthAgoDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        return calendar.getTime();
    }

    /**
     * 获取指定以前的某个月份的时间
     */
    public static Date getMonthAgoDate(int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -number);
        return calendar.getTime();
    }

    /**
     * 得到指定格式的时间字符串
     */
    public static String getMyDateTime(Date d, String pattern) {
        if( null == d ){
            return null;
        }
        DateFormat dtFmt = new SimpleDateFormat(pattern);
        String myDate = "";
        try {
            myDate = dtFmt.format(d);
        } catch (Exception ex) {
            System.out.print("Parser Exception: Invalid Date or pattern!");
        }
        return myDate;
    }

    public static Date getEndOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MILLISECOND, -1);
        return cal.getTime();
    }

    /**
     * 按XX小时XX分返回两个时间点中的时间
     *
     * @param startDt
     * @param endDt
     * @return
     */
    public static String getHourMinuteStrBetweenDate(Date startDt, Date endDt) {
        long totalSeconds = (endDt.getTime() - startDt.getTime()) / 1000;
        long hours = totalSeconds % (24 * 3600) / 3600;
        long minutes = totalSeconds % 3600 / 60;
//        long seconds = totalSeconds % 60;
        return String.format("%d小时%d分", hours, minutes);
    }

    /**
     * 从两个时间中得到小时数, 不足一小时按1小时返回
     *
     * @param startDt
     * @param endDt
     * @return
     */
    public static long getHoursBetweenDate(Date startDt, Date endDt) {
        long totalSeconds = (endDt.getTime() - startDt.getTime()) / 1000;
        long hours = totalSeconds % (24 * 3600) / 3600;
        long minutes = totalSeconds % 3600 / 60;
        if (minutes > 0) {
            hours += 1;
        }
        return hours;
    }

    /**
     * 从两个时间中得到分钟数
     *
     * @param startDt
     * @param endDt
     * @return
     */
    public static int getMinutesBetweenDate(Date startDt, Date endDt) {
        long totalSeconds = (endDt.getTime() - startDt.getTime()) / 1000;
        long minutes = totalSeconds / 60;
//        return minutes;

        return Long.valueOf(minutes).intValue();
    }

    /**
     * 手机端时间显示,格式为yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    public static String toDeviceDisplay(Date date) {
        if (date == null) {
            return null;
        }
        DateFormat dtFmt = new SimpleDateFormat(DEVICE_DATE_PATTERN, Locale.CHINA);
        return dtFmt.format(date);
    }

    /**
     * 手机端时间显示,格式为yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String toDeviceBirthdayDisplay(Date date) {
        if (date == null) {
            return null;
        }
        DateFormat dtFmt = new SimpleDateFormat(DEVICE_DAY_PATTERN, Locale.CHINA);
        return dtFmt.format(date);
    }

    public static Date parseToBirthday(String date) {
        return parseDate(date, DEVICE_DAY_PATTERN);
    }

    /**
     * 转换指定格式的时间为字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (date == null)
            return "";
        DateFormat dtFmt = new SimpleDateFormat(format, Locale.CHINA);
        return dtFmt.format(date);
    }

    /**
     * 手机端时间显示,格式为 yyyy-MM-dd HH:mm - HH:mm(同一天) 或者 yyyy-MM-dd HH:mm - yyyy-MM-dd HH:mm(不同天)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String toDeviceDisplay(Date startDate, Date endDate) {
        StringBuffer sb = new StringBuffer("");
        if (startDate == null || endDate == null) {
            return sb.toString();
        }

        DateFormat dateFmt = new SimpleDateFormat(DEVICE_DAY_PATTERN, Locale.CHINA);
        String startDateStr = dateFmt.format(startDate);
        String endDateStr = dateFmt.format(endDate);

        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        String startTimeStr = timeFmt.format(startDate);
        String endTimeStr = timeFmt.format(endDate);

        String dateTimeStr;
        if (startDateStr.equals(endDateStr)) {
            dateTimeStr = String.format("%s %s-%s", startDateStr, startTimeStr, endTimeStr);
        } else {
            dateTimeStr = String.format("%s %s-%s %s", startDateStr, startTimeStr, endDateStr, endTimeStr);
        }
        return dateTimeStr;
    }

    /**
     * 手机端时间显示,格式为 MM月dd日 HH:mm
     */
    public static String toDateTime(Date date, Date time) {
        if (date == null) {
            return "";
        }

        DateFormat dateFmt = new SimpleDateFormat(DEVICE_DAY_PATTERN_2, Locale.CHINA);
        String dateStr = dateFmt.format(date);

        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        String timeStr = timeFmt.format(time);
        return String.format("%s%s", dateStr, timeStr);
    }

    /**
     * 根据时间得到
     */
    public static String toDateYYMM(Date date1) {
        if (date1 == null) {
            return "";
        }
        DateFormat dateFmt = new SimpleDateFormat(DEVICE_DAY_PATTERN_3, Locale.CHINA);
        String dateStr1 = dateFmt.format(date1);
        return String.format("%s", dateStr1);
    }

    /**
     * 手机端时间显示,格式为 MM月dd日 HH:mm - HH:mm(同一天) 或者 MM月dd日 HH:mm - MM月dd日 HH:mm(不同天)
     */
    public static String getFreeDateTime(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return "";
        }

        DateFormat dateFmt = new SimpleDateFormat(DEVICE_DAY_PATTERN_2, Locale.CHINA);
        String startDateStr = dateFmt.format(startDate);
        String endDateStr = dateFmt.format(endDate);

        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        String startTimeStr = timeFmt.format(startDate);
        String endTimeStr = timeFmt.format(endDate);
        String dateTimeStr;
        if (startDateStr.equals(endDateStr)) {
            dateTimeStr = String.format("%s %s-%s", startDateStr, startTimeStr, endTimeStr);
        } else {
            dateTimeStr = String.format("%s %s-%s %s", startDateStr, startTimeStr, endDateStr, endTimeStr);
        }
        return dateTimeStr;
    }

    /**
     * 手机端时间显示,格式为 MM月dd日 HH:mm - HH:mm(同一天) 或者 MM月dd日 HH:mm - MM月dd日 HH:mm(不同天) (Car Parker 模块使用)
     */
    public static String getFreeDateTimeForTxn(Date startDate, Date endDate, Date txnDate) {
        if (startDate == null || endDate == null) {
            return "";
        }
        DateFormat dateFmt = new SimpleDateFormat(DEVICE_DAY_PATTERN_2, Locale.CHINA);
        String dateStr = dateFmt.format(txnDate);

        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        String startTimeStr = timeFmt.format(startDate);
        String endTimeStr = timeFmt.format(endDate);

        return String.format("%s %s-%s", dateStr, startTimeStr, endTimeStr);
    }

    /**
     * 手机端时间显示,格式为 [周期名 HH:mm - HH:mm]  (Car Parker 模块使用)
     */
    public static String getFreeDateTimeForDuration(Date startDate, Date endDate, int duration) {
        StringBuffer sb = new StringBuffer("");
        if (startDate == null || endDate == null) {
            return sb.toString();
        }

        String dateStr = null;
        switch (duration) {
            case 1:
                dateStr = "";
                break;
            case 2:
                dateStr = "每天";
                break;
            case 3:
                dateStr = "周一到周五";
                break;
            case 4:
                dateStr = "周末";
                break;
        }
        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        String startTimeStr = timeFmt.format(startDate);
        String endTimeStr = timeFmt.format(endDate);

        return String.format("%s %s-%s", dateStr, startTimeStr, endTimeStr);
    }

    /**
     * 返回两个时间之间的天数（不满一天算1天）
     *
     * @param startDt
     * @param endDt
     * @return
     */
    public static Integer getStartEndDateForDay(Date startDt, Date endDt) {
        if (startDt == null || endDt == null) {
            return 0;
        }

        startDt = parseDate(toString(startDt, DEVICE_DATE_PATTERN), DEVICE_DATE_PATTERN);
        endDt = parseDate(toString(endDt, DEVICE_DATE_PATTERN), DEVICE_DATE_PATTERN);

        long interval = endDt.getTime() - startDt.getTime();
        BigDecimal dayBigDecimal = new BigDecimal(interval)
                .divide(new BigDecimal(1000), 2)
                .divide(new BigDecimal(60), 2)
                .divide(new BigDecimal(60), 2)
                .divide(new BigDecimal(24), 2);
        return dayBigDecimal.intValue();
    }

    public static String displayDeviceTime(Date date) {
        if (date == null) {
            return null;
        }

        DateFormat timeFmt = new SimpleDateFormat(DEVICE_TIME_PATTERN, Locale.CHINA);
        String time = timeFmt.format(date);
        return time;
    }

    public static String getDefaultDatePattern() {
        return DEFAULT_DATE_PATTERN;
    }

    public static String getDefaultDayPattern() {
        return DEFAULT_DAY_PATTERN;
    }

    public static String getDeviceTimePattern1() {
        return DEVICE_TIME_PATTERN_1;
    }

    public static String getDeviceDatePattern() {
        return DEVICE_DATE_PATTERN;
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static int getCurrentDateYear() {
        Calendar a = Calendar.getInstance();
        return a.get(Calendar.YEAR);
    }

    public static int getCurrentDateMoth() {
        Calendar a = Calendar.getInstance();
        return a.get(Calendar.MONTH) + 1;
    }

    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getSystemTimePattern() {
        return "HH:mm";
    }

    public static Date parseDate(String str, String pattern) {
        if (str == null || str.trim().equals(""))
            return null;

        Date dt = null;
        DateFormat dtFmt = new SimpleDateFormat(pattern, Locale.CHINA);
        try {
            new Date();
            dt = new Date(dtFmt.parse(str).getTime());
        } catch (Exception ex) {
            System.out.println("Parser Exception: Invalid Date or pattern!");
        }
        return dt;
    }

    public static Date parseDate(Timestamp time) {
        if (time == null)
            return null;

        return new Date(time.getTime());
    }

    /**
     * 得到指定格式的时间
     *
     * @param str
     * @param pattern
     * @return
     */
    public static Timestamp parseTimestamp(String str, String pattern) {
        if (str == null || str.equals(""))
            return null;

        Timestamp dt = null;
        try {
            DateFormat dtFmt = new SimpleDateFormat(pattern, Locale.CHINA);
            dt = new Timestamp(dtFmt.parse(str).getTime());
        } catch (Exception ex) {
            System.out.println("Parser Exception: Invalid Timestamp or pattern!");
        }
        return dt;
    }

    public static Timestamp parseTimestamp(Date date) {
        if (date == null)
            return null;

        return new Timestamp(date.getTime());
    }

    public static String toTimeString(Date date) {
        String pattern = getSystemTimePattern();
        return toString(date, pattern);
    }

    public static String toTimeString(Timestamp timestamp) {
        String pattern = getSystemTimePattern();
        return toString(timestamp, pattern);
    }

    public static String toString(Date date, String pattern) {
        if (date == null)
            return "";
        DateFormat dtFmt = new SimpleDateFormat(pattern, Locale.CHINA);
        return dtFmt.format(date);
    }

    public static String toString(Timestamp timestamp, String pattern) {
        if (timestamp == null)
            return "";
        DateFormat dtFmt = new SimpleDateFormat(pattern, Locale.CHINA);
        return dtFmt.format(timestamp);
    }

    public static Date add(Date datetime, long number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        return new Date(calendar.getTimeInMillis() + number);
    }

    public static Date add(Date datetime, int datepart, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.add(datepart, number);
        return new Date(calendar.getTimeInMillis());
    }

    public static Timestamp add(Timestamp datetime, int datepart, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(datetime.getTime());
        calendar.add(datepart, number);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Date roll(Date datetime, int datepart, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.roll(datepart, number);
        return new Date(calendar.getTimeInMillis());
    }

    public static Timestamp roll(Timestamp datetime, int datepart, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(datetime.getTime());
        calendar.roll(datepart, number);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Date getDateAfterMonth(int to) {
        Calendar strDate = Calendar.getInstance();
        strDate.add(Calendar.MONTH, to);
        return new Date(strDate.getTimeInMillis());
    }

    public static long getDatetimeIntGap(Date headDate, Date tailDate, int datepart)
            throws Exception {
        long millisecond = tailDate.getTime() - headDate.getTime();
        long value = 0;

        switch (datepart) {
            case Calendar.MILLISECOND: {
                value = millisecond;
                break;
            }
            case Calendar.SECOND: {
                value = millisecond / 1000;
                break;
            }
            case Calendar.MINUTE: {
                value = millisecond / 1000 / 60;
                break;
            }
            case Calendar.HOUR: {
                value = millisecond / 1000 / 60 / 60;
                break;
            }
            case Calendar.DATE: {
                value = millisecond / 1000 / 60 / 60 / 24;
                break;
            }
            case Calendar.WEEK_OF_YEAR: {
                value = millisecond / 1000 / 60 / 60 / 24 / 7;
                break;
            }
            case Calendar.MONTH: {
                Calendar headCal = Calendar.getInstance();
                Calendar tailCal = Calendar.getInstance();
                headCal.setTime(headDate);
                tailCal.setTime(tailDate);
                value = (tailCal.get(Calendar.YEAR) - headCal.get(Calendar.YEAR)) * 12
                        + (tailCal.get(Calendar.MONTH) - headCal.get(Calendar.MONTH));
                break;
            }
            case Calendar.YEAR: {
                Calendar headCal = Calendar.getInstance();
                Calendar tailCal = Calendar.getInstance();
                headCal.setTime(headDate);
                tailCal.setTime(tailDate);
                value = tailCal.get(Calendar.YEAR) - headCal.get(Calendar.YEAR);
                break;
            }
            default: {
                throw new Exception();
            }
        }

        return value;
    }

    public static double getDatetimeFltGap(Date headDate, Date tailDate, int datepart)
            throws Exception {
        double millisecond = Double.longBitsToDouble(tailDate.getTime() - headDate.getTime());
        double value = 0;

        switch (datepart) {
            case Calendar.MILLISECOND: {
                value = millisecond;
                break;
            }
            case Calendar.SECOND: {
                value = millisecond / 1000;
                break;
            }
            case Calendar.MINUTE: {
                value = millisecond / 1000 / 60;
                break;
            }
            case Calendar.HOUR: {
                value = millisecond / 1000 / 60 / 60;
                break;
            }
            case Calendar.DATE: {
                value = millisecond / 1000 / 60 / 60 / 24;
                break;
            }
            case Calendar.WEEK_OF_YEAR: {
                value = millisecond / 1000 / 60 / 60 / 24 / 7;
                break;
            }
            case Calendar.MONTH: {
                value = millisecond / 1000 / 60 / 60 / 24 / 30.5;
                break;
            }
            case Calendar.YEAR: {
                value = millisecond / 1000 / 60 / 60 / 24 / 365;
                break;
            }
            default: {
                throw new Exception();
            }
        }

        return value;
    }

    public static int getDateTimePart(Date datetime, int datepart) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(datetime.getTime());
        return cal.get(datepart);
    }

    public static void setDateTimePart(Date datetime, int datepart, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(datetime.getTime());
        cal.set(datepart, value);
        datetime.setTime(cal.getTimeInMillis());
    }

    public static boolean isAfterToday(Date date) {
        if (date == null)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        Calendar now = Calendar.getInstance();

        if (cal.get(Calendar.YEAR) > now.get(Calendar.YEAR)
                || (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR) && cal.get(Calendar.DAY_OF_YEAR) > now
                .get(Calendar.DAY_OF_YEAR))) {
            return true;
        } else
            return false;
    }

    public static boolean isAfterEqualToday(Date date, int dayIncrement) {
        if (date == null)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        Calendar now = Calendar.getInstance();

        if (dayIncrement == 0) {
            if (cal.get(Calendar.YEAR) >= now.get(Calendar.YEAR)
                    || (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR) && cal.get(Calendar.DAY_OF_YEAR) >= now
                    .get(Calendar.DAY_OF_YEAR))) {
                return true;
            } else {
                return false;
            }
        } else {
            if (cal.get(Calendar.YEAR) >= now.get(Calendar.YEAR)
                    || (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR) && cal.get(Calendar.DAY_OF_YEAR) >= now
                    .get(Calendar.DAY_OF_YEAR + dayIncrement))) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isBeforeToday(Date date) {
        if (date == null)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        Calendar now = Calendar.getInstance();

        if (cal.get(Calendar.YEAR) < now.get(Calendar.YEAR)
                || (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR) && cal.get(Calendar.DAY_OF_YEAR) < now
                .get(Calendar.DAY_OF_YEAR))) {
            return true;
        } else
            return false;
    }

    public static boolean isBeforeEqualToday(Date date) {
        if (date == null)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        Calendar now = Calendar.getInstance();

        if (cal.get(Calendar.YEAR) <= now.get(Calendar.YEAR)
                || (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR) && cal.get(Calendar.DAY_OF_YEAR) <= now
                .get(Calendar.DAY_OF_YEAR))) {
            return true;
        } else
            return false;
    }

    public static boolean isAfterNow(Timestamp time) {
        if (time == null)
            return false;

        if (time.after(new Timestamp(System.currentTimeMillis())))
            return true;
        else
            return false;
    }

    public static boolean isBeforeNow(Timestamp time) {
        if (time == null)
            return false;

        if (time.before(new Timestamp(System.currentTimeMillis())))
            return true;
        else
            return false;
    }

    public static boolean isBefore10Mins(Date time) {
        if (time == null)
            return false;

        if (new Timestamp(System.currentTimeMillis() - 600000).before(time))
            return true;
        else
            return false;
    }

    public static boolean isLeapYear(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(date.getTime());
        return cal.isLeapYear(cal.get(Calendar.YEAR));
    }

    public static long compare(Date headDate, Date tailDate) {
        return tailDate.getTime() - headDate.getTime();
    }

    public static long getSub(Date headDate, Date tailDate) {
        return tailDate.getTime() - headDate.getTime();
    }

    public static Calendar addDate(int to) {
        Calendar strDate = Calendar.getInstance();
        strDate.add(Calendar.DATE, to);
        return strDate;
    }

    public static String getDurationDate(Date start, Date end) throws Exception {
        if (start == null || end == null || compare(start, end) < 0)
            return null;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        startCalendar.set(Calendar.MILLISECOND, 0);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        endCalendar.set(Calendar.HOUR_OF_DAY, 0);
        endCalendar.set(Calendar.MINUTE, 0);
        endCalendar.set(Calendar.SECOND, 0);
        endCalendar.set(Calendar.MILLISECOND, 0);

        int durationYear = 0;
        int durationMonth = 0;
        int durationDay = 0;

        // Compute Year Value
        startCalendar.add(Calendar.YEAR, 1);
        while (startCalendar.before(endCalendar) || SameDay(startCalendar, endCalendar)) {
            durationYear++;
            startCalendar.add(Calendar.YEAR, 1);
        }
        startCalendar.add(Calendar.YEAR, -1);

        // Compute Month Value
        startCalendar.add(Calendar.MONTH, 1);
        while (startCalendar.before(endCalendar) || SameDay(startCalendar, endCalendar)) {
            durationMonth++;
            startCalendar.add(Calendar.MONTH, 1);
        }
        startCalendar.add(Calendar.MONTH, -1);

        // Compute Day Value
        startCalendar.add(Calendar.DAY_OF_YEAR, 1);
        durationDay++;
        while (startCalendar.before(endCalendar) || SameDay(startCalendar, endCalendar)) {
            durationDay++;
            startCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        StringBuffer duration = new StringBuffer();
        duration.append(durationYear < 10 ? "0" + durationYear : "" + durationYear);
        duration.append(durationMonth < 10 ? "0" + durationMonth : "" + durationMonth);
        duration.append(durationDay < 10 ? "0" + durationDay : "" + durationDay);
        return duration.toString();
    }

    public static boolean SameDay(Calendar startCalendar, Calendar endCalendar) {
        if (startCalendar.get(Calendar.YEAR) == endCalendar.get(Calendar.YEAR)
                && startCalendar.get(Calendar.MONTH) == endCalendar.get(Calendar.MONTH)
                && startCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDate(String str) {
        try {
            parseDate(str, DEFAULT_DATE_PATTERN);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isTime(String value) {
        try {
            parseDate(value + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 得到今天以前指定天数的时间，如：向前数一天的时间
     */
    public static Date getBeforeSomeDays(int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE, -number);
        return calendar.getTime();
    }

    /**
     * 获取偏移后的日期
     *
     * @param givenDate
     * @param offset
     * @return
     */
    public static Calendar getOffsetDateForGivenDate(Date givenDate, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.DATE, offset);
        return cal;
    }

    /**
     * 判断一个时间段包含的月数
     *
     * @param formatStr 时间格式
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getMonths(String formatStr, String startDate, String endDate) {
        int iMonth = 0;
        int flag = 0;
        try {
            SimpleDateFormat format2 = new SimpleDateFormat(formatStr);
            Date date1 = format2.parse(startDate);
            Date date2 = format2.parse(endDate);
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);

            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);

            if (objCalendarDate2.equals(objCalendarDate1))
                return 1;
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }
            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))
                flag = 1;

            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR))
                        * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
                        - objCalendarDate1.get(Calendar.MONTH);
            else
                iMonth = objCalendarDate2.get(Calendar.MONTH)
                        - objCalendarDate1.get(Calendar.MONTH) - flag;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth + 1;
    }

    /**
     * 得到当月最大天数
     *
     * @param formatStr
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getMaxDayOnMonth(String formatStr, String date) throws ParseException {
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(new SimpleDateFormat(formatStr).parse(date));
        cal_1.set(Calendar.DATE, 1);     //把日期设置为当月第一天
        cal_1.roll(Calendar.DATE, -1);
        int maxDate = cal_1.get(Calendar.DATE);
        return maxDate;
    }

    public static String displayTimeToNow(Date date) {
        if (date == null) {
            return "--";
        }
        long diffLong = DateUtils.compare(date, DateUtils.getCurrentDate());
        long diff = diffLong / 1000L;       //秒
        if (diff < 60) {
            return "刚刚";
        }
        diff = diff / 60;           //分
        if (diff < 60) {
            return diff + "分钟前";
        }
        diff = diff / 60;           //小时
        if (diff < 24) {
            return diff + "小时前";
        }
        diff = diff / 24;           //天
        if (diff < 3) {
            return diff + "天前";
        }
        return dateToString(date, DEVICE_DAY_PATTERN);
    }

    public static String displayTimeToNow2(Date date) {
        if (date == null) {
            return "--";
        }
        long diffLong = DateUtils.compare(date, DateUtils.getCurrentDate());
        long diff = diffLong / 1000L;       //秒
        if (diff < 60) {
            return "刚刚";
        }
        diff = diff / 60;           //分
        if (diff < 60) {
            return diff + "分钟前";
        }
        diff = diff / 60;           //小时
        if (diff < 24) {
            return diff + "小时前";
        }
        diff = diff / 24;           //天
        if (diff < 3) {
            return diff + "天前";
        }
        return dateToString(date, DEVICE_DAY_PATTERN_EXCEL_DAY);
    }

    public static String displayTimeToDt(Date date) {
        if (date == null) {
            return "--";
        }
        long diffLong = DateUtils.compare(date, DateUtils.getCurrentDate());
        long diff = diffLong / 1000L;       //秒
        if (diff < 60) {
            return "刚刚";
        }
        diff = diff / 60;           //分
        if (diff < 60) {
            return diff + "分钟前";
        }
        diff = diff / 60;           //小时
        if (diff < 24) {
            return diff + "小时前";
        }
        diff = diff / 24;           //天
        if (diff < 30) {
            return diff + "天前";
        }
        diff = diff / 30;
        if (diff < 12) {
            return diff + "月前";
        }
        diff = diff / 12;
        return diff + "年前";
    }

    /**
     * 在指定的时间基础上加上指定天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getDateAfterDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }

    /**
     * 根据年 月 获取对应的月份 天数
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当月的 天数
     */
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据身份证号码计算出生日期
     *
     * @param idNo
     * @return
     */
    public static Date idNoToBirthday(String idNo) {
        Date date = null;
        String birthday = null;
        SimpleDateFormat sdf = null;
        if (idNo.length() == 18) {
            birthday = idNo.substring(6, 14);
            sdf = new SimpleDateFormat("yyyyMMdd");

        } else {
            birthday = idNo.substring(6, 12);
            sdf = new SimpleDateFormat("yyMMdd");
        }
        try {
            date = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 根据身份证号确定性别
     *
     * @param idNo
     * @return 1 男  0 女
     */
    public static int idNoToSex(String idNo) {
        String sex = null;
        if (idNo.length() == 18) {
            sex = idNo.substring(idNo.length() - 2, idNo.length() - 1);
        } else {
            sex = idNo.substring(idNo.length() - 1, idNo.length());
        }
        if (Integer.parseInt(sex) % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static Date getBirthdayStart(int year, Date date) {
        date = date == null ? DateUtils.getCurrentDate() : date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtils.getDayOfBeginTime(date));
        cal.add(Calendar.YEAR, -year);
        return cal.getTime();
    }

    public static Date getBirthdayEnd(int year, Date date) {
        date = date == null ? DateUtils.getCurrentDate() : date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateUtils.getDayOfBeginTime(date));
        cal.add(Calendar.YEAR, -(year + 1));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static String toDisplayToNewCalendarDate(Date date) {
        String DEVICE_DATE_PATTERN = "M月dd";
        if (date == null) {
            return null;
        }
        DateFormat dtFmt = new SimpleDateFormat(DEVICE_DATE_PATTERN, Locale.CHINA);
        return dtFmt.format(date);
    }

    public static int getForWeek(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    private static void testGetAge() {
        Date birthDate = DateUtils.stringToDate("1946-04-13", DateUtils.DEVICE_DAY_PATTERN);
        System.out.println(getAgeByBirthday(birthDate, null));
    }

    private static void testGetBirthdayDate() {
        Date date = DateUtils.stringToDate("2017-04-13", DateUtils.DEVICE_DAY_PATTERN);
        date = null;
        System.out.println(getBirthdayStart(5, date));
        System.out.println(getBirthdayEnd(5, date));
    }

    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {//格式化为相同格式
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取指定日期 那周第一天
     *
     * @param date
     * @return
     */
    public static Date getDayOfWeek(Date date) {
        if (date == null) {
            date = getCurrentDate();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayOfWeek);
        return getDayOfBeginTime(cal.getTime());
    }

    /**
     * 获取指定日期 那季第一天
     *
     * @param date
     * @return
     */
    public static Date getDayOfQuarter(Date date) {
        if (date == null) {
            date = getCurrentDate();
        }
        final int[] SEASON = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);

        int month_day = cal.get(Calendar.DAY_OF_MONTH) - 1;
        if (month_day != 0) {
            cal.add(Calendar.DAY_OF_MONTH, -month_day);
        }
        return cal.getTime();
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(dateToString(getDayOfQuarter(stringToDate("20171206", DateUtils.DATE_DAY)), DateUtils.DATE_DAY));
//
////        System.out.println(stringToDate("20170706", "yyyy-MMdd"));
//        //System.out.println(toString(getMonthDay01(parseDate("2017-07-31 13:00", DEVICE_DATE_PATTERN)), DEVICE_DATE_PATTERN));
//    }

    private static void isSameDayTest() {
        System.out.println(isSameDay(DateUtils.getCurrentDate(), DateUtils.getDateAfterDays(DateUtils.getCurrentDate(), 0)));
    }

    private static void getEndOfLastMonthTest() {
        Date date = getEndOfLastMonth();
        String str = DateUtils.dateToString(date, DateUtils.DEFAULT_DATE_PATTERN);
        System.out.println(date);
        System.out.println(str);
    }
}
