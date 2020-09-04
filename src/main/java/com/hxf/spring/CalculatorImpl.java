package com.hxf.spring;

import org.springframework.stereotype.Component;

/**
 * @author: hxf
 * @date: 2019/9/23 17:37
 * @description:
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}
