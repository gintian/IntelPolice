import com.conn.*;
import com.constant.CommonConstant;
import com.utils.PropertiesUtils;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tl on 2018/5/14 0014.
 * //整个数据备份的启动类
 */
public class PoillStart {
    //整个数据备份的启动类
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(PoillStart.class);
        //用户备份
        final UserConnection userConnection = new UserConnection();
        //110警务
        final PoilceConnection poilceConnection = new PoilceConnection();
        //用户
        final BpipConnection bpipConnection = new BpipConnection();
        //案事件
        final CaseConnection caseConnection = new CaseConnection();
        //code
        final CodeConnection codeConnection = new CodeConnection();
        //doc文书
        final DocConnection docConnection = new DocConnection();
        //毒品
        final DurgConnection durgConnection = new DurgConnection();
        //信息
        final SmsLogConnection smsLogConnection = new SmsLogConnection();
        //受立案监督
        final InvestigationConnection investigationConnection = new InvestigationConnection();

        //心跳任务类
        TimerTask timerTask = new TimerTask() {

            private int i = 1;
            @Override
            public void run() {
                //线程任务管理类
                ExecutorService executorService = Executors.newCachedThreadPool();

                logger.info("---------------------------start7------------------------");
               //部门
                try {
                    executorService.execute(bpipConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //用户
                try {
                    executorService.execute(userConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //110
                try {
                    executorService.execute(poilceConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //案事件
                try {
                    executorService.execute(caseConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //Code
                try {
                    executorService.execute(codeConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //文书
                try {
                    executorService.execute(docConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //毒品
                try {
                    executorService.execute(durgConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //信息
                try {
                    executorService.execute(smsLogConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }

                //受立案监督
                try {
                    executorService.execute(investigationConnection);
                } catch (Exception e) {
                    logger.debug("出错", e);
                }
                executorService.shutdown();
                logger.info("第"+(i++)+"次执行备份");
                logger.info("---------------------------end--------------------------");
            }
        };

        //心跳 执行类
        Timer timer = new Timer();
        try {
            timer.schedule(timerTask, new Date(), Integer.parseInt(PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.HEARTBEAT_TIME, "System")));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
