package com.hxf;

import com.hxf.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: hxf
 * @date: 2019/10/17 14:47
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AspectTest {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.print("Dk", "hxf", 26);
    }
}
