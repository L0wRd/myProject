package com.hxf.service;

import com.hxf.annotation.CheckMsg;
import org.springframework.stereotype.Service;

/**
 * @author: hxf
 * @date: 2019/10/17 14:44
 * @description:
 */
@Service
public class TestService {

    @CheckMsg
    public void print(String nickName, String name, int age) {
        System.out.println("nickName: " + nickName +  " and name: " + name + " and age: " + age);
    }
}
