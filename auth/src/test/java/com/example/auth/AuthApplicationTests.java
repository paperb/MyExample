package com.example.auth;

import com.example.threadpoolspringbootstater.config.ThreadPoolAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;


@SpringBootTest
@RunWith(SpringRunner.class)
class AuthApplicationTests {
    @Autowired
    ThreadPoolExecutor executor;

    @Test
    void contextLoads() {
        System.out.println("CoreThreadPoolSize:" + executor.getCorePoolSize());
    }

}
