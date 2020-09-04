package com.hxf.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("@annotation(com.hxf.annotation.CheckMsg) && args(name,..)")
    public void checkPoint(String name) {}

    @Before(value = "checkPoint(name)")
    public void msgCheck(JoinPoint joinPoint, String name) {
        System.out.println(name);
        System.out.println(joinPoint.getArgs());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg.getClass());
        }
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println(signature.getDeclaringTypeName());
    }

    @After(value = "checkPoint(name)")
    public void afterHandler(String name) {
        System.out.println("good bye~~ " + name);
    }
}
