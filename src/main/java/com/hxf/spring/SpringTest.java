package com.hxf.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: hxf
 * @date: 2019/9/23 17:45
 * @description:
 */
public class SpringTest {

    public static void main(String[] args) {
        System.out.println("启动spring容器");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("======================================================");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        System.out.println(calculator.getClass().getName());
        calculator.add(1, 2);
    }
}
