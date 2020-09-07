package com.hxf.beans.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: hxf
 * @date: 2019/10/9 15:47
 * @description:
 */
@ComponentScan(value = "com.hxf.beans")
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TestConfig {
}
