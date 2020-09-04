package com.hxf;

import com.hxf.config.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: hxf
 * @date: 2019/9/17 10:43
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertiesTest {

    @Autowired
    private MyConfig myConfig;

    @Test
    public void test() {
        System.out.println(myConfig.getGame());
        System.out.println(myConfig.getTeam());
    }
}
