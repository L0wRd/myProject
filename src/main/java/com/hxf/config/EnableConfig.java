package com.hxf.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: hxf
 * @date: 2019/9/17 10:48
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(MyConfig.class)
public class EnableConfig {
}
