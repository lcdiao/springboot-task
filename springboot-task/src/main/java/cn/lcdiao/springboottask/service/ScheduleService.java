package cn.lcdiao.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author: diao
 * @Description:
 * @Date: 2019/6/5 14:35
 */
@Service
public class ScheduleService {

    /**
     * 秒、分、时、日、月、周（0-7  ：1-6代表周一到周六，0和7代表周日）
     * 【0 * * * * MON-FRI】      周一到周五每一分钟(0秒的时候)触发
     * 【0 0/5 14,18 * * ?】      每天14点整和18点整，每隔5分钟执行一次
     * 【0 15 10 ? *  1-6】       每个月的周一至周六10:15分执行一次
     * 【0 0 2 ? * 6L】           每个月的最后一个周六凌晨2点执行一次
     * 【0 0 2 LW * ?】           每个月的最后一个工作日凌晨2点执行一次
     * 【0 0 2-4 ? * 1#1】        每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次
     * */
    //@Scheduled(cron = "0 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")
    //@Scheduled(cron = "0-4 * * * * MON-FRI")
    //每隔4秒执行一次
    @Scheduled(cron = "0/4 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello ...");
    }
}
