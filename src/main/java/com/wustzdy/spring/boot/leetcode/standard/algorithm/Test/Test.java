package com.wustzdy.spring.boot.leetcode.standard.algorithm.Test;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "zdy1", 12, "23", false));
        list.add(new Person(2, "zdy2", 13, "24", true));
        list.add(new Person(3, "zdy3", 14, "25", false));
        list.add(new Person(4, "zdy4", 15, "26", true));
        list.forEach(object -> System.out.println(object.toString()));

        System.out.println("---------------------------------");

        List<Person> collection = getList(list);


        collection.forEach(object -> System.out.println(object.toString()));


    }

    private static List<Person> getList(List<Person> list) {
        List<Person> collect = list.stream().map(object -> {
            Person response = new Person();
            BeanUtils.copyProperties(object, response);
            response.setName(getName(object));
            return response;
        }).collect(Collectors.toList());
        return collect;
    }

    private static String getName(Person object) {
        String name = "";
        if ("zdy3".equals(object.getName())) {
            name = "wustzdy";
        }
        return name;
    }
}
