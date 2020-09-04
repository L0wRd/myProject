package com.hxf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: hxf
 * @date: 2019/9/17 10:45
 * @Description:
 */
//@Component
//单独使用ConfigurationProperties则无法将该类的实例作为bean加入到ioc容器中，
//需要配合@Component或者@EnableConfigurationProperties使用
@ConfigurationProperties(prefix = "com.hxf")
public class MyConfig {

    private String team;

    private String game;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
