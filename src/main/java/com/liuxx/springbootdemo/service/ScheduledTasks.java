package com.liuxx.springbootdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:定时任务
 * Creator:liuxx
 * Date:2017/9/29 10:38
 */
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("hello");
        LOGGER.warn("The time is now {}", dateFormat.format(new Date()));
    }
}
