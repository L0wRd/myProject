package com.hxf.beans.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: hxf
 * @date: 2019/10/17 14:30
 * @description:
 */
@Component
@Slf4j
@Aspect
public class MyAspect {

    @Pointcut("@annotation(com.hxf.beans.annotation.CheckMsg) && args(name,..)")
    public void checkPoint(String name) {}

    @Before(value = "checkPoint(name)")
    public void msgCheck(JoinPoint joinPoint, String name) {
        System.out.println("MyAspect beforeHandler....");
//        System.out.println(joinPoint.getArgs());
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            System.out.println(arg.getClass());
//        }
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
//        Signature signature = joinPoint.getSignature();
//        System.out.println(signature.getName());
//        System.out.println(signature.getDeclaringTypeName());
    }

    @After(value = "checkPoint(name)")
    public void afterHandler(String name) {
        System.out.println("MyAspect afterHandler....");
    }

    @AfterReturning(value = "checkPoint(name)", returning = "result")
    public void afterReturnHandler(JoinPoint joinPoint, String name, String result) {
        System.out.println("MyAspect afterReturnHandler.... result: " + result);

    }

    @AfterThrowing(value = "checkPoint(name)", throwing="e")
    public void afterThrowingHandler(JoinPoint joinPoint, String name, Throwable e) {
        System.out.println("MyAspect afterThrowingHandler....");
        System.out.println(e.getMessage());
        e.printStackTrace();
    }

    @Around(value = "checkPoint(name)")
    public String aroundHandler(ProceedingJoinPoint joinPoint, String name) throws Throwable {
        System.out.println("MyAspect aroundHandler before....");
        Object proceed = joinPoint.proceed(new Object[]{name, joinPoint.getArgs()[1]});
        System.out.println("MyAspect aroundHandler after....");
        return (String) proceed;
    }
}
