package com.james.signature.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 仅AOP调试用
 */
@Aspect
@Component
@Configuration
public class HttpAspect {

    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.james.signature.controller.SignController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore() {
        logger.info("SignController中的方法开始执行");
    }

    @After("log()")
    public void doAfter() {
        logger.info("SignController内某个方法刚结束执行");
    }

}
