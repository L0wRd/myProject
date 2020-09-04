package com.hxf.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: hxf
 * @date: 2019/10/9 15:45
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class BeanB {

    private int age = 18;

    @Autowired
    private BeanA a;

    @Override
    public String toString() {
        return "BeanB(age = " + age + ", a = " + (a == null ? "null" : a.getName()) + ")";
    }
}
