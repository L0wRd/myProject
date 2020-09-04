package com.hxf;


import java.util.concurrent.TimeUnit;

/**
 * @author: hxf
 * @date: 2020/5/14 17:09
 * @description:
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread.currentThread().interrupt();
            System.out.println("==========");
            try {
                LockTest.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("响应中断");
            }
        });

        TimeUnit.SECONDS.sleep(3L);
        thread.start();

    }

    public static synchronized void test() throws InterruptedException {
        System.out.println("进入同步方法块。。。");
        LockTest.class.wait();
    }
}
