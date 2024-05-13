package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.dynamic;

//BM83 字符串变形
//输入："This is a sample",16
//返回值："SAMPLE A IS tHIS"
//小写变大写  大写变小写 反转
public class trans {
    public static void main(String[] args) {
        String thisIsASample = trans("This is a sample", 16);
        System.out.println("thisIsASample:" + thisIsASample);
    }

    public static String trans(String s, int n) {
        String res = "";
        String tempStr = "";
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                tempStr += Character.toUpperCase(c);
            else if (c >= 'A' && c <= 'Z')
                tempStr += Character.toLowerCase(c);
            else {
                tempStr = c + tempStr;
                res = tempStr + res;
                tempStr = "";
            }
        }
        res = tempStr + res;
        return res;
    }
    public static String trans1(String s, int n) {
        StringBuilder res = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                tempStr.append(Character.toUpperCase(c));
            else if (c >= 'A' && c <= 'Z')
                tempStr.append(Character.toLowerCase(c));
            else {
                res.insert(0, tempStr).insert(0, c);
                tempStr = new StringBuilder();
            }
        }
        return tempStr.append(res).toString();
    }
}
