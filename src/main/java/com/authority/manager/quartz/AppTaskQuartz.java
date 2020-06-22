package com.authority.manager.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author yls
 * @Date 2020/3/30 11:50
 * @Description 定时器：注解的方式自动注入
 * @Version 1.0
 **/
@Component
@Configuration
@EnableScheduling
public class AppTaskQuartz {
    //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(AppTaskQuartz.class);

    @Scheduled(cron = "0 0 12  * * * ")
    public void  AppTaskRun(){
        LOGGER.info("=》AppTaskQuartz定时器-----------run；");
    }
}
