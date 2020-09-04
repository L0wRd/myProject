package com.hxf.distribute;

/**
 * @author: hxf
 * @date: 2019/10/16 9:47
 * @description:
 */
public interface DLock {

    void lock();

    void unLock();

    boolean tryLock();

    boolean isLocked();
}
