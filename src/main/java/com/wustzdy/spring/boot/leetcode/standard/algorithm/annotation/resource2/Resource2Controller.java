package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//https://blog.csdn.net/YoErose/article/details/119825679
@RestController
@RequestMapping("resource/test")
public class Resource2Controller {

    //默认按照byName去匹配，此时name = "123" 去找池子里bean id为123的bean,所以匹配成功
    @Resource(name = "123")
    private ResourceService resourceService;

    @RequestMapping("/test")
    public String resourceTest(@RequestParam("name") String name) {
        return resourceService.satHello(name);
    }

}
