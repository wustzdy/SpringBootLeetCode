package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("primary/test")
public class PrimaryController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/test")
    public String resourceTest(@RequestParam("name") String name) {
        return helloService.satHello(name);
    }

}
