package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("resource/test")
public class ResourceController {
    @Resource
    private UserService userService2;

    @RequestMapping("/test")
    public String resourceTest(@RequestParam("name") String name) {
        return userService2.satHello(name);
    }

}
