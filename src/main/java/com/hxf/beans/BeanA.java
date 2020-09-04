package com.hxf.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: hxf
 * @date: 2019/10/9 15:43
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class BeanA {

    private String name = "test";

    @Autowired
    private BeanB b;

    @Override
    public String toString() {
        return "BeanA(name = " + name + ", b = " + (b == null ? "null" : b.getAge()) + ")";
    }
}
