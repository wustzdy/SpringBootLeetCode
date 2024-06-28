package com.wustzdy.spring.boot.leetcode.standard.algorithm.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
public class ProxyController {
    private String targetAddr = "http://127.0.0.1:4000";

    /**
     * 代理所有请求
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/proxy/homeList")
    public void proxy(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {
        System.out.println("1222");
        // String url = URLDecoder.decode(request.getRequestURL().toString(), "UTF-8");
        URI uri = new URI(request.getRequestURI());
        String path = uri.getPath();
        String query = request.getQueryString();
        String target = targetAddr + path.replace("/proxy", "");
        if (query != null && !query.equals("") && !query.equals("null")) {
            target = target + "?" + query;
        }
        URI newUri = new URI(target);
        // 执行代理查询
        String methodName = request.getMethod();
        HttpMethod httpMethod = HttpMethod.resolve(methodName);
        if (httpMethod == null) {
            return;
        }
        ClientHttpRequest delegate = new SimpleClientHttpRequestFactory().createRequest(newUri, httpMethod);
        Enumeration<String> headerNames = request.getHeaderNames();
        // 设置请求头
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> v = request.getHeaders(headerName);
            List<String> arr = new ArrayList<>();
            while (v.hasMoreElements()) {
                arr.add(v.nextElement());
            }
            delegate.getHeaders().addAll(headerName, arr);
        }
        StreamUtils.copy(request.getInputStream(), delegate.getBody());
        // 执行远程调用
        ClientHttpResponse clientHttpResponse = delegate.execute();
        response.setStatus(clientHttpResponse.getStatusCode().value());
        // 设置响应头
        clientHttpResponse.getHeaders().forEach((key, value) -> value.forEach(it -> {
            response.setHeader(key, it);
        }));
        StreamUtils.copy(clientHttpResponse.getBody(), response.getOutputStream());
    }


}
