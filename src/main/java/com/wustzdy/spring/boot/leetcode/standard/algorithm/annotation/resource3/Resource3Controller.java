package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.resource3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//https://blog.csdn.net/YoErose/article/details/119825679
@RestController
@RequestMapping("resource3/test")
public class Resource3Controller {

    //@Reource 没有指定name的值，所以容器会拿这个p1变量的名字去Bean池子中查找id为resourceService2的bean并装配到这个resourceService2变量中。装配成功
    @Resource
    private Resource3Service resource3Service2;

    //默认 这个byName为resourceService2  去找池子里面id=resourceService2 变量中。装配成功

    @RequestMapping("/test")
    public String resourceTest(@RequestParam("name") String name) {
        return resource3Service2.satHello(name);
    }

}
