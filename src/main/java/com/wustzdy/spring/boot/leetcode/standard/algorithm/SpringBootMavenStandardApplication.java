package com.wustzdy.spring.boot.leetcode.standard.algorithm;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
public class SpringBootMavenStandardApplication {
    private AtomicInteger number = new AtomicInteger();

    @Value("${message.core.resource.webhookJsonFile.:classpath:/webhook.json}")
    private String webhookJsonFile;

    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ObjectMapper objectMapper;

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

    @PostConstruct
    public void test111() {
        Resource resource = resourceLoader.getResource(webhookJsonFile);
        try {
            List<Map<String, Object>> webhook =
                    objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, Object>>>() {
                    });
            String alertRuleTemp = "{\n" + "  \"version\":\"4\",\n" + "  \"groupKey\":\"{}:{alertname=\\\"test\\\", severity=\\\"major\\\"}\",\n" + "  \"receiver\":\"webhook\",\n" + "  \"status\":\"firing\",\n" + "  \"alerts\":[\n" + "    {\n" + "      \"status\":\"firing\",\n" + "      \"labels\":{\n" + "        \"alertgroup\":\"node\",\n" + "        \"alertname\":\"test\",\n" + "        \"instance\":9100,\n" + "        \"severity\":\"major\"\n" + "      },\n" + "      \"annotations\":{\n" + "        \"description\":\"cpu overload for 15 min 0.05815972222266652\",\n" + "        \"value\":\"0.05815972222266652\"\n" + "      },\n" + "      \"startsAt\":\"2023-05-24T11:56:07.221664103Z\",\n" + "      \"endsAt\":\"0001-01-01T00:00:00Z\",\n" + "      \"generatorURL\":\"http://vmalert-spe-85b79459fc-xm7p5:8080/api/v1/1013612175511790069/6151226998575564619/status\",\n" + "      \"fingerprint\":\"e993a4c769190a02\"\n" + "    }\n" + "  ],\n" + "  \"groupLabels\":{\n" + "    \"alertname\":\"test\",\n" + "    \"severity\":\"major\"\n" + "  },\n" + "  \"commonLabels\":{\n" + "    \"alertgroup\":\"node\",\n" + "    \"alertname\":\"test\",\n" + "    \"instance\":9100,\n" + "    \"severity\":\"major\"\n" + "  },\n" + "  \"commonAnnotations\":{\n" + "    \"description\":\"cpu overload for 15 min 0.05815972222266652\",\n" + "    \"value\":\"0.05815972222266652\"\n" + "  },\n" + "  \"externalURL\":\"http://vmalertmanager-spe-0:9093\",\n" + "  \"alertTime\":\"2023-05-24T12:00:37.231904746Z\"\n" + "}";

          /*  log.info("---webhook---:{}",objectMapper.writeValueAsString(webhook));
            for (Map<String, Object> operator : webhook) {

            }*/
        } catch (Exception e) {
            log.error("alert rule request is error:{}", e);
            throw new RuntimeException(e.getMessage());
        }
        log.info("---getMonitorWarningData--end--");
    }

}
