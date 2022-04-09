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

@RestController
@RequestMapping("/test/Qualifier")
public class EmployeeInfoControl {
    @Qualifier("b")
    private EmployeeService employeeService;

    @RequestMapping("/test")
    public String showQualifier(@RequestParam("id") String id) {
        return employeeService.getEmployeeById(id);
    }
}
