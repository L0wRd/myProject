package com.hxf.beans.service;

import com.hxf.beans.annotation.CheckMsg;
import org.springframework.stereotype.Service;

/**
 * @author: hxf
 * @date: 2019/10/17 14:44
 * @description:
 */
@Service
public class TestService {

    @CheckMsg
    public String print(String name, int age) {
        System.out.println("target method run....");
        int a = 10 / age;
        return name + " " + age;
    }
}
