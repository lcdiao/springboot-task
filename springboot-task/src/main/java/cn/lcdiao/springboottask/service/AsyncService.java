package cn.lcdiao.springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: diao
 * @Description:
 * @Date: 2019/6/5 14:27
 */
@Service
public class AsyncService {

    //告诉spring，这是一个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000L);
            System.out.println("处理数据中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
