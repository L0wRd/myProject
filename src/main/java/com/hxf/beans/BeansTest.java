package com.hxf.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hxf
 * @date: 2019/10/9 15:48
 * @description:
 */
public class BeansTest {

    public static void main(String[] args) throws Exception {
        System.out.println("=====启动容器======");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        BeanA a = context.getBean(BeanA.class);
        BeanB b = context.getBean(BeanB.class);
        System.out.println(a);
        System.out.println(b);
        System.out.println("=====终止容器======");
    }
}
