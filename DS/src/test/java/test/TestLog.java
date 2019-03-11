package test;

import com.constant.CommonConstant;
import com.utils.DateUtils;
import com.utils.PropertiesUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/30 0030.
 */
public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);
    @Test
    public void test(){
        logger.error("error");
        logger.debug("debug");
        logger.info("info");
    }


    @Test
    public void test033() throws Exception{
        Date date = new Date();
        System.out.println(DateUtils.dateToString(date, DateUtils.DEFAULT_DATE_PATTERN));
        Date dataendtime = DateUtils.add(date, Calendar.SECOND, Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.DATAENDTIME, "System")));

        System.out.println(DateUtils.dateToString(dataendtime, DateUtils.DEFAULT_DATE_PATTERN));
    }
}
