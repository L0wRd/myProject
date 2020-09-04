package com.hxf.redis;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author: hxf
 * @date: 2019/12/4 15:32
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisListTest {

    private static final String KEY = "send:envelope:req";

    @Autowired
    private StringRedisTemplate redisTemplate;

    ExecutorService executorService = null;

//    @Before
    public void init() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        redisTemplate.opsForList().leftPushAll(KEY, list);
        executorService = Executors.newFixedThreadPool(50);
    }

    @Test
    public void test1() {
        System.out.println("**********************测试开始**************************");
        CountDownLatch countDownLatch = new CountDownLatch(50);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(50);
        for (int i = 0; i < 50 ; i++) {
            executorService.execute(() -> {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String res;
                while ((res = redisTemplate.opsForList().rightPop(KEY)) != null) {
//                    List<String> res = redisTemplate.opsForList().range(KEY, 0, 4);
                    System.out.println("当前线程：" + Thread.currentThread().getName() + " 取出数据： " + res);
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("**********************测试结束**************************");
    }

    @Test
    public void test2() {
//        for (int i = 0; i < 10; i++) {
//            JSONObject jsonObject = new JSONObject();
//            try {
//                jsonObject.put("source", "5");
//                jsonObject.put("app", "5");
//                jsonObject.put("channel", "3");
//                jsonObject.put("partnerTradeNo", "121714250" + i);
//                jsonObject.put("openId", "oxscP5UvjbCA6utfy45lC4RCaoYE");
//                jsonObject.put("amount", i);
//            } catch (JSONException e) {
//                e.printStackTrace();
//                redisTemplate.opsForList().leftPush(KEY, jsonObject.toString());
//            }
//        }
        Set<String> nice = redisTemplate.opsForSet().members("nice");
        System.out.println(nice);
//        System.out.println(redisTemplate.opsForValue().increment("haha"));
    }
}
