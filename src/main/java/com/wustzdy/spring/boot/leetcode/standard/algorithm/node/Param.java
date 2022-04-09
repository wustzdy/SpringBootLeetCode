package com.wustzdy.spring.boot.leetcode.standard.algorithm.node;

public enum Param {
    NODE("node"),
    GROUP("group"),
    INSTANCE("instance"),
    CLUSTER("cluster"),
    ALERTNAME("alertname"),
    POOL("pool");

    Param(String valueName) {
        this.valueName = valueName;
        this.placeHolder = "${" + valueName + "}";
    }

    private String placeHolder;

    private String valueName;

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public String getValueName() {
        return this.valueName;
    }
}
