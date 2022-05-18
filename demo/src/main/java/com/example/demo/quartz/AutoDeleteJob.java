package com.example.demo.quartz;

import com.example.demo.handler.UserConnectionHandler;
import com.example.demo.service.DataTransferService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import java.io.IOException;
import java.util.Date;

@Component
public class AutoDeleteJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(AutoDeleteJob.class);
    @Autowired
    DataTransferService dataTransferService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        try {
//            dataTransferService.truncateList();
//            logger.info("清空表成功"+new Date());
//        } catch (Exception e) {
//            logger.error("清空表失败"+new Date());
//        }
//        try {
//            UserConnectionHandler userConnectionHandler = new UserConnectionHandler();
//            userConnectionHandler.sendAllSessionMessage("定时发送消息");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    }
