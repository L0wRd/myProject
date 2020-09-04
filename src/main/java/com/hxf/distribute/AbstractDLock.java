package com.hxf.distribute;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author: hxf
 * @date: 2019/10/16 9:49
 * @description:
 */
public abstract class AbstractDLock implements DLock {

    protected abstract RLock getLock();

    @Override
    public void lock() {
        getLock().lock(1, TimeUnit.MINUTES);
    }

    @Override
    public boolean tryLock() {
        return getLock().tryLock();
    }

    @Override
    public void unLock() {
        getLock().unlock();
    }

    @Override
    public boolean isLocked() {
        return getLock().isLocked();
    }
}
