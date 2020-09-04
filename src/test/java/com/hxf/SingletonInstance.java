package com.hxf;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: hxf
 * @date: 2020/4/30 15:58
 * @description:
 */
public class SingletonInstance {

    private Integer m = 5;

    private String str = "hxf";

    private boolean res = true;

    private static SingletonInstance instance;

    private SingletonInstance() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(20L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public Integer getM() {
        return m;
    }

    public String getStr() {
        return str;
    }

    public boolean isRes() {
        return res;
    }

    public static SingletonInstance newInstance() {
        if (instance == null) {
            synchronized (SingletonInstance.class) {
                if (instance == null) {
                    try {
                        TimeUnit.SECONDS.sleep(3L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingletonInstance();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        int times = 20;
        CountDownLatch latch = new CountDownLatch(times);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < times; i++) {
//            Future<Integer> submit = executorService.submit(() -> {
//                try {
//                    latch.await();
//                    Integer m = SingletonInstance.newInstance().getM();
//                    System.out.println(m);
//                    return SingletonInstance.newInstance().getM();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            });
//            System.out.println(submit.get());
            new Thread(() -> {
                try {
                    latch.await();
                    SingletonInstance singletonInstance = SingletonInstance.newInstance();
                    System.out.println(singletonInstance + " == " + singletonInstance.getStr());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("=================");
        for (int i = 0; i < times; i++) {
            latch.countDown();
        }
    }
}
