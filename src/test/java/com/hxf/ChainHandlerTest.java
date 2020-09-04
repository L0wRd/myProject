package com.hxf;

import java.util.Arrays;
import java.util.List;

/**
 * @author: hxf
 * @date: 2019/10/14 16:31
 * @description:
 */
public class ChainHandlerTest {

    static class ClientA extends ChainHandler {
        @Override
        protected void requestProcess() {
            System.out.println("request handled by ClientA");
        }
    }

    static class ClientB extends ChainHandler {
        @Override
        protected void requestProcess() {
            System.out.println("request handled by ClientB");
        }
    }

    static class ClientC extends ChainHandler {
        @Override
        protected void requestProcess() {
            System.out.println("request handled by ClientC");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> list = Arrays.asList(new ClientA(), new ClientB(), new ClientC());
        Chain chain = new Chain(list);
        chain.proceed();
    }
}
