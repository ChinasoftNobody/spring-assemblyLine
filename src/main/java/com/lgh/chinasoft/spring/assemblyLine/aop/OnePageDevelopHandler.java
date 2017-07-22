package com.lgh.chinasoft.spring.assemblyLine.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/22.
 */
@Component
@Aspect
public class OnePageDevelopHandler {
    @Pointcut("execution(String com.lgh.chinasoft.spring.assemblyLine.controller..*.*(..))")
    public void getRequest(){}

    @Around("getRequest()")
    public String twiceAsOld(ProceedingJoinPoint thisJoinPoint){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes1 = (ServletRequestAttributes) attributes;
        HttpServletRequest request = attributes1.getRequest();
        HttpServletResponse response = attributes1.getResponse();

        try {
            String pathTo = (String) thisJoinPoint.proceed();
            request.setAttribute("pathTo",pathTo);
//            return thing;
        } catch (Throwable e) {
            e.printStackTrace ();
        }
        return "index";
    }
}
