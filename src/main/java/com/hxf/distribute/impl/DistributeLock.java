package com.hxf.distribute.impl;

import com.hxf.distribute.AbstractDLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: hxf
 * @date: 2019/10/16 9:57
 * @description:
 */
@Component
public class DistributeLock extends AbstractDLock {

    private RedissonClient redissonClient;

    @Autowired
    public DistributeLock(RedissonClient client) {
        this.redissonClient = client;
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }

    @Override
    protected RLock getLock() {
        return redissonClient.getLock("dlock:test");
    }
}
