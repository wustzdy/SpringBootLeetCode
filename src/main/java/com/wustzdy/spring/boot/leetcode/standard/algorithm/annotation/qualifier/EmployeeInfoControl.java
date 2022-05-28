package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
Spring的注解@Qualifier注解
@Qualifier注解了，qualifier的意思是合格者，通过这个标示，表明了哪个实现类才是我们所需要的，
        我们修改调用代码，添加@Qualifier注解，需要注意的是@Qualifier的参数名称必须为我们之前定义@Service注解的名称之一！   例子：
*/

/*Spring中@Primary注解的使用
在spring 中使用注解，常使用@Autowired， 默认是根据类型Type来自动注入的。但有些特殊情况，对同一个接口，可能会有几种不同的实现类，而默认只会采取其中一种的情况下 @Primary  的作用就出来了。下面是个简单的使用例子。
        spring 根据类型无法选择到底注入哪一个。这个时候@Primay 可以闪亮登场了。*/

@RestController
@RequestMapping("/test/Qualifier")
public class EmployeeInfoControl {
    @Qualifier("b")
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/test")
    public String showQualifier(@RequestParam("id") String id) {
        return employeeService.getEmployeeById(id);
    }
}
