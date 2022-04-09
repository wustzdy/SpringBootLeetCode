package com.wustzdy.spring.boot.leetcode.standard.algorithm.node;

public class ParamProvider {
    private Param param;
    private String value;

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ParamProvider(Param param, String value) {
        this.param = param;
        this.value = value;
    }

    public ParamProvider() {
    }
}
