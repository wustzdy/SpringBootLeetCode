package com.wustzdy.spring.boot.leetcode.standard.algorithm.annotation.qualifier;

import org.springframework.stereotype.Service;

@Service("a")
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String getEmployeeById(String id) {
        return "this id EmployeeServiceImpl of service a" + id;
    }
}
