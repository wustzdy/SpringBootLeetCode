package com.wustzdy.spring.boot.leetcode.standard.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
public class SpringBootMavenStandardApplication {
    private AtomicInteger number = new AtomicInteger();

    public static void main(String[] args) {
        log.info("spring boot开始启动...");
        ApplicationContext ctx = SpringApplication.run(SpringBootMavenStandardApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            log.info("当前环境为:" + profile);
        }
        log.info("spring boot启动成功...");
    }

    //    @Scheduled(fixedDelay = 120000)
    public void job() {
        try {
            System.out.println("当前时间：" + new Date().toString());
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
