package com.hxf;

/**
 * @author: hxf
 * @date: 2019/10/14 16:26
 * @description:
 */
public abstract class ChainHandler {

    protected abstract void requestProcess();

    public void execute(Chain chain) {
//        requestProcess();
//        chain.proceed();

        try {
            chain.proceed();
        } finally {
            requestProcess();
        }
    }
}
