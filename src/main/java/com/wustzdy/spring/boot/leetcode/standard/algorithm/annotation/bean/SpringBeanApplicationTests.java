package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanApplicationTests {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean myBean = (MyBean) context.getBean("myBean");
        String show = myBean.show();
        System.out.println("show:" + show);
    }
}
