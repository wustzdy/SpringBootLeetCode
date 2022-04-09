package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("resource2/test")
public class ResourceController {
    @Resource(name = "userService2")//@Resource(type = UserService2.class)一回事
    private UserService userService;

    @RequestMapping("/test")
    public String resourceTest(@RequestParam("name") String name) {
        return userService.satHello(name);
    }

}
