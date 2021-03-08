package com.wustzdy.spring.boot.leetcode.standard.algorithm.Test;

public class Person {
    private int id;
    private String name;
    private int age;
    private String high;
    private Boolean status;

    public Person() {
    }


    public Person(int id, String name, int age, String high, Boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.high = high;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", high='" + high + '\'' +
                ", status=" + status +
                '}';
    }
}
