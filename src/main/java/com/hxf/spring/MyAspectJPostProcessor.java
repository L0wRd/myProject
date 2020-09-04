package com.hxf.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author: hxf
 * @date: 2019/9/23 17:38
 * @description:
 */
@Component
public class MyAspectJPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==========" + beanName + "=============");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final Object obj = bean;
        if (bean instanceof Calculator) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("-----------开始计算---------------");
                        Object result = method.invoke(obj, args);
                        System.out.println("-----------结束计算---------------");
                        return result;
            });
        }
        return bean;
    }
}
