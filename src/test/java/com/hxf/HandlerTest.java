package com.hxf;

/**
 * @author: hxf
 * @date: 2019/10/14 16:16
 * @description:
 */
public class HandlerTest {

    static class ClientA extends Handler {
        @Override
        protected void requestProcess() {
            System.out.println("request handled by ClientA");
        }
    }

    static class ClientB extends Handler {
        @Override
        protected void requestProcess() {
            System.out.println("request handled by ClientB");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new ClientA();
        Handler handlerB = new ClientB();
        handlerA.setSucessor(handlerB);
        handlerA.execute();
    }

}
