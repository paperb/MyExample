package com.example.demo;


import com.example.demo.dao.StatisticsDao;
import com.example.demo.entity.Client;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.io.IOException;


@SpringBootTest
public class MyTest {

@Autowired
    StatisticsDao statisticsDao;

    @Test
    public void test() throws IOException {
        Client client = statisticsDao.selectClient(1, 1);
        System.out.println(client);
    }



}


