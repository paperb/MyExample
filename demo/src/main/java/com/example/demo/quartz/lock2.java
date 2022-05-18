package com.example.demo.quartz;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
public class  lock2 implements Runnable {
    @Resource
    Redisson redisson;

    public static Redisson redisson1;
    @Override
    public void run() {
        RLock lock = redisson1.getLock("lock");
        try {
            lock.lock(3000, TimeUnit.MILLISECONDS);
            System.out.println(Thread.currentThread().getName()+"lock2上锁");
            Thread.sleep(2000);
        } catch (Exception e) {

        }finally {
            lock.unlock();
            System.out.println("lock2解锁");
        }

    }
    @PostConstruct
    void init(){
        redisson1=redisson;
    }
    }


