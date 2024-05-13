package com.wustzdy.spring.boot.leetcode.standard.algorithm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class redirect {
    @RequestMapping("alipayforward")
    public ModelAndView alipayforward() throws Exception {
        System.out.println("--------测试redirect-------");

        String url = "redirect:https://10.142.94.200/?accessToken=eyJhbGciOiJIUzUxMiJ9.eyJhY2NvdW50IjoibGh6XzAwMDJfZGV2Iiwicm9sZUxpc3QiOiJHQUlYQ19ERVZFTE9QRVJfUk9MRSIsInVzZXJJZCI6IjcwNzg2REU3OUNCNDQ5MjQ5NzQzQUY2NzIwRjZGOTkyIiwiZW1wbG95ZWVJZCI6Ijk1RUY0RkUyRTVFMDQwNTc4RjYyNTYyMTZFMTdEMUYzIiwiZW1wbG95ZWVOYW1lIjoiXHU1MjE4XHU3ZWEyXHU2NTNmIiwib3JnSWQiOiIwIiwib3JnQ29kZSI6IjAxIiwib3JnTmFtZSI6Ilx1NjAzYlx1NTE2Y1x1NTNmOCIsInRoaXJkU3lzdGVtTmFtZSI6IkdBSVhDIiwic3lzdGVtTmFtZSI6IkdBSVhDIiwiZXhwIjoxNjc5MzczNjIxLCJyZWZyZXNoRGF0ZSI6MTY3OTM2NjQyMTg3MiwianRpIjoiOTNjZDUzMTQtM2RiYy00ZDgxLThhOWMtYWUzMDBlMGUzNzBlIiwicmVmcmVzaEludGVydmFsIjoxMjAsInN1YiI6Ilx1NjUyZlx1ODJiM1x1OWY5OSIsInRoaXJkQ2VydCI6IjRBIn0&redirect=https://10.142.94.200/notebook/namespace/spew-8rqy4dgtmdnjldk/jupyterlab/zytest1019/lab";

//        String result = "redirect:https//baidu.com";
        String result = "redirect:https://10.142.94.200/os-console/#/acc";
        return new ModelAndView(result);

    }

    @RequestMapping("test1111")
    public void test1111(HttpServletResponse response, HttpServletRequest request) throws Exception {
        response.sendRedirect("error");
//        response.sendRedirect("https://10.142.94.200/os-console/#/acc");
//        return "redirect:https://10.142.94.200/os-console/#/acc";
//        request.getRequestDispatcher("https://blog.csdn.net/gs6666666/article/details/127241949").forward(request, response);
    }
}
