package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource/test")
public class ResourceController {
    @Autowired
    @Qualifier("HelloService1")
    private HelloService helloService;

    @RequestMapping("/test")
    public String resourceTest(@RequestParam("name") String name) {
        return helloService.satHello(name);
    }

}
