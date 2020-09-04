package com.hxf;

import com.hxf.distribute.impl.DistributeLock;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author: hxf
 * @date: 2019/10/16 14:30
 * @description:
 */
public class DLockTest {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("123456");
        RedissonClient client = Redisson.create(config);
        DistributeLock dLock = new DistributeLock(client);
        TimeUnit.SECONDS.sleep(10);
        for (int i = 0; i < 5; i++) {
            new Thread(new Print(dLock), "thread-" + i).start();
        }
    }

    static class Print implements Runnable {

        private DistributeLock dLock;

        Print(DistributeLock lock) {
            this.dLock = lock;
        }

        @Override
        public void run() {
            try {
                dLock.lock();
                for (int i = 0; i < 3; i++) {
                    System.err.println("####" + Thread.currentThread().getName() + " print: " + i + "####");
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dLock.unLock();
            }
        }
    }
}
