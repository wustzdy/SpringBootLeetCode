package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.qualifier;

import org.springframework.stereotype.Service;

@Service("b")
public class EmployeeServiceImpl2 implements EmployeeService {
    @Override
    public String getEmployeeById(String id) {
        return "this id EmployeeServiceImpl2 of service b" + id;
    }
}
