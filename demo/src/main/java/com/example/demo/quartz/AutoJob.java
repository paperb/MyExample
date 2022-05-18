package com.example.demo.quartz;

import cn.hutool.Hutool;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.Scheduler;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.*;

@Slf4j
@Component
@Async
public class AutoJob {

    @Scheduled(cron = "0/10 * * * * ? ")
    public void testSc1() {
        log.info(Thread.currentThread().getName()+"定时任务开始01");
        //Thread.sleep(5000);

        Thread thread = new Thread(new lock1());
        Thread thread1 = new Thread(new lock2());
        thread.start();
        thread1.start();
    }


    //@Scheduled(cron = "0/10 * * * * ? ")
    public void testSc2() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"定时任务开始02");
        //Thread.sleep(5000);
    }

    //@Scheduled(cron = "0/10 * * * * ? ")
    public void testSc3() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"定时任务开始03");
        //Thread.sleep(5000);
    }

}
