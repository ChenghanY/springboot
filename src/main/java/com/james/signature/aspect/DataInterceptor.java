package com.james.signature.aspect;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class DataInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        ServletInputStream inputStream = request.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        IOUtils.copy(inputStream, byteArrayOutputStream);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        String body = new String(bytes, Charset.forName("UTF-8"));

        System.out.println("=======================" + body);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}