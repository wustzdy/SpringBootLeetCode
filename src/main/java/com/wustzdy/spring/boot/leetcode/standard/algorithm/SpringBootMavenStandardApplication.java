package com.wustzdy.spring.boot.leetcode.standard.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class SpringBootMavenStandardApplication {
    private AtomicInteger number = new AtomicInteger();

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMavenStandardApplication.class, args);
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
