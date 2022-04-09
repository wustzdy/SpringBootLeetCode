package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/Qualifier")
public class EmployeeInfoControl {
    @Autowired
    @Qualifier("b")
    private EmployeeService employeeService;

    @RequestMapping("/test")
    public String showQualifier(@RequestParam("id") String id) {
        return employeeService.getEmployeeById(id);
    }
}
